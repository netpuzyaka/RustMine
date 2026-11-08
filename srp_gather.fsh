#version 330

// Rustmine SRP, pass 1 (before translucent geometry, so only opaque surfaces are in depth), per pixel:
//   R = sun visibility: the sun's shadow map (monuments, buildings, deployables) and a screen-space ray for what
//       the map doesn't hold (players, animals, vehicles, small details)
//   G = ambient occlusion
//   BA = linear depth (16 bit) for the bilateral filter in the light pass

uniform sampler2D DepthSampler;
uniform sampler2D ShadowSampler;
uniform sampler2D ShadowOldSampler;

layout(std140) uniform SrpData {
    mat4 InvProj;
    mat4 Proj;
    vec4 SunView;      // xyz: direction to the sun in view space, w: sun strength (day, weather)
    vec4 SunColor;     // rgb, w: shadow strength
    vec4 ShadowTint;   // rgb, w: AO strength
    vec4 Screen;       // xy: full size, zw: gather size
    vec4 Misc;         // x: time, y: tier, z: screen-space ray length (blocks), w: overcast
    vec4 Fx;           // x: bloom, y: vignette, z: grade, w: fxaa
    vec4 Cfg;          // x: screen-space ray steps, y: AO samples, z: debug, w: shadow map filter taps (up to 12)
    vec4 Cam1;         // xyz: fract(camera)
    mat4 InvView;      // view space to world space (rotation)
    mat4 ShadowVP;     // shadow map: anchor-relative world position to light clip space
    vec4 ShadowParams; // x: texel size (blocks), y: map size, z: filter radius (texels), w: 1 when the map is on
    vec4 ShadowAnchor; // xyz: floor(camera) minus the anchor the map was drawn around
    mat4 PrevViewProj; // TAA: previous frame, camera-relative world position (previous camera) to clip, unjittered
    vec4 Taa;          // xy: this frame's jitter (NDC), z: 1 when the history is usable, w: frame index (0 without TAA)
    vec4 CamDelta;     // xyz: camera position minus the previous frame's, w: 1 when TAA is on
    mat4 ShadowVPOld;  // the older shadow map (the newest fades in over it)
    vec4 ShadowOld;    // xyz: floor(camera) minus the older map's anchor, w: fade (1 = newest only)
    vec4 Fires[24];    // fires near the camera: (position relative to floor(camera), range), (colour, flicker), (spot direction, cos half angle or -2); count in Cam1.w
    mat4 FireFaces[24]; // per shadowed fire and cube face: world position relative to floor(camera) -> fire shadow atlas clip
    vec4 FireShadow;   // x: fires with a shadow map, y: tile size, zw: atlas size
    vec4 Carry;        // x: first carried light (torch, flashlight, lamp hats), y: block light the lightmap is raised to (0: not), z: sky light at the camera
};

in vec2 texCoord;
out vec4 fragColor;

float ign(vec2 p) {
    return fract(52.9829189 * fract(dot(p, vec2(0.06711056, 0.00583715))));
}

vec3 viewPos(vec2 uv, float d) {
    vec4 p = InvProj * vec4(uv * 2.0 - 1.0, d * 2.0 - 1.0, 1.0);
    return p.xyz / p.w;
}

float fetchDepth(ivec2 px) {
    ivec2 sz = textureSize(DepthSampler, 0);
    return texelFetch(DepthSampler, clamp(px, ivec2(0), sz - 1), 0).r;
}

// Normal from the neighbour on the same surface (no stretching across silhouettes)
vec3 normalAt(ivec2 px, vec2 invSize, vec3 P) {
    vec3 r = viewPos((vec2(px) + vec2(1.5, 0.5)) * invSize, fetchDepth(px + ivec2(1, 0)));
    vec3 l = viewPos((vec2(px) + vec2(-0.5, 0.5)) * invSize, fetchDepth(px + ivec2(-1, 0)));
    vec3 u = viewPos((vec2(px) + vec2(0.5, 1.5)) * invSize, fetchDepth(px + ivec2(0, 1)));
    vec3 d = viewPos((vec2(px) + vec2(0.5, -0.5)) * invSize, fetchDepth(px + ivec2(0, -1)));
    vec3 dx = abs(r.z - P.z) < abs(l.z - P.z) ? r - P : P - l;
    vec3 dy = abs(u.z - P.z) < abs(d.z - P.z) ? u - P : P - d;
    vec3 n = normalize(cross(dx, dy));
    return dot(n, P) > 0.0 ? -n : n;
}

const vec2 POISSON[12] = vec2[](
    vec2(-0.326, -0.406), vec2(-0.840, -0.074), vec2(-0.696, 0.457), vec2(-0.203, 0.621),
    vec2(0.962, -0.195), vec2(0.473, -0.480), vec2(0.519, 0.767), vec2(0.185, -0.893),
    vec2(0.507, 0.064), vec2(0.896, 0.412), vec2(-0.322, -0.933), vec2(-0.792, -0.598));

// One shadow map (its light transform and anchor), filtered with a rotated Poisson disc; coverage fades to 0 towards
// the map's edge, and outside it the sun is unknown: lit
float sampleMap(sampler2D map, mat4 vp, vec3 anchor, vec3 rel, vec3 Nw, float ndl, float jitter) {
    float texel = ShadowParams.x;
    vec3 p = rel + anchor + Nw * texel * (1.5 + 2.0 * (1.0 - ndl)); // normal offset: no acne on slopes
    vec4 c = vp * vec4(p, 1.0);
    vec3 s = c.xyz / c.w * 0.5 + 0.5;
    vec2 edge = abs(s.xy - 0.5) * 2.0;
    float coverage = 1.0 - smoothstep(0.82, 0.97, max(edge.x, edge.y));
    if (coverage <= 0.0 || s.z >= 1.0) return 1.0;
    float radius = ShadowParams.z / ShadowParams.y;
    float a = jitter * 6.2831853;
    mat2 rot = mat2(cos(a), sin(a), -sin(a), cos(a));
    float lit = 0.0;
    int taps = int(Cfg.w);
    for (int i = 0; i < taps; i++) {
        float d = texture(map, s.xy + rot * POISSON[i] * radius).r;
        lit += s.z - 0.00004 <= d ? 1.0 : 0.0;
    }
    return mix(1.0, lit / float(taps), coverage);
}

// The sun's shadow: the newest map, faded in over the older one while the sun steps on (no jumps)
float mapShadow(vec3 rel, vec3 Nw, float ndl, float jitter) {
    if (ShadowParams.w < 0.5) return 1.0;
    float fresh = sampleMap(ShadowSampler, ShadowVP, ShadowAnchor.xyz, rel, Nw, ndl, jitter);
    float fade = ShadowOld.w;
    if (fade >= 1.0) return fresh;
    float old = sampleMap(ShadowOldSampler, ShadowVPOld, ShadowOld.xyz, rel, Nw, ndl, jitter);
    return mix(old, fresh, fade * fade * (3.0 - 2.0 * fade));
}

// Screen-space ray towards the sun: shadows of what the map doesn't hold (players, animals, vehicles, details).
// Nothing within NEAR_IGNORE blocks of the camera casts: only the own hands and held things are ever that close.
const float NEAR_IGNORE = 1.3;
float screenShadow(vec3 P, vec3 N, float jitter) {
    vec3 L = SunView.xyz;
    vec3 start = P + N * (0.02 + 0.002 * -P.z);
    vec3 end = start + L * Misc.z;
    if (end.z > -0.12) end = start + (end - start) * clamp((-0.12 - start.z) / (end.z - start.z), 0.0, 1.0);
    int steps = int(Cfg.x);
    for (int i = 0; i < steps; i++) {
        float t = (float(i) + jitter) / float(steps);
        t *= t;
        vec3 S = start + (end - start) * t;
        vec4 c = Proj * vec4(S, 1.0);
        if (c.w <= 0.0) break;
        vec2 uv = c.xy / c.w * 0.5 + 0.5;
        if (uv.x <= 0.0 || uv.y <= 0.0 || uv.x >= 1.0 || uv.y >= 1.0) break;
        float sd = texture(DepthSampler, uv).r;
        if (sd >= 0.99999) continue;
        float sz = viewPos(uv, sd).z; // the full position: Rust camera animations turn the projection, so depth alone is not z
        if (sz > -NEAR_IGNORE) continue;
        float diff = sz - S.z;
        if (diff > 0.02 + 0.004 * -S.z && diff < 0.35 + 0.025 * -S.z) return 0.25 * t; // softer the farther it reaches
    }
    return 1.0;
}

// The depth buffer's step grows with the square of the distance (z^2 / near * 2^-24, near 0.05: 0.3 m at 500 m), and a
// step between two pixels of one smooth surface must not count as something in the way (the far ground would show a
// dark ripple). Four steps' worth: nothing changes up close, and AO fades out by itself past the point where its radius
// is lost in them.
const float DEPTH_STEP_BIAS = 4.0 * 5.96e-8 / 0.05;

float ambientOcclusion(vec3 P, vec3 N, vec2 uv, float jitter) {
    int n = int(Cfg.y);
    float bias = 0.03 + DEPTH_STEP_BIAS * P.z * P.z;
    float radius = clamp(0.6 + 0.012 * -P.z, 0.6, 1.6);
    vec2 scale = vec2(Proj[0][0], Proj[1][1]) * 0.5 / max(-P.z, 0.1);
    float ang = jitter * 6.2831853;
    float sum = 0.0;
    for (int i = 0; i < n; i++) {
        float f = (float(i) + 0.5) / float(n);
        float a = ang + float(i) * 2.3999632;
        vec2 suv = uv + vec2(cos(a), sin(a)) * (f * radius) * scale;
        if (suv.x <= 0.0 || suv.y <= 0.0 || suv.x >= 1.0 || suv.y >= 1.0) continue;
        float sd = texture(DepthSampler, suv).r;
        if (sd >= 0.99999) continue;
        vec3 S = viewPos(suv, sd);
        if (S.z > -NEAR_IGNORE) continue;
        vec3 v = S - P;
        float len2 = dot(v, v);
        if (len2 > radius * radius * 1.4) continue;
        float rangeCheck = smoothstep(0.0, 1.0, radius / max(abs(P.z - S.z), 1e-3));
        sum += max(dot(N, v) - bias, 0.0) / (len2 + 0.02) * rangeCheck;
    }
    return clamp(1.0 - sum / float(n) * radius * 1.3, 0.0, 1.0);
}

void main() {
    ivec2 gp = ivec2(gl_FragCoord.xy);
    vec2 uv = (vec2(gp) + 0.5) / Screen.zw;
    ivec2 fullPx = ivec2(uv * Screen.xy);
    float d = fetchDepth(fullPx);
    if (d >= 0.99999) {
        fragColor = vec4(1.0);
        return;
    }
    vec2 invFull = 1.0 / Screen.xy;
    vec2 fuv = (vec2(fullPx) + 0.5) * invFull;
    vec3 P = viewPos(fuv, d);
    vec3 N = normalAt(fullPx, invFull, P);
    float jitter = ign(gl_FragCoord.xy + Taa.w * 7.123); // with TAA the noise turns every frame and averages out

    float vis = 1.0;
    float ndl = dot(N, SunView.xyz);
    if (SunView.w > 0.01 && ndl > -0.2) {
        vec3 rel = Cam1.xyz + (InvView * vec4(P, 0.0)).xyz; // world position relative to floor(camera)
        vec3 Nw = (InvView * vec4(N, 0.0)).xyz;
        float m = mapShadow(rel, Nw, clamp(ndl, 0.0, 1.0), jitter);
        float screen = screenShadow(P, N, jitter);
        vis = min(m, screen);
        // /srp debug 5, 6: one source at a time (shadow map, screen-space ray)
        int debug = int(Cfg.z);
        if (debug == 5) vis = m;
        else if (debug == 6) vis = screen;
    }
    float ao = ambientOcclusion(P, N, fuv, ign(gl_FragCoord.xy + 17.0));

    float lin = clamp(-P.z / 1024.0, 0.0, 1.0);
    float hi = floor(lin * 255.0) / 255.0;
    float lo = fract(lin * 255.0);
    fragColor = vec4(vis, ao, hi, lo);
}

#version 330

// Rustmine SRP, temporal anti-aliasing (after the whole world, before the grade): every frame is rendered with a
// sub-pixel jitter; the last result is reprojected through depth and the camera, clipped to what this frame's pixel
// neighbourhood allows (no ghosting), and blended in. Thin wires, lattice towers, fences and leaf edges resolve over
// a few frames instead of crawling.

uniform sampler2D CurrentSampler;
uniform sampler2D DepthSampler;
uniform sampler2D HistorySampler;

layout(std140) uniform SrpData {
    mat4 InvProj;
    mat4 Proj;
    vec4 SunView;
    vec4 SunColor;
    vec4 ShadowTint;
    vec4 Screen;
    vec4 Misc;
    vec4 Fx;
    vec4 Cfg;
    vec4 Cam1;
    mat4 InvView;
    mat4 ShadowVP;
    vec4 ShadowParams;
    vec4 ShadowAnchor;
    mat4 PrevViewProj;
    vec4 Taa;
    vec4 CamDelta;
    mat4 ShadowVPOld;  // the older shadow map (the newest fades in over it)
    vec4 ShadowOld;    // xyz: floor(camera) minus the older map's anchor, w: fade (1 = newest only)
    vec4 Fires[24];    // fires near the camera: (position relative to floor(camera), range), (colour, flicker), (spot direction, cos half angle or -2); count in Cam1.w
    mat4 FireFaces[24]; // per shadowed fire and cube face: world position relative to floor(camera) -> fire shadow atlas clip
    vec4 FireShadow;   // x: fires with a shadow map, y: tile size, zw: atlas size
    vec4 Carry;        // x: first carried light (torch, flashlight, lamp hats), y: block light the lightmap is raised to (0: not), z: sky light at the camera
};

in vec2 texCoord;
out vec4 fragColor;

vec3 toYCoCg(vec3 c) {
    return vec3(dot(c, vec3(0.25, 0.5, 0.25)), dot(c, vec3(0.5, 0.0, -0.5)), dot(c, vec3(-0.25, 0.5, -0.25)));
}

vec3 toRgb(vec3 c) {
    return vec3(c.x + c.y - c.z, c.x + c.z, c.x - c.y - c.z);
}

vec3 fetch(ivec2 p) {
    return texelFetch(CurrentSampler, clamp(p, ivec2(0), ivec2(Screen.xy) - 1), 0).rgb;
}

// History through a 5-tap Catmull-Rom: bilinear history blurs a little more every frame
vec3 history(vec2 uv) {
    vec2 size = Screen.xy;
    vec2 pos = uv * size;
    vec2 c = floor(pos - 0.5) + 0.5;
    vec2 f = pos - c;
    vec2 w0 = f * (-0.5 + f * (1.0 - 0.5 * f));
    vec2 w1 = 1.0 + f * f * (-2.5 + 1.5 * f);
    vec2 w2 = f * (0.5 + f * (2.0 - 1.5 * f));
    vec2 w3 = f * f * (-0.5 + 0.5 * f);
    vec2 w12 = w1 + w2;
    vec2 t0 = (c - 1.0) / size, t3 = (c + 2.0) / size, t12 = (c + w2 / w12) / size;
    vec3 r = texture(HistorySampler, vec2(t12.x, t0.y)).rgb * (w12.x * w0.y)
        + texture(HistorySampler, vec2(t0.x, t12.y)).rgb * (w0.x * w12.y)
        + texture(HistorySampler, vec2(t12.x, t12.y)).rgb * (w12.x * w12.y)
        + texture(HistorySampler, vec2(t3.x, t12.y)).rgb * (w3.x * w12.y)
        + texture(HistorySampler, vec2(t12.x, t3.y)).rgb * (w12.x * w3.y);
    float wsum = w12.x * w0.y + w0.x * w12.y + w12.x * w12.y + w3.x * w12.y + w12.x * w3.y;
    return max(r / wsum, 0.0);
}

// Pull the history towards the neighbourhood's box (a clip towards its centre, not a hard clamp per channel)
vec3 clipToBox(vec3 h, vec3 lo, vec3 hi) {
    vec3 center = 0.5 * (hi + lo);
    vec3 ext = 0.5 * (hi - lo) + 1e-4;
    vec3 v = h - center;
    vec3 a = abs(v / ext);
    float m = max(a.x, max(a.y, a.z));
    return m > 1.0 ? center + v / m : h;
}

void main() {
    ivec2 px = ivec2(gl_FragCoord.xy);
    vec2 inv = 1.0 / Screen.xy;
    vec2 uv = (vec2(px) + 0.5) * inv;
    vec3 cur = fetch(px);

    // neighbourhood statistics (YCoCg), and the nearest depth around: edges reproject with what is in front
    vec3 m1 = vec3(0.0), m2 = vec3(0.0), lo = vec3(1e9), hi = vec3(-1e9);
    float nearest = 1.0;
    ivec2 nearestPx = px;
    for (int y = -1; y <= 1; y++) {
        for (int x = -1; x <= 1; x++) {
            ivec2 p = px + ivec2(x, y);
            vec3 c = toYCoCg(fetch(p));
            m1 += c;
            m2 += c * c;
            lo = min(lo, c);
            hi = max(hi, c);
            float d = texelFetch(DepthSampler, clamp(p, ivec2(0), ivec2(Screen.xy) - 1), 0).r;
            if (d < nearest) {
                nearest = d;
                nearestPx = p;
            }
        }
    }
    if (Taa.z < 0.5) {
        fragColor = vec4(cur, 1.0);
        return;
    }

    // where this pixel was last frame
    vec2 nuv = (vec2(nearestPx) + 0.5) * inv;
    vec4 v = InvProj * vec4(nuv * 2.0 - 1.0, nearest * 2.0 - 1.0, 1.0);
    vec3 world = (InvView * vec4(v.xyz / v.w, 0.0)).xyz + CamDelta.xyz;
    vec4 prev = PrevViewProj * vec4(world, 1.0);
    vec2 puv = prev.xy / prev.w * 0.5 + 0.5 + (uv - nuv);
    if (prev.w <= 0.0 || puv.x <= 0.0 || puv.y <= 0.0 || puv.x >= 1.0 || puv.y >= 1.0) {
        fragColor = vec4(cur, 1.0);
        return;
    }

    // variance box, tightened by the min/max box
    vec3 mu = m1 / 9.0;
    vec3 sigma = sqrt(max(m2 / 9.0 - mu * mu, 0.0));
    vec3 boxLo = max(lo, mu - sigma * 1.25), boxHi = min(hi, mu + sigma * 1.25);
    vec3 h = toRgb(clipToBox(toYCoCg(history(puv)), boxLo, boxHi));

    // more of this frame where things move fast on screen: less smearing
    float speed = length((puv - uv) * Screen.xy);
    float alpha = mix(0.08, 0.3, clamp(speed / 24.0, 0.0, 1.0));
    fragColor = vec4(mix(h, cur, alpha), 1.0);
}

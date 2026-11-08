#version 330

// Rustmine SRP, pass 3 (after the whole world, translucent included, before the hand): anti-aliasing, bloom, a
// highlight shoulder, the grade and the vignette. No luminance squashing: below the shoulder colours stay as drawn.

uniform sampler2D InSampler;

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

const vec3 LUMA = vec3(0.2126, 0.7152, 0.0722);

vec3 fxaa(vec2 uv, vec2 inv) {
    vec3 m = textureLod(InSampler, uv, 0.0).rgb;
    if (Fx.w < 0.5) return m;
    vec3 nw = textureLod(InSampler, uv + vec2(-1.0, -1.0) * inv, 0.0).rgb;
    vec3 ne = textureLod(InSampler, uv + vec2(1.0, -1.0) * inv, 0.0).rgb;
    vec3 sw = textureLod(InSampler, uv + vec2(-1.0, 1.0) * inv, 0.0).rgb;
    vec3 se = textureLod(InSampler, uv + vec2(1.0, 1.0) * inv, 0.0).rgb;
    float lM = dot(m, LUMA), lNW = dot(nw, LUMA), lNE = dot(ne, LUMA), lSW = dot(sw, LUMA), lSE = dot(se, LUMA);
    float lMin = min(lM, min(min(lNW, lNE), min(lSW, lSE)));
    float lMax = max(lM, max(max(lNW, lNE), max(lSW, lSE)));
    if (lMax - lMin < max(0.03, lMax * 0.125)) return m;
    vec2 dir = vec2(-((lNW + lNE) - (lSW + lSE)), (lNW + lSW) - (lNE + lSE));
    float reduce = max((lNW + lNE + lSW + lSE) * 0.03125, 1.0 / 128.0);
    dir = clamp(dir / (min(abs(dir.x), abs(dir.y)) + reduce), -8.0, 8.0) * inv;
    vec3 a = 0.5 * (textureLod(InSampler, uv + dir * (1.0 / 3.0 - 0.5), 0.0).rgb + textureLod(InSampler, uv + dir * (2.0 / 3.0 - 0.5), 0.0).rgb);
    vec3 b = a * 0.5 + 0.25 * (textureLod(InSampler, uv + dir * -0.5, 0.0).rgb + textureLod(InSampler, uv + dir * 0.5, 0.0).rgb);
    float lB = dot(b, LUMA);
    return (lB < lMin || lB > lMax) ? a : b;
}

// After TAA: a light sharpen (the history's filtering softens a little)
vec3 sharpened(ivec2 px) {
    ivec2 lim = ivec2(Screen.xy) - 1;
    vec3 c = texelFetch(InSampler, px, 0).rgb;
    vec3 n = texelFetch(InSampler, clamp(px + ivec2(0, 1), ivec2(0), lim), 0).rgb;
    vec3 s = texelFetch(InSampler, clamp(px - ivec2(0, 1), ivec2(0), lim), 0).rgb;
    vec3 e = texelFetch(InSampler, clamp(px + ivec2(1, 0), ivec2(0), lim), 0).rgb;
    vec3 w = texelFetch(InSampler, clamp(px - ivec2(1, 0), ivec2(0), lim), 0).rgb;
    vec3 lo = min(c, min(min(n, s), min(e, w))), hi = max(c, max(max(n, s), max(e, w)));
    return clamp(c + (4.0 * c - n - s - e - w) * 0.18, lo, hi);
}

// Glow of the truly bright only (sun glare, fire, white sky): plain light concrete stays crisp
vec3 bloomAt(vec2 uv, vec2 inv) {
    vec3 acc = vec3(0.0);
    float wsum = 0.0;
    for (int ring = 0; ring < 2; ring++) {
        float rad = (ring == 0 ? 5.0 : 13.0) * (Screen.y / 1080.0);
        for (int i = 0; i < 8; i++) {
            float a = (float(i) + float(ring) * 0.5) * 0.7853982;
            vec3 c = textureLod(InSampler, uv + vec2(cos(a), sin(a)) * rad * inv, 0.0).rgb;
            float k = smoothstep(0.90, 1.25, dot(c, LUMA));
            float w = ring == 0 ? 1.0 : 0.7;
            acc += c * k * w;
            wsum += w;
        }
    }
    return acc / wsum;
}

float dither(vec2 p) {
    return fract(52.9829189 * fract(dot(p, vec2(0.06711056, 0.00583715))));
}

void main() {
    vec2 inv = 1.0 / Screen.xy;
    vec2 uv = (floor(gl_FragCoord.xy) + 0.5) * inv;
    vec3 col = CamDelta.w > 0.5 ? sharpened(ivec2(gl_FragCoord.xy)) : fxaa(uv, inv);
    if (int(Cfg.z) != 0) {
        fragColor = vec4(col, 1.0); // debug views stay ungraded
        return;
    }

    if (Fx.x > 0.0) col += bloomAt(uv, inv) * 0.14 * Fx.x * (1.0 - Misc.w * 0.4);

    // tone: untouched below the shoulder, only the brightest highlights roll off
    float l = dot(col, LUMA);
    if (l > 0.80) {
        float t = (l - 0.80) / 0.80;
        float mapped = 0.80 + 0.20 * (1.0 - exp(-t * 2.2));
        col *= mapped / l;
    }
    if (Fx.z > 0.5) {
        // grade: S-curve, warm highlights, cool shadows, more saturation
        l = dot(col, LUMA);
        col = mix(vec3(l), col, 1.14);
        col = mix(col, col * vec3(0.96, 0.99, 1.05), 1.0 - smoothstep(0.0, 0.35, l));
        col = mix(col, col * vec3(1.04, 1.01, 0.96), smoothstep(0.45, 1.0, l));
        col = clamp(col, 0.0, 1.0);
        col = mix(col, col * col * (3.0 - 2.0 * col), 0.30);
    }
    if (Fx.y > 0.5) {
        vec2 c = uv * 2.0 - 1.0;
        col *= 1.0 - dot(c, c) * 0.09;
    }
    col += (dither(gl_FragCoord.xy) - 0.5) / 255.0; // no banding in skies and shadows
    fragColor = vec4(clamp(col, 0.0, 1.0), 1.0);
}

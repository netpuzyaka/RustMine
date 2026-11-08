#version 330

// Rustmine SRP, pass 2 (before translucent geometry): lights the opaque scene with the gathered sun visibility and
// occlusion. The scene is already lit by Minecraft, so nothing is lit twice: shadows only darken (towards a cool sky
// tint) where the sun would reach, the sun models the faces that look at it, and pixels dark anyway stay as they are.

uniform sampler2D InSampler;
uniform sampler2D DepthSampler;
uniform sampler2D GatherSampler;
uniform sampler2D FireShadowSampler;
uniform sampler2D LightSampler; // Minecraft's lightmap: x block light, y sky light

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

vec3 viewPos(vec2 uv, float d) {
    vec4 p = InvProj * vec4(uv * 2.0 - 1.0, d * 2.0 - 1.0, 1.0);
    return p.xyz / p.w;
}

float fetchDepth(ivec2 px) {
    return texelFetch(DepthSampler, clamp(px, ivec2(0), ivec2(Screen.xy) - 1), 0).r;
}

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

// Depth-aware blur of the gathered visibility/AO: removes the filter noise and upsamples a half-resolution gather
vec2 gatherAt(vec2 uv, float linDepth) {
    vec2 gsize = Screen.zw;
    vec2 gpos = uv * gsize - 0.5;
    ivec2 base = ivec2(floor(gpos));
    vec2 f = gpos - vec2(base);
    vec2 sum = vec2(0.0);
    float wsum = 0.0;
    int R = Misc.y >= 3.0 ? 2 : 1;
    for (int y = -R + 1; y <= R; y++) {
        for (int x = -R + 1; x <= R; x++) {
            ivec2 p = clamp(base + ivec2(x, y), ivec2(0), ivec2(gsize) - 1);
            vec4 g = texelFetch(GatherSampler, p, 0);
            float gd = (g.b + g.a / 255.0) * 1024.0;
            vec2 dxy = vec2(float(x), float(y)) - f;
            float spatial = exp(-dot(dxy, dxy) * (R == 2 ? 0.45 : 0.9));
            float rel = abs(gd - linDepth) / max(linDepth, 0.5);
            float w = spatial * exp(-rel * 60.0) + 1e-5;
            sum += g.rg * w;
            wsum += w;
        }
    }
    return sum / wsum;
}

float ign(vec2 p) {
    return fract(52.9829189 * fract(dot(p, vec2(0.06711056, 0.00583715))));
}

// Whether fire i sees the point (world position relative to floor(camera), moved off its surface): its cube shadow
// map, the face the point lies in, a 4-tap filter kept inside that face's tile of the atlas
float fireShadow(int i, vec3 rel) {
    vec3 v = rel - Fires[i * 3].xyz;
    vec3 a = abs(v);
    int f = a.x >= a.y && a.x >= a.z ? (v.x > 0.0 ? 0 : 1) : a.y >= a.z ? (v.y > 0.0 ? 2 : 3) : (v.z > 0.0 ? 4 : 5);
    vec4 c = FireFaces[i * 6 + f] * vec4(rel, 1.0);
    if (c.w <= 0.0) return 1.0;
    vec3 s = c.xyz / c.w * 0.5 + 0.5;
    vec2 texel = 1.0 / FireShadow.zw;
    vec2 lo = vec2(float(f), float(i)) * FireShadow.y * texel + texel, hi = lo + (FireShadow.y - 2.0) * texel;
    // compared as distances along the face's axis: the stored depth is the perspective one (near 0.05, far the range)
    float n = 0.05, far = Fires[i * 3].w;
    float zp = max(a.x, max(a.y, a.z));
    float bias = 0.03 + 0.015 * zp;
    float lit = 0.0;
    for (int k = 0; k < 4; k++) {
        vec2 o = (vec2(k & 1, k >> 1) - 0.5) * texel;
        float d = texture(FireShadowSampler, clamp(s.xy + o, lo, hi)).r;
        float zs = 2.0 * far * n / ((far + n) - (2.0 * d - 1.0) * (far - n));
        lit += zp - zs <= bias ? 1.0 : 0.0;
    }
    return lit * 0.25;
}

// The fires around P: how much of P's light is theirs (x), how much of their light P gets though they can't see it
// (y: Minecraft's light goes through building walls and around corners), and their colour weighted by what they give.
// blockLevel: Minecraft's block light at P from the fires that stand (their light blocks: RustLights, six levels a metre
// of range, at most 15, less a level a block of Manhattan distance, as Minecraft spreads it). Carried lights (from
// Carry.x on) have no light block: carried is the level they give P the same way (the highest, like Minecraft takes the
// brightest source; a spot fades over its range inside its cone), carriedAmt their share, carriedTint colour and flicker,
// carriedLight the light they shine on P as Unity's lights do (colour times intensity, Unity's falloff over the range,
// the angle to the surface, the spot's cone, the flicker): what lights P by day, when Minecraft's light is full anyway.
// standLight: the same from the fires that stand, where they see P (their shadow maps): Minecraft's light block lights
// every face alike, Rust's light inside a campfire's ring makes the stones and the ground at it glow.
vec2 fires(vec3 P, vec3 N, out vec3 tint, out float flicker, out float blockLevel, out float carried, out float carriedAmt, out vec4 carriedTint, out vec3 carriedLight, out vec3 standLight) {
    tint = vec3(0.0);
    carriedTint = vec4(0.0);
    flicker = 0.0;
    blockLevel = 0.0;
    carried = 0.0;
    carriedAmt = 0.0;
    carriedLight = vec3(0.0);
    standLight = vec3(0.0);
    int n = int(Cam1.w);
    if (n == 0) return vec2(0.0);
    vec3 rel = Cam1.xyz + (InvView * vec4(P, 0.0)).xyz;
    vec3 Nw = (InvView * vec4(N, 0.0)).xyz;
    int shadowed = int(FireShadow.x);
    int firstCarried = int(Carry.x);
    float amount = 0.0, leak = 0.0;
    for (int i = 0; i < n; i++) {
        vec4 F = Fires[i * 3];
        vec3 toL = F.xyz - rel;
        float dist = length(toL);
        vec3 dirL = toL / max(dist, 1e-3);
        float lvl = clamp(floor(F.w * 6.0 + 0.5), 1.0, 15.0);
        float level = lvl - (abs(toL.x) + abs(toL.y) + abs(toL.z));
        float facing = max(dot(Nw, dirL), 0.0) * 0.7 + 0.3;
        vec4 S = Fires[i * 3 + 2];
        float spot = 1.0;
        if (S.w > -1.5) spot = smoothstep(S.w, mix(S.w, 1.0, 0.25), dot(-dirL, S.xyz)); // flashlight, miner's hat: soft at the rim
        float flick = Fires[i * 3 + 1].w - 1.0; // LightEx: the flame breathes
        if (i >= firstCarried) {
            float at = S.w > -1.5 ? lvl * (1.0 - min(dist / F.w, 1.0)) * spot : level;
            if (at <= 0.0) continue;
            carried = max(carried, at * (facing * 0.4 + 0.6));
            float share = at / 15.0 * facing;
            carriedAmt += share;
            vec3 c = Fires[i * 3 + 1].rgb;
            carriedTint += vec4(c / max(max(c.r, c.g), max(c.b, 1e-4)), flick) * share;
            float xu = min(dist / F.w, 1.0);
            float unity = (1.0 - xu * xu) * (1.0 - xu * xu) / (1.0 + 25.0 * xu * xu);
            carriedLight += c * unity * max(dot(Nw, dirL), 0.0) * spot * (1.0 + flick * 0.5); // LightEx's curve, halved: 40 keys a second
            continue;
        }
        blockLevel = max(blockLevel, level);
        if (dist >= F.w || spot <= 0.0) continue;
        float x = dist / F.w;
        float att = (1.0 - x * x) * (1.0 - x * x) / (1.0 + 4.0 * x * x) * spot;
        float seen = i < shadowed ? fireShadow(i, rel + Nw * (0.04 + 0.01 * dist)) : 1.0;
        amount += att * facing * seen;
        leak += att * (1.0 - seen);
        tint += Fires[i * 3 + 1].rgb * att * facing * seen;
        flicker += flick * att * facing * seen;
        float unity = (1.0 - x * x) * (1.0 - x * x) / (1.0 + 25.0 * x * x);
        // only up close: further out Minecraft's light block lights it already, and the two add up to a glare
        standLight += Fires[i * 3 + 1].rgb * unity * max(dot(Nw, dirL), 0.0) * spot * seen * (1.0 + flick * 0.5) * clamp(1.0 - dist / 2.5, 0.0, 1.0);
    }
    return vec2(clamp(amount, 0.0, 1.0), clamp(leak, 0.0, 1.0));
}

vec3 lightmap(float block, float sky) {
    return texture(LightSampler, (clamp(vec2(block, sky), 0.0, 15.0) + 0.5) / 16.0).rgb;
}

void main() {
    vec2 inv = 1.0 / Screen.xy;
    ivec2 px = ivec2(gl_FragCoord.xy);
    vec2 uv = (vec2(px) + 0.5) * inv;
    vec3 col = texelFetch(InSampler, px, 0).rgb;
    float d = fetchDepth(px);
    int debug = int(Cfg.z);
    if (d >= 0.99999) {
        fragColor = vec4(col, 1.0);
        return;
    }

    vec3 P = viewPos(uv, d);
    float lin = -P.z;
    bool firesOnly = Misc.y < 0.5; // post-processing off (Potato): the fires' light alone, no gather, shadows or sun
    vec2 g = firesOnly ? vec2(1.0) : gatherAt(uv, lin);
    float vis = g.x;
    float ao = g.y;
    vec3 N = normalAt(px, inv, P);
    if (debug == 1 || debug >= 5) { fragColor = vec4(vec3(vis), 1.0); return; }
    if (debug == 2) { fragColor = vec4(vec3(ao), 1.0); return; }
    if (debug == 3) { fragColor = vec4(N * 0.5 + 0.5, 1.0); return; }
    if (debug == 4) { fragColor = vec4(vec3(fract(lin / 16.0)), 1.0); return; }

    float luma = dot(col, LUMA);
    float gate = smoothstep(0.03, 0.22, luma);                 // the very dark (caves, night) stays as it is
    float farFade = 1.0 - smoothstep(160.0, 240.0, lin);
    float ndl = clamp(dot(N, SunView.xyz), 0.0, 1.0);
    float sunAmt = firesOnly ? 0.0 : SunView.w * farFade;
    float sunLit = vis * ndl * sunAmt;                         // how much direct sun this pixel gets

    // form: Minecraft shades faces by a fixed table; the real sun models them (lit faces open up, the rest sit back)
    if (!firesOnly) {
        col *= mix(1.0, mix(0.86, 1.16, sunLit), gate);
        col *= mix(vec3(1.0), SunColor.rgb * 1.03, sunLit * 0.55); // warm light only where the sun really reaches
    }

    // fires: what they light keeps its light (the sun's shadow doesn't fall on firelight)
    vec3 fireTint;
    vec4 carriedTint;
    vec3 carriedLight, standLight;
    float fireFlicker, blockLevel, carried, carriedAmt;
    vec2 fire = fires(P, N, fireTint, fireFlicker, blockLevel, carried, carriedAmt, carriedTint, carriedLight, standLight);
    float standX = fire.x; // the fires that stand; what players carry is added to fire.x below
    // P's colour (its albedo taken as its normalised colour) for the light the flames add on top
    vec3 surf = min(col / max(dot(col, LUMA), 0.02), vec3(4.0));
    // Rust's eye adapts: in daylight a flame's light hardly shows, in the dark it does. What the flames add on top
    // counts as much as P is dark, and saturates (E / (1 + E)) instead of burning bright surfaces out
    float dark = 1.0 - smoothstep(0.2, 0.7, luma);
    // what the fires that stand add where they see P, over Minecraft's even light from their light blocks: a little
    // (Minecraft's already there), but enough for what faces the flame up close (a campfire's stones)
    vec3 standAdd = surf * 0.15 * dark * standLight / (1.0 + standLight);
    // what players carry: at night P was drawn with Minecraft's lightmap raised to Carry.y (Srp.boostLightmap) and takes
    // the lightmap at the level the flame gives it over that (as a light block there would; the sky light at the camera
    // stands in for P's): the raised frame darkened back by the distance from the flame, nothing lost.
    vec3 carriedGain = vec3(1.0), carriedAdd = vec3(0.0);
    if (Carry.y < 0.5) {
        if (dot(carriedLight, LUMA) > 1e-3) {
            // by day Minecraft's light is full, even inside a monument or in a building's shade (what darkens them is
            // their own shading, the sun's shadow and occlusion), and the lightmap can't tell a flame from it: the
            // flame's light is added on top of what P shows after the sun's shadow and occlusion, in P's colour and
            // the flame's, as much as P is dark; it leaves the shadow and the rest of the picture alone
            carriedAdd = surf * 0.45 * dark * carriedLight / (1.0 + carriedLight);
        }
    } else {
        vec3 own = lightmap(blockLevel, Carry.z), lit = lightmap(max(blockLevel, carried), Carry.z);
        carriedGain = min(lit / max(lightmap(max(blockLevel, Carry.y), Carry.z), vec3(0.004)), vec3(6.0));
        // how much the flame adds to P's own light: that much its colour and flicker show
        float adds = clamp(dot(lit / max(own, vec3(0.004)), LUMA) - 1.0, 0.0, 1.0);
        fire.x = clamp(fire.x + min(carriedAmt, 1.0) * adds, 0.0, 1.0);
        fireTint += carriedTint.rgb * adds;
        fireFlicker += carriedTint.w * adds * 0.5; // LightEx's curve, halved: 40 keys a second
    }

    // shadow: deep and cool, where the sun would have reached but something is in the way
    float shadow = (1.0 - vis) * smoothstep(0.0, 0.30, ndl) * sunAmt * SunColor.w * gate * (1.0 - fire.x);
    vec3 shaded = col * ShadowTint.rgb;
    shaded = mix(shaded, vec3(dot(shaded, LUMA)), 0.08);
    col = mix(col, shaded, clamp(shadow, 0.0, 1.0));

    // contact occlusion everywhere, strongest in the already-lit
    float aoAmt = ShadowTint.w * mix(0.55, 1.0, gate);
    col *= mix(1.0, ao * ao * (3.0 - 2.0 * ao), aoAmt);

    col = col * carriedGain + carriedAdd + standAdd;

    if (fire.x + fire.y > 0.0) {
        col *= 1.0 + clamp(fireFlicker, -0.35, 0.35) * 0.6;
        // firelight takes the fire's colour (Rust's campfire: deep orange), as much as the fire lights it
        float tmax = max(fireTint.r, max(fireTint.g, fireTint.b));
        if (tmax > 1e-4) {
            // gently for the fires that stand (their light block already lights a wide ring, and multiplied into green
            // grass the orange turns it yellow-green), fully for a carried flame's close light
            float carriedShare = clamp((fire.x - standX) / max(fire.x, 1e-4), 0.0, 1.0);
            vec3 warm = mix(vec3(1.0), fireTint / tmax * mix(1.2, 1.35, carriedShare), mix(0.35, 0.6, carriedShare));
            col = mix(col, col * warm, fire.x * mix(0.25, 0.55, carriedShare));
        }
        // and where the fire can't see (behind a wall, under a box) its light goes: Minecraft's light leaks there
        col *= 1.0 - fire.y * 0.65;
    }

    fragColor = vec4(clamp(col, 0.0, 1.0), 1.0);
}

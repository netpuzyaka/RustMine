#version 330

// Rustmine SRP, carried flames at night: Minecraft's lightmap (16x16, x block light, y sky light) with every block
// light below the flame's level raised to it. The opaque world is drawn with it, and the light pass takes it back
// down to the flame's falloff: darkening loses nothing, while lifting a dark frame up would only show its banding.

uniform sampler2D InSampler;

layout(std140) uniform BoostData {
    vec4 Boost; // x: the block light level everything is raised to
};

out vec4 fragColor;

void main() {
    ivec2 p = ivec2(gl_FragCoord.xy);
    fragColor = texelFetch(InSampler, ivec2(max(p.x, int(Boost.x)), p.y), 0);
}

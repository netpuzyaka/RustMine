#version 330

// A bullet tracer: vanilla's entity fragment shader (EMISSIVE, NO_OVERLAY) for premultiplied colours. Vanilla's fog mixes the
// colour toward the fog's and keeps alpha, so a transparent texel got the fog's colour at alpha 0 and the premultiplied blend
// added it to the sky: by day a light square around every far shot. Here the fog's colour is weighted by the texel's alpha.

#moj_import <minecraft:fog.glsl>
#moj_import <minecraft:dynamictransforms.glsl>

uniform sampler2D Sampler0;

in float sphericalVertexDistance;
in float cylindricalVertexDistance;
in vec4 vertexColor;
in vec4 lightMapColor;
in vec4 overlayColor;
in vec2 texCoord0;

out vec4 fragColor;

void main() {
    vec4 color = texture(Sampler0, texCoord0) * vertexColor * ColorModulator;
    float fogValue = total_fog_value(sphericalVertexDistance, cylindricalVertexDistance, FogEnvironmentalStart, FogEnvironmentalEnd,
        FogRenderDistanceStart, FogRenderDistanceEnd) * FogColor.a;
    fragColor = vec4(mix(color.rgb, FogColor.rgb * color.a, fogValue), color.a);
}

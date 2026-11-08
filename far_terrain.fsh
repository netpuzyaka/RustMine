#version 330

// The island's distant ground (FarTerrain). Parameters ride in the transform's spare TextureMat:
//   column 0 = (mask origin chunk x, mask origin chunk z, mask size in chunks, -)
//   column 1 = (end of the mesh in blocks from the camera, -, -, -)
// Sampler3 is the mask of chunk columns whose blocks Minecraft has built: the mesh is dropped there.

#moj_import <minecraft:fog.glsl>
#moj_import <minecraft:dynamictransforms.glsl>

uniform sampler2D Sampler3;

in float sphericalVertexDistance;
in float cylindricalVertexDistance;
in vec4 vertexColor;
in vec2 worldXZ;
in vec2 cameraXZ;

out vec4 fragColor;

void main() {
    vec4 mask = TextureMat[0];
    if (length(cameraXZ) > TextureMat[1].x) {
        discard;
    }
    ivec2 c = ivec2(floor(worldXZ / 16.0)) - ivec2(mask.xy);
    int size = int(mask.z);
    if (c.x >= 0 && c.y >= 0 && c.x < size && c.y < size && texelFetch(Sampler3, c, 0).r > 0.5) {
        discard;
    }
    fragColor = apply_fog(vertexColor, sphericalVertexDistance, cylindricalVertexDistance, FogEnvironmentalStart, FogEnvironmentalEnd, FogRenderDistanceStart, FogRenderDistanceEnd, FogColor);
}

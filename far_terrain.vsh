#version 330

// The island's distant ground (FarTerrain): world-space vertices moved into camera space by ModelOffset (= -camera).
// Colour = ground texture average x splat tint, from the vertex; alpha 0 marks the sea, painted ColorModulator (the
// water's colour) over the sea floor's colour. Lit like a block in open sky (lightmap at sky 15, block 0) with
// Minecraft's face shading spread over the smooth normal (up 1.0, north/south 0.8, east/west 0.6, down 0.5).

#moj_import <minecraft:fog.glsl>
#moj_import <minecraft:dynamictransforms.glsl>
#moj_import <minecraft:projection.glsl>

in vec3 Position;
in vec4 Color;
in vec3 Normal;

uniform sampler2D Sampler2;

out float sphericalVertexDistance;
out float cylindricalVertexDistance;
out vec4 vertexColor;
out vec2 worldXZ;
out vec2 cameraXZ;

void main() {
    vec3 pos = Position + ModelOffset;
    gl_Position = ProjMat * ModelViewMat * vec4(pos, 1.0);

    sphericalVertexDistance = fog_spherical_distance(pos);
    cylindricalVertexDistance = fog_cylindrical_distance(pos);

    vec3 n = normalize(Normal);
    float shade = n.x * n.x * 0.6 + n.z * n.z * 0.8 + n.y * n.y * (n.y > 0.0 ? 1.0 : 0.5);
    vec3 rgb = mix(Color.rgb, ColorModulator.rgb, (1.0 - Color.a) * 0.85);
    vec4 light = texelFetch(Sampler2, ivec2(0, 15), 0);
    vertexColor = vec4(rgb * shade * light.rgb, 1.0);
    worldXZ = Position.xz;
    cameraXZ = pos.xz;
}

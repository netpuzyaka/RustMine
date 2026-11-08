#version 330

// Sun shadow map, monuments: position, the mesh UV (any tile) and its sprite rectangle in the block atlas
in vec3 Position;
in vec2 UV0;
in ivec2 UV1;
in ivec2 UV2;

layout(std140) uniform ShadowTransform {
    mat4 ShadowMVP;
};

out vec2 uv;
flat out ivec4 sprite;

void main() {
    gl_Position = ShadowMVP * vec4(Position, 1.0);
    uv = UV0;
    sprite = ivec4(UV1, UV2);
}

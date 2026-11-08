#version 330

// Sun shadow map: positions only, relative to the shadow anchor
in vec3 Position;

layout(std140) uniform ShadowTransform {
    mat4 ShadowMVP;
};

void main() {
    gl_Position = ShadowMVP * vec4(Position, 1.0);
}

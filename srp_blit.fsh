#version 330

uniform sampler2D InSampler;

in vec2 texCoord;
out vec4 fragColor;

void main() {
    fragColor = vec4(texelFetch(InSampler, ivec2(gl_FragCoord.xy), 0).rgb, 1.0);
}

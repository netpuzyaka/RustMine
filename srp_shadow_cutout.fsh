#version 330

// Leaves, grates and fences cast through their texture: the UV wraps into the sprite, cut-away texels drop out
uniform sampler2D Sampler0;

in vec2 uv;
flat in ivec4 sprite;

out vec4 fragColor;

void main() {
    if (sprite.z > 0) {
        vec2 atlas = vec2(textureSize(Sampler0, 0));
        vec2 p = (vec2(sprite.xy) + fract(uv) * vec2(sprite.zw)) / atlas;
        if (textureLod(Sampler0, p, 0.0).a < 0.5) discard;
    }
    fragColor = vec4(1.0);
}

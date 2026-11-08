package net.rustmine.client.mixin;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.class_1011;
import net.minecraft.class_7764;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Environment(EnvType.CLIENT)
@Mixin({class_7764.class})
public interface SpriteContentsAccessor {
  @Accessor("field_40539")
  class_1011 rustmine$originalImage();
}


/* Location:              C:\Users\SystemX\AppData\Local\IceCubeRust\game\mods\rustmine-0.1.2.jar!\net\rustmine\client\mixin\SpriteContentsAccessor.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */
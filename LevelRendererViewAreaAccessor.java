package net.rustmine.client.mixin;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.class_761;
import net.minecraft.class_769;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Environment(EnvType.CLIENT)
@Mixin({class_761.class})
public interface LevelRendererViewAreaAccessor {
  @Accessor("field_4112")
  class_769 rustmine$viewArea();
}


/* Location:              C:\Users\SystemX\AppData\Local\IceCubeRust\game\mods\rustmine-0.1.2.jar!\net\rustmine\client\mixin\LevelRendererViewAreaAccessor.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */
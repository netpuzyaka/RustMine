package net.rustmine.client.mixin;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.class_4184;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Environment(EnvType.CLIENT)
@Mixin({class_4184.class})
public interface CameraAccessor {
  @Accessor("field_18721")
  float rustmine$eyeHeight();
  
  @Accessor("field_18721")
  void rustmine$setEyeHeight(float paramFloat);
  
  @Accessor("field_18722")
  float rustmine$eyeHeightOld();
  
  @Accessor("field_18722")
  void rustmine$setEyeHeightOld(float paramFloat);
}


/* Location:              C:\Users\SystemX\AppData\Local\IceCubeRust\game\mods\rustmine-0.1.2.jar!\net\rustmine\client\mixin\CameraAccessor.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */
package net.rustmine.mixin;

import net.minecraft.class_3248;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin({class_3248.class})
public interface ServerLoginAccessor {
  @Accessor("field_45028")
  String rustmine$requestedUsername();
}


/* Location:              C:\Users\SystemX\AppData\Local\IceCubeRust\game\mods\rustmine-0.1.2.jar!\net\rustmine\mixin\ServerLoginAccessor.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */
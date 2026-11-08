package net.rustmine.mixin;

import net.minecraft.class_1827;
import net.minecraft.class_2248;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin({class_1827.class})
public interface StandingAndWallBlockItemAccessor {
  @Accessor("field_8918")
  class_2248 rustmine$wallBlock();
}


/* Location:              C:\Users\SystemX\AppData\Local\IceCubeRust\game\mods\rustmine-0.1.2.jar!\net\rustmine\mixin\StandingAndWallBlockItemAccessor.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */
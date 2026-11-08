package net.rustmine.mixin;

import net.minecraft.class_1735;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin({class_1735.class})
public interface SlotAccessor {
  @Accessor("field_7873")
  @Mutable
  void setX(int paramInt);
  
  @Accessor("field_7872")
  @Mutable
  void setY(int paramInt);
}


/* Location:              C:\Users\SystemX\AppData\Local\IceCubeRust\game\mods\rustmine-0.1.2.jar!\net\rustmine\mixin\SlotAccessor.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */
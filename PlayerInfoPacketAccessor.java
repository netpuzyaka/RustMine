package net.rustmine.mixin;

import java.util.EnumSet;
import java.util.List;
import net.minecraft.class_2703;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin({class_2703.class})
public interface PlayerInfoPacketAccessor {
  @Mutable
  @Accessor("field_40698")
  void rustmine$setActions(EnumSet<class_2703.class_5893> paramEnumSet);
  
  @Mutable
  @Accessor("field_12369")
  void rustmine$setEntries(List<class_2703.class_2705> paramList);
}


/* Location:              C:\Users\SystemX\AppData\Local\IceCubeRust\game\mods\rustmine-0.1.2.jar!\net\rustmine\mixin\PlayerInfoPacketAccessor.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */
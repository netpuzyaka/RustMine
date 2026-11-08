package net.rustmine.mixin;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.class_3898;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin({class_3898.class})
public interface ChunkMapAccessor {
  @Accessor("field_18242")
  Int2ObjectMap<?> rustmine$entityMap();
}


/* Location:              C:\Users\SystemX\AppData\Local\IceCubeRust\game\mods\rustmine-0.1.2.jar!\net\rustmine\mixin\ChunkMapAccessor.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */
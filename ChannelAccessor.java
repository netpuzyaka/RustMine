package net.rustmine.client.mixin;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.class_4224;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Environment(EnvType.CLIENT)
@Mixin({class_4224.class})
public interface ChannelAccessor {
  @Accessor("field_18893")
  int rustmine$source();
}


/* Location:              C:\Users\SystemX\AppData\Local\IceCubeRust\game\mods\rustmine-0.1.2.jar!\net\rustmine\client\mixin\ChannelAccessor.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */
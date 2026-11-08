package net.rustmine.client.mixin;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.class_2338;
import net.minecraft.class_769;
import net.minecraft.class_846;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Environment(EnvType.CLIENT)
@Mixin({class_769.class})
public interface ViewAreaInvoker {
  @Invoker("method_3323")
  class_846.class_851 rustmine$sectionAt(class_2338 paramclass_2338);
}


/* Location:              C:\Users\SystemX\AppData\Local\IceCubeRust\game\mods\rustmine-0.1.2.jar!\net\rustmine\client\mixin\ViewAreaInvoker.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */
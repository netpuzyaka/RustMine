package net.rustmine;

import java.util.List;
import net.minecraft.class_1657;
import net.minecraft.class_3222;

public interface Api {
  RustVitalsData get(class_1657 paramclass_1657);
  
  void sync(class_3222 paramclass_3222, RustVitalsData paramRustVitalsData);
  
  void useMedkit(class_3222 paramclass_3222);
  
  void drinkWater(class_3222 paramclass_3222);
  
  void onMeleeHit(class_3222 paramclass_32221, float paramFloat, RustWearManager.Hitbox paramHitbox, class_3222 paramclass_32222);
  
  void consume(class_3222 paramclass_3222, List<RustConsumables.Effect> paramList);
}


/* Location:              C:\Users\SystemX\AppData\Local\IceCubeRust\game\mods\rustmine-0.1.2.jar!\net\rustmine\RustVitalsManager$Api.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */
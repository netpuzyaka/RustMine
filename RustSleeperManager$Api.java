package net.rustmine;

import java.util.UUID;
import net.minecraft.class_1657;

public interface Api {
  boolean isSleeping(UUID paramUUID);
  
  boolean isSleeping(class_1657 paramclass_1657);
  
  void registerSleeper(UUID paramUUID, RustSleeperEntity paramRustSleeperEntity);
  
  void unregisterSleeper(UUID paramUUID);
  
  void markKilled(UUID paramUUID);
}


/* Location:              C:\Users\SystemX\AppData\Local\IceCubeRust\game\mods\rustmine-0.1.2.jar!\net\rustmine\RustSleeperManager$Api.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */
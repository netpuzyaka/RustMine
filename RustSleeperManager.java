/*    */ package net.rustmine;
/*    */ 
/*    */ import java.util.UUID;
/*    */ import net.minecraft.class_1657;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class RustSleeperManager
/*    */ {
/*    */   public static volatile Api impl;
/*    */   
/*    */   public static boolean isSleeping(UUID uuid) {
/* 21 */     Api a = impl;
/* 22 */     return (a == null) ? false : a.isSleeping(uuid);
/*    */   }
/*    */   
/*    */   public static boolean isSleeping(class_1657 player) {
/* 26 */     Api a = impl;
/* 27 */     return (a == null) ? false : a.isSleeping(player);
/*    */   }
/*    */   
/*    */   public static void registerSleeper(UUID ownerUuid, RustSleeperEntity entity) {
/* 31 */     Api a = impl;
/* 32 */     if (a != null) a.registerSleeper(ownerUuid, entity); 
/*    */   }
/*    */   
/*    */   public static void unregisterSleeper(UUID ownerUuid) {
/* 36 */     Api a = impl;
/* 37 */     if (a != null) a.unregisterSleeper(ownerUuid); 
/*    */   }
/*    */   
/*    */   public static void markKilled(UUID uuid) {
/* 41 */     Api a = impl;
/* 42 */     if (a != null) a.markKilled(uuid); 
/*    */   }
/*    */   
/*    */   public static interface Api {
/*    */     boolean isSleeping(UUID param1UUID);
/*    */     
/*    */     boolean isSleeping(class_1657 param1class_1657);
/*    */     
/*    */     void registerSleeper(UUID param1UUID, RustSleeperEntity param1RustSleeperEntity);
/*    */     
/*    */     void unregisterSleeper(UUID param1UUID);
/*    */     
/*    */     void markKilled(UUID param1UUID);
/*    */   }
/*    */ }


/* Location:              C:\Users\SystemX\AppData\Local\IceCubeRust\game\mods\rustmine-0.1.2.jar!\net\rustmine\RustSleeperManager.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */
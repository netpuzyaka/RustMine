/*    */ package net.rustmine;
/*    */ 
/*    */ import java.util.UUID;
/*    */ import net.minecraft.class_3222;
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
/*    */ public final class RustWoundedManager
/*    */ {
/*    */   public static volatile Api impl;
/*    */   
/*    */   public static boolean isWounded(class_3222 player) {
/* 20 */     Api a = impl;
/* 21 */     return (a == null) ? false : a.isWounded(player);
/*    */   }
/*    */   
/*    */   public static boolean isWounded(UUID uuid) {
/* 25 */     Api a = impl;
/* 26 */     return (a == null) ? false : a.isWounded(uuid);
/*    */   }
/*    */   
/*    */   public static void executeKill(class_3222 player) {
/* 30 */     Api a = impl;
/* 31 */     if (a != null) a.executeKill(player); 
/*    */   }
/*    */   
/*    */   public static interface Api {
/*    */     boolean isWounded(class_3222 param1class_3222);
/*    */     
/*    */     boolean isWounded(UUID param1UUID);
/*    */     
/*    */     void executeKill(class_3222 param1class_3222);
/*    */   }
/*    */ }


/* Location:              C:\Users\SystemX\AppData\Local\IceCubeRust\game\mods\rustmine-0.1.2.jar!\net\rustmine\RustWoundedManager.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */
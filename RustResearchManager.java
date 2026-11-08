/*    */ package net.rustmine;
/*    */ 
/*    */ import net.minecraft.class_1657;
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
/*    */ public final class RustResearchManager
/*    */ {
/*    */   public static volatile Api impl;
/*    */   
/*    */   public static boolean isUnlocked(class_1657 player, String recipeId) {
/* 19 */     Api a = impl;
/* 20 */     return (a == null) ? false : a.isUnlocked(player, recipeId);
/*    */   }
/*    */   
/*    */   public static boolean unlock(class_3222 player, String recipeId) {
/* 24 */     Api a = impl;
/* 25 */     return (a == null) ? false : a.unlock(player, recipeId);
/*    */   }
/*    */   
/*    */   public static interface Api {
/*    */     boolean isUnlocked(class_1657 param1class_1657, String param1String);
/*    */     
/*    */     boolean unlock(class_3222 param1class_3222, String param1String);
/*    */   }
/*    */ }


/* Location:              C:\Users\SystemX\AppData\Local\IceCubeRust\game\mods\rustmine-0.1.2.jar!\net\rustmine\RustResearchManager.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */
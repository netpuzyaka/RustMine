/*    */ package net.rustmine;
/*    */ 
/*    */ import net.minecraft.class_1263;
/*    */ import net.minecraft.class_3218;
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
/*    */ public final class RustRecycler
/*    */ {
/*    */   public static volatile Api impl;
/*    */   
/*    */   public static boolean hasRecyclable(class_1263 container, int inputSlots) {
/* 20 */     Api a = impl;
/* 21 */     return (a != null && a.hasRecyclable(container, inputSlots));
/*    */   }
/*    */   
/*    */   public static boolean think(class_3218 level, class_1263 container, int inputSlots, int outStart, int outEnd, double x, double y, double z) {
/* 25 */     Api a = impl;
/* 26 */     return (a != null && a.think(level, container, inputSlots, outStart, outEnd, x, y, z));
/*    */   }
/*    */   
/*    */   public static interface Api {
/*    */     boolean hasRecyclable(class_1263 param1class_1263, int param1Int);
/*    */     
/*    */     boolean think(class_3218 param1class_3218, class_1263 param1class_1263, int param1Int1, int param1Int2, int param1Int3, double param1Double1, double param1Double2, double param1Double3);
/*    */   }
/*    */ }


/* Location:              C:\Users\SystemX\AppData\Local\IceCubeRust\game\mods\rustmine-0.1.2.jar!\net\rustmine\RustRecycler.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */
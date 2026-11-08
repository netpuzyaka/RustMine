/*    */ package net.rustmine;
/*    */ 
/*    */ import net.minecraft.class_1297;
/*    */ import net.minecraft.class_3486;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class RustSwim
/*    */ {
/*    */   public static final float FORWARD = 1.4F;
/*    */   public static final float BACK = 0.75F;
/*    */   public static final float SIDE = 0.5F;
/*    */   public static final double SWIMMING_FACTOR = 0.65D;
/*    */   
/*    */   public static boolean swimming(class_1297 e) {
/* 18 */     return (e != null && e.method_5799() && e.method_5861(class_3486.field_15517) >= 0.65D * e.method_17682());
/*    */   }
/*    */ }


/* Location:              C:\Users\SystemX\AppData\Local\IceCubeRust\game\mods\rustmine-0.1.2.jar!\net\rustmine\RustSwim.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */
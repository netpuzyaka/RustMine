/*    */ package net.rustmine;
/*    */ 
/*    */ import net.minecraft.class_1297;
/*    */ import net.minecraft.class_1792;
/*    */ import net.minecraft.class_243;
/*    */ import net.minecraft.class_3218;
/*    */ import net.minecraft.class_3222;
/*    */ import net.minecraft.class_3414;
/*    */ import net.minecraft.class_3419;
/*    */ import net.minecraft.class_7923;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class RustToolSounds
/*    */ {
/*    */   public static class_3414 get(class_1792 item, String kind) {
/* 20 */     if (item == null) return null; 
/* 21 */     String base = "tool." + class_7923.field_41178.method_10221(item).method_12832() + ".";
/* 22 */     class_3414 s = RustmineMod.SOUNDS.get(base + base);
/* 23 */     if (s == null && kind.startsWith("strike_")) s = RustmineMod.SOUNDS.get(base + "strike"); 
/* 24 */     if (s == null && kind.endsWith("3p")) s = RustmineMod.SOUNDS.get(base + base); 
/* 25 */     return s;
/*    */   }
/*    */ 
/*    */   
/*    */   public static boolean strike(class_3218 level, class_243 pos, class_1792 tool, String kind) {
/* 30 */     class_3414 s = get(tool, kind);
/* 31 */     if (s == null) return false; 
/* 32 */     level.method_43128(null, pos.field_1352, pos.field_1351, pos.field_1350, s, class_3419.field_15248, 1.0F, 0.95F + level.field_9229.method_43057() * 0.1F);
/* 33 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public static void swing3p(class_3222 p, class_1792 tool) {
/* 38 */     class_3414 s = get(tool, "swing3p");
/* 39 */     if (s != null) p.method_51469().method_43128((class_1297)p, p.method_23317(), p.method_23320(), p.method_23321(), s, class_3419.field_15248, 1.0F, 0.95F + p.method_59922().method_43057() * 0.1F); 
/*    */   }
/*    */ }


/* Location:              C:\Users\SystemX\AppData\Local\IceCubeRust\game\mods\rustmine-0.1.2.jar!\net\rustmine\RustToolSounds.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */
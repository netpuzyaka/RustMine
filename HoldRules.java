/*    */ package net.rustmine;
/*    */ 
/*    */ import java.util.function.Predicate;
/*    */ import net.minecraft.class_1657;
/*    */ import net.minecraft.class_1661;
/*    */ import net.minecraft.class_1799;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class HoldRules
/*    */ {
/*    */   public static volatile Predicate<class_1799> firstPerson;
/*    */   private static boolean scrolling;
/*    */   private static boolean bypass;
/*    */   
/*    */   public static boolean mayHold(class_1657 player, class_1799 stack) {
/* 22 */     if (stack.method_7960()) return false; 
/* 23 */     Predicate<class_1799> rule = firstPerson;
/* 24 */     return (rule == null || !player.method_73183().method_8608() || rule.test(stack));
/*    */   }
/*    */   
/* 27 */   public static boolean scrolling() { return scrolling; }
/* 28 */   public static void scrolling(boolean on) { scrolling = on; } public static boolean bypass() {
/* 29 */     return bypass;
/*    */   }
/*    */   
/*    */   public static void select(class_1661 inventory, int slot) {
/* 33 */     bypass = true;
/*    */     try {
/* 35 */       inventory.method_61496(slot);
/*    */     } finally {
/* 37 */       bypass = false;
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\SystemX\AppData\Local\IceCubeRust\game\mods\rustmine-0.1.2.jar!\net\rustmine\HoldRules.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */
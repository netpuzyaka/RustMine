/*    */ package net.rustmine;
/*    */ 
/*    */ import net.minecraft.class_1792;
/*    */ import net.minecraft.class_1799;
/*    */ import net.minecraft.class_2487;
/*    */ import net.minecraft.class_9279;
/*    */ import net.minecraft.class_9334;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class TorchItem
/*    */   extends class_1792
/*    */ {
/*    */   public static final String KEY_LIT = "rust_torch_lit";
/*    */   
/*    */   public TorchItem(class_1792.class_1793 properties) {
/* 17 */     super(properties);
/*    */   }
/*    */   
/*    */   public static boolean isLit(class_1799 stack) {
/* 21 */     if (stack == null || stack.method_7960() || !(stack.method_7909() instanceof TorchItem)) return false; 
/* 22 */     class_9279 cd = (class_9279)stack.method_58694(class_9334.field_49628);
/* 23 */     return (cd != null && ((Boolean)cd.method_57461().method_10577("rust_torch_lit").orElse(Boolean.valueOf(false))).booleanValue());
/*    */   }
/*    */   
/*    */   public static void setLit(class_1799 stack, boolean lit) {
/* 27 */     if (stack == null || stack.method_7960())
/* 28 */       return;  class_9279.method_57452(class_9334.field_49628, stack, tag -> tag.method_10556("rust_torch_lit", lit));
/*    */   }
/*    */ }


/* Location:              C:\Users\SystemX\AppData\Local\IceCubeRust\game\mods\rustmine-0.1.2.jar!\net\rustmine\TorchItem.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */
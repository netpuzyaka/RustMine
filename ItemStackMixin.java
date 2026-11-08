/*    */ package net.rustmine.mixin;
/*    */ import net.minecraft.class_1799;
/*    */ import net.rustmine.RustStacks;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ import org.spongepowered.asm.mixin.injection.Constant;
/*    */ import org.spongepowered.asm.mixin.injection.Inject;
/*    */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
/*    */ 
/*    */ @Mixin({class_1799.class})
/*    */ abstract class ItemStackMixin {
/*    */   @Inject(method = {"method_7914"}, at = {@At("HEAD")}, cancellable = true)
/*    */   private void rustmine$customMaxStack(CallbackInfoReturnable<Integer> cir) {
/* 14 */     class_1799 self = (class_1799)this;
/* 15 */     int custom = RustStacks.getMaxStack(self.method_7909());
/* 16 */     if (custom > 0) {
/* 17 */       cir.setReturnValue(Integer.valueOf(custom));
/*    */     }
/*    */   }
/*    */   
/*    */   @ModifyConstant(method = {"method_57371"}, constant = {@Constant(intValue = 99)}, require = 0)
/*    */   private static int rustmine$expandItemStackCodecCountMax(int original) {
/* 23 */     return 1000000;
/*    */   }
/*    */ }


/* Location:              C:\Users\SystemX\AppData\Local\IceCubeRust\game\mods\rustmine-0.1.2.jar!\net\rustmine\mixin\ItemStackMixin.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */
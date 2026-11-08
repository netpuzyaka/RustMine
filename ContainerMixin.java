/*    */ package net.rustmine.mixin;
/*    */ 
/*    */ import net.minecraft.class_1263;
/*    */ import net.minecraft.class_1799;
/*    */ import net.rustmine.RustStacks;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ import org.spongepowered.asm.mixin.injection.Inject;
/*    */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
/*    */ 
/*    */ @Mixin({class_1263.class})
/*    */ public interface ContainerMixin {
/*    */   @Inject(method = {"method_5444()I"}, at = {@At("HEAD")}, cancellable = true)
/*    */   default void rustmine$containerMaxStack(CallbackInfoReturnable<Integer> cir) {
/* 15 */     cir.setReturnValue(Integer.valueOf(1000));
/*    */   }
/*    */   
/*    */   @Inject(method = {"method_58350(Lnet/minecraft/class_1799;)I"}, at = {@At("HEAD")}, cancellable = true)
/*    */   default void rustmine$containerMaxStackItem(class_1799 stack, CallbackInfoReturnable<Integer> cir) {
/* 20 */     if (stack != null && !stack.method_7960()) {
/* 21 */       int custom = RustStacks.getMaxStack(stack.method_7909());
/* 22 */       if (custom > 0)
/* 23 */         cir.setReturnValue(Integer.valueOf(custom)); 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\SystemX\AppData\Local\IceCubeRust\game\mods\rustmine-0.1.2.jar!\net\rustmine\mixin\ContainerMixin.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */
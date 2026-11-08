/*    */ package net.rustmine.mixin;
/*    */ 
/*    */ import net.minecraft.class_1792;
/*    */ import net.rustmine.RustStacks;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ import org.spongepowered.asm.mixin.injection.Inject;
/*    */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
/*    */ 
/*    */ @Mixin({class_1792.class})
/*    */ public abstract class ItemMixin {
/*    */   @Inject(method = {"method_7882"}, at = {@At("HEAD")}, cancellable = true)
/*    */   private void rustmine$customDefaultMaxStack(CallbackInfoReturnable<Integer> cir) {
/* 14 */     class_1792 self = (class_1792)this;
/* 15 */     int custom = RustStacks.getMaxStack(self);
/* 16 */     if (custom > 0)
/* 17 */       cir.setReturnValue(Integer.valueOf(custom)); 
/*    */   }
/*    */ }


/* Location:              C:\Users\SystemX\AppData\Local\IceCubeRust\game\mods\rustmine-0.1.2.jar!\net\rustmine\mixin\ItemMixin.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */
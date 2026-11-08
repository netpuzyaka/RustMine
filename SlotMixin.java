/*    */ package net.rustmine.mixin;
/*    */ 
/*    */ import net.minecraft.class_1657;
/*    */ import net.minecraft.class_1735;
/*    */ import net.minecraft.class_1799;
/*    */ import net.rustmine.RustStacks;
/*    */ import net.rustmine.inventory.RustSlotFilter;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ import org.spongepowered.asm.mixin.injection.Inject;
/*    */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
/*    */ 
/*    */ @Mixin({class_1735.class})
/*    */ abstract class SlotMixin {
/*    */   @Inject(method = {"method_7680"}, at = {@At("HEAD")}, cancellable = true)
/*    */   private void rustmine$mayPlace(class_1799 stack, CallbackInfoReturnable<Boolean> cir) {
/* 17 */     class_1735 self = (class_1735)this;
/* 18 */     if (!RustSlotFilter.isAllowedSlot(self)) {
/* 19 */       cir.setReturnValue(Boolean.valueOf(false));
/* 20 */     } else if (self.field_7871 instanceof net.rustmine.claim.ToolCupboardEntity.Contents && !self.field_7871.method_5437(self.method_34266(), stack)) {
/* 21 */       cir.setReturnValue(Boolean.valueOf(false));
/*    */     } 
/*    */   }
/*    */   
/*    */   @Inject(method = {"method_7674"}, at = {@At("HEAD")}, cancellable = true)
/*    */   private void rustmine$mayPickup(class_1657 player, CallbackInfoReturnable<Boolean> cir) {
/* 27 */     class_1735 self = (class_1735)this;
/* 28 */     if (!RustSlotFilter.isAllowedSlot(self)) {
/* 29 */       cir.setReturnValue(Boolean.valueOf(false));
/*    */     }
/*    */   }
/*    */   
/*    */   @Inject(method = {"method_7682"}, at = {@At("HEAD")}, cancellable = true)
/*    */   private void rustmine$isActive(CallbackInfoReturnable<Boolean> cir) {
/* 35 */     class_1735 self = (class_1735)this;
/* 36 */     if (!RustSlotFilter.isAllowedSlot(self)) {
/* 37 */       cir.setReturnValue(Boolean.valueOf(false));
/*    */     }
/*    */   }
/*    */   
/*    */   @Inject(method = {"method_32754"}, at = {@At("HEAD")}, cancellable = true)
/*    */   private void rustmine$allowModification(class_1657 player, CallbackInfoReturnable<Boolean> cir) {
/* 43 */     class_1735 self = (class_1735)this;
/* 44 */     if (!RustSlotFilter.isAllowedSlot(self)) {
/* 45 */       cir.setReturnValue(Boolean.valueOf(false));
/*    */     }
/*    */   }
/*    */   
/*    */   @Inject(method = {"method_7675()I"}, at = {@At("HEAD")}, cancellable = true)
/*    */   private void rustmine$getMaxStack(CallbackInfoReturnable<Integer> cir) {
/* 51 */     class_1735 self = (class_1735)this;
/* 52 */     if (!RustSlotFilter.isAllowedSlot(self)) {
/* 53 */       cir.setReturnValue(Integer.valueOf(0));
/*    */     } else {
/* 55 */       cir.setReturnValue(Integer.valueOf(1000));
/*    */     } 
/*    */   }
/*    */   
/*    */   @Inject(method = {"method_7676(Lnet/minecraft/class_1799;)I"}, at = {@At("HEAD")}, cancellable = true)
/*    */   private void rustmine$slotCustomMaxStack(class_1799 stack, CallbackInfoReturnable<Integer> cir) {
/* 61 */     class_1735 self = (class_1735)this;
/* 62 */     if (!RustSlotFilter.isAllowedSlot(self)) {
/* 63 */       cir.setReturnValue(Integer.valueOf(0));
/*    */       return;
/*    */     } 
/* 66 */     int custom = RustStacks.getMaxStack(stack.method_7909());
/* 67 */     if (custom > 0)
/* 68 */       cir.setReturnValue(Integer.valueOf(custom)); 
/*    */   }
/*    */ }


/* Location:              C:\Users\SystemX\AppData\Local\IceCubeRust\game\mods\rustmine-0.1.2.jar!\net\rustmine\mixin\SlotMixin.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */
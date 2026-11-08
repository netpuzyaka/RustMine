/*    */ package net.rustmine.mixin;
/*    */ 
/*    */ import net.minecraft.class_1657;
/*    */ import net.minecraft.class_1703;
/*    */ import net.minecraft.class_1713;
/*    */ import net.minecraft.class_1735;
/*    */ import net.minecraft.class_2371;
/*    */ import net.rustmine.inventory.RustSlotFilter;
/*    */ import org.spongepowered.asm.mixin.Final;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.Shadow;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ import org.spongepowered.asm.mixin.injection.Inject;
/*    */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
/*    */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
/*    */ 
/*    */ 
/*    */ @Mixin({class_1703.class})
/*    */ abstract class AbstractContainerMenuMixin
/*    */ {
/*    */   @Inject(method = {"method_7593"}, at = {@At("HEAD")}, cancellable = true)
/*    */   private void rustmine$onSlotClicked(int slotIndex, int button, class_1713 clickType, class_1657 player, CallbackInfo ci) {
/* 23 */     if (slotIndex >= 0 && slotIndex < this.field_7761.size()) {
/* 24 */       class_1735 s = (class_1735)this.field_7761.get(slotIndex);
/* 25 */       if (!RustSlotFilter.isAllowedSlot(s))
/* 26 */         ci.cancel(); 
/*    */     } 
/*    */   } @Shadow
/*    */   @Final
/*    */   public class_2371<class_1735> field_7761;
/*    */   @Inject(method = {"method_7615"}, at = {@At("HEAD")}, cancellable = true)
/*    */   private void rustmine$canDragTo(class_1735 slot, CallbackInfoReturnable<Boolean> cir) {
/* 33 */     if (!RustSlotFilter.isAllowedSlot(slot))
/* 34 */       cir.setReturnValue(Boolean.valueOf(false)); 
/*    */   }
/*    */ }


/* Location:              C:\Users\SystemX\AppData\Local\IceCubeRust\game\mods\rustmine-0.1.2.jar!\net\rustmine\mixin\AbstractContainerMenuMixin.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */
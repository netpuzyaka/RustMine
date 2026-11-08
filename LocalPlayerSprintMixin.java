/*    */ package net.rustmine.client.mixin;
/*    */ import net.fabricmc.api.EnvType;
/*    */ import net.minecraft.class_241;
/*    */ import net.minecraft.class_310;
/*    */ import net.minecraft.class_746;
/*    */ import net.rustmine.client.ClientRustWounded;
/*    */ import net.rustmine.client.RustSprintInput;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ import org.spongepowered.asm.mixin.injection.Inject;
/*    */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
/*    */ 
/*    */ @Environment(EnvType.CLIENT)
/*    */ @Mixin({class_746.class})
/*    */ abstract class LocalPlayerSprintMixin {
/*    */   @Inject(method = {"method_48300"}, at = {@At("RETURN")}, cancellable = true)
/*    */   private void rustmine$heldStart(CallbackInfoReturnable<Boolean> cir) {
/* 18 */     class_746 self = (class_746)this;
/* 19 */     if (RustSprintInput.landMovement(self)) cir.setReturnValue(Boolean.valueOf((cir.getReturnValueZ() && RustSprintInput.held(self)))); 
/*    */   }
/*    */   
/*    */   @Inject(method = {"method_65949"}, at = {@At("RETURN")}, cancellable = true)
/*    */   private void rustmine$heldStop(CallbackInfoReturnable<Boolean> cir) {
/* 24 */     class_746 self = (class_746)this;
/* 25 */     if (RustSprintInput.landMovement(self)) cir.setReturnValue(Boolean.valueOf((cir.getReturnValueZ() || !RustSprintInput.held(self)))); 
/*    */   }
/*    */   
/*    */   @ModifyArg(method = {"method_67270"}, at = @At(value = "INVOKE", target = "Lnet/minecraft/class_241;method_35582(F)Lnet/minecraft/class_241;", ordinal = 2), index = 0)
/*    */   private float rustmine$crouchSpeed(float factor) {
/* 30 */     class_746 self = (class_746)this;
/* 31 */     return (RustSprintInput.landMovement(self) && self.method_18276()) ? RustSprint.crouchInput(factor) : factor;
/*    */   }
/*    */ 
/*    */   
/*    */   @Inject(method = {"method_67271"}, at = {@At("HEAD")}, cancellable = true)
/*    */   private static void rustmine$equalDiagonalSpeed(class_241 input, CallbackInfoReturnable<class_241> cir) {
/* 37 */     if (ClientRustWounded.isLocalWounded() && ClientRustWounded.isLocalLooted()) {
/* 38 */       cir.setReturnValue(class_241.field_1340);
/*    */       return;
/*    */     } 
/* 41 */     if (RustSprintInput.landMovement((class_310.method_1551()).field_1724)) cir.setReturnValue(input); 
/*    */   }
/*    */ }


/* Location:              C:\Users\SystemX\AppData\Local\IceCubeRust\game\mods\rustmine-0.1.2.jar!\net\rustmine\client\mixin\LocalPlayerSprintMixin.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */
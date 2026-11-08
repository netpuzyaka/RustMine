/*    */ package net.rustmine.mixin;
/*    */ import net.minecraft.class_1657;
/*    */ import net.rustmine.RustSprint;
/*    */ import net.rustmine.RustWearManager;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ import org.spongepowered.asm.mixin.injection.Inject;
/*    */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
/*    */ 
/*    */ @Mixin({class_1657.class})
/*    */ abstract class PlayerSprintMixin {
/*    */   @Inject(method = {"method_6029"}, at = {@At("RETURN")}, cancellable = true)
/*    */   private void rustmine$groundSpeed(CallbackInfoReturnable<Float> cir) {
/* 14 */     class_1657 self = (class_1657)this;
/* 15 */     if (RustSprint.landMovement((self.method_31549()).field_7479, (self.method_5799() || self.method_5771()), self.method_5765(), (self
/* 16 */         .method_6128() || self.method_20448() || self.method_6101()))) {
/* 17 */       float speed = RustSprint.movementSpeed(cir.getReturnValueF(), self.method_5624(), self.method_18276());
/* 18 */       float armorMult = RustWearManager.getSpeedMultiplier(self);
/* 19 */       cir.setReturnValue(Float.valueOf(speed * armorMult));
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\SystemX\AppData\Local\IceCubeRust\game\mods\rustmine-0.1.2.jar!\net\rustmine\mixin\PlayerSprintMixin.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */
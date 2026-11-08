/*    */ package net.rustmine.mixin;
/*    */ 
/*    */ import net.minecraft.class_11890;
/*    */ import net.minecraft.class_4048;
/*    */ import net.minecraft.class_4050;
/*    */ import net.rustmine.RustCrouch;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ import org.spongepowered.asm.mixin.injection.Inject;
/*    */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
/*    */ 
/*    */ @Mixin({class_11890.class})
/*    */ abstract class AvatarMixin
/*    */ {
/*    */   @Inject(method = {"method_55694"}, at = {@At("RETURN")}, cancellable = true)
/*    */   private void rustmine$rustCrouch(class_4050 pose, CallbackInfoReturnable<class_4048> cir) {
/* 17 */     if (pose == class_4050.field_18081) cir.setReturnValue(RustCrouch.DIMENSIONS); 
/*    */   }
/*    */ }


/* Location:              C:\Users\SystemX\AppData\Local\IceCubeRust\game\mods\rustmine-0.1.2.jar!\net\rustmine\mixin\AvatarMixin.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */
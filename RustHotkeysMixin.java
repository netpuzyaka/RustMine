/*    */ package net.rustmine.client.mixin;
/*    */ import net.fabricmc.api.EnvType;
/*    */ import net.minecraft.class_11908;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ import org.spongepowered.asm.mixin.injection.Inject;
/*    */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
/*    */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
/*    */ 
/*    */ @Environment(EnvType.CLIENT)
/*    */ @Mixin({class_309.class})
/*    */ abstract class RustHotkeysMixin {
/*    */   @Inject(method = {"method_1468"}, at = {@At("HEAD")}, cancellable = true, require = 1)
/*    */   private void rustmine$disableF3Debug(class_11908 event, CallbackInfoReturnable<Boolean> cir) {
/* 15 */     cir.setReturnValue(Boolean.valueOf(true));
/*    */   }
/*    */   
/*    */   @Inject(method = {"method_35696"}, at = {@At("HEAD")}, cancellable = true, require = 1)
/*    */   private void rustmine$disableChunkDebug(class_11908 event, CallbackInfoReturnable<Boolean> cir) {
/* 20 */     cir.setReturnValue(Boolean.valueOf(true));
/*    */   }
/*    */   
/*    */   @Inject(method = {"method_1466"}, at = {@At("HEAD")}, cancellable = true, require = 1)
/*    */   private void rustmine$disableNarratorCombo(long window, int action, class_11908 event, CallbackInfo ci) {
/* 25 */     if (event.comp_4795() == 66 && (event.comp_4797() & 0x2) != 0)
/* 26 */       ci.cancel(); 
/*    */   }
/*    */ }


/* Location:              C:\Users\SystemX\AppData\Local\IceCubeRust\game\mods\rustmine-0.1.2.jar!\net\rustmine\client\mixin\RustHotkeysMixin.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */
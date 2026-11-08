/*    */ package net.rustmine.client.mixin;
/*    */ 
/*    */ import net.fabricmc.api.EnvType;
/*    */ import net.fabricmc.api.Environment;
/*    */ import net.minecraft.class_2561;
/*    */ import net.minecraft.class_310;
/*    */ import net.minecraft.class_329;
/*    */ import net.minecraft.class_332;
/*    */ import net.minecraft.class_9779;
/*    */ import net.rustmine.client.RustHud;
/*    */ import net.rustmine.client.rustui.RustHudUi;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ import org.spongepowered.asm.mixin.injection.Inject;
/*    */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
/*    */ 
/*    */ 
/*    */ @Environment(EnvType.CLIENT)
/*    */ @Mixin({class_329.class})
/*    */ abstract class GuiMixin
/*    */ {
/*    */   @Inject(method = {"method_1736"}, at = {@At("HEAD")}, cancellable = true)
/*    */   private void rustmine$noCrosshair(class_332 graphics, class_9779 delta, CallbackInfo ci) {
/* 24 */     ci.cancel();
/*    */   }
/*    */   
/*    */   @Inject(method = {"method_55805"}, at = {@At("HEAD")}, cancellable = true)
/*    */   private void rustmine$cancelVanillaHotbar(class_332 graphics, class_9779 delta, CallbackInfo ci) {
/* 29 */     ci.cancel();
/*    */   }
/*    */   
/*    */   @Inject(method = {"method_1760"}, at = {@At("HEAD")}, cancellable = true)
/*    */   private void rustmine$cancelVanillaHealth(class_332 graphics, CallbackInfo ci) {
/* 34 */     ci.cancel();
/*    */   }
/*    */   
/*    */   @Inject(method = {"method_1765"}, at = {@At("HEAD")}, cancellable = true)
/*    */   private void rustmine$cancelVanillaEffects(class_332 graphics, class_9779 delta, CallbackInfo ci) {
/* 39 */     ci.cancel();
/*    */   }
/*    */ 
/*    */   
/*    */   @Inject(method = {"method_1758"}, at = {@At("HEAD")})
/*    */   private void rustmine$captureTip(class_2561 message, boolean animate, CallbackInfo ci) {
/* 45 */     RustHudUi.showTip(message, 60);
/*    */   }
/*    */   
/*    */   @Inject(method = {"method_55800"}, at = {@At("HEAD")}, cancellable = true)
/*    */   private void rustmine$noOverlayMessage(class_332 graphics, class_9779 delta, CallbackInfo ci) {
/* 50 */     if (RustHudUi.available()) ci.cancel(); 
/*    */   }
/*    */   
/*    */   @Inject(method = {"method_1753"}, at = {@At("TAIL")})
/*    */   private void rustmine$renderRustHud(class_332 graphics, class_9779 delta, CallbackInfo ci) {
/* 55 */     class_310 mc = class_310.method_1551();
/* 56 */     if (mc.field_1755 == null && !mc.field_1690.field_1842)
/* 57 */       RustHud.render(graphics, delta); 
/*    */   }
/*    */ }


/* Location:              C:\Users\SystemX\AppData\Local\IceCubeRust\game\mods\rustmine-0.1.2.jar!\net\rustmine\client\mixin\GuiMixin.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */
/*    */ package net.rustmine.client.mixin;
/*    */ 
/*    */ import net.fabricmc.api.EnvType;
/*    */ import net.fabricmc.api.Environment;
/*    */ import net.minecraft.class_11908;
/*    */ import net.minecraft.class_11909;
/*    */ import net.minecraft.class_342;
/*    */ import net.minecraft.class_408;
/*    */ import net.rustmine.client.chat.RustChatControls;
/*    */ import net.rustmine.client.rustui.RustChatUi;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.Shadow;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ import org.spongepowered.asm.mixin.injection.Inject;
/*    */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
/*    */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
/*    */ 
/*    */ @Environment(EnvType.CLIENT)
/*    */ @Mixin({class_408.class})
/*    */ abstract class ChatScreenMixin
/*    */ {
/*    */   @Inject(method = {"method_25426"}, at = {@At("TAIL")})
/*    */   private void rustmine$initChat(CallbackInfo ci) {
/* 24 */     RustChatControls.configure((class_408)this, this.field_2382);
/*    */   } @Shadow
/*    */   protected class_342 field_2382;
/*    */   @Inject(method = {"method_25402"}, at = {@At("HEAD")}, cancellable = true)
/*    */   private void rustmine$clickChatControls(class_11909 event, boolean doubleClick, CallbackInfoReturnable<Boolean> cir) {
/* 29 */     if (RustChatControls.click((class_408)this, this.field_2382, event.comp_4798(), event.comp_4799(), event.method_74245())) {
/* 30 */       cir.setReturnValue(Boolean.valueOf(true));
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   @Inject(method = {"method_25404"}, at = {@At("HEAD")}, cancellable = true)
/*    */   private void rustmine$tabChannel(class_11908 event, CallbackInfoReturnable<Boolean> cir) {
/* 37 */     if (event.comp_4795() == 258 && RustChatControls.tab(this.field_2382)) cir.setReturnValue(Boolean.valueOf(true));
/*    */   
/*    */   }
/*    */   
/*    */   @Inject(method = {"method_25401"}, at = {@At("HEAD")}, cancellable = true)
/*    */   private void rustmine$scrollChat(double mouseX, double mouseY, double scrollX, double scrollY, CallbackInfoReturnable<Boolean> cir) {
/* 43 */     if (RustChatUi.available()) {
/* 44 */       RustChatUi.scroll(scrollY);
/* 45 */       cir.setReturnValue(Boolean.valueOf(true));
/*    */     } 
/*    */   }
/*    */   
/*    */   @Inject(method = {"method_44056"}, at = {@At("HEAD")}, cancellable = true)
/*    */   private void rustmine$handleChatInput(String message, boolean addToHistory, CallbackInfo ci) {
/* 51 */     if (RustChatControls.handleSend(message, addToHistory))
/* 52 */       ci.cancel(); 
/*    */   }
/*    */ }


/* Location:              C:\Users\SystemX\AppData\Local\IceCubeRust\game\mods\rustmine-0.1.2.jar!\net\rustmine\client\mixin\ChatScreenMixin.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */
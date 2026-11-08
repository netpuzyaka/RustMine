/*    */ package net.rustmine.client.mixin;
/*    */ import net.fabricmc.api.EnvType;
/*    */ import net.minecraft.class_2561;
/*    */ import net.minecraft.class_327;
/*    */ import net.minecraft.class_332;
/*    */ import net.minecraft.class_338;
/*    */ import net.minecraft.class_7591;
/*    */ import net.rustmine.client.chat.RustChatHud;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ import org.spongepowered.asm.mixin.injection.Inject;
/*    */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
/*    */ 
/*    */ @Environment(EnvType.CLIENT)
/*    */ @Mixin({class_338.class})
/*    */ abstract class ChatComponentMixin {
/*    */   @Inject(method = {"method_75804"}, at = {@At("HEAD")}, cancellable = true)
/*    */   private void rustmine$renderRustChat(class_332 graphics, class_327 font, int currentTick, int mouseX, int mouseY, boolean focused, boolean isChatFocused, CallbackInfo ci) {
/* 19 */     if (RustChatHud.render(graphics, font, currentTick, mouseX, mouseY, (focused || isChatFocused))) {
/* 20 */       ci.cancel();
/*    */     }
/*    */   }
/*    */   
/*    */   @Inject(method = {"method_44811(Lnet/minecraft/class_2561;Lnet/minecraft/class_7469;Lnet/minecraft/class_7591;)V"}, at = {@At("HEAD")})
/*    */   private void rustmine$captureMessage(class_2561 message, class_7469 signature, class_7591 tag, CallbackInfo ci) {
/* 26 */     RustChatHud.onMessage(message);
/*    */   }
/*    */ }


/* Location:              C:\Users\SystemX\AppData\Local\IceCubeRust\game\mods\rustmine-0.1.2.jar!\net\rustmine\client\mixin\ChatComponentMixin.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */
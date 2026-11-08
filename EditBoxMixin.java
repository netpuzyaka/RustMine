/*    */ package net.rustmine.client.mixin;
/*    */ import net.fabricmc.api.EnvType;
/*    */ import net.fabricmc.api.Environment;
/*    */ import net.minecraft.class_342;
/*    */ import net.rustmine.client.chat.RustChatControls;
/*    */ import net.rustmine.client.rustui.RustChatUi;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ import org.spongepowered.asm.mixin.injection.Inject;
/*    */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
/*    */ 
/*    */ @Environment(EnvType.CLIENT)
/*    */ @Mixin({class_342.class})
/*    */ abstract class EditBoxMixin {
/*    */   @Inject(method = {"method_48579"}, at = {@At("HEAD")}, cancellable = true)
/*    */   private void rustmine$hideChatInput(class_332 graphics, int mouseX, int mouseY, float partialTick, CallbackInfo ci) {
/* 17 */     if (RustChatControls.isChatInput((class_342)this) && RustChatUi.available()) ci.cancel(); 
/*    */   }
/*    */ }


/* Location:              C:\Users\SystemX\AppData\Local\IceCubeRust\game\mods\rustmine-0.1.2.jar!\net\rustmine\client\mixin\EditBoxMixin.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */
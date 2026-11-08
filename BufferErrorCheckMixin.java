/*    */ package net.rustmine.client.mixin;
/*    */ 
/*    */ import net.fabricmc.api.EnvType;
/*    */ import net.fabricmc.api.Environment;
/*    */ import net.minecraft.class_10865;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ import org.spongepowered.asm.mixin.injection.Redirect;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Environment(EnvType.CLIENT)
/*    */ @Mixin({class_10865.class})
/*    */ abstract class BufferErrorCheckMixin
/*    */ {
/*    */   @Redirect(method = {"createBuffer"}, at = @At(value = "INVOKE", target = "Lcom/mojang/blaze3d/opengl/GlStateManager;clearGlErrors()V"), require = 1)
/*    */   private void rustmine$noClear() {}
/*    */   
/*    */   @Redirect(method = {"createBuffer"}, at = @At(value = "INVOKE", target = "Lcom/mojang/blaze3d/opengl/GlStateManager;_getError()I"), require = 1)
/*    */   private int rustmine$noError() {
/* 22 */     return 0;
/*    */   }
/*    */ }


/* Location:              C:\Users\SystemX\AppData\Local\IceCubeRust\game\mods\rustmine-0.1.2.jar!\net\rustmine\client\mixin\BufferErrorCheckMixin.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */
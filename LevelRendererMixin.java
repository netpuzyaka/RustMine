/*    */ package net.rustmine.client.mixin;
/*    */ import com.mojang.blaze3d.buffers.GpuBufferSlice;
/*    */ import net.fabricmc.api.EnvType;
/*    */ import net.fabricmc.api.Environment;
/*    */ import net.minecraft.class_4184;
/*    */ import net.minecraft.class_761;
/*    */ import net.minecraft.class_9779;
/*    */ import net.minecraft.class_9922;
/*    */ import net.rustmine.client.render.srp.Srp;
/*    */ import net.rustmine.client.render.srp.SrpFrame;
/*    */ import org.joml.Matrix4f;
/*    */ import org.joml.Vector4f;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ import org.spongepowered.asm.mixin.injection.Inject;
/*    */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
/*    */ 
/*    */ @Environment(EnvType.CLIENT)
/*    */ @Mixin({class_761.class})
/*    */ abstract class LevelRendererMixin {
/*    */   @Inject(method = {"method_22710"}, at = {@At("HEAD")})
/*    */   private void rustmine$captureMatrices(class_9922 allocator, class_9779 deltaTracker, boolean renderBlockOutline, class_4184 camera, Matrix4f view, Matrix4f projection, Matrix4f cullingProjection, GpuBufferSlice fog, Vector4f fogColor, boolean renderSky, CallbackInfo ci) {
/* 23 */     SrpFrame.capture(view, projection);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @Inject(method = {"method_3295(IIIZ)V"}, at = {@At("HEAD")})
/*    */   private void rustmine$shadowSectionDirty(int sx, int sy, int sz, boolean reRenderOnMainThread, CallbackInfo ci) {
/* 33 */     Srp.sectionDirty(sx, sy, sz);
/*    */   }
/*    */ }


/* Location:              C:\Users\SystemX\AppData\Local\IceCubeRust\game\mods\rustmine-0.1.2.jar!\net\rustmine\client\mixin\LevelRendererMixin.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */
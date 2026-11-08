/*    */ package net.rustmine.client.mixin;
/*    */ import net.fabricmc.api.EnvType;
/*    */ import net.fabricmc.api.Environment;
/*    */ import net.minecraft.class_757;
/*    */ import net.rustmine.client.farterrain.FarTerrain;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
/*    */ 
/*    */ @Environment(EnvType.CLIENT)
/*    */ @Mixin({class_757.class})
/*    */ abstract class FarTerrainDepthMixin {
/*    */   @Inject(method = {"method_32796"}, at = {@At("RETURN")}, cancellable = true)
/*    */   private void rustmine$farTerrainDepth(CallbackInfoReturnable<Float> cir) {
/* 15 */     cir.setReturnValue(Float.valueOf(FarTerrain.depthFar(cir.getReturnValueF())));
/*    */   }
/*    */ }


/* Location:              C:\Users\SystemX\AppData\Local\IceCubeRust\game\mods\rustmine-0.1.2.jar!\net\rustmine\client\mixin\FarTerrainDepthMixin.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */
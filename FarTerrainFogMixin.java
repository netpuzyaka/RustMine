/*    */ package net.rustmine.client.mixin;
/*    */ 
/*    */ import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
/*    */ import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
/*    */ import java.nio.ByteBuffer;
/*    */ import net.fabricmc.api.EnvType;
/*    */ import net.fabricmc.api.Environment;
/*    */ import net.minecraft.class_758;
/*    */ import net.rustmine.client.farterrain.FarTerrain;
/*    */ import org.joml.Vector4f;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ 
/*    */ 
/*    */ 
/*    */ @Environment(EnvType.CLIENT)
/*    */ @Mixin({class_758.class})
/*    */ abstract class FarTerrainFogMixin
/*    */ {
/*    */   @WrapOperation(method = {"method_3211"}, at = {@At(value = "INVOKE", target = "Lnet/minecraft/class_758;method_71110(Ljava/nio/ByteBuffer;ILorg/joml/Vector4f;FFFFFF)V")})
/*    */   private void rustmine$farTerrainFog(class_758 self, ByteBuffer buf, int offset, Vector4f color, float envStart, float envEnd, float renderStart, float renderEnd, float skyEnd, float cloudEnd, Operation<Void> original) {
/* 22 */     original.call(new Object[] { self, buf, Integer.valueOf(offset), color, Float.valueOf(envStart), Float.valueOf(envEnd), Float.valueOf(FarTerrain.fogStart(renderStart, renderEnd)), Float.valueOf(FarTerrain.fogEnd(renderEnd)), Float.valueOf(skyEnd), Float.valueOf(cloudEnd) });
/*    */   }
/*    */ }


/* Location:              C:\Users\SystemX\AppData\Local\IceCubeRust\game\mods\rustmine-0.1.2.jar!\net\rustmine\client\mixin\FarTerrainFogMixin.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */
/*    */ package net.rustmine.client.mixin;
/*    */ import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
/*    */ import java.util.List;
/*    */ import java.util.concurrent.Executor;
/*    */ import net.fabricmc.api.EnvType;
/*    */ import net.fabricmc.api.Environment;
/*    */ import net.minecraft.class_1059;
/*    */ import net.minecraft.class_148;
/*    */ import net.minecraft.class_2960;
/*    */ import net.minecraft.class_7764;
/*    */ import net.minecraft.class_7766;
/*    */ import net.rustmine.client.render.AtlasFit;
/*    */ import org.slf4j.Logger;
/*    */ import org.slf4j.LoggerFactory;
/*    */ import org.spongepowered.asm.mixin.Final;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.Shadow;
/*    */ import org.spongepowered.asm.mixin.Unique;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ import org.spongepowered.asm.mixin.injection.Redirect;
/*    */ 
/*    */ @Environment(EnvType.CLIENT)
/*    */ @Mixin({class_7766.class})
/*    */ abstract class SpriteLoaderFitMixin {
/*    */   @Unique
/* 26 */   private static final Logger RUSTMINE_LOG = LoggerFactory.getLogger("rustmine"); @Shadow
/*    */   @Final
/*    */   private class_2960 field_40549; @Shadow
/*    */   @Final
/*    */   private int field_40550;
/*    */   
/*    */   @WrapMethod(method = {"method_47663"})
/*    */   private class_7766.class_7767 rustmine$fit(List<class_7764> sprites, int mipLevel, Executor executor, Operation<class_7766.class_7767> original) {
/*    */     try {
/* 35 */       return (class_7766.class_7767)original.call(new Object[] { sprites, Integer.valueOf(mipLevel), executor });
/* 36 */     } catch (class_148 e) {
/* 37 */       if (!(e.getCause() instanceof net.minecraft.class_1054)) throw e; 
/* 38 */       class_148 failure = e;
/*    */       
/* 40 */       List<class_7764> current = sprites;
/* 41 */       for (int cap : AtlasFit.CAPS) {
/* 42 */         current = AtlasFit.capped(current, cap);
/*    */         try {
/* 44 */           class_7766.class_7767 result = (class_7766.class_7767)original.call(new Object[] { current, Integer.valueOf(mipLevel), executor });
/* 45 */           RUSTMINE_LOG.warn("atlas {} doesn't fit the video card's limit of {}: the mod's textures are limited to {} pixels", new Object[] { this.field_40549, Integer.valueOf(this.field_40550), Integer.valueOf(cap) });
/* 46 */           return result;
/* 47 */         } catch (class_148 class_148) {
/* 48 */           if (!(class_148.getCause() instanceof net.minecraft.class_1054)) throw class_148; 
/* 49 */           failure = class_148;
/*    */         } 
/*    */       } 
/* 52 */       throw failure;
/*    */     } 
/*    */   }
/*    */   @Redirect(method = {"method_45837"}, at = @At(value = "INVOKE", target = "Lnet/minecraft/class_1059;method_45850()I"))
/*    */   private static int rustmine$limit(class_1059 atlas) {
/* 57 */     return AtlasFit.maxAtlasSize(atlas.method_45850());
/*    */   }
/*    */ }


/* Location:              C:\Users\SystemX\AppData\Local\IceCubeRust\game\mods\rustmine-0.1.2.jar!\net\rustmine\client\mixin\SpriteLoaderFitMixin.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */
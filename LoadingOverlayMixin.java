/*    */ package net.rustmine.client.mixin;
/*    */ 
/*    */ import com.mojang.blaze3d.pipeline.RenderPipeline;
/*    */ import java.io.InputStream;
/*    */ import java.util.function.IntSupplier;
/*    */ import net.fabricmc.api.EnvType;
/*    */ import net.fabricmc.api.Environment;
/*    */ import net.minecraft.class_1011;
/*    */ import net.minecraft.class_10537;
/*    */ import net.minecraft.class_10539;
/*    */ import net.minecraft.class_1060;
/*    */ import net.minecraft.class_10799;
/*    */ import net.minecraft.class_1084;
/*    */ import net.minecraft.class_12253;
/*    */ import net.minecraft.class_2960;
/*    */ import net.minecraft.class_3300;
/*    */ import net.minecraft.class_332;
/*    */ import net.minecraft.class_425;
/*    */ import net.rustmine.RustmineMod;
/*    */ import net.rustmine.vault.Vault;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.Unique;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ import org.spongepowered.asm.mixin.injection.Inject;
/*    */ import org.spongepowered.asm.mixin.injection.Redirect;
/*    */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
/*    */ 
/*    */ @Environment(EnvType.CLIENT)
/*    */ @Mixin({class_425.class})
/*    */ abstract class LoadingOverlayMixin {
/*    */   @Unique
/* 32 */   private static final class_2960 RUSTMINE_LOGO = RustmineMod.id("loading_logo");
/*    */   @Unique
/*    */   private static final int RUSTMINE_BACKGROUND = -16315112;
/*    */   
/*    */   @Inject(method = {"method_18819"}, at = {@At("TAIL")})
/*    */   private static void rustmine$registerLogo(class_1060 textures, CallbackInfo ci) {
/* 38 */     textures.method_65876(RUSTMINE_LOGO, new class_10537(RUSTMINE_LOGO)
/*    */         {
/*    */           public class_10539 method_65809(class_3300 resources) {
/* 41 */             InputStream in = Vault.open("assets/rustmine/textures/gui/menu_logo.png");
/* 42 */             if (in == null) {
/* 43 */               in = LoadingOverlayMixin.class.getResourceAsStream("/assets/rustmine/textures/gui/menu_logo.png");
/*    */             }
/* 45 */             if (in != null) {
/* 46 */               try { InputStream stream = in; 
/* 47 */                 try { class_10539 class_10539 = new class_10539(class_1011.method_4309(stream), new class_1084(true, true, class_12253.field_64077, 0.0F));
/* 48 */                   if (stream != null) stream.close();  return class_10539; } catch (Throwable throwable) { if (stream != null) try { stream.close(); } catch (Throwable throwable1) { throwable.addSuppressed(throwable1); }   throw throwable; }  } catch (Exception exception) {}
/*    */             }
/* 50 */             return new class_10539(new class_1011(1, 1, true), new class_1084(true, true, class_12253.field_64077, 0.0F));
/*    */           }
/*    */         });
/*    */   }
/*    */   
/*    */   @Redirect(method = {"method_25394"}, at = @At(value = "INVOKE", target = "Ljava/util/function/IntSupplier;getAsInt()I"))
/*    */   private int rustmine$background(IntSupplier brand) {
/* 57 */     return -16315112;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @Redirect(method = {"method_25394"}, at = @At(value = "INVOKE", ordinal = 0, target = "Lnet/minecraft/class_332;method_25293(Lcom/mojang/blaze3d/pipeline/RenderPipeline;Lnet/minecraft/class_2960;IIFFIIIIIII)V"))
/*    */   private void rustmine$logo(class_332 g, RenderPipeline pipeline, class_2960 id, int x, int y, float u, float v, int w, int h, int uw, int vh, int tw, int th, int color) {
/* 65 */     int cx = x + w, cy = y + h / 2, size = h * 2;
/* 66 */     g.method_25293(class_10799.field_56883, RUSTMINE_LOGO, cx - size / 2, cy - size / 2, 0.0F, 0.0F, size, size, 256, 256, 256, 256, color);
/*    */   }
/*    */   
/*    */   @Redirect(method = {"method_25394"}, at = @At(value = "INVOKE", ordinal = 1, target = "Lnet/minecraft/class_332;method_25293(Lcom/mojang/blaze3d/pipeline/RenderPipeline;Lnet/minecraft/class_2960;IIFFIIIIIII)V"))
/*    */   private void rustmine$noLogoRight(class_332 g, RenderPipeline pipeline, class_2960 id, int x, int y, float u, float v, int w, int h, int uw, int vh, int tw, int th, int color) {}
/*    */ }


/* Location:              C:\Users\SystemX\AppData\Local\IceCubeRust\game\mods\rustmine-0.1.2.jar!\net\rustmine\client\mixin\LoadingOverlayMixin.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */
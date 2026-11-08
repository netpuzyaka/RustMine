/*    */ package net.rustmine.client.mixin;
/*    */ import net.fabricmc.api.EnvType;
/*    */ import net.minecraft.class_310;
/*    */ import net.rustmine.client.menu.IceMusic;
/*    */ import net.rustmine.client.menu.InGameMusic;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
/*    */ 
/*    */ @Environment(EnvType.CLIENT)
/*    */ @Mixin({class_1142.class})
/*    */ abstract class MusicManagerMixin {
/*    */   @Inject(method = {"method_18669"}, at = {@At("HEAD")}, cancellable = true)
/*    */   private void rustmine$iceTheme(CallbackInfo ci) {
/* 15 */     class_310 mc = class_310.method_1551();
/* 16 */     if (mc.field_1687 == null) {
/* 17 */       InGameMusic.reset();
/* 18 */       IceMusic.tick(mc);
/*    */     } else {
/* 20 */       InGameMusic.tick(mc);
/* 21 */       IceMusic.tick(mc);
/*    */     } 
/* 23 */     ci.cancel();
/*    */   }
/*    */ }


/* Location:              C:\Users\SystemX\AppData\Local\IceCubeRust\game\mods\rustmine-0.1.2.jar!\net\rustmine\client\mixin\MusicManagerMixin.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */
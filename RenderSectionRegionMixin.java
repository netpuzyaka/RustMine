/*    */ package net.rustmine.client.mixin;
/*    */ import net.fabricmc.api.EnvType;
/*    */ import net.fabricmc.api.Environment;
/*    */ import net.minecraft.class_2338;
/*    */ import net.minecraft.class_2680;
/*    */ import net.minecraft.class_853;
/*    */ import net.rustmine.decor.Decor;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ import org.spongepowered.asm.mixin.injection.Inject;
/*    */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
/*    */ 
/*    */ @Environment(EnvType.CLIENT)
/*    */ @Mixin({class_853.class})
/*    */ abstract class RenderSectionRegionMixin {
/*    */   @Inject(method = {"method_8320"}, at = {@At("HEAD")}, cancellable = true)
/*    */   private void rustmine$hideAnchor(class_2338 pos, CallbackInfoReturnable<class_2680> cir) {
/* 18 */     if (Decor.clientAnchored(pos)) cir.setReturnValue(class_2246.field_10124.method_9564()); 
/*    */   }
/*    */ }


/* Location:              C:\Users\SystemX\AppData\Local\IceCubeRust\game\mods\rustmine-0.1.2.jar!\net\rustmine\client\mixin\RenderSectionRegionMixin.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */
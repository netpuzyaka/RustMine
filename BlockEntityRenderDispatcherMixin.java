/*    */ package net.rustmine.client.mixin;
/*    */ import net.fabricmc.api.EnvType;
/*    */ import net.fabricmc.api.Environment;
/*    */ import net.minecraft.class_11683;
/*    */ import net.minecraft.class_11954;
/*    */ import net.minecraft.class_2586;
/*    */ import net.minecraft.class_824;
/*    */ import net.rustmine.client.decor.DecorClient;
/*    */ import net.rustmine.decor.Decor;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ import org.spongepowered.asm.mixin.injection.Inject;
/*    */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
/*    */ 
/*    */ @Environment(EnvType.CLIENT)
/*    */ @Mixin({class_824.class})
/*    */ abstract class BlockEntityRenderDispatcherMixin {
/*    */   @Inject(method = {"method_74348"}, at = {@At("HEAD")}, cancellable = true)
/*    */   private void rustmine$hideAnchor(class_2586 be, float partialTick, class_11683.class_11792 crumbling, CallbackInfoReturnable<class_11954> cir) {
/* 20 */     if (!DecorClient.drawingDecor && Decor.clientAnchored(be.method_11016())) cir.setReturnValue(null); 
/*    */   }
/*    */ }


/* Location:              C:\Users\SystemX\AppData\Local\IceCubeRust\game\mods\rustmine-0.1.2.jar!\net\rustmine\client\mixin\BlockEntityRenderDispatcherMixin.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */
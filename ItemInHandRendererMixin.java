/*    */ package net.rustmine.client.mixin;
/*    */ 
/*    */ import net.fabricmc.api.EnvType;
/*    */ import net.fabricmc.api.Environment;
/*    */ import net.minecraft.class_11659;
/*    */ import net.minecraft.class_1268;
/*    */ import net.minecraft.class_1306;
/*    */ import net.minecraft.class_1799;
/*    */ import net.minecraft.class_4587;
/*    */ import net.minecraft.class_742;
/*    */ import net.minecraft.class_759;
/*    */ import net.rustmine.client.Gun;
/*    */ import net.rustmine.client.RustmineClient;
/*    */ import net.rustmine.client.ViewmodelRenderer;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.Shadow;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ import org.spongepowered.asm.mixin.injection.Inject;
/*    */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
/*    */ 
/*    */ 
/*    */ 
/*    */ @Environment(EnvType.CLIENT)
/*    */ @Mixin({class_759.class})
/*    */ abstract class ItemInHandRendererMixin
/*    */ {
/*    */   @Shadow
/*    */   private void method_3219(class_4587 pose, class_11659 collector, int light, float equipProgress, float swingProgress, class_1306 arm) {}
/*    */   
/*    */   @Inject(method = {"method_3228"}, at = {@At("HEAD")}, cancellable = true)
/*    */   private void rustmine$renderAk(class_742 player, float partialTick, float pitch, class_1268 hand, float swing, class_1799 stack, float equip, class_4587 pose, class_11659 collector, int light, CallbackInfo ci) {
/* 32 */     Gun gun = (hand == class_1268.field_5808) ? RustmineClient.gunFor(stack) : null;
/* 33 */     if (gun != null) {
/* 34 */       ViewmodelRenderer.render(gun, pose, collector, light, partialTick);
/* 35 */       ci.cancel();
/* 36 */     } else if (hand == class_1268.field_5808) {
/* 37 */       ci.cancel();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\SystemX\AppData\Local\IceCubeRust\game\mods\rustmine-0.1.2.jar!\net\rustmine\client\mixin\ItemInHandRendererMixin.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */
/*    */ package net.rustmine.client.mixin;
/*    */ import net.fabricmc.api.EnvType;
/*    */ import net.minecraft.class_10017;
/*    */ import net.minecraft.class_124;
/*    */ import net.minecraft.class_1297;
/*    */ import net.minecraft.class_1657;
/*    */ import net.minecraft.class_2561;
/*    */ import net.minecraft.class_310;
/*    */ import net.minecraft.class_765;
/*    */ import net.minecraft.class_897;
/*    */ import net.rustmine.voice.client.party.ClientPartyManager;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ import org.spongepowered.asm.mixin.injection.Inject;
/*    */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
/*    */ 
/*    */ @Environment(EnvType.CLIENT)
/*    */ @Mixin({class_897.class})
/*    */ abstract class EntityRendererMixin {
/*    */   @Inject(method = {"method_3933"}, at = {@At("HEAD")}, cancellable = true)
/*    */   private void rustmine$noRenderDead(class_1297 entity, class_4604 frustum, double x, double y, double z, CallbackInfoReturnable<Boolean> cir) {
/* 22 */     if (entity instanceof class_1657) { class_1657 player = (class_1657)entity; if (player.method_29504() || player.field_6213 > 0) {
/* 23 */         cir.setReturnValue(Boolean.valueOf(false));
/*    */       } }
/*    */   
/*    */   }
/*    */ 
/*    */   
/*    */   @Inject(method = {"method_72979"}, at = {@At("TAIL")})
/*    */   private void rustmine$noBlobShadow(class_10017 state, class_310 mc, class_1937 level, CallbackInfo ci) {
/* 31 */     if (Srp.sunShadows()) {
/* 32 */       state.field_61823.clear();
/* 33 */       state.field_61822 = 0.0F;
/*    */     } 
/*    */   }
/*    */   
/*    */   @Inject(method = {"method_24088"}, at = {@At("RETURN")}, cancellable = true)
/*    */   private void rustmine$buildingShade(class_1297 entity, float partialTick, CallbackInfoReturnable<Integer> cir) {
/* 39 */     if (entity instanceof net.rustmine.building.BuildingEntity)
/* 40 */       return;  int light = cir.getReturnValueI(), sky = class_765.method_24187(light);
/* 41 */     if (sky == 0)
/* 42 */       return;  float f = BuildLight.skyFactor(entity.method_73183(), entity.method_5829().method_1005());
/* 43 */     if (f < 1.0F) cir.setReturnValue(Integer.valueOf(class_765.method_23687(class_765.method_24186(light), Math.round(sky * f)))); 
/*    */   }
/*    */   
/*    */   @Inject(method = {"method_62426"}, at = {@At("RETURN")}, cancellable = true)
/*    */   private void rustmine$teammateGreen(class_1297 entity, CallbackInfoReturnable<class_2561> cir) {
/* 48 */     if (entity instanceof class_1657) { class_1657 player = (class_1657)entity; if (ClientPartyManager.getInstance().isMember(player.method_5667()))
/* 49 */         cir.setReturnValue(player.method_5477().method_27661().method_27692(class_124.field_1060));  }
/*    */   
/*    */   }
/*    */ }


/* Location:              C:\Users\SystemX\AppData\Local\IceCubeRust\game\mods\rustmine-0.1.2.jar!\net\rustmine\client\mixin\EntityRendererMixin.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */
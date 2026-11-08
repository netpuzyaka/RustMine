/*    */ package net.rustmine.client.mixin;
/*    */ import net.minecraft.class_10055;
/*    */ import net.minecraft.class_11890;
/*    */ import net.minecraft.class_12075;
/*    */ import net.minecraft.class_4587;
/*    */ import net.rustmine.client.RustPlayers;
/*    */ import net.rustmine.client.death.TeamWorldMarkers;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ import org.spongepowered.asm.mixin.injection.Inject;
/*    */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
/*    */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
/*    */ 
/*    */ @Environment(EnvType.CLIENT)
/*    */ @Mixin({class_1007.class})
/*    */ abstract class AvatarRendererMixin {
/*    */   @Inject(method = {"method_62604(Lnet/minecraft/class_11890;Lnet/minecraft/class_10055;F)V"}, at = {@At("TAIL")})
/*    */   private void rustmine$animate(class_11890 avatar, class_10055 state, float partialTick, CallbackInfo ci) {
/* 18 */     RustPlayers.extract(avatar, state, partialTick);
/* 19 */     TeamWorldMarkers.extract(avatar, state);
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 24 */     state.field_53337 = null;
/* 25 */     state.field_53525 = null;
/*    */   }
/*    */   
/*    */   @Inject(method = {"method_4213(Lnet/minecraft/class_10055;Lnet/minecraft/class_4587;Lnet/minecraft/class_11659;Lnet/minecraft/class_12075;)V"}, at = {@At("HEAD")}, cancellable = true)
/*    */   private void rustmine$submitTeamMarker(class_10055 state, class_4587 pose, class_11659 out, class_12075 camera, CallbackInfo ci) {
/* 30 */     if (TeamWorldMarkers.submit((class_10017)state, pose, out, camera)) {
/* 31 */       ci.cancel();
/*    */     }
/*    */   }
/*    */   
/*    */   @Inject(method = {"method_62606(Lnet/minecraft/class_10055;)Z"}, at = {@At("HEAD")}, cancellable = true)
/*    */   private void rustmine$noLayers(class_10055 state, CallbackInfoReturnable<Boolean> cir) {
/* 37 */     if (state.field_53460 || state.field_53449 > 0.0F || RustPlayers.active(state)) cir.setReturnValue(Boolean.valueOf(false));
/*    */   
/*    */   }
/*    */   
/*    */   @Inject(method = {"method_74935(Lnet/minecraft/class_11890;D)Z"}, at = {@At("HEAD")}, cancellable = true)
/*    */   private void rustmine$onlyTeammateNames(class_11890 avatar, double distanceSq, CallbackInfoReturnable<Boolean> cir) {
/* 43 */     cir.setReturnValue(Boolean.valueOf((distanceSq < 4096.0D && avatar != (class_310.method_1551()).field_1724 && 
/* 44 */           ClientPartyManager.getInstance().isMember(avatar.method_5667()))));
/*    */   }
/*    */ }


/* Location:              C:\Users\SystemX\AppData\Local\IceCubeRust\game\mods\rustmine-0.1.2.jar!\net\rustmine\client\mixin\AvatarRendererMixin.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */
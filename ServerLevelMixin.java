/*    */ package net.rustmine.mixin;
/*    */ 
/*    */ import net.minecraft.class_1297;
/*    */ import net.minecraft.class_3218;
/*    */ import net.rustmine.world.NoVanillaMobs;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ import org.spongepowered.asm.mixin.injection.Inject;
/*    */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
/*    */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
/*    */ 
/*    */ 
/*    */ @Mixin({class_3218.class})
/*    */ abstract class ServerLevelMixin
/*    */ {
/*    */   @Inject(method = {"method_29202"}, at = {@At("HEAD")}, cancellable = true)
/*    */   private void rustmine$noCustomSpawners(boolean spawnFriendlies, CallbackInfo ci) {
/* 18 */     ci.cancel();
/*    */   }
/*    */ 
/*    */   
/*    */   @Inject(method = {"method_8649"}, at = {@At("HEAD")}, cancellable = true)
/*    */   private void rustmine$noVanillaMobs(class_1297 entity, CallbackInfoReturnable<Boolean> cir) {
/* 24 */     if (NoVanillaMobs.isVanillaMob(entity)) cir.setReturnValue(Boolean.valueOf(false));
/*    */   
/*    */   }
/*    */   
/*    */   @Inject(method = {"method_39501"}, at = {@At("HEAD")})
/*    */   private void rustmine$clearSky(CallbackInfo ci) {
/* 30 */     class_3218 level = (class_3218)this;
/* 31 */     if (level.method_8419() || level.method_8546() || level.method_8430(1.0F) > 0.0F || level.method_8478(1.0F) > 0.0F)
/* 32 */       level.method_27910(12000, 0, false, false); 
/*    */   }
/*    */ }


/* Location:              C:\Users\SystemX\AppData\Local\IceCubeRust\game\mods\rustmine-0.1.2.jar!\net\rustmine\mixin\ServerLevelMixin.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */
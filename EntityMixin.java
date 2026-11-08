/*    */ package net.rustmine.mixin;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import net.minecraft.class_1297;
/*    */ import net.minecraft.class_1313;
/*    */ import net.minecraft.class_1937;
/*    */ import net.minecraft.class_238;
/*    */ import net.minecraft.class_243;
/*    */ import net.minecraft.class_265;
/*    */ import net.minecraft.class_2680;
/*    */ import net.rustmine.building.BuildingCollision;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ import org.spongepowered.asm.mixin.injection.Inject;
/*    */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
/*    */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
/*    */ 
/*    */ @Mixin({class_1297.class})
/*    */ abstract class EntityMixin {
/*    */   @Inject(method = {"method_5790"}, at = {@At("HEAD")}, cancellable = true)
/*    */   private void rustmine$noSprintSwim(CallbackInfo ci) {
/* 22 */     class_1297 self = (class_1297)this;
/* 23 */     if (self instanceof net.minecraft.class_1657) {
/* 24 */       if (self.method_5681()) self.method_5796(false); 
/* 25 */       ci.cancel();
/*    */     } 
/*    */   }
/*    */   
/*    */   @Inject(method = {"method_5784"}, at = {@At("TAIL")})
/*    */   private void rustmine$slopeContact(class_1313 type, class_243 movement, CallbackInfo ci) {
/* 31 */     class_1297 self = (class_1297)this;
/* 32 */     if (!self.field_5960 && movement.field_1351 <= 0.0D && (self.method_18798()).field_1351 <= 0.0D && (type == class_1313.field_6308 || type == class_1313.field_6305) && 
/*    */       
/* 34 */       BuildingCollision.supportedSlope(self.method_73183(), self.method_5829())) {
/* 35 */       self.method_60607(true, self.field_5976, movement);
/* 36 */       self.method_18799(self.method_18798().method_18805(1.0D, 0.0D, 1.0D));
/* 37 */       self.method_38785();
/*    */     } 
/*    */   }
/*    */   @Inject(method = {"method_17835"}, at = {@At("RETURN")}, cancellable = true)
/*    */   private void rustmine$buildingCollision(class_243 movement, CallbackInfoReturnable<class_243> cir) {
/* 42 */     class_243 result = (class_243)cir.getReturnValue();
/* 43 */     class_243 clipped = BuildingCollision.clip((class_1297)this, result);
/* 44 */     if (clipped != result) cir.setReturnValue(clipped); 
/*    */   }
/*    */   
/*    */   @Inject(method = {"method_59920"}, at = {@At("RETURN")}, cancellable = true)
/*    */   private static void rustmine$meshColliders(class_1297 entity, class_1937 level, List<class_265> list, class_238 aABB, CallbackInfoReturnable<List<class_265>> cir) {
/* 49 */     List<class_265> meshShapes = MeshColliderManager.getCollisions(level, entity, aABB);
/* 50 */     if (!meshShapes.isEmpty()) {
/* 51 */       List<class_265> existing = (List<class_265>)cir.getReturnValue();
/* 52 */       List<class_265> merged = new ArrayList<>(existing.size() + meshShapes.size());
/* 53 */       merged.addAll(existing);
/* 54 */       merged.addAll(meshShapes);
/* 55 */       cir.setReturnValue(merged);
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   @Inject(method = {"method_5876"}, at = {@At("HEAD")}, cancellable = true)
/*    */   private void rustmine$staticNoFluid(CallbackInfoReturnable<Boolean> cir) {
/* 62 */     Object self = this;
/* 63 */     if (self instanceof net.rustmine.building.DoorEntity || self instanceof net.rustmine.building.BuildingEntity || self instanceof net.rustmine.monument.RustCrateEntity || self instanceof net.rustmine.deploy.RustDeployableEntity || self instanceof net.rustmine.monument.baked.MonumentDoorEntity || self instanceof net.rustmine.claim.ToolCupboardEntity || self instanceof net.rustmine.respawn.SleepingBagEntity || self instanceof net.rustmine.decor.DecorEntity || self instanceof net.rustmine.resource.RustOreNodeEntity || self instanceof net.rustmine.monument.RustPropEntity)
/*    */     {
/*    */ 
/*    */ 
/*    */       
/* 68 */       cir.setReturnValue(Boolean.valueOf(false));
/*    */     }
/*    */   }
/*    */   
/*    */   @Inject(method = {"method_51297"}, at = {@At("HEAD")}, cancellable = true)
/*    */   private void rustmine$noVanillaSteps(class_2338 pos, class_2680 state, CallbackInfo ci) {
/* 74 */     if (this instanceof net.minecraft.class_1657) ci.cancel(); 
/*    */   }
/*    */ }


/* Location:              C:\Users\SystemX\AppData\Local\IceCubeRust\game\mods\rustmine-0.1.2.jar!\net\rustmine\mixin\EntityMixin.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */
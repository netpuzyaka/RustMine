/*    */ package net.rustmine.mixin;
/*    */ 
/*    */ import net.minecraft.class_1313;
/*    */ import net.minecraft.class_1657;
/*    */ import net.minecraft.class_238;
/*    */ import net.minecraft.class_243;
/*    */ import net.minecraft.class_4050;
/*    */ import net.rustmine.building.BuildingCollision;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ import org.spongepowered.asm.mixin.injection.Inject;
/*    */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Mixin({class_1657.class})
/*    */ abstract class PlayerMixin
/*    */ {
/*    */   @Inject(method = {"method_18796"}, at = {@At("HEAD")}, cancellable = true)
/*    */   private void rustmine$enterFrameOpening(class_243 movement, class_1313 type, CallbackInfoReturnable<class_243> cir) {
/* 22 */     class_1657 self = (class_1657)this;
/* 23 */     if (self.method_24828() && self.method_5715() && !(self.method_31549()).field_7479 && movement.field_1351 <= 0.0D && (type == class_1313.field_6308 || type == class_1313.field_6305) && 
/*    */       
/* 25 */       BuildingCollision.internalOpening(self.method_73183(), self.method_5829(), movement)) cir.setReturnValue(movement);
/*    */   
/*    */   }
/*    */   
/*    */   @Inject(method = {"method_52558"}, at = {@At("RETURN")}, cancellable = true)
/*    */   private void rustmine$roomAmongBuildings(class_4050 pose, CallbackInfoReturnable<Boolean> cir) {
/* 31 */     if (!cir.getReturnValueZ())
/* 32 */       return;  class_1657 self = (class_1657)this;
/* 33 */     if (BuildingCollision.intersects(self.method_73183(), self.method_18377(pose).method_30757(self.method_73189()).method_1011(1.0E-4D))) cir.setReturnValue(Boolean.valueOf(false)); 
/*    */   }
/*    */   
/*    */   @Inject(method = {"method_59818"}, at = {@At("RETURN")}, cancellable = true)
/*    */   private void rustmine$buildingsHoldYou(double dx, double dz, double depth, CallbackInfoReturnable<Boolean> cir) {
/* 38 */     if (!cir.getReturnValueZ())
/* 39 */       return;  class_1657 self = (class_1657)this;
/* 40 */     class_238 b = self.method_5829();
/* 41 */     class_238 below = new class_238(b.field_1323 + 1.0E-7D + dx, b.field_1322 - depth - 1.0E-7D, b.field_1321 + 1.0E-7D + dz, b.field_1320 - 1.0E-7D + dx, b.field_1322, b.field_1324 - 1.0E-7D + dz);
/* 42 */     if (BuildingCollision.intersects(self.method_73183(), below)) cir.setReturnValue(Boolean.valueOf(false)); 
/*    */   }
/*    */   
/*    */   @Inject(method = {"method_21824"}, at = {@At("HEAD")}, cancellable = true)
/*    */   private void rustminicopter$noDismountOnShift(CallbackInfoReturnable<Boolean> cir) {
/* 47 */     class_1657 self = (class_1657)this;
/* 48 */     if (self.method_5854() instanceof com.rustminicopter.entity.MinicopterEntity)
/* 49 */       cir.setReturnValue(Boolean.valueOf(false)); 
/*    */   }
/*    */ }


/* Location:              C:\Users\SystemX\AppData\Local\IceCubeRust\game\mods\rustmine-0.1.2.jar!\net\rustmine\mixin\PlayerMixin.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */
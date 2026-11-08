/*     */ package net.rustmine.client.mixin;
/*     */ import com.rustminicopter.entity.MinicopterEntity;
/*     */ import net.minecraft.class_1297;
/*     */ import net.minecraft.class_310;
/*     */ import net.minecraft.class_4184;
/*     */ import net.minecraft.class_4587;
/*     */ import net.minecraft.class_757;
/*     */ import net.minecraft.class_7833;
/*     */ import net.rustmine.client.Gun;
/*     */ import net.rustmine.client.Viewmodel;
/*     */ import net.rustmine.client.render.srp.Srp;
/*     */ import org.joml.Matrix4f;
/*     */ import org.joml.Quaternionfc;
/*     */ import org.joml.Vector3f;
/*     */ import org.spongepowered.asm.mixin.Unique;
/*     */ import org.spongepowered.asm.mixin.injection.At;
/*     */ import org.spongepowered.asm.mixin.injection.Inject;
/*     */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
/*     */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
/*     */ 
/*     */ @Environment(EnvType.CLIENT)
/*     */ @Mixin({class_757.class})
/*     */ abstract class GameRendererMixin {
/*     */   @Unique
/*  25 */   private static final Vector3f rustmine$euler = new Vector3f(); @Unique
/*     */   private static boolean rustmine$worldBob;
/*     */   @Unique
/*     */   private static Gun rustmine$gun() {
/*  29 */     return RustmineClient.held((class_310.method_1551()).field_1724);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Unique
/*  36 */   private static final Vector3f rustmine$camShown = new Vector3f(); @Unique private static final Vector3f rustmine$camFrom = new Vector3f();
/*     */   @Unique
/*     */   private static Viewmodel rustmine$camVm;
/*     */   @Unique
/*     */   private static int rustmine$camPlays;
/*     */   @Unique
/*     */   private static long rustmine$camStart;
/*     */   @Unique
/*  44 */   private static float rustmine$camBlend = 0.25F;
/*     */ 
/*     */ 
/*     */   
/*     */   @WrapOperation(method = {"method_3188"}, at = {@At(value = "INVOKE", target = "Lnet/minecraft/class_757;method_3186(Lnet/minecraft/class_4587;F)V")})
/*     */   private void rustmine$worldBob(class_757 self, class_4587 pose, float partialTick, Operation<Void> original) {
/*  50 */     rustmine$worldBob = true;
/*     */     try {
/*  52 */       original.call(new Object[] { self, pose, Float.valueOf(partialTick) });
/*     */     } finally {
/*  54 */       rustmine$worldBob = false;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Inject(method = {"method_3186"}, at = {@At("HEAD")}, cancellable = true)
/*     */   private void rustmine$noHandBob(class_4587 pose, float partialTick, CallbackInfo ci) {
/*  64 */     if (!rustmine$worldBob && RustmineClient.holding((class_310.method_1551()).field_1724)) ci.cancel();
/*     */   
/*     */   }
/*     */   
/*     */   @Inject(method = {"method_3198"}, at = {@At("HEAD")}, cancellable = true)
/*     */   private void rustmine$cameraAnimation(class_4587 pose, float partialTick, CallbackInfo ci) {
/*  70 */     class_310 mc = class_310.method_1551();
/*  71 */     class_1297 class_1297 = mc.method_1560(); if (class_1297 instanceof class_1309) { class_1309 le = (class_1309)class_1297; if (le.method_29504()) {
/*  72 */         ci.cancel(); return;
/*     */       }  }
/*     */     
/*  75 */     Gun gun = rustmine$gun();
/*  76 */     Viewmodel vm = (gun == null) ? null : gun.loadedViewmodel();
/*  77 */     if (vm == null || !vm.cameraEuler(rustmine$euler)) rustmine$euler.zero();
/*     */     
/*  79 */     int plays = (vm == null) ? 0 : vm.plays();
/*  80 */     long now = System.nanoTime();
/*  81 */     if (vm != rustmine$camVm || plays != rustmine$camPlays) {
/*  82 */       rustmine$camBlend = (vm != rustmine$camVm) ? 0.25F : Math.max(0.05F, vm.fadeSeconds());
/*  83 */       rustmine$camVm = vm;
/*  84 */       rustmine$camPlays = plays;
/*  85 */       rustmine$camFrom.set((Vector3fc)rustmine$camShown);
/*  86 */       rustmine$camStart = now;
/*     */     } 
/*  88 */     float t = Math.min(1.0F, (float)(now - rustmine$camStart) / 1.0E9F / rustmine$camBlend);
/*  89 */     rustmine$camFrom.lerp((Vector3fc)rustmine$euler, t * t * (3.0F - 2.0F * t), rustmine$camShown);
/*  90 */     if (rustmine$camShown.lengthSquared() > 1.0E-8F) {
/*  91 */       pose.method_22907((Quaternionfc)class_7833.field_40718.rotationDegrees(rustmine$camShown.z));
/*  92 */       pose.method_22907((Quaternionfc)class_7833.field_40714.rotationDegrees(rustmine$camShown.x));
/*  93 */       pose.method_22907((Quaternionfc)class_7833.field_40716.rotationDegrees(rustmine$camShown.y));
/*     */     } 
/*     */     
/*  96 */     if (mc.field_1724 != null) { class_1297 class_12971 = mc.field_1724.method_5854(); if (class_12971 instanceof MinicopterEntity) { MinicopterEntity copter = (MinicopterEntity)class_12971;
/*  97 */         if (mc.field_1690.method_31044().method_31034())
/*  98 */           if (copter.getPilot() == mc.field_1724 && !RustMinicopterClient.isFreeLook()) {
/*  99 */             float roll = class_3532.method_16439(partialTick, copter.prevRoll, copter.getRollAngle());
/* 100 */             if (Math.abs(roll) > 0.01F) {
/* 101 */               pose.method_22907((Quaternionfc)class_7833.field_40718.rotationDegrees(-roll));
/*     */             }
/*     */           } else {
/*     */             
/* 105 */             class_4184 cam = mc.field_1773.method_19418();
/* 106 */             float roll = SeatLook.riderRoll(copter, cam.method_19330(), cam.method_19329(), partialTick);
/* 107 */             if (Math.abs(roll) > 0.01F) pose.method_22907((Quaternionfc)class_7833.field_40718.rotationDegrees(roll));
/*     */           
/*     */           }   }
/*     */        }
/*     */   
/*     */   }
/*     */   
/*     */   @Inject(method = {"method_3196"}, at = {@At("RETURN")}, cancellable = true)
/*     */   private void rustmine$adsFov(class_4184 camera, float partialTick, boolean world, CallbackInfoReturnable<Float> cir) {
/* 116 */     Gun gun = rustmine$gun();
/* 117 */     if (gun != null && !world) {
/* 118 */       cir.setReturnValue(Float.valueOf(cir.getReturnValueF() * gun.handFovDegrees() / 70.0F));
/*     */       return;
/*     */     } 
/* 121 */     Viewmodel vm = (gun == null) ? null : gun.loadedViewmodel();
/* 122 */     if (vm == null)
/* 123 */       return;  float ads = vm.ads();
/* 124 */     if (ads > 0.0F) cir.setReturnValue(Float.valueOf(cir.getReturnValueF() / class_3532.method_16439(ads, 1.0F, gun.zoom())));
/*     */   
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @ModifyArg(method = {"method_3188(Lnet/minecraft/class_9779;)V"}, at = @At(value = "INVOKE", target = "Lnet/minecraft/class_11286;method_71123(Lorg/joml/Matrix4f;)Lcom/mojang/blaze3d/buffers/GpuBufferSlice;"))
/*     */   private Matrix4f rustmine$taaJitter(Matrix4f projection) {
/* 134 */     Srp.jitter(projection);
/* 135 */     return projection;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @Inject(method = {"method_3188(Lnet/minecraft/class_9779;)V"}, at = {@At(value = "INVOKE", target = "Lnet/minecraft/class_765;method_3313(F)V", shift = At.Shift.AFTER)})
/*     */   private void rustmine$boostLightmap(class_9779 deltaTracker, CallbackInfo ci) {
/* 142 */     Srp.boostLightmap();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @ModifyArg(method = {"method_3172"}, at = @At(value = "INVOKE", target = "Lnet/minecraft/class_759;method_22976(FLnet/minecraft/class_4587;Lnet/minecraft/class_11659;Lnet/minecraft/class_746;I)V"), index = 4)
/*     */   private int rustmine$carriedHandLight(int packedLight) {
/* 150 */     return Srp.handLight(packedLight);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Inject(method = {"method_3188(Lnet/minecraft/class_9779;)V"}, at = {@At(value = "INVOKE", target = "Lnet/minecraft/class_761;method_22710(Lnet/minecraft/class_9922;Lnet/minecraft/class_9779;ZLnet/minecraft/class_4184;Lorg/joml/Matrix4f;Lorg/joml/Matrix4f;Lorg/joml/Matrix4f;Lcom/mojang/blaze3d/buffers/GpuBufferSlice;Lorg/joml/Vector4f;Z)V", shift = At.Shift.AFTER)})
/*     */   private void rustmine$postProcess(class_9779 deltaTracker, CallbackInfo ci) {
/* 158 */     Srp.finish(deltaTracker.method_60637(false));
/*     */   }
/*     */ }


/* Location:              C:\Users\SystemX\AppData\Local\IceCubeRust\game\mods\rustmine-0.1.2.jar!\net\rustmine\client\mixin\GameRendererMixin.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */
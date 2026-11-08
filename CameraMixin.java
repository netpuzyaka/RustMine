/*     */ package net.rustmine.client.mixin;
/*     */ import com.rustminicopter.client.RustMinicopterClient;
/*     */ import com.rustminicopter.entity.MinicopterEntity;
/*     */ import net.fabricmc.api.EnvType;
/*     */ import net.fabricmc.api.Environment;
/*     */ import net.minecraft.class_1297;
/*     */ import net.minecraft.class_1657;
/*     */ import net.minecraft.class_1937;
/*     */ import net.minecraft.class_243;
/*     */ import net.minecraft.class_3532;
/*     */ import net.minecraft.class_4184;
/*     */ import net.minecraft.class_746;
/*     */ import net.rustmine.client.ClientRustSleep;
/*     */ import net.rustmine.client.SeatLook;
/*     */ import net.rustmine.seat.MountRules;
/*     */ import org.spongepowered.asm.mixin.Mixin;
/*     */ import org.spongepowered.asm.mixin.Shadow;
/*     */ import org.spongepowered.asm.mixin.injection.At;
/*     */ import org.spongepowered.asm.mixin.injection.Inject;
/*     */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
/*     */ 
/*     */ @Environment(EnvType.CLIENT)
/*     */ @Mixin({class_4184.class})
/*     */ abstract class CameraMixin {
/*     */   @Shadow
/*     */   protected abstract void method_19327(double paramDouble1, double paramDouble2, double paramDouble3);
/*     */   
/*     */   @Inject(method = {"method_19321"}, at = {@At("RETURN")})
/*     */   private void rustminicopter$alignPilotCamera(class_1937 area, class_1297 focusedEntity, boolean thirdPerson, boolean inverseView, float partialTicks, CallbackInfo ci) {
/*  30 */     if (!thirdPerson && ClientRustSleep.isSleeping() && focusedEntity != null) {
/*  31 */       double px = class_3532.method_16436(partialTicks, focusedEntity.field_6014, focusedEntity.method_23317());
/*  32 */       double py = class_3532.method_16436(partialTicks, focusedEntity.field_6036, focusedEntity.method_23318()) + 0.22D;
/*  33 */       double pz = class_3532.method_16436(partialTicks, focusedEntity.field_5969, focusedEntity.method_23321());
/*  34 */       method_19327(px, py, pz);
/*     */       return;
/*     */     } 
/*  37 */     if (focusedEntity instanceof class_1657) { class_1657 player = (class_1657)focusedEntity; class_1297 class_12971 = player.method_5854(); if (class_12971 instanceof MinicopterEntity) { MinicopterEntity copter = (MinicopterEntity)class_12971;
/*  38 */         boolean isPilot = (copter.getPilot() == player);
/*     */         
/*  40 */         double copterX = class_3532.method_16436(partialTicks, copter.field_6014, copter.method_23317());
/*  41 */         double copterY = class_3532.method_16436(partialTicks, copter.field_6036, copter.method_23318());
/*  42 */         double copterZ = class_3532.method_16436(partialTicks, copter.field_5969, copter.method_23321());
/*     */ 
/*     */         
/*  45 */         float yaw = class_3532.method_17821(partialTicks, copter.field_5982, copter.method_36454());
/*  46 */         float pitch = class_3532.method_16439(partialTicks, copter.prevPitch, copter.getPitchAngle());
/*  47 */         float roll = class_3532.method_16439(partialTicks, copter.prevRoll, copter.getRollAngle());
/*     */         
/*  49 */         boolean freeLook = RustMinicopterClient.isFreeLook();
/*  50 */         boolean isScrap = copter instanceof com.rustminicopter.entity.ScrapHeliEntity;
/*     */         
/*  52 */         if (!thirdPerson) {
/*     */           double localX, localY, localZ;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*  59 */           int seat = copter.getSeatIndex((class_1297)player);
/*  60 */           if (isScrap) {  }
/*     */           else {  }
/*  62 */            class_243 fallback = new class_243(0.0D, (seat == 0) ? 1.05D : 0.78D, (seat == 0) ? 0.65D : 1.62D);
/*  63 */           class_243 so = SeatConfig.getOffset(isScrap ? "scrapheli" : "minicopter", seat, fallback);
/*  64 */           if (isScrap && seat <= 1) {
/*     */             
/*  66 */             localX = (seat == 0) ? 0.62D : -0.62D;
/*  67 */             localY = 1.95D;
/*  68 */             localZ = 2.45D;
/*  69 */           } else if (!isScrap) {
/*     */ 
/*     */             
/*  72 */             float[] eye = MountRules.seat("minicopter", seat).eye();
/*  73 */             localX = (eye != null) ? eye[0] : 0.0D;
/*  74 */             localY = (eye != null) ? eye[1] : ((seat == 0) ? 1.75D : 1.48D);
/*  75 */             localZ = (eye != null) ? eye[2] : ((seat == 0) ? 0.35D : 1.62D);
/*     */           } else {
/*     */             
/*  78 */             localX = so.field_1352;
/*  79 */             localY = so.field_1351 + 0.72D;
/*  80 */             localZ = so.field_1350;
/*     */           } 
/*     */           
/*  83 */           float yawRad = yaw * 0.017453292F;
/*  84 */           float pitchRad = pitch * 0.017453292F;
/*  85 */           float rollRad = roll * 0.017453292F;
/*     */ 
/*     */           
/*  88 */           double x1 = localX * class_3532.method_15362(rollRad) + localY * class_3532.method_15374(rollRad);
/*  89 */           double y1 = -localX * class_3532.method_15374(rollRad) + localY * class_3532.method_15362(rollRad);
/*  90 */           double z1 = localZ;
/*     */ 
/*     */           
/*  93 */           double x2 = x1;
/*  94 */           double y2 = y1 * class_3532.method_15362(pitchRad) - z1 * class_3532.method_15374(pitchRad);
/*  95 */           double z2 = y1 * class_3532.method_15374(pitchRad) + z1 * class_3532.method_15362(pitchRad);
/*     */ 
/*     */           
/*  98 */           double x3 = x2 * class_3532.method_15362(yawRad) - z2 * class_3532.method_15374(yawRad);
/*  99 */           double y3 = y2;
/* 100 */           double z3 = x2 * class_3532.method_15374(yawRad) + z2 * class_3532.method_15362(yawRad);
/*     */           
/* 102 */           method_19327(copterX + x3, copterY + y3, copterZ + z3);
/*     */           
/* 104 */           class_746 lp = (class_746)player;
/* 105 */           float[] seatLook = (!isPilot && player instanceof class_746) ? SeatLook.camera(lp, partialTicks) : null;
/* 106 */           if (seatLook != null) {
/*     */             
/* 108 */             method_19325(seatLook[0], seatLook[1]);
/* 109 */           } else if (!freeLook) {
/* 110 */             method_19325(yaw, pitch);
/*     */           } else {
/* 112 */             float freeYaw = class_3532.method_17821(partialTicks, player.field_5982, player.method_36454());
/* 113 */             float freePitch = class_3532.method_16439(partialTicks, player.field_6004, player.method_36455());
/* 114 */             method_19325(freeYaw, freePitch);
/*     */           } 
/*     */         } else {
/*     */           
/* 118 */           double centerX = copterX;
/* 119 */           double centerY = copterY + (isScrap ? 1.8D : 1.15D);
/* 120 */           double centerZ = copterZ;
/*     */           
/* 122 */           boolean ownLook = (freeLook || !isPilot);
/* 123 */           float camYaw = ownLook ? class_3532.method_17821(partialTicks, player.field_5982, player.method_36454()) : yaw;
/* 124 */           float camPitch = ownLook ? class_3532.method_16439(partialTicks, player.field_6004, player.method_36455()) : pitch;
/*     */           
/* 126 */           float radYaw = -camYaw * 0.017453292F;
/* 127 */           float radPitch = camPitch * 0.017453292F;
/* 128 */           double dist = isScrap ? 8.5D : 4.6D;
/*     */           
/* 130 */           double camX = centerX - (class_3532.method_15374(radYaw) * class_3532.method_15362(radPitch)) * dist;
/* 131 */           double camY = centerY + class_3532.method_15374(radPitch) * dist;
/* 132 */           double camZ = centerZ - (class_3532.method_15362(radYaw) * class_3532.method_15362(radPitch)) * dist;
/*     */           
/* 134 */           method_19327(camX, camY, camZ);
/* 135 */           method_19325(camYaw, camPitch);
/*     */         }  }
/*     */        }
/*     */   
/*     */   }
/*     */   
/*     */   @Shadow
/*     */   protected abstract void method_19325(float paramFloat1, float paramFloat2);
/*     */ }


/* Location:              C:\Users\SystemX\AppData\Local\IceCubeRust\game\mods\rustmine-0.1.2.jar!\net\rustmine\client\mixin\CameraMixin.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */
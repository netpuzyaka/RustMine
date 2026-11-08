/*     */ package net.rustmine.client.mixin;
/*     */ import com.rustminicopter.client.RustMinicopterClient;
/*     */ import com.rustminicopter.entity.MinicopterEntity;
/*     */ import net.minecraft.class_1297;
/*     */ import net.minecraft.class_310;
/*     */ import net.rustmine.HoldRules;
/*     */ import net.rustmine.client.Gun;
/*     */ import net.rustmine.client.Viewmodel;
/*     */ import org.spongepowered.asm.mixin.Shadow;
/*     */ import org.spongepowered.asm.mixin.injection.At;
/*     */ import org.spongepowered.asm.mixin.injection.Inject;
/*     */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
/*     */ 
/*     */ @Environment(EnvType.CLIENT)
/*     */ @Mixin({class_312.class})
/*     */ abstract class MouseHandlerMixin {
/*     */   @Shadow
/*     */   private double field_1789;
/*     */   
/*     */   @Inject(method = {"method_1598"}, at = {@At("HEAD")})
/*     */   private void rustmine$scrollStart(long window, double xOffset, double yOffset, CallbackInfo ci) {
/*  22 */     HoldRules.scrolling(true);
/*     */   } @Shadow
/*     */   private double field_1787;
/*     */   @Inject(method = {"method_1598"}, at = {@At("RETURN")})
/*     */   private void rustmine$scrollEnd(long window, double xOffset, double yOffset, CallbackInfo ci) {
/*  27 */     HoldRules.scrolling(false);
/*     */   }
/*     */   
/*     */   @Inject(method = {"method_1606"}, at = {@At("HEAD")}, cancellable = true)
/*     */   private void rustmine$pieMenu(double time, CallbackInfo ci) {
/*  32 */     if (RadialMenu.isOpen()) {
/*  33 */       RadialMenu.mouse(this.field_1789, this.field_1787);
/*  34 */       this.field_1789 = 0.0D;
/*  35 */       this.field_1787 = 0.0D;
/*  36 */       ci.cancel();
/*     */       
/*     */       return;
/*     */     } 
/*  40 */     class_310 mc = class_310.method_1551();
/*  41 */     if (mc.field_1724 != null) { class_1297 class_1297 = mc.field_1724.method_5854(); if (class_1297 instanceof MinicopterEntity) { MinicopterEntity copter = (MinicopterEntity)class_1297; if (copter
/*  42 */           .getPilot() == mc.field_1724) {
/*  43 */           boolean freeLook = class_3675.method_15987(mc.method_22683(), 342);
/*  44 */           RustMinicopterClient.setFreeLook(freeLook);
/*     */           
/*  46 */           if (!freeLook) {
/*  47 */             double dx = this.field_1789;
/*  48 */             double dy = this.field_1787;
/*  49 */             this.field_1789 = 0.0D;
/*  50 */             this.field_1787 = 0.0D;
/*     */             
/*  52 */             double sens = ((Double)mc.field_1690.method_42495().method_41753()).doubleValue() * 0.6D + 0.2D;
/*  53 */             double sensFactor = sens * sens * sens * 8.0D;
/*  54 */             if (((Boolean)mc.field_1690.method_42438().method_41753()).booleanValue()) {
/*  55 */               dy = -dy;
/*     */             }
/*     */             
/*  58 */             RustMinicopterClient.addMouseTurn(dx * sensFactor, dy * sensFactor);
/*     */ 
/*     */             
/*  61 */             mc.field_1724.method_36456(copter.method_36454());
/*  62 */             mc.field_1724.method_36457(copter.getPitchAngle());
/*  63 */             mc.field_1724.method_5847(copter.method_36454());
/*  64 */             mc.field_1724.method_5636(copter.method_36454());
/*     */             
/*  66 */             ci.cancel();
/*     */             return;
/*     */           } 
/*     */         }  }
/*     */        }
/*     */     
/*  72 */     if (mc.field_1724 != null && mc.field_1755 == null) {
/*  73 */       Gun gun = RustmineClient.held(mc.field_1724);
/*  74 */       Viewmodel vm = (gun == null) ? null : gun.loadedViewmodel();
/*  75 */       float ads = (vm == null) ? 0.0F : vm.ads();
/*  76 */       if (ads > 0.0F) {
/*  77 */         double f = 1.0D + ((ControlSettings.get()).adsSensitivity - 1.0D) * ads;
/*  78 */         this.field_1789 *= f;
/*  79 */         this.field_1787 *= f;
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/*  84 */     if (mc.field_1724 != null && mc.field_1755 == null) { class_1297 class_1297 = mc.field_1724.method_5854(); if (class_1297 instanceof MinicopterEntity) { MinicopterEntity copter = (MinicopterEntity)class_1297; if (copter
/*  85 */           .getPilot() != mc.field_1724) {
/*  86 */           double sens = ((Double)mc.field_1690.method_42495().method_41753()).doubleValue() * 0.6D + 0.2D;
/*  87 */           double f = sens * sens * sens * 8.0D;
/*  88 */           double dy = this.field_1787 * f * (((Boolean)mc.field_1690.method_42438().method_41753()).booleanValue() ? -1 : true);
/*  89 */           if (SeatLook.turn(mc.field_1724, this.field_1789 * f, dy)) {
/*  90 */             this.field_1789 = 0.0D;
/*  91 */             this.field_1787 = 0.0D;
/*  92 */             ci.cancel();
/*     */           } 
/*     */         }  }
/*     */        }
/*     */   
/*     */   } @Inject(method = {"method_1598"}, at = {@At("HEAD")}, cancellable = true)
/*     */   private void rustmine$noScrollWhenWounded(long window, double xOffset, double yOffset, CallbackInfo ci) {
/*  99 */     if (ClientRustWounded.isLocalWounded())
/* 100 */       ci.cancel(); 
/*     */   }
/*     */ }


/* Location:              C:\Users\SystemX\AppData\Local\IceCubeRust\game\mods\rustmine-0.1.2.jar!\net\rustmine\client\mixin\MouseHandlerMixin.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */
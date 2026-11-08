/*     */ package net.rustmine.client.mixin;
/*     */ import net.minecraft.class_310;
/*     */ import net.minecraft.class_437;
/*     */ import net.minecraft.class_476;
/*     */ import net.minecraft.class_746;
/*     */ import net.rustmine.client.ClientRustSleep;
/*     */ import net.rustmine.client.ClientRustWounded;
/*     */ import org.spongepowered.asm.mixin.injection.At;
/*     */ import org.spongepowered.asm.mixin.injection.Inject;
/*     */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
/*     */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
/*     */ 
/*     */ @Environment(EnvType.CLIENT)
/*     */ @Mixin({class_310.class})
/*     */ abstract class MinecraftMixin {
/*     */   @ModifyVariable(method = {"method_1507"}, at = @At("HEAD"), argsOnly = true)
/*     */   private class_437 rustmine$iceMenus(class_437 screen) {
/*  18 */     return IceMenus.replace(((class_310)this).field_1755, screen);
/*     */   }
/*     */   
/*     */   @Inject(method = {"method_1536"}, at = {@At("HEAD")}, cancellable = true)
/*     */   private void rustmine$noAttack(CallbackInfoReturnable<Boolean> cir) {
/*  23 */     if (ClientRustWounded.isLocalWounded() || ClientRustSleep.isSleeping() || 
/*  24 */       VehicleSeats.handsBusy((class_1297)((class_310)this).field_1724)) {
/*  25 */       cir.setReturnValue(Boolean.valueOf(false));
/*     */       return;
/*     */     } 
/*  28 */     class_746 player = ((class_310)this).field_1724;
/*     */     
/*  30 */     if (RadialMenu.isOpen() || RadialMenu.swallowsAttack()) {
/*  31 */       cir.setReturnValue(Boolean.valueOf(false));
/*     */       return;
/*     */     } 
/*  34 */     if (RustmineClient.holding(player)) {
/*  35 */       RustmineClient.attackClicked(player);
/*  36 */       cir.setReturnValue(Boolean.valueOf(false));
/*     */       return;
/*     */     } 
/*  39 */     if (player.method_6047().method_31574(RustmineMod.C4) || player.method_6047().method_31574(RustmineMod.SATCHEL) || player.method_6047().method_31574(RustmineMod.BEANCAN)) {
/*  40 */       class_310 mc = (class_310)this;
/*  41 */       mc.field_1761.method_2919((class_1657)player, class_1268.field_5808);
/*  42 */       cir.setReturnValue(Boolean.valueOf(false));
/*     */     } 
/*     */   }
/*     */   
/*     */   @Inject(method = {"method_1590"}, at = {@At("HEAD")}, cancellable = true)
/*     */   private void rustmine$noMining(boolean attacking, CallbackInfo ci) {
/*  48 */     if (ClientRustWounded.isLocalWounded() || ClientRustSleep.isSleeping() || VehicleSeats.handsBusy((class_1297)((class_310)this).field_1724) || RustmineClient.holding(((class_310)this).field_1724) || RadialMenu.isOpen() || RadialMenu.swallowsAttack()) ci.cancel(); 
/*     */   }
/*     */   
/*     */   @Inject(method = {"method_1583"}, at = {@At("HEAD")}, cancellable = true)
/*     */   private void rustmine$noUse(CallbackInfo ci) {
/*  53 */     if (ClientRustWounded.isLocalWounded() || ClientRustSleep.isSleeping() || 
/*  54 */       VehicleSeats.handsBusy((class_1297)((class_310)this).field_1724)) {
/*  55 */       ci.cancel();
/*     */       return;
/*     */     } 
/*  58 */     Gun gun = RustmineClient.held(((class_310)this).field_1724);
/*  59 */     if (gun instanceof ExplosiveTool) { ExplosiveTool exp = (ExplosiveTool)gun;
/*  60 */       exp.click();
/*  61 */       ci.cancel();
/*     */       return; }
/*     */     
/*  64 */     if (gun != null || DecorClient.onUse()) ci.cancel(); 
/*     */   }
/*     */   
/*     */   private static boolean rustmine$tabWasDown = false;
/*     */   private static boolean rustmine$f1WasDown = false;
/*     */   
/*     */   @Inject(method = {"method_1507"}, at = {@At("HEAD")}, cancellable = true)
/*     */   private void rustmine$keepRespawnScreen(class_437 screen, CallbackInfo ci) {
/*  72 */     if (screen == null && ClientRustSleep.isSleeping()) {
/*  73 */       class_310 mc = (class_310)this;
/*  74 */       if (!(mc.field_1755 instanceof RustSleepingScreen)) {
/*  75 */         ci.cancel();
/*  76 */         mc.method_1507((class_437)new RustSleepingScreen());
/*     */         return;
/*     */       } 
/*     */     } 
/*  80 */     if (ClientRustSleep.isSleeping() && screen instanceof net.minecraft.class_465) {
/*  81 */       ci.cancel();
/*     */       return;
/*     */     } 
/*  84 */     if (screen instanceof net.minecraft.class_418)
/*  85 */     { ci.cancel();
/*  86 */       class_310 mc = (class_310)this;
/*  87 */       if (!(mc.field_1755 instanceof RustRespawnScreen)) {
/*  88 */         mc.method_1507((class_437)new RustRespawnScreen("[]"));
/*     */       } }
/*  90 */     else if ((screen instanceof net.minecraft.class_490 || screen instanceof net.minecraft.class_481) && !(screen instanceof RustInventoryScreen) && !(screen instanceof RustCreativeScreen))
/*     */     
/*     */     { 
/*     */       
/*  94 */       ci.cancel(); }
/*  95 */     else if (screen instanceof class_476) { class_476 cs = (class_476)screen; if (!(screen instanceof RustDeployableScreen)) {
/*  96 */         class_310 mc = (class_310)this;
/*  97 */         if (mc.field_1724 != null) {
/*  98 */           ci.cancel();
/*  99 */           mc.method_1507((class_437)new RustDeployableScreen((class_1707)cs.method_17577(), mc.field_1724.method_31548(), cs.method_25440()));
/*     */         } 
/*     */       }  }
/*     */   
/*     */   }
/*     */   @Inject(method = {"method_1508"}, at = {@At("HEAD")})
/*     */   private void rustmine$handleKeybinds(CallbackInfo ci) {
/* 106 */     class_310 mc = (class_310)this;
/*     */     
/* 108 */     while (mc.field_1690.field_1822.method_1436());
/*     */ 
/*     */     
/* 111 */     while (mc.field_1690.field_1831.method_1436()) {
/*     */       
/* 113 */       if (mc.field_1724 != null && mc.field_1755 == null) {
/* 114 */         ClientPlayNetworking.send((class_8710)LightTogglePayload.toggleAll());
/*     */       }
/*     */     } 
/*     */     
/* 118 */     FastFoodInput.pollHotbar(mc);
/*     */     
/* 120 */     if (ClientRustWounded.isLocalWounded() || ClientRustSleep.isSleeping()) {
/* 121 */       for (int i = 0; i < 9; i++) {
/* 122 */         while (mc.field_1690.field_1852[i].method_1436());
/*     */       }
/*     */ 
/*     */       
/*     */       return;
/*     */     } 
/*     */ 
/*     */     
/* 130 */     if (mc.field_1724 != null && mc.field_1755 == null) {
/* 131 */       int currentSelected = mc.field_1724.method_31548().method_67532();
/* 132 */       for (int i = 0; i < 6; i++) {
/* 133 */         if (i < mc.field_1690.field_1852.length && mc.field_1690.field_1852[i] != null && 
/* 134 */           i == currentSelected) {
/* 135 */           boolean clicked = false;
/* 136 */           while (mc.field_1690.field_1852[i].method_1436()) {
/* 137 */             clicked = true;
/*     */           }
/* 139 */           if (clicked) {
/* 140 */             mc.field_1724.method_31548().method_61496(-1);
/* 141 */             if (mc.method_1562() != null) {
/* 142 */               mc.method_1562().method_52787((class_2596)new class_2868(-1));
/*     */             }
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 150 */     if (mc.field_1724 != null && mc.field_1755 == null) {
/* 151 */       long window = mc.method_22683().method_4490();
/* 152 */       boolean tabDown = (GLFW.glfwGetKey(window, 258) == 1);
/* 153 */       if (tabDown && !rustmine$tabWasDown) {
/* 154 */         rustmine$tabWasDown = true;
/* 155 */         if (mc.field_1724.method_68878()) {
/* 156 */           mc.method_1507((class_437)new RustCreativeScreen(mc.field_1724));
/*     */         } else {
/* 158 */           mc.method_1507((class_437)new RustInventoryScreen(mc.field_1724));
/*     */         } 
/* 160 */       } else if (!tabDown) {
/* 161 */         rustmine$tabWasDown = false;
/*     */       } 
/*     */       
/* 164 */       boolean f1Down = (GLFW.glfwGetKey(window, 290) == 1);
/* 165 */       if (f1Down && !rustmine$f1WasDown && mc.field_1724.method_68878()) {
/* 166 */         rustmine$f1WasDown = true;
/* 167 */         mc.method_1507((class_437)new RustCreativeScreen(mc.field_1724));
/* 168 */       } else if (!f1Down) {
/* 169 */         rustmine$f1WasDown = false;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\SystemX\AppData\Local\IceCubeRust\game\mods\rustmine-0.1.2.jar!\net\rustmine\client\mixin\MinecraftMixin.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */
/*    */ package net.rustmine.client.mixin;
/*    */ import net.fabricmc.api.EnvType;
/*    */ import net.fabricmc.api.Environment;
/*    */ import net.minecraft.class_10185;
/*    */ import net.minecraft.class_241;
/*    */ import net.minecraft.class_304;
/*    */ import net.minecraft.class_310;
/*    */ import net.minecraft.class_315;
/*    */ import net.minecraft.class_3675;
/*    */ import net.minecraft.class_743;
/*    */ import net.minecraft.class_744;
/*    */ import net.rustmine.client.ClientRustWounded;
/*    */ import org.spongepowered.asm.mixin.Final;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.Shadow;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ import org.spongepowered.asm.mixin.injection.Inject;
/*    */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
/*    */ 
/*    */ @Environment(EnvType.CLIENT)
/*    */ @Mixin({class_743.class})
/*    */ abstract class KeyboardInputMixin extends class_744 {
/*    */   private static boolean rustmine$isDown(class_304 mapping) {
/* 24 */     if (mapping == null) return false; 
/* 25 */     class_310 mc = class_310.method_1551();
/* 26 */     if (mc == null || mc.method_22683() == null) return false; 
/*    */     try {
/* 28 */       class_3675.class_306 k = class_3675.method_15981(mapping.method_1428());
/* 29 */       if (k != null && k != class_3675.field_16237 && k.method_1442() == class_3675.class_307.field_1668) {
/* 30 */         return class_3675.method_15987(mc.method_22683(), k.method_1444());
/*    */       }
/* 32 */     } catch (Exception exception) {}
/* 33 */     return mapping.method_1434();
/*    */   } @Shadow
/*    */   @Final
/*    */   private class_315 field_3902; @Inject(method = {"method_3129"}, at = {@At("TAIL")})
/*    */   private void rustmine$mapMovement(CallbackInfo ci) {
/* 38 */     if (ClientRustSleep.isSleeping()) {
/* 39 */       this.field_54155 = new class_10185(false, false, false, false, false, false, false);
/* 40 */       this.field_55868 = class_241.field_1340;
/*    */       return;
/*    */     } 
/* 43 */     if (ClientRustWounded.isLocalWounded()) {
/* 44 */       if (ClientRustWounded.isLocalLooted()) {
/* 45 */         this.field_54155 = new class_10185(false, false, false, false, false, false, false);
/* 46 */         this.field_55868 = class_241.field_1340;
/*    */         return;
/*    */       } 
/* 49 */       if (this.field_54155.comp_3163() || this.field_54155.comp_3165()) {
/* 50 */         this
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */           
/* 56 */           .field_54155 = new class_10185(this.field_54155.comp_3159(), this.field_54155.comp_3160(), this.field_54155.comp_3161(), this.field_54155.comp_3162(), false, this.field_54155.comp_3164(), false);
/*    */       }
/*    */     } 
/*    */ 
/*    */     
/* 61 */     if (RustMapClient.isMapOpen()) {
/* 62 */       boolean up = rustmine$isDown(this.field_3902.field_1894);
/* 63 */       boolean down = rustmine$isDown(this.field_3902.field_1881);
/* 64 */       boolean left = rustmine$isDown(this.field_3902.field_1913);
/* 65 */       boolean right = rustmine$isDown(this.field_3902.field_1849);
/* 66 */       boolean jump = rustmine$isDown(this.field_3902.field_1903);
/* 67 */       boolean shift = rustmine$isDown(this.field_3902.field_1832);
/* 68 */       boolean sprint = rustmine$isDown(this.field_3902.field_1867);
/*    */       
/* 70 */       this.field_54155 = new class_10185(up, down, left, right, jump, shift, sprint);
/*    */       
/* 72 */       float f1 = (up == down) ? 0.0F : (up ? 1.0F : -1.0F);
/* 73 */       float f2 = (left == right) ? 0.0F : (left ? 1.0F : -1.0F);
/* 74 */       this.field_55868 = (new class_241(f2, f1)).method_35581();
/*    */     } 
/*    */   }
/*    */   
/*    */   @Inject(method = {"method_3129"}, at = {@At("TAIL")})
/*    */   private void rustmine$fastFoodInput(CallbackInfo ci) {
/* 80 */     FastFoodInput.handleInput(this.field_3902);
/*    */   }
/*    */ }


/* Location:              C:\Users\SystemX\AppData\Local\IceCubeRust\game\mods\rustmine-0.1.2.jar!\net\rustmine\client\mixin\KeyboardInputMixin.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */
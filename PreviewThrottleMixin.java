/*    */ package net.rustmine.client.mixin;
/*    */ 
/*    */ import net.fabricmc.api.EnvType;
/*    */ import net.fabricmc.api.Environment;
/*    */ import net.minecraft.class_10017;
/*    */ import net.minecraft.class_10055;
/*    */ import net.minecraft.class_11239;
/*    */ import net.minecraft.class_11252;
/*    */ import net.minecraft.class_11256;
/*    */ import net.minecraft.class_310;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.Unique;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ import org.spongepowered.asm.mixin.injection.Inject;
/*    */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
/*    */ 
/*    */ @Environment(EnvType.CLIENT)
/*    */ @Mixin({class_11239.class})
/*    */ abstract class PreviewThrottleMixin
/*    */ {
/*    */   @Unique
/*    */   private static final long PREVIEW_NANOS = 33333333L;
/*    */   @Unique
/*    */   private static long rustmine$lastRender;
/*    */   @Unique
/*    */   private static int rustmine$x0;
/*    */   
/*    */   @Inject(method = {"method_72113"}, at = {@At("HEAD")}, cancellable = true)
/*    */   private void rustmine$throttlePreview(class_11256 state, CallbackInfoReturnable<Boolean> cir) {
/*    */     class_11252 g;
/* 31 */     if (this instanceof net.minecraft.class_11235 && state instanceof class_11252) { g = (class_11252)state; } else { return; }
/* 32 */      class_310 mc = class_310.method_1551();
/* 33 */     if (mc.field_1724 != null) { class_10017 class_10017 = g.comp_4134(); if (class_10017 instanceof class_10055) { class_10055 a = (class_10055)class_10017; if (a.field_53528 == mc.field_1724.method_5628()) {
/* 34 */           long now = System.nanoTime();
/* 35 */           boolean samePlace = (g.comp_4122() == rustmine$x0 && g.comp_4123() == rustmine$y0 && g.comp_4124() == rustmine$x1 && g.comp_4125() == rustmine$y1);
/* 36 */           if (samePlace && now - rustmine$lastRender < 33333333L) {
/* 37 */             cir.setReturnValue(Boolean.valueOf(true));
/*    */             
/*    */             return;
/*    */           } 
/* 41 */           rustmine$lastRender = now;
/* 42 */           rustmine$x0 = g.comp_4122();
/* 43 */           rustmine$y0 = g.comp_4123();
/* 44 */           rustmine$x1 = g.comp_4124();
/* 45 */           rustmine$y1 = g.comp_4125();
/*    */           return;
/*    */         }  }
/*    */        }
/*    */   
/*    */   }
/*    */   
/*    */   @Unique
/*    */   private static int rustmine$y0;
/*    */   @Unique
/*    */   private static int rustmine$x1;
/*    */   @Unique
/*    */   private static int rustmine$y1;
/*    */ }


/* Location:              C:\Users\SystemX\AppData\Local\IceCubeRust\game\mods\rustmine-0.1.2.jar!\net\rustmine\client\mixin\PreviewThrottleMixin.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */
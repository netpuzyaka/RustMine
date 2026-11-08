/*    */ package net.rustmine.mixin;
/*    */ 
/*    */ import net.minecraft.class_10774;
/*    */ import net.minecraft.class_1297;
/*    */ import net.minecraft.class_1937;
/*    */ import net.minecraft.class_2246;
/*    */ import net.minecraft.class_2266;
/*    */ import net.minecraft.class_2338;
/*    */ import net.minecraft.class_2680;
/*    */ import net.minecraft.class_3218;
/*    */ import net.minecraft.class_3481;
/*    */ import net.minecraft.class_4538;
/*    */ import net.minecraft.class_5819;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ import org.spongepowered.asm.mixin.injection.Inject;
/*    */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
/*    */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Mixin({class_2266.class})
/*    */ public class CactusBlockMixin
/*    */ {
/*    */   @Inject(method = {"method_9558"}, at = {@At("HEAD")}, cancellable = true)
/*    */   private void rustmine$canSurviveOnTerrain(class_2680 state, class_4538 level, class_2338 pos, CallbackInfoReturnable<Boolean> cir) {
/* 32 */     class_2680 below = level.method_8320(pos.method_10074());
/* 33 */     cir.setReturnValue(Boolean.valueOf((below.method_27852(class_2246.field_10029) || below.method_26164(class_3481.field_15466) || below
/* 34 */           .method_26204() instanceof net.rustmine.worldgen.TerrainLayerBlock || below.method_51367())));
/*    */   }
/*    */   
/*    */   @Inject(method = {"method_9514"}, at = {@At("HEAD")}, cancellable = true)
/*    */   private void rustmine$noVanillaGrowth(class_2680 state, class_3218 level, class_2338 pos, class_5819 random, CallbackInfo ci) {
/* 39 */     ci.cancel();
/*    */   }
/*    */   
/*    */   @Inject(method = {"method_9548"}, at = {@At("HEAD")}, cancellable = true)
/*    */   private void rustmine$onlyHurtPlayers(class_2680 state, class_1937 level, class_2338 pos, class_1297 entity, class_10774 applier, boolean bl, CallbackInfo ci) {
/* 44 */     if (!(entity instanceof net.minecraft.class_1657))
/* 45 */       ci.cancel(); 
/*    */   }
/*    */ }


/* Location:              C:\Users\SystemX\AppData\Local\IceCubeRust\game\mods\rustmine-0.1.2.jar!\net\rustmine\mixin\CactusBlockMixin.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */
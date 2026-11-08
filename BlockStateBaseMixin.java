/*    */ package net.rustmine.mixin;
/*    */ 
/*    */ import net.minecraft.class_10225;
/*    */ import net.minecraft.class_1922;
/*    */ import net.minecraft.class_2338;
/*    */ import net.minecraft.class_2350;
/*    */ import net.minecraft.class_259;
/*    */ import net.minecraft.class_265;
/*    */ import net.minecraft.class_2680;
/*    */ import net.minecraft.class_3726;
/*    */ import net.minecraft.class_4538;
/*    */ import net.minecraft.class_4970;
/*    */ import net.minecraft.class_5819;
/*    */ import net.rustmine.decor.Decor;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ import org.spongepowered.asm.mixin.injection.Inject;
/*    */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Mixin({class_4970.class_4971.class})
/*    */ abstract class BlockStateBaseMixin
/*    */ {
/*    */   @Inject(method = {"method_26172(Lnet/minecraft/class_1922;Lnet/minecraft/class_2338;Lnet/minecraft/class_3726;)Lnet/minecraft/class_265;"}, at = {@At("HEAD")}, cancellable = true)
/*    */   private void rustmine$noOutline(class_1922 level, class_2338 pos, class_3726 context, CallbackInfoReturnable<class_265> cir) {
/* 29 */     if (Decor.anchored(level, pos)) cir.setReturnValue(class_259.method_1073());
/*    */   
/*    */   }
/*    */   
/*    */   @Inject(method = {"method_26194(Lnet/minecraft/class_1922;Lnet/minecraft/class_2338;Lnet/minecraft/class_3726;)Lnet/minecraft/class_265;"}, at = {@At("HEAD")}, cancellable = true)
/*    */   private void rustmine$noCollision(class_1922 level, class_2338 pos, class_3726 context, CallbackInfoReturnable<class_265> cir) {
/* 35 */     if (Decor.anchored(level, pos)) cir.setReturnValue(class_259.method_1073());
/*    */   
/*    */   }
/*    */   
/*    */   @Inject(method = {"method_26230"}, at = {@At("HEAD")}, cancellable = true)
/*    */   private void rustmine$seeThrough(class_1922 level, class_2338 pos, CallbackInfoReturnable<Boolean> cir) {
/* 41 */     if (Decor.anchored(level, pos)) cir.setReturnValue(Boolean.valueOf(false));
/*    */   
/*    */   }
/*    */ 
/*    */   
/*    */   @Inject(method = {"method_26234"}, at = {@At("HEAD")}, cancellable = true)
/*    */   private void rustmine$cellNotFull(class_1922 level, class_2338 pos, CallbackInfoReturnable<Boolean> cir) {
/* 48 */     if (((class_2680)this).method_26204() instanceof net.rustmine.monument.baked.MonumentCellBlock) cir.setReturnValue(Boolean.valueOf(false)); 
/*    */   }
/*    */   
/*    */   @Inject(method = {"method_26184"}, at = {@At("HEAD")}, cancellable = true)
/*    */   private void rustmine$survive(class_4538 level, class_2338 pos, CallbackInfoReturnable<Boolean> cir) {
/* 53 */     if (Decor.anchored((class_1922)level, pos)) cir.setReturnValue(Boolean.valueOf(true));
/*    */   
/*    */   }
/*    */   
/*    */   @Inject(method = {"method_26191"}, at = {@At("HEAD")}, cancellable = true)
/*    */   private void rustmine$stay(class_4538 level, class_10225 ticks, class_2338 pos, class_2350 dir, class_2338 from, class_2680 neighbour, class_5819 random, CallbackInfoReturnable<class_2680> cir) {
/* 59 */     if (Decor.anchored((class_1922)level, pos)) cir.setReturnValue(this); 
/*    */   }
/*    */ }


/* Location:              C:\Users\SystemX\AppData\Local\IceCubeRust\game\mods\rustmine-0.1.2.jar!\net\rustmine\mixin\BlockStateBaseMixin.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */
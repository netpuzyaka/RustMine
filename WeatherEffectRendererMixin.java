/*    */ package net.rustmine.client.mixin;
/*    */ 
/*    */ import net.fabricmc.api.EnvType;
/*    */ import net.fabricmc.api.Environment;
/*    */ import net.minecraft.class_1937;
/*    */ import net.minecraft.class_2338;
/*    */ import net.minecraft.class_2902;
/*    */ import net.minecraft.class_638;
/*    */ import net.minecraft.class_9976;
/*    */ import net.rustmine.client.building.WorldSolids;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.Unique;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ import org.spongepowered.asm.mixin.injection.ModifyArg;
/*    */ import org.spongepowered.asm.mixin.injection.Redirect;
/*    */ 
/*    */ @Environment(EnvType.CLIENT)
/*    */ @Mixin({class_9976.class})
/*    */ abstract class WeatherEffectRendererMixin
/*    */ {
/*    */   @Unique
/* 22 */   private double rustmine$splashY = Double.NaN;
/*    */ 
/*    */ 
/*    */   
/*    */   @Redirect(method = {"method_62315"}, at = @At(value = "INVOKE", target = "Lnet/minecraft/class_1937;method_8624(Lnet/minecraft/class_2902$class_2903;II)I"))
/*    */   private int rustmine$roofColumn(class_1937 level, class_2902.class_2903 type, int x, int z) {
/* 28 */     return Math.max(level.method_8624(type, x, z), WorldSolids.roofBlock(level, x, z));
/*    */   }
/*    */ 
/*    */   
/*    */   @Redirect(method = {"method_62319"}, at = @At(value = "INVOKE", target = "Lnet/minecraft/class_638;method_8598(Lnet/minecraft/class_2902$class_2903;Lnet/minecraft/class_2338;)Lnet/minecraft/class_2338;"))
/*    */   private class_2338 rustmine$roofPos(class_638 level, class_2902.class_2903 type, class_2338 pos) {
/* 34 */     class_2338 ground = level.method_8598(type, pos);
/* 35 */     double roof = WorldSolids.roof((class_1937)level, pos.method_10263(), pos.method_10260());
/* 36 */     this.rustmine$splashY = Double.NaN;
/* 37 */     if (roof <= ground.method_10264()) return ground; 
/* 38 */     this.rustmine$splashY = roof;
/*    */     
/* 40 */     return new class_2338(pos.method_10263(), (int)Math.floor(roof) + 1, pos.method_10260());
/*    */   }
/*    */ 
/*    */   
/*    */   @ModifyArg(method = {"method_62319"}, index = 2, at = @At(value = "INVOKE", target = "Lnet/minecraft/class_638;method_8406(Lnet/minecraft/class_2394;DDDDDD)V"))
/*    */   private double rustmine$splashOnRoof(double y) {
/* 46 */     return Double.isNaN(this.rustmine$splashY) ? y : this.rustmine$splashY;
/*    */   }
/*    */ }


/* Location:              C:\Users\SystemX\AppData\Local\IceCubeRust\game\mods\rustmine-0.1.2.jar!\net\rustmine\client\mixin\WeatherEffectRendererMixin.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */
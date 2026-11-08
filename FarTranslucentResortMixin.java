/*    */ package net.rustmine.client.mixin;
/*    */ 
/*    */ import net.fabricmc.api.EnvType;
/*    */ import net.fabricmc.api.Environment;
/*    */ import net.minecraft.class_10196;
/*    */ import net.minecraft.class_243;
/*    */ import net.minecraft.class_4076;
/*    */ import net.minecraft.class_761;
/*    */ import net.minecraft.class_846;
/*    */ import org.spongepowered.asm.mixin.Final;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.Shadow;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ import org.spongepowered.asm.mixin.injection.Inject;
/*    */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Environment(EnvType.CLIENT)
/*    */ @Mixin({class_761.class})
/*    */ abstract class FarTranslucentResortMixin
/*    */ {
/*    */   private static final double FAR = 48.0D;
/*    */   @Shadow
/*    */   @Final
/*    */   private class_846 field_45614;
/*    */   
/*    */   @Inject(method = {"method_64060"}, at = {@At("HEAD")}, cancellable = true)
/*    */   private void rustmine$farResort(class_846.class_851 section, class_10196 pov, class_243 camera, boolean blockMoved, boolean nearby, CallbackInfo ci) {
/* 31 */     if (!blockMoved || nearby)
/* 32 */       return;  long node = section.method_62975();
/* 33 */     double dx = (class_4076.method_18688(class_4076.method_18686(node)) + 8) - camera.field_1352;
/* 34 */     double dy = (class_4076.method_18688(class_4076.method_18689(node)) + 8) - camera.field_1351;
/* 35 */     double dz = (class_4076.method_18688(class_4076.method_18690(node)) + 8) - camera.field_1350;
/* 36 */     if (dx * dx + dy * dy + dz * dz < 2304.0D)
/* 37 */       return;  pov.method_64070(camera, node);
/* 38 */     if (section.method_72052().method_72036(pov) && !section.method_64066() && section.method_64065()) {
/* 39 */       section.method_22773(this.field_45614);
/*    */     }
/* 41 */     ci.cancel();
/*    */   }
/*    */ }


/* Location:              C:\Users\SystemX\AppData\Local\IceCubeRust\game\mods\rustmine-0.1.2.jar!\net\rustmine\client\mixin\FarTranslucentResortMixin.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */
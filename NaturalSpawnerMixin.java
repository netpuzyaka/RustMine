/*    */ package net.rustmine.mixin;
/*    */ 
/*    */ import net.minecraft.class_1948;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ import org.spongepowered.asm.mixin.injection.Inject;
/*    */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
/*    */ 
/*    */ @Mixin({class_1948.class})
/*    */ abstract class NaturalSpawnerMixin
/*    */ {
/*    */   @Inject(method = {"method_27821"}, at = {@At("HEAD")}, cancellable = true)
/*    */   private static void rustmine$noNaturalSpawns(CallbackInfo ci) {
/* 14 */     ci.cancel();
/*    */   }
/*    */   
/*    */   @Inject(method = {"method_8661"}, at = {@At("HEAD")}, cancellable = true)
/*    */   private static void rustmine$noWorldGenMobs(CallbackInfo ci) {
/* 19 */     ci.cancel();
/*    */   }
/*    */ }


/* Location:              C:\Users\SystemX\AppData\Local\IceCubeRust\game\mods\rustmine-0.1.2.jar!\net\rustmine\mixin\NaturalSpawnerMixin.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */
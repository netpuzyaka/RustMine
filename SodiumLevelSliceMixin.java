/*    */ package net.rustmine.client.mixin;
/*    */ 
/*    */ import net.fabricmc.api.EnvType;
/*    */ import net.fabricmc.api.Environment;
/*    */ import net.minecraft.class_2246;
/*    */ import net.minecraft.class_2338;
/*    */ import net.minecraft.class_2680;
/*    */ import net.rustmine.decor.Decor;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.Pseudo;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ import org.spongepowered.asm.mixin.injection.Inject;
/*    */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
/*    */ 
/*    */ @Environment(EnvType.CLIENT)
/*    */ @Pseudo
/*    */ @Mixin(targets = {"net/caffeinemc/mods/sodium/client/world/LevelSlice"}, remap = false)
/*    */ abstract class SodiumLevelSliceMixin
/*    */ {
/*    */   @Inject(method = {"getBlockState(III)Lnet/minecraft/class_2680;"}, at = {@At("HEAD")}, cancellable = true, require = 0)
/*    */   private void rustmine$hideAnchor(int x, int y, int z, CallbackInfoReturnable<class_2680> cir) {
/* 22 */     if (Decor.clientAnchored(class_2338.method_10064(x, y, z))) cir.setReturnValue(class_2246.field_10124.method_9564()); 
/*    */   }
/*    */   
/*    */   @Inject(method = {"method_8320(Lnet/minecraft/class_2338;)Lnet/minecraft/class_2680;"}, at = {@At("HEAD")}, cancellable = true, require = 0)
/*    */   private void rustmine$hideAnchorAt(class_2338 pos, CallbackInfoReturnable<class_2680> cir) {
/* 27 */     if (Decor.clientAnchored(pos.method_10063())) cir.setReturnValue(class_2246.field_10124.method_9564()); 
/*    */   }
/*    */ }


/* Location:              C:\Users\SystemX\AppData\Local\IceCubeRust\game\mods\rustmine-0.1.2.jar!\net\rustmine\client\mixin\SodiumLevelSliceMixin.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */
/*    */ package net.rustmine.mixin;
/*    */ 
/*    */ import net.minecraft.class_1922;
/*    */ import net.minecraft.class_2338;
/*    */ import net.minecraft.class_2346;
/*    */ import net.minecraft.class_2680;
/*    */ import net.minecraft.class_3218;
/*    */ import net.minecraft.class_5819;
/*    */ import net.rustmine.decor.Decor;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ import org.spongepowered.asm.mixin.injection.Inject;
/*    */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
/*    */ 
/*    */ @Mixin({class_2346.class})
/*    */ abstract class FallingBlockMixin {
/*    */   @Inject(method = {"method_9588"}, at = {@At("HEAD")}, cancellable = true)
/*    */   private void rustmine$noFall(class_2680 state, class_3218 level, class_2338 pos, class_5819 random, CallbackInfo ci) {
/* 19 */     if (Decor.anchored((class_1922)level, pos)) ci.cancel(); 
/*    */   }
/*    */ }


/* Location:              C:\Users\SystemX\AppData\Local\IceCubeRust\game\mods\rustmine-0.1.2.jar!\net\rustmine\mixin\FallingBlockMixin.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */
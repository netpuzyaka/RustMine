/*    */ package net.rustmine.mixin;
/*    */ 
/*    */ import net.minecraft.class_1937;
/*    */ import net.minecraft.class_2338;
/*    */ import net.minecraft.class_2418;
/*    */ import net.minecraft.class_2680;
/*    */ import net.minecraft.class_5819;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ import org.spongepowered.asm.mixin.injection.Inject;
/*    */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
/*    */ 
/*    */ @Mixin({class_2418.class})
/*    */ abstract class MyceliumBlockMixin
/*    */ {
/*    */   @Inject(method = {"method_9496"}, at = {@At("HEAD")}, cancellable = true)
/*    */   private void rustmine$noSpores(class_2680 state, class_1937 level, class_2338 pos, class_5819 random, CallbackInfo ci) {
/* 18 */     ci.cancel();
/*    */   }
/*    */ }


/* Location:              C:\Users\SystemX\AppData\Local\IceCubeRust\game\mods\rustmine-0.1.2.jar!\net\rustmine\mixin\MyceliumBlockMixin.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */
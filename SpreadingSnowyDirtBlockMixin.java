/*    */ package net.rustmine.mixin;
/*    */ 
/*    */ import net.minecraft.class_2246;
/*    */ import net.minecraft.class_2338;
/*    */ import net.minecraft.class_2500;
/*    */ import net.minecraft.class_2680;
/*    */ import net.minecraft.class_3218;
/*    */ import net.minecraft.class_5819;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ import org.spongepowered.asm.mixin.injection.Inject;
/*    */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
/*    */ 
/*    */ @Mixin({class_2500.class})
/*    */ abstract class SpreadingSnowyDirtBlockMixin
/*    */ {
/*    */   @Inject(method = {"method_9514"}, at = {@At("HEAD")}, cancellable = true)
/*    */   private void rustmine$staticMycelium(class_2680 state, class_3218 level, class_2338 pos, class_5819 random, CallbackInfo ci) {
/* 19 */     if (state.method_27852(class_2246.field_10402)) ci.cancel(); 
/*    */   }
/*    */ }


/* Location:              C:\Users\SystemX\AppData\Local\IceCubeRust\game\mods\rustmine-0.1.2.jar!\net\rustmine\mixin\SpreadingSnowyDirtBlockMixin.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */
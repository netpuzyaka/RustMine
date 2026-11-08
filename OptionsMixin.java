/*    */ package net.rustmine.client.mixin;
/*    */ import net.fabricmc.api.EnvType;
/*    */ import net.minecraft.class_315;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ import org.spongepowered.asm.mixin.injection.Constant;
/*    */ import org.spongepowered.asm.mixin.injection.ModifyConstant;
/*    */ 
/*    */ @Environment(EnvType.CLIENT)
/*    */ @Mixin({class_315.class})
/*    */ abstract class OptionsMixin {
/*    */   @ModifyConstant(method = {"<init>"}, constant = {@Constant(intValue = 340)}, require = 1, allow = 1)
/*    */   private int rustmine$crouchDefault(int key) {
/* 14 */     return 341;
/*    */   }
/*    */   
/*    */   @ModifyConstant(method = {"<init>"}, constant = {@Constant(intValue = 341)}, require = 1, allow = 1)
/*    */   private int rustmine$sprintDefault(int key) {
/* 19 */     return 340;
/*    */   }
/*    */   
/*    */   @Inject(method = {"method_1636"}, at = {@At("TAIL")}, require = 1)
/*    */   private void rustmine$firstRunDefaults(CallbackInfo ci) {
/* 24 */     RustFirstRunOptions.apply((class_315)this);
/*    */   }
/*    */ }


/* Location:              C:\Users\SystemX\AppData\Local\IceCubeRust\game\mods\rustmine-0.1.2.jar!\net\rustmine\client\mixin\OptionsMixin.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */
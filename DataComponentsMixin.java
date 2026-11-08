/*    */ package net.rustmine.mixin;
/*    */ 
/*    */ import net.minecraft.class_9334;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.injection.Constant;
/*    */ import org.spongepowered.asm.mixin.injection.ModifyConstant;
/*    */ 
/*    */ @Mixin({class_9334.class})
/*    */ public abstract class DataComponentsMixin {
/*    */   @ModifyConstant(method = {"method_58570"}, constant = {@Constant(intValue = 99)}, require = 0)
/*    */   private static int rustmine$expandMaxStackSizeComponent(int original) {
/* 12 */     return 1000000;
/*    */   }
/*    */ }


/* Location:              C:\Users\SystemX\AppData\Local\IceCubeRust\game\mods\rustmine-0.1.2.jar!\net\rustmine\mixin\DataComponentsMixin.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */
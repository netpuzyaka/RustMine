/*    */ package net.rustmine.mixin;
/*    */ 
/*    */ import net.minecraft.class_2338;
/*    */ import net.minecraft.class_2488;
/*    */ import net.minecraft.class_2680;
/*    */ import net.minecraft.class_4538;
/*    */ import net.rustmine.monument.baked.BakedMonuments;
/*    */ import net.rustmine.worldgen.RustIslandModel;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ import org.spongepowered.asm.mixin.injection.Inject;
/*    */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
/*    */ 
/*    */ @Mixin({class_2488.class})
/*    */ public class SnowLayerBlockMixin {
/*    */   @Inject(method = {"method_9558"}, at = {@At("HEAD")}, cancellable = true)
/*    */   private void rustmine$noSnowOnMonuments(class_2680 state, class_4538 level, class_2338 pos, CallbackInfoReturnable<Boolean> cir) {
/* 18 */     if (level.method_8320(pos.method_10074()).method_27852(BakedMonuments.CELL)) { cir.setReturnValue(Boolean.valueOf(false));
/*    */       return; }
/*    */     
/* 21 */     if (level instanceof net.minecraft.class_5281 && 
/* 22 */       RustIslandModel.get().inMonumentTerrain(pos.method_10263(), pos.method_10260())) cir.setReturnValue(Boolean.valueOf(false)); 
/*    */   }
/*    */ }


/* Location:              C:\Users\SystemX\AppData\Local\IceCubeRust\game\mods\rustmine-0.1.2.jar!\net\rustmine\mixin\SnowLayerBlockMixin.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */
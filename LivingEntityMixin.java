/*    */ package net.rustmine.mixin;
/*    */ import java.util.List;
/*    */ import net.minecraft.class_1657;
/*    */ import net.minecraft.class_3222;
/*    */ import net.rustmine.RustWoundedManager;
/*    */ import net.rustmine.monument.baked.BakedMonument;
/*    */ import net.rustmine.monument.baked.BakedMonuments;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ import org.spongepowered.asm.mixin.injection.Inject;
/*    */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
/*    */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
/*    */ 
/*    */ @Mixin({class_1309.class})
/*    */ abstract class LivingEntityMixin {
/*    */   @Inject(method = {"method_6043"}, at = {@At("HEAD")}, cancellable = true)
/*    */   private void rustmine$noServerJumpWhileWounded(CallbackInfo ci) {
/* 17 */     LivingEntityMixin livingEntityMixin = this; if (livingEntityMixin instanceof class_3222) { class_3222 sp = (class_3222)livingEntityMixin; if (RustWoundedManager.isWounded(sp.method_5667())) {
/* 18 */         ci.cancel();
/*    */       } }
/*    */   
/*    */   }
/*    */   
/*    */   @Inject(method = {"method_6101"}, at = {@At("HEAD")}, cancellable = true)
/*    */   private void rustmine$monumentLadder(CallbackInfoReturnable<Boolean> cir) {
/* 25 */     LivingEntityMixin livingEntityMixin = this; if (livingEntityMixin instanceof class_1657) { class_1657 pl = (class_1657)livingEntityMixin; if (!pl.method_7325()) {
/* 26 */         List<BakedMonument> list = pl.method_73183().method_8608() ? BakedMonuments.CLIENT : BakedMonuments.SERVER;
/* 27 */         if (!list.isEmpty() && MonumentLadders.at(list, pl.method_73189().method_1031(0.0D, 0.6D, 0.0D), 0.3D)) {
/* 28 */           cir.setReturnValue(Boolean.valueOf(true));
/*    */           return;
/*    */         } 
/* 31 */         if (LadderClimbHelper.isClimbing(pl))
/* 32 */           cir.setReturnValue(Boolean.valueOf(true)); 
/*    */         return;
/*    */       }  }
/*    */   
/*    */   } @Inject(method = {"method_6010"}, at = {@At("HEAD")}, cancellable = true)
/*    */   private void rustmine$noServerLiquidJumpWhileWounded(class_6862<class_3611> fluid, CallbackInfo ci) {
/* 38 */     LivingEntityMixin livingEntityMixin = this; if (livingEntityMixin instanceof class_3222) { class_3222 sp = (class_3222)livingEntityMixin; if (RustWoundedManager.isWounded(sp.method_5667()))
/* 39 */         ci.cancel();  }
/*    */   
/*    */   }
/*    */ }


/* Location:              C:\Users\SystemX\AppData\Local\IceCubeRust\game\mods\rustmine-0.1.2.jar!\net\rustmine\mixin\LivingEntityMixin.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */
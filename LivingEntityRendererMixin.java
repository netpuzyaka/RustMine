/*    */ package net.rustmine.client.mixin;
/*    */ import net.fabricmc.api.EnvType;
/*    */ import net.fabricmc.api.Environment;
/*    */ import net.minecraft.class_10042;
/*    */ import net.minecraft.class_10055;
/*    */ import net.minecraft.class_1058;
/*    */ import net.minecraft.class_11659;
/*    */ import net.minecraft.class_1921;
/*    */ import net.minecraft.class_4050;
/*    */ import net.minecraft.class_4587;
/*    */ import net.minecraft.class_7833;
/*    */ import net.minecraft.class_922;
/*    */ import net.rustmine.client.RustPlayers;
/*    */ import org.joml.Quaternionfc;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
/*    */ 
/*    */ @Environment(EnvType.CLIENT)
/*    */ @Mixin({class_922.class})
/*    */ abstract class LivingEntityRendererMixin {
/*    */   @WrapWithCondition(method = {"method_4054(Lnet/minecraft/class_10042;Lnet/minecraft/class_4587;Lnet/minecraft/class_11659;Lnet/minecraft/class_12075;)V"}, at = {@At(value = "INVOKE", target = "Lnet/minecraft/class_11659;method_73490(Lnet/minecraft/class_3879;Ljava/lang/Object;Lnet/minecraft/class_4587;Lnet/minecraft/class_1921;IIILnet/minecraft/class_1058;ILnet/minecraft/class_11683$class_11792;)V")})
/*    */   private boolean rustmine$playerModel(class_11659 collector, class_3879<?> model, Object state, class_4587 pose, class_1921 type, int light, int overlay, int tint, class_1058 sprite, int outline, class_11683.class_11792 crumbling) {
/* 24 */     if (state instanceof class_10055) { class_10055 s = (class_10055)state;
/* 25 */       if (s.field_53449 > 0.0F || s.field_53460) {
/* 26 */         return false;
/*    */       }
/* 28 */       if (RustPlayers.active(s)) {
/* 29 */         RustPlayers.submit(s, pose, collector);
/* 30 */         return false;
/*    */       }  }
/*    */     
/* 33 */     return true;
/*    */   }
/*    */   
/*    */   @Inject(method = {"method_4058"}, at = {@At("HEAD")}, cancellable = true)
/*    */   private void rustmine$setupRotations(class_10042 state, class_4587 poseStack, float bodyRot, float scale, CallbackInfo ci) {
/* 38 */     if (state instanceof class_10055) { class_10055 s = (class_10055)state; if (RustPlayers.active(s) && (
/* 39 */         state.method_62613(class_4050.field_18078) || ClientRustSleep.isSleeping(s.field_53528))) {
/* 40 */         ci.cancel();
/* 41 */         poseStack.method_22907((Quaternionfc)class_7833.field_40716.rotationDegrees(180.0F - bodyRot));
/*    */       }  }
/*    */   
/*    */   }
/*    */ }


/* Location:              C:\Users\SystemX\AppData\Local\IceCubeRust\game\mods\rustmine-0.1.2.jar!\net\rustmine\client\mixin\LivingEntityRendererMixin.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */
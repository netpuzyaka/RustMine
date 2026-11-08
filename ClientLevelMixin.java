/*    */ package net.rustmine.client.mixin;
/*    */ 
/*    */ import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
/*    */ import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
/*    */ import net.fabricmc.api.EnvType;
/*    */ import net.fabricmc.api.Environment;
/*    */ import net.minecraft.class_1937;
/*    */ import net.minecraft.class_2248;
/*    */ import net.minecraft.class_2338;
/*    */ import net.minecraft.class_2394;
/*    */ import net.minecraft.class_243;
/*    */ import net.minecraft.class_2680;
/*    */ import net.minecraft.class_5819;
/*    */ import net.minecraft.class_638;
/*    */ import net.rustmine.client.decor.DecorClient;
/*    */ import net.rustmine.client.render.ParticleBudget;
/*    */ import net.rustmine.decor.Decor;
/*    */ import net.rustmine.decor.DecorEntity;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.Shadow;
/*    */ import org.spongepowered.asm.mixin.Unique;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ import org.spongepowered.asm.mixin.injection.Inject;
/*    */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
/*    */ 
/*    */ 
/*    */ 
/*    */ @Environment(EnvType.CLIENT)
/*    */ @Mixin({class_638.class})
/*    */ abstract class ClientLevelMixin
/*    */ {
/*    */   @Unique
/*    */   private DecorEntity rustmine$decor;
/*    */   
/*    */   @WrapOperation(method = {"method_2943"}, at = {@At(value = "INVOKE", target = "Lnet/minecraft/class_2248;method_9496(Lnet/minecraft/class_2680;Lnet/minecraft/class_1937;Lnet/minecraft/class_2338;Lnet/minecraft/class_5819;)V")})
/*    */   private void rustmine$fromDecor(class_2248 block, class_2680 state, class_1937 level, class_2338 pos, class_5819 random, Operation<Void> original) {
/* 37 */     DecorEntity d = Decor.clientDecor(pos);
/* 38 */     if (d == null) {
/* 39 */       original.call(new Object[] { block, state, level, pos, random });
/*    */       return;
/*    */     } 
/* 42 */     this.rustmine$decor = d;
/* 43 */     this.rustmine$anchor = pos.method_10062();
/*    */     try {
/* 45 */       original.call(new Object[] { block, state, level, pos, random });
/*    */     } finally {
/* 47 */       this.rustmine$decor = null;
/*    */     } 
/*    */   } @Unique
/*    */   private class_2338 rustmine$anchor; @Shadow
/*    */   protected abstract void method_74919(class_2394 paramclass_2394, boolean paramBoolean1, boolean paramBoolean2, double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, double paramDouble5, double paramDouble6);
/*    */   @Inject(method = {"method_74919"}, at = {@At("HEAD")}, cancellable = true)
/*    */   private void rustmine$moveParticle(class_2394 options, boolean force, boolean decreased, double x, double y, double z, double dx, double dy, double dz, CallbackInfo ci) {
/* 54 */     if (!ParticleBudget.trySpawn(options, x, y, z)) {
/* 55 */       ci.cancel();
/*    */       return;
/*    */     } 
/* 58 */     DecorEntity d = this.rustmine$decor;
/* 59 */     if (d == null)
/* 60 */       return;  this.rustmine$decor = null;
/* 61 */     class_243 p = DecorClient.particleAt(d, this.rustmine$anchor, x, y, z);
/* 62 */     method_74919(options, force, decreased, p.field_1352, p.field_1351, p.field_1350, dx, dy, dz);
/* 63 */     this.rustmine$decor = d;
/* 64 */     ci.cancel();
/*    */   }
/*    */ }


/* Location:              C:\Users\SystemX\AppData\Local\IceCubeRust\game\mods\rustmine-0.1.2.jar!\net\rustmine\client\mixin\ClientLevelMixin.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */
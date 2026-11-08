/*    */ package net.rustmine.client.mixin;
/*    */ import net.fabricmc.api.EnvType;
/*    */ import net.fabricmc.api.Environment;
/*    */ import net.minecraft.class_1309;
/*    */ import net.minecraft.class_1657;
/*    */ import net.rustmine.client.ClientRustWounded;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ import org.spongepowered.asm.mixin.injection.Inject;
/*    */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
/*    */ 
/*    */ @Environment(EnvType.CLIENT)
/*    */ @Mixin({class_1309.class})
/*    */ abstract class ClientLivingEntityMixin {
/*    */   @Inject(method = {"method_6043"}, at = {@At("HEAD")}, cancellable = true)
/*    */   private void rustmine$noClientJumpWhileWounded(CallbackInfo ci) {
/* 17 */     ClientLivingEntityMixin clientLivingEntityMixin = this; if (clientLivingEntityMixin instanceof class_1657) { class_1657 player = (class_1657)clientLivingEntityMixin; if (ClientRustWounded.isWounded(player.method_5628()))
/* 18 */         ci.cancel();  }
/*    */   
/*    */   }
/*    */   
/*    */   @Inject(method = {"method_6010"}, at = {@At("HEAD")}, cancellable = true)
/*    */   private void rustmine$noClientLiquidJumpWhileWounded(class_6862<class_3611> fluid, CallbackInfo ci) {
/* 24 */     ClientLivingEntityMixin clientLivingEntityMixin = this; if (clientLivingEntityMixin instanceof class_1657) { class_1657 player = (class_1657)clientLivingEntityMixin; if (ClientRustWounded.isWounded(player.method_5628()))
/* 25 */         ci.cancel();  }
/*    */   
/*    */   }
/*    */   
/*    */   @Inject(method = {"method_5711"}, at = {@At("HEAD")}, cancellable = true)
/*    */   private void rustmine$noDeathEventPoof(byte status, CallbackInfo ci) {
/* 31 */     if (status == 3) { ClientLivingEntityMixin clientLivingEntityMixin = this; if (clientLivingEntityMixin instanceof class_1657) { class_1657 player = (class_1657)clientLivingEntityMixin;
/* 32 */         ci.cancel(); }
/*    */        }
/*    */   
/*    */   }
/*    */ }


/* Location:              C:\Users\SystemX\AppData\Local\IceCubeRust\game\mods\rustmine-0.1.2.jar!\net\rustmine\client\mixin\ClientLivingEntityMixin.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */
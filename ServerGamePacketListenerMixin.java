/*    */ package net.rustmine.mixin;
/*    */ import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
/*    */ import net.minecraft.class_1268;
/*    */ import net.minecraft.class_2547;
/*    */ import net.minecraft.class_2596;
/*    */ import net.minecraft.class_2600;
/*    */ import net.minecraft.class_2824;
/*    */ import net.minecraft.class_2828;
/*    */ import net.minecraft.class_2846;
/*    */ import net.minecraft.class_2868;
/*    */ import net.minecraft.class_3222;
/*    */ import net.minecraft.class_3244;
/*    */ import net.rustmine.anticheat.AntiCheatHooks;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.Shadow;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ import org.spongepowered.asm.mixin.injection.Inject;
/*    */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
/*    */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
/*    */ 
/*    */ @Mixin({class_3244.class})
/*    */ abstract class ServerGamePacketListenerMixin {
/*    */   @Inject(method = {"method_64962"}, at = {@At("HEAD")}, cancellable = true)
/*    */   private void rustmine$noSpeedCheckInFlight(boolean elytra, CallbackInfoReturnable<Boolean> cir) {
/* 25 */     if ((this.field_14140.method_31549()).field_7478) cir.setReturnValue(Boolean.valueOf(false));
/*    */   
/*    */   }
/*    */ 
/*    */   
/*    */   @Shadow
/*    */   public class_3222 field_14140;
/*    */   
/*    */   @ModifyExpressionValue(method = {"method_12063"}, at = {@At(value = "INVOKE", target = "Lnet/minecraft/class_2828;method_12273()Z")})
/*    */   private boolean rustmine$groundClaim(boolean claimed) {
/* 35 */     return AntiCheatHooks.impl.groundClaim(this.field_14140, claimed);
/*    */   }
/*    */ 
/*    */   
/*    */   @Inject(method = {"method_12063"}, at = {@At("RETURN")})
/*    */   private void rustmine$moved(class_2828 packet, CallbackInfo ci) {
/* 41 */     AntiCheatHooks.impl.moved(this.field_14140);
/*    */   }
/*    */ 
/*    */   
/*    */   @Inject(method = {"method_12062"}, at = {@At("HEAD")}, cancellable = true)
/*    */   private void rustmine$interact(class_2824 packet, CallbackInfo ci) {
/* 47 */     if (!this.field_14140.method_51469().method_8503().method_18854())
/* 48 */       return;  if (AntiCheatHooks.impl.interacted(this.field_14140, ((InteractPacketAccessor)packet).rustmine$entityId(), AntiCheatHooks.isAttack(packet))) ci.cancel();
/*    */   
/*    */   }
/*    */   
/*    */   @Inject(method = {"method_12066"}, at = {@At("HEAD")}, cancellable = true)
/*    */   private void rustmine$noSwapHands(class_2846 packet, CallbackInfo ci) {
/* 54 */     if (packet.method_12363() == class_2846.class_2847.field_12969) ci.cancel();
/*    */   
/*    */   }
/*    */   
/*    */   @Inject(method = {"method_12056"}, at = {@At("HEAD")}, cancellable = true)
/*    */   private void rustmine$handleSetCarriedItem(class_2868 packet, CallbackInfo ci) {
/* 60 */     if (packet.method_12442() == -1) {
/* 61 */       ci.cancel();
/* 62 */       class_3244 listener = (class_3244)this;
/* 63 */       class_2600.method_11073((class_2596)packet, (class_2547)listener, this.field_14140.method_51469());
/* 64 */       if (this.field_14140.method_31548().method_67532() != -1 && this.field_14140.method_6058() == class_1268.field_5808) {
/* 65 */         this.field_14140.method_6021();
/*    */       }
/* 67 */       this.field_14140.method_31548().method_61496(-1);
/* 68 */       this.field_14140.method_14234();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\SystemX\AppData\Local\IceCubeRust\game\mods\rustmine-0.1.2.jar!\net\rustmine\mixin\ServerGamePacketListenerMixin.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */
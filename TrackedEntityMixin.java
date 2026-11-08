/*    */ package net.rustmine.mixin;
/*    */ 
/*    */ import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
/*    */ import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
/*    */ import java.util.Set;
/*    */ import net.minecraft.class_1297;
/*    */ import net.minecraft.class_3222;
/*    */ import net.minecraft.class_5629;
/*    */ import net.rustmine.anticheat.AntiCheatHooks;
/*    */ import net.rustmine.anticheat.TrackedEntityAccess;
/*    */ import org.spongepowered.asm.mixin.Final;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.Shadow;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Mixin(targets = {"net/minecraft/class_3898$class_3208"})
/*    */ abstract class TrackedEntityMixin
/*    */   implements TrackedEntityAccess
/*    */ {
/*    */   @Shadow
/*    */   @Final
/*    */   class_1297 field_18247;
/*    */   
/*    */   @WrapOperation(method = {"method_18736"}, at = {@At(value = "INVOKE", target = "Lnet/minecraft/class_1297;method_5680(Lnet/minecraft/class_3222;)Z")})
/*    */   private boolean rustmine$hidden(class_1297 self, class_3222 player, Operation<Boolean> original) {
/* 29 */     return (((Boolean)original.call(new Object[] { self, player })).booleanValue() && !AntiCheatHooks.impl.hidden(player, self));
/*    */   } @Shadow
/*    */   @Final
/*    */   Set<class_5629> field_18250; @Shadow
/*    */   public abstract void method_18736(class_3222 paramclass_3222); public class_1297 rustmine$entity() {
/* 34 */     return this.field_18247;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean rustmine$seenBy(class_3222 player) {
/* 39 */     return this.field_18250.contains(player.field_13987);
/*    */   }
/*    */ 
/*    */   
/*    */   public void rustmine$update(class_3222 player) {
/* 44 */     method_18736(player);
/*    */   }
/*    */ }


/* Location:              C:\Users\SystemX\AppData\Local\IceCubeRust\game\mods\rustmine-0.1.2.jar!\net\rustmine\mixin\TrackedEntityMixin.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */
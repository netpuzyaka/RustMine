/*    */ package net.rustmine.client.mixin;
/*    */ 
/*    */ import java.util.Map;
/*    */ import net.fabricmc.api.EnvType;
/*    */ import net.fabricmc.api.Environment;
/*    */ import net.minecraft.class_1113;
/*    */ import net.minecraft.class_1140;
/*    */ import net.minecraft.class_4224;
/*    */ import net.minecraft.class_4235;
/*    */ import net.rustmine.client.SoundMuffle;
/*    */ import org.spongepowered.asm.mixin.Final;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.Shadow;
/*    */ import org.spongepowered.asm.mixin.Unique;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ import org.spongepowered.asm.mixin.injection.Inject;
/*    */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
/*    */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
/*    */ 
/*    */ @Environment(EnvType.CLIENT)
/*    */ @Mixin({class_1140.class})
/*    */ abstract class SoundEngineMixin
/*    */ {
/*    */   @Shadow
/*    */   @Final
/*    */   private Map<class_1113, class_4235.class_4236> field_18950;
/*    */   @Unique
/*    */   private int rustmine$ticks;
/*    */   
/*    */   @Inject(method = {"method_4854"}, at = {@At(value = "INVOKE", target = "Ljava/util/Map;put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", ordinal = 1, shift = At.Shift.AFTER)})
/*    */   private void rustmine$muffleNew(class_1113 sound, CallbackInfoReturnable<?> cir) {
/* 32 */     class_4235.class_4236 handle = this.field_18950.get(sound);
/* 33 */     int level = SoundMuffle.level(sound);
/* 34 */     if (handle != null && level > 0) handle.method_19735(ch -> SoundMuffle.apply(ch, level)); 
/*    */   }
/*    */   
/*    */   @Inject(method = {"method_20185"}, at = {@At("TAIL")})
/*    */   private void rustmine$muffleUpdate(boolean paused, CallbackInfo ci) {
/* 39 */     if (paused || ++this.rustmine$ticks % 5 != 0)
/* 40 */       return;  this.field_18950.forEach((sound, handle) -> {
/*    */           int level = SoundMuffle.level(sound);
/*    */           handle.method_19735(());
/*    */         });
/*    */   }
/*    */ }


/* Location:              C:\Users\SystemX\AppData\Local\IceCubeRust\game\mods\rustmine-0.1.2.jar!\net\rustmine\client\mixin\SoundEngineMixin.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */
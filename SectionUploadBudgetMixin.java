/*    */ package net.rustmine.client.mixin;
/*    */ 
/*    */ import java.util.Queue;
/*    */ import net.fabricmc.api.EnvType;
/*    */ import net.fabricmc.api.Environment;
/*    */ import net.minecraft.class_11517;
/*    */ import net.minecraft.class_846;
/*    */ import org.spongepowered.asm.mixin.Final;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.Shadow;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ import org.spongepowered.asm.mixin.injection.Inject;
/*    */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Environment(EnvType.CLIENT)
/*    */ @Mixin({class_846.class})
/*    */ abstract class SectionUploadBudgetMixin
/*    */ {
/*    */   private static final long BUDGET_NS = 2000000L;
/*    */   
/*    */   @Inject(method = {"method_22761"}, at = {@At("HEAD")}, cancellable = true)
/*    */   private void rustmine$budget(CallbackInfo ci) {
/* 27 */     long end = System.nanoTime() + 2000000L;
/*    */     Runnable r;
/* 29 */     while ((r = this.field_4443.poll()) != null) {
/* 30 */       r.run();
/* 31 */       if (System.nanoTime() > end)
/*    */         break; 
/*    */     }  class_11517 m;
/* 34 */     for (; (m = this.field_61029.poll()) != null; m.close());
/* 35 */     ci.cancel();
/*    */   }
/*    */   
/*    */   @Shadow
/*    */   @Final
/*    */   private Queue<Runnable> field_4443;
/*    */   @Shadow
/*    */   @Final
/*    */   Queue<class_11517> field_61029;
/*    */ }


/* Location:              C:\Users\SystemX\AppData\Local\IceCubeRust\game\mods\rustmine-0.1.2.jar!\net\rustmine\client\mixin\SectionUploadBudgetMixin.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */
/*    */ package net.rustmine.client.mixin;
/*    */ import java.util.Arrays;
/*    */ import net.fabricmc.api.EnvType;
/*    */ import net.fabricmc.api.Environment;
/*    */ import net.minecraft.class_3283;
/*    */ import net.minecraft.class_3285;
/*    */ import net.rustmine.client.vault.VaultPackSource;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ import org.spongepowered.asm.mixin.injection.ModifyVariable;
/*    */ 
/*    */ @Environment(EnvType.CLIENT)
/*    */ @Mixin({class_3283.class})
/*    */ public abstract class PackRepositoryMixin {
/*    */   @ModifyVariable(method = {"<init>"}, at = @At("HEAD"), argsOnly = true)
/*    */   private static class_3285[] rustmine$addVault(class_3285[] sources) {
/* 17 */     class_3285[] all = Arrays.<class_3285>copyOf(sources, sources.length + 1);
/* 18 */     all[sources.length] = (class_3285)new VaultPackSource();
/* 19 */     return all;
/*    */   }
/*    */ }


/* Location:              C:\Users\SystemX\AppData\Local\IceCubeRust\game\mods\rustmine-0.1.2.jar!\net\rustmine\client\mixin\PackRepositoryMixin.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */
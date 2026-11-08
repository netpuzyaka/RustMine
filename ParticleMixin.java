/*    */ package net.rustmine.client.mixin;
/*    */ import java.util.List;
/*    */ import net.fabricmc.api.EnvType;
/*    */ import net.fabricmc.api.Environment;
/*    */ import net.minecraft.class_1297;
/*    */ import net.minecraft.class_1937;
/*    */ import net.minecraft.class_238;
/*    */ import net.minecraft.class_243;
/*    */ import net.minecraft.class_265;
/*    */ import net.minecraft.class_703;
/*    */ import net.rustmine.client.building.WorldSolids;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ import org.spongepowered.asm.mixin.injection.Redirect;
/*    */ 
/*    */ @Environment(EnvType.CLIENT)
/*    */ @Mixin({class_703.class})
/*    */ abstract class ParticleMixin {
/*    */   @Redirect(method = {"method_3069"}, at = @At(value = "INVOKE", target = "Lnet/minecraft/class_1297;method_20736(Lnet/minecraft/class_1297;Lnet/minecraft/class_243;Lnet/minecraft/class_238;Lnet/minecraft/class_1937;Ljava/util/List;)Lnet/minecraft/class_243;"))
/*    */   private class_243 rustmine$buildingCollision(class_1297 entity, class_243 move, class_238 box, class_1937 level, List<class_265> shapes) {
/* 21 */     class_243 v = class_1297.method_20736(entity, move, box, level, shapes);
/* 22 */     if (!WorldSolids.blocked(level, box.method_997(v))) return v;
/*    */     
/* 24 */     double y = WorldSolids.blocked(level, box.method_989(0.0D, v.field_1351, 0.0D)) ? 0.0D : v.field_1351;
/* 25 */     boolean side = WorldSolids.blocked(level, box.method_989(v.field_1352, y, v.field_1350));
/* 26 */     return new class_243(side ? 0.0D : v.field_1352, y, side ? 0.0D : v.field_1350);
/*    */   }
/*    */ }


/* Location:              C:\Users\SystemX\AppData\Local\IceCubeRust\game\mods\rustmine-0.1.2.jar!\net\rustmine\client\mixin\ParticleMixin.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */
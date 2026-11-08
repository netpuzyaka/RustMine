/*    */ package net.rustmine.mixin;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import net.minecraft.class_1297;
/*    */ import net.minecraft.class_1924;
/*    */ import net.minecraft.class_1937;
/*    */ import net.minecraft.class_238;
/*    */ import net.minecraft.class_265;
/*    */ import net.rustmine.collision.MeshColliderManager;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ import org.spongepowered.asm.mixin.injection.Inject;
/*    */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
/*    */ 
/*    */ @Mixin({class_1924.class})
/*    */ public interface EntityGetterMixin {
/*    */   @Inject(method = {"method_20743"}, at = {@At("RETURN")}, cancellable = true)
/*    */   default void rustmine$addMeshEntityCollisions(class_1297 entity, class_238 aABB, CallbackInfoReturnable<List<class_265>> cir) {
/* 20 */     EntityGetterMixin entityGetterMixin = this; if (entityGetterMixin instanceof class_1937) { class_1937 level = (class_1937)entityGetterMixin;
/* 21 */       List<class_265> meshShapes = MeshColliderManager.getCollisions(level, entity, aABB);
/* 22 */       if (!meshShapes.isEmpty()) {
/* 23 */         List<class_265> shapes = (List<class_265>)cir.getReturnValue();
/* 24 */         List<class_265> merged = new ArrayList<>(shapes.size() + meshShapes.size());
/* 25 */         merged.addAll(shapes);
/* 26 */         merged.addAll(meshShapes);
/* 27 */         cir.setReturnValue(merged);
/*    */       }  }
/*    */   
/*    */   }
/*    */ }


/* Location:              C:\Users\SystemX\AppData\Local\IceCubeRust\game\mods\rustmine-0.1.2.jar!\net\rustmine\mixin\EntityGetterMixin.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */
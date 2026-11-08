/*    */ package net.rustmine;
/*    */ 
/*    */ import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
/*    */ import net.minecraft.class_1263;
/*    */ import net.minecraft.class_1297;
/*    */ import net.minecraft.class_1542;
/*    */ import net.minecraft.class_1657;
/*    */ import net.minecraft.class_1799;
/*    */ import net.minecraft.class_1937;
/*    */ import net.minecraft.class_243;
/*    */ import net.minecraft.class_3222;
/*    */ import net.minecraft.class_3417;
/*    */ import net.minecraft.class_3419;
/*    */ import net.minecraft.class_5819;
/*    */ import net.minecraft.class_7923;
/*    */ import net.rustmine.building.BuildingCollision;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class GroundItems
/*    */ {
/*    */   public static final double REACH = 4.0D;
/*    */   
/*    */   public static void spill(class_1937 level, double x, double y, double z, class_1263 container) {
/* 29 */     for (int i = 0; i < container.method_5439(); i++) {
/* 30 */       class_1799 stack = container.method_5438(i);
/* 31 */       if (!stack.method_7960()) drop(level, x, y, z, stack.method_7972()); 
/*    */     } 
/*    */   }
/*    */   
/*    */   public static void spill(class_1937 level, class_1297 at, class_1263 container) {
/* 36 */     spill(level, at.method_23317(), at.method_23318(), at.method_23321(), container);
/*    */   }
/*    */ 
/*    */   
/*    */   public static void drop(class_1937 level, double x, double y, double z, class_1799 stack) {
/* 41 */     class_5819 r = level.method_8409();
/* 42 */     class_1542 item = new class_1542(level, x + (r.method_43058() - 0.5D) * 0.5D, y + 0.5D + r.method_43058() * 0.5D, z + (r.method_43058() - 0.5D) * 0.5D, stack);
/* 43 */     item.method_18800(r.method_43385(0.0D, 0.11485D), 0.2D, r.method_43385(0.0D, 0.11485D));
/* 44 */     item.method_6988();
/* 45 */     level.method_8649((class_1297)item);
/*    */   }
/*    */   
/*    */   public static void pickUp(class_3222 player, int entityId) {
/* 49 */     if (!player.method_5805() || RustWoundedManager.isWounded(player.method_5667()) || RustSleeperManager.isSleeping((class_1657)player))
/*    */       return; 
/* 51 */     class_1297 class_1297 = player.method_51469().method_8469(entityId); if (class_1297 instanceof class_1542) { class_1542 item = (class_1542)class_1297; if (!item.method_31481() && 
/* 52 */         !((RustDespawnableItem)item).rustmine$neverPickedUp()) {
/* 53 */         class_243 eye = player.method_33571(), at = item.method_5829().method_1005();
/* 54 */         if (eye.method_1022(at) > 5.0D)
/*    */           return; 
/* 56 */         class_243 over = new class_243(at.field_1352, (item.method_5829()).field_1325 + 0.05D, at.field_1350);
/* 57 */         if (!BuildingCollision.hasLineOfSight((class_1937)player.method_51469(), eye, at) && !BuildingCollision.hasLineOfSight((class_1937)player.method_51469(), eye, over))
/*    */           return; 
/* 59 */         class_1799 stack = item.method_6983();
/* 60 */         if (stack.method_7960())
/* 61 */           return;  class_1799 kind = stack.method_7972();
/* 62 */         int before = stack.method_7947();
/* 63 */         player.method_31548().method_7394(stack);
/* 64 */         int taken = before - stack.method_7947();
/* 65 */         if (taken <= 0)
/* 66 */           return;  if (stack.method_7960()) { item.method_31472(); }
/* 67 */         else { item.method_6979(stack); }
/* 68 */          player.method_51469().method_43128(null, player.method_23317(), player.method_23318(), player.method_23321(), class_3417.field_15197, class_3419.field_15248, 0.2F, 1.0F);
/* 69 */         String id = class_7923.field_41178.method_10221(kind.method_7909()).toString();
/* 70 */         ServerPlayNetworking.send(player, new RustItemNoticePayload(id, taken));
/*    */         return;
/*    */       }  }
/*    */   
/*    */   }
/*    */ }


/* Location:              C:\Users\SystemX\AppData\Local\IceCubeRust\game\mods\rustmine-0.1.2.jar!\net\rustmine\GroundItems.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */
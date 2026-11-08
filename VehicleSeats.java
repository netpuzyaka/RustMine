/*    */ package net.rustmine;
/*    */ 
/*    */ import com.rustboats.entity.BaseRustMotorboatEntity;
/*    */ import com.rustboats.entity.KayakEntity;
/*    */ import com.rustminicopter.entity.MinicopterEntity;
/*    */ import net.minecraft.class_1297;
/*    */ import net.rustmine.seat.MountRules;
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class VehicleSeats
/*    */ {
/*    */   public static boolean isDriver(class_1297 e) {
/* 14 */     if (e == null) return false; 
/* 15 */     class_1297 v = e.method_5854();
/* 16 */     if (v instanceof MinicopterEntity) { MinicopterEntity c = (MinicopterEntity)v; return (c.getSeatIndex(e) == 0); }
/* 17 */      if (v instanceof BaseRustMotorboatEntity) { BaseRustMotorboatEntity b = (BaseRustMotorboatEntity)v; return (b.getSeatIndex(e) == 0); }
/* 18 */      if (v instanceof KayakEntity) { KayakEntity k = (KayakEntity)v; return (k.getSeatIndex(e) == 0); }
/* 19 */      return false;
/*    */   }
/*    */ 
/*    */   
/*    */   public static boolean canWieldItems(class_1297 e) {
/* 24 */     MountRules.Seat seat = MountRules.of(e);
/* 25 */     return (seat == null || seat.canWieldItems());
/*    */   }
/*    */ 
/*    */   
/*    */   public static boolean handsBusy(class_1297 e) {
/* 30 */     return (e != null && e.method_5854() != null && !canWieldItems(e));
/*    */   }
/*    */ }


/* Location:              C:\Users\SystemX\AppData\Local\IceCubeRust\game\mods\rustmine-0.1.2.jar!\net\rustmine\VehicleSeats.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */
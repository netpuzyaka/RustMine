/*    */ package net.rustmine;
/*    */ 
/*    */ import java.util.List;
/*    */ import net.minecraft.class_1657;
/*    */ import net.minecraft.class_3222;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class RustVitalsManager
/*    */ {
/*    */   public static volatile Api impl;
/*    */   
/*    */   public static RustVitalsData get(class_1657 player) {
/* 23 */     Api a = impl;
/* 24 */     return (a == null) ? new RustVitalsData() : a.get(player);
/*    */   }
/*    */   
/*    */   public static void sync(class_3222 player, RustVitalsData v) {
/* 28 */     Api a = impl;
/* 29 */     if (a != null) a.sync(player, v); 
/*    */   }
/*    */   
/*    */   public static void useMedkit(class_3222 player) {
/* 33 */     Api a = impl;
/* 34 */     if (a != null) a.useMedkit(player); 
/*    */   }
/*    */   
/*    */   public static void drinkWater(class_3222 player) {
/* 38 */     Api a = impl;
/* 39 */     if (a != null) a.drinkWater(player); 
/*    */   }
/*    */   
/*    */   public static void onMeleeHit(class_3222 victim, float baseMeleeDamage, RustWearManager.Hitbox hitbox, class_3222 attacker) {
/* 43 */     Api a = impl;
/* 44 */     if (a != null) a.onMeleeHit(victim, baseMeleeDamage, hitbox, attacker); 
/*    */   }
/*    */   
/*    */   public static void consume(class_3222 player, List<RustConsumables.Effect> effects) {
/* 48 */     Api a = impl;
/* 49 */     if (a != null) a.consume(player, effects); 
/*    */   }
/*    */   
/*    */   public static interface Api {
/*    */     RustVitalsData get(class_1657 param1class_1657);
/*    */     
/*    */     void sync(class_3222 param1class_3222, RustVitalsData param1RustVitalsData);
/*    */     
/*    */     void useMedkit(class_3222 param1class_3222);
/*    */     
/*    */     void drinkWater(class_3222 param1class_3222);
/*    */     
/*    */     void onMeleeHit(class_3222 param1class_32221, float param1Float, RustWearManager.Hitbox param1Hitbox, class_3222 param1class_32222);
/*    */     
/*    */     void consume(class_3222 param1class_3222, List<RustConsumables.Effect> param1List);
/*    */   }
/*    */ }


/* Location:              C:\Users\SystemX\AppData\Local\IceCubeRust\game\mods\rustmine-0.1.2.jar!\net\rustmine\RustVitalsManager.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */
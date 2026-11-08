/*    */ package net.rustmine;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import java.util.UUID;
/*    */ import net.minecraft.class_1297;
/*    */ import net.minecraft.class_1792;
/*    */ import net.minecraft.class_1799;
/*    */ import net.minecraft.class_239;
/*    */ import net.minecraft.class_243;
/*    */ import net.minecraft.class_2487;
/*    */ import net.minecraft.class_3222;
/*    */ import net.minecraft.class_3414;
/*    */ import net.minecraft.class_3417;
/*    */ import net.minecraft.class_3419;
/*    */ import net.minecraft.class_3532;
/*    */ import net.minecraft.class_3959;
/*    */ import net.minecraft.class_3965;
/*    */ import net.minecraft.class_9279;
/*    */ import net.minecraft.class_9334;
/*    */ 
/*    */ public class WaterBottleItem extends class_1792 {
/*    */   public static final int CAPACITY = 250;
/* 23 */   private static final Map<UUID, Long> LAST_DRUNK = new HashMap<>(); public static final int DEFAULT = 120; public static final int DRINK = 50;
/*    */   
/*    */   public WaterBottleItem(class_1792.class_1793 properties) {
/* 26 */     super(properties);
/*    */   }
/*    */   
/*    */   public static int water(class_1799 stack) {
/* 30 */     class_9279 data = (class_9279)stack.method_58694(class_9334.field_49628);
/* 31 */     return (data == null) ? 120 : data.method_57461().method_68083("water", 120);
/*    */   }
/*    */   
/*    */   public static void setWater(class_1799 stack, int water) {
/* 35 */     class_9279.method_57452(class_9334.field_49628, stack, tag -> tag.method_10569("water", class_3532.method_15340(water, 0, 250)));
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean method_31567(class_1799 stack) {
/* 40 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public int method_31569(class_1799 stack) {
/* 45 */     return Math.round(13.0F * water(stack) / 250.0F);
/*    */   }
/*    */ 
/*    */   
/*    */   public int method_31571(class_1799 stack) {
/* 50 */     return 4164832;
/*    */   }
/*    */ 
/*    */   
/*    */   public static void use(class_3222 player) {
/* 55 */     use(player, player.method_6047());
/*    */   }
/*    */   
/*    */   public static void use(class_3222 player, class_1799 stack) {
/* 59 */     if (!(stack.method_7909() instanceof WaterBottleItem))
/* 60 */       return;  int water = water(stack);
/* 61 */     if (water < 250 && aimedAtWater(player)) {
/* 62 */       setWater(stack, 250);
/* 63 */       player.method_51469().method_43128(null, player.method_23317(), player.method_23318(), player.method_23321(), class_3417.field_15126, class_3419.field_15248, 0.8F, 1.0F);
/*    */       return;
/*    */     } 
/* 66 */     RustConsumables.Consumable drink = RustConsumables.water();
/* 67 */     if (drink == null || water < 50)
/* 68 */       return;  long now = System.currentTimeMillis();
/* 69 */     Long last = LAST_DRUNK.get(player.method_5667());
/* 70 */     if (last != null && (float)(now - last.longValue()) < 900.0F)
/* 71 */       return;  LAST_DRUNK.put(player.method_5667(), Long.valueOf(now));
/* 72 */     setWater(stack, water - 50);
/* 73 */     RustVitalsManager.consume(player, drink.effects());
/* 74 */     player.method_51469().method_43128(null, player.method_23317(), player.method_23318(), player.method_23321(), (class_3414)class_3417.field_20613.comp_349(), class_3419.field_15248, 0.9F, 1.0F);
/*    */   }
/*    */   
/*    */   private static boolean aimedAtWater(class_3222 player) {
/* 78 */     class_243 eye = player.method_33571();
/* 79 */     class_243 end = eye.method_1019(player.method_5720().method_1021(4.0D));
/* 80 */     class_3965 hit = player.method_51469().method_17742(new class_3959(eye, end, class_3959.class_3960.field_17558, class_3959.class_242.field_1345, (class_1297)player));
/* 81 */     return (hit.method_17783() == class_239.class_240.field_1332 && player.method_51469().method_8316(hit.method_17777()).method_15767(class_3486.field_15517));
/*    */   }
/*    */ }


/* Location:              C:\Users\SystemX\AppData\Local\IceCubeRust\game\mods\rustmine-0.1.2.jar!\net\rustmine\WaterBottleItem.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */
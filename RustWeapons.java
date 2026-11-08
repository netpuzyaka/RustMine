/*    */ package net.rustmine.combat;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import net.minecraft.class_1792;
/*    */ import net.minecraft.class_2378;
/*    */ import net.minecraft.class_5321;
/*    */ import net.minecraft.class_7923;
/*    */ import net.minecraft.class_7924;
/*    */ import net.rustmine.RustmineMod;
/*    */ 
/*    */ public final class RustWeapons
/*    */ {
/* 14 */   public static final class_5321<class_1792> AK_KEY = class_5321.method_29179(class_7924.field_41197, RustmineMod.id("ak47"));
/* 15 */   public static final class_1792 AK = (class_1792)class_2378.method_39197((class_2378)class_7923.field_41178, AK_KEY, new RustWeaponItem((new class_1792.class_1793()).method_63686(AK_KEY).method_7889(1)));
/*    */ 
/*    */   
/* 18 */   public static final class_5321<class_1792> LAUNCHER_KEY = class_5321.method_29179(class_7924.field_41197, RustmineMod.id("rocket_launcher"));
/* 19 */   public static final class_1792 ROCKET_LAUNCHER = (class_1792)class_2378.method_39197((class_2378)class_7923.field_41178, LAUNCHER_KEY, new RustWeaponItem((new class_1792.class_1793())
/* 20 */         .method_63686(LAUNCHER_KEY).method_7889(1)));
/*    */ 
/*    */   
/* 23 */   public static final class_1792 SAR = weaponItem("semi_auto_rifle");
/* 24 */   public static final class_1792 SAP = weaponItem("semi_auto_pistol");
/* 25 */   public static final class_1792 THOMPSON = weaponItem("thompson");
/* 26 */   public static final class_1792 MP5 = weaponItem("mp5");
/* 27 */   public static final class_1792 SMG = weaponItem("smg");
/* 28 */   public static final class_1792 BOLT = weaponItem("bolt");
/* 29 */   public static final class_1792 PYTHON = weaponItem("python");
/* 30 */   public static final class_1792 REVOLVER = weaponItem("revolver");
/* 31 */   public static final class_1792 PUMP_SHOTGUN = weaponItem("pump_shotgun");
/* 32 */   public static final class_1792 DOUBLE_BARREL = weaponItem("double_barrel");
/* 33 */   public static final class_1792 WATERPIPE = weaponItem("waterpipe");
/* 34 */   public static final class_1792 EOKA = weaponItem("eoka");
/* 35 */   public static final class_1792 M92 = weaponItem("m92");
/* 36 */   public static final class_1792 M39 = weaponItem("m39");
/* 37 */   public static final class_1792 M249 = weaponItem("m249");
/* 38 */   public static final class_1792 CROSSBOW = weaponItem("crossbow");
/* 39 */   public static final class_1792 BOW = weaponItem("bow");
/* 40 */   public static final class_1792 HUNTING_BOW = BOW;
/* 41 */   public static final class_1792 LR300 = weaponItem("lr300");
/* 42 */   public static final class_1792 L96 = weaponItem("l96");
/*    */ 
/*    */   
/* 45 */   public static final Map<class_1792, WeaponStats> GUNS = new HashMap<>();
/*    */   
/*    */   static {
/* 48 */     GUNS.put(AK, new WeaponStats("ak47"));
/* 49 */     GUNS.put(SAR, new WeaponStats("sar"));
/* 50 */     GUNS.put(SAP, new WeaponStats("sap"));
/* 51 */     GUNS.put(THOMPSON, new WeaponStats("thompson"));
/* 52 */     GUNS.put(MP5, new WeaponStats("mp5"));
/* 53 */     GUNS.put(SMG, new WeaponStats("smg"));
/* 54 */     GUNS.put(BOLT, new WeaponStats("bolt"));
/* 55 */     GUNS.put(PYTHON, new WeaponStats("python"));
/* 56 */     GUNS.put(REVOLVER, new WeaponStats("revolver"));
/* 57 */     GUNS.put(PUMP_SHOTGUN, new WeaponStats("pump_shotgun"));
/* 58 */     GUNS.put(DOUBLE_BARREL, new WeaponStats("double_barrel"));
/* 59 */     GUNS.put(WATERPIPE, new WeaponStats("waterpipe"));
/* 60 */     GUNS.put(EOKA, new WeaponStats("eoka"));
/* 61 */     GUNS.put(M92, new WeaponStats("m92"));
/* 62 */     GUNS.put(M39, new WeaponStats("m39"));
/* 63 */     GUNS.put(M249, new WeaponStats("m249"));
/* 64 */     GUNS.put(CROSSBOW, new WeaponStats("crossbow"));
/* 65 */     GUNS.put(BOW, new WeaponStats("bow"));
/* 66 */     GUNS.put(LR300, new WeaponStats("lr300"));
/* 67 */     GUNS.put(L96, new WeaponStats("l96"));
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public static class_1792 weaponItem(String name) {
/* 73 */     class_5321<class_1792> key = class_5321.method_29179(class_7924.field_41197, RustmineMod.id(name));
/* 74 */     return (class_1792)class_2378.method_39197((class_2378)class_7923.field_41178, key, new RustWeaponItem((new class_1792.class_1793()).method_63686(key).method_7889(1)));
/*    */   }
/*    */   
/*    */   public static WeaponStats getStats(class_1792 item) {
/* 78 */     return GUNS.get(item);
/*    */   }
/*    */   
/*    */   public static boolean isGun(class_1792 item) {
/* 82 */     return GUNS.containsKey(item);
/*    */   }
/*    */   
/*    */   public static void init() {}
/*    */ }


/* Location:              C:\Users\SystemX\AppData\Local\IceCubeRust\game\mods\rustmine-0.1.2.jar!\net\rustmine\combat\RustWeapons.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */
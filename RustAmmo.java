/*    */ package net.rustmine.combat;
/*    */ 
/*    */ import net.minecraft.class_1792;
/*    */ import net.minecraft.class_2378;
/*    */ import net.minecraft.class_5321;
/*    */ import net.minecraft.class_7923;
/*    */ import net.minecraft.class_7924;
/*    */ import net.rustmine.RustmineMod;
/*    */ 
/*    */ public final class RustAmmo
/*    */ {
/* 12 */   public static final class_5321<class_1792> AMMO_556_KEY = class_5321.method_29179(class_7924.field_41197, RustmineMod.id("ammo_556"));
/* 13 */   public static final class_1792 AMMO_556 = (class_1792)class_2378.method_39197((class_2378)class_7923.field_41178, AMMO_556_KEY, new class_1792((new class_1792.class_1793())
/* 14 */         .method_63686(AMMO_556_KEY).method_7889(99)));
/* 15 */   public static final class_5321<class_1792> AMMO_556_EXP_KEY = class_5321.method_29179(class_7924.field_41197, RustmineMod.id("ammo_556_explosive"));
/* 16 */   public static final class_1792 AMMO_556_EXP = (class_1792)class_2378.method_39197((class_2378)class_7923.field_41178, AMMO_556_EXP_KEY, new class_1792((new class_1792.class_1793())
/* 17 */         .method_63686(AMMO_556_EXP_KEY).method_7889(99)));
/* 18 */   public static final class_1792 AMMO_556_HV = ammoItem("ammo_556_hv", 99);
/* 19 */   public static final class_1792 AMMO_556_INC = ammoItem("ammo_556_incendiary", 99);
/*    */ 
/*    */   
/* 22 */   public static final class_5321<class_1792> AMMO_PISTOL_KEY = class_5321.method_29179(class_7924.field_41197, RustmineMod.id("ammo_pistol"));
/* 23 */   public static final class_1792 AMMO_PISTOL = (class_1792)class_2378.method_39197((class_2378)class_7923.field_41178, AMMO_PISTOL_KEY, new class_1792((new class_1792.class_1793())
/* 24 */         .method_63686(AMMO_PISTOL_KEY).method_7889(99)));
/* 25 */   public static final class_1792 AMMO_PISTOL_HV = ammoItem("ammo_pistol_hv", 99);
/* 26 */   public static final class_1792 AMMO_PISTOL_INC = ammoItem("ammo_pistol_fire", 99);
/*    */ 
/*    */   
/* 29 */   public static final class_1792 SHOTGUN_BUCKSHOT = ammoItem("ammo_shotgun", 64);
/* 30 */   public static final class_1792 SHOTGUN_SLUG = ammoItem("ammo_shotgun_slug", 64);
/* 31 */   public static final class_1792 SHOTGUN_INC = ammoItem("ammo_shotgun_fire", 64);
/* 32 */   public static final class_1792 SHOTGUN_HANDMADE = ammoItem("ammo_handmade_shell", 64);
/*    */ 
/*    */   
/* 35 */   public static final class_5321<class_1792> AMMO_ROCKET_KEY = class_5321.method_29179(class_7924.field_41197, RustmineMod.id("ammo_rocket_basic"));
/* 36 */   public static final class_1792 AMMO_ROCKET = (class_1792)class_2378.method_39197((class_2378)class_7923.field_41178, AMMO_ROCKET_KEY, new class_1792((new class_1792.class_1793())
/* 37 */         .method_63686(AMMO_ROCKET_KEY).method_7889(3)));
/* 38 */   public static final class_1792 ROCKET_HV = ammoItem("ammo_rocket_hv", 3);
/* 39 */   public static final class_1792 ROCKET_INC = ammoItem("ammo_rocket_fire", 3);
/*    */ 
/*    */   
/* 42 */   public static final class_1792 ARROW_WOODEN = ammoItem("arrow_wooden", 64);
/* 43 */   public static final class_1792 ARROW_HV = ammoItem("arrow_hv", 64);
/* 44 */   public static final class_1792 ARROW_FIRE = ammoItem("arrow_fire", 64);
/* 45 */   public static final class_1792 ARROW_BONE = ammoItem("arrow_bone", 64);
/*    */ 
/*    */ 
/*    */   
/*    */   public static class_1792 ammoItem(String name, int maxStack) {
/* 50 */     class_5321<class_1792> key = class_5321.method_29179(class_7924.field_41197, RustmineMod.id(name));
/* 51 */     return (class_1792)class_2378.method_39197((class_2378)class_7923.field_41178, key, new class_1792((new class_1792.class_1793()).method_63686(key).method_7889(maxStack)));
/*    */   }
/*    */   
/*    */   public static void init() {}
/*    */ }


/* Location:              C:\Users\SystemX\AppData\Local\IceCubeRust\game\mods\rustmine-0.1.2.jar!\net\rustmine\combat\RustAmmo.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */
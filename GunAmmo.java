/*     */ package net.rustmine.combat;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import net.minecraft.class_1657;
/*     */ import net.minecraft.class_1792;
/*     */ import net.minecraft.class_1799;
/*     */ import net.minecraft.class_1935;
/*     */ import net.minecraft.class_2487;
/*     */ import net.minecraft.class_9279;
/*     */ import net.minecraft.class_9334;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class GunAmmo
/*     */ {
/*     */   public static final String KEY_AMMO = "rust_ammo";
/*     */   public static final String KEY_AMMO_TYPE = "rust_ammo_type";
/*     */   public static final String TYPE_556 = "rustmine:ammo_556";
/*     */   public static final String TYPE_556_EXP = "rustmine:ammo_556_explosive";
/*     */   public static final String TYPE_556_HV = "rustmine:ammo_556_hv";
/*     */   public static final String TYPE_556_INC = "rustmine:ammo_556_incendiary";
/*     */   public static final String TYPE_PISTOL = "rustmine:ammo_pistol";
/*     */   public static final String TYPE_PISTOL_HV = "rustmine:ammo_pistol_hv";
/*     */   public static final String TYPE_PISTOL_INC = "rustmine:ammo_pistol_fire";
/*     */   public static final String TYPE_SHOTGUN_BUCK = "rustmine:ammo_shotgun";
/*     */   public static final String TYPE_SHOTGUN_SLUG = "rustmine:ammo_shotgun_slug";
/*     */   public static final String TYPE_SHOTGUN_INC = "rustmine:ammo_shotgun_fire";
/*     */   public static final String TYPE_SHOTGUN_HANDMADE = "rustmine:ammo_handmade_shell";
/*     */   public static final String TYPE_ROCKET = "rustmine:ammo_rocket_basic";
/*     */   public static final String TYPE_ROCKET_HV = "rustmine:ammo_rocket_hv";
/*     */   public static final String TYPE_ROCKET_INC = "rustmine:ammo_rocket_fire";
/*     */   public static final String TYPE_ARROW_WOOD = "rustmine:arrow_wooden";
/*     */   public static final String TYPE_ARROW_HV = "rustmine:arrow_hv";
/*     */   public static final String TYPE_ARROW_FIRE = "rustmine:arrow_fire";
/*     */   public static final String TYPE_ARROW_BONE = "rustmine:arrow_bone";
/*     */   
/*     */   public static boolean isGun(class_1799 stack) {
/*  47 */     if (stack == null || stack.method_7960()) return false; 
/*  48 */     class_1792 item = stack.method_7909();
/*  49 */     return (RustWeapons.GUNS.containsKey(item) || item == RustWeapons.ROCKET_LAUNCHER);
/*     */   }
/*     */   
/*     */   public static int getMaxCapacity(class_1792 item) {
/*  53 */     if (item == RustWeapons.ROCKET_LAUNCHER) return 1; 
/*  54 */     WeaponStats stats = RustWeapons.GUNS.get(item);
/*  55 */     if (stats != null) return stats.magazine; 
/*  56 */     return 0;
/*     */   }
/*     */   
/*     */   public static int getAmmo(class_1799 stack) {
/*  60 */     if (!isGun(stack)) return 0; 
/*  61 */     class_9279 cd = (class_9279)stack.method_58694(class_9334.field_49628);
/*  62 */     if (cd == null) return -1; 
/*  63 */     class_2487 tag = cd.method_57461();
/*  64 */     return tag.method_68083("rust_ammo", -1);
/*     */   }
/*     */   
/*     */   public static void setAmmo(class_1799 stack, int count) {
/*  68 */     if (!isGun(stack))
/*  69 */       return;  int max = getMaxCapacity(stack.method_7909());
/*  70 */     int clamped = Math.max(0, Math.min(count, max));
/*  71 */     class_9279.method_57452(class_9334.field_49628, stack, tag -> tag.method_10569("rust_ammo", clamped));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class_1799 takeLoaded(class_1799 gun) {
/*  78 */     int n = getAmmo(gun);
/*  79 */     if (n <= 0) return class_1799.field_8037; 
/*  80 */     String type = getAmmoType(gun);
/*  81 */     class_1792 item = getAmmoItem((type == null || type.isEmpty()) ? getDefaultAmmoType(gun.method_7909()) : type);
/*  82 */     setAmmo(gun, 0);
/*  83 */     return (item == null) ? class_1799.field_8037 : new class_1799((class_1935)item, n);
/*     */   }
/*     */   
/*     */   public static String getAmmoType(class_1799 stack) {
/*  87 */     if (!isGun(stack)) return ""; 
/*  88 */     class_9279 cd = (class_9279)stack.method_58694(class_9334.field_49628);
/*  89 */     if (cd == null) return ""; 
/*  90 */     class_2487 tag = cd.method_57461();
/*  91 */     return tag.method_68564("rust_ammo_type", "");
/*     */   }
/*     */   
/*     */   public static void setAmmoType(class_1799 stack, String type) {
/*  95 */     if (!isGun(stack))
/*  96 */       return;  class_9279.method_57452(class_9334.field_49628, stack, tag -> tag.method_10582("rust_ammo_type", (type != null) ? type : ""));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean is556Gun(class_1792 gun) {
/* 102 */     return (gun == RustWeapons.AK || gun == RustWeapons.SAR || gun == RustWeapons.BOLT || gun == RustWeapons.M39 || gun == RustWeapons.M249 || gun == RustWeapons.LR300 || gun == RustWeapons.L96);
/*     */   }
/*     */ 
/*     */   
/*     */   public static boolean isPistolGun(class_1792 gun) {
/* 107 */     return (gun == RustWeapons.SAP || gun == RustWeapons.THOMPSON || gun == RustWeapons.MP5 || gun == RustWeapons.SMG || gun == RustWeapons.PYTHON || gun == RustWeapons.REVOLVER || gun == RustWeapons.M92);
/*     */   }
/*     */ 
/*     */   
/*     */   public static boolean isShotgun(class_1792 gun) {
/* 112 */     return (gun == RustWeapons.PUMP_SHOTGUN || gun == RustWeapons.DOUBLE_BARREL || gun == RustWeapons.WATERPIPE || gun == RustWeapons.EOKA);
/*     */   }
/*     */   
/*     */   public static boolean isBow(class_1792 gun) {
/* 116 */     return (gun == RustWeapons.CROSSBOW || gun == RustWeapons.BOW);
/*     */   }
/*     */   
/*     */   public static List<String> getAvailableTypes(class_1792 gun) {
/* 120 */     List<String> list = new ArrayList<>();
/* 121 */     if (is556Gun(gun)) {
/* 122 */       list.add("rustmine:ammo_556");
/* 123 */       list.add("rustmine:ammo_556_explosive");
/* 124 */       list.add("rustmine:ammo_556_hv");
/* 125 */       list.add("rustmine:ammo_556_incendiary");
/* 126 */     } else if (isPistolGun(gun)) {
/* 127 */       list.add("rustmine:ammo_pistol");
/* 128 */       list.add("rustmine:ammo_pistol_hv");
/* 129 */       list.add("rustmine:ammo_pistol_fire");
/* 130 */     } else if (isShotgun(gun)) {
/* 131 */       list.add("rustmine:ammo_shotgun");
/* 132 */       list.add("rustmine:ammo_shotgun_slug");
/* 133 */       list.add("rustmine:ammo_shotgun_fire");
/* 134 */       list.add("rustmine:ammo_handmade_shell");
/* 135 */     } else if (gun == RustWeapons.ROCKET_LAUNCHER) {
/* 136 */       list.add("rustmine:ammo_rocket_basic");
/* 137 */       list.add("rustmine:ammo_rocket_hv");
/* 138 */       list.add("rustmine:ammo_rocket_fire");
/* 139 */     } else if (isBow(gun)) {
/* 140 */       list.add("rustmine:arrow_wooden");
/* 141 */       list.add("rustmine:arrow_hv");
/* 142 */       list.add("rustmine:arrow_fire");
/* 143 */       list.add("rustmine:arrow_bone");
/*     */     } 
/* 145 */     return list;
/*     */   }
/*     */   
/*     */   public static String getDefaultAmmoType(class_1792 gun) {
/* 149 */     if (is556Gun(gun)) return "rustmine:ammo_556"; 
/* 150 */     if (isPistolGun(gun)) return "rustmine:ammo_pistol"; 
/* 151 */     if (isShotgun(gun)) return "rustmine:ammo_shotgun"; 
/* 152 */     if (isBow(gun)) return "rustmine:arrow_wooden"; 
/* 153 */     if (gun == RustWeapons.ROCKET_LAUNCHER) return "rustmine:ammo_rocket_basic"; 
/* 154 */     return "rustmine:ammo_556";
/*     */   }
/*     */   
/*     */   public static class_1792 getAmmoItem(String typeId) {
/* 158 */     if ("rustmine:ammo_556".equals(typeId)) return RustAmmo.AMMO_556; 
/* 159 */     if ("rustmine:ammo_556_explosive".equals(typeId)) return RustAmmo.AMMO_556_EXP; 
/* 160 */     if ("rustmine:ammo_556_hv".equals(typeId)) return RustAmmo.AMMO_556_HV; 
/* 161 */     if ("rustmine:ammo_556_incendiary".equals(typeId)) return RustAmmo.AMMO_556_INC;
/*     */     
/* 163 */     if ("rustmine:ammo_pistol".equals(typeId)) return RustAmmo.AMMO_PISTOL; 
/* 164 */     if ("rustmine:ammo_pistol_hv".equals(typeId)) return RustAmmo.AMMO_PISTOL_HV; 
/* 165 */     if ("rustmine:ammo_pistol_fire".equals(typeId)) return RustAmmo.AMMO_PISTOL_INC;
/*     */     
/* 167 */     if ("rustmine:ammo_shotgun".equals(typeId)) return RustAmmo.SHOTGUN_BUCKSHOT; 
/* 168 */     if ("rustmine:ammo_shotgun_slug".equals(typeId)) return RustAmmo.SHOTGUN_SLUG; 
/* 169 */     if ("rustmine:ammo_shotgun_fire".equals(typeId)) return RustAmmo.SHOTGUN_INC; 
/* 170 */     if ("rustmine:ammo_handmade_shell".equals(typeId)) return RustAmmo.SHOTGUN_HANDMADE;
/*     */     
/* 172 */     if ("rustmine:ammo_rocket_basic".equals(typeId)) return RustAmmo.AMMO_ROCKET; 
/* 173 */     if ("rustmine:ammo_rocket_hv".equals(typeId)) return RustAmmo.ROCKET_HV; 
/* 174 */     if ("rustmine:ammo_rocket_fire".equals(typeId)) return RustAmmo.ROCKET_INC;
/*     */     
/* 176 */     if ("rustmine:arrow_wooden".equals(typeId)) return RustAmmo.ARROW_WOODEN; 
/* 177 */     if ("rustmine:arrow_hv".equals(typeId)) return RustAmmo.ARROW_HV; 
/* 178 */     if ("rustmine:arrow_fire".equals(typeId)) return RustAmmo.ARROW_FIRE; 
/* 179 */     if ("rustmine:arrow_bone".equals(typeId)) return RustAmmo.ARROW_BONE;
/*     */     
/* 181 */     return null;
/*     */   }
/*     */   
/*     */   public static String getTypeId(class_1792 item) {
/* 185 */     if (item == RustAmmo.AMMO_556) return "rustmine:ammo_556"; 
/* 186 */     if (item == RustAmmo.AMMO_556_EXP) return "rustmine:ammo_556_explosive"; 
/* 187 */     if (item == RustAmmo.AMMO_556_HV) return "rustmine:ammo_556_hv"; 
/* 188 */     if (item == RustAmmo.AMMO_556_INC) return "rustmine:ammo_556_incendiary";
/*     */     
/* 190 */     if (item == RustAmmo.AMMO_PISTOL) return "rustmine:ammo_pistol"; 
/* 191 */     if (item == RustAmmo.AMMO_PISTOL_HV) return "rustmine:ammo_pistol_hv"; 
/* 192 */     if (item == RustAmmo.AMMO_PISTOL_INC) return "rustmine:ammo_pistol_fire";
/*     */     
/* 194 */     if (item == RustAmmo.SHOTGUN_BUCKSHOT) return "rustmine:ammo_shotgun"; 
/* 195 */     if (item == RustAmmo.SHOTGUN_SLUG) return "rustmine:ammo_shotgun_slug"; 
/* 196 */     if (item == RustAmmo.SHOTGUN_INC) return "rustmine:ammo_shotgun_fire"; 
/* 197 */     if (item == RustAmmo.SHOTGUN_HANDMADE) return "rustmine:ammo_handmade_shell";
/*     */     
/* 199 */     if (item == RustAmmo.AMMO_ROCKET) return "rustmine:ammo_rocket_basic"; 
/* 200 */     if (item == RustAmmo.ROCKET_HV) return "rustmine:ammo_rocket_hv"; 
/* 201 */     if (item == RustAmmo.ROCKET_INC) return "rustmine:ammo_rocket_fire";
/*     */     
/* 203 */     if (item == RustAmmo.ARROW_WOODEN) return "rustmine:arrow_wooden"; 
/* 204 */     if (item == RustAmmo.ARROW_HV) return "rustmine:arrow_hv"; 
/* 205 */     if (item == RustAmmo.ARROW_FIRE) return "rustmine:arrow_fire"; 
/* 206 */     if (item == RustAmmo.ARROW_BONE) return "rustmine:arrow_bone";
/*     */     
/* 208 */     return "";
/*     */   }
/*     */   
/*     */   public static String getAmmoName(String typeId) {
/* 212 */     if ("rustmine:ammo_556".equals(typeId)) return "5.56 мм"; 
/* 213 */     if ("rustmine:ammo_556_explosive".equals(typeId)) return "5.56 мм РАЗРЫВНЫЕ"; 
/* 214 */     if ("rustmine:ammo_556_hv".equals(typeId)) return "5.56 мм СКОРОСТНЫЕ"; 
/* 215 */     if ("rustmine:ammo_556_incendiary".equals(typeId)) return "5.56 мм ЗАЖИГАТЕЛЬНЫЕ";
/*     */     
/* 217 */     if ("rustmine:ammo_pistol".equals(typeId)) return "9 мм"; 
/* 218 */     if ("rustmine:ammo_pistol_hv".equals(typeId)) return "9 мм СКОРОСТНЫЕ"; 
/* 219 */     if ("rustmine:ammo_pistol_fire".equals(typeId)) return "9 мм ЗАЖИГАТЕЛЬНЫЕ";
/*     */     
/* 221 */     if ("rustmine:ammo_shotgun".equals(typeId)) return "12к КАРТЕЧЬ"; 
/* 222 */     if ("rustmine:ammo_shotgun_slug".equals(typeId)) return "12к ПУЛЯ"; 
/* 223 */     if ("rustmine:ammo_shotgun_fire".equals(typeId)) return "12к ЗАЖИГАТЕЛЬНЫЙ"; 
/* 224 */     if ("rustmine:ammo_handmade_shell".equals(typeId)) return "12к САМОДЕЛЬНАЯ ДРОБЬ";
/*     */     
/* 226 */     if ("rustmine:ammo_rocket_basic".equals(typeId)) return "Ракета"; 
/* 227 */     if ("rustmine:ammo_rocket_hv".equals(typeId)) return "Скоростная ракета HV"; 
/* 228 */     if ("rustmine:ammo_rocket_fire".equals(typeId)) return "Зажигательная ракета";
/*     */     
/* 230 */     if ("rustmine:arrow_wooden".equals(typeId)) return "Деревянная стрела"; 
/* 231 */     if ("rustmine:arrow_hv".equals(typeId)) return "Скоростная стрела HV"; 
/* 232 */     if ("rustmine:arrow_fire".equals(typeId)) return "Огненная стрела"; 
/* 233 */     if ("rustmine:arrow_bone".equals(typeId)) return "Костяная стрела";
/*     */     
/* 235 */     return "";
/*     */   }
/*     */   
/*     */   public static int countAmmo(class_1657 player, class_1792 item) {
/* 239 */     if (player == null || item == null) return 0; 
/* 240 */     int count = 0;
/* 241 */     for (int i = 0; i < player.method_31548().method_5439(); i++) {
/* 242 */       class_1799 s = player.method_31548().method_5438(i);
/* 243 */       if (s.method_31574(item)) count += s.method_7947(); 
/*     */     } 
/* 245 */     if (player.method_6079().method_31574(item)) count += player.method_6079().method_7947(); 
/* 246 */     return count;
/*     */   }
/*     */   
/*     */   public static int consumeAmmo(class_1657 player, class_1792 item, int amount) {
/* 250 */     if (player == null || item == null || amount <= 0) return 0; 
/* 251 */     int remaining = amount;
/* 252 */     for (int i = 0; i < player.method_31548().method_5439() && 
/* 253 */       remaining > 0; i++) {
/* 254 */       class_1799 s = player.method_31548().method_5438(i);
/* 255 */       if (s.method_31574(item)) {
/* 256 */         int take = Math.min(remaining, s.method_7947());
/* 257 */         s.method_7934(take);
/* 258 */         remaining -= take;
/*     */       } 
/*     */     } 
/* 261 */     if (remaining > 0 && player.method_6079().method_31574(item)) {
/* 262 */       int take = Math.min(remaining, player.method_6079().method_7947());
/* 263 */       player.method_6079().method_7934(take);
/* 264 */       remaining -= take;
/*     */     } 
/* 266 */     return amount - remaining;
/*     */   }
/*     */   
/*     */   public static String chooseReloadAmmoType(class_1657 p, class_1799 stack) {
/* 270 */     if (!isGun(stack)) return null; 
/* 271 */     class_1792 gun = stack.method_7909();
/* 272 */     int cur = getAmmo(stack);
/*     */ 
/*     */     
/* 275 */     if (cur > 0) {
/* 276 */       String currentType = getAmmoType(stack);
/* 277 */       class_1792 matchingItem = getAmmoItem(currentType);
/* 278 */       if (matchingItem == null) matchingItem = getAmmoItem(getDefaultAmmoType(gun)); 
/* 279 */       if (p.method_68878() || countAmmo(p, matchingItem) > 0) {
/* 280 */         return (currentType != null && !currentType.isEmpty()) ? currentType : getDefaultAmmoType(gun);
/*     */       }
/* 282 */       return null;
/*     */     } 
/*     */ 
/*     */     
/* 286 */     List<String> types = getAvailableTypes(gun);
/* 287 */     if (p.method_68878()) {
/* 288 */       return types.isEmpty() ? null : types.get(0);
/*     */     }
/* 290 */     for (String type : types) {
/* 291 */       class_1792 item = getAmmoItem(type);
/* 292 */       if (item != null && countAmmo(p, item) > 0) {
/* 293 */         return type;
/*     */       }
/*     */     } 
/* 296 */     return null;
/*     */   }
/*     */   
/*     */   public static boolean canReload(class_1657 p, class_1799 stack) {
/* 300 */     if (!isGun(stack)) return false; 
/* 301 */     int cur = Math.max(0, getAmmo(stack));
/* 302 */     int max = getMaxCapacity(stack.method_7909());
/* 303 */     if (cur >= max) return false; 
/* 304 */     if (p.method_68878()) return true; 
/* 305 */     return (chooseReloadAmmoType(p, stack) != null);
/*     */   }
/*     */ }


/* Location:              C:\Users\SystemX\AppData\Local\IceCubeRust\game\mods\rustmine-0.1.2.jar!\net\rustmine\combat\GunAmmo.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */
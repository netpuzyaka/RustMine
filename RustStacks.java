/*     */ package net.rustmine;
/*     */ import com.google.gson.JsonObject;
/*     */ import java.io.InputStream;
/*     */ import java.util.Iterator;
/*     */ import net.minecraft.class_1792;
/*     */ import net.minecraft.class_2960;
/*     */ import net.rustmine.combat.RustAmmo;
/*     */ 
/*     */ public final class RustStacks {
/*  10 */   private static final Map<class_1792, Integer> STACKS = new HashMap<>();
/*     */ 
/*     */   
/*     */   public static void init() {
/*  14 */     set(RustmineMod.RES_WOOD, 1000);
/*  15 */     set(RustmineMod.RES_STONES, 1000);
/*  16 */     set(RustmineMod.RES_METAL, 1000);
/*  17 */     set(RustmineMod.RES_SULFUR, 1000);
/*  18 */     set(RustmineMod.RES_CHARCOAL, 1000);
/*  19 */     set(RustmineMod.RES_GUNPOWDER, 1000);
/*  20 */     set(RustmineMod.RES_CLOTH, 1000);
/*  21 */     set(RustmineMod.RES_SCRAP, 1000);
/*  22 */     set(RustmineMod.RES_BONE, 1000);
/*  23 */     set(RustmineMod.RES_FAT, 1000);
/*  24 */     set(RustmineMod.RES_LEATHER, 1000);
/*  25 */     set(RustmineMod.RES_CRUDE, 1000);
/*  26 */     set(RustmineMod.RES_METAL_ORE, 1000);
/*  27 */     set(RustmineMod.RES_SULFUR_ORE, 1000);
/*  28 */     set(RustmineMod.RES_HQM_ORE, 1000);
/*     */ 
/*     */     
/*  31 */     set(RustmineMod.RES_LGF, 500);
/*  32 */     set(RustmineMod.RES_HQM, 100);
/*     */ 
/*     */     
/*  35 */     set(RustAmmo.AMMO_556, 128);
/*  36 */     set(RustAmmo.AMMO_556_HV, 128);
/*  37 */     set(RustAmmo.AMMO_556_INC, 128);
/*  38 */     set(RustAmmo.AMMO_556_EXP, 128);
/*  39 */     set(RustAmmo.AMMO_PISTOL, 128);
/*  40 */     set(RustAmmo.AMMO_PISTOL_HV, 128);
/*  41 */     set(RustAmmo.AMMO_PISTOL_INC, 128);
/*  42 */     set(RustAmmo.SHOTGUN_BUCKSHOT, 64);
/*  43 */     set(RustAmmo.SHOTGUN_SLUG, 64);
/*  44 */     set(RustAmmo.SHOTGUN_INC, 64);
/*  45 */     set(RustAmmo.SHOTGUN_HANDMADE, 64);
/*  46 */     set(RustAmmo.ARROW_WOODEN, 64);
/*  47 */     set(RustAmmo.ARROW_HV, 64);
/*  48 */     set(RustAmmo.ARROW_FIRE, 64);
/*  49 */     set(RustAmmo.ARROW_BONE, 64);
/*  50 */     set(RustAmmo.AMMO_ROCKET, 3);
/*  51 */     set(RustAmmo.ROCKET_HV, 3);
/*  52 */     set(RustAmmo.ROCKET_INC, 3);
/*     */ 
/*     */     
/*  55 */     set(RustmineMod.MED_SYRINGE, 2);
/*  56 */     set(RustmineMod.MED_BANDAGE, 3);
/*  57 */     set(RustmineMod.MED_LARGEMEDKIT, 1);
/*     */ 
/*     */     
/*  60 */     set(RustmineMod.FOOD_BEANS, 10);
/*  61 */     set(RustmineMod.FOOD_TUNA, 10);
/*     */ 
/*     */     
/*  64 */     set(RustmineMod.COMP_GEARS, 20);
/*  65 */     set(RustmineMod.COMP_PIPE, 20);
/*  66 */     set(RustmineMod.COMP_SPRING, 20);
/*  67 */     set(RustmineMod.COMP_ROPE, 50);
/*  68 */     set(RustmineMod.COMP_SEWING_KIT, 40);
/*  69 */     set(RustmineMod.COMP_ROAD_SIGNS, 20);
/*  70 */     set(RustmineMod.COMP_TECH_TRASH, 50);
/*  71 */     set(RustmineMod.COMP_BLADE, 30);
/*     */ 
/*     */     
/*  74 */     try { InputStream in = RustData.open("stacks.json"); 
/*  75 */       try { if (in != null) {
/*  76 */           JsonObject sizes = JsonParser.parseString(new String(in.readAllBytes(), StandardCharsets.UTF_8)).getAsJsonObject();
/*  77 */           for (Iterator<String> iterator = sizes.keySet().iterator(); iterator.hasNext(); ) { String key = iterator.next();
/*  78 */             Optional<class_1792> item = class_7923.field_41178.method_17966(RustmineMod.id(key));
/*  79 */             item.ifPresent(it -> set(it, sizes.get(key).getAsInt())); }
/*     */         
/*     */         } 
/*  82 */         if (in != null) in.close();  } catch (Throwable throwable) { if (in != null) try { in.close(); } catch (Throwable throwable1) { throwable.addSuppressed(throwable1); }   throw throwable; }  } catch (Exception e)
/*  83 */     { System.err.println("rustmine: can't read stacks.json: " + e.getMessage()); }
/*     */ 
/*     */ 
/*     */     
/*  87 */     JsonObject cfg = RustConfigManager.ammoConfig;
/*  88 */     if (cfg != null && cfg.has("stackSizes")) {
/*  89 */       JsonObject ss = cfg.getAsJsonObject("stackSizes");
/*  90 */       for (String key : ss.keySet()) {
/*  91 */         class_2960 id = class_2960.method_12829(key.contains(":") ? key : ("rustmine:" + key));
/*  92 */         if (id != null && class_7923.field_41178.method_10250(id)) {
/*  93 */           class_1792 it = (class_1792)class_7923.field_41178.method_63535(id);
/*  94 */           if (it != null) {
/*  95 */             STACKS.put(it, Integer.valueOf(ss.get(key).getAsInt()));
/*     */           }
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   private static void set(class_1792 item, int max) {
/* 103 */     if (item != null) STACKS.put(item, Integer.valueOf(max)); 
/*     */   }
/*     */   
/*     */   public static int getMaxStack(class_1792 item) {
/* 107 */     if (STACKS.isEmpty()) init(); 
/* 108 */     Integer v = STACKS.get(item);
/* 109 */     return (v != null) ? v.intValue() : 0;
/*     */   }
/*     */ }


/* Location:              C:\Users\SystemX\AppData\Local\IceCubeRust\game\mods\rustmine-0.1.2.jar!\net\rustmine\RustStacks.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */
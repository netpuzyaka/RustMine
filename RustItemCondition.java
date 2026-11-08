/*     */ package net.rustmine;
/*     */ 
/*     */ import com.google.gson.JsonElement;
/*     */ import com.google.gson.JsonObject;
/*     */ import java.io.InputStream;
/*     */ import java.nio.charset.StandardCharsets;
/*     */ import java.util.Map;
/*     */ import java.util.Random;
/*     */ import net.minecraft.class_1792;
/*     */ import net.minecraft.class_1799;
/*     */ import net.minecraft.class_2487;
/*     */ import net.minecraft.class_9279;
/*     */ import net.minecraft.class_9334;
/*     */ import net.rustmine.combat.GunAmmo;
/*     */ import net.rustmine.combat.RustWeapons;
/*     */ import net.rustmine.init.RustmineItems;
/*     */ 
/*     */ public final class RustItemCondition {
/*     */   public static final String KEY_CONDITION = "rust_condition";
/*     */   public static final String KEY_MAX_CONDITION = "rust_max_condition";
/*     */   public static final String KEY_BASE_MAX = "rust_base_max";
/*     */   public static final String KEY_BROKEN = "rust_broken";
/*     */   public static final float SHOT_LOSS = 0.25F;
/*     */   public static final float MELEE_LOSS = 1.0F;
/*     */   public static final float REPAIR_MAX_LOSS = 0.2F;
/*     */   public static final float BREAK_AWAY_MAX = 5.0F;
/*     */   
/*     */   private static final class Def extends Record {
/*     */     private final float max;
/*     */     private final float foundMin;
/*     */     private final float foundMax;
/*     */     private final boolean maintainMax;
/*     */     private final int ammo;
/*     */     private final boolean repairable;
/*     */     
/*  36 */     private Def(float max, float foundMin, float foundMax, boolean maintainMax, int ammo, boolean repairable) { this.max = max; this.foundMin = foundMin; this.foundMax = foundMax; this.maintainMax = maintainMax; this.ammo = ammo; this.repairable = repairable; } public final String toString() { // Byte code:
/*     */       //   0: aload_0
/*     */       //   1: <illegal opcode> toString : (Lnet/rustmine/RustItemCondition$Def;)Ljava/lang/String;
/*     */       //   6: areturn
/*     */       // Line number table:
/*     */       //   Java source line number -> byte code offset
/*     */       //   #36	-> 0
/*     */       // Local variable table:
/*     */       //   start	length	slot	name	descriptor
/*  36 */       //   0	7	0	this	Lnet/rustmine/RustItemCondition$Def; } public float max() { return this.max; } public final int hashCode() { // Byte code:
/*     */       //   0: aload_0
/*     */       //   1: <illegal opcode> hashCode : (Lnet/rustmine/RustItemCondition$Def;)I
/*     */       //   6: ireturn
/*     */       // Line number table:
/*     */       //   Java source line number -> byte code offset
/*     */       //   #36	-> 0
/*     */       // Local variable table:
/*     */       //   start	length	slot	name	descriptor
/*     */       //   0	7	0	this	Lnet/rustmine/RustItemCondition$Def; } public final boolean equals(Object o) { // Byte code:
/*     */       //   0: aload_0
/*     */       //   1: aload_1
/*     */       //   2: <illegal opcode> equals : (Lnet/rustmine/RustItemCondition$Def;Ljava/lang/Object;)Z
/*     */       //   7: ireturn
/*     */       // Line number table:
/*     */       //   Java source line number -> byte code offset
/*     */       //   #36	-> 0
/*     */       // Local variable table:
/*     */       //   start	length	slot	name	descriptor
/*     */       //   0	8	0	this	Lnet/rustmine/RustItemCondition$Def;
/*  36 */       //   0	8	1	o	Ljava/lang/Object; } public float foundMin() { return this.foundMin; } public float foundMax() { return this.foundMax; } public boolean maintainMax() { return this.maintainMax; } public int ammo() { return this.ammo; } public boolean repairable() { return this.repairable; }
/*     */   
/*     */   }
/*     */ 
/*     */   
/*  41 */   private static final Map<String, Def> DEFS = new HashMap<>();
/*     */   private static boolean loaded;
/*     */   
/*     */   private static synchronized void load() {
/*  45 */     if (loaded)
/*  46 */       return;  loaded = true; 
/*  47 */     try { InputStream in = RustData.open("item_condition.json"); 
/*  48 */       try { if (in == null)
/*     */         
/*     */         { 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*  55 */           if (in != null) in.close();  return; }  JsonObject o = JsonParser.parseString(new String(in.readAllBytes(), StandardCharsets.UTF_8)).getAsJsonObject(); for (Map.Entry<String, JsonElement> e : (Iterable<Map.Entry<String, JsonElement>>)o.entrySet()) { JsonObject d = ((JsonElement)e.getValue()).getAsJsonObject(); DEFS.put(e.getKey(), new Def(d.get("max").getAsFloat(), d.get("foundMin").getAsFloat(), d.get("foundMax").getAsFloat(), d.get("maintainMax").getAsBoolean(), d.has("ammo") ? d.get("ammo").getAsInt() : 0, (!d.has("repairable") || d.get("repairable").getAsBoolean()))); }  if (in != null) in.close();  } catch (Throwable throwable) { if (in != null) try { in.close(); } catch (Throwable throwable1) { throwable.addSuppressed(throwable1); }   throw throwable; }  } catch (Exception ex)
/*  56 */     { System.err.println("rustmine: can't read item_condition.json: " + ex.getMessage()); }
/*     */   
/*     */   }
/*     */   
/*     */   private static Def def(class_1792 item) {
/*  61 */     if (!loaded) load(); 
/*  62 */     return DEFS.get(class_7923.field_41178.method_10221(item).method_12832());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean hasCondition(class_1799 stack) {
/*  68 */     if (stack == null || stack.method_7960()) return false; 
/*  69 */     class_1792 item = stack.method_7909();
/*  70 */     if (def(item) != null) return true; 
/*  71 */     if (GunAmmo.isGun(stack) || RustWeapons.GUNS.containsKey(item)) return true; 
/*  72 */     if (RustmineItems.TOOLS.containsKey(item)) return true;
/*     */     
/*  74 */     if (RustArmorStats.get(item) != null) return false; 
/*  75 */     class_9279 cd = (class_9279)stack.method_58694(class_9334.field_49628);
/*  76 */     return (cd != null && cd.method_57461().method_10583("rust_condition").isPresent());
/*     */   }
/*     */   
/*     */   public static float getBaseMax(class_1799 stack) {
/*  80 */     if (stack.method_7960()) return 100.0F; 
/*  81 */     class_1792 item = stack.method_7909();
/*  82 */     Def d = def(item);
/*  83 */     if (d != null) return d.max(); 
/*  84 */     class_9279 cd = (class_9279)stack.method_58694(class_9334.field_49628);
/*  85 */     if (cd != null) {
/*  86 */       class_2487 tag = cd.method_57461();
/*  87 */       if (tag.method_10583("rust_base_max").isPresent()) {
/*  88 */         return ((Float)tag.method_10583("rust_base_max").get()).floatValue();
/*     */       }
/*     */     } 
/*  91 */     if (GunAmmo.isGun(stack) || RustWeapons.GUNS.containsKey(item)) return 200.0F; 
/*  92 */     if (RustmineItems.TOOLS.containsKey(item)) return 150.0F; 
/*  93 */     if (RustArmorStats.get(item) != null) return 100.0F; 
/*  94 */     return 100.0F;
/*     */   }
/*     */   
/*     */   public static float getMaxCondition(class_1799 stack) {
/*  98 */     if (stack.method_7960()) return 100.0F; 
/*  99 */     class_9279 cd = (class_9279)stack.method_58694(class_9334.field_49628);
/* 100 */     if (cd != null) {
/* 101 */       class_2487 tag = cd.method_57461();
/* 102 */       if (tag.method_10583("rust_max_condition").isPresent()) {
/* 103 */         return Math.max(1.0F, ((Float)tag.method_10583("rust_max_condition").get()).floatValue());
/*     */       }
/*     */     } 
/* 106 */     return getBaseMax(stack);
/*     */   }
/*     */   
/*     */   public static float getCondition(class_1799 stack) {
/* 110 */     if (stack.method_7960()) return 100.0F; 
/* 111 */     class_9279 cd = (class_9279)stack.method_58694(class_9334.field_49628);
/* 112 */     if (cd != null) {
/* 113 */       class_2487 tag = cd.method_57461();
/* 114 */       if (tag.method_10583("rust_condition").isPresent()) {
/* 115 */         return Math.max(0.0F, ((Float)tag.method_10583("rust_condition").get()).floatValue());
/*     */       }
/*     */     } 
/* 118 */     return getMaxCondition(stack);
/*     */   }
/*     */   
/*     */   public static boolean isBroken(class_1799 stack) {
/* 122 */     if (stack.method_7960()) return false; 
/* 123 */     class_9279 cd = (class_9279)stack.method_58694(class_9334.field_49628);
/* 124 */     if (cd != null) {
/* 125 */       class_2487 tag = cd.method_57461();
/* 126 */       if (((Boolean)tag.method_10577("rust_broken").orElse(Boolean.valueOf(false))).booleanValue()) return true; 
/* 127 */       if (tag.method_10583("rust_condition").isPresent()) {
/* 128 */         return (((Float)tag.method_10583("rust_condition").get()).floatValue() <= 0.001F);
/*     */       }
/*     */     } 
/* 131 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void damage(class_1799 stack, float amount) {
/* 139 */     if (stack.method_7960() || amount <= 0.0F)
/* 140 */       return;  float baseMax = getBaseMax(stack);
/* 141 */     float curMax = getMaxCondition(stack);
/* 142 */     float curCond = getCondition(stack);
/* 143 */     float nextCond = Math.max(0.0F, curCond - amount);
/* 144 */     boolean broken = (nextCond <= 0.001F);
/*     */     
/* 146 */     class_9279.method_57452(class_9334.field_49628, stack, tag -> {
/*     */           tag.method_10548("rust_base_max", baseMax);
/*     */           tag.method_10548("rust_max_condition", curMax);
/*     */           tag.method_10548("rust_condition", nextCond);
/*     */           tag.method_10556("rust_broken", broken);
/*     */         });
/* 152 */     if (broken && curCond > 0.001F && breaksAway(stack) && !GunAmmo.isGun(stack)) stack.method_7939(0);
/*     */   
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean breaksAway(class_1799 stack) {
/* 160 */     if (!isBroken(stack)) return false; 
/* 161 */     Def d = def(stack.method_7909());
/* 162 */     return ((d != null && !d.repairable()) || getMaxCondition(stack) <= 5.0F);
/*     */   }
/*     */   
/*     */   public static void setCondition(class_1799 stack, float condition, float maxCondition) {
/* 166 */     if (stack.method_7960())
/* 167 */       return;  float baseMax = getBaseMax(stack);
/* 168 */     float clampedMax = Math.min(baseMax, Math.max(1.0F, maxCondition));
/* 169 */     float clampedCond = Math.min(clampedMax, Math.max(0.0F, condition));
/* 170 */     boolean broken = (clampedCond <= 0.001F);
/*     */     
/* 172 */     class_9279.method_57452(class_9334.field_49628, stack, tag -> {
/*     */           tag.method_10548("rust_base_max", baseMax);
/*     */           tag.method_10548("rust_max_condition", clampedMax);
/*     */           tag.method_10548("rust_condition", clampedCond);
/*     */           tag.method_10556("rust_broken", broken);
/*     */         });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void repair(class_1799 stack) {
/* 185 */     if (stack.method_7960())
/* 186 */       return;  float baseMax = getBaseMax(stack);
/* 187 */     float curMax = getMaxCondition(stack);
/* 188 */     Def d = def(stack.method_7909());
/* 189 */     float lost = 1.0F - Math.min(1.0F, getCondition(stack) / curMax);
/* 190 */     float newMax = (d != null && d.maintainMax()) ? curMax : (curMax * (1.0F - 0.2F * lost));
/*     */     
/* 192 */     class_9279.method_57452(class_9334.field_49628, stack, tag -> {
/*     */           tag.method_10548("rust_base_max", baseMax);
/*     */           tag.method_10548("rust_max_condition", newMax);
/*     */           tag.method_10548("rust_condition", newMax);
/*     */           tag.method_10556("rust_broken", false);
/*     */         });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void onFound(class_1799 stack, Random rnd) {
/* 205 */     if (stack.method_7960())
/* 206 */       return;  Def d = def(stack.method_7909());
/* 207 */     if (d != null && d.foundMax() < 1.0F) {
/* 208 */       float frac = d.foundMin() + rnd.nextFloat() * (d.foundMax() - d.foundMin());
/* 209 */       setCondition(stack, d.max() * frac, d.max());
/*     */     } 
/* 211 */     if (GunAmmo.isGun(stack)) {
/* 212 */       GunAmmo.setAmmo(stack, (d != null) ? d.ammo() : 0);
/* 213 */       GunAmmo.setAmmoType(stack, GunAmmo.getDefaultAmmoType(stack.method_7909()));
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static float getConditionRatio(class_1799 stack) {
/* 219 */     float base = getBaseMax(stack);
/* 220 */     if (base <= 0.0F) return 1.0F; 
/* 221 */     return Math.max(0.0F, Math.min(1.0F, getCondition(stack) / base));
/*     */   }
/*     */ 
/*     */   
/*     */   public static float getLostMaxRatio(class_1799 stack) {
/* 226 */     float base = getBaseMax(stack);
/* 227 */     float curMax = getMaxCondition(stack);
/* 228 */     if (base <= 0.0F || curMax >= base) return 0.0F; 
/* 229 */     return Math.max(0.0F, Math.min(1.0F, (base - curMax) / base));
/*     */   }
/*     */ }


/* Location:              C:\Users\SystemX\AppData\Local\IceCubeRust\game\mods\rustmine-0.1.2.jar!\net\rustmine\RustItemCondition.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */
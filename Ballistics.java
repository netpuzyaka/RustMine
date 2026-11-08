/*     */ package net.rustmine.combat;
/*     */ 
/*     */ import com.google.gson.JsonElement;
/*     */ import com.google.gson.JsonObject;
/*     */ import com.google.gson.JsonParser;
/*     */ import java.io.InputStream;
/*     */ import java.nio.charset.StandardCharsets;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Random;
/*     */ import net.minecraft.class_243;
/*     */ import net.rustmine.RustData;
/*     */ import net.rustmine.config.RustConfigManager;
/*     */ import net.rustmine.damage.RustDamage;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class Ballistics
/*     */ {
/*     */   public static final float GRAVITY = 9.81F;
/*     */   private static final float DEFAULT_TRACER_WIDTH = 0.086F;
/*     */   private static final float DEFAULT_TRACER_TIME = 0.01F;
/*     */   
/*     */   public static final class Params
/*     */   {
/*     */     public final float speed;
/*     */     public final float gravity;
/*     */     public final float drag;
/*     */     public final float initialDistance;
/*     */     public final float baseDamage;
/*     */     public final float damageMult;
/*     */     public final int color;
/*     */     public final float thickness;
/*     */     public final boolean isArrow;
/*     */     public final boolean isExplosive;
/*     */     public final boolean isIncendiary;
/*     */     public final int pellets;
/*     */     public final double spreadDeg;
/*     */     public final float speedSpread;
/*     */     public final float hitboxRadius;
/*     */     public final float falloffStart;
/*     */     public final float falloffEnd;
/*     */     public final float falloffMult;
/*     */     public final int damageType;
/*     */     public final float tracerWidth;
/*     */     public final float tracerTime;
/*     */     
/*     */     public Params(float speed, float gravity, float drag, float initialDistance, float baseDamage, float damageMult, int color, float thickness, boolean isArrow, boolean isExplosive, boolean isIncendiary, int pellets, double spreadDeg, float speedSpread, float hitboxRadius, float falloffStart, float falloffEnd, float falloffMult, int damageType) {
/*  52 */       this(speed, gravity, drag, initialDistance, baseDamage, damageMult, color, thickness, isArrow, isExplosive, isIncendiary, pellets, spreadDeg, speedSpread, hitboxRadius, falloffStart, falloffEnd, falloffMult, damageType, 0.086F, 0.01F);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Params(float speed, float gravity, float drag, float initialDistance, float baseDamage, float damageMult, int color, float thickness, boolean isArrow, boolean isExplosive, boolean isIncendiary, int pellets, double spreadDeg, float speedSpread, float hitboxRadius, float falloffStart, float falloffEnd, float falloffMult, int damageType, float tracerWidth, float tracerTime) {
/*  59 */       this.tracerWidth = tracerWidth;
/*  60 */       this.tracerTime = tracerTime;
/*  61 */       this.speed = speed;
/*  62 */       this.gravity = gravity;
/*  63 */       this.drag = drag;
/*  64 */       this.initialDistance = initialDistance;
/*  65 */       this.baseDamage = baseDamage;
/*  66 */       this.damageMult = damageMult;
/*  67 */       this.color = color;
/*  68 */       this.thickness = thickness;
/*  69 */       this.isArrow = isArrow;
/*  70 */       this.isExplosive = isExplosive;
/*  71 */       this.isIncendiary = isIncendiary;
/*  72 */       this.pellets = pellets;
/*  73 */       this.spreadDeg = spreadDeg;
/*  74 */       this.speedSpread = speedSpread;
/*  75 */       this.hitboxRadius = hitboxRadius;
/*  76 */       this.falloffStart = falloffStart;
/*  77 */       this.falloffEnd = falloffEnd;
/*  78 */       this.falloffMult = falloffMult;
/*  79 */       this.damageType = damageType;
/*     */     }
/*     */ 
/*     */     
/*     */     public float falloff(double distance) {
/*  84 */       if (this.falloffEnd <= this.falloffStart) return 1.0F; 
/*  85 */       float t = (float)Math.max(0.0D, Math.min(1.0D, (distance - this.falloffStart) / (this.falloffEnd - this.falloffStart)));
/*  86 */       return 1.0F + (this.falloffMult - 1.0F) * t;
/*     */     }
/*     */   }
/*     */   private static final class Ammo extends Record { private final float velocity; private final float velocitySpread; private final int pellets; private final float spread; private final float drag; private final float gravity; private final float thickness;
/*  90 */     private Ammo(float velocity, float velocitySpread, int pellets, float spread, float drag, float gravity, float thickness, float initialDistance, float damage, float falloffFrom, float falloffTo, float falloffMult, int damageType, float tracerWidth, float tracerTime) { this.velocity = velocity; this.velocitySpread = velocitySpread; this.pellets = pellets; this.spread = spread; this.drag = drag; this.gravity = gravity; this.thickness = thickness; this.initialDistance = initialDistance; this.damage = damage; this.falloffFrom = falloffFrom; this.falloffTo = falloffTo; this.falloffMult = falloffMult; this.damageType = damageType; this.tracerWidth = tracerWidth; this.tracerTime = tracerTime; } private final float initialDistance; private final float damage; private final float falloffFrom; private final float falloffTo; private final float falloffMult; private final int damageType; private final float tracerWidth; private final float tracerTime; public final String toString() { // Byte code:
/*     */       //   0: aload_0
/*     */       //   1: <illegal opcode> toString : (Lnet/rustmine/combat/Ballistics$Ammo;)Ljava/lang/String;
/*     */       //   6: areturn
/*     */       // Line number table:
/*     */       //   Java source line number -> byte code offset
/*     */       //   #90	-> 0
/*     */       // Local variable table:
/*     */       //   start	length	slot	name	descriptor
/*     */       //   0	7	0	this	Lnet/rustmine/combat/Ballistics$Ammo; } public final int hashCode() { // Byte code:
/*     */       //   0: aload_0
/*     */       //   1: <illegal opcode> hashCode : (Lnet/rustmine/combat/Ballistics$Ammo;)I
/*     */       //   6: ireturn
/*     */       // Line number table:
/*     */       //   Java source line number -> byte code offset
/*     */       //   #90	-> 0
/*     */       // Local variable table:
/*     */       //   start	length	slot	name	descriptor
/*     */       //   0	7	0	this	Lnet/rustmine/combat/Ballistics$Ammo; } public final boolean equals(Object o) { // Byte code:
/*     */       //   0: aload_0
/*     */       //   1: aload_1
/*     */       //   2: <illegal opcode> equals : (Lnet/rustmine/combat/Ballistics$Ammo;Ljava/lang/Object;)Z
/*     */       //   7: ireturn
/*     */       // Line number table:
/*     */       //   Java source line number -> byte code offset
/*     */       //   #90	-> 0
/*     */       // Local variable table:
/*     */       //   start	length	slot	name	descriptor
/*     */       //   0	8	0	this	Lnet/rustmine/combat/Ballistics$Ammo;
/*  90 */       //   0	8	1	o	Ljava/lang/Object; } public float velocity() { return this.velocity; } public float velocitySpread() { return this.velocitySpread; } public int pellets() { return this.pellets; } public float spread() { return this.spread; } public float drag() { return this.drag; } public float gravity() { return this.gravity; } public float thickness() { return this.thickness; } public float initialDistance() { return this.initialDistance; } public float damage() { return this.damage; } public float falloffFrom() { return this.falloffFrom; } public float falloffTo() { return this.falloffTo; } public float falloffMult() { return this.falloffMult; } public int damageType() { return this.damageType; } public float tracerWidth() { return this.tracerWidth; } public float tracerTime() { return this.tracerTime; }
/*     */      } private static final class Variant extends Record { private final String base; private final float speed; private final float gravity; private final float damage; private final int color; private final boolean incendiary; private final boolean explosive;
/*  92 */     private Variant(String base, float speed, float gravity, float damage, int color, boolean incendiary, boolean explosive) { this.base = base; this.speed = speed; this.gravity = gravity; this.damage = damage; this.color = color; this.incendiary = incendiary; this.explosive = explosive; } public final String toString() { // Byte code:
/*     */       //   0: aload_0
/*     */       //   1: <illegal opcode> toString : (Lnet/rustmine/combat/Ballistics$Variant;)Ljava/lang/String;
/*     */       //   6: areturn
/*     */       // Line number table:
/*     */       //   Java source line number -> byte code offset
/*     */       //   #92	-> 0
/*     */       // Local variable table:
/*     */       //   start	length	slot	name	descriptor
/*     */       //   0	7	0	this	Lnet/rustmine/combat/Ballistics$Variant; } public final int hashCode() { // Byte code:
/*     */       //   0: aload_0
/*     */       //   1: <illegal opcode> hashCode : (Lnet/rustmine/combat/Ballistics$Variant;)I
/*     */       //   6: ireturn
/*     */       // Line number table:
/*     */       //   Java source line number -> byte code offset
/*     */       //   #92	-> 0
/*     */       // Local variable table:
/*     */       //   start	length	slot	name	descriptor
/*     */       //   0	7	0	this	Lnet/rustmine/combat/Ballistics$Variant; } public final boolean equals(Object o) { // Byte code:
/*     */       //   0: aload_0
/*     */       //   1: aload_1
/*     */       //   2: <illegal opcode> equals : (Lnet/rustmine/combat/Ballistics$Variant;Ljava/lang/Object;)Z
/*     */       //   7: ireturn
/*     */       // Line number table:
/*     */       //   Java source line number -> byte code offset
/*     */       //   #92	-> 0
/*     */       // Local variable table:
/*     */       //   start	length	slot	name	descriptor
/*     */       //   0	8	0	this	Lnet/rustmine/combat/Ballistics$Variant;
/*  92 */       //   0	8	1	o	Ljava/lang/Object; } public String base() { return this.base; } public float speed() { return this.speed; } public float gravity() { return this.gravity; } public float damage() { return this.damage; } public int color() { return this.color; } public boolean incendiary() { return this.incendiary; } public boolean explosive() { return this.explosive; }
/*     */      }
/*  94 */   private static final Map<String, Ammo> AMMO = new HashMap<>();
/*  95 */   private static final Map<String, Float> VELOCITY_SCALE = new HashMap<>();
/*  96 */   private static final Map<String, Float> DISTANCE_SCALE = new HashMap<>();
/*     */   
/*     */   private static boolean loaded;
/*     */   
/* 100 */   private static final Map<String, Variant> VARIANTS = Map.of("ammo_556_incendiary", new Variant("ammo_556", 0.85F, 1.35F, 1.15F, -47872, true, false), "ammo_556_explosive", new Variant("ammo_556", 0.85F, 1.35F, 1.0F, -18384, false, true), "ammo_pistol_fire", new Variant("ammo_pistol", 0.85F, 1.35F, 1.15F, -47872, true, false), "ammo_shotgun_fire", new Variant("ammo_shotgun", 0.93F, 1.1F, 1.15F, -47872, true, false), "arrow_fire", new Variant("arrow_wooden", 0.82F, 1.35F, 1.15F, -47872, true, false));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static synchronized void load() {
/* 110 */     if (loaded)
/* 111 */       return;  loaded = true; 
/* 112 */     try { InputStream in = RustData.open("ballistics.json"); 
/* 113 */       try { if (in == null)
/*     */         
/*     */         { 
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
/* 126 */           if (in != null) in.close();  return; }  JsonObject o = JsonParser.parseString(new String(in.readAllBytes(), StandardCharsets.UTF_8)).getAsJsonObject(); for (Map.Entry<String, JsonElement> e : (Iterable<Map.Entry<String, JsonElement>>)o.getAsJsonObject("ammo").entrySet()) { JsonObject a = ((JsonElement)e.getValue()).getAsJsonObject(); AMMO.put(e.getKey(), new Ammo(a.get("velocity").getAsFloat(), a.get("velocitySpread").getAsFloat(), a.get("pellets").getAsInt(), a.get("spread").getAsFloat(), a.get("drag").getAsFloat(), a.get("gravity").getAsFloat(), a.get("thickness").getAsFloat(), a.get("initialDistance").getAsFloat(), a.get("damage").getAsFloat(), a.getAsJsonArray("falloffDistances").get(0).getAsFloat(), a.getAsJsonArray("falloffDistances").get(1).getAsFloat(), a.getAsJsonArray("falloffMultipliers").get(1).getAsFloat(), RustDamage.typeIndex(a.get("damageType").getAsString()), a.has("tracerWidth") ? a.get("tracerWidth").getAsFloat() : 0.086F, a.has("tracerTime") ? a.get("tracerTime").getAsFloat() : 0.01F)); }  for (Map.Entry<String, JsonElement> e : (Iterable<Map.Entry<String, JsonElement>>)o.getAsJsonObject("gun").entrySet()) { VELOCITY_SCALE.put(e.getKey(), Float.valueOf(((JsonElement)e.getValue()).getAsJsonObject().get("velocityScale").getAsFloat())); DISTANCE_SCALE.put(e.getKey(), Float.valueOf(((JsonElement)e.getValue()).getAsJsonObject().get("distanceScale").getAsFloat())); }  if (in != null) in.close();  } catch (Throwable throwable) { if (in != null) try { in.close(); } catch (Throwable throwable1) { throwable.addSuppressed(throwable1); }   throw throwable; }  } catch (Exception ex)
/* 127 */     { System.err.println("rustmine: can't read ballistics.json: " + ex.getMessage()); }
/*     */   
/*     */   }
/*     */ 
/*     */   
/*     */   private static int colorOf(String id, boolean arrow) {
/* 133 */     if (!arrow) return -1; 
/* 134 */     if (id.contains("hv")) return -9375489; 
/* 135 */     if (id.contains("bone")) return -2039600; 
/* 136 */     return -1654144;
/*     */   }
/*     */   
/*     */   public static Params getParams(String gunName, String ammoType) {
/* 140 */     if (!loaded) load(); 
/* 141 */     String id = (ammoType == null) ? "" : ammoType.replace("rustmine:", "");
/* 142 */     if (id.isEmpty()) id = ("bow".equals(gunName) || "crossbow".equals(gunName)) ? "arrow_wooden" : "ammo_556"; 
/* 143 */     Variant v = VARIANTS.get(id);
/* 144 */     Ammo a = AMMO.get((v != null) ? v.base() : id);
/* 145 */     if (a == null) a = AMMO.get("ammo_556"); 
/* 146 */     boolean arrow = id.startsWith("arrow");
/* 147 */     float scale = ((Float)VELOCITY_SCALE.getOrDefault(gunName, Float.valueOf(1.0F))).floatValue();
/* 148 */     float distScale = ((Float)DISTANCE_SCALE.getOrDefault(gunName, Float.valueOf(1.0F))).floatValue();
/* 149 */     float speedMult = (v != null) ? v.speed() : 1.0F, gravMult = (v != null) ? v.gravity() : 1.0F;
/* 150 */     float speed = a.velocity() * scale * speedMult;
/* 151 */     float gravity = 9.81F * a.gravity() * gravMult;
/*     */     
/* 153 */     float radius = a.thickness();
/* 154 */     float tracer = arrow ? 0.035F : ((a.pellets() > 1) ? 0.05F : 0.06F);
/*     */     
/* 156 */     float reference = (id.contains("shotgun") || id.contains("handmade")) ? 210.0F : 50.0F;
/* 157 */     float damageMult = a.damage() * a.pellets() / reference * ((v != null) ? v.damage() : 1.0F);
/*     */ 
/*     */     
/* 160 */     Params p = new Params(speed, gravity, a.drag(), a.initialDistance(), 0.0F, damageMult, (v != null) ? v.color() : colorOf(id, arrow), tracer, arrow, (v != null && v.explosive()), (v != null && v.incendiary()), a.pellets(), a.spread(), a.velocitySpread(), radius, a.falloffFrom() * distScale, a.falloffTo() * distScale, a.falloffMult(), a.damageType(), a.tracerWidth(), a.tracerTime());
/* 161 */     return applyConfigOverrides(p, id);
/*     */   }
/*     */ 
/*     */   
/*     */   public static class_243 spreadDirection(class_243 dir, Params p, Random rnd) {
/* 166 */     if (p.pellets <= 1 || p.spreadDeg <= 0.0D) return dir; 
/* 167 */     double r = Math.tan(Math.toRadians(p.spreadDeg)) * Math.sqrt(rnd.nextDouble());
/* 168 */     double phi = rnd.nextDouble() * Math.PI * 2.0D;
/* 169 */     class_243 up = (Math.abs(dir.field_1351) > 0.95D) ? new class_243(1.0D, 0.0D, 0.0D) : new class_243(0.0D, 1.0D, 0.0D);
/* 170 */     class_243 right = dir.method_1036(up).method_1029();
/* 171 */     class_243 upv = right.method_1036(dir).method_1029();
/* 172 */     return dir.method_1019(right.method_1021(r * Math.cos(phi))).method_1019(upv.method_1021(r * Math.sin(phi))).method_1029();
/*     */   }
/*     */ 
/*     */   
/*     */   public static float speedOf(Params p, Random rnd) {
/* 177 */     return (p.speedSpread > 0.0F) ? (p.speed + (rnd.nextFloat() * 2.0F - 1.0F) * p.speedSpread) : p.speed;
/*     */   }
/*     */   
/*     */   private static Params applyConfigOverrides(Params p, String ammoId) {
/* 181 */     JsonObject cfg = RustConfigManager.ammoConfig;
/* 182 */     if (cfg == null || !cfg.has("ballistics_overrides")) return p; 
/* 183 */     JsonObject all = cfg.getAsJsonObject("ballistics_overrides");
/* 184 */     if (!all.has(ammoId)) return p; 
/* 185 */     JsonObject o = all.getAsJsonObject(ammoId);
/* 186 */     float sp = o.has("speed") ? o.get("speed").getAsFloat() : p.speed;
/* 187 */     float gr = o.has("gravity") ? o.get("gravity").getAsFloat() : p.gravity;
/* 188 */     float dr = o.has("drag") ? o.get("drag").getAsFloat() : p.drag;
/* 189 */     float dm = o.has("damageMult") ? o.get("damageMult").getAsFloat() : p.damageMult;
/* 190 */     int pel = o.has("pellets") ? o.get("pellets").getAsInt() : p.pellets;
/* 191 */     double spr = o.has("spread") ? o.get("spread").getAsDouble() : p.spreadDeg;
/* 192 */     float hb = o.has("hitboxRadius") ? o.get("hitboxRadius").getAsFloat() : p.hitboxRadius;
/* 193 */     return new Params(sp, gr, dr, p.initialDistance, p.baseDamage, dm, p.color, p.thickness, p.isArrow, p.isExplosive, p.isIncendiary, pel, spr, p.speedSpread, hb, p.falloffStart, p.falloffEnd, p.falloffMult, p.damageType, p.tracerWidth, p.tracerTime);
/*     */   }
/*     */ }


/* Location:              C:\Users\SystemX\AppData\Local\IceCubeRust\game\mods\rustmine-0.1.2.jar!\net\rustmine\combat\Ballistics.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */
/*     */ package net.rustmine.combat;
/*     */ import com.google.gson.JsonElement;
/*     */ import com.google.gson.JsonObject;
/*     */ import com.google.gson.JsonParser;
/*     */ import java.io.InputStream;
/*     */ import java.io.InputStreamReader;
/*     */ import java.nio.charset.StandardCharsets;
/*     */ import net.rustmine.config.RustConfigManager;
/*     */ import net.rustmine.vault.Vault;
/*     */ 
/*     */ public final class WeaponStats {
/*     */   public final String name;
/*     */   public final float repeatDelay;
/*     */   public final float reloadTime;
/*     */   public final float deployDelay;
/*     */   public final float aimCone;
/*     */   public final float hipAimCone;
/*     */   public final float damageScale;
/*     */   public final float bulletDamage;
/*     */   public final float zoom;
/*     */   public final int magazine;
/*     */   public final boolean automatic;
/*     */   public final boolean punch;
/*     */   public final float punchDuration;
/*     */   public final float punchMagnitude;
/*     */   public final float yawMin;
/*     */   public final float yawMax;
/*     */   public final float pitchMin;
/*     */   public final float pitchMax;
/*     */   public final float timeToTakeMin;
/*     */   public final float timeToTakeMax;
/*     */   public final float adsScale;
/*     */   public final float movementPenalty;
/*     */   
/*     */   public WeaponStats(String name) {
/*  36 */     this.name = name;
/*  37 */     JsonObject o = null; 
/*  38 */     try { InputStream in = Vault.open("/assets/rustmine/weapons/" + name + ".json"); 
/*  39 */       try { if (in != null) {
/*  40 */           o = JsonParser.parseReader(new InputStreamReader(in, StandardCharsets.UTF_8)).getAsJsonObject();
/*     */         } else {
/*  42 */           System.err.println("rustmine: WARNING: missing weapons/" + name + ".json, using fallback stats!");
/*     */         } 
/*  44 */         if (in != null) in.close();  } catch (Throwable throwable) { if (in != null) try { in.close(); } catch (Throwable throwable1) { throwable.addSuppressed(throwable1); }   throw throwable; }  } catch (Exception e)
/*  45 */     { System.err.println("rustmine: ERROR reading weapons/" + name + ".json: " + e.getMessage()); }
/*     */     
/*  47 */     if (o == null) {
/*  48 */       o = createFallbackWeaponJson(name);
/*     */     }
/*  50 */     this.repeatDelay = o.get("repeatDelay").getAsFloat();
/*  51 */     this.reloadTime = o.get("reloadTime").getAsFloat();
/*  52 */     this.deployDelay = o.get("deployDelay").getAsFloat();
/*  53 */     this.aimCone = o.get("aimCone").getAsFloat();
/*  54 */     this.hipAimCone = o.get("hipAimCone").getAsFloat();
/*  55 */     this.damageScale = o.get("damageScale").getAsFloat();
/*  56 */     float rawDmg = o.get("bulletDamage").getAsFloat();
/*  57 */     this.bulletDamage = RustConfigManager.getWeaponDamage(name, rawDmg);
/*  58 */     this.magazine = o.get("magazine").getAsInt();
/*  59 */     this.automatic = o.get("automatic").getAsBoolean();
/*  60 */     JsonObject iron = o.getAsJsonObject("ironsights");
/*  61 */     this.zoom = iron.has("zoomFactor") ? iron.get("zoomFactor").getAsFloat() : 1.0F;
/*  62 */     JsonObject pu = o.getAsJsonObject("punch");
/*  63 */     this.punch = (pu.size() > 0);
/*  64 */     this.punchDuration = opt(pu, "punchDuration", 0.15F);
/*  65 */     this.punchMagnitude = opt(pu, "punchMagnitude", 0.02F);
/*  66 */     JsonObject r = o.getAsJsonObject("recoil");
/*  67 */     this.yawMin = r.get("recoilYawMin").getAsFloat();
/*  68 */     this.yawMax = r.get("recoilYawMax").getAsFloat();
/*  69 */     this.pitchMin = r.get("recoilPitchMin").getAsFloat();
/*  70 */     this.pitchMax = r.get("recoilPitchMax").getAsFloat();
/*  71 */     this.timeToTakeMin = r.get("timeToTakeMin").getAsFloat();
/*  72 */     this.timeToTakeMax = r.get("timeToTakeMax").getAsFloat();
/*  73 */     this.adsScale = r.get("ADSScale").getAsFloat();
/*  74 */     this.movementPenalty = r.get("movementPenalty").getAsFloat();
/*  75 */     this.aimconePenaltyPerShot = opt(o, "aimconePenaltyPerShot", 0.0F);
/*  76 */     this.aimConePenaltyMax = opt(o, "aimConePenaltyMax", 0.0F);
/*  77 */     this.aimconePenaltyRecoverTime = opt(o, "aimconePenaltyRecoverTime", 0.1F);
/*  78 */     this.aimconePenaltyRecoverDelay = opt(o, "aimconePenaltyRecoverDelay", 0.1F);
/*  79 */     this.stancePenaltyScale = opt(o, "stancePenaltyScale", 1.0F);
/*  80 */     this.useCurves = (r.has("useCurves") && r.get("useCurves").getAsBoolean());
/*  81 */     this.curvesAsScalar = (r.has("curvesAsScalar") && r.get("curvesAsScalar").getAsBoolean());
/*  82 */     this.shotsUntilMax = Math.max(1, (int)opt(r, "shotsUntilMax", 30.0F));
/*  83 */     this.maxRecoilRadius = opt(r, "maxRecoilRadius", 5.0F);
/*  84 */     this.pitchCurve = RustCurve.parse(r.get("pitchCurve"));
/*  85 */     this.yawCurve = RustCurve.parse(r.get("yawCurve"));
/*  86 */     this.introSpeed = opt(iron, "introSpeed", 3.0F);
/*  87 */     this.outroSpeed = opt(iron, "outroSpeed", 2.0F);
/*  88 */     this.introCurve = RustCurve.parse(iron.get("introCurve"));
/*  89 */     this.outroCurve = RustCurve.parse(iron.get("outroCurve"));
/*  90 */     this.punchScale = RustCurve.parse(pu.get("punchScale"));
/*  91 */     this.aimSway = opt(o, "aimSway", 0.0F);
/*  92 */     this.aimSwaySpeed = opt(o, "aimSwaySpeed", 0.0F);
/*  93 */     JsonObject sway = o.getAsJsonObject("sway");
/*  94 */     this.hasSway = (sway != null);
/*  95 */     this.swaySpeed = (sway == null) ? 1.0F : opt(sway, "rotationSwaySpeed", 1.0F);
/*  96 */     this.swayAmount = (sway == null) ? 1.0F : opt(sway, "rotationSwayAmount", 1.0F);
/*  97 */     this.swayRotate = (sway == null) ? 0.0F : opt(sway, "rotateAmountTest", 0.0F);
/*     */   }
/*     */   public final float aimconePenaltyPerShot; public final float aimConePenaltyMax; public final float aimconePenaltyRecoverTime; public final float aimconePenaltyRecoverDelay; public final float stancePenaltyScale; public final boolean useCurves; public final boolean curvesAsScalar; public final int shotsUntilMax; public final float maxRecoilRadius; public final RustCurve pitchCurve; public final RustCurve yawCurve; public final float introSpeed; public final float outroSpeed; public final RustCurve introCurve; public final RustCurve outroCurve; public final RustCurve punchScale; public final float aimSway; public final float aimSwaySpeed; public final boolean hasSway; public final float swaySpeed; public final float swayAmount; public final float swayRotate;
/*     */   private static float opt(JsonObject o, String key, float def) {
/* 101 */     return o.has(key) ? o.get(key).getAsFloat() : def;
/*     */   }
/*     */ 
/*     */   
/*     */   public float rustDamage() {
/* 106 */     return this.bulletDamage * this.damageScale;
/*     */   }
/*     */   
/*     */   private static JsonObject createFallbackWeaponJson(String name) {
/* 110 */     LoggerFactory.getLogger("rustmine").error("rustmine: ERROR: missing weapon configuration for '{}'! Weapon is disabled.", name);
/* 111 */     JsonObject o = new JsonObject();
/* 112 */     o.addProperty("repeatDelay", Float.valueOf(1.0F));
/* 113 */     o.addProperty("reloadTime", Float.valueOf(5.0F));
/* 114 */     o.addProperty("deployDelay", Float.valueOf(2.0F));
/* 115 */     o.addProperty("aimCone", Float.valueOf(1.0F));
/* 116 */     o.addProperty("hipAimCone", Float.valueOf(5.0F));
/* 117 */     o.addProperty("damageScale", Float.valueOf(0.0F));
/* 118 */     o.addProperty("bulletDamage", Float.valueOf(0.0F));
/* 119 */     o.addProperty("magazine", Integer.valueOf(0));
/* 120 */     o.addProperty("automatic", Boolean.valueOf(false));
/*     */     
/* 122 */     JsonObject iron = new JsonObject();
/* 123 */     iron.addProperty("zoomFactor", Float.valueOf(1.0F));
/* 124 */     o.add("ironsights", (JsonElement)iron);
/*     */     
/* 126 */     JsonObject punch = new JsonObject();
/* 127 */     o.add("punch", (JsonElement)punch);
/*     */     
/* 129 */     JsonObject r = new JsonObject();
/* 130 */     r.addProperty("recoilYawMin", Float.valueOf(0.0F));
/* 131 */     r.addProperty("recoilYawMax", Float.valueOf(0.0F));
/* 132 */     r.addProperty("recoilPitchMin", Float.valueOf(0.0F));
/* 133 */     r.addProperty("recoilPitchMax", Float.valueOf(0.0F));
/* 134 */     r.addProperty("timeToTakeMin", Float.valueOf(0.2F));
/* 135 */     r.addProperty("timeToTakeMax", Float.valueOf(0.2F));
/* 136 */     r.addProperty("ADSScale", Float.valueOf(1.0F));
/* 137 */     r.addProperty("movementPenalty", Float.valueOf(1.0F));
/* 138 */     o.add("recoil", (JsonElement)r);
/*     */     
/* 140 */     return o;
/*     */   }
/*     */ }


/* Location:              C:\Users\SystemX\AppData\Local\IceCubeRust\game\mods\rustmine-0.1.2.jar!\net\rustmine\combat\WeaponStats.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */
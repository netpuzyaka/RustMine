/*    */ package net.rustmine.combat;
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
/*    */ 
/*    */ public final class Params
/*    */ {
/*    */   public final float speed;
/*    */   public final float gravity;
/*    */   public final float drag;
/*    */   public final float initialDistance;
/*    */   public final float baseDamage;
/*    */   public final float damageMult;
/*    */   public final int color;
/*    */   public final float thickness;
/*    */   public final boolean isArrow;
/*    */   public final boolean isExplosive;
/*    */   public final boolean isIncendiary;
/*    */   public final int pellets;
/*    */   public final double spreadDeg;
/*    */   public final float speedSpread;
/*    */   public final float hitboxRadius;
/*    */   public final float falloffStart;
/*    */   public final float falloffEnd;
/*    */   public final float falloffMult;
/*    */   public final int damageType;
/*    */   public final float tracerWidth;
/*    */   public final float tracerTime;
/*    */   
/*    */   public Params(float speed, float gravity, float drag, float initialDistance, float baseDamage, float damageMult, int color, float thickness, boolean isArrow, boolean isExplosive, boolean isIncendiary, int pellets, double spreadDeg, float speedSpread, float hitboxRadius, float falloffStart, float falloffEnd, float falloffMult, int damageType) {
/* 52 */     this(speed, gravity, drag, initialDistance, baseDamage, damageMult, color, thickness, isArrow, isExplosive, isIncendiary, pellets, spreadDeg, speedSpread, hitboxRadius, falloffStart, falloffEnd, falloffMult, damageType, 0.086F, 0.01F);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Params(float speed, float gravity, float drag, float initialDistance, float baseDamage, float damageMult, int color, float thickness, boolean isArrow, boolean isExplosive, boolean isIncendiary, int pellets, double spreadDeg, float speedSpread, float hitboxRadius, float falloffStart, float falloffEnd, float falloffMult, int damageType, float tracerWidth, float tracerTime) {
/* 59 */     this.tracerWidth = tracerWidth;
/* 60 */     this.tracerTime = tracerTime;
/* 61 */     this.speed = speed;
/* 62 */     this.gravity = gravity;
/* 63 */     this.drag = drag;
/* 64 */     this.initialDistance = initialDistance;
/* 65 */     this.baseDamage = baseDamage;
/* 66 */     this.damageMult = damageMult;
/* 67 */     this.color = color;
/* 68 */     this.thickness = thickness;
/* 69 */     this.isArrow = isArrow;
/* 70 */     this.isExplosive = isExplosive;
/* 71 */     this.isIncendiary = isIncendiary;
/* 72 */     this.pellets = pellets;
/* 73 */     this.spreadDeg = spreadDeg;
/* 74 */     this.speedSpread = speedSpread;
/* 75 */     this.hitboxRadius = hitboxRadius;
/* 76 */     this.falloffStart = falloffStart;
/* 77 */     this.falloffEnd = falloffEnd;
/* 78 */     this.falloffMult = falloffMult;
/* 79 */     this.damageType = damageType;
/*    */   }
/*    */ 
/*    */   
/*    */   public float falloff(double distance) {
/* 84 */     if (this.falloffEnd <= this.falloffStart) return 1.0F; 
/* 85 */     float t = (float)Math.max(0.0D, Math.min(1.0D, (distance - this.falloffStart) / (this.falloffEnd - this.falloffStart)));
/* 86 */     return 1.0F + (this.falloffMult - 1.0F) * t;
/*    */   }
/*    */ }


/* Location:              C:\Users\SystemX\AppData\Local\IceCubeRust\game\mods\rustmine-0.1.2.jar!\net\rustmine\combat\Ballistics$Params.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */
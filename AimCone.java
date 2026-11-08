/*    */ package net.rustmine.combat;
/*    */ 
/*    */ import java.util.Random;
/*    */ import net.minecraft.class_243;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class AimCone
/*    */ {
/* 15 */   public static float spreadFactor = 1.0F;
/*    */   
/*    */   public static boolean zeroCone = false;
/*    */   
/*    */   private static final long CONE_SALT = 18376469676772933L;
/*    */   
/*    */   private static final long RECOIL_SALT = 90457435490636L;
/*    */ 
/*    */   
/*    */   public static int shotSeed(int n) {
/* 25 */     long z = n * -7046029254386353131L + 1397247828L;
/* 26 */     z = (z ^ z >>> 30L) * -4658895280553007687L;
/* 27 */     z = (z ^ z >>> 27L) * -7723592293110705685L;
/* 28 */     return (int)(z ^ z >>> 31L);
/*    */   }
/*    */ 
/*    */   
/*    */   public static class_243 view(float yaw, float pitch) {
/* 33 */     double p = Math.toRadians(pitch), y = Math.toRadians(-yaw);
/* 34 */     double cp = Math.cos(p);
/* 35 */     return new class_243(Math.sin(y) * cp, -Math.sin(p), Math.cos(y) * cp);
/*    */   }
/*    */ 
/*    */   
/*    */   public static class_243 apply(class_243 look, float cone, int seed) {
/* 40 */     float effCone = cone * Math.max(1.0F, spreadFactor) * (zeroCone ? 1.0F : 1.0F);
/* 41 */     if (effCone <= 1.0E-4F) return look; 
/* 42 */     Random r = new Random(seed ^ 0x41494D434F4E45L);
/* 43 */     double ang = r.nextDouble() * Math.PI * 2.0D, rad = Math.sqrt(r.nextDouble());
/* 44 */     double yawOff = Math.toRadians(Math.cos(ang) * rad * effCone * 0.5D), pitchOff = Math.toRadians(Math.sin(ang) * rad * effCone * 0.5D);
/* 45 */     class_243 up0 = (Math.abs(look.field_1351) > 0.99D) ? new class_243(1.0D, 0.0D, 0.0D) : new class_243(0.0D, 1.0D, 0.0D);
/* 46 */     class_243 right = look.method_1036(up0).method_1029(), up = right.method_1036(look).method_1029();
/* 47 */     return look.method_1019(right.method_1021(Math.tan(yawOff))).method_1019(up.method_1021(Math.tan(pitchOff))).method_1029();
/*    */   }
/*    */ 
/*    */   
/*    */   public static float[] recoilKick(WeaponStats stats, int seed) {
/* 52 */     Random r = new Random(seed ^ 0x5245434F494CL);
/* 53 */     float pitch = lerp(r.nextFloat(), stats.pitchMin, stats.pitchMax);
/* 54 */     float yaw = lerp(r.nextFloat(), stats.yawMin, stats.yawMax);
/* 55 */     float time = lerp(r.nextFloat(), stats.timeToTakeMin, stats.timeToTakeMax);
/* 56 */     return new float[] { yaw, pitch, time };
/*    */   }
/*    */ 
/*    */   
/*    */   public static float[] patternTarget(WeaponStats stats, int shots) {
/* 61 */     if (stats.pitchCurve == null || stats.yawCurve == null) return new float[] { 0.0F, 0.0F }; 
/* 62 */     float u = shots / Math.max(1, stats.magazine) % 1.0F;
/* 63 */     return new float[] { stats.yawCurve.evaluate(u) * stats.yawMax, stats.pitchCurve.evaluate(u) * stats.pitchMax };
/*    */   }
/*    */   
/*    */   private static float lerp(float t, float a, float b) {
/* 67 */     return a + (b - a) * t;
/*    */   }
/*    */ }


/* Location:              C:\Users\SystemX\AppData\Local\IceCubeRust\game\mods\rustmine-0.1.2.jar!\net\rustmine\combat\AimCone.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */
/*    */ package net.rustmine.combat;
/*    */ 
/*    */ import com.google.gson.JsonArray;
/*    */ import com.google.gson.JsonElement;
/*    */ 
/*    */ public final class RustCurve
/*    */ {
/*    */   private final float[][] keys;
/*    */   
/*    */   public RustCurve(float[][] keys) {
/* 11 */     this.keys = keys;
/*    */   }
/*    */ 
/*    */   
/*    */   public static RustCurve parse(JsonElement e) {
/* 16 */     if (e == null || !e.isJsonArray() || e.getAsJsonArray().isEmpty()) return null; 
/* 17 */     JsonArray a = e.getAsJsonArray();
/* 18 */     float[][] keys = new float[a.size()][];
/* 19 */     for (int i = 0; i < keys.length; i++) {
/* 20 */       JsonArray k = a.get(i).getAsJsonArray();
/* 21 */       (new float[4])[0] = k.get(0).getAsFloat(); (new float[4])[1] = k.get(1).getAsFloat(); (new float[4])[2] = k.get(2).getAsFloat(); (new float[4])[3] = k.get(3).getAsFloat(); keys[i] = new float[4];
/*    */     } 
/* 23 */     return new RustCurve(keys);
/*    */   }
/*    */   
/*    */   public float evaluate(float t) {
/* 27 */     if (t <= this.keys[0][0]) return this.keys[0][1]; 
/* 28 */     for (int i = 0; i < this.keys.length - 1; i++) {
/* 29 */       float[] a = this.keys[i], b = this.keys[i + 1];
/* 30 */       if (t <= b[0]) {
/* 31 */         if (Float.isInfinite(a[3]) || Float.isInfinite(b[2])) return a[1]; 
/* 32 */         float dt = b[0] - a[0], u = (t - a[0]) / dt, u2 = u * u, u3 = u2 * u;
/* 33 */         return (2.0F * u3 - 3.0F * u2 + 1.0F) * a[1] + (u3 - 2.0F * u2 + u) * dt * a[3] + (-2.0F * u3 + 3.0F * u2) * b[1] + (u3 - u2) * dt * b[2];
/*    */       } 
/*    */     } 
/* 36 */     return this.keys[this.keys.length - 1][1];
/*    */   }
/*    */ }


/* Location:              C:\Users\SystemX\AppData\Local\IceCubeRust\game\mods\rustmine-0.1.2.jar!\net\rustmine\combat\RustCurve.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */
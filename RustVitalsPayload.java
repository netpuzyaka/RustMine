/*    */ package net.rustmine;public final class RustVitalsPayload extends Record implements class_8710 { private final float health;
/*    */   private final float calories;
/*    */   private final float hydration;
/*    */   private final float bleeding;
/*    */   private final int temperature;
/*    */   private final float healOverTime;
/*    */   private final float wetness;
/*    */   private final float radiationPoison;
/*    */   private final float radiationExposure;
/*    */   
/* 11 */   public RustVitalsPayload(float health, float calories, float hydration, float bleeding, int temperature, float healOverTime, float wetness, float radiationPoison, float radiationExposure) { this.health = health; this.calories = calories; this.hydration = hydration; this.bleeding = bleeding; this.temperature = temperature; this.healOverTime = healOverTime; this.wetness = wetness; this.radiationPoison = radiationPoison; this.radiationExposure = radiationExposure; } public final String toString() { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> toString : (Lnet/rustmine/RustVitalsPayload;)Ljava/lang/String;
/*    */     //   6: areturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #11	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/* 11 */     //   0	7	0	this	Lnet/rustmine/RustVitalsPayload; } public float health() { return this.health; } public final int hashCode() { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> hashCode : (Lnet/rustmine/RustVitalsPayload;)I
/*    */     //   6: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #11	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	7	0	this	Lnet/rustmine/RustVitalsPayload; } public final boolean equals(Object o) { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: aload_1
/*    */     //   2: <illegal opcode> equals : (Lnet/rustmine/RustVitalsPayload;Ljava/lang/Object;)Z
/*    */     //   7: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #11	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	8	0	this	Lnet/rustmine/RustVitalsPayload;
/* 11 */     //   0	8	1	o	Ljava/lang/Object; } public float calories() { return this.calories; } public float hydration() { return this.hydration; } public float bleeding() { return this.bleeding; } public int temperature() { return this.temperature; } public float healOverTime() { return this.healOverTime; } public float wetness() { return this.wetness; } public float radiationPoison() { return this.radiationPoison; } public float radiationExposure() { return this.radiationExposure; }
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
/* 23 */   public static final class_8710.class_9154<RustVitalsPayload> TYPE = new class_8710.class_9154(RustmineMod.id("vitals")); public static final class_9139<class_9129, RustVitalsPayload> CODEC;
/*    */   static {
/* 25 */     CODEC = class_9139.method_56437((buf, p) -> {
/*    */           buf.method_52941(p.health);
/*    */           buf.method_52941(p.calories);
/*    */           buf.method_52941(p.hydration);
/*    */           buf.method_52941(p.bleeding);
/*    */           buf.method_53002(p.temperature);
/*    */           buf.method_52941(p.healOverTime);
/*    */           buf.method_52941(p.wetness);
/*    */           buf.method_52941(p.radiationPoison);
/*    */           buf.method_52941(p.radiationExposure);
/*    */         }buf -> new RustVitalsPayload(buf.readFloat(), buf.readFloat(), buf.readFloat(), buf.readFloat(), buf.readInt(), buf.readFloat(), buf.readFloat(), buf.readFloat(), buf.readFloat()));
/*    */   }
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
/*    */   public class_8710.class_9154<? extends class_8710> method_56479() {
/* 52 */     return (class_8710.class_9154)TYPE;
/*    */   } }


/* Location:              C:\Users\SystemX\AppData\Local\IceCubeRust\game\mods\rustmine-0.1.2.jar!\net\rustmine\RustVitalsPayload.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */
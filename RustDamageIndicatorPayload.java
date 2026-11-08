/*    */ package net.rustmine;public final class RustDamageIndicatorPayload extends Record implements class_8710 { private final double sourceX;
/*    */   private final double sourceY;
/*    */   private final double sourceZ;
/*    */   private final float damage;
/*    */   private final boolean hasSource;
/*    */   
/*  7 */   public RustDamageIndicatorPayload(double sourceX, double sourceY, double sourceZ, float damage, boolean hasSource) { this.sourceX = sourceX; this.sourceY = sourceY; this.sourceZ = sourceZ; this.damage = damage; this.hasSource = hasSource; } public final String toString() { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> toString : (Lnet/rustmine/RustDamageIndicatorPayload;)Ljava/lang/String;
/*    */     //   6: areturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #7	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*  7 */     //   0	7	0	this	Lnet/rustmine/RustDamageIndicatorPayload; } public double sourceX() { return this.sourceX; } public final int hashCode() { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> hashCode : (Lnet/rustmine/RustDamageIndicatorPayload;)I
/*    */     //   6: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #7	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	7	0	this	Lnet/rustmine/RustDamageIndicatorPayload; } public final boolean equals(Object o) { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: aload_1
/*    */     //   2: <illegal opcode> equals : (Lnet/rustmine/RustDamageIndicatorPayload;Ljava/lang/Object;)Z
/*    */     //   7: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #7	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	8	0	this	Lnet/rustmine/RustDamageIndicatorPayload;
/*  7 */     //   0	8	1	o	Ljava/lang/Object; } public double sourceY() { return this.sourceY; } public double sourceZ() { return this.sourceZ; } public float damage() { return this.damage; } public boolean hasSource() { return this.hasSource; }
/*  8 */    public static final class_8710.class_9154<RustDamageIndicatorPayload> TYPE = new class_8710.class_9154(RustmineMod.id("damage_indicator")); public static final class_9139<class_9129, RustDamageIndicatorPayload> CODEC; static {
/*  9 */     CODEC = class_9139.method_56437((buf, p) -> {
/*    */           buf.method_52940(p.sourceX);
/*    */           buf.method_52940(p.sourceY);
/*    */           buf.method_52940(p.sourceZ);
/*    */           buf.method_52941(p.damage);
/*    */           buf.method_52964(p.hasSource);
/*    */         }buf -> new RustDamageIndicatorPayload(buf.readDouble(), buf.readDouble(), buf.readDouble(), buf.readFloat(), buf.readBoolean()));
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public class_8710.class_9154<? extends class_8710> method_56479() {
/* 22 */     return (class_8710.class_9154)TYPE;
/*    */   } }


/* Location:              C:\Users\SystemX\AppData\Local\IceCubeRust\game\mods\rustmine-0.1.2.jar!\net\rustmine\RustDamageIndicatorPayload.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */
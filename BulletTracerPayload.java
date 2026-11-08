/*    */ package net.rustmine;
/*    */ 
/*    */ public final class BulletTracerPayload extends Record implements class_8710 {
/*    */   private final int shooterId;
/*    */   private final class_243 eye;
/*    */   private final class_243 origin;
/*    */   private final class_243 dir;
/*    */   private final String gunName;
/*    */   private final String ammoType;
/*    */   private final int seed;
/*    */   
/* 12 */   public BulletTracerPayload(int shooterId, class_243 eye, class_243 origin, class_243 dir, String gunName, String ammoType, int seed) { this.shooterId = shooterId; this.eye = eye; this.origin = origin; this.dir = dir; this.gunName = gunName; this.ammoType = ammoType; this.seed = seed; } public final String toString() { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> toString : (Lnet/rustmine/BulletTracerPayload;)Ljava/lang/String;
/*    */     //   6: areturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #12	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/* 12 */     //   0	7	0	this	Lnet/rustmine/BulletTracerPayload; } public int shooterId() { return this.shooterId; } public final int hashCode() { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> hashCode : (Lnet/rustmine/BulletTracerPayload;)I
/*    */     //   6: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #12	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	7	0	this	Lnet/rustmine/BulletTracerPayload; } public final boolean equals(Object o) { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: aload_1
/*    */     //   2: <illegal opcode> equals : (Lnet/rustmine/BulletTracerPayload;Ljava/lang/Object;)Z
/*    */     //   7: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #12	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	8	0	this	Lnet/rustmine/BulletTracerPayload;
/* 12 */     //   0	8	1	o	Ljava/lang/Object; } public class_243 eye() { return this.eye; } public class_243 origin() { return this.origin; } public class_243 dir() { return this.dir; } public String gunName() { return this.gunName; } public String ammoType() { return this.ammoType; } public int seed() { return this.seed; }
/* 13 */    public static final class_8710.class_9154<BulletTracerPayload> TYPE = new class_8710.class_9154(RustmineMod.id("bullet_tracer")); public static final class_9139<class_9129, BulletTracerPayload> CODEC; static {
/* 14 */     CODEC = class_9139.method_56437((buf, p) -> {
/*    */           buf.method_53002(p.shooterId);
/*    */           buf.method_52955(p.eye);
/*    */           buf.method_52955(p.origin);
/*    */           buf.method_52955(p.dir);
/*    */           buf.method_10814(p.gunName);
/*    */           buf.method_10814(p.ammoType);
/*    */           buf.method_53002(p.seed);
/*    */         }buf -> new BulletTracerPayload(buf.readInt(), buf.method_52996(), buf.method_52996(), buf.method_52996(), buf.method_19772(), buf.method_19772(), buf.readInt()));
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public class_8710.class_9154<? extends class_8710> method_56479() {
/* 29 */     return (class_8710.class_9154)TYPE;
/*    */   }
/*    */ }


/* Location:              C:\Users\SystemX\AppData\Local\IceCubeRust\game\mods\rustmine-0.1.2.jar!\net\rustmine\BulletTracerPayload.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */
/*    */ package net.rustmine;
/*    */ 
/*    */ import net.minecraft.class_9129;
/*    */ 
/*    */ public final class ShootPayload extends Record implements class_8710 {
/*    */   private final class_243 eye;
/*    */   private final float yaw;
/*    */   private final float pitch;
/*    */   private final float cone;
/*    */   private final int seed;
/*    */   
/* 12 */   public ShootPayload(class_243 eye, float yaw, float pitch, float cone, int seed) { this.eye = eye; this.yaw = yaw; this.pitch = pitch; this.cone = cone; this.seed = seed; } public final String toString() { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> toString : (Lnet/rustmine/ShootPayload;)Ljava/lang/String;
/*    */     //   6: areturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #12	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/* 12 */     //   0	7	0	this	Lnet/rustmine/ShootPayload; } public class_243 eye() { return this.eye; } public final int hashCode() { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> hashCode : (Lnet/rustmine/ShootPayload;)I
/*    */     //   6: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #12	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	7	0	this	Lnet/rustmine/ShootPayload; } public final boolean equals(Object o) { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: aload_1
/*    */     //   2: <illegal opcode> equals : (Lnet/rustmine/ShootPayload;Ljava/lang/Object;)Z
/*    */     //   7: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #12	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	8	0	this	Lnet/rustmine/ShootPayload;
/* 12 */     //   0	8	1	o	Ljava/lang/Object; } public float yaw() { return this.yaw; } public float pitch() { return this.pitch; } public float cone() { return this.cone; } public int seed() { return this.seed; }
/* 13 */    public static final class_8710.class_9154<ShootPayload> TYPE = new class_8710.class_9154(RustmineMod.id("shoot")); public static final class_9139<class_9129, ShootPayload> CODEC; static {
/* 14 */     CODEC = class_9139.method_56437((buf, p) -> {
/*    */           buf.method_52955(p.eye);
/*    */           buf.method_52941(p.yaw);
/*    */           buf.method_52941(p.pitch);
/*    */           buf.method_52941(p.cone);
/*    */           buf.method_53002(p.seed);
/*    */         }buf -> new ShootPayload(buf.method_52996(), buf.readFloat(), buf.readFloat(), buf.readFloat(), buf.readInt()));
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public class_8710.class_9154<? extends class_8710> method_56479() {
/* 27 */     return (class_8710.class_9154)TYPE;
/*    */   }
/*    */ }


/* Location:              C:\Users\SystemX\AppData\Local\IceCubeRust\game\mods\rustmine-0.1.2.jar!\net\rustmine\ShootPayload.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */
/*    */ package net.rustmine;
/*    */ 
/*    */ import net.minecraft.class_8710;
/*    */ import net.minecraft.class_9129;
/*    */ 
/*    */ public final class FireRocketPayload extends Record implements class_8710 {
/*    */   private final class_243 dir;
/*    */   
/*  9 */   public FireRocketPayload(class_243 dir) { this.dir = dir; } public final String toString() { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> toString : (Lnet/rustmine/FireRocketPayload;)Ljava/lang/String;
/*    */     //   6: areturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #9	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*  9 */     //   0	7	0	this	Lnet/rustmine/FireRocketPayload; } public class_243 dir() { return this.dir; }
/*    */   public final int hashCode() { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> hashCode : (Lnet/rustmine/FireRocketPayload;)I
/*    */     //   6: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #9	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	7	0	this	Lnet/rustmine/FireRocketPayload; } public final boolean equals(Object o) { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: aload_1
/*    */     //   2: <illegal opcode> equals : (Lnet/rustmine/FireRocketPayload;Ljava/lang/Object;)Z
/*    */     //   7: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #9	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	8	0	this	Lnet/rustmine/FireRocketPayload;
/* 10 */     //   0	8	1	o	Ljava/lang/Object; } public static final class_8710.class_9154<FireRocketPayload> TYPE = new class_8710.class_9154(RustmineMod.id("fire_rocket")); public static final class_9139<class_9129, FireRocketPayload> CODEC; static {
/* 11 */     CODEC = class_9139.method_56437((buf, p) -> buf.method_52955(p.dir), buf -> new FireRocketPayload(buf.method_52996()));
/*    */   }
/*    */ 
/*    */   
/*    */   public class_8710.class_9154<? extends class_8710> method_56479() {
/* 16 */     return (class_8710.class_9154)TYPE;
/*    */   }
/*    */ }


/* Location:              C:\Users\SystemX\AppData\Local\IceCubeRust\game\mods\rustmine-0.1.2.jar!\net\rustmine\FireRocketPayload.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */
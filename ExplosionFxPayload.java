/*    */ package net.rustmine;
/*    */ 
/*    */ import net.minecraft.class_9129;
/*    */ 
/*    */ public final class ExplosionFxPayload extends Record implements class_8710 {
/*    */   private final class_243 pos;
/*    */   private final class_243 normal;
/*    */   
/*  9 */   public ExplosionFxPayload(class_243 pos, class_243 normal) { this.pos = pos; this.normal = normal; } public final String toString() { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> toString : (Lnet/rustmine/ExplosionFxPayload;)Ljava/lang/String;
/*    */     //   6: areturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #9	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*  9 */     //   0	7	0	this	Lnet/rustmine/ExplosionFxPayload; } public class_243 pos() { return this.pos; } public final int hashCode() { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> hashCode : (Lnet/rustmine/ExplosionFxPayload;)I
/*    */     //   6: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #9	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	7	0	this	Lnet/rustmine/ExplosionFxPayload; } public final boolean equals(Object o) { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: aload_1
/*    */     //   2: <illegal opcode> equals : (Lnet/rustmine/ExplosionFxPayload;Ljava/lang/Object;)Z
/*    */     //   7: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #9	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	8	0	this	Lnet/rustmine/ExplosionFxPayload;
/*  9 */     //   0	8	1	o	Ljava/lang/Object; } public class_243 normal() { return this.normal; }
/* 10 */    public static final class_8710.class_9154<ExplosionFxPayload> TYPE = new class_8710.class_9154(RustmineMod.id("explosion_fx")); public static final class_9139<class_9129, ExplosionFxPayload> CODEC; static {
/* 11 */     CODEC = class_9139.method_56437((buf, p) -> {
/*    */           buf.method_52955(p.pos);
/*    */           buf.method_52955(p.normal);
/*    */         }buf -> new ExplosionFxPayload(buf.method_52996(), buf.method_52996()));
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public class_8710.class_9154<? extends class_8710> method_56479() {
/* 20 */     return (class_8710.class_9154)TYPE;
/*    */   }
/*    */ }


/* Location:              C:\Users\SystemX\AppData\Local\IceCubeRust\game\mods\rustmine-0.1.2.jar!\net\rustmine\ExplosionFxPayload.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */
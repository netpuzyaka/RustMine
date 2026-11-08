/*    */ package net.rustmine;
/*    */ 
/*    */ import net.minecraft.class_8710;
/*    */ import net.minecraft.class_9129;
/*    */ import net.minecraft.class_9139;
/*    */ 
/*    */ public final class HitmarkerPayload extends Record implements class_8710 {
/*    */   private final boolean headshot;
/*    */   
/*    */   public HitmarkerPayload(boolean headshot) {
/* 11 */     this.headshot = headshot; } public final String toString() { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> toString : (Lnet/rustmine/HitmarkerPayload;)Ljava/lang/String;
/*    */     //   6: areturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #11	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	7	0	this	Lnet/rustmine/HitmarkerPayload; } public final int hashCode() { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> hashCode : (Lnet/rustmine/HitmarkerPayload;)I
/*    */     //   6: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #11	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	7	0	this	Lnet/rustmine/HitmarkerPayload; } public final boolean equals(Object o) { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: aload_1
/*    */     //   2: <illegal opcode> equals : (Lnet/rustmine/HitmarkerPayload;Ljava/lang/Object;)Z
/*    */     //   7: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #11	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	8	0	this	Lnet/rustmine/HitmarkerPayload;
/* 11 */     //   0	8	1	o	Ljava/lang/Object; } public boolean headshot() { return this.headshot; }
/* 12 */    public static final class_8710.class_9154<HitmarkerPayload> TYPE = new class_8710.class_9154(RustmineMod.id("hitmarker")); public static final class_9139<class_9129, HitmarkerPayload> CODEC; static {
/* 13 */     CODEC = class_9139.method_56437((buf, p) -> buf.method_52964(p.headshot), buf -> new HitmarkerPayload(buf.readBoolean()));
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public class_8710.class_9154<? extends class_8710> method_56479() {
/* 20 */     return (class_8710.class_9154)TYPE;
/*    */   }
/*    */ }


/* Location:              C:\Users\SystemX\AppData\Local\IceCubeRust\game\mods\rustmine-0.1.2.jar!\net\rustmine\HitmarkerPayload.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */
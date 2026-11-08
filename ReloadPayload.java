/*    */ package net.rustmine;
/*    */ 
/*    */ 
/*    */ public final class ReloadPayload extends Record implements class_8710 {
/*    */   private final String ammoType;
/*    */   
/*  7 */   public ReloadPayload(String ammoType) { this.ammoType = ammoType; } public final String toString() { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> toString : (Lnet/rustmine/ReloadPayload;)Ljava/lang/String;
/*    */     //   6: areturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #7	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*  7 */     //   0	7	0	this	Lnet/rustmine/ReloadPayload; } public String ammoType() { return this.ammoType; }
/*    */   public final int hashCode() { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> hashCode : (Lnet/rustmine/ReloadPayload;)I
/*    */     //   6: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #7	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	7	0	this	Lnet/rustmine/ReloadPayload; } public final boolean equals(Object o) { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: aload_1
/*    */     //   2: <illegal opcode> equals : (Lnet/rustmine/ReloadPayload;Ljava/lang/Object;)Z
/*    */     //   7: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #7	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	8	0	this	Lnet/rustmine/ReloadPayload;
/*  8 */     //   0	8	1	o	Ljava/lang/Object; } public static final class_8710.class_9154<ReloadPayload> TYPE = new class_8710.class_9154(RustmineMod.id("reload")); public static final class_9139<class_9129, ReloadPayload> CODEC; static {
/*  9 */     CODEC = class_9139.method_56437((buf, p) -> buf.method_10788(p.ammoType, 64), buf -> new ReloadPayload(buf.method_10800(64)));
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public class_8710.class_9154<? extends class_8710> method_56479() {
/* 15 */     return (class_8710.class_9154)TYPE;
/*    */   }
/*    */ }


/* Location:              C:\Users\SystemX\AppData\Local\IceCubeRust\game\mods\rustmine-0.1.2.jar!\net\rustmine\ReloadPayload.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */
/*    */ package net.rustmine;
/*    */ public final class SplitStackPayload extends Record implements class_8710 {
/*    */   private final int containerId;
/*    */   private final int from;
/*    */   private final int to;
/*    */   private final int amount;
/*    */   
/*  8 */   public SplitStackPayload(int containerId, int from, int to, int amount) { this.containerId = containerId; this.from = from; this.to = to; this.amount = amount; } public final String toString() { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> toString : (Lnet/rustmine/SplitStackPayload;)Ljava/lang/String;
/*    */     //   6: areturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #8	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*  8 */     //   0	7	0	this	Lnet/rustmine/SplitStackPayload; } public int containerId() { return this.containerId; } public final int hashCode() { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> hashCode : (Lnet/rustmine/SplitStackPayload;)I
/*    */     //   6: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #8	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	7	0	this	Lnet/rustmine/SplitStackPayload; } public final boolean equals(Object o) { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: aload_1
/*    */     //   2: <illegal opcode> equals : (Lnet/rustmine/SplitStackPayload;Ljava/lang/Object;)Z
/*    */     //   7: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #8	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	8	0	this	Lnet/rustmine/SplitStackPayload;
/*  8 */     //   0	8	1	o	Ljava/lang/Object; } public int from() { return this.from; } public int to() { return this.to; } public int amount() { return this.amount; }
/*  9 */    public static final class_8710.class_9154<SplitStackPayload> TYPE = new class_8710.class_9154(
/* 10 */       RustmineMod.id("split_stack")); public static final class_9139<class_9129, SplitStackPayload> CODEC;
/*    */   static {
/* 12 */     CODEC = class_9139.method_56437((buf, p) -> {
/*    */           buf.method_53002(p.containerId);
/*    */           buf.method_53002(p.from);
/*    */           buf.method_53002(p.to);
/*    */           buf.method_53002(p.amount);
/*    */         }buf -> new SplitStackPayload(buf.readInt(), buf.readInt(), buf.readInt(), buf.readInt()));
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public class_8710.class_9154<? extends class_8710> method_56479() {
/* 24 */     return (class_8710.class_9154)TYPE;
/*    */   }
/*    */ }


/* Location:              C:\Users\SystemX\AppData\Local\IceCubeRust\game\mods\rustmine-0.1.2.jar!\net\rustmine\SplitStackPayload.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */
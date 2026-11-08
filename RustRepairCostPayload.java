/*    */ package net.rustmine;
/*    */ public final class RustRepairCostPayload extends Record implements class_8710 { private final String text; private final int color;
/*    */   public final String toString() {
/*    */     // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> toString : (Lnet/rustmine/RustRepairCostPayload;)Ljava/lang/String;
/*    */     //   6: areturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #11	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	7	0	this	Lnet/rustmine/RustRepairCostPayload;
/*    */   }
/*    */   
/*    */   public final int hashCode() {
/*    */     // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> hashCode : (Lnet/rustmine/RustRepairCostPayload;)I
/*    */     //   6: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #11	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	7	0	this	Lnet/rustmine/RustRepairCostPayload;
/*    */   }
/*    */   
/* 11 */   public RustRepairCostPayload(String text, int color) { this.text = text; this.color = color; } public final boolean equals(Object o) { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: aload_1
/*    */     //   2: <illegal opcode> equals : (Lnet/rustmine/RustRepairCostPayload;Ljava/lang/Object;)Z
/*    */     //   7: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #11	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	8	0	this	Lnet/rustmine/RustRepairCostPayload;
/* 11 */     //   0	8	1	o	Ljava/lang/Object; } public String text() { return this.text; } public int color() { return this.color; }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 16 */   public static final class_8710.class_9154<RustRepairCostPayload> TYPE = new class_8710.class_9154(
/* 17 */       RustmineMod.id("repair_cost")); public static final class_9139<class_9129, RustRepairCostPayload> CODEC;
/*    */   static {
/* 19 */     CODEC = class_9139.method_56437((buf, p) -> {
/*    */           buf.method_10814(p.text);
/*    */           buf.method_53002(p.color);
/*    */         }buf -> new RustRepairCostPayload(buf.method_19772(), buf.readInt()));
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public class_8710.class_9154<? extends class_8710> method_56479() {
/* 32 */     return (class_8710.class_9154)TYPE;
/*    */   } }


/* Location:              C:\Users\SystemX\AppData\Local\IceCubeRust\game\mods\rustmine-0.1.2.jar!\net\rustmine\RustRepairCostPayload.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */
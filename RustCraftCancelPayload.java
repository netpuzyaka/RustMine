/*    */ package net.rustmine;
/*    */ public final class RustCraftCancelPayload extends Record implements class_8710 { private final int slotIndex;
/*    */   public final String toString() {
/*    */     // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> toString : (Lnet/rustmine/RustCraftCancelPayload;)Ljava/lang/String;
/*    */     //   6: areturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #10	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	7	0	this	Lnet/rustmine/RustCraftCancelPayload;
/*    */   }
/*    */   public final int hashCode() {
/*    */     // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> hashCode : (Lnet/rustmine/RustCraftCancelPayload;)I
/*    */     //   6: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #10	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	7	0	this	Lnet/rustmine/RustCraftCancelPayload;
/*    */   }
/*    */   
/* 10 */   public RustCraftCancelPayload(int slotIndex) { this.slotIndex = slotIndex; } public final boolean equals(Object o) { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: aload_1
/*    */     //   2: <illegal opcode> equals : (Lnet/rustmine/RustCraftCancelPayload;Ljava/lang/Object;)Z
/*    */     //   7: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #10	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	8	0	this	Lnet/rustmine/RustCraftCancelPayload;
/* 10 */     //   0	8	1	o	Ljava/lang/Object; } public int slotIndex() { return this.slotIndex; }
/* 11 */    public static final class_8710.class_9154<RustCraftCancelPayload> TYPE = new class_8710.class_9154(RustmineMod.id("craft_cancel")); public static final class_9139<class_9129, RustCraftCancelPayload> CODEC; static {
/* 12 */     CODEC = class_9139.method_56437((buf, p) -> buf.method_10804(p.slotIndex), buf -> new RustCraftCancelPayload(buf.method_10816()));
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public class_8710.class_9154<? extends class_8710> method_56479() {
/* 19 */     return (class_8710.class_9154)TYPE;
/*    */   } }


/* Location:              C:\Users\SystemX\AppData\Local\IceCubeRust\game\mods\rustmine-0.1.2.jar!\net\rustmine\RustCraftCancelPayload.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */
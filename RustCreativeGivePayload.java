/*    */ package net.rustmine;
/*    */ public final class RustCreativeGivePayload extends Record implements class_8710 {
/*    */   private final String itemId;
/*    */   private final int count;
/*    */   private final boolean clearAll;
/*    */   
/*  7 */   public RustCreativeGivePayload(String itemId, int count, boolean clearAll) { this.itemId = itemId; this.count = count; this.clearAll = clearAll; } public final String toString() { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> toString : (Lnet/rustmine/RustCreativeGivePayload;)Ljava/lang/String;
/*    */     //   6: areturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #7	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*  7 */     //   0	7	0	this	Lnet/rustmine/RustCreativeGivePayload; } public String itemId() { return this.itemId; } public final int hashCode() { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> hashCode : (Lnet/rustmine/RustCreativeGivePayload;)I
/*    */     //   6: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #7	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	7	0	this	Lnet/rustmine/RustCreativeGivePayload; } public final boolean equals(Object o) { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: aload_1
/*    */     //   2: <illegal opcode> equals : (Lnet/rustmine/RustCreativeGivePayload;Ljava/lang/Object;)Z
/*    */     //   7: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #7	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	8	0	this	Lnet/rustmine/RustCreativeGivePayload;
/*  7 */     //   0	8	1	o	Ljava/lang/Object; } public int count() { return this.count; } public boolean clearAll() { return this.clearAll; }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 13 */   public static final class_8710.class_9154<RustCreativeGivePayload> TYPE = new class_8710.class_9154(
/* 14 */       RustmineMod.id("creative_give")); public static final class_9139<class_9129, RustCreativeGivePayload> CODEC;
/*    */   static {
/* 16 */     CODEC = class_9139.method_56437((buf, p) -> {
/*    */           buf.method_10814((p.itemId != null) ? p.itemId : "");
/*    */           buf.method_53002(p.count);
/*    */           buf.method_52964(p.clearAll);
/*    */         }buf -> new RustCreativeGivePayload(buf.method_19772(), buf.readInt(), buf.readBoolean()));
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public class_8710.class_9154<? extends class_8710> method_56479() {
/* 31 */     return (class_8710.class_9154)TYPE;
/*    */   }
/*    */ }


/* Location:              C:\Users\SystemX\AppData\Local\IceCubeRust\game\mods\rustmine-0.1.2.jar!\net\rustmine\RustCreativeGivePayload.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */
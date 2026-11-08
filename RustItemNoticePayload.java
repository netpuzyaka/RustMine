/*    */ package net.rustmine;
/*    */ 
/*    */ public final class RustItemNoticePayload extends Record implements class_8710 {
/*    */   private final String itemId;
/*    */   private final int count;
/*    */   
/*  7 */   public RustItemNoticePayload(String itemId, int count) { this.itemId = itemId; this.count = count; } public final String toString() { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> toString : (Lnet/rustmine/RustItemNoticePayload;)Ljava/lang/String;
/*    */     //   6: areturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #7	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*  7 */     //   0	7	0	this	Lnet/rustmine/RustItemNoticePayload; } public String itemId() { return this.itemId; } public final int hashCode() { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> hashCode : (Lnet/rustmine/RustItemNoticePayload;)I
/*    */     //   6: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #7	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	7	0	this	Lnet/rustmine/RustItemNoticePayload; } public final boolean equals(Object o) { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: aload_1
/*    */     //   2: <illegal opcode> equals : (Lnet/rustmine/RustItemNoticePayload;Ljava/lang/Object;)Z
/*    */     //   7: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #7	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	8	0	this	Lnet/rustmine/RustItemNoticePayload;
/*  7 */     //   0	8	1	o	Ljava/lang/Object; } public int count() { return this.count; }
/*    */ 
/*    */ 
/*    */   
/* 11 */   public static final class_8710.class_9154<RustItemNoticePayload> TYPE = new class_8710.class_9154(
/* 12 */       RustmineMod.id("item_notice")); public static final class_9139<class_9129, RustItemNoticePayload> CODEC;
/*    */   static {
/* 14 */     CODEC = class_9139.method_56437((buf, p) -> {
/*    */           buf.method_10788(p.itemId, 128);
/*    */           buf.method_53002(p.count);
/*    */         }buf -> new RustItemNoticePayload(buf.method_10800(128), buf.readInt()));
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public class_8710.class_9154<? extends class_8710> method_56479() {
/* 27 */     return (class_8710.class_9154)TYPE;
/*    */   }
/*    */ 
/*    */   
/*    */   public static void send(class_3222 player, class_1792 item, int count) {
/* 32 */     if (player == null || item == null || count == 0)
/* 33 */       return;  ServerPlayNetworking.send(player, new RustItemNoticePayload(class_7923.field_41178
/* 34 */           .method_10221(item).toString(), count));
/*    */   }
/*    */ }


/* Location:              C:\Users\SystemX\AppData\Local\IceCubeRust\game\mods\rustmine-0.1.2.jar!\net\rustmine\RustItemNoticePayload.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */
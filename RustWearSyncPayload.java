/*    */ package net.rustmine;
/*    */ public final class RustWearSyncPayload extends Record implements class_8710 { private final int entityId; private final List<class_1799> items;
/*    */   
/*    */   public final String toString() {
/*    */     // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> toString : (Lnet/rustmine/RustWearSyncPayload;)Ljava/lang/String;
/*    */     //   6: areturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #12	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	7	0	this	Lnet/rustmine/RustWearSyncPayload;
/*    */   }
/*    */   
/*    */   public final int hashCode() {
/*    */     // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> hashCode : (Lnet/rustmine/RustWearSyncPayload;)I
/*    */     //   6: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #12	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	7	0	this	Lnet/rustmine/RustWearSyncPayload;
/*    */   }
/*    */   
/* 12 */   public RustWearSyncPayload(int entityId, List<class_1799> items) { this.entityId = entityId; this.items = items; } public final boolean equals(Object o) { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: aload_1
/*    */     //   2: <illegal opcode> equals : (Lnet/rustmine/RustWearSyncPayload;Ljava/lang/Object;)Z
/*    */     //   7: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #12	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	8	0	this	Lnet/rustmine/RustWearSyncPayload;
/* 12 */     //   0	8	1	o	Ljava/lang/Object; } public int entityId() { return this.entityId; } public List<class_1799> items() { return this.items; }
/* 13 */    public static final class_8710.class_9154<RustWearSyncPayload> TYPE = new class_8710.class_9154(RustmineMod.id("wear_sync")); public static final class_9139<class_9129, RustWearSyncPayload> CODEC;
/*    */   static {
/* 15 */     CODEC = class_9139.method_56437((buf, p) -> {
/*    */           buf.method_10804(p.entityId);
/*    */           class_1799.field_49269.encode(buf, p.items);
/*    */         }buf -> new RustWearSyncPayload(buf.method_10816(), (List<class_1799>)class_1799.field_49269.decode(buf)));
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public class_8710.class_9154<? extends class_8710> method_56479() {
/* 25 */     return (class_8710.class_9154)TYPE;
/*    */   } }


/* Location:              C:\Users\SystemX\AppData\Local\IceCubeRust\game\mods\rustmine-0.1.2.jar!\net\rustmine\RustWearSyncPayload.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */
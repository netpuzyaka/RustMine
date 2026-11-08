/*    */ package net.rustmine;
/*    */ public final class RustCraftQueueSyncPayload extends Record implements class_8710 {
/*    */   private final List<Entry> entries;
/*    */   
/*    */   public final String toString() {
/*    */     // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> toString : (Lnet/rustmine/RustCraftQueueSyncPayload;)Ljava/lang/String;
/*    */     //   6: areturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #13	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	7	0	this	Lnet/rustmine/RustCraftQueueSyncPayload;
/*    */   }
/*    */   
/*    */   public final int hashCode() {
/*    */     // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> hashCode : (Lnet/rustmine/RustCraftQueueSyncPayload;)I
/*    */     //   6: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #13	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	7	0	this	Lnet/rustmine/RustCraftQueueSyncPayload;
/*    */   }
/*    */   
/* 13 */   public RustCraftQueueSyncPayload(List<Entry> entries) { this.entries = entries; } public final boolean equals(Object o) { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: aload_1
/*    */     //   2: <illegal opcode> equals : (Lnet/rustmine/RustCraftQueueSyncPayload;Ljava/lang/Object;)Z
/*    */     //   7: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #13	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	8	0	this	Lnet/rustmine/RustCraftQueueSyncPayload;
/* 13 */     //   0	8	1	o	Ljava/lang/Object; } public List<Entry> entries() { return this.entries; }
/* 14 */    public static final class_8710.class_9154<RustCraftQueueSyncPayload> TYPE = new class_8710.class_9154(RustmineMod.id("craft_queue_sync")); public static final class_9139<class_9129, RustCraftQueueSyncPayload> CODEC;
/*    */   public static final class Entry extends Record { private final String recipeId; private final int count; private final float singleItemTime; private final float remainingSingleTime;
/* 16 */     public Entry(String recipeId, int count, float singleItemTime, float remainingSingleTime) { this.recipeId = recipeId; this.count = count; this.singleItemTime = singleItemTime; this.remainingSingleTime = remainingSingleTime; } public final String toString() { // Byte code:
/*    */       //   0: aload_0
/*    */       //   1: <illegal opcode> toString : (Lnet/rustmine/RustCraftQueueSyncPayload$Entry;)Ljava/lang/String;
/*    */       //   6: areturn
/*    */       // Line number table:
/*    */       //   Java source line number -> byte code offset
/*    */       //   #16	-> 0
/*    */       // Local variable table:
/*    */       //   start	length	slot	name	descriptor
/* 16 */       //   0	7	0	this	Lnet/rustmine/RustCraftQueueSyncPayload$Entry; } public String recipeId() { return this.recipeId; } public final int hashCode() { // Byte code:
/*    */       //   0: aload_0
/*    */       //   1: <illegal opcode> hashCode : (Lnet/rustmine/RustCraftQueueSyncPayload$Entry;)I
/*    */       //   6: ireturn
/*    */       // Line number table:
/*    */       //   Java source line number -> byte code offset
/*    */       //   #16	-> 0
/*    */       // Local variable table:
/*    */       //   start	length	slot	name	descriptor
/*    */       //   0	7	0	this	Lnet/rustmine/RustCraftQueueSyncPayload$Entry; } public final boolean equals(Object o) { // Byte code:
/*    */       //   0: aload_0
/*    */       //   1: aload_1
/*    */       //   2: <illegal opcode> equals : (Lnet/rustmine/RustCraftQueueSyncPayload$Entry;Ljava/lang/Object;)Z
/*    */       //   7: ireturn
/*    */       // Line number table:
/*    */       //   Java source line number -> byte code offset
/*    */       //   #16	-> 0
/*    */       // Local variable table:
/*    */       //   start	length	slot	name	descriptor
/*    */       //   0	8	0	this	Lnet/rustmine/RustCraftQueueSyncPayload$Entry;
/* 16 */       //   0	8	1	o	Ljava/lang/Object; } public int count() { return this.count; } public float singleItemTime() { return this.singleItemTime; } public float remainingSingleTime() { return this.remainingSingleTime; }
/*    */      } static {
/* 18 */     CODEC = class_9139.method_56437((buf, p) -> {
/*    */           buf.method_10804(p.entries.size());
/*    */           for (Entry e : p.entries) {
/*    */             buf.method_10814(e.recipeId());
/*    */             buf.method_10804(e.count());
/*    */             buf.method_52941(e.singleItemTime());
/*    */             buf.method_52941(e.remainingSingleTime());
/*    */           } 
/*    */         }buf -> {
/*    */           int count = buf.method_10816();
/*    */           List<Entry> list = new ArrayList<>(count);
/*    */           for (int i = 0; i < count; i++) {
/*    */             list.add(new Entry(buf.method_19772(), buf.method_10816(), buf.readFloat(), buf.readFloat()));
/*    */           }
/*    */           return new RustCraftQueueSyncPayload(list);
/*    */         });
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public class_8710.class_9154<? extends class_8710> method_56479() {
/* 40 */     return (class_8710.class_9154)TYPE;
/*    */   }
/*    */ }


/* Location:              C:\Users\SystemX\AppData\Local\IceCubeRust\game\mods\rustmine-0.1.2.jar!\net\rustmine\RustCraftQueueSyncPayload.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */
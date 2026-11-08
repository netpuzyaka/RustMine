/*    */ package net.rustmine;
/*    */ public final class Entry extends Record { private final String recipeId; private final int count; private final float singleItemTime; private final float remainingSingleTime;
/*    */   
/*    */   public final String toString() {
/*    */     // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> toString : (Lnet/rustmine/RustCraftQueueSyncPayload$Entry;)Ljava/lang/String;
/*    */     //   6: areturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #16	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	7	0	this	Lnet/rustmine/RustCraftQueueSyncPayload$Entry;
/*    */   }
/*    */   
/*    */   public final int hashCode() {
/*    */     // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> hashCode : (Lnet/rustmine/RustCraftQueueSyncPayload$Entry;)I
/*    */     //   6: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #16	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	7	0	this	Lnet/rustmine/RustCraftQueueSyncPayload$Entry;
/*    */   }
/*    */   
/*    */   public final boolean equals(Object o) {
/*    */     // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: aload_1
/*    */     //   2: <illegal opcode> equals : (Lnet/rustmine/RustCraftQueueSyncPayload$Entry;Ljava/lang/Object;)Z
/*    */     //   7: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #16	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	8	0	this	Lnet/rustmine/RustCraftQueueSyncPayload$Entry;
/*    */     //   0	8	1	o	Ljava/lang/Object;
/*    */   }
/*    */   
/* 16 */   public Entry(String recipeId, int count, float singleItemTime, float remainingSingleTime) { this.recipeId = recipeId; this.count = count; this.singleItemTime = singleItemTime; this.remainingSingleTime = remainingSingleTime; } public String recipeId() { return this.recipeId; } public int count() { return this.count; } public float singleItemTime() { return this.singleItemTime; } public float remainingSingleTime() { return this.remainingSingleTime; }
/*    */    }


/* Location:              C:\Users\SystemX\AppData\Local\IceCubeRust\game\mods\rustmine-0.1.2.jar!\net\rustmine\RustCraftQueueSyncPayload$Entry.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */
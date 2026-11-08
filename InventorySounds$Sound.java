/*    */ package net.rustmine;
/*    */ 
/*    */ final class Sound extends Record {
/*    */   private final String event;
/*    */   private final float volume;
/*    */   private final float volumeVariation;
/*    */   private final float pitch;
/*    */   private final float pitchVariation;
/*    */   
/*    */   public final String toString() {
/*    */     // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> toString : (Lnet/rustmine/InventorySounds$Sound;)Ljava/lang/String;
/*    */     //   6: areturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #23	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	7	0	this	Lnet/rustmine/InventorySounds$Sound;
/*    */   }
/*    */   
/*    */   public final int hashCode() {
/*    */     // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> hashCode : (Lnet/rustmine/InventorySounds$Sound;)I
/*    */     //   6: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #23	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	7	0	this	Lnet/rustmine/InventorySounds$Sound;
/*    */   }
/*    */   
/*    */   public final boolean equals(Object o) {
/*    */     // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: aload_1
/*    */     //   2: <illegal opcode> equals : (Lnet/rustmine/InventorySounds$Sound;Ljava/lang/Object;)Z
/*    */     //   7: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #23	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	8	0	this	Lnet/rustmine/InventorySounds$Sound;
/*    */     //   0	8	1	o	Ljava/lang/Object;
/*    */   }
/*    */   
/*    */   private Sound(String event, float volume, float volumeVariation, float pitch, float pitchVariation) {
/* 23 */     this.event = event; this.volume = volume; this.volumeVariation = volumeVariation; this.pitch = pitch; this.pitchVariation = pitchVariation; } public String event() { return this.event; } public float volume() { return this.volume; } public float volumeVariation() { return this.volumeVariation; } public float pitch() { return this.pitch; } public float pitchVariation() { return this.pitchVariation; }
/*    */ 
/*    */ }


/* Location:              C:\Users\SystemX\AppData\Local\IceCubeRust\game\mods\rustmine-0.1.2.jar!\net\rustmine\InventorySounds$Sound.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */
/*    */ package net.rustmine;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ final class Def
/*    */   extends Record
/*    */ {
/*    */   private final float max;
/*    */   private final float foundMin;
/*    */   private final float foundMax;
/*    */   private final boolean maintainMax;
/*    */   private final int ammo;
/*    */   private final boolean repairable;
/*    */   
/*    */   public final String toString() {
/*    */     // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> toString : (Lnet/rustmine/RustItemCondition$Def;)Ljava/lang/String;
/*    */     //   6: areturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #36	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	7	0	this	Lnet/rustmine/RustItemCondition$Def;
/*    */   }
/*    */   
/*    */   public final int hashCode() {
/*    */     // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> hashCode : (Lnet/rustmine/RustItemCondition$Def;)I
/*    */     //   6: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #36	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	7	0	this	Lnet/rustmine/RustItemCondition$Def;
/*    */   }
/*    */   
/*    */   public final boolean equals(Object o) {
/*    */     // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: aload_1
/*    */     //   2: <illegal opcode> equals : (Lnet/rustmine/RustItemCondition$Def;Ljava/lang/Object;)Z
/*    */     //   7: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #36	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	8	0	this	Lnet/rustmine/RustItemCondition$Def;
/*    */     //   0	8	1	o	Ljava/lang/Object;
/*    */   }
/*    */   
/*    */   private Def(float max, float foundMin, float foundMax, boolean maintainMax, int ammo, boolean repairable) {
/* 36 */     this.max = max; this.foundMin = foundMin; this.foundMax = foundMax; this.maintainMax = maintainMax; this.ammo = ammo; this.repairable = repairable; } public float max() { return this.max; } public float foundMin() { return this.foundMin; } public float foundMax() { return this.foundMax; } public boolean maintainMax() { return this.maintainMax; } public int ammo() { return this.ammo; } public boolean repairable() { return this.repairable; }
/*    */ 
/*    */ }


/* Location:              C:\Users\SystemX\AppData\Local\IceCubeRust\game\mods\rustmine-0.1.2.jar!\net\rustmine\RustItemCondition$Def.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */
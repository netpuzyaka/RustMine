/*    */ package net.rustmine;
/*    */ 
/*    */ public final class Blueprint extends Record {
/*    */   private final float time;
/*    */   private final int amount;
/*    */   private final int workbench;
/*    */   private final boolean def;
/*    */   private final boolean craftable;
/*    */   private final boolean researchable;
/*    */   private final int category;
/*    */   private final int rarity;
/*    */   private final int scrapFromRecycle;
/*    */   private final List<RustBlueprints.Ingredient> ingredients;
/*    */   
/*    */   public final String toString() {
/*    */     // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> toString : (Lnet/rustmine/RustBlueprints$Blueprint;)Ljava/lang/String;
/*    */     //   6: areturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #27	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	7	0	this	Lnet/rustmine/RustBlueprints$Blueprint;
/*    */   }
/*    */   
/*    */   public final int hashCode() {
/*    */     // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> hashCode : (Lnet/rustmine/RustBlueprints$Blueprint;)I
/*    */     //   6: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #27	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	7	0	this	Lnet/rustmine/RustBlueprints$Blueprint;
/*    */   }
/*    */   
/*    */   public final boolean equals(Object o) {
/*    */     // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: aload_1
/*    */     //   2: <illegal opcode> equals : (Lnet/rustmine/RustBlueprints$Blueprint;Ljava/lang/Object;)Z
/*    */     //   7: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #27	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	8	0	this	Lnet/rustmine/RustBlueprints$Blueprint;
/*    */     //   0	8	1	o	Ljava/lang/Object;
/*    */   }
/*    */   
/* 27 */   public Blueprint(float time, int amount, int workbench, boolean def, boolean craftable, boolean researchable, int category, int rarity, int scrapFromRecycle, List<RustBlueprints.Ingredient> ingredients) { this.time = time; this.amount = amount; this.workbench = workbench; this.def = def; this.craftable = craftable; this.researchable = researchable; this.category = category; this.rarity = rarity; this.scrapFromRecycle = scrapFromRecycle; this.ingredients = ingredients; } public float time() { return this.time; } public int amount() { return this.amount; } public int workbench() { return this.workbench; } public boolean def() { return this.def; } public boolean craftable() { return this.craftable; } public boolean researchable() { return this.researchable; } public int category() { return this.category; } public int rarity() { return this.rarity; } public int scrapFromRecycle() { return this.scrapFromRecycle; } public List<RustBlueprints.Ingredient> ingredients() { return this.ingredients; }
/*    */ 
/*    */ }


/* Location:              C:\Users\SystemX\AppData\Local\IceCubeRust\game\mods\rustmine-0.1.2.jar!\net\rustmine\RustBlueprints$Blueprint.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */
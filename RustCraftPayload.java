/*    */ package net.rustmine;
/*    */ 
/*    */ public final class RustCraftPayload extends Record implements class_8710 {
/*    */   private final String recipeId;
/*    */   private final int count;
/*    */   
/*  7 */   public RustCraftPayload(String recipeId, int count) { this.recipeId = recipeId; this.count = count; } public final String toString() { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> toString : (Lnet/rustmine/RustCraftPayload;)Ljava/lang/String;
/*    */     //   6: areturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #7	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*  7 */     //   0	7	0	this	Lnet/rustmine/RustCraftPayload; } public String recipeId() { return this.recipeId; } public final int hashCode() { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> hashCode : (Lnet/rustmine/RustCraftPayload;)I
/*    */     //   6: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #7	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	7	0	this	Lnet/rustmine/RustCraftPayload; } public final boolean equals(Object o) { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: aload_1
/*    */     //   2: <illegal opcode> equals : (Lnet/rustmine/RustCraftPayload;Ljava/lang/Object;)Z
/*    */     //   7: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #7	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	8	0	this	Lnet/rustmine/RustCraftPayload;
/*  7 */     //   0	8	1	o	Ljava/lang/Object; } public int count() { return this.count; }
/*  8 */    public static final class_8710.class_9154<RustCraftPayload> TYPE = new class_8710.class_9154(RustmineMod.id("craft")); public static final class_9139<class_9129, RustCraftPayload> CODEC; static {
/*  9 */     CODEC = class_9139.method_56437((buf, p) -> {
/*    */           buf.method_10814(p.recipeId);
/*    */           buf.method_10804(p.count);
/*    */         }buf -> new RustCraftPayload(buf.method_19772(), buf.method_10816()));
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public RustCraftPayload(String recipeId) {
/* 18 */     this(recipeId, 1);
/*    */   }
/*    */ 
/*    */   
/*    */   public class_8710.class_9154<? extends class_8710> method_56479() {
/* 23 */     return (class_8710.class_9154)TYPE;
/*    */   }
/*    */ }


/* Location:              C:\Users\SystemX\AppData\Local\IceCubeRust\game\mods\rustmine-0.1.2.jar!\net\rustmine\RustCraftPayload.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */
/*    */ package net.rustmine;
/*    */ public final class RustResearchActionPayload extends Record implements class_8710 { private final String recipeId;
/*    */   public final String toString() {
/*    */     // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> toString : (Lnet/rustmine/RustResearchActionPayload;)Ljava/lang/String;
/*    */     //   6: areturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #10	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	7	0	this	Lnet/rustmine/RustResearchActionPayload;
/*    */   }
/*    */   public final int hashCode() {
/*    */     // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> hashCode : (Lnet/rustmine/RustResearchActionPayload;)I
/*    */     //   6: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #10	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	7	0	this	Lnet/rustmine/RustResearchActionPayload;
/*    */   }
/*    */   
/* 10 */   public RustResearchActionPayload(String recipeId) { this.recipeId = recipeId; } public final boolean equals(Object o) { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: aload_1
/*    */     //   2: <illegal opcode> equals : (Lnet/rustmine/RustResearchActionPayload;Ljava/lang/Object;)Z
/*    */     //   7: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #10	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	8	0	this	Lnet/rustmine/RustResearchActionPayload;
/* 10 */     //   0	8	1	o	Ljava/lang/Object; } public String recipeId() { return this.recipeId; }
/* 11 */    public static final class_8710.class_9154<RustResearchActionPayload> TYPE = new class_8710.class_9154(RustmineMod.id("research_action")); public static final class_9139<class_9129, RustResearchActionPayload> CODEC; static {
/* 12 */     CODEC = class_9139.method_56437((buf, p) -> buf.method_10814(p.recipeId), buf -> new RustResearchActionPayload(buf.method_19772()));
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public class_8710.class_9154<? extends class_8710> method_56479() {
/* 19 */     return (class_8710.class_9154)TYPE;
/*    */   } }


/* Location:              C:\Users\SystemX\AppData\Local\IceCubeRust\game\mods\rustmine-0.1.2.jar!\net\rustmine\RustResearchActionPayload.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */
/*    */ package net.rustmine;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import net.minecraft.class_8710;
/*    */ import net.minecraft.class_9129;
/*    */ import net.minecraft.class_9139;
/*    */ 
/*    */ public final class RustResearchSyncPayload extends Record implements class_8710 {
/*    */   private final List<String> unlockedRecipeIds;
/*    */   
/*    */   public RustResearchSyncPayload(List<String> unlockedRecipeIds) {
/* 13 */     this.unlockedRecipeIds = unlockedRecipeIds; } public final String toString() { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> toString : (Lnet/rustmine/RustResearchSyncPayload;)Ljava/lang/String;
/*    */     //   6: areturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #13	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	7	0	this	Lnet/rustmine/RustResearchSyncPayload; } public final int hashCode() { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> hashCode : (Lnet/rustmine/RustResearchSyncPayload;)I
/*    */     //   6: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #13	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	7	0	this	Lnet/rustmine/RustResearchSyncPayload; } public final boolean equals(Object o) { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: aload_1
/*    */     //   2: <illegal opcode> equals : (Lnet/rustmine/RustResearchSyncPayload;Ljava/lang/Object;)Z
/*    */     //   7: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #13	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	8	0	this	Lnet/rustmine/RustResearchSyncPayload;
/* 13 */     //   0	8	1	o	Ljava/lang/Object; } public List<String> unlockedRecipeIds() { return this.unlockedRecipeIds; }
/* 14 */    public static final class_8710.class_9154<RustResearchSyncPayload> TYPE = new class_8710.class_9154(RustmineMod.id("research_sync")); public static final class_9139<class_9129, RustResearchSyncPayload> CODEC; static {
/* 15 */     CODEC = class_9139.method_56437((buf, p) -> {
/*    */           buf.method_10804(p.unlockedRecipeIds.size());
/*    */           for (String id : p.unlockedRecipeIds) {
/*    */             buf.method_10814(id);
/*    */           }
/*    */         }buf -> {
/*    */           int count = buf.method_10816();
/*    */           List<String> list = new ArrayList<>(count);
/*    */           for (int i = 0; i < count; i++) {
/*    */             list.add(buf.method_19772());
/*    */           }
/*    */           return new RustResearchSyncPayload(list);
/*    */         });
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public class_8710.class_9154<? extends class_8710> method_56479() {
/* 34 */     return (class_8710.class_9154)TYPE;
/*    */   }
/*    */ }


/* Location:              C:\Users\SystemX\AppData\Local\IceCubeRust\game\mods\rustmine-0.1.2.jar!\net\rustmine\RustResearchSyncPayload.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */
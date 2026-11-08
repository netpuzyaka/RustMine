/*    */ package net.rustmine;
/*    */ import net.minecraft.class_8710;
/*    */ 
/*    */ public final class ReloadStartPayload extends Record implements class_8710 {
/*    */   public final String toString() {
/*    */     // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> toString : (Lnet/rustmine/ReloadStartPayload;)Ljava/lang/String;
/*    */     //   6: areturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #8	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	7	0	this	Lnet/rustmine/ReloadStartPayload;
/*    */   }
/*    */   
/*  9 */   public static final class_8710.class_9154<ReloadStartPayload> TYPE = new class_8710.class_9154(RustmineMod.id("reload_start"));
/*    */   public final int hashCode() { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> hashCode : (Lnet/rustmine/ReloadStartPayload;)I
/*    */     //   6: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #8	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	7	0	this	Lnet/rustmine/ReloadStartPayload; } public final boolean equals(Object o) { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: aload_1
/*    */     //   2: <illegal opcode> equals : (Lnet/rustmine/ReloadStartPayload;Ljava/lang/Object;)Z
/*    */     //   7: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #8	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	8	0	this	Lnet/rustmine/ReloadStartPayload;
/* 10 */     //   0	8	1	o	Ljava/lang/Object; } public static final class_9139<class_9129, ReloadStartPayload> CODEC = class_9139.method_56437((buf, p) -> {
/*    */       
/*    */       }buf -> new ReloadStartPayload());
/*    */   public class_8710.class_9154<? extends class_8710> method_56479() {
/* 14 */     return (class_8710.class_9154)TYPE;
/*    */   }
/*    */ }


/* Location:              C:\Users\SystemX\AppData\Local\IceCubeRust\game\mods\rustmine-0.1.2.jar!\net\rustmine\ReloadStartPayload.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */
/*    */ package net.rustmine;
/*    */ 
/*    */ public final class MedicalActionPayload extends Record implements class_8710 {
/*    */   private final int playerId;
/*    */   private final String action;
/*    */   
/*  7 */   public MedicalActionPayload(int playerId, String action) { this.playerId = playerId; this.action = action; } public final String toString() { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> toString : (Lnet/rustmine/MedicalActionPayload;)Ljava/lang/String;
/*    */     //   6: areturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #7	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*  7 */     //   0	7	0	this	Lnet/rustmine/MedicalActionPayload; } public int playerId() { return this.playerId; } public final int hashCode() { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> hashCode : (Lnet/rustmine/MedicalActionPayload;)I
/*    */     //   6: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #7	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	7	0	this	Lnet/rustmine/MedicalActionPayload; } public final boolean equals(Object o) { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: aload_1
/*    */     //   2: <illegal opcode> equals : (Lnet/rustmine/MedicalActionPayload;Ljava/lang/Object;)Z
/*    */     //   7: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #7	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	8	0	this	Lnet/rustmine/MedicalActionPayload;
/*  7 */     //   0	8	1	o	Ljava/lang/Object; } public String action() { return this.action; }
/*  8 */    public static final class_8710.class_9154<MedicalActionPayload> TYPE = new class_8710.class_9154(RustmineMod.id("medical_action")); public static final class_9139<class_9129, MedicalActionPayload> CODEC; static {
/*  9 */     CODEC = class_9139.method_56437((buf, p) -> {
/*    */           buf.method_53002(p.playerId);
/*    */           buf.method_10788(p.action, 64);
/*    */         }buf -> new MedicalActionPayload(buf.readInt(), buf.method_10800(64)));
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public class_8710.class_9154<? extends class_8710> method_56479() {
/* 19 */     return (class_8710.class_9154)TYPE;
/*    */   }
/*    */ }


/* Location:              C:\Users\SystemX\AppData\Local\IceCubeRust\game\mods\rustmine-0.1.2.jar!\net\rustmine\MedicalActionPayload.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */
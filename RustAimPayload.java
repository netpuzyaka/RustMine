/*    */ package net.rustmine;
/*    */ 
/*    */ public final class RustAimPayload extends Record implements class_8710 {
/*    */   private final int playerId;
/*    */   private final boolean aiming;
/*    */   
/*  7 */   public RustAimPayload(int playerId, boolean aiming) { this.playerId = playerId; this.aiming = aiming; } public final String toString() { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> toString : (Lnet/rustmine/RustAimPayload;)Ljava/lang/String;
/*    */     //   6: areturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #7	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*  7 */     //   0	7	0	this	Lnet/rustmine/RustAimPayload; } public int playerId() { return this.playerId; } public final int hashCode() { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> hashCode : (Lnet/rustmine/RustAimPayload;)I
/*    */     //   6: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #7	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	7	0	this	Lnet/rustmine/RustAimPayload; } public final boolean equals(Object o) { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: aload_1
/*    */     //   2: <illegal opcode> equals : (Lnet/rustmine/RustAimPayload;Ljava/lang/Object;)Z
/*    */     //   7: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #7	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	8	0	this	Lnet/rustmine/RustAimPayload;
/*  7 */     //   0	8	1	o	Ljava/lang/Object; } public boolean aiming() { return this.aiming; }
/*  8 */    public static final class_8710.class_9154<RustAimPayload> TYPE = new class_8710.class_9154(RustmineMod.id("player_aim")); public static final class_9139<class_9129, RustAimPayload> CODEC; static {
/*  9 */     CODEC = class_9139.method_56437((buf, p) -> {
/*    */           buf.method_53002(p.playerId);
/*    */           buf.method_52964(p.aiming);
/*    */         }buf -> new RustAimPayload(buf.readInt(), buf.readBoolean()));
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public class_8710.class_9154<? extends class_8710> method_56479() {
/* 19 */     return (class_8710.class_9154)TYPE;
/*    */   }
/*    */ }


/* Location:              C:\Users\SystemX\AppData\Local\IceCubeRust\game\mods\rustmine-0.1.2.jar!\net\rustmine\RustAimPayload.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */
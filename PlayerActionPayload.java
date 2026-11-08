/*    */ package net.rustmine;
/*    */ public final class PlayerActionPayload extends Record implements class_8710 {
/*    */   private final int playerId;
/*    */   private final String action;
/*    */   
/*    */   public final String toString() {
/*    */     // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> toString : (Lnet/rustmine/PlayerActionPayload;)Ljava/lang/String;
/*    */     //   6: areturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #14	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	7	0	this	Lnet/rustmine/PlayerActionPayload;
/*    */   }
/*    */   
/*    */   public final int hashCode() {
/*    */     // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> hashCode : (Lnet/rustmine/PlayerActionPayload;)I
/*    */     //   6: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #14	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	7	0	this	Lnet/rustmine/PlayerActionPayload;
/*    */   }
/*    */   
/* 14 */   public PlayerActionPayload(int playerId, String action) { this.playerId = playerId; this.action = action; } public final boolean equals(Object o) { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: aload_1
/*    */     //   2: <illegal opcode> equals : (Lnet/rustmine/PlayerActionPayload;Ljava/lang/Object;)Z
/*    */     //   7: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #14	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	8	0	this	Lnet/rustmine/PlayerActionPayload;
/* 14 */     //   0	8	1	o	Ljava/lang/Object; } public int playerId() { return this.playerId; } public String action() { return this.action; }
/* 15 */    public static final class_8710.class_9154<PlayerActionPayload> TYPE = new class_8710.class_9154(RustmineMod.id("player_action")); public static final class_9139<class_9129, PlayerActionPayload> CODEC; static {
/* 16 */     CODEC = class_9139.method_56437((buf, p) -> {
/*    */           buf.method_10804(p.playerId);
/*    */           buf.method_10788(p.action, 32);
/*    */         }buf -> new PlayerActionPayload(buf.method_10816(), buf.method_10800(32)));
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void broadcast(class_3222 sp, String action) {
/* 26 */     PlayerActionPayload p = new PlayerActionPayload(sp.method_5628(), action);
/* 27 */     for (class_3222 tracker : PlayerLookup.tracking((class_1297)sp)) {
/* 28 */       if (tracker != sp) ServerPlayNetworking.send(tracker, p);
/*    */     
/*    */     } 
/*    */   }
/*    */   
/*    */   public class_8710.class_9154<? extends class_8710> method_56479() {
/* 34 */     return (class_8710.class_9154)TYPE;
/*    */   }
/*    */ }


/* Location:              C:\Users\SystemX\AppData\Local\IceCubeRust\game\mods\rustmine-0.1.2.jar!\net\rustmine\PlayerActionPayload.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */
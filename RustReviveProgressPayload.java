/*    */ package net.rustmine;
/*    */ public final class RustReviveProgressPayload extends Record implements class_8710 { private final UUID victimUuid; private final float progress;
/*    */   public final String toString() {
/*    */     // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> toString : (Lnet/rustmine/RustReviveProgressPayload;)Ljava/lang/String;
/*    */     //   6: areturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #11	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	7	0	this	Lnet/rustmine/RustReviveProgressPayload;
/*    */   }
/*    */   
/*    */   public final int hashCode() {
/*    */     // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> hashCode : (Lnet/rustmine/RustReviveProgressPayload;)I
/*    */     //   6: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #11	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	7	0	this	Lnet/rustmine/RustReviveProgressPayload;
/*    */   }
/*    */   
/* 11 */   public RustReviveProgressPayload(UUID victimUuid, float progress) { this.victimUuid = victimUuid; this.progress = progress; } public final boolean equals(Object o) { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: aload_1
/*    */     //   2: <illegal opcode> equals : (Lnet/rustmine/RustReviveProgressPayload;Ljava/lang/Object;)Z
/*    */     //   7: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #11	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	8	0	this	Lnet/rustmine/RustReviveProgressPayload;
/* 11 */     //   0	8	1	o	Ljava/lang/Object; } public UUID victimUuid() { return this.victimUuid; } public float progress() { return this.progress; }
/*    */ 
/*    */ 
/*    */   
/* 15 */   public static final class_8710.class_9154<RustReviveProgressPayload> TYPE = new class_8710.class_9154(RustmineMod.id("player_revive_progress")); public static final class_9139<class_9129, RustReviveProgressPayload> CODEC; static {
/* 16 */     CODEC = class_9139.method_56437((buf, p) -> {
/*    */           buf.method_10797(p.victimUuid);
/*    */           buf.method_52941(p.progress);
/*    */         }buf -> new RustReviveProgressPayload(buf.method_10790(), buf.readFloat()));
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public class_8710.class_9154<? extends class_8710> method_56479() {
/* 29 */     return (class_8710.class_9154)TYPE;
/*    */   } }


/* Location:              C:\Users\SystemX\AppData\Local\IceCubeRust\game\mods\rustmine-0.1.2.jar!\net\rustmine\RustReviveProgressPayload.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */
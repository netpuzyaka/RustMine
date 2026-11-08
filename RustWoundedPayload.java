/*    */ package net.rustmine;
/*    */ public final class RustWoundedPayload extends Record implements class_8710 {
/*    */   private final UUID playerUuid;
/*    */   private final boolean isWounded;
/*    */   private final int durationTicks;
/*    */   private final int remainingTicks;
/*    */   private final float recoverChance;
/*    */   private final boolean hasMedkit;
/*    */   private final boolean isLooted;
/*    */   
/* 11 */   public RustWoundedPayload(UUID playerUuid, boolean isWounded, int durationTicks, int remainingTicks, float recoverChance, boolean hasMedkit, boolean isLooted) { this.playerUuid = playerUuid; this.isWounded = isWounded; this.durationTicks = durationTicks; this.remainingTicks = remainingTicks; this.recoverChance = recoverChance; this.hasMedkit = hasMedkit; this.isLooted = isLooted; } public final String toString() { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> toString : (Lnet/rustmine/RustWoundedPayload;)Ljava/lang/String;
/*    */     //   6: areturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #11	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/* 11 */     //   0	7	0	this	Lnet/rustmine/RustWoundedPayload; } public UUID playerUuid() { return this.playerUuid; } public final int hashCode() { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> hashCode : (Lnet/rustmine/RustWoundedPayload;)I
/*    */     //   6: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #11	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	7	0	this	Lnet/rustmine/RustWoundedPayload; } public final boolean equals(Object o) { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: aload_1
/*    */     //   2: <illegal opcode> equals : (Lnet/rustmine/RustWoundedPayload;Ljava/lang/Object;)Z
/*    */     //   7: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #11	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	8	0	this	Lnet/rustmine/RustWoundedPayload;
/* 11 */     //   0	8	1	o	Ljava/lang/Object; } public boolean isWounded() { return this.isWounded; } public int durationTicks() { return this.durationTicks; } public int remainingTicks() { return this.remainingTicks; } public float recoverChance() { return this.recoverChance; } public boolean hasMedkit() { return this.hasMedkit; } public boolean isLooted() { return this.isLooted; }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 20 */   public static final class_8710.class_9154<RustWoundedPayload> TYPE = new class_8710.class_9154(RustmineMod.id("player_wounded")); public static final class_9139<class_9129, RustWoundedPayload> CODEC; static {
/* 21 */     CODEC = class_9139.method_56437((buf, p) -> {
/*    */           buf.method_10797(p.playerUuid);
/*    */           buf.method_52964(p.isWounded);
/*    */           buf.method_53002(p.durationTicks);
/*    */           buf.method_53002(p.remainingTicks);
/*    */           buf.method_52941(p.recoverChance);
/*    */           buf.method_52964(p.hasMedkit);
/*    */           buf.method_52964(p.isLooted);
/*    */         }buf -> new RustWoundedPayload(buf.method_10790(), buf.readBoolean(), buf.readInt(), buf.readInt(), buf.readFloat(), buf.readBoolean(), buf.readBoolean()));
/*    */   }
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
/*    */   
/*    */   public class_8710.class_9154<? extends class_8710> method_56479() {
/* 44 */     return (class_8710.class_9154)TYPE;
/*    */   }
/*    */ }


/* Location:              C:\Users\SystemX\AppData\Local\IceCubeRust\game\mods\rustmine-0.1.2.jar!\net\rustmine\RustWoundedPayload.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */
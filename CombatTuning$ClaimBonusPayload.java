/*     */ package net.rustmine.combat;
/*     */ 
/*     */ import net.minecraft.class_8710;
/*     */ import net.minecraft.class_9129;
/*     */ import net.minecraft.class_9139;
/*     */ import net.rustmine.RustmineMod;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class ClaimBonusPayload
/*     */   extends Record
/*     */   implements class_8710
/*     */ {
/*     */   private final String rewardId;
/*     */   private final int amount;
/*     */   
/*     */   public final String toString() {
/*     */     // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: <illegal opcode> toString : (Lnet/rustmine/combat/CombatTuning$ClaimBonusPayload;)Ljava/lang/String;
/*     */     //   6: areturn
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #122	-> 0
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	descriptor
/*     */     //   0	7	0	this	Lnet/rustmine/combat/CombatTuning$ClaimBonusPayload;
/*     */   }
/*     */   
/*     */   public final int hashCode() {
/*     */     // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: <illegal opcode> hashCode : (Lnet/rustmine/combat/CombatTuning$ClaimBonusPayload;)I
/*     */     //   6: ireturn
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #122	-> 0
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	descriptor
/*     */     //   0	7	0	this	Lnet/rustmine/combat/CombatTuning$ClaimBonusPayload;
/*     */   }
/*     */   
/*     */   public final boolean equals(Object o) {
/*     */     // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: aload_1
/*     */     //   2: <illegal opcode> equals : (Lnet/rustmine/combat/CombatTuning$ClaimBonusPayload;Ljava/lang/Object;)Z
/*     */     //   7: ireturn
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #122	-> 0
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	descriptor
/*     */     //   0	8	0	this	Lnet/rustmine/combat/CombatTuning$ClaimBonusPayload;
/*     */     //   0	8	1	o	Ljava/lang/Object;
/*     */   }
/*     */   
/*     */   public ClaimBonusPayload(String rewardId, int amount) {
/* 122 */     this.rewardId = rewardId; this.amount = amount; } public String rewardId() { return this.rewardId; } public int amount() { return this.amount; }
/* 123 */    public static final class_8710.class_9154<ClaimBonusPayload> TYPE = new class_8710.class_9154(RustmineMod.id("claim_bonus")); public static final class_9139<class_9129, ClaimBonusPayload> CODEC; static {
/* 124 */     CODEC = class_9139.method_56437((buf, p) -> {
/*     */           buf.method_10788(p.rewardId, 64);
/*     */           buf.method_10804(p.amount);
/*     */         }buf -> new ClaimBonusPayload(buf.method_10800(64), buf.method_10816()));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public class_8710.class_9154<? extends class_8710> method_56479() {
/* 133 */     return (class_8710.class_9154)TYPE;
/*     */   }
/*     */ }


/* Location:              C:\Users\SystemX\AppData\Local\IceCubeRust\game\mods\rustmine-0.1.2.jar!\net\rustmine\combat\CombatTuning$ClaimBonusPayload.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */
/*    */ package net.rustmine.combat;
/*    */ 
/*    */ import net.minecraft.class_8710;
/*    */ import net.minecraft.class_9129;
/*    */ import net.minecraft.class_9139;
/*    */ import net.rustmine.RustmineMod;
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
/*    */ public final class HitConfirmPayload
/*    */   extends Record
/*    */   implements class_8710
/*    */ {
/*    */   private final int targetId;
/*    */   private final float damage;
/*    */   private final boolean headshot;
/*    */   
/*    */   public final String toString() {
/*    */     // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> toString : (Lnet/rustmine/combat/CombatTuning$HitConfirmPayload;)Ljava/lang/String;
/*    */     //   6: areturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #64	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	7	0	this	Lnet/rustmine/combat/CombatTuning$HitConfirmPayload;
/*    */   }
/*    */   
/*    */   public final int hashCode() {
/*    */     // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> hashCode : (Lnet/rustmine/combat/CombatTuning$HitConfirmPayload;)I
/*    */     //   6: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #64	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	7	0	this	Lnet/rustmine/combat/CombatTuning$HitConfirmPayload;
/*    */   }
/*    */   
/*    */   public final boolean equals(Object o) {
/*    */     // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: aload_1
/*    */     //   2: <illegal opcode> equals : (Lnet/rustmine/combat/CombatTuning$HitConfirmPayload;Ljava/lang/Object;)Z
/*    */     //   7: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #64	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	8	0	this	Lnet/rustmine/combat/CombatTuning$HitConfirmPayload;
/*    */     //   0	8	1	o	Ljava/lang/Object;
/*    */   }
/*    */   
/*    */   public HitConfirmPayload(int targetId, float damage, boolean headshot) {
/* 64 */     this.targetId = targetId; this.damage = damage; this.headshot = headshot; } public int targetId() { return this.targetId; } public float damage() { return this.damage; } public boolean headshot() { return this.headshot; }
/* 65 */    public static final class_8710.class_9154<HitConfirmPayload> TYPE = new class_8710.class_9154(RustmineMod.id("hit_confirm")); public static final class_9139<class_9129, HitConfirmPayload> CODEC; static {
/* 66 */     CODEC = class_9139.method_56437((buf, p) -> {
/*    */           buf.method_10804(p.targetId);
/*    */           buf.method_52941(p.damage);
/*    */           buf.method_52964(p.headshot);
/*    */         }buf -> new HitConfirmPayload(buf.method_10816(), buf.readFloat(), buf.readBoolean()));
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public class_8710.class_9154<? extends class_8710> method_56479() {
/* 76 */     return (class_8710.class_9154)TYPE;
/*    */   }
/*    */ }


/* Location:              C:\Users\SystemX\AppData\Local\IceCubeRust\game\mods\rustmine-0.1.2.jar!\net\rustmine\combat\CombatTuning$HitConfirmPayload.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */
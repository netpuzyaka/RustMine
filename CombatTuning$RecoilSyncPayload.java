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
/*    */ public final class RecoilSyncPayload
/*    */   extends Record
/*    */   implements class_8710
/*    */ {
/*    */   private final float recoilScale;
/*    */   private final float spreadScale;
/*    */   
/*    */   public final String toString() {
/*    */     // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> toString : (Lnet/rustmine/combat/CombatTuning$RecoilSyncPayload;)Ljava/lang/String;
/*    */     //   6: areturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #80	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	7	0	this	Lnet/rustmine/combat/CombatTuning$RecoilSyncPayload;
/*    */   }
/*    */   
/*    */   public final int hashCode() {
/*    */     // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> hashCode : (Lnet/rustmine/combat/CombatTuning$RecoilSyncPayload;)I
/*    */     //   6: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #80	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	7	0	this	Lnet/rustmine/combat/CombatTuning$RecoilSyncPayload;
/*    */   }
/*    */   
/*    */   public final boolean equals(Object o) {
/*    */     // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: aload_1
/*    */     //   2: <illegal opcode> equals : (Lnet/rustmine/combat/CombatTuning$RecoilSyncPayload;Ljava/lang/Object;)Z
/*    */     //   7: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #80	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	8	0	this	Lnet/rustmine/combat/CombatTuning$RecoilSyncPayload;
/*    */     //   0	8	1	o	Ljava/lang/Object;
/*    */   }
/*    */   
/*    */   public RecoilSyncPayload(float recoilScale, float spreadScale) {
/* 80 */     this.recoilScale = recoilScale; this.spreadScale = spreadScale; } public float recoilScale() { return this.recoilScale; } public float spreadScale() { return this.spreadScale; }
/* 81 */    public static final class_8710.class_9154<RecoilSyncPayload> TYPE = new class_8710.class_9154(RustmineMod.id("recoil_sync")); public static final class_9139<class_9129, RecoilSyncPayload> CODEC; static {
/* 82 */     CODEC = class_9139.method_56437((buf, p) -> {
/*    */           buf.method_52941(p.recoilScale);
/*    */           buf.method_52941(p.spreadScale);
/*    */         }buf -> new RecoilSyncPayload(buf.readFloat(), buf.readFloat()));
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public class_8710.class_9154<? extends class_8710> method_56479() {
/* 91 */     return (class_8710.class_9154)TYPE;
/*    */   }
/*    */ }


/* Location:              C:\Users\SystemX\AppData\Local\IceCubeRust\game\mods\rustmine-0.1.2.jar!\net\rustmine\combat\CombatTuning$RecoilSyncPayload.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */
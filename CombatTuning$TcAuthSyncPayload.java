/*     */ package net.rustmine.combat;
/*     */ 
/*     */ import net.minecraft.class_2338;
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
/*     */ public final class TcAuthSyncPayload
/*     */   extends Record
/*     */   implements class_8710
/*     */ {
/*     */   private final class_2338 pos;
/*     */   private final boolean authorized;
/*     */   
/*     */   public final String toString() {
/*     */     // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: <illegal opcode> toString : (Lnet/rustmine/combat/CombatTuning$TcAuthSyncPayload;)Ljava/lang/String;
/*     */     //   6: areturn
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #95	-> 0
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	descriptor
/*     */     //   0	7	0	this	Lnet/rustmine/combat/CombatTuning$TcAuthSyncPayload;
/*     */   }
/*     */   
/*     */   public final int hashCode() {
/*     */     // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: <illegal opcode> hashCode : (Lnet/rustmine/combat/CombatTuning$TcAuthSyncPayload;)I
/*     */     //   6: ireturn
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #95	-> 0
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	descriptor
/*     */     //   0	7	0	this	Lnet/rustmine/combat/CombatTuning$TcAuthSyncPayload;
/*     */   }
/*     */   
/*     */   public final boolean equals(Object o) {
/*     */     // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: aload_1
/*     */     //   2: <illegal opcode> equals : (Lnet/rustmine/combat/CombatTuning$TcAuthSyncPayload;Ljava/lang/Object;)Z
/*     */     //   7: ireturn
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #95	-> 0
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	descriptor
/*     */     //   0	8	0	this	Lnet/rustmine/combat/CombatTuning$TcAuthSyncPayload;
/*     */     //   0	8	1	o	Ljava/lang/Object;
/*     */   }
/*     */   
/*     */   public TcAuthSyncPayload(class_2338 pos, boolean authorized) {
/*  95 */     this.pos = pos; this.authorized = authorized; } public class_2338 pos() { return this.pos; } public boolean authorized() { return this.authorized; }
/*  96 */    public static final class_8710.class_9154<TcAuthSyncPayload> TYPE = new class_8710.class_9154(RustmineMod.id("tc_auth_sync")); public static final class_9139<class_9129, TcAuthSyncPayload> CODEC; static {
/*  97 */     CODEC = class_9139.method_56437((buf, p) -> {
/*     */           buf.method_10807(p.pos);
/*     */           buf.method_52964(p.authorized);
/*     */         }buf -> new TcAuthSyncPayload(buf.method_10811(), buf.readBoolean()));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public class_8710.class_9154<? extends class_8710> method_56479() {
/* 106 */     return (class_8710.class_9154)TYPE;
/*     */   }
/*     */ }


/* Location:              C:\Users\SystemX\AppData\Local\IceCubeRust\game\mods\rustmine-0.1.2.jar!\net\rustmine\combat\CombatTuning$TcAuthSyncPayload.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */
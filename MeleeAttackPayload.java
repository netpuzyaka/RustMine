/*    */ package net.rustmine;
/*    */ 
/*    */ import net.minecraft.class_2540;
/*    */ 
/*    */ public final class MeleeAttackPayload extends Record implements class_8710 {
/*    */   private final class_243 dir;
/*    */   
/*  8 */   public MeleeAttackPayload(class_243 dir) { this.dir = dir; } public final String toString() { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> toString : (Lnet/rustmine/MeleeAttackPayload;)Ljava/lang/String;
/*    */     //   6: areturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #8	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*  8 */     //   0	7	0	this	Lnet/rustmine/MeleeAttackPayload; } public class_243 dir() { return this.dir; }
/*    */   public final int hashCode() { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> hashCode : (Lnet/rustmine/MeleeAttackPayload;)I
/*    */     //   6: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #8	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	7	0	this	Lnet/rustmine/MeleeAttackPayload; } public final boolean equals(Object o) { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: aload_1
/*    */     //   2: <illegal opcode> equals : (Lnet/rustmine/MeleeAttackPayload;Ljava/lang/Object;)Z
/*    */     //   7: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #8	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	8	0	this	Lnet/rustmine/MeleeAttackPayload;
/*  9 */     //   0	8	1	o	Ljava/lang/Object; } public static final class_8710.class_9154<MeleeAttackPayload> TYPE = new class_8710.class_9154(RustmineMod.id("melee_attack")); public static final class_9139<class_2540, MeleeAttackPayload> CODEC; static {
/* 10 */     CODEC = class_9139.method_56438((payload, buf) -> {
/*    */           buf.method_52940((payload.dir()).field_1352);
/*    */           buf.method_52940((payload.dir()).field_1351);
/*    */           buf.method_52940((payload.dir()).field_1350);
/*    */         }buf -> new MeleeAttackPayload(new class_243(buf.readDouble(), buf.readDouble(), buf.readDouble())));
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public class_8710.class_9154<? extends class_8710> method_56479() {
/* 21 */     return (class_8710.class_9154)TYPE;
/*    */   }
/*    */ }


/* Location:              C:\Users\SystemX\AppData\Local\IceCubeRust\game\mods\rustmine-0.1.2.jar!\net\rustmine\MeleeAttackPayload.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */
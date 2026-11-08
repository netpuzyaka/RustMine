/*    */ package net.rustmine.anticheat;
/*    */ 
/*    */ import net.minecraft.class_8710;
/*    */ import net.minecraft.class_9129;
/*    */ import net.minecraft.class_9139;
/*    */ import net.rustmine.RustmineMod;
/*    */ 
/*    */ 
/*    */ public final class Signatures
/*    */   extends Record
/*    */   implements class_8710
/*    */ {
/*    */   private final String json;
/*    */   
/*    */   public final String toString() {
/*    */     // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> toString : (Lnet/rustmine/anticheat/AcPayloads$Signatures;)Ljava/lang/String;
/*    */     //   6: areturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #20	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	7	0	this	Lnet/rustmine/anticheat/AcPayloads$Signatures;
/*    */   }
/*    */   
/*    */   public Signatures(String json) {
/* 20 */     this.json = json; } public final int hashCode() { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> hashCode : (Lnet/rustmine/anticheat/AcPayloads$Signatures;)I
/*    */     //   6: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #20	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	7	0	this	Lnet/rustmine/anticheat/AcPayloads$Signatures; } public final boolean equals(Object o) { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: aload_1
/*    */     //   2: <illegal opcode> equals : (Lnet/rustmine/anticheat/AcPayloads$Signatures;Ljava/lang/Object;)Z
/*    */     //   7: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #20	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	8	0	this	Lnet/rustmine/anticheat/AcPayloads$Signatures;
/* 20 */     //   0	8	1	o	Ljava/lang/Object; } public String json() { return this.json; }
/* 21 */    public static final class_8710.class_9154<Signatures> TYPE = new class_8710.class_9154(RustmineMod.id("ac_sig")); public static final class_9139<class_9129, Signatures> CODEC; static {
/* 22 */     CODEC = class_9139.method_56437((buf, p) -> buf.method_10788(p.json, 262144), buf -> new Signatures(buf.method_10800(262144)));
/*    */   }
/*    */ 
/*    */   
/*    */   public class_8710.class_9154<? extends class_8710> method_56479() {
/* 27 */     return (class_8710.class_9154)TYPE;
/*    */   }
/*    */ }


/* Location:              C:\Users\SystemX\AppData\Local\IceCubeRust\game\mods\rustmine-0.1.2.jar!\net\rustmine\anticheat\AcPayloads$Signatures.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */
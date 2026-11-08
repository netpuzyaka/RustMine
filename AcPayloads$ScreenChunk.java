/*    */ package net.rustmine.anticheat;
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
/*    */ public final class ScreenChunk
/*    */   extends Record
/*    */   implements class_8710
/*    */ {
/*    */   private final int id;
/*    */   private final int index;
/*    */   private final int total;
/*    */   private final byte[] data;
/*    */   public static final int MAX_CHUNK = 30000;
/*    */   public static final int MAX_CHUNKS = 96;
/*    */   
/*    */   public final String toString() {
/*    */     // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> toString : (Lnet/rustmine/anticheat/AcPayloads$ScreenChunk;)Ljava/lang/String;
/*    */     //   6: areturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #82	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	7	0	this	Lnet/rustmine/anticheat/AcPayloads$ScreenChunk;
/*    */   }
/*    */   
/*    */   public final int hashCode() {
/*    */     // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> hashCode : (Lnet/rustmine/anticheat/AcPayloads$ScreenChunk;)I
/*    */     //   6: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #82	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	7	0	this	Lnet/rustmine/anticheat/AcPayloads$ScreenChunk;
/*    */   }
/*    */   
/*    */   public final boolean equals(Object o) {
/*    */     // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: aload_1
/*    */     //   2: <illegal opcode> equals : (Lnet/rustmine/anticheat/AcPayloads$ScreenChunk;Ljava/lang/Object;)Z
/*    */     //   7: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #82	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	8	0	this	Lnet/rustmine/anticheat/AcPayloads$ScreenChunk;
/*    */     //   0	8	1	o	Ljava/lang/Object;
/*    */   }
/*    */   
/*    */   public ScreenChunk(int id, int index, int total, byte[] data) {
/* 82 */     this.id = id; this.index = index; this.total = total; this.data = data; } public int id() { return this.id; } public int index() { return this.index; } public int total() { return this.total; } public byte[] data() { return this.data; }
/*    */   
/* 84 */   public static final class_8710.class_9154<ScreenChunk> TYPE = new class_8710.class_9154(RustmineMod.id("ac_screen_part")); public static final class_9139<class_9129, ScreenChunk> CODEC; static {
/* 85 */     CODEC = class_9139.method_56437((buf, p) -> {
/*    */           buf.method_53002(p.id);
/*    */           buf.method_10804(p.index);
/*    */           buf.method_10804(p.total);
/*    */           buf.method_10813(p.data);
/*    */         }buf -> new ScreenChunk(buf.readInt(), buf.method_10816(), buf.method_10816(), buf.method_10803(30000)));
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public class_8710.class_9154<? extends class_8710> method_56479() {
/* 96 */     return (class_8710.class_9154)TYPE;
/*    */   }
/*    */ }


/* Location:              C:\Users\SystemX\AppData\Local\IceCubeRust\game\mods\rustmine-0.1.2.jar!\net\rustmine\anticheat\AcPayloads$ScreenChunk.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */
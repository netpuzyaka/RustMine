/*    */ package net.rustmine.anticheat;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
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
/*    */ public final class Report
/*    */   extends Record
/*    */   implements class_8710
/*    */ {
/*    */   private final int nonce;
/*    */   private final List<String> hits;
/*    */   public static final int MAX_HITS = 64;
/*    */   
/*    */   public final String toString() {
/*    */     // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> toString : (Lnet/rustmine/anticheat/AcPayloads$Report;)Ljava/lang/String;
/*    */     //   6: areturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #44	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	7	0	this	Lnet/rustmine/anticheat/AcPayloads$Report;
/*    */   }
/*    */   
/*    */   public final int hashCode() {
/*    */     // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> hashCode : (Lnet/rustmine/anticheat/AcPayloads$Report;)I
/*    */     //   6: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #44	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	7	0	this	Lnet/rustmine/anticheat/AcPayloads$Report;
/*    */   }
/*    */   
/*    */   public final boolean equals(Object o) {
/*    */     // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: aload_1
/*    */     //   2: <illegal opcode> equals : (Lnet/rustmine/anticheat/AcPayloads$Report;Ljava/lang/Object;)Z
/*    */     //   7: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #44	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	8	0	this	Lnet/rustmine/anticheat/AcPayloads$Report;
/*    */     //   0	8	1	o	Ljava/lang/Object;
/*    */   }
/*    */   
/*    */   public Report(int nonce, List<String> hits) {
/* 44 */     this.nonce = nonce; this.hits = hits; } public int nonce() { return this.nonce; } public List<String> hits() { return this.hits; }
/*    */   
/* 46 */   public static final class_8710.class_9154<Report> TYPE = new class_8710.class_9154(RustmineMod.id("ac_report")); public static final class_9139<class_9129, Report> CODEC; static {
/* 47 */     CODEC = class_9139.method_56437((buf, p) -> {
/*    */           buf.method_53002(p.nonce);
/*    */           int n = Math.min(64, p.hits.size());
/*    */           buf.method_10804(n);
/*    */           for (int i = 0; i < n; i++)
/*    */             buf.method_10788(p.hits.get(i), 256); 
/*    */         }buf -> {
/*    */           int nonce = buf.readInt();
/*    */           int n = buf.method_10816();
/*    */           if (n < 0 || n > 64)
/*    */             throw new IllegalArgumentException("hits"); 
/*    */           List<String> hits = new ArrayList<>(n);
/*    */           for (int i = 0; i < n; i++)
/*    */             hits.add(buf.method_10800(256)); 
/*    */           return new Report(nonce, hits);
/*    */         });
/*    */   }
/*    */   public class_8710.class_9154<? extends class_8710> method_56479() {
/* 65 */     return (class_8710.class_9154)TYPE;
/*    */   }
/*    */ }


/* Location:              C:\Users\SystemX\AppData\Local\IceCubeRust\game\mods\rustmine-0.1.2.jar!\net\rustmine\anticheat\AcPayloads$Report.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */
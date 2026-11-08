/*     */ package net.rustmine.anticheat;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry;
/*     */ import net.minecraft.class_8710;
/*     */ import net.minecraft.class_9129;
/*     */ import net.minecraft.class_9139;
/*     */ import net.rustmine.RustmineMod;
/*     */ 
/*     */ public final class AcPayloads
/*     */ {
/*     */   public static final class Signatures
/*     */     extends Record
/*     */     implements class_8710
/*     */   {
/*     */     private final String json;
/*     */     
/*     */     public Signatures(String json) {
/*  20 */       this.json = json; } public final String toString() { // Byte code:
/*     */       //   0: aload_0
/*     */       //   1: <illegal opcode> toString : (Lnet/rustmine/anticheat/AcPayloads$Signatures;)Ljava/lang/String;
/*     */       //   6: areturn
/*     */       // Line number table:
/*     */       //   Java source line number -> byte code offset
/*     */       //   #20	-> 0
/*     */       // Local variable table:
/*     */       //   start	length	slot	name	descriptor
/*     */       //   0	7	0	this	Lnet/rustmine/anticheat/AcPayloads$Signatures; } public final int hashCode() { // Byte code:
/*     */       //   0: aload_0
/*     */       //   1: <illegal opcode> hashCode : (Lnet/rustmine/anticheat/AcPayloads$Signatures;)I
/*     */       //   6: ireturn
/*     */       // Line number table:
/*     */       //   Java source line number -> byte code offset
/*     */       //   #20	-> 0
/*     */       // Local variable table:
/*     */       //   start	length	slot	name	descriptor
/*     */       //   0	7	0	this	Lnet/rustmine/anticheat/AcPayloads$Signatures; } public final boolean equals(Object o) { // Byte code:
/*     */       //   0: aload_0
/*     */       //   1: aload_1
/*     */       //   2: <illegal opcode> equals : (Lnet/rustmine/anticheat/AcPayloads$Signatures;Ljava/lang/Object;)Z
/*     */       //   7: ireturn
/*     */       // Line number table:
/*     */       //   Java source line number -> byte code offset
/*     */       //   #20	-> 0
/*     */       // Local variable table:
/*     */       //   start	length	slot	name	descriptor
/*     */       //   0	8	0	this	Lnet/rustmine/anticheat/AcPayloads$Signatures;
/*  20 */       //   0	8	1	o	Ljava/lang/Object; } public String json() { return this.json; }
/*  21 */      public static final class_8710.class_9154<Signatures> TYPE = new class_8710.class_9154(RustmineMod.id("ac_sig")); public static final class_9139<class_9129, Signatures> CODEC; static {
/*  22 */       CODEC = class_9139.method_56437((buf, p) -> buf.method_10788(p.json, 262144), buf -> new Signatures(buf.method_10800(262144)));
/*     */     }
/*     */ 
/*     */     
/*     */     public class_8710.class_9154<? extends class_8710> method_56479() {
/*  27 */       return (class_8710.class_9154)TYPE;
/*     */     } }
/*     */   
/*     */   public static final class ScanRequest extends Record implements class_8710 { private final int nonce;
/*     */     
/*  32 */     public ScanRequest(int nonce) { this.nonce = nonce; } public final String toString() { // Byte code:
/*     */       //   0: aload_0
/*     */       //   1: <illegal opcode> toString : (Lnet/rustmine/anticheat/AcPayloads$ScanRequest;)Ljava/lang/String;
/*     */       //   6: areturn
/*     */       // Line number table:
/*     */       //   Java source line number -> byte code offset
/*     */       //   #32	-> 0
/*     */       // Local variable table:
/*     */       //   start	length	slot	name	descriptor
/*  32 */       //   0	7	0	this	Lnet/rustmine/anticheat/AcPayloads$ScanRequest; } public int nonce() { return this.nonce; } public final int hashCode() { // Byte code:
/*     */       //   0: aload_0
/*     */       //   1: <illegal opcode> hashCode : (Lnet/rustmine/anticheat/AcPayloads$ScanRequest;)I
/*     */       //   6: ireturn
/*     */       // Line number table:
/*     */       //   Java source line number -> byte code offset
/*     */       //   #32	-> 0
/*     */       // Local variable table:
/*     */       //   start	length	slot	name	descriptor
/*     */       //   0	7	0	this	Lnet/rustmine/anticheat/AcPayloads$ScanRequest; } public final boolean equals(Object o) { // Byte code:
/*     */       //   0: aload_0
/*     */       //   1: aload_1
/*     */       //   2: <illegal opcode> equals : (Lnet/rustmine/anticheat/AcPayloads$ScanRequest;Ljava/lang/Object;)Z
/*     */       //   7: ireturn
/*     */       // Line number table:
/*     */       //   Java source line number -> byte code offset
/*     */       //   #32	-> 0
/*     */       // Local variable table:
/*     */       //   start	length	slot	name	descriptor
/*     */       //   0	8	0	this	Lnet/rustmine/anticheat/AcPayloads$ScanRequest;
/*     */       //   0	8	1	o	Ljava/lang/Object; }
/*  33 */     public static final class_8710.class_9154<ScanRequest> TYPE = new class_8710.class_9154(RustmineMod.id("ac_scan")); public static final class_9139<class_9129, ScanRequest> CODEC; static {
/*  34 */       CODEC = class_9139.method_56437((buf, p) -> buf.method_53002(p.nonce), buf -> new ScanRequest(buf.readInt()));
/*     */     }
/*     */ 
/*     */     
/*     */     public class_8710.class_9154<? extends class_8710> method_56479() {
/*  39 */       return (class_8710.class_9154)TYPE;
/*     */     } }
/*     */   public static final class Report extends Record implements class_8710 { private final int nonce; private final List<String> hits;
/*     */     public static final int MAX_HITS = 64;
/*     */     
/*  44 */     public Report(int nonce, List<String> hits) { this.nonce = nonce; this.hits = hits; } public final String toString() { // Byte code:
/*     */       //   0: aload_0
/*     */       //   1: <illegal opcode> toString : (Lnet/rustmine/anticheat/AcPayloads$Report;)Ljava/lang/String;
/*     */       //   6: areturn
/*     */       // Line number table:
/*     */       //   Java source line number -> byte code offset
/*     */       //   #44	-> 0
/*     */       // Local variable table:
/*     */       //   start	length	slot	name	descriptor
/*  44 */       //   0	7	0	this	Lnet/rustmine/anticheat/AcPayloads$Report; } public int nonce() { return this.nonce; } public final int hashCode() { // Byte code:
/*     */       //   0: aload_0
/*     */       //   1: <illegal opcode> hashCode : (Lnet/rustmine/anticheat/AcPayloads$Report;)I
/*     */       //   6: ireturn
/*     */       // Line number table:
/*     */       //   Java source line number -> byte code offset
/*     */       //   #44	-> 0
/*     */       // Local variable table:
/*     */       //   start	length	slot	name	descriptor
/*     */       //   0	7	0	this	Lnet/rustmine/anticheat/AcPayloads$Report; } public final boolean equals(Object o) { // Byte code:
/*     */       //   0: aload_0
/*     */       //   1: aload_1
/*     */       //   2: <illegal opcode> equals : (Lnet/rustmine/anticheat/AcPayloads$Report;Ljava/lang/Object;)Z
/*     */       //   7: ireturn
/*     */       // Line number table:
/*     */       //   Java source line number -> byte code offset
/*     */       //   #44	-> 0
/*     */       // Local variable table:
/*     */       //   start	length	slot	name	descriptor
/*     */       //   0	8	0	this	Lnet/rustmine/anticheat/AcPayloads$Report;
/*  44 */       //   0	8	1	o	Ljava/lang/Object; } public List<String> hits() { return this.hits; }
/*     */     
/*  46 */     public static final class_8710.class_9154<Report> TYPE = new class_8710.class_9154(RustmineMod.id("ac_report")); public static final class_9139<class_9129, Report> CODEC; static {
/*  47 */       CODEC = class_9139.method_56437((buf, p) -> {
/*     */             buf.method_53002(p.nonce);
/*     */             int n = Math.min(64, p.hits.size());
/*     */             buf.method_10804(n);
/*     */             for (int i = 0; i < n; i++)
/*     */               buf.method_10788(p.hits.get(i), 256); 
/*     */           }buf -> {
/*     */             int nonce = buf.readInt();
/*     */             int n = buf.method_10816();
/*     */             if (n < 0 || n > 64)
/*     */               throw new IllegalArgumentException("hits"); 
/*     */             List<String> hits = new ArrayList<>(n);
/*     */             for (int i = 0; i < n; i++)
/*     */               hits.add(buf.method_10800(256)); 
/*     */             return new Report(nonce, hits);
/*     */           });
/*     */     }
/*     */     public class_8710.class_9154<? extends class_8710> method_56479() {
/*  65 */       return (class_8710.class_9154)TYPE;
/*     */     } }
/*     */   
/*     */   public static final class ScreenRequest extends Record implements class_8710 { private final int id;
/*     */     
/*  70 */     public ScreenRequest(int id) { this.id = id; } public final String toString() { // Byte code:
/*     */       //   0: aload_0
/*     */       //   1: <illegal opcode> toString : (Lnet/rustmine/anticheat/AcPayloads$ScreenRequest;)Ljava/lang/String;
/*     */       //   6: areturn
/*     */       // Line number table:
/*     */       //   Java source line number -> byte code offset
/*     */       //   #70	-> 0
/*     */       // Local variable table:
/*     */       //   start	length	slot	name	descriptor
/*     */       //   0	7	0	this	Lnet/rustmine/anticheat/AcPayloads$ScreenRequest; } public final int hashCode() { // Byte code:
/*     */       //   0: aload_0
/*     */       //   1: <illegal opcode> hashCode : (Lnet/rustmine/anticheat/AcPayloads$ScreenRequest;)I
/*     */       //   6: ireturn
/*     */       // Line number table:
/*     */       //   Java source line number -> byte code offset
/*     */       //   #70	-> 0
/*     */       // Local variable table:
/*     */       //   start	length	slot	name	descriptor
/*     */       //   0	7	0	this	Lnet/rustmine/anticheat/AcPayloads$ScreenRequest; } public final boolean equals(Object o) { // Byte code:
/*     */       //   0: aload_0
/*     */       //   1: aload_1
/*     */       //   2: <illegal opcode> equals : (Lnet/rustmine/anticheat/AcPayloads$ScreenRequest;Ljava/lang/Object;)Z
/*     */       //   7: ireturn
/*     */       // Line number table:
/*     */       //   Java source line number -> byte code offset
/*     */       //   #70	-> 0
/*     */       // Local variable table:
/*     */       //   start	length	slot	name	descriptor
/*     */       //   0	8	0	this	Lnet/rustmine/anticheat/AcPayloads$ScreenRequest;
/*  70 */       //   0	8	1	o	Ljava/lang/Object; } public int id() { return this.id; }
/*  71 */      public static final class_8710.class_9154<ScreenRequest> TYPE = new class_8710.class_9154(RustmineMod.id("ac_screen")); public static final class_9139<class_9129, ScreenRequest> CODEC; static {
/*  72 */       CODEC = class_9139.method_56437((buf, p) -> buf.method_53002(p.id), buf -> new ScreenRequest(buf.readInt()));
/*     */     }
/*     */ 
/*     */     
/*     */     public class_8710.class_9154<? extends class_8710> method_56479() {
/*  77 */       return (class_8710.class_9154)TYPE;
/*     */     } }
/*     */   public static final class ScreenChunk extends Record implements class_8710 { private final int id; private final int index; private final int total; private final byte[] data; public static final int MAX_CHUNK = 30000;
/*     */     public static final int MAX_CHUNKS = 96;
/*     */     
/*  82 */     public ScreenChunk(int id, int index, int total, byte[] data) { this.id = id; this.index = index; this.total = total; this.data = data; } public final String toString() { // Byte code:
/*     */       //   0: aload_0
/*     */       //   1: <illegal opcode> toString : (Lnet/rustmine/anticheat/AcPayloads$ScreenChunk;)Ljava/lang/String;
/*     */       //   6: areturn
/*     */       // Line number table:
/*     */       //   Java source line number -> byte code offset
/*     */       //   #82	-> 0
/*     */       // Local variable table:
/*     */       //   start	length	slot	name	descriptor
/*     */       //   0	7	0	this	Lnet/rustmine/anticheat/AcPayloads$ScreenChunk; } public final int hashCode() { // Byte code:
/*     */       //   0: aload_0
/*     */       //   1: <illegal opcode> hashCode : (Lnet/rustmine/anticheat/AcPayloads$ScreenChunk;)I
/*     */       //   6: ireturn
/*     */       // Line number table:
/*     */       //   Java source line number -> byte code offset
/*     */       //   #82	-> 0
/*     */       // Local variable table:
/*     */       //   start	length	slot	name	descriptor
/*     */       //   0	7	0	this	Lnet/rustmine/anticheat/AcPayloads$ScreenChunk; } public final boolean equals(Object o) { // Byte code:
/*     */       //   0: aload_0
/*     */       //   1: aload_1
/*     */       //   2: <illegal opcode> equals : (Lnet/rustmine/anticheat/AcPayloads$ScreenChunk;Ljava/lang/Object;)Z
/*     */       //   7: ireturn
/*     */       // Line number table:
/*     */       //   Java source line number -> byte code offset
/*     */       //   #82	-> 0
/*     */       // Local variable table:
/*     */       //   start	length	slot	name	descriptor
/*     */       //   0	8	0	this	Lnet/rustmine/anticheat/AcPayloads$ScreenChunk;
/*  82 */       //   0	8	1	o	Ljava/lang/Object; } public int id() { return this.id; } public int index() { return this.index; } public int total() { return this.total; } public byte[] data() { return this.data; }
/*     */     
/*  84 */     public static final class_8710.class_9154<ScreenChunk> TYPE = new class_8710.class_9154(RustmineMod.id("ac_screen_part")); public static final class_9139<class_9129, ScreenChunk> CODEC; static {
/*  85 */       CODEC = class_9139.method_56437((buf, p) -> {
/*     */             buf.method_53002(p.id);
/*     */             buf.method_10804(p.index);
/*     */             buf.method_10804(p.total);
/*     */             buf.method_10813(p.data);
/*     */           }buf -> new ScreenChunk(buf.readInt(), buf.method_10816(), buf.method_10816(), buf.method_10803(30000)));
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public class_8710.class_9154<? extends class_8710> method_56479() {
/*  96 */       return (class_8710.class_9154)TYPE;
/*     */     } }
/*     */   
/*     */   public static final class DevCommand extends Record implements class_8710 { private final String command;
/*     */     
/* 101 */     public DevCommand(String command) { this.command = command; } public final String toString() { // Byte code:
/*     */       //   0: aload_0
/*     */       //   1: <illegal opcode> toString : (Lnet/rustmine/anticheat/AcPayloads$DevCommand;)Ljava/lang/String;
/*     */       //   6: areturn
/*     */       // Line number table:
/*     */       //   Java source line number -> byte code offset
/*     */       //   #101	-> 0
/*     */       // Local variable table:
/*     */       //   start	length	slot	name	descriptor
/*     */       //   0	7	0	this	Lnet/rustmine/anticheat/AcPayloads$DevCommand; } public final int hashCode() { // Byte code:
/*     */       //   0: aload_0
/*     */       //   1: <illegal opcode> hashCode : (Lnet/rustmine/anticheat/AcPayloads$DevCommand;)I
/*     */       //   6: ireturn
/*     */       // Line number table:
/*     */       //   Java source line number -> byte code offset
/*     */       //   #101	-> 0
/*     */       // Local variable table:
/*     */       //   start	length	slot	name	descriptor
/*     */       //   0	7	0	this	Lnet/rustmine/anticheat/AcPayloads$DevCommand; } public final boolean equals(Object o) { // Byte code:
/*     */       //   0: aload_0
/*     */       //   1: aload_1
/*     */       //   2: <illegal opcode> equals : (Lnet/rustmine/anticheat/AcPayloads$DevCommand;Ljava/lang/Object;)Z
/*     */       //   7: ireturn
/*     */       // Line number table:
/*     */       //   Java source line number -> byte code offset
/*     */       //   #101	-> 0
/*     */       // Local variable table:
/*     */       //   start	length	slot	name	descriptor
/*     */       //   0	8	0	this	Lnet/rustmine/anticheat/AcPayloads$DevCommand;
/* 101 */       //   0	8	1	o	Ljava/lang/Object; } public String command() { return this.command; }
/* 102 */      public static final class_8710.class_9154<DevCommand> TYPE = new class_8710.class_9154(RustmineMod.id("dev_command")); public static final class_9139<class_9129, DevCommand> CODEC; static {
/* 103 */       CODEC = class_9139.method_56437((buf, p) -> buf.method_10788(p.command, 256), buf -> new DevCommand(buf.method_10800(256)));
/*     */     }
/*     */ 
/*     */     
/*     */     public class_8710.class_9154<? extends class_8710> method_56479() {
/* 108 */       return (class_8710.class_9154)TYPE;
/*     */     } }
/*     */ 
/*     */   
/*     */   public static void register() {
/* 113 */     PayloadTypeRegistry.playS2C().register(Signatures.TYPE, Signatures.CODEC);
/* 114 */     PayloadTypeRegistry.playS2C().register(ScanRequest.TYPE, ScanRequest.CODEC);
/* 115 */     PayloadTypeRegistry.playC2S().register(Report.TYPE, Report.CODEC);
/* 116 */     PayloadTypeRegistry.playS2C().register(ScreenRequest.TYPE, ScreenRequest.CODEC);
/* 117 */     PayloadTypeRegistry.playC2S().register(ScreenChunk.TYPE, ScreenChunk.CODEC);
/* 118 */     PayloadTypeRegistry.playC2S().register(DevCommand.TYPE, DevCommand.CODEC);
/*     */   }
/*     */ }


/* Location:              C:\Users\SystemX\AppData\Local\IceCubeRust\game\mods\rustmine-0.1.2.jar!\net\rustmine\anticheat\AcPayloads.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */
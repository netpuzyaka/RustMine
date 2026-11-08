/*    */ package net.rustmine;
/*    */ 
/*    */ import net.minecraft.class_243;
/*    */ import net.minecraft.class_3222;
/*    */ import net.minecraft.class_8710;
/*    */ import net.minecraft.class_9129;
/*    */ 
/*    */ public final class FxPayload extends Record implements class_8710 {
/*    */   private final String effect;
/*    */   private final class_243 pos;
/*    */   private final class_243 dir;
/*    */   private final int entity;
/*    */   
/* 14 */   public FxPayload(String effect, class_243 pos, class_243 dir, int entity) { this.effect = effect; this.pos = pos; this.dir = dir; this.entity = entity; } public final String toString() { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> toString : (Lnet/rustmine/FxPayload;)Ljava/lang/String;
/*    */     //   6: areturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #14	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/* 14 */     //   0	7	0	this	Lnet/rustmine/FxPayload; } public String effect() { return this.effect; } public final int hashCode() { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> hashCode : (Lnet/rustmine/FxPayload;)I
/*    */     //   6: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #14	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	7	0	this	Lnet/rustmine/FxPayload; } public final boolean equals(Object o) { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: aload_1
/*    */     //   2: <illegal opcode> equals : (Lnet/rustmine/FxPayload;Ljava/lang/Object;)Z
/*    */     //   7: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #14	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	8	0	this	Lnet/rustmine/FxPayload;
/* 14 */     //   0	8	1	o	Ljava/lang/Object; } public class_243 pos() { return this.pos; } public class_243 dir() { return this.dir; } public int entity() { return this.entity; }
/* 15 */    public static final class_8710.class_9154<FxPayload> TYPE = new class_8710.class_9154(RustmineMod.id("fx")); public static final class_9139<class_9129, FxPayload> CODEC; static {
/* 16 */     CODEC = class_9139.method_56437((buf, p) -> {
/*    */           class_9135.field_48554.encode(buf, p.effect);
/*    */           buf.method_52955(p.pos);
/*    */           buf.method_52955(p.dir);
/*    */           buf.method_10804(p.entity + 1);
/*    */         }buf -> new FxPayload((String)class_9135.field_48554.decode(buf), buf.method_52996(), buf.method_52996(), buf.method_10816() - 1));
/*    */   }
/*    */ 
/*    */   
/*    */   public static void send(class_3218 level, String effect, class_243 pos, class_243 dir, int entity) {
/* 26 */     FxPayload p = new FxPayload(effect, pos, dir, entity);
/* 27 */     for (class_3222 player : PlayerLookup.around(level, pos, 96.0D)) ServerPlayNetworking.send(player, p); 
/*    */   }
/*    */   
/*    */   public static void sendExcept(class_3218 level, class_3222 except, String effect, class_243 pos, class_243 dir) {
/* 31 */     FxPayload p = new FxPayload(effect, pos, dir, -1);
/* 32 */     for (class_3222 player : PlayerLookup.around(level, pos, 96.0D)) { if (player != except) ServerPlayNetworking.send(player, p);  }
/*    */   
/*    */   }
/*    */   
/*    */   public class_8710.class_9154<? extends class_8710> method_56479() {
/* 37 */     return (class_8710.class_9154)TYPE;
/*    */   }
/*    */ }


/* Location:              C:\Users\SystemX\AppData\Local\IceCubeRust\game\mods\rustmine-0.1.2.jar!\net\rustmine\FxPayload.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */
/*    */ package net.rustmine;
/*    */ 
/*    */ import net.minecraft.class_9129;
/*    */ 
/*    */ public final class ItemPickupPayload extends Record implements class_8710 {
/*    */   private final int entityId;
/*    */   
/*  8 */   public ItemPickupPayload(int entityId) { this.entityId = entityId; } public final String toString() { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> toString : (Lnet/rustmine/ItemPickupPayload;)Ljava/lang/String;
/*    */     //   6: areturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #8	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*  8 */     //   0	7	0	this	Lnet/rustmine/ItemPickupPayload; } public int entityId() { return this.entityId; }
/*    */   public final int hashCode() { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> hashCode : (Lnet/rustmine/ItemPickupPayload;)I
/*    */     //   6: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #8	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	7	0	this	Lnet/rustmine/ItemPickupPayload; } public final boolean equals(Object o) { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: aload_1
/*    */     //   2: <illegal opcode> equals : (Lnet/rustmine/ItemPickupPayload;Ljava/lang/Object;)Z
/*    */     //   7: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #8	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	8	0	this	Lnet/rustmine/ItemPickupPayload;
/*  9 */     //   0	8	1	o	Ljava/lang/Object; } public static final class_8710.class_9154<ItemPickupPayload> TYPE = new class_8710.class_9154(
/* 10 */       RustmineMod.id("item_pickup")); public static final class_9139<class_9129, ItemPickupPayload> CODEC;
/*    */   static {
/* 12 */     CODEC = class_9139.method_56437((buf, p) -> buf.method_53002(p.entityId), buf -> new ItemPickupPayload(buf.readInt()));
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public class_8710.class_9154<? extends class_8710> method_56479() {
/* 19 */     return (class_8710.class_9154)TYPE;
/*    */   }
/*    */ }


/* Location:              C:\Users\SystemX\AppData\Local\IceCubeRust\game\mods\rustmine-0.1.2.jar!\net\rustmine\ItemPickupPayload.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */
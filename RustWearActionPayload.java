/*    */ package net.rustmine;public final class RustWearActionPayload extends Record implements class_8710 { private final int action; private final int slotIndex; private final int targetSlot; public static final int ACTION_SWAP = 0;
/*    */   public static final int ACTION_TAKE = 1;
/*    */   public static final int ACTION_QUICK_UNEQUIP = 2;
/*    */   public static final int ACTION_QUICK_EQUIP = 3;
/*    */   public static final int ACTION_DROP = 4;
/*    */   public static final int ACTION_MOVE_TO_SLOT = 5;
/*    */   public static final int ACTION_SWAP_WEAR = 6;
/*    */   public static final int ACTION_EQUIP_TO_SLOT = 7;
/*    */   
/* 10 */   public RustWearActionPayload(int action, int slotIndex, int targetSlot) { this.action = action; this.slotIndex = slotIndex; this.targetSlot = targetSlot; } public final String toString() { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> toString : (Lnet/rustmine/RustWearActionPayload;)Ljava/lang/String;
/*    */     //   6: areturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #10	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/* 10 */     //   0	7	0	this	Lnet/rustmine/RustWearActionPayload; } public int action() { return this.action; } public final int hashCode() { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> hashCode : (Lnet/rustmine/RustWearActionPayload;)I
/*    */     //   6: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #10	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	7	0	this	Lnet/rustmine/RustWearActionPayload; } public final boolean equals(Object o) { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: aload_1
/*    */     //   2: <illegal opcode> equals : (Lnet/rustmine/RustWearActionPayload;Ljava/lang/Object;)Z
/*    */     //   7: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #10	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	8	0	this	Lnet/rustmine/RustWearActionPayload;
/* 10 */     //   0	8	1	o	Ljava/lang/Object; } public int slotIndex() { return this.slotIndex; } public int targetSlot() { return this.targetSlot; }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public RustWearActionPayload(int action, int slotIndex) {
/* 21 */     this(action, slotIndex, -1);
/*    */   }
/*    */   
/* 24 */   public static final class_8710.class_9154<RustWearActionPayload> TYPE = new class_8710.class_9154(RustmineMod.id("wear_action")); public static final class_9139<class_9129, RustWearActionPayload> CODEC;
/*    */   static {
/* 26 */     CODEC = class_9139.method_56437((buf, p) -> {
/*    */           buf.method_53002(p.action);
/*    */           buf.method_53002(p.slotIndex);
/*    */           buf.method_53002(p.targetSlot);
/*    */         }buf -> new RustWearActionPayload(buf.readInt(), buf.readInt(), buf.readInt()));
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public class_8710.class_9154<? extends class_8710> method_56479() {
/* 37 */     return (class_8710.class_9154)TYPE;
/*    */   } }


/* Location:              C:\Users\SystemX\AppData\Local\IceCubeRust\game\mods\rustmine-0.1.2.jar!\net\rustmine\RustWearActionPayload.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */
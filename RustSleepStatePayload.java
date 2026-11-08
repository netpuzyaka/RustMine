/*    */ package net.rustmine;
/*    */ public final class RustSleepStatePayload extends Record implements class_8710 { private final int entityId; private final boolean isSleeping;
/*    */   public final String toString() {
/*    */     // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> toString : (Lnet/rustmine/RustSleepStatePayload;)Ljava/lang/String;
/*    */     //   6: areturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #11	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	7	0	this	Lnet/rustmine/RustSleepStatePayload;
/*    */   }
/*    */   
/*    */   public final int hashCode() {
/*    */     // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> hashCode : (Lnet/rustmine/RustSleepStatePayload;)I
/*    */     //   6: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #11	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	7	0	this	Lnet/rustmine/RustSleepStatePayload;
/*    */   }
/*    */   
/* 11 */   public RustSleepStatePayload(int entityId, boolean isSleeping) { this.entityId = entityId; this.isSleeping = isSleeping; } public final boolean equals(Object o) { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: aload_1
/*    */     //   2: <illegal opcode> equals : (Lnet/rustmine/RustSleepStatePayload;Ljava/lang/Object;)Z
/*    */     //   7: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #11	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	8	0	this	Lnet/rustmine/RustSleepStatePayload;
/* 11 */     //   0	8	1	o	Ljava/lang/Object; } public int entityId() { return this.entityId; } public boolean isSleeping() { return this.isSleeping; }
/* 12 */    public static final class_8710.class_9154<RustSleepStatePayload> TYPE = new class_8710.class_9154(RustmineMod.id("sleep_state"));
/* 13 */   public static final class_9139<class_9129, RustSleepStatePayload> CODEC = class_9139.method_56435(class_9135.field_48550, RustSleepStatePayload::entityId, class_9135.field_48547, RustSleepStatePayload::isSleeping, RustSleepStatePayload::new);
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public class_8710.class_9154<? extends class_8710> method_56479() {
/* 21 */     return (class_8710.class_9154)TYPE;
/*    */   } }


/* Location:              C:\Users\SystemX\AppData\Local\IceCubeRust\game\mods\rustmine-0.1.2.jar!\net\rustmine\RustSleepStatePayload.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */
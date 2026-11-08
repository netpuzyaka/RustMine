/*    */ package net.rustmine;
/*    */ public final class BuildPayload extends Record implements class_8710 { private final int action; private final int piece; private final class_243 pos; private final float yaw;
/*    */   private final int entity;
/*    */   private final int grade;
/*    */   public static final int PLACE = 0;
/*    */   public static final int UPGRADE = 1;
/*    */   public static final int DEMOLISH = 2;
/*    */   public static final int REPAIR = 3;
/*    */   public static final int ROTATE = 4;
/*    */   public static final int PLACE_DOOR = 5;
/*    */   
/* 12 */   public BuildPayload(int action, int piece, class_243 pos, float yaw, int entity, int grade) { this.action = action; this.piece = piece; this.pos = pos; this.yaw = yaw; this.entity = entity; this.grade = grade; } public static final int DOOR_TOGGLE = 6; public static final int DOOR_KNOCK = 7; public static final int PLACE_CUPBOARD = 8; public static final int PLACE_BAG = 9; public static final int TC_OPEN = 10; public static final int TC_AUTH = 11; public static final int TC_CLEAR = 12; public static final int BAG_PICKUP = 13; public static final int EXPLOSIVE_IGNITE = 14; public static final int EXPLOSIVE_PICKUP = 15; public static final int TC_DEAUTH = 16; public static final int DOOR_PICKUP = 17; public final String toString() { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> toString : (Lnet/rustmine/BuildPayload;)Ljava/lang/String;
/*    */     //   6: areturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #12	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	7	0	this	Lnet/rustmine/BuildPayload; } public final int hashCode() { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> hashCode : (Lnet/rustmine/BuildPayload;)I
/*    */     //   6: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #12	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	7	0	this	Lnet/rustmine/BuildPayload; } public final boolean equals(Object o) { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: aload_1
/*    */     //   2: <illegal opcode> equals : (Lnet/rustmine/BuildPayload;Ljava/lang/Object;)Z
/*    */     //   7: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #12	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	8	0	this	Lnet/rustmine/BuildPayload;
/* 12 */     //   0	8	1	o	Ljava/lang/Object; } public int action() { return this.action; } public int piece() { return this.piece; } public class_243 pos() { return this.pos; } public float yaw() { return this.yaw; } public int entity() { return this.entity; } public int grade() { return this.grade; }
/*    */ 
/*    */ 
/*    */   
/* 16 */   public static final class_8710.class_9154<BuildPayload> TYPE = new class_8710.class_9154(RustmineMod.id("build")); public static final class_9139<class_9129, BuildPayload> CODEC; static {
/* 17 */     CODEC = class_9139.method_56437((buf, p) -> {
/*    */           buf.method_10804(p.action);
/*    */           buf.method_10804(p.piece);
/*    */           buf.method_52955(p.pos);
/*    */           buf.method_52941(p.yaw);
/*    */           buf.method_10804(p.entity + 1);
/*    */           buf.method_10804(p.grade);
/*    */         }buf -> new BuildPayload(buf.method_10816(), buf.method_10816(), buf.method_52996(), buf.readFloat(), buf.method_10816() - 1, buf.method_10816()));
/*    */   }
/*    */ 
/*    */   
/*    */   public static BuildPayload place(int piece, class_243 pos, float yaw) {
/* 29 */     return new BuildPayload(0, piece, pos, yaw, -1, 0);
/*    */   }
/*    */   
/*    */   public static BuildPayload place(int piece, class_243 pos, float yaw, int target) {
/* 33 */     return new BuildPayload(0, piece, pos, yaw, target, 0);
/*    */   }
/*    */   
/*    */   public static BuildPayload placeDoor(int kind, class_243 pos, float yaw) {
/* 37 */     return new BuildPayload(5, kind, pos, yaw, -1, 0);
/*    */   }
/*    */   
/*    */   public static BuildPayload placeCupboard(class_243 pos, float yaw) {
/* 41 */     return new BuildPayload(8, 0, pos, yaw, -1, 0);
/*    */   }
/*    */   
/*    */   public static BuildPayload placeBag(class_243 pos, float yaw) {
/* 45 */     return new BuildPayload(9, 0, pos, yaw, -1, 0);
/*    */   }
/*    */   
/*    */   public static BuildPayload onBlock(int action, int entity, int grade) {
/* 49 */     return new BuildPayload(action, 0, class_243.field_1353, 0.0F, entity, grade);
/*    */   }
/*    */   
/*    */   public static BuildPayload repair(int entity, class_243 hit) {
/* 53 */     return new BuildPayload(3, 0, hit, 0.0F, entity, 0);
/*    */   }
/*    */ 
/*    */   
/*    */   public class_8710.class_9154<? extends class_8710> method_56479() {
/* 58 */     return (class_8710.class_9154)TYPE;
/*    */   } }


/* Location:              C:\Users\SystemX\AppData\Local\IceCubeRust\game\mods\rustmine-0.1.2.jar!\net\rustmine\BuildPayload.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */
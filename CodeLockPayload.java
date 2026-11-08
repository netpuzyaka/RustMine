/*    */ package net.rustmine;public final class CodeLockPayload extends Record implements class_8710 { private final int action; private final int door;
/*    */   private final String code;
/*    */   private final boolean guest;
/*    */   public static final int PLACE = 0;
/*    */   public static final int LOCK = 1;
/*    */   public static final int UNLOCK = 2;
/*    */   public static final int CHANGE_CODE = 3;
/*    */   public static final int ENTER_CODE = 4;
/*    */   public static final int TAKE = 5;
/*    */   public static final int PLACE_KEY_LOCK = 6;
/*    */   
/* 12 */   public CodeLockPayload(int action, int door, String code, boolean guest) { this.action = action; this.door = door; this.code = code; this.guest = guest; } public final String toString() { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> toString : (Lnet/rustmine/CodeLockPayload;)Ljava/lang/String;
/*    */     //   6: areturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #12	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/* 12 */     //   0	7	0	this	Lnet/rustmine/CodeLockPayload; } public int action() { return this.action; } public final int hashCode() { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> hashCode : (Lnet/rustmine/CodeLockPayload;)I
/*    */     //   6: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #12	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	7	0	this	Lnet/rustmine/CodeLockPayload; } public final boolean equals(Object o) { // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: aload_1
/*    */     //   2: <illegal opcode> equals : (Lnet/rustmine/CodeLockPayload;Ljava/lang/Object;)Z
/*    */     //   7: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #12	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	8	0	this	Lnet/rustmine/CodeLockPayload;
/* 12 */     //   0	8	1	o	Ljava/lang/Object; } public int door() { return this.door; } public String code() { return this.code; } public boolean guest() { return this.guest; }
/*    */   
/* 14 */   public static final class_8710.class_9154<CodeLockPayload> TYPE = new class_8710.class_9154(RustmineMod.id("code_lock")); public static final class_9139<class_9129, CodeLockPayload> CODEC; static {
/* 15 */     CODEC = class_9139.method_56437((buf, p) -> {
/*    */           buf.method_10804(p.action);
/*    */           buf.method_10804(p.door);
/*    */           buf.method_10788(p.code, 8);
/*    */           buf.method_52964(p.guest);
/*    */         }buf -> new CodeLockPayload(buf.method_10816(), buf.method_10816(), buf.method_10800(8), buf.readBoolean()));
/*    */   }
/*    */ 
/*    */   
/*    */   public static CodeLockPayload of(int action, int door) {
/* 25 */     return new CodeLockPayload(action, door, "", false);
/*    */   }
/*    */ 
/*    */   
/*    */   public class_8710.class_9154<? extends class_8710> method_56479() {
/* 30 */     return (class_8710.class_9154)TYPE;
/*    */   } }


/* Location:              C:\Users\SystemX\AppData\Local\IceCubeRust\game\mods\rustmine-0.1.2.jar!\net\rustmine\CodeLockPayload.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */
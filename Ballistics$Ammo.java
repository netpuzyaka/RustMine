/*    */ package net.rustmine.combat;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ final class Ammo
/*    */   extends Record
/*    */ {
/*    */   private final float velocity;
/*    */   private final float velocitySpread;
/*    */   private final int pellets;
/*    */   private final float spread;
/*    */   private final float drag;
/*    */   private final float gravity;
/*    */   private final float thickness;
/*    */   private final float initialDistance;
/*    */   private final float damage;
/*    */   private final float falloffFrom;
/*    */   private final float falloffTo;
/*    */   private final float falloffMult;
/*    */   private final int damageType;
/*    */   private final float tracerWidth;
/*    */   private final float tracerTime;
/*    */   
/*    */   public final String toString() {
/*    */     // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> toString : (Lnet/rustmine/combat/Ballistics$Ammo;)Ljava/lang/String;
/*    */     //   6: areturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #90	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	7	0	this	Lnet/rustmine/combat/Ballistics$Ammo;
/*    */   }
/*    */   
/*    */   public final int hashCode() {
/*    */     // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: <illegal opcode> hashCode : (Lnet/rustmine/combat/Ballistics$Ammo;)I
/*    */     //   6: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #90	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	7	0	this	Lnet/rustmine/combat/Ballistics$Ammo;
/*    */   }
/*    */   
/*    */   public final boolean equals(Object o) {
/*    */     // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: aload_1
/*    */     //   2: <illegal opcode> equals : (Lnet/rustmine/combat/Ballistics$Ammo;Ljava/lang/Object;)Z
/*    */     //   7: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #90	-> 0
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   0	8	0	this	Lnet/rustmine/combat/Ballistics$Ammo;
/*    */     //   0	8	1	o	Ljava/lang/Object;
/*    */   }
/*    */   
/*    */   private Ammo(float velocity, float velocitySpread, int pellets, float spread, float drag, float gravity, float thickness, float initialDistance, float damage, float falloffFrom, float falloffTo, float falloffMult, int damageType, float tracerWidth, float tracerTime) {
/* 90 */     this.velocity = velocity; this.velocitySpread = velocitySpread; this.pellets = pellets; this.spread = spread; this.drag = drag; this.gravity = gravity; this.thickness = thickness; this.initialDistance = initialDistance; this.damage = damage; this.falloffFrom = falloffFrom; this.falloffTo = falloffTo; this.falloffMult = falloffMult; this.damageType = damageType; this.tracerWidth = tracerWidth; this.tracerTime = tracerTime; } public float velocity() { return this.velocity; } public float velocitySpread() { return this.velocitySpread; } public int pellets() { return this.pellets; } public float spread() { return this.spread; } public float drag() { return this.drag; } public float gravity() { return this.gravity; } public float thickness() { return this.thickness; } public float initialDistance() { return this.initialDistance; } public float damage() { return this.damage; } public float falloffFrom() { return this.falloffFrom; } public float falloffTo() { return this.falloffTo; } public float falloffMult() { return this.falloffMult; } public int damageType() { return this.damageType; } public float tracerWidth() { return this.tracerWidth; } public float tracerTime() { return this.tracerTime; }
/*    */ 
/*    */ }


/* Location:              C:\Users\SystemX\AppData\Local\IceCubeRust\game\mods\rustmine-0.1.2.jar!\net\rustmine\combat\Ballistics$Ammo.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */
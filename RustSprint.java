/*    */ package net.rustmine;
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class RustSprint
/*    */ {
/*    */   public static final float WALK = 2.8F;
/*    */   public static final float RUN = 5.5F;
/*    */   public static final float CROUCH = 1.7F;
/*    */   private static final float VANILLA_SPRINT_FACTOR = 1.3F;
/*    */   private static final float VANILLA_SNEAK_FACTOR = 0.3F;
/*    */   private static final float VANILLA_WALK = 4.317181F;
/*    */   
/*    */   public static boolean landMovement(boolean flying, boolean inFluid, boolean passenger, boolean specialPose) {
/* 15 */     return (!flying && !inFluid && !passenger && !specialPose);
/*    */   }
/*    */ 
/*    */   
/*    */   public static float movementSpeed(float attributeSpeed, boolean sprinting, boolean crouching) {
/* 20 */     float walkingAttribute = attributeSpeed / (sprinting ? 1.3F : 1.0F);
/* 21 */     return walkingAttribute * ((sprinting && !crouching) ? 5.5F : 2.8F) / 4.317181F;
/*    */   }
/*    */ 
/*    */   
/*    */   public static float crouchInput(float sneakingFactor) {
/* 26 */     return Math.min(1.0F, sneakingFactor * 0.60714287F / 0.3F);
/*    */   }
/*    */   
/*    */   public static boolean held(boolean sprintKey, float forward, boolean crouching, boolean weaponBusy) {
/* 30 */     return (sprintKey && forward > 1.0E-5F && !crouching && !weaponBusy);
/*    */   }
/*    */ }


/* Location:              C:\Users\SystemX\AppData\Local\IceCubeRust\game\mods\rustmine-0.1.2.jar!\net\rustmine\RustSprint.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */
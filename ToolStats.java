/*    */ package net.rustmine.combat;
/*    */ 
/*    */ import net.minecraft.class_1792;
/*    */ 
/*    */ 
/*    */ public final class ToolStats
/*    */ {
/*    */   public final String name;
/*    */   public final class_1792 item;
/*    */   public final float damage;
/*    */   public final float softSideMult;
/*    */   public final float swingDelay;
/*    */   public final float treeGather;
/*    */   public final float treeDestroy;
/*    */   public final float oreGather;
/*    */   public final float oreDestroy;
/*    */   public final float fleshGather;
/*    */   public final float fleshDestroy;
/*    */   public final float gatherWood;
/*    */   public final float gatherStone;
/*    */   public final float gatherMetal;
/*    */   
/*    */   public ToolStats(String name, class_1792 item, float damage, float softSideMult, float swingDelay, float treeGather, float treeDestroy, float oreGather, float oreDestroy, float fleshGather, float fleshDestroy) {
/* 24 */     this.name = name;
/* 25 */     this.item = item;
/* 26 */     this.damage = damage;
/* 27 */     this.softSideMult = softSideMult;
/* 28 */     this.swingDelay = swingDelay;
/* 29 */     this.treeGather = treeGather;
/* 30 */     this.treeDestroy = treeDestroy;
/* 31 */     this.oreGather = oreGather;
/* 32 */     this.oreDestroy = oreDestroy;
/* 33 */     this.fleshGather = fleshGather;
/* 34 */     this.fleshDestroy = fleshDestroy;
/* 35 */     this.gatherWood = treeGather;
/* 36 */     this.gatherStone = oreGather;
/* 37 */     this.gatherMetal = oreGather;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public float getFleshGatherEfficiency() {
/* 45 */     float baseEff = this.fleshGather / 20.0F;
/* 46 */     float netYield = baseEff * (1.0F - this.fleshDestroy);
/* 47 */     return Math.max(0.1F, Math.min(1.0F, netYield));
/*    */   }
/*    */ }


/* Location:              C:\Users\SystemX\AppData\Local\IceCubeRust\game\mods\rustmine-0.1.2.jar!\net\rustmine\combat\ToolStats.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */
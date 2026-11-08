/*     */ package net.rustmine;
/*     */ 
/*     */ import java.util.UUID;
/*     */ import java.util.function.Consumer;
/*     */ import net.minecraft.class_11368;
/*     */ import net.minecraft.class_11372;
/*     */ import net.minecraft.class_1282;
/*     */ import net.minecraft.class_1297;
/*     */ import net.minecraft.class_1299;
/*     */ import net.minecraft.class_1309;
/*     */ import net.minecraft.class_1675;
/*     */ import net.minecraft.class_1937;
/*     */ import net.minecraft.class_238;
/*     */ import net.minecraft.class_239;
/*     */ import net.minecraft.class_243;
/*     */ import net.minecraft.class_2940;
/*     */ import net.minecraft.class_2943;
/*     */ import net.minecraft.class_2945;
/*     */ import net.minecraft.class_3218;
/*     */ import net.minecraft.class_3532;
/*     */ import net.minecraft.class_3959;
/*     */ import net.minecraft.class_3965;
/*     */ import net.minecraft.class_3966;
/*     */ import net.rustmine.building.BuildingCollision;
/*     */ import net.rustmine.raid.RaidExplosive;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class RocketEntity
/*     */   extends class_1297
/*     */ {
/*     */   public static final int KIND_NORMAL = 0;
/*     */   public static final int KIND_HV = 1;
/*     */   public static final int KIND_INC = 2;
/*  45 */   private static final class_2940<Integer> KIND = class_2945.method_12791(RocketEntity.class, class_2943.field_13327);
/*     */   
/*     */   public static final float SPEED = 18.0F;
/*     */   
/*     */   public static final float GRAVITY = 2.4525F;
/*     */   
/*     */   static final float MIN_RADIUS = 1.0F;
/*     */   static final float RADIUS = 3.8F;
/*     */   static final float DAMAGE = 70.0F;
/*     */   static final double BODY_RADIUS = 0.06D;
/*     */   private static final int SUBSTEPS = 5;
/*     */   private static final float DT = 0.01F;
/*     */   public static Consumer<RocketEntity> clientTick = r -> {
/*     */     
/*     */     };
/*     */   private UUID owner;
/*     */   private int fuse;
/*     */   private boolean exploded;
/*     */   
/*     */   public RocketEntity(class_1299<? extends RocketEntity> type, class_1937 level) {
/*  65 */     super(type, level);
/*  66 */     this.fuse = 160 + level.field_9229.method_43048(41);
/*  67 */     this.field_5960 = true;
/*     */   }
/*     */   
/*     */   public int getKind() {
/*  71 */     return ((Integer)this.field_6011.method_12789(KIND)).intValue();
/*     */   }
/*     */   
/*     */   public static RocketEntity launch(class_3218 level, class_1309 shooter, class_243 from, class_243 dir) {
/*  75 */     return launch(level, shooter, from, dir, 0);
/*     */   }
/*     */   
/*     */   public static RocketEntity launch(class_3218 level, class_1309 shooter, class_243 from, class_243 dir, int kind) {
/*  79 */     RocketEntity r = new RocketEntity(RustmineMod.ROCKET, (class_1937)level);
/*  80 */     r.owner = shooter.method_5667();
/*  81 */     r.field_6011.method_12778(KIND, Integer.valueOf(kind));
/*  82 */     r.method_33574(from);
/*  83 */     float spd = (kind == 1) ? 50.0F : 18.0F;
/*  84 */     r.method_18799(dir.method_1029().method_1021(spd / 20.0D));
/*  85 */     r.faceVelocity();
/*  86 */     level.method_8649(r);
/*  87 */     return r;
/*     */   }
/*     */   
/*     */   void faceVelocity() {
/*  91 */     class_243 v = method_18798();
/*  92 */     if (v.method_1027() < 1.0E-6D)
/*  93 */       return;  method_36456((float)(class_3532.method_15349(-v.field_1352, v.field_1350) * 57.2957763671875D));
/*  94 */     method_36457((float)(class_3532.method_15349(-v.field_1351, v.method_37267()) * 57.2957763671875D));
/*     */   }
/*     */ 
/*     */   
/*     */   public void method_5773() {
/*  99 */     super.method_5773();
/* 100 */     int kind = getKind();
/* 101 */     float gravity = (kind == 1) ? 0.98100007F : ((kind == 2) ? 2.9430003F : 2.4525F);
/* 102 */     if (method_73183().method_8608()) {
/*     */       
/* 104 */       for (int j = 0; j < 5; j++) {
/* 105 */         class_243 v = method_18798().method_1021(20.0D).method_1031(0.0D, (-gravity * 0.01F), 0.0D);
/* 106 */         method_18799(v.method_1021(0.05D));
/* 107 */         method_33574(method_73189().method_1019(v.method_1021(0.009999999776482582D)));
/*     */       } 
/* 109 */       faceVelocity();
/* 110 */       clientTick.accept(this);
/*     */       return;
/*     */     } 
/* 113 */     if (this.exploded)
/* 114 */       return;  if (this.field_6012 > this.fuse) {
/* 115 */       explode(method_73189(), new class_243(0.0D, 1.0D, 0.0D));
/*     */       return;
/*     */     } 
/* 118 */     class_3218 level = (class_3218)method_73183();
/* 119 */     for (int i = 0; i < 5 && !this.exploded; i++) {
/* 120 */       class_3966 class_39661; class_243 v = method_18798().method_1021(20.0D).method_1031(0.0D, (-gravity * 0.01F), 0.0D);
/* 121 */       method_18799(v.method_1021(0.05D));
/* 122 */       class_243 from = method_73189(), to = from.method_1019(v.method_1021(0.009999999776482582D));
/* 123 */       class_239 hit = clipBody(level, from, to);
/* 124 */       class_243 end = (hit.method_17783() == class_239.class_240.field_1333) ? to : hit.method_17784();
/* 125 */       class_3966 eh = class_1675.method_37226((class_1937)level, this, from, end, (new class_238(from, end))
/* 126 */           .method_1014(0.5D), e -> (e.method_5863() && !e.method_7325() && (this.field_6012 > 4 || !e.method_5667().equals(this.owner))), 0.1F);
/* 127 */       if (eh != null) class_39661 = eh; 
/* 128 */       BuildingCollision.Hit block = BuildingCollision.raycast((class_1937)level, from, to, 0.06D);
/* 129 */       BuildingCollision.DoorHit door = BuildingCollision.raycastDoors((class_1937)level, from, to, 0.06D);
/* 130 */       double other = from.method_1022((class_39661.method_17783() == class_239.class_240.field_1333) ? to : class_39661.method_17784());
/* 131 */       if (door != null && door.distance() < other && (block == null || door.distance() < block.distance())) {
/*     */         
/* 133 */         class_243 at = door.location().method_1020(v.method_1029().method_1021(0.1D));
/* 134 */         method_33574(at);
/* 135 */         explode(at, v.method_1029().method_22882());
/*     */         return;
/*     */       } 
/* 138 */       if (block != null && block.distance() < other) {
/* 139 */         class_243 at = block.location().method_1020(v.method_1029().method_1021(0.1D));
/* 140 */         method_33574(at);
/*     */         
/* 142 */         class_243 away = block.location().method_1020(block.solid().closest(block.location()));
/* 143 */         explode(at, (away.method_1027() > 1.0E-6D) ? away.method_1029() : block.block().obb().normalAt(block.location()));
/*     */         return;
/*     */       } 
/* 146 */       if (class_39661.method_17783() != class_239.class_240.field_1333) {
/*     */         
/* 148 */         class_243 dir = v.method_1029();
/* 149 */         class_243 at = class_39661.method_17784().method_1020(dir.method_1021(0.1D));
/* 150 */         class_3965 bh = (class_3965)class_39661; class_243 normal = (class_39661 instanceof class_3965) ? class_243.method_24954(bh.method_17780().method_62675()) : dir.method_22882();
/* 151 */         method_33574(at);
/* 152 */         explode(at, normal);
/*     */         return;
/*     */       } 
/* 155 */       method_33574(to);
/*     */     } 
/* 157 */     faceVelocity();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private class_239 clipBody(class_3218 level, class_243 from, class_243 to) {
/* 165 */     class_3965 class_3965 = level.method_17742(new class_3959(from, to, class_3959.class_3960.field_17558, class_3959.class_242.field_1348, this));
/* 166 */     double bestDistance = (class_3965.method_17783() == class_239.class_240.field_1333) ? Double.MAX_VALUE : from.method_1022(class_3965.method_17784());
/* 167 */     class_243 dir = to.method_1020(from).method_1029();
/* 168 */     class_243 side = dir.method_1036((Math.abs(dir.field_1351) > 0.95D) ? new class_243(1.0D, 0.0D, 0.0D) : new class_243(0.0D, 1.0D, 0.0D)).method_1029().method_1021(0.06D);
/* 169 */     class_243 other = dir.method_1036(side);
/* 170 */     for (class_243 offset : new class_243[] { side, side.method_22882(), other, other.method_22882() }) {
/* 171 */       class_243 start = from.method_1019(offset);
/* 172 */       class_3965 hit = level.method_17742(new class_3959(start, to.method_1019(offset), class_3959.class_3960.field_17558, class_3959.class_242.field_1348, this));
/* 173 */       if (hit.method_17783() != class_239.class_240.field_1333 && !hit.method_17781()) {
/* 174 */         double distance = start.method_1022(hit.method_17784());
/* 175 */         if (distance < bestDistance) {
/* 176 */           bestDistance = distance;
/* 177 */           class_3965 = new class_3965(from.method_1019(dir.method_1021(distance)), hit.method_17780(), hit.method_17777(), false);
/*     */         } 
/*     */       } 
/* 180 */     }  return (class_239)class_3965;
/*     */   }
/*     */   
/*     */   private void explode(class_243 at, class_243 normal) {
/* 184 */     this.exploded = true;
/* 185 */     class_3218 level = (class_3218)method_73183();
/* 186 */     class_1297 shooter = (this.owner == null) ? null : level.method_66347(this.owner);
/* 187 */     int kind = getKind();
/* 188 */     switch (kind) { case 1: 
/*     */       case 2: 
/*     */       default:
/* 191 */         break; }  int raidType = 2;
/*     */     
/* 193 */     float defaultDmg = (kind == 1) ? 250.0F : ((kind == 2) ? 150.0F : 350.0F);
/* 194 */     float defaultRad = (kind == 1) ? 4.5F : ((kind == 2) ? 4.5F : 3.8F);
/* 195 */     float dmg = RaidExplosive.getExplosivePlayerDamage(raidType, defaultDmg);
/* 196 */     float rad = RaidExplosive.getExplosiveRadius(raidType, defaultRad);
/*     */     
/* 198 */     RaidExplosive.detonateRaid(level, (shooter != null) ? shooter : this, at, normal, raidType, dmg, rad);
/* 199 */     method_31472();
/*     */   }
/*     */ 
/*     */   
/*     */   protected void method_5693(class_2945.class_9222 builder) {
/* 204 */     builder.method_56912(KIND, Integer.valueOf(0));
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean method_64397(class_3218 level, class_1282 source, float amount) {
/* 209 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void method_5749(class_11368 in) {}
/*     */ 
/*     */ 
/*     */   
/*     */   protected void method_5652(class_11372 out) {}
/*     */ 
/*     */   
/*     */   public boolean method_31746() {
/* 222 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Users\SystemX\AppData\Local\IceCubeRust\game\mods\rustmine-0.1.2.jar!\net\rustmine\RocketEntity.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */
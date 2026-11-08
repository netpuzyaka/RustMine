/*     */ package net.rustmine;
/*     */ 
/*     */ import java.util.Optional;
/*     */ import java.util.UUID;
/*     */ import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
/*     */ import net.minecraft.class_11368;
/*     */ import net.minecraft.class_11372;
/*     */ import net.minecraft.class_1262;
/*     */ import net.minecraft.class_1263;
/*     */ import net.minecraft.class_1268;
/*     */ import net.minecraft.class_1269;
/*     */ import net.minecraft.class_1277;
/*     */ import net.minecraft.class_1282;
/*     */ import net.minecraft.class_1297;
/*     */ import net.minecraft.class_1299;
/*     */ import net.minecraft.class_1313;
/*     */ import net.minecraft.class_1657;
/*     */ import net.minecraft.class_1661;
/*     */ import net.minecraft.class_1703;
/*     */ import net.minecraft.class_1707;
/*     */ import net.minecraft.class_1799;
/*     */ import net.minecraft.class_1937;
/*     */ import net.minecraft.class_2371;
/*     */ import net.minecraft.class_2561;
/*     */ import net.minecraft.class_2940;
/*     */ import net.minecraft.class_2943;
/*     */ import net.minecraft.class_2945;
/*     */ import net.minecraft.class_3218;
/*     */ import net.minecraft.class_3222;
/*     */ import net.minecraft.class_3419;
/*     */ import net.minecraft.class_3908;
/*     */ import net.minecraft.class_3917;
/*     */ import net.minecraft.class_747;
/*     */ import net.minecraft.class_8710;
/*     */ import net.rustmine.deploy.RustDeployableOpenPayload;
/*     */ 
/*     */ public class RustSleeperEntity
/*     */   extends class_1297 implements class_1263 {
/*  39 */   private static final class_2940<String> OWNER_UUID = class_2945.method_12791(RustSleeperEntity.class, class_2943.field_13326);
/*  40 */   private static final class_2940<String> OWNER_NAME = class_2945.method_12791(RustSleeperEntity.class, class_2943.field_13326);
/*  41 */   private static final class_2940<Float> YAW = class_2945.method_12791(RustSleeperEntity.class, class_2943.field_13320);
/*  42 */   private static final class_2940<Float> HEALTH = class_2945.method_12791(RustSleeperEntity.class, class_2943.field_13320);
/*     */   
/*  44 */   private static final class_2940<class_1799> WEAR_0 = class_2945.method_12791(RustSleeperEntity.class, class_2943.field_13322);
/*  45 */   private static final class_2940<class_1799> WEAR_1 = class_2945.method_12791(RustSleeperEntity.class, class_2943.field_13322);
/*  46 */   private static final class_2940<class_1799> WEAR_2 = class_2945.method_12791(RustSleeperEntity.class, class_2943.field_13322);
/*  47 */   private static final class_2940<class_1799> WEAR_3 = class_2945.method_12791(RustSleeperEntity.class, class_2943.field_13322);
/*  48 */   private static final class_2940<class_1799> WEAR_4 = class_2945.method_12791(RustSleeperEntity.class, class_2943.field_13322);
/*  49 */   private static final class_2940<class_1799> WEAR_5 = class_2945.method_12791(RustSleeperEntity.class, class_2943.field_13322);
/*  50 */   private static final class_2940<class_1799> WEAR_6 = class_2945.method_12791(RustSleeperEntity.class, class_2943.field_13322);
/*     */   
/*  52 */   private final class_1277 container = new class_1277(45)
/*     */     {
/*     */       public void method_5431() {
/*  55 */         super.method_5431();
/*  56 */         RustSleeperEntity.this.updateWearSync();
/*     */       }
/*     */     };
/*     */   
/*     */   public RustSleeperEntity(class_1299<? extends RustSleeperEntity> type, class_1937 level) {
/*  61 */     super(type, level);
/*  62 */     this.field_23807 = true;
/*     */   }
/*     */ 
/*     */   
/*     */   public void method_5773() {
/*  67 */     super.method_5773();
/*  68 */     if (!method_5740()) {
/*  69 */       method_18799(method_18798().method_1031(0.0D, -0.04D, 0.0D));
/*     */     }
/*  71 */     method_5784(class_1313.field_6308, method_18798());
/*  72 */     method_18799(method_18798().method_18805(0.98D, 0.98D, 0.98D));
/*     */   }
/*     */   
/*     */   public static RustSleeperEntity createFromPlayer(class_3222 player) {
/*  76 */     class_3218 level = player.method_51469();
/*  77 */     RustSleeperEntity sleeper = new RustSleeperEntity(RustmineMod.SLEEPER_ENTITY, (class_1937)level);
/*  78 */     sleeper.method_5814(player.method_23317(), player.method_23318(), player.method_23321());
/*  79 */     float rustHp = (RustVitalsManager.get((class_1657)player)).health;
/*  80 */     sleeper.setup(player.method_5667(), player.method_5477().getString(), player.method_36454(), rustHp);
/*     */     
/*     */     int i;
/*  83 */     for (i = 0; i < 24; i++) {
/*  84 */       int vanillaSlot = 9 + i;
/*  85 */       if (vanillaSlot < player.method_31548().method_5439()) {
/*  86 */         class_1799 stack = player.method_31548().method_5438(vanillaSlot);
/*  87 */         if (!stack.method_7960()) {
/*  88 */           sleeper.container.method_5447(i, stack.method_7972());
/*  89 */           player.method_31548().method_5447(vanillaSlot, class_1799.field_8037);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/*  95 */     for (i = 0; i < 6; i++) {
/*  96 */       class_1799 stack = player.method_31548().method_5438(i);
/*  97 */       if (!stack.method_7960()) {
/*  98 */         sleeper.container.method_5447(24 + i, stack.method_7972());
/*  99 */         player.method_31548().method_5447(i, class_1799.field_8037);
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 104 */     class_2371<class_1799> wear = RustWearManager.getWear((class_1657)player);
/* 105 */     for (int j = 0; j < 7; j++) {
/* 106 */       class_1799 stack = (class_1799)wear.get(j);
/* 107 */       if (!stack.method_7960()) {
/* 108 */         sleeper.container.method_5447(30 + j, stack.method_7972());
/* 109 */         wear.set(j, class_1799.field_8037);
/*     */       } 
/*     */     } 
/* 112 */     RustWearManager.sync(player);
/*     */     
/* 114 */     sleeper.updateWearSync();
/* 115 */     level.method_8649(sleeper);
/* 116 */     RustSleeperManager.registerSleeper(player.method_5667(), sleeper);
/* 117 */     return sleeper;
/*     */   }
/*     */   
/*     */   public void restoreToPlayer(class_3222 player) {
/*     */     int i;
/* 122 */     for (i = 0; i < 24; i++) {
/* 123 */       int vanillaSlot = 9 + i;
/* 124 */       if (vanillaSlot < player.method_31548().method_5439()) {
/* 125 */         class_1799 stack = this.container.method_5438(i);
/* 126 */         player.method_31548().method_5447(vanillaSlot, stack.method_7972());
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 131 */     for (i = 0; i < 6; i++) {
/* 132 */       class_1799 stack = this.container.method_5438(24 + i);
/* 133 */       player.method_31548().method_5447(i, stack.method_7972());
/*     */     } 
/*     */ 
/*     */     
/* 137 */     class_2371<class_1799> wear = RustWearManager.getWear((class_1657)player);
/* 138 */     for (int j = 0; j < 7; j++) {
/* 139 */       class_1799 stack = this.container.method_5438(30 + j);
/* 140 */       wear.set(j, stack.method_7972());
/*     */     } 
/* 142 */     RustWearManager.sync(player);
/*     */ 
/*     */     
/* 145 */     RustVitalsData v = RustVitalsManager.get((class_1657)player);
/* 146 */     v.health = Math.max(1.0F, Math.min(100.0F, getHealth()));
/* 147 */     RustVitalsManager.sync(player, v);
/* 148 */     player.method_6033(player.method_6063());
/* 149 */     player.method_5859(method_23317(), method_23318(), method_23321());
/*     */   }
/*     */   
/*     */   public void setup(UUID ownerUuid, String ownerName, float yaw, float health) {
/* 153 */     this.field_6011.method_12778(OWNER_UUID, (ownerUuid != null) ? ownerUuid.toString() : "");
/* 154 */     this.field_6011.method_12778(OWNER_NAME, (ownerName != null) ? ownerName : "");
/* 155 */     this.field_6011.method_12778(YAW, Float.valueOf(yaw));
/* 156 */     this.field_6011.method_12778(HEALTH, Float.valueOf(Math.max(1.0F, health)));
/* 157 */     method_36456(yaw);
/*     */   }
/*     */   
/*     */   public Optional<UUID> getOwnerUuid() {
/* 161 */     String u = (String)this.field_6011.method_12789(OWNER_UUID);
/* 162 */     if (u == null || u.isEmpty()) return Optional.empty(); 
/*     */     try {
/* 164 */       return Optional.of(UUID.fromString(u));
/* 165 */     } catch (Exception e) {
/* 166 */       return Optional.empty();
/*     */     } 
/*     */   }
/*     */   
/*     */   public String getOwnerName() {
/* 171 */     return (String)this.field_6011.method_12789(OWNER_NAME);
/*     */   }
/*     */   
/*     */   public float getSleeperYaw() {
/* 175 */     return ((Float)this.field_6011.method_12789(YAW)).floatValue();
/*     */   }
/*     */   
/*     */   public float getHealth() {
/* 179 */     return ((Float)this.field_6011.method_12789(HEALTH)).floatValue();
/*     */   }
/*     */   
/*     */   public class_1799 getWearItem(int slot) {
/* 183 */     switch (slot) { case 0: case 1: case 2: case 3: case 4: case 5: case 6:  }  return 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 191 */       class_1799.field_8037;
/*     */   }
/*     */ 
/*     */   
/*     */   private void updateWearSync() {
/* 196 */     if (method_73183().method_8608())
/* 197 */       return;  this.field_6011.method_12778(WEAR_0, this.container.method_5438(30));
/* 198 */     this.field_6011.method_12778(WEAR_1, this.container.method_5438(31));
/* 199 */     this.field_6011.method_12778(WEAR_2, this.container.method_5438(32));
/* 200 */     this.field_6011.method_12778(WEAR_3, this.container.method_5438(33));
/* 201 */     this.field_6011.method_12778(WEAR_4, this.container.method_5438(34));
/* 202 */     this.field_6011.method_12778(WEAR_5, this.container.method_5438(35));
/* 203 */     this.field_6011.method_12778(WEAR_6, this.container.method_5438(36));
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean method_5863() {
/* 208 */     return !method_31481();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean method_64397(class_3218 level, class_1282 source, float amount) {
/* 213 */     if (method_31481()) return false;
/*     */     
/* 215 */     int protection = 0;
/* 216 */     for (int i = 30; i <= 36; i++) {
/* 217 */       class_1799 st = this.container.method_5438(i);
/* 218 */       if (!st.method_7960()) {
/* 219 */         RustArmorStats stats = RustArmorStats.get(st.method_7909());
/* 220 */         if (stats != null) {
/* 221 */           protection += stats.projectile();
/*     */         }
/*     */       } 
/*     */     } 
/* 225 */     float finalDamage = amount * (1.0F - Math.min(75, protection) / 100.0F);
/* 226 */     float currentHp = getHealth() - finalDamage;
/* 227 */     this.field_6011.method_12778(HEALTH, Float.valueOf(Math.max(0.0F, currentHp)));
/*     */     
/* 229 */     level.method_43128(null, method_23317(), method_23318(), method_23321(), RustmineMod.SOUNDS.getOrDefault("flesh_hit", RustmineMod.DEPLOY), class_3419.field_15248, 1.0F, 1.0F);
/*     */     
/* 231 */     if (currentHp <= 0.0F) {
/*     */       
/* 233 */       level.method_43128(null, method_23317(), method_23318(), method_23321(), RustmineMod.PLAYER_DEATH, class_3419.field_15248, 1.2F, 1.0F);
/* 234 */       getOwnerUuid().ifPresent(RustSleeperManager::markKilled);
/*     */ 
/*     */       
/* 237 */       RustCorpseEntity corpse = new RustCorpseEntity(RustmineMod.CORPSE_ENTITY, (class_1937)level);
/* 238 */       corpse.method_5814(method_23317(), method_23318(), method_23321());
/* 239 */       corpse.setup(getOwnerUuid().orElse(null), getOwnerName(), getSleeperYaw());
/* 240 */       for (int j = 0; j < 45; j++) {
/* 241 */         corpse.method_5447(j, this.container.method_5438(j).method_7972());
/*     */       }
/* 243 */       level.method_8649(corpse);
/*     */       
/* 245 */       method_31472();
/*     */     } 
/* 247 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public void method_5650(class_1297.class_5529 reason) {
/* 252 */     super.method_5650(reason);
/* 253 */     getOwnerUuid().ifPresent(RustSleeperManager::unregisterSleeper);
/*     */   }
/*     */ 
/*     */   
/*     */   public class_1269 method_5688(class_1657 player, class_1268 hand) {
/* 258 */     if (method_73183().method_8608()) return (class_1269)class_1269.field_5812;
/*     */     
/* 260 */     if (player instanceof class_3222) { class_3222 sp = (class_3222)player;
/* 261 */       method_73183().method_43128(null, method_23317(), method_23318(), method_23321(), RustmineMod.CRATE_OPEN, class_3419.field_15248, 1.0F, 1.0F);
/* 262 */       String title = getOwnerName().isEmpty() ? "Спящий" : ("Спящий (" + getOwnerName() + ")");
/*     */       
/* 264 */       ServerPlayNetworking.send(sp, (class_8710)new RustDeployableOpenPayload(
/* 265 */             method_5628(), -3, 
/*     */             
/* 267 */             (int)getHealth(), 100.0F, false, title, ""));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 274 */       sp.method_17355((class_3908)new class_747((id, inv, p) -> new class_1707(class_3917.field_18667, id, inv, (class_1263)this.container, 5), 
/*     */             
/* 276 */             (class_2561)class_2561.method_43470(title))); }
/*     */ 
/*     */     
/* 279 */     return (class_1269)class_1269.field_5812;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void method_5693(class_2945.class_9222 builder) {
/* 284 */     builder.method_56912(OWNER_UUID, "");
/* 285 */     builder.method_56912(OWNER_NAME, "");
/* 286 */     builder.method_56912(YAW, Float.valueOf(0.0F));
/* 287 */     builder.method_56912(HEALTH, Float.valueOf(100.0F));
/* 288 */     builder.method_56912(WEAR_0, class_1799.field_8037);
/* 289 */     builder.method_56912(WEAR_1, class_1799.field_8037);
/* 290 */     builder.method_56912(WEAR_2, class_1799.field_8037);
/* 291 */     builder.method_56912(WEAR_3, class_1799.field_8037);
/* 292 */     builder.method_56912(WEAR_4, class_1799.field_8037);
/* 293 */     builder.method_56912(WEAR_5, class_1799.field_8037);
/* 294 */     builder.method_56912(WEAR_6, class_1799.field_8037);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void method_5749(class_11368 input) {
/* 299 */     this.field_6011.method_12778(OWNER_UUID, input.method_71428("ownerUuid", ""));
/* 300 */     this.field_6011.method_12778(OWNER_NAME, input.method_71428("ownerName", ""));
/* 301 */     this.field_6011.method_12778(YAW, Float.valueOf(input.method_71423("yaw", 0.0F)));
/* 302 */     this.field_6011.method_12778(HEALTH, Float.valueOf(input.method_71423("health", 100.0F)));
/* 303 */     class_2371<class_1799> items = class_2371.method_10213(45, class_1799.field_8037);
/* 304 */     class_1262.method_5429(input, items);
/* 305 */     for (int i = 0; i < 45; i++) {
/* 306 */       this.container.method_5447(i, (class_1799)items.get(i));
/*     */     }
/* 308 */     updateWearSync();
/* 309 */     getOwnerUuid().ifPresent(u -> RustSleeperManager.registerSleeper(u, this));
/*     */   }
/*     */ 
/*     */   
/*     */   protected void method_5652(class_11372 output) {
/* 314 */     output.method_71469("ownerUuid", (String)this.field_6011.method_12789(OWNER_UUID));
/* 315 */     output.method_71469("ownerName", (String)this.field_6011.method_12789(OWNER_NAME));
/* 316 */     output.method_71464("yaw", ((Float)this.field_6011.method_12789(YAW)).floatValue());
/* 317 */     output.method_71464("health", ((Float)this.field_6011.method_12789(HEALTH)).floatValue());
/* 318 */     class_2371<class_1799> items = class_2371.method_10213(45, class_1799.field_8037);
/* 319 */     for (int i = 0; i < 45; i++) {
/* 320 */       items.set(i, this.container.method_5438(i));
/*     */     }
/* 322 */     class_1262.method_5426(output, items);
/*     */   }
/*     */ 
/*     */   
/*     */   public int method_5439() {
/* 327 */     return this.container.method_5439();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean method_5442() {
/* 332 */     return this.container.method_5442();
/*     */   }
/*     */ 
/*     */   
/*     */   public class_1799 method_5438(int slot) {
/* 337 */     return this.container.method_5438(slot);
/*     */   }
/*     */ 
/*     */   
/*     */   public class_1799 method_5434(int slot, int amount) {
/* 342 */     return this.container.method_5434(slot, amount);
/*     */   }
/*     */ 
/*     */   
/*     */   public class_1799 method_5441(int slot) {
/* 347 */     return this.container.method_5441(slot);
/*     */   }
/*     */ 
/*     */   
/*     */   public void method_5447(int slot, class_1799 stack) {
/* 352 */     this.container.method_5447(slot, stack);
/* 353 */     updateWearSync();
/*     */   }
/*     */ 
/*     */   
/*     */   public void method_5431() {
/* 358 */     this.container.method_5431();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean method_5443(class_1657 player) {
/* 363 */     return (!method_31481() && method_5858((class_1297)player) <= 36.0D);
/*     */   }
/*     */ 
/*     */   
/*     */   public void method_5448() {
/* 368 */     this.container.method_5448();
/*     */   }
/*     */ }


/* Location:              C:\Users\SystemX\AppData\Local\IceCubeRust\game\mods\rustmine-0.1.2.jar!\net\rustmine\RustSleeperEntity.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */
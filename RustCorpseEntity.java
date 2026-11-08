/*     */ package net.rustmine;
/*     */ import java.util.Optional;
/*     */ import java.util.Set;
/*     */ import java.util.UUID;
/*     */ import java.util.concurrent.ConcurrentHashMap;
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
/*     */ import net.minecraft.class_3468;
/*     */ import net.minecraft.class_3917;
/*     */ import net.minecraft.class_747;
/*     */ import net.minecraft.class_8710;
/*     */ import net.rustmine.animal.RustAnimalData;
/*     */ import net.rustmine.animal.RustAnimals;
/*     */ import net.rustmine.combat.ToolStats;
/*     */ import net.rustmine.config.RustConfigManager;
/*     */ 
/*     */ public class RustCorpseEntity extends class_1297 implements class_1263 {
/*     */   public static final int CORPSE_DECAY_TICKS = 6000;
/*  42 */   private static final Set<UUID> ACTIVE_DEATH_SPAWNS = Collections.newSetFromMap(new ConcurrentHashMap<>());
/*  43 */   private static final Map<UUID, Long> LAST_CORPSE_SPAWN_TICK = new ConcurrentHashMap<>();
/*     */   
/*  45 */   private static final class_2940<String> OWNER_UUID = class_2945.method_12791(RustCorpseEntity.class, class_2943.field_13326);
/*  46 */   private static final class_2940<String> OWNER_NAME = class_2945.method_12791(RustCorpseEntity.class, class_2943.field_13326);
/*  47 */   private static final class_2940<Float> YAW = class_2945.method_12791(RustCorpseEntity.class, class_2943.field_13320);
/*  48 */   private static final class_2940<Float> HEALTH = class_2945.method_12791(RustCorpseEntity.class, class_2943.field_13320);
/*     */   
/*  50 */   private static final class_2940<class_1799> WEAR_0 = class_2945.method_12791(RustCorpseEntity.class, class_2943.field_13322);
/*  51 */   private static final class_2940<class_1799> WEAR_1 = class_2945.method_12791(RustCorpseEntity.class, class_2943.field_13322);
/*  52 */   private static final class_2940<class_1799> WEAR_2 = class_2945.method_12791(RustCorpseEntity.class, class_2943.field_13322);
/*  53 */   private static final class_2940<class_1799> WEAR_3 = class_2945.method_12791(RustCorpseEntity.class, class_2943.field_13322);
/*  54 */   private static final class_2940<class_1799> WEAR_4 = class_2945.method_12791(RustCorpseEntity.class, class_2943.field_13322);
/*  55 */   private static final class_2940<class_1799> WEAR_5 = class_2945.method_12791(RustCorpseEntity.class, class_2943.field_13322);
/*  56 */   private static final class_2940<class_1799> WEAR_6 = class_2945.method_12791(RustCorpseEntity.class, class_2943.field_13322);
/*     */   
/*  58 */   private final class_1277 container = new class_1277(45)
/*     */     {
/*     */       public void method_5431() {
/*  61 */         super.method_5431();
/*  62 */         RustCorpseEntity.this.updateWearSync();
/*     */       }
/*     */     };
/*  65 */   private int ageTicks = 0;
/*  66 */   private long deathGameTime = -1L;
/*     */   
/*  68 */   public float[] yieldAcc = new float[0];
/*     */   public float destroyedFraction;
/*  70 */   public int animalFat = 2;
/*     */   
/*     */   public RustCorpseEntity(class_1299<? extends RustCorpseEntity> type, class_1937 level) {
/*  73 */     super(type, level);
/*  74 */     this.field_23807 = true;
/*     */   }
/*     */   
/*     */   public static RustCorpseEntity createFromPlayer(class_3222 player) {
/*  78 */     if (player == null || player.method_51469().method_8608()) return null; 
/*  79 */     UUID uuid = player.method_5667();
/*  80 */     long now = player.method_51469().method_75260();
/*  81 */     Long lastTick = LAST_CORPSE_SPAWN_TICK.get(uuid);
/*  82 */     if (lastTick != null && now - lastTick.longValue() < 5L) {
/*  83 */       return null;
/*     */     }
/*  85 */     if (!ACTIVE_DEATH_SPAWNS.add(uuid)) {
/*  86 */       return null;
/*     */     }
/*     */     try {
/*  89 */       LAST_CORPSE_SPAWN_TICK.put(uuid, Long.valueOf(now));
/*  90 */       class_3218 level = player.method_51469();
/*  91 */       RustCorpseEntity corpse = new RustCorpseEntity(RustmineMod.CORPSE_ENTITY, (class_1937)level);
/*  92 */       corpse.method_5814(player.method_23317(), player.method_23318(), player.method_23321());
/*  93 */       corpse.deathGameTime = now;
/*  94 */       corpse.setup(player.method_5667(), player.method_5477().getString(), player.method_36454());
/*  95 */       int ticksAlive = player.method_14248().method_15025(class_3468.field_15419.method_14956(class_3468.field_15400));
/*  96 */       corpse.animalFat = 2 + Math.min(20, Math.max(0, ticksAlive / 3600));
/*     */       
/*     */       int i;
/*  99 */       for (i = 0; i < 24; i++) {
/* 100 */         int vanillaSlot = 9 + i;
/* 101 */         if (vanillaSlot < player.method_31548().method_5439()) {
/* 102 */           class_1799 stack = player.method_31548().method_5438(vanillaSlot);
/* 103 */           if (!stack.method_7960()) {
/* 104 */             corpse.container.method_5447(i, stack.method_7972());
/* 105 */             player.method_31548().method_5447(vanillaSlot, class_1799.field_8037);
/*     */           } 
/*     */         } 
/*     */       } 
/*     */ 
/*     */       
/* 111 */       for (i = 0; i < 6; i++) {
/* 112 */         class_1799 stack = player.method_31548().method_5438(i);
/* 113 */         if (!stack.method_7960()) {
/* 114 */           corpse.container.method_5447(24 + i, stack.method_7972());
/* 115 */           player.method_31548().method_5447(i, class_1799.field_8037);
/*     */         } 
/*     */       } 
/*     */ 
/*     */       
/* 120 */       class_2371<class_1799> wear = RustWearManager.getWear((class_1657)player);
/* 121 */       for (int j = 0; j < 7; j++) {
/* 122 */         class_1799 stack = (class_1799)wear.get(j);
/* 123 */         if (!stack.method_7960()) {
/* 124 */           corpse.container.method_5447(30 + j, stack.method_7972());
/* 125 */           wear.set(j, class_1799.field_8037);
/*     */         } 
/*     */       } 
/* 128 */       RustWearManager.sync(player);
/* 129 */       RustWearManager.save(level.method_8503());
/*     */ 
/*     */       
/* 132 */       player.method_31548().method_5448();
/*     */       
/* 134 */       corpse.updateWearSync();
/* 135 */       level.method_8649(corpse);
/* 136 */       return corpse;
/*     */     } finally {
/* 138 */       ACTIVE_DEATH_SPAWNS.remove(uuid);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void setup(UUID ownerUuid, String ownerName, float yaw) {
/* 143 */     this.field_6011.method_12778(OWNER_UUID, (ownerUuid != null) ? ownerUuid.toString() : "");
/* 144 */     this.field_6011.method_12778(OWNER_NAME, (ownerName != null) ? ownerName : "");
/* 145 */     this.field_6011.method_12778(YAW, Float.valueOf(yaw));
/* 146 */     method_36456(yaw);
/* 147 */     this.field_6011.method_12778(HEALTH, Float.valueOf(maxRustHealth()));
/* 148 */     if (this.deathGameTime <= 0L) {
/* 149 */       this.deathGameTime = method_73183().method_75260();
/*     */     }
/*     */   }
/*     */   
/*     */   public void setDeathGameTime(long deathGameTime) {
/* 154 */     this.deathGameTime = deathGameTime;
/*     */   }
/*     */   
/*     */   public long getDeathGameTime() {
/* 158 */     return this.deathGameTime;
/*     */   }
/*     */   
/*     */   public Optional<UUID> getOwnerUuid() {
/* 162 */     String u = (String)this.field_6011.method_12789(OWNER_UUID);
/* 163 */     if (u == null || u.isEmpty()) return Optional.empty(); 
/*     */     try {
/* 165 */       return Optional.of(UUID.fromString(u));
/* 166 */     } catch (Exception e) {
/* 167 */       return Optional.empty();
/*     */     } 
/*     */   }
/*     */   
/*     */   public String getOwnerName() {
/* 172 */     return (String)this.field_6011.method_12789(OWNER_NAME);
/*     */   }
/*     */   
/*     */   public float getCorpseYaw() {
/* 176 */     return ((Float)this.field_6011.method_12789(YAW)).floatValue();
/*     */   }
/*     */   
/*     */   public static RustAnimalData corpseData() {
/* 180 */     return RustAnimalData.get("player");
/*     */   }
/*     */   
/*     */   public float getHealth() {
/* 184 */     return ((Float)this.field_6011.method_12789(HEALTH)).floatValue();
/*     */   }
/*     */   
/*     */   public void setRustHealth(float hp) {
/* 188 */     this.field_6011.method_12778(HEALTH, Float.valueOf(hp));
/*     */   }
/*     */   
/*     */   public float maxRustHealth() {
/* 192 */     RustAnimalData d = corpseData();
/* 193 */     return (d != null) ? d.corpseHealth() : 100.0F;
/*     */   }
/*     */ 
/*     */   
/*     */   public void dropBackpackAndDiscard() {
/* 198 */     if (method_73183().method_8608() || method_31481())
/* 199 */       return;  if (!this.container.method_5442()) {
/* 200 */       RustBackpackEntity bp = new RustBackpackEntity(RustmineMod.BACKPACK_ENTITY, method_73183());
/* 201 */       bp.method_5814(method_23317(), method_23318(), method_23321());
/* 202 */       bp.setup(getOwnerName(), getCorpseYaw(), this.container);
/* 203 */       long corpseTicks = RustConfigManager.CORPSE_DESPAWN_TICKS;
/* 204 */       long now = method_73183().method_75260();
/* 205 */       bp.setSpawnGameTime((this.deathGameTime > 0L) ? Math.min(now, this.deathGameTime + corpseTicks) : now);
/* 206 */       if (!bp.method_31481()) {
/* 207 */         method_73183().method_8649(bp);
/*     */       }
/*     */     } 
/* 210 */     method_31472();
/*     */   }
/*     */ 
/*     */   
/*     */   public void harvest(class_3222 player, ToolStats tool) {
/* 215 */     RustAnimals.gatherCorpse(this, player, tool);
/*     */   }
/*     */   
/*     */   public class_1799 getWearItem(int slot) {
/* 219 */     switch (slot) { case 0: case 1: case 2: case 3: case 4: case 5: case 6:  }  return 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 227 */       class_1799.field_8037;
/*     */   }
/*     */ 
/*     */   
/*     */   private void updateWearSync() {
/* 232 */     if (method_73183().method_8608())
/* 233 */       return;  this.field_6011.method_12778(WEAR_0, this.container.method_5438(30));
/* 234 */     this.field_6011.method_12778(WEAR_1, this.container.method_5438(31));
/* 235 */     this.field_6011.method_12778(WEAR_2, this.container.method_5438(32));
/* 236 */     this.field_6011.method_12778(WEAR_3, this.container.method_5438(33));
/* 237 */     this.field_6011.method_12778(WEAR_4, this.container.method_5438(34));
/* 238 */     this.field_6011.method_12778(WEAR_5, this.container.method_5438(35));
/* 239 */     this.field_6011.method_12778(WEAR_6, this.container.method_5438(36));
/*     */   }
/*     */ 
/*     */   
/*     */   public void method_5773() {
/* 244 */     super.method_5773();
/* 245 */     if (!method_5740()) {
/* 246 */       method_18799(method_18798().method_1031(0.0D, -0.04D, 0.0D));
/*     */     }
/* 248 */     method_5784(class_1313.field_6308, method_18798());
/* 249 */     method_18799(method_18798().method_18805(0.98D, 0.98D, 0.98D));
/* 250 */     if (method_24828()) {
/* 251 */       method_18799(method_18798().method_18805(0.7D, 0.0D, 0.7D));
/*     */     }
/* 253 */     if (!method_73183().method_8608()) {
/* 254 */       checkDecayOrDespawn();
/*     */     }
/*     */   }
/*     */   
/*     */   private void checkDecayOrDespawn() {
/* 259 */     if (method_73183().method_8608() || method_31481())
/* 260 */       return;  long now = method_73183().method_75260();
/* 261 */     if (this.deathGameTime <= 0L || this.deathGameTime > now) {
/* 262 */       this.deathGameTime = now - this.ageTicks;
/*     */     }
/*     */     
/* 265 */     long corpseTicks = RustConfigManager.CORPSE_DESPAWN_TICKS;
/* 266 */     long backpackTicks = RustConfigManager.BACKPACK_DESPAWN_TICKS;
/* 267 */     long elapsed = now - this.deathGameTime;
/*     */ 
/*     */     
/* 270 */     if (elapsed < corpseTicks) {
/*     */       return;
/*     */     }
/*     */ 
/*     */     
/* 275 */     if (elapsed < corpseTicks + backpackTicks) {
/* 276 */       if (!this.container.method_5442()) {
/* 277 */         RustBackpackEntity bp = new RustBackpackEntity(RustmineMod.BACKPACK_ENTITY, method_73183());
/* 278 */         bp.method_5814(method_23317(), method_23318(), method_23321());
/* 279 */         bp.setup(getOwnerName(), getCorpseYaw(), this.container);
/* 280 */         bp.setSpawnGameTime(this.deathGameTime + corpseTicks);
/* 281 */         method_73183().method_8649(bp);
/*     */       } 
/* 283 */       method_31472();
/*     */       
/*     */       return;
/*     */     } 
/*     */     
/* 288 */     this.container.method_5448();
/* 289 */     method_31472();
/*     */   }
/*     */ 
/*     */   
/*     */   public class_1269 method_5688(class_1657 player, class_1268 hand) {
/* 294 */     if (method_73183().method_8608()) {
/* 295 */       return (class_1269)class_1269.field_5812;
/*     */     }
/*     */     
/* 298 */     if (player instanceof class_3222) { class_3222 sp = (class_3222)player;
/* 299 */       method_73183().method_43128(null, method_23317(), method_23318(), method_23321(), RustmineMod.CRATE_OPEN, class_3419.field_15248, 1.0F, 1.0F);
/* 300 */       String title = getOwnerName().isEmpty() ? "Труп" : ("Труп (" + getOwnerName() + ")");
/*     */       
/* 302 */       ServerPlayNetworking.send(sp, (class_8710)new RustDeployableOpenPayload(
/* 303 */             method_5628(), -3, 100.0F, 100.0F, false, title, ""));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 312 */       sp.method_17355((class_3908)new class_747((id, inv, p) -> new class_1707(class_3917.field_18667, id, inv, (class_1263)this.container, 5), 
/*     */             
/* 314 */             (class_2561)class_2561.method_43470(title))); }
/*     */ 
/*     */     
/* 317 */     return (class_1269)class_1269.field_5812;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean method_5863() {
/* 322 */     return !method_31481();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean method_5810() {
/* 327 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean method_64397(class_3218 level, class_1282 damageSource, float amount) {
/* 332 */     if (RustAnimals.hurtCorpse(this, level, damageSource, amount)) return true; 
/* 333 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean method_5732() {
/* 339 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void method_5693(class_2945.class_9222 builder) {
/* 344 */     builder.method_56912(OWNER_UUID, "");
/* 345 */     builder.method_56912(OWNER_NAME, "");
/* 346 */     builder.method_56912(YAW, Float.valueOf(0.0F));
/* 347 */     builder.method_56912(HEALTH, Float.valueOf(100.0F));
/* 348 */     builder.method_56912(WEAR_0, class_1799.field_8037);
/* 349 */     builder.method_56912(WEAR_1, class_1799.field_8037);
/* 350 */     builder.method_56912(WEAR_2, class_1799.field_8037);
/* 351 */     builder.method_56912(WEAR_3, class_1799.field_8037);
/* 352 */     builder.method_56912(WEAR_4, class_1799.field_8037);
/* 353 */     builder.method_56912(WEAR_5, class_1799.field_8037);
/* 354 */     builder.method_56912(WEAR_6, class_1799.field_8037);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void method_5749(class_11368 in) {
/* 359 */     this.field_6011.method_12778(OWNER_UUID, in.method_71428("OwnerUuid", ""));
/* 360 */     this.field_6011.method_12778(OWNER_NAME, in.method_71428("OwnerName", ""));
/* 361 */     this.field_6011.method_12778(YAW, Float.valueOf(in.method_71423("Yaw", 0.0F)));
/* 362 */     this.field_6011.method_12778(HEALTH, Float.valueOf(in.method_71423("Health", maxRustHealth())));
/* 363 */     this.destroyedFraction = in.method_71423("Destroyed", 0.0F);
/* 364 */     this.animalFat = in.method_71424("AnimalFat", 2);
/* 365 */     this.deathGameTime = in.method_71425("DeathGameTime", -1L);
/* 366 */     this.ageTicks = in.method_71424("AgeTicks", 0);
/* 367 */     if (this.deathGameTime <= 0L && this.ageTicks > 0) {
/* 368 */       this.deathGameTime = method_73183().method_75260() - this.ageTicks;
/*     */     }
/* 370 */     class_1262.method_5429(in, this.container.method_54454());
/* 371 */     updateWearSync();
/*     */     
/* 373 */     if (!method_73183().method_8608() && this.deathGameTime > 0L) {
/* 374 */       long now = method_73183().method_75260();
/* 375 */       long corpseTicks = RustConfigManager.CORPSE_DESPAWN_TICKS;
/* 376 */       long backpackTicks = RustConfigManager.BACKPACK_DESPAWN_TICKS;
/* 377 */       if (now - this.deathGameTime >= corpseTicks + backpackTicks) {
/* 378 */         this.container.method_5448();
/* 379 */         method_31472();
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected void method_5652(class_11372 out) {
/* 386 */     out.method_71469("OwnerUuid", (String)this.field_6011.method_12789(OWNER_UUID));
/* 387 */     out.method_71469("OwnerName", (String)this.field_6011.method_12789(OWNER_NAME));
/* 388 */     out.method_71464("Yaw", ((Float)this.field_6011.method_12789(YAW)).floatValue());
/* 389 */     out.method_71464("Health", ((Float)this.field_6011.method_12789(HEALTH)).floatValue());
/* 390 */     out.method_71464("Destroyed", this.destroyedFraction);
/* 391 */     out.method_71465("AnimalFat", this.animalFat);
/* 392 */     out.method_71466("DeathGameTime", this.deathGameTime);
/* 393 */     out.method_71465("AgeTicks", (int)Math.min(2147483647L, Math.max(0L, method_73183().method_75260() - this.deathGameTime)));
/* 394 */     class_1262.method_5426(out, this.container.method_54454());
/*     */   }
/*     */   
/*     */   public int method_5439() {
/* 398 */     return this.container.method_5439();
/* 399 */   } public boolean method_5442() { return this.container.method_5442(); } public class_1799 method_5438(int slot) {
/* 400 */     return this.container.method_5438(slot);
/*     */   } public class_1799 method_5434(int slot, int amount) {
/* 402 */     class_1799 res = this.container.method_5434(slot, amount);
/* 403 */     updateWearSync();
/* 404 */     return res;
/*     */   }
/*     */   public class_1799 method_5441(int slot) {
/* 407 */     class_1799 res = this.container.method_5441(slot);
/* 408 */     updateWearSync();
/* 409 */     return res;
/*     */   }
/*     */   public void method_5447(int slot, class_1799 stack) {
/* 412 */     this.container.method_5447(slot, stack);
/* 413 */     updateWearSync();
/*     */   }
/*     */   public void method_5431() {
/* 416 */     this.container.method_5431();
/* 417 */     updateWearSync();
/*     */   } public boolean method_5443(class_1657 player) {
/* 419 */     return (!method_31481() && method_5858((class_1297)player) <= 64.0D);
/*     */   } public void method_5448() {
/* 421 */     this.container.method_5448();
/* 422 */     updateWearSync();
/*     */   }
/*     */ }


/* Location:              C:\Users\SystemX\AppData\Local\IceCubeRust\game\mods\rustmine-0.1.2.jar!\net\rustmine\RustCorpseEntity.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */
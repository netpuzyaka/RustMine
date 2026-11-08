/*     */ package net.rustmine;
/*     */ 
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
/*     */ import net.rustmine.config.RustConfigManager;
/*     */ import net.rustmine.deploy.RustDeployableOpenPayload;
/*     */ 
/*     */ public class RustBackpackEntity
/*     */   extends class_1297 implements class_1263 {
/*     */   public static final int DESPAWN_TICKS = 72000;
/*  38 */   private static final class_2940<String> OWNER_NAME = class_2945.method_12791(RustBackpackEntity.class, class_2943.field_13326);
/*  39 */   private static final class_2940<Float> YAW = class_2945.method_12791(RustBackpackEntity.class, class_2943.field_13320);
/*     */   
/*  41 */   private static final class_2940<Boolean> POUCH = class_2945.method_12791(RustBackpackEntity.class, class_2943.field_13323);
/*     */   
/*  43 */   private final class_1277 container = new class_1277(45)
/*     */     {
/*     */       public void method_5431() {
/*  46 */         super.method_5431();
/*  47 */         if (!RustBackpackEntity.this.method_73183().method_8608() && method_5442())
/*  48 */           RustBackpackEntity.this.method_31472(); 
/*     */       }
/*     */     };
/*     */   
/*  52 */   private int ageTicks = 0;
/*  53 */   private long spawnGameTime = -1L;
/*     */   
/*     */   public RustBackpackEntity(class_1299<? extends RustBackpackEntity> type, class_1937 level) {
/*  56 */     super(type, level);
/*  57 */     this.field_23807 = true;
/*     */   }
/*     */   
/*     */   public void setup(String ownerName, float yaw, class_1277 sourceContainer) {
/*  61 */     this.field_6011.method_12778(OWNER_NAME, (ownerName != null) ? ownerName : "");
/*  62 */     this.field_6011.method_12778(YAW, Float.valueOf(yaw));
/*  63 */     if (this.spawnGameTime <= 0L) {
/*  64 */       this.spawnGameTime = method_73183().method_75260();
/*     */     }
/*  66 */     if (sourceContainer != null) {
/*  67 */       int limit = Math.min(this.container.method_5439(), sourceContainer.method_5439());
/*  68 */       for (int i = 0; i < limit; i++) {
/*  69 */         this.container.method_5447(i, sourceContainer.method_5438(i).method_7972());
/*     */       }
/*     */     } 
/*  72 */     if (this.container.method_5442()) {
/*  73 */       method_31472();
/*     */     }
/*     */   }
/*     */   
/*     */   public void setSpawnGameTime(long time) {
/*  78 */     this.spawnGameTime = time;
/*     */   }
/*     */   
/*     */   public long getSpawnGameTime() {
/*  82 */     return this.spawnGameTime;
/*     */   }
/*     */   
/*     */   public void setPouch() {
/*  86 */     this.field_6011.method_12778(POUCH, Boolean.valueOf(true));
/*     */   }
/*     */   
/*     */   public boolean isPouch() {
/*  90 */     return ((Boolean)this.field_6011.method_12789(POUCH)).booleanValue();
/*     */   }
/*     */   
/*     */   public String getOwnerName() {
/*  94 */     return (String)this.field_6011.method_12789(OWNER_NAME);
/*     */   }
/*     */   
/*     */   public float getBackpackYaw() {
/*  98 */     return ((Float)this.field_6011.method_12789(YAW)).floatValue();
/*     */   }
/*     */ 
/*     */   
/*     */   public void method_5773() {
/* 103 */     super.method_5773();
/* 104 */     if (!method_5740()) {
/* 105 */       method_18799(method_18798().method_1031(0.0D, -0.04D, 0.0D));
/*     */     }
/* 107 */     method_5784(class_1313.field_6308, method_18798());
/* 108 */     method_18799(method_18798().method_18805(0.98D, 0.98D, 0.98D));
/* 109 */     if (method_24828()) {
/* 110 */       method_18799(method_18798().method_18805(0.7D, 0.0D, 0.7D));
/*     */     }
/* 112 */     if (!method_73183().method_8608()) {
/* 113 */       if (this.container.method_5442()) {
/* 114 */         method_31472();
/*     */         return;
/*     */       } 
/* 117 */       long now = method_73183().method_75260();
/* 118 */       if (this.spawnGameTime <= 0L || this.spawnGameTime > now) {
/* 119 */         this.spawnGameTime = now - this.ageTicks;
/*     */       }
/* 121 */       long maxTicks = isPouch() ? RustConfigManager.POUCH_DESPAWN_TICKS : RustConfigManager.BACKPACK_DESPAWN_TICKS;
/* 122 */       if (now - this.spawnGameTime >= maxTicks) {
/* 123 */         method_31472();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public class_1269 method_5688(class_1657 player, class_1268 hand) {
/* 130 */     if (method_73183().method_8608()) {
/* 131 */       return (class_1269)class_1269.field_5812;
/*     */     }
/*     */     
/* 134 */     if (player instanceof class_3222) { class_3222 sp = (class_3222)player;
/* 135 */       method_73183().method_43128(null, method_23317(), method_23318(), method_23321(), RustmineMod.CRATE_OPEN, class_3419.field_15248, 1.0F, 1.0F);
/* 136 */       String title = getOwnerName().isEmpty() ? "Рюкзак" : ("Рюкзак (" + getOwnerName() + ")");
/*     */       
/* 138 */       ServerPlayNetworking.send(sp, (class_8710)new RustDeployableOpenPayload(
/* 139 */             method_5628(), -3, 100.0F, 100.0F, false, title, ""));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 148 */       sp.method_17355((class_3908)new class_747((id, inv, p) -> new class_1707(class_3917.field_18667, id, inv, (class_1263)this.container, 5), 
/*     */             
/* 150 */             (class_2561)class_2561.method_43470(title))); }
/*     */ 
/*     */     
/* 153 */     return (class_1269)class_1269.field_5812;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean method_5863() {
/* 158 */     return !method_31481();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean method_5810() {
/* 163 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean method_64397(class_3218 level, class_1282 damageSource, float amount) {
/* 168 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void method_5693(class_2945.class_9222 builder) {
/* 173 */     builder.method_56912(OWNER_NAME, "");
/* 174 */     builder.method_56912(YAW, Float.valueOf(0.0F));
/* 175 */     builder.method_56912(POUCH, Boolean.valueOf(false));
/*     */   }
/*     */ 
/*     */   
/*     */   protected void method_5749(class_11368 in) {
/* 180 */     this.field_6011.method_12778(OWNER_NAME, in.method_71428("OwnerName", ""));
/* 181 */     this.field_6011.method_12778(YAW, Float.valueOf(in.method_71423("Yaw", 0.0F)));
/* 182 */     this.field_6011.method_12778(POUCH, Boolean.valueOf(in.method_71433("Pouch", false)));
/* 183 */     this.spawnGameTime = in.method_71425("SpawnGameTime", -1L);
/* 184 */     this.ageTicks = in.method_71424("AgeTicks", 0);
/* 185 */     if (this.spawnGameTime <= 0L && this.ageTicks > 0) {
/* 186 */       this.spawnGameTime = method_73183().method_75260() - this.ageTicks;
/*     */     }
/* 188 */     class_1262.method_5429(in, this.container.method_54454());
/*     */     
/* 190 */     if (!method_73183().method_8608() && this.spawnGameTime > 0L) {
/* 191 */       long now = method_73183().method_75260();
/* 192 */       long maxTicks = isPouch() ? RustConfigManager.POUCH_DESPAWN_TICKS : RustConfigManager.BACKPACK_DESPAWN_TICKS;
/* 193 */       if (now - this.spawnGameTime >= maxTicks) {
/* 194 */         method_31472();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected void method_5652(class_11372 out) {
/* 201 */     out.method_71469("OwnerName", (String)this.field_6011.method_12789(OWNER_NAME));
/* 202 */     out.method_71464("Yaw", ((Float)this.field_6011.method_12789(YAW)).floatValue());
/* 203 */     out.method_71472("Pouch", ((Boolean)this.field_6011.method_12789(POUCH)).booleanValue());
/* 204 */     out.method_71466("SpawnGameTime", this.spawnGameTime);
/* 205 */     out.method_71465("AgeTicks", (int)Math.min(2147483647L, Math.max(0L, method_73183().method_75260() - this.spawnGameTime)));
/* 206 */     class_1262.method_5426(out, this.container.method_54454());
/*     */   }
/*     */   
/*     */   public int method_5439() {
/* 210 */     return this.container.method_5439();
/* 211 */   } public boolean method_5442() { return this.container.method_5442(); }
/* 212 */   public class_1799 method_5438(int slot) { return this.container.method_5438(slot); }
/* 213 */   public class_1799 method_5434(int slot, int amount) { return this.container.method_5434(slot, amount); }
/* 214 */   public class_1799 method_5441(int slot) { return this.container.method_5441(slot); }
/* 215 */   public void method_5447(int slot, class_1799 stack) { this.container.method_5447(slot, stack); }
/* 216 */   public void method_5431() { this.container.method_5431(); }
/* 217 */   public boolean method_5443(class_1657 player) { return (!method_31481() && method_5858((class_1297)player) <= 64.0D); } public void method_5448() {
/* 218 */     this.container.method_5448();
/*     */   }
/*     */ }


/* Location:              C:\Users\SystemX\AppData\Local\IceCubeRust\game\mods\rustmine-0.1.2.jar!\net\rustmine\RustBackpackEntity.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */
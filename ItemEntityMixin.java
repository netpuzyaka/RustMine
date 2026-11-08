/*     */ package net.rustmine.mixin;
/*     */ import net.minecraft.class_11368;
/*     */ import net.minecraft.class_11372;
/*     */ import net.minecraft.class_1297;
/*     */ import net.minecraft.class_1542;
/*     */ import net.minecraft.class_1799;
/*     */ import net.minecraft.class_1937;
/*     */ import net.minecraft.class_2338;
/*     */ import net.minecraft.class_238;
/*     */ import net.minecraft.class_243;
/*     */ import net.minecraft.class_2680;
/*     */ import net.minecraft.class_3532;
/*     */ import net.rustmine.building.Obb;
/*     */ import net.rustmine.config.RustConfigManager;
/*     */ import org.spongepowered.asm.mixin.Unique;
/*     */ import org.spongepowered.asm.mixin.injection.At;
/*     */ import org.spongepowered.asm.mixin.injection.Inject;
/*     */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
/*     */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
/*     */ 
/*     */ @Mixin({class_1542.class})
/*     */ public abstract class ItemEntityMixin implements RustDespawnableItem {
/*     */   @Unique
/*     */   private static final int GROUND_MAX = 1000;
/*     */   @Unique
/*  26 */   private long rustmine$spawnGameTime = -1L; @Shadow private int field_7204; @Shadow private int field_7202; @Unique
/*  27 */   private long rustmine$despawnTicks = -1L;
/*     */ 
/*     */   
/*     */   public long rustmine$getSpawnGameTime() {
/*  31 */     return this.rustmine$spawnGameTime;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rustmine$setSpawnGameTime(long time) {
/*  36 */     this.rustmine$spawnGameTime = time;
/*     */   }
/*     */ 
/*     */   
/*     */   public long rustmine$getDespawnTicks() {
/*  41 */     return this.rustmine$despawnTicks;
/*     */   }
/*     */ 
/*     */   
/*     */   public void rustmine$setDespawnTicks(long ticks) {
/*  46 */     this.rustmine$despawnTicks = ticks;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean rustmine$neverPickedUp() {
/*  51 */     return (this.field_7202 == 32767);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Redirect(method = {"method_5773"}, at = @At(value = "INVOKE", target = "Lnet/minecraft/class_1937;method_8587(Lnet/minecraft/class_1297;Lnet/minecraft/class_238;)Z"))
/*     */   private boolean rustmine$freeOfWholeBlocks(class_1937 level, class_1297 entity, class_238 box) {
/*  63 */     for (class_2338 pos : class_2338.method_10094(
/*  64 */         class_3532.method_15357(box.field_1323), class_3532.method_15357(box.field_1322), class_3532.method_15357(box.field_1321), 
/*  65 */         class_3532.method_15357(box.field_1320), class_3532.method_15357(box.field_1325), class_3532.method_15357(box.field_1324))) {
/*  66 */       if (level.method_8320(pos).method_26234((class_1922)level, pos)) return false; 
/*     */     } 
/*  68 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   @Inject(method = {"method_5773"}, at = {@At("TAIL")})
/*     */   private void rustmine$settle(CallbackInfo ci) {
/*  74 */     class_1542 self = (class_1542)this;
/*  75 */     if (self.method_31481() || !self.method_24828())
/*  76 */       return;  class_243 v = self.method_18798();
/*  77 */     self.method_18800(v.field_1352 * 0.5D, Math.min(v.field_1351, 0.0D), v.field_1350 * 0.5D);
/*     */   }
/*     */   
/*     */   @Inject(method = {"method_5773"}, at = {@At("TAIL")})
/*     */   private void rustmine$tickDespawn(CallbackInfo ci) {
/*  82 */     class_1542 self = (class_1542)this;
/*  83 */     if (self.method_73183().method_8608() || self.method_31481())
/*     */       return; 
/*  85 */     long now = self.method_73183().method_75260();
/*  86 */     if (this.rustmine$spawnGameTime <= 0L || this.rustmine$spawnGameTime > now) {
/*  87 */       this.rustmine$spawnGameTime = now;
/*     */     }
/*  89 */     if (this.rustmine$despawnTicks <= 0L) {
/*  90 */       this.rustmine$despawnTicks = RustConfigManager.getItemDespawnTicks(self.method_6983());
/*     */     }
/*     */     
/*  93 */     if (now - this.rustmine$spawnGameTime >= this.rustmine$despawnTicks) {
/*  94 */       self.method_31472();
/*     */       
/*     */       return;
/*     */     } 
/*     */     
/*  99 */     if (this.field_7204 >= 5000) {
/* 100 */       this.field_7204 = 1000;
/*     */     }
/*     */   }
/*     */   
/*     */   @Inject(method = {"method_5749"}, at = {@At("TAIL")})
/*     */   private void rustmine$readDespawnData(class_11368 in, CallbackInfo ci) {
/* 106 */     this.rustmine$spawnGameTime = in.method_71425("RustSpawnGameTime", -1L);
/* 107 */     this.rustmine$despawnTicks = in.method_71425("RustDespawnTicks", -1L);
/* 108 */     class_1542 self = (class_1542)this;
/* 109 */     if (!self.method_73183().method_8608()) {
/* 110 */       long now = self.method_73183().method_75260();
/* 111 */       if (this.rustmine$spawnGameTime > 0L) {
/* 112 */         long limit = (this.rustmine$despawnTicks > 0L) ? this.rustmine$despawnTicks : RustConfigManager.getItemDespawnTicks(self.method_6983());
/* 113 */         if (now - this.rustmine$spawnGameTime >= limit) {
/* 114 */           self.method_31472();
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   @Inject(method = {"method_5652"}, at = {@At("TAIL")})
/*     */   private void rustmine$saveDespawnData(class_11372 out, CallbackInfo ci) {
/* 122 */     out.method_71466("RustSpawnGameTime", this.rustmine$spawnGameTime);
/* 123 */     out.method_71466("RustDespawnTicks", this.rustmine$despawnTicks);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Inject(method = {"method_20397"}, at = {@At("HEAD")}, cancellable = true)
/*     */   private void rustmine$mergeAnyCount(CallbackInfoReturnable<Boolean> cir) {
/* 132 */     class_1542 self = (class_1542)this;
/* 133 */     long limit = (this.rustmine$despawnTicks > 0L) ? this.rustmine$despawnTicks : RustConfigManager.getItemDespawnTicks(self.method_6983());
/* 134 */     long now = self.method_73183().method_75260();
/* 135 */     boolean expired = (this.rustmine$spawnGameTime > 0L && now - this.rustmine$spawnGameTime >= limit);
/* 136 */     cir.setReturnValue(Boolean.valueOf((self.method_5805() && !expired && this.field_7202 != 32767 && this.field_7204 != -32768 && self.method_6983().method_7947() < 1000)));
/*     */   }
/*     */   
/*     */   @Inject(method = {"method_24017"}, at = {@At("HEAD")}, cancellable = true)
/*     */   private static void rustmine$sameKindMerges(class_1799 a, class_1799 b, CallbackInfoReturnable<Boolean> cir) {
/* 141 */     cir.setReturnValue(Boolean.valueOf((class_1799.method_31577(a, b) && a.method_7947() + b.method_7947() <= 1000)));
/*     */   }
/*     */ 
/*     */   
/*     */   @Inject(method = {"method_24018(Lnet/minecraft/class_1799;Lnet/minecraft/class_1799;I)Lnet/minecraft/class_1799;"}, at = {@At("HEAD")}, cancellable = true)
/*     */   private static void rustmine$mergeAll(class_1799 target, class_1799 source, int limit, CallbackInfoReturnable<class_1799> cir) {
/* 147 */     int moved = Math.min(source.method_7947(), 1000 - target.method_7947());
/* 148 */     class_1799 merged = target.method_46651(target.method_7947() + moved);
/* 149 */     source.method_7934(moved);
/* 150 */     cir.setReturnValue(merged);
/*     */   }
/*     */ 
/*     */   
/*     */   @Inject(method = {"method_5694"}, at = {@At("HEAD")}, cancellable = true)
/*     */   private void rustmine$noPickupByTouch(class_1657 player, CallbackInfo ci) {
/* 156 */     ci.cancel();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Inject(method = {"method_5773"}, at = {@At("HEAD")})
/*     */   private void rustmine$outOfMeshes(CallbackInfo ci) {
/* 166 */     class_1542 self = (class_1542)this;
/* 167 */     if (self.field_5960)
/*     */       return; 
/* 169 */     if (self.method_24828() && (self.method_18798()).field_1351 >= 0.0D)
/* 170 */       return;  class_1937 level = self.method_73183();
/* 171 */     class_238 box = self.method_5829();
/* 172 */     class_238 inner = box.method_1011(1.0E-4D);
/* 173 */     double top = Double.NEGATIVE_INFINITY;
/* 174 */     class_3726 ctx = class_3726.method_16195((class_1297)self);
/* 175 */     for (class_2338 pos : class_2338.method_10094(
/* 176 */         class_3532.method_15357(box.field_1323), class_3532.method_15357(box.field_1322), class_3532.method_15357(box.field_1321), 
/* 177 */         class_3532.method_15357(box.field_1320), class_3532.method_15357(box.field_1325), class_3532.method_15357(box.field_1324))) {
/* 178 */       class_2680 state = level.method_8320(pos);
/* 179 */       if (!(state.method_26204() instanceof net.rustmine.monument.baked.MonumentCellBlock))
/* 180 */         continue;  for (class_238 part : state.method_26194((class_1922)level, pos, ctx).method_66507((class_2382)pos).method_1090()) {
/* 181 */         if (part.method_994(inner)) top = Math.max(top, part.field_1325); 
/*     */       } 
/* 183 */     }  for (class_265 shape : MeshColliderManager.getCollisions(level, (class_1297)self, box)) {
/* 184 */       for (class_238 part : shape.method_1090()) {
/* 185 */         if (part.method_994(inner)) top = Math.max(top, part.field_1325); 
/*     */       } 
/* 187 */     }  for (Obb solid : BuildingCollision.solidsNear(level, box)) {
/* 188 */       if (BuildingCollision.intersects(solid, inner)) top = Math.max(top, solid.topAt(box)); 
/* 189 */     }  if (top > box.field_1322 && top - box.field_1322 <= 1.0D) {
/* 190 */       self.method_5814(self.method_23317(), top, self.method_23321());
/* 191 */       class_243 v = self.method_18798();
/* 192 */       if (v.field_1351 < 0.0D) self.method_18800(v.field_1352, 0.0D, v.field_1350); 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\SystemX\AppData\Local\IceCubeRust\game\mods\rustmine-0.1.2.jar!\net\rustmine\mixin\ItemEntityMixin.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */
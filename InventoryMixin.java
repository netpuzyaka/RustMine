/*     */ package net.rustmine.mixin;
/*     */ 
/*     */ import net.minecraft.class_1657;
/*     */ import net.minecraft.class_1799;
/*     */ import net.minecraft.class_3222;
/*     */ import net.rustmine.HoldRules;
/*     */ import net.rustmine.inventory.RustSlotFilter;
/*     */ import org.spongepowered.asm.mixin.Final;
/*     */ import org.spongepowered.asm.mixin.Shadow;
/*     */ import org.spongepowered.asm.mixin.injection.At;
/*     */ import org.spongepowered.asm.mixin.injection.Inject;
/*     */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
/*     */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
/*     */ 
/*     */ @Mixin({class_1661.class})
/*     */ abstract class InventoryMixin {
/*     */   @Shadow
/*     */   @Final
/*     */   public class_1657 field_7546;
/*     */   @Shadow
/*     */   @Final
/*     */   public class_2371<class_1799> field_7547;
/*     */   @Shadow
/*     */   public int field_7545;
/*     */   
/*  26 */   private boolean rustmine$hasRemainingSpace(class_1799 target, class_1799 source) { return (!target.method_7960() && 
/*  27 */       class_1799.method_31577(target, source) && target
/*  28 */       .method_7946() && target
/*  29 */       .method_7947() < target.method_7914()); } @Shadow
/*     */   public abstract class_1799 method_5438(int paramInt); @Shadow
/*     */   public abstract boolean method_7394(class_1799 paramclass_1799); @Shadow
/*     */   public abstract void method_61496(int paramInt); @Inject(method = {"method_61496"}, at = {@At("HEAD")}, cancellable = true)
/*     */   private void rustmine$noSelectSlotWhenWounded(int slot, CallbackInfo ci) {
/*  34 */     class_1657 class_16571 = this.field_7546; if (class_16571 instanceof class_3222) { class_3222 sp = (class_3222)class_16571; if (RustWoundedManager.isWounded(sp.method_5667()))
/*  35 */         ci.cancel();  }
/*     */   
/*     */   }
/*     */   
/*     */   @Inject(method = {"method_7365"}, at = {@At("HEAD")}, cancellable = true)
/*     */   private void rustmine$noPickSlotWhenWounded(int slot, CallbackInfo ci) {
/*  41 */     class_1657 class_16571 = this.field_7546; if (class_16571 instanceof class_3222) { class_3222 sp = (class_3222)class_16571; if (RustWoundedManager.isWounded(sp.method_5667()))
/*  42 */         ci.cancel();  }
/*     */   
/*     */   }
/*     */   
/*     */   @Inject(method = {"method_7376"}, at = {@At("HEAD")}, cancellable = true)
/*     */   private void rustmine$getFreeSlot(CallbackInfoReturnable<Integer> cir) {
/*  48 */     for (int i = 0; i < this.field_7547.size(); i++) {
/*  49 */       if (RustSlotFilter.isAllowedInventorySlot(i) && ((class_1799)this.field_7547.get(i)).method_7960()) {
/*  50 */         cir.setReturnValue(Integer.valueOf(i));
/*     */         return;
/*     */       } 
/*     */     } 
/*  54 */     cir.setReturnValue(Integer.valueOf(-1));
/*     */   }
/*     */   
/*     */   @Inject(method = {"method_7390"}, at = {@At("HEAD")}, cancellable = true)
/*     */   private void rustmine$getSlotWithRemainingSpace(class_1799 stack, CallbackInfoReturnable<Integer> cir) {
/*  59 */     if (this.field_7545 >= 0 && this.field_7545 <= 5 && rustmine$hasRemainingSpace(method_5438(this.field_7545), stack)) {
/*  60 */       cir.setReturnValue(Integer.valueOf(this.field_7545));
/*     */       return;
/*     */     } 
/*  63 */     for (int i = 0; i < this.field_7547.size(); i++) {
/*  64 */       if (RustSlotFilter.isAllowedInventorySlot(i) && rustmine$hasRemainingSpace((class_1799)this.field_7547.get(i), stack)) {
/*  65 */         cir.setReturnValue(Integer.valueOf(i));
/*     */         return;
/*     */       } 
/*     */     } 
/*  69 */     cir.setReturnValue(Integer.valueOf(-1));
/*     */   }
/*     */   
/*     */   @Inject(method = {"method_7395"}, at = {@At("HEAD")}, cancellable = true)
/*     */   private void rustmine$findSlotMatchingItem(class_1799 stack, CallbackInfoReturnable<Integer> cir) {
/*  74 */     for (int i = 0; i < this.field_7547.size(); i++) {
/*  75 */       if (RustSlotFilter.isAllowedInventorySlot(i)) {
/*  76 */         class_1799 cur = (class_1799)this.field_7547.get(i);
/*  77 */         if (!cur.method_7960() && class_1799.method_31577(stack, cur)) {
/*  78 */           cir.setReturnValue(Integer.valueOf(i));
/*     */           return;
/*     */         } 
/*     */       } 
/*     */     } 
/*  83 */     cir.setReturnValue(Integer.valueOf(-1));
/*     */   }
/*     */   
/*     */   @Inject(method = {"method_7367(ILnet/minecraft/class_1799;)Z"}, at = {@At("HEAD")}, cancellable = true)
/*     */   private void rustmine$addSlot(int slot, class_1799 stack, CallbackInfoReturnable<Boolean> cir) {
/*  88 */     if (slot != -1 && !RustSlotFilter.isAllowedInventorySlot(slot)) {
/*  89 */       cir.setReturnValue(Boolean.valueOf(false));
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   @Inject(method = {"method_61496"}, at = {@At("HEAD")}, cancellable = true)
/*     */   private void rustmine$onlyHoldable(int slot, CallbackInfo ci) {
/*  96 */     if (slot == -1) {
/*  97 */       this.field_7545 = -1;
/*  98 */       ci.cancel();
/*     */       return;
/*     */     } 
/* 101 */     if (slot < 0 || slot >= 6 || HoldRules.bypass() || slot == this.field_7545)
/* 102 */       return;  if (HoldRules.mayHold(this.field_7546, (class_1799)this.field_7547.get(slot)))
/* 103 */       return;  if (HoldRules.scrolling()) {
/* 104 */       int base = (this.field_7545 < 0) ? 0 : this.field_7545;
/* 105 */       int dir = (Math.floorMod(slot - base, 6) == 1) ? 1 : -1;
/* 106 */       for (int i = 1; i < 6; i++) {
/* 107 */         int next = Math.floorMod(base + dir * i, 6);
/* 108 */         if (HoldRules.mayHold(this.field_7546, (class_1799)this.field_7547.get(next))) {
/* 109 */           this.field_7545 = next;
/*     */           break;
/*     */         } 
/*     */       } 
/* 113 */       ci.cancel();
/*     */       return;
/*     */     } 
/* 116 */     ci.cancel();
/*     */   }
/*     */   
/*     */   @Inject(method = {"method_61496"}, at = {@At("HEAD")}, cancellable = true)
/*     */   private void rustmine$setSelectedSlot(int slot, CallbackInfo ci) {
/* 121 */     if (slot == -1) {
/* 122 */       this.field_7545 = -1;
/* 123 */       ci.cancel();
/*     */       return;
/*     */     } 
/* 126 */     if (slot < 0 || slot >= 6) {
/* 127 */       this.field_7545 = Math.floorMod(slot, 6);
/* 128 */       ci.cancel();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   @Inject(method = {"method_7391"}, at = {@At("HEAD")}, cancellable = true, require = 0)
/*     */   private void rustmine$nothingSelected(CallbackInfoReturnable<class_1799> cir) {
/* 135 */     if (this.field_7545 < 0) cir.setReturnValue(class_1799.field_8037); 
/*     */   }
/*     */   
/*     */   @Inject(method = {"method_7368"}, at = {@At("HEAD")}, cancellable = true)
/*     */   private static void rustmine$getSelectionSize(CallbackInfoReturnable<Integer> cir) {
/* 140 */     cir.setReturnValue(Integer.valueOf(6));
/*     */   }
/*     */   
/*     */   @Inject(method = {"method_7380"}, at = {@At("HEAD")}, cancellable = true)
/*     */   private static void rustmine$isHotbarSlot(int slot, CallbackInfoReturnable<Boolean> cir) {
/* 145 */     cir.setReturnValue(Boolean.valueOf((slot >= 0 && slot < 6)));
/*     */   }
/*     */   
/*     */   @Inject(method = {"method_7386"}, at = {@At("HEAD")}, cancellable = true)
/*     */   private void rustmine$getSuitableHotbarSlot(CallbackInfoReturnable<Integer> cir) {
/* 150 */     int base = Math.max(0, this.field_7545); int i;
/* 151 */     for (i = 0; i < 6; i++) {
/* 152 */       int candidate = (base + i) % 6;
/* 153 */       if (((class_1799)this.field_7547.get(candidate)).method_7960()) {
/* 154 */         cir.setReturnValue(Integer.valueOf(candidate));
/*     */         return;
/*     */       } 
/*     */     } 
/* 158 */     for (i = 0; i < 6; i++) {
/* 159 */       int candidate = (base + i) % 6;
/* 160 */       if (!((class_1799)this.field_7547.get(candidate)).method_7942()) {
/* 161 */         cir.setReturnValue(Integer.valueOf(candidate));
/*     */         return;
/*     */       } 
/*     */     } 
/* 165 */     cir.setReturnValue(Integer.valueOf(base % 6));
/*     */   }
/*     */   
/*     */   @Inject(method = {"method_7381"}, at = {@At("TAIL")})
/*     */   private void rustmine$cleanHiddenSlots(CallbackInfo ci) {
/* 170 */     for (int i = 0; i < this.field_7547.size(); i++) {
/* 171 */       if (!RustSlotFilter.isAllowedInventorySlot(i)) {
/* 172 */         class_1799 st = (class_1799)this.field_7547.get(i);
/* 173 */         if (!st.method_7960()) {
/* 174 */           this.field_7547.set(i, class_1799.field_8037);
/* 175 */           if (!method_7394(st))
/* 176 */             this.field_7546.method_7328(st, false); 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\SystemX\AppData\Local\IceCubeRust\game\mods\rustmine-0.1.2.jar!\net\rustmine\mixin\InventoryMixin.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */
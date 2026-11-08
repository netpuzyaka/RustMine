/*     */ package net.rustmine;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import net.minecraft.class_1657;
/*     */ import net.minecraft.class_1661;
/*     */ import net.minecraft.class_1792;
/*     */ import net.minecraft.class_1799;
/*     */ import net.minecraft.class_2477;
/*     */ import net.minecraft.class_2561;
/*     */ import net.minecraft.class_3222;
/*     */ import net.rustmine.config.RustConfigManager;
/*     */ import net.rustmine.deploy.RustDeployableEntity;
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
/*     */ public class Recipe
/*     */ {
/*     */   public final String id;
/*     */   public String name;
/*     */   public boolean autoName;
/*     */   public RustCrafting.Category category;
/*     */   public RustCrafting.WorkbenchTier tier;
/*     */   public int craftTimeSeconds;
/*     */   public final class_1799 result;
/*  72 */   public final List<RustCrafting.Ingredient> ingredients = new ArrayList<>();
/*     */   
/*     */   public Recipe(String id, String name, RustCrafting.Category category, RustCrafting.WorkbenchTier tier, int craftTimeSeconds, class_1799 result) {
/*  75 */     this.id = id;
/*  76 */     this.name = name;
/*  77 */     this.category = category;
/*  78 */     this.tier = tier;
/*  79 */     this.craftTimeSeconds = craftTimeSeconds;
/*  80 */     this.result = result;
/*     */   }
/*     */   
/*     */   public Recipe(String id, String name, class_1799 result) {
/*  84 */     this(id, name, RustCrafting.Category.ITEMS, RustCrafting.WorkbenchTier.NONE, 5, result);
/*     */   }
/*     */ 
/*     */   
/*     */   public String title() {
/*  89 */     if (!this.autoName && this.name != null && !this.name.isEmpty()) return this.name; 
/*  90 */     return class_2477.method_10517().method_48307(this.result.method_7909().method_7876());
/*     */   }
/*     */   
/*     */   public Recipe add(class_1792 item, int count) {
/*  94 */     this.ingredients.add(new RustCrafting.Ingredient(item, count));
/*  95 */     return this;
/*     */   }
/*     */   
/*     */   public int getIngredientCount(class_1661 inv, class_1792 item) {
/*  99 */     int has = 0;
/* 100 */     for (int i = 0; i < inv.method_5439(); i++) {
/* 101 */       class_1799 s = inv.method_5438(i);
/* 102 */       if (s.method_31574(item)) has += s.method_7947(); 
/*     */     } 
/* 104 */     return has;
/*     */   }
/*     */   
/*     */   public boolean isUnlocked(class_1657 player) {
/* 108 */     if (player == null || player.method_68878()) return true; 
/* 109 */     if (RustConfigManager.isDefaultUnlocked(this.id)) return true; 
/* 110 */     if (player.method_73183().method_8608()) {
/* 111 */       return (RustCrafting.clientUnlockCheck != null) ? RustCrafting.clientUnlockCheck.test(player, this.id) : true;
/*     */     }
/* 113 */     return RustResearchManager.isUnlocked(player, this.id);
/*     */   }
/*     */   
/*     */   public boolean canCraft(class_1661 inv) {
/* 117 */     return canCraft(inv, 1);
/*     */   }
/*     */   
/*     */   public boolean canCraft(class_1661 inv, int count) {
/* 121 */     if (count <= 0) return false; 
/* 122 */     for (RustCrafting.Ingredient ing : this.ingredients) {
/* 123 */       if (getIngredientCount(inv, ing.item) < ing.count * count) return false; 
/*     */     } 
/* 125 */     return true;
/*     */   }
/*     */   
/*     */   public boolean canCraft(class_1657 player) {
/* 129 */     return canCraft(player, 1);
/*     */   }
/*     */   
/*     */   public boolean canCraft(class_1657 player, int count) {
/* 133 */     if (player.method_68878()) return true; 
/* 134 */     if (!isUnlocked(player)) return false; 
/* 135 */     if (this.tier.level > 0 && RustDeployableEntity.getNearbyWorkbenchTier(player) < this.tier.level) {
/* 136 */       return false;
/*     */     }
/* 138 */     return canCraft(player.method_31548(), count);
/*     */   }
/*     */   
/*     */   public boolean craft(class_3222 player) {
/* 142 */     if (!canCraft((class_1657)player)) {
/* 143 */       if (this.tier.level > 0 && RustDeployableEntity.getNearbyWorkbenchTier((class_1657)player) < this.tier.level) {
/* 144 */         player.method_7353((class_2561)class_2561.method_43470("§cТребуется " + this.tier.displayName + "!"), true);
/*     */       }
/* 146 */       return false;
/*     */     } 
/*     */     
/* 149 */     class_1661 inv = player.method_31548();
/* 150 */     if (!player.method_68878())
/* 151 */       for (RustCrafting.Ingredient ing : this.ingredients) {
/* 152 */         int needed = ing.count;
/* 153 */         for (int i = 0; i < inv.method_5439(); i++) {
/* 154 */           class_1799 s = inv.method_5438(i);
/* 155 */           if (s.method_31574(ing.item)) {
/* 156 */             int take = Math.min(needed, s.method_7947());
/* 157 */             s.method_7934(take);
/* 158 */             needed -= take;
/* 159 */             if (needed <= 0) {
/*     */               break;
/*     */             }
/*     */           } 
/*     */         } 
/*     */       }  
/* 165 */     class_1799 res = this.result.method_7972();
/* 166 */     if (!inv.method_7394(res)) {
/* 167 */       player.method_7328(res, false);
/*     */     }
/* 169 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Users\SystemX\AppData\Local\IceCubeRust\game\mods\rustmine-0.1.2.jar!\net\rustmine\RustCrafting$Recipe.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */
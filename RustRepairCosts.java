/*     */ package net.rustmine;
/*     */ 
/*     */ import java.util.List;
/*     */ import net.minecraft.class_1657;
/*     */ import net.minecraft.class_1661;
/*     */ import net.minecraft.class_1792;
/*     */ import net.minecraft.class_1799;
/*     */ import net.rustmine.combat.RustWeapons;
/*     */ 
/*     */ public final class RustRepairCosts {
/*     */   public static final class CostEntry extends Record {
/*     */     private final String recipeId;
/*     */     private final List<RustCrafting.Ingredient> ingredients;
/*     */     
/*     */     public final String toString() {
/*     */       // Byte code:
/*     */       //   0: aload_0
/*     */       //   1: <illegal opcode> toString : (Lnet/rustmine/RustRepairCosts$CostEntry;)Ljava/lang/String;
/*     */       //   6: areturn
/*     */       // Line number table:
/*     */       //   Java source line number -> byte code offset
/*     */       //   #23	-> 0
/*     */       // Local variable table:
/*     */       //   start	length	slot	name	descriptor
/*     */       //   0	7	0	this	Lnet/rustmine/RustRepairCosts$CostEntry;
/*     */     }
/*     */     
/*     */     public final int hashCode() {
/*     */       // Byte code:
/*     */       //   0: aload_0
/*     */       //   1: <illegal opcode> hashCode : (Lnet/rustmine/RustRepairCosts$CostEntry;)I
/*     */       //   6: ireturn
/*     */       // Line number table:
/*     */       //   Java source line number -> byte code offset
/*     */       //   #23	-> 0
/*     */       // Local variable table:
/*     */       //   start	length	slot	name	descriptor
/*     */       //   0	7	0	this	Lnet/rustmine/RustRepairCosts$CostEntry;
/*     */     }
/*     */     
/*  23 */     public CostEntry(String recipeId, List<RustCrafting.Ingredient> ingredients) { this.recipeId = recipeId; this.ingredients = ingredients; } public final boolean equals(Object o) { // Byte code:
/*     */       //   0: aload_0
/*     */       //   1: aload_1
/*     */       //   2: <illegal opcode> equals : (Lnet/rustmine/RustRepairCosts$CostEntry;Ljava/lang/Object;)Z
/*     */       //   7: ireturn
/*     */       // Line number table:
/*     */       //   Java source line number -> byte code offset
/*     */       //   #23	-> 0
/*     */       // Local variable table:
/*     */       //   start	length	slot	name	descriptor
/*     */       //   0	8	0	this	Lnet/rustmine/RustRepairCosts$CostEntry;
/*  23 */       //   0	8	1	o	Ljava/lang/Object; } public String recipeId() { return this.recipeId; } public List<RustCrafting.Ingredient> ingredients() { return this.ingredients; }
/*     */      }
/*  25 */   private static final Map<class_1792, CostEntry> ENTRIES = new HashMap<>();
/*     */ 
/*     */   
/*     */   static {
/*  29 */     reg(RustWeapons.AK, "ak47", List.of(new RustCrafting.Ingredient(RustmineMod.RES_HQM, 13), new RustCrafting.Ingredient(RustmineMod.RES_WOOD, 50), new RustCrafting.Ingredient(RustmineMod.RES_METAL, 50)));
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  34 */     reg(RustWeapons.BOLT, "bolt", List.of(new RustCrafting.Ingredient(RustmineMod.RES_HQM, 10), new RustCrafting.Ingredient(RustmineMod.RES_METAL, 50)));
/*     */ 
/*     */ 
/*     */     
/*  38 */     reg(RustWeapons.SAR, "sar", List.of(new RustCrafting.Ingredient(RustmineMod.RES_METAL, 100), new RustCrafting.Ingredient(RustmineMod.RES_WOOD, 25)));
/*     */ 
/*     */ 
/*     */     
/*  42 */     reg(RustWeapons.SAP, "sap", List.of(new RustCrafting.Ingredient(RustmineMod.RES_METAL, 60), new RustCrafting.Ingredient(RustmineMod.RES_HQM, 1)));
/*     */ 
/*     */ 
/*     */     
/*  46 */     reg(RustWeapons.THOMPSON, "thompson", List.of(new RustCrafting.Ingredient(RustmineMod.RES_METAL, 75), new RustCrafting.Ingredient(RustmineMod.RES_WOOD, 25)));
/*     */ 
/*     */ 
/*     */     
/*  50 */     reg(RustWeapons.SMG, "custom_smg", List.of(new RustCrafting.Ingredient(RustmineMod.RES_METAL, 60), new RustCrafting.Ingredient(RustmineMod.RES_HQM, 2)));
/*     */ 
/*     */ 
/*     */     
/*  54 */     reg(RustWeapons.MP5, "mp5", List.of(new RustCrafting.Ingredient(RustmineMod.RES_HQM, 10), new RustCrafting.Ingredient(RustmineMod.RES_METAL, 50)));
/*     */ 
/*     */ 
/*     */     
/*  58 */     reg(RustWeapons.PYTHON, "python", List.of(new RustCrafting.Ingredient(RustmineMod.RES_METAL, 50), new RustCrafting.Ingredient(RustmineMod.RES_HQM, 2)));
/*     */ 
/*     */ 
/*     */     
/*  62 */     reg(RustWeapons.REVOLVER, "revolver", List.of(new RustCrafting.Ingredient(RustmineMod.RES_METAL, 40), new RustCrafting.Ingredient(RustmineMod.RES_CLOTH, 10)));
/*     */ 
/*     */ 
/*     */     
/*  66 */     reg(RustWeapons.PUMP_SHOTGUN, "pump_shotgun", List.of(new RustCrafting.Ingredient(RustmineMod.RES_METAL, 60)));
/*     */ 
/*     */     
/*  69 */     reg(RustWeapons.DOUBLE_BARREL, "double_barrel", List.of(new RustCrafting.Ingredient(RustmineMod.RES_METAL, 50), new RustCrafting.Ingredient(RustmineMod.RES_WOOD, 40)));
/*     */ 
/*     */ 
/*     */     
/*  73 */     reg(RustWeapons.WATERPIPE, "waterpipe", List.of(new RustCrafting.Ingredient(RustmineMod.RES_WOOD, 40), new RustCrafting.Ingredient(RustmineMod.RES_METAL, 20)));
/*     */ 
/*     */ 
/*     */     
/*  77 */     reg(RustWeapons.EOKA, "eoka", List.of(new RustCrafting.Ingredient(RustmineMod.RES_WOOD, 20), new RustCrafting.Ingredient(RustmineMod.RES_METAL, 10)));
/*     */ 
/*     */ 
/*     */     
/*  81 */     reg(RustWeapons.BOW, "hunting_bow", List.of(new RustCrafting.Ingredient(RustmineMod.RES_WOOD, 40), new RustCrafting.Ingredient(RustmineMod.RES_CLOTH, 10)));
/*     */ 
/*     */ 
/*     */     
/*  85 */     reg(RustWeapons.CROSSBOW, "crossbow", List.of(new RustCrafting.Ingredient(RustmineMod.RES_WOOD, 40), new RustCrafting.Ingredient(RustmineMod.RES_METAL, 15)));
/*     */ 
/*     */ 
/*     */     
/*  89 */     reg(RustWeapons.ROCKET_LAUNCHER, "rocket_launcher", List.of(new RustCrafting.Ingredient(RustmineMod.RES_HQM, 20), new RustCrafting.Ingredient(RustmineMod.RES_METAL, 100)));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  95 */     reg(RustWeapons.L96, null, List.of(new RustCrafting.Ingredient(RustmineMod.RES_HQM, 15), new RustCrafting.Ingredient(RustmineMod.RES_METAL, 100)));
/*     */ 
/*     */ 
/*     */     
/*  99 */     reg(RustWeapons.M39, null, List.of(new RustCrafting.Ingredient(RustmineMod.RES_HQM, 15), new RustCrafting.Ingredient(RustmineMod.RES_METAL, 100)));
/*     */ 
/*     */ 
/*     */     
/* 103 */     reg(RustWeapons.M249, null, List.of(new RustCrafting.Ingredient(RustmineMod.RES_HQM, 25), new RustCrafting.Ingredient(RustmineMod.RES_METAL, 150)));
/*     */ 
/*     */ 
/*     */     
/* 107 */     reg(RustWeapons.LR300, null, List.of(new RustCrafting.Ingredient(RustmineMod.RES_HQM, 20), new RustCrafting.Ingredient(RustmineMod.RES_METAL, 100)));
/*     */ 
/*     */ 
/*     */     
/* 111 */     reg(RustWeapons.M92, null, List.of(new RustCrafting.Ingredient(RustmineMod.RES_HQM, 10), new RustCrafting.Ingredient(RustmineMod.RES_METAL, 50)));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 117 */     reg(RustmineMod.TOOL_HATCHET, "hatchet_metal", List.of(new RustCrafting.Ingredient(RustmineMod.RES_METAL, 25), new RustCrafting.Ingredient(RustmineMod.RES_WOOD, 25)));
/*     */ 
/*     */ 
/*     */     
/* 121 */     reg(RustmineMod.TOOL_PICKAXE, "pickaxe_metal", List.of(new RustCrafting.Ingredient(RustmineMod.RES_METAL, 25), new RustCrafting.Ingredient(RustmineMod.RES_WOOD, 25)));
/*     */ 
/*     */ 
/*     */     
/* 125 */     reg(RustmineMod.TOOL_SALVAGED_AXE, "salvaged_axe", List.of(new RustCrafting.Ingredient(RustmineMod.RES_METAL, 35), new RustCrafting.Ingredient(RustmineMod.COMP_BLADE, 1)));
/*     */ 
/*     */ 
/*     */     
/* 129 */     reg(RustmineMod.TOOL_SALVAGED_ICEPICK, "salvaged_icepick", List.of(new RustCrafting.Ingredient(RustmineMod.RES_METAL, 35), new RustCrafting.Ingredient(RustmineMod.COMP_BLADE, 1)));
/*     */ 
/*     */ 
/*     */     
/* 133 */     reg(RustmineMod.TOOL_SALVAGED_HAMMER, "salvaged_hammer", List.of(new RustCrafting.Ingredient(RustmineMod.RES_METAL, 30)));
/*     */ 
/*     */     
/* 136 */     reg(RustmineMod.TOOL_STONE_HATCHET, "hatchet_stone", List.of(new RustCrafting.Ingredient(RustmineMod.RES_WOOD, 30), new RustCrafting.Ingredient(RustmineMod.RES_STONES, 50)));
/*     */ 
/*     */ 
/*     */     
/* 140 */     reg(RustmineMod.TOOL_STONE_PICKAXE, "pickaxe_stone", List.of(new RustCrafting.Ingredient(RustmineMod.RES_WOOD, 30), new RustCrafting.Ingredient(RustmineMod.RES_STONES, 50)));
/*     */ 
/*     */ 
/*     */     
/* 144 */     reg(RustmineMod.HAMMER, "hammer", List.of(new RustCrafting.Ingredient(RustmineMod.RES_WOOD, 20)));
/*     */ 
/*     */     
/* 147 */     reg(RustmineMod.TOOL_COMBAT_KNIFE, "combat_knife", List.of(new RustCrafting.Ingredient(RustmineMod.RES_METAL, 15)));
/*     */ 
/*     */     
/* 150 */     reg(RustmineMod.TOOL_BONE_KNIFE, "bone_knife", List.of(new RustCrafting.Ingredient(RustmineMod.RES_BONE, 15)));
/*     */ 
/*     */     
/* 153 */     reg(RustmineMod.TOOL_CHAINSAW, "chainsaw", List.of(new RustCrafting.Ingredient(RustmineMod.RES_METAL, 40), new RustCrafting.Ingredient(RustmineMod.RES_HQM, 2)));
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 158 */     reg(RustmineMod.TOOL_JACKHAMMER, null, List.of());
/* 159 */     reg(RustmineMod.TOOL_ROCK, null, List.of(new RustCrafting.Ingredient(RustmineMod.RES_STONES, 10)));
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 164 */     reg(RustmineMod.ARMOR_METAL_FACEMASK, "metal_facemask", List.of(new RustCrafting.Ingredient(RustmineMod.RES_HQM, 4), new RustCrafting.Ingredient(RustmineMod.COMP_SEWING_KIT, 1)));
/*     */ 
/*     */ 
/*     */     
/* 168 */     reg(RustmineMod.ARMOR_METAL_CHEST, "metal_chestplate", List.of(new RustCrafting.Ingredient(RustmineMod.RES_HQM, 6), new RustCrafting.Ingredient(RustmineMod.COMP_SEWING_KIT, 2)));
/*     */ 
/*     */ 
/*     */     
/* 172 */     reg(RustmineMod.ARMOR_ROADSIGN_JACKET, "roadsign_jacket", List.of(new RustCrafting.Ingredient(RustmineMod.COMP_ROAD_SIGNS, 1), new RustCrafting.Ingredient(RustmineMod.COMP_SEWING_KIT, 1)));
/*     */ 
/*     */ 
/*     */     
/* 176 */     reg(RustmineMod.ARMOR_ROADSIGN_KILT, "roadsign_kilt", List.of(new RustCrafting.Ingredient(RustmineMod.COMP_ROAD_SIGNS, 1), new RustCrafting.Ingredient(RustmineMod.COMP_SEWING_KIT, 1)));
/*     */ 
/*     */ 
/*     */     
/* 180 */     reg(RustmineMod.ARMOR_COFFEECAN, "coffeecan", List.of(new RustCrafting.Ingredient(RustmineMod.RES_METAL, 15), new RustCrafting.Ingredient(RustmineMod.COMP_SEWING_KIT, 1)));
/*     */ 
/*     */ 
/*     */     
/* 184 */     reg(RustmineMod.ARMOR_HAZMAT, "hazmat", List.of(new RustCrafting.Ingredient(RustmineMod.RES_HQM, 2), new RustCrafting.Ingredient(RustmineMod.COMP_TARP, 1)));
/*     */ 
/*     */ 
/*     */     
/* 188 */     reg(RustmineMod.ARMOR_HEAVY_PLATE_HELMET, "heavy_plate_helmet", List.of(new RustCrafting.Ingredient(RustmineMod.RES_HQM, 2), new RustCrafting.Ingredient(RustmineMod.RES_METAL, 25)));
/*     */ 
/*     */ 
/*     */     
/* 192 */     reg(RustmineMod.ARMOR_HEAVY_PLATE_JACKET, "heavy_plate_jacket", List.of(new RustCrafting.Ingredient(RustmineMod.RES_HQM, 3), new RustCrafting.Ingredient(RustmineMod.RES_METAL, 40)));
/*     */ 
/*     */ 
/*     */     
/* 196 */     reg(RustmineMod.ARMOR_HEAVY_PLATE_PANTS, "heavy_plate_pants", List.of(new RustCrafting.Ingredient(RustmineMod.RES_HQM, 2), new RustCrafting.Ingredient(RustmineMod.RES_METAL, 25)));
/*     */ 
/*     */ 
/*     */     
/* 200 */     reg(RustmineMod.ARMOR_WOOD_HELMET, "wood_helmet", List.of(new RustCrafting.Ingredient(RustmineMod.RES_WOOD, 50)));
/*     */ 
/*     */     
/* 203 */     reg(RustmineMod.ARMOR_WOOD_CHEST, "wood_chestplate", List.of(new RustCrafting.Ingredient(RustmineMod.RES_WOOD, 60)));
/*     */ 
/*     */     
/* 206 */     reg(RustmineMod.ARMOR_WOOD_PANTS, "wood_pants", List.of(new RustCrafting.Ingredient(RustmineMod.RES_WOOD, 50)));
/*     */ 
/*     */     
/* 209 */     reg(RustmineMod.ARMOR_BONE_HELMET, "bone_helmet", List.of(new RustCrafting.Ingredient(RustmineMod.RES_BONE, 10)));
/*     */ 
/*     */     
/* 212 */     reg(RustmineMod.ARMOR_BONE_SUIT, "bone_armor", List.of(new RustCrafting.Ingredient(RustmineMod.RES_BONE, 20)));
/*     */ 
/*     */     
/* 215 */     reg(RustmineMod.ARMOR_HOODIE, "hoodie", List.of(new RustCrafting.Ingredient(RustmineMod.RES_CLOTH, 20)));
/*     */ 
/*     */     
/* 218 */     reg(RustmineMod.ARMOR_PANTS, "pants", List.of(new RustCrafting.Ingredient(RustmineMod.RES_CLOTH, 20)));
/*     */ 
/*     */     
/* 221 */     reg(RustmineMod.ARMOR_BOOTS, "boots", List.of(new RustCrafting.Ingredient(RustmineMod.RES_LEATHER, 15)));
/*     */ 
/*     */     
/* 224 */     reg(RustmineMod.ARMOR_GLOVES, "gloves", List.of(new RustCrafting.Ingredient(RustmineMod.RES_LEATHER, 10)));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/* 229 */   private static BiPredicate<class_1657, String> clientUnlockCheck = null;
/*     */   
/*     */   public static void setClientUnlockCheck(BiPredicate<class_1657, String> check) {
/* 232 */     clientUnlockCheck = check;
/*     */   }
/*     */   
/*     */   private static void reg(class_1792 item, String recipeId, List<RustCrafting.Ingredient> ingredients) {
/* 236 */     ENTRIES.put(item, new CostEntry(recipeId, ingredients));
/*     */   }
/*     */   
/*     */   public static CostEntry getCost(class_1799 stack) {
/* 240 */     if (stack.method_7960()) return null; 
/* 241 */     CostEntry e = ENTRIES.get(stack.method_7909());
/* 242 */     if (e != null) return e;
/*     */     
/* 244 */     if (GunAmmo.isGun(stack) || RustWeapons.GUNS.containsKey(stack.method_7909())) {
/* 245 */       return new CostEntry(null, List.of(new RustCrafting.Ingredient(RustmineMod.RES_METAL, 50)));
/*     */     }
/* 247 */     if (RustmineItems.TOOLS.containsKey(stack.method_7909())) {
/* 248 */       return new CostEntry(null, List.of(new RustCrafting.Ingredient(RustmineMod.RES_METAL, 25)));
/*     */     }
/* 250 */     if (RustArmorStats.get(stack.method_7909()) != null) {
/* 251 */       return new CostEntry(null, List.of(new RustCrafting.Ingredient(RustmineMod.RES_CLOTH, 20)));
/*     */     }
/* 253 */     return null;
/*     */   }
/*     */   
/*     */   public static boolean isBlueprintUnlocked(class_1657 player, class_1799 stack) {
/* 257 */     if (player == null || player.method_68878()) return true; 
/* 258 */     CostEntry entry = getCost(stack);
/* 259 */     if (entry == null || entry.recipeId() == null) return true; 
/* 260 */     if (player.method_73183().method_8608()) {
/* 261 */       return (clientUnlockCheck != null) ? clientUnlockCheck.test(player, entry.recipeId()) : true;
/*     */     }
/* 263 */     return RustResearchManager.isUnlocked(player, entry.recipeId());
/*     */   }
/*     */   
/*     */   public static boolean hasRequiredIngredients(class_1657 player, class_1799 stack) {
/* 267 */     if (player == null || player.method_68878()) return true; 
/* 268 */     CostEntry entry = getCost(stack);
/* 269 */     if (entry == null) return false; 
/* 270 */     class_1661 inv = player.method_31548();
/* 271 */     for (RustCrafting.Ingredient ing : entry.ingredients()) {
/* 272 */       int has = 0;
/* 273 */       for (int i = 0; i < inv.method_5439(); i++) {
/* 274 */         class_1799 s = inv.method_5438(i);
/* 275 */         if (s.method_31574(ing.item())) {
/* 276 */           has += s.method_7947();
/*     */         }
/*     */       } 
/* 279 */       if (has < ing.count()) return false; 
/*     */     } 
/* 281 */     return true;
/*     */   }
/*     */   
/*     */   public static boolean consumeIngredients(class_1657 player, class_1799 stack) {
/* 285 */     if (player.method_68878()) return true; 
/* 286 */     CostEntry entry = getCost(stack);
/* 287 */     if (entry == null) return false; 
/* 288 */     if (!hasRequiredIngredients(player, stack)) return false;
/*     */     
/* 290 */     class_1661 inv = player.method_31548();
/* 291 */     for (RustCrafting.Ingredient ing : entry.ingredients()) {
/* 292 */       int needed = ing.count();
/* 293 */       if (player instanceof class_3222) { class_3222 sp = (class_3222)player;
/* 294 */         String id = class_7923.field_41178.method_10221(ing.item()).toString();
/* 295 */         ServerPlayNetworking.send(sp, new RustItemNoticePayload(id, -needed)); }
/*     */       
/* 297 */       for (int i = 0; i < inv.method_5439(); i++) {
/* 298 */         class_1799 s = inv.method_5438(i);
/* 299 */         if (s.method_31574(ing.item())) {
/* 300 */           int take = Math.min(needed, s.method_7947());
/* 301 */           s.method_7934(take);
/* 302 */           needed -= take;
/* 303 */           if (needed <= 0)
/*     */             break; 
/*     */         } 
/*     */       } 
/* 307 */     }  return true;
/*     */   }
/*     */ }


/* Location:              C:\Users\SystemX\AppData\Local\IceCubeRust\game\mods\rustmine-0.1.2.jar!\net\rustmine\RustRepairCosts.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */
/*     */ package net.rustmine;
/*     */ import com.google.gson.JsonArray;
/*     */ import com.google.gson.JsonElement;
/*     */ import com.google.gson.JsonObject;
/*     */ import com.google.gson.JsonParser;
/*     */ import java.io.InputStream;
/*     */ import java.nio.charset.StandardCharsets;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.LinkedHashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import net.minecraft.class_1792;
/*     */ import net.minecraft.class_1799;
/*     */ import net.minecraft.class_1802;
/*     */ import net.minecraft.class_1935;
/*     */ import net.minecraft.class_7923;
/*     */ import net.rustmine.config.RustConfigManager;
/*     */ 
/*     */ public final class RustBlueprints {
/*     */   public static final class Ingredient extends Record {
/*     */     private final String item;
/*     */     private final int amount;
/*     */     
/*  26 */     public Ingredient(String item, int amount) { this.item = item; this.amount = amount; } public final String toString() { // Byte code:
/*     */       //   0: aload_0
/*     */       //   1: <illegal opcode> toString : (Lnet/rustmine/RustBlueprints$Ingredient;)Ljava/lang/String;
/*     */       //   6: areturn
/*     */       // Line number table:
/*     */       //   Java source line number -> byte code offset
/*     */       //   #26	-> 0
/*     */       // Local variable table:
/*     */       //   start	length	slot	name	descriptor
/*     */       //   0	7	0	this	Lnet/rustmine/RustBlueprints$Ingredient; } public final int hashCode() { // Byte code:
/*     */       //   0: aload_0
/*     */       //   1: <illegal opcode> hashCode : (Lnet/rustmine/RustBlueprints$Ingredient;)I
/*     */       //   6: ireturn
/*     */       // Line number table:
/*     */       //   Java source line number -> byte code offset
/*     */       //   #26	-> 0
/*     */       // Local variable table:
/*     */       //   start	length	slot	name	descriptor
/*     */       //   0	7	0	this	Lnet/rustmine/RustBlueprints$Ingredient; } public final boolean equals(Object o) { // Byte code:
/*     */       //   0: aload_0
/*     */       //   1: aload_1
/*     */       //   2: <illegal opcode> equals : (Lnet/rustmine/RustBlueprints$Ingredient;Ljava/lang/Object;)Z
/*     */       //   7: ireturn
/*     */       // Line number table:
/*     */       //   Java source line number -> byte code offset
/*     */       //   #26	-> 0
/*     */       // Local variable table:
/*     */       //   start	length	slot	name	descriptor
/*     */       //   0	8	0	this	Lnet/rustmine/RustBlueprints$Ingredient;
/*  26 */       //   0	8	1	o	Ljava/lang/Object; } public String item() { return this.item; } public int amount() { return this.amount; }
/*  27 */   } public static final class Blueprint extends Record { private final float time; private final int amount; private final int workbench; private final boolean def; private final boolean craftable; private final boolean researchable; private final int category; private final int rarity; private final int scrapFromRecycle; private final List<RustBlueprints.Ingredient> ingredients; public Blueprint(float time, int amount, int workbench, boolean def, boolean craftable, boolean researchable, int category, int rarity, int scrapFromRecycle, List<RustBlueprints.Ingredient> ingredients) { this.time = time; this.amount = amount; this.workbench = workbench; this.def = def; this.craftable = craftable; this.researchable = researchable; this.category = category; this.rarity = rarity; this.scrapFromRecycle = scrapFromRecycle; this.ingredients = ingredients; } public final String toString() { // Byte code:
/*     */       //   0: aload_0
/*     */       //   1: <illegal opcode> toString : (Lnet/rustmine/RustBlueprints$Blueprint;)Ljava/lang/String;
/*     */       //   6: areturn
/*     */       // Line number table:
/*     */       //   Java source line number -> byte code offset
/*     */       //   #27	-> 0
/*     */       // Local variable table:
/*     */       //   start	length	slot	name	descriptor
/*     */       //   0	7	0	this	Lnet/rustmine/RustBlueprints$Blueprint; } public final int hashCode() { // Byte code:
/*     */       //   0: aload_0
/*     */       //   1: <illegal opcode> hashCode : (Lnet/rustmine/RustBlueprints$Blueprint;)I
/*     */       //   6: ireturn
/*     */       // Line number table:
/*     */       //   Java source line number -> byte code offset
/*     */       //   #27	-> 0
/*     */       // Local variable table:
/*     */       //   start	length	slot	name	descriptor
/*     */       //   0	7	0	this	Lnet/rustmine/RustBlueprints$Blueprint; } public final boolean equals(Object o) { // Byte code:
/*     */       //   0: aload_0
/*     */       //   1: aload_1
/*     */       //   2: <illegal opcode> equals : (Lnet/rustmine/RustBlueprints$Blueprint;Ljava/lang/Object;)Z
/*     */       //   7: ireturn
/*     */       // Line number table:
/*     */       //   Java source line number -> byte code offset
/*     */       //   #27	-> 0
/*     */       // Local variable table:
/*     */       //   start	length	slot	name	descriptor
/*     */       //   0	8	0	this	Lnet/rustmine/RustBlueprints$Blueprint;
/*  27 */       //   0	8	1	o	Ljava/lang/Object; } public float time() { return this.time; } public int amount() { return this.amount; } public int workbench() { return this.workbench; } public boolean def() { return this.def; } public boolean craftable() { return this.craftable; } public boolean researchable() { return this.researchable; } public int category() { return this.category; } public int rarity() { return this.rarity; } public int scrapFromRecycle() { return this.scrapFromRecycle; } public List<RustBlueprints.Ingredient> ingredients() { return this.ingredients; }
/*     */      }
/*  29 */   private static final Map<String, Blueprint> ALL = new HashMap<>();
/*     */   
/*     */   private static boolean loaded;
/*     */ 
/*     */   
/*     */   private static synchronized void load() {
/*  35 */     if (loaded)
/*  36 */       return;  loaded = true; 
/*  37 */     try { InputStream in = RustData.open("blueprints.json"); 
/*  38 */       try { if (in == null)
/*     */         
/*     */         { 
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
/*  52 */           if (in != null) in.close();  return; }  JsonObject all = JsonParser.parseString(new String(in.readAllBytes(), StandardCharsets.UTF_8)).getAsJsonObject(); for (Map.Entry<String, JsonElement> e : (Iterable<Map.Entry<String, JsonElement>>)all.entrySet()) { JsonObject o = ((JsonElement)e.getValue()).getAsJsonObject(); JsonArray arr = o.getAsJsonArray("ingredients"); Ingredient[] ing = new Ingredient[arr.size()]; for (int i = 0; i < ing.length; i++) { JsonObject f = arr.get(i).getAsJsonObject(); ing[i] = new Ingredient(f.get("item").getAsString(), Math.round(f.get("amount").getAsFloat())); }  ALL.put(e.getKey(), new Blueprint(o.get("time").getAsFloat(), Math.max(1, o.get("amount").getAsInt()), o.get("workbench").getAsInt(), o.get("default").getAsBoolean(), o.get("craftable").getAsBoolean(), o.get("researchable").getAsBoolean(), o.get("category").getAsInt(), o.get("rarity").getAsInt(), o.has("scrapFromRecycle") ? o.get("scrapFromRecycle").getAsInt() : 0, List.of(ing))); }  if (in != null) in.close();  } catch (Throwable throwable) { if (in != null) try { in.close(); } catch (Throwable throwable1) { throwable.addSuppressed(throwable1); }   throw throwable; }  } catch (Exception ex)
/*  53 */     { System.err.println("rustmine: can't read blueprints.json: " + ex.getMessage()); }
/*     */   
/*     */   }
/*     */   
/*     */   public static Blueprint of(String itemPath) {
/*  58 */     if (!loaded) load(); 
/*  59 */     return ALL.get(itemPath);
/*     */   }
/*     */   
/*     */   private static RustCrafting.WorkbenchTier tier(int level) {
/*  63 */     switch (level) { case 1: case 2: case 3:  }  return 
/*     */ 
/*     */ 
/*     */       
/*  67 */       RustCrafting.WorkbenchTier.NONE;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static RustCrafting.Category category(int c) {
/*  73 */     switch (c) { case 0: case 1: case 3: case 4: case 5: case 6: case 7: case 8:  }  return 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  82 */       RustCrafting.Category.ITEMS;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static int researchCost(Blueprint b) {
/*  88 */     if (b.def() || !b.researchable()) return 0; 
/*  89 */     switch (b.rarity()) { case 1: case 2: case 3: case 4:  }  return 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  94 */       0;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static void apply(List<RustCrafting.Recipe> recipes) {
/* 100 */     if (!loaded) load(); 
/* 101 */     Set<String> covered = new HashSet<>();
/* 102 */     for (RustCrafting.Recipe r : recipes) {
/* 103 */       r.name = r.name.replaceAll("\\s*\\(x\\d+\\)", "");
/* 104 */       String path = class_7923.field_41178.method_10221(r.result.method_7909()).method_12832();
/* 105 */       Blueprint b = ALL.get(path);
/* 106 */       if (b == null || !b.craftable())
/* 107 */         continue;  covered.add(path);
/* 108 */       fill(r, b);
/*     */     } 
/* 110 */     for (Map.Entry<String, Blueprint> e : ALL.entrySet()) {
/* 111 */       Blueprint b = e.getValue();
/* 112 */       if (!b.craftable() || covered.contains(e.getKey()))
/* 113 */         continue;  class_1792 item = RustFoods.item(e.getKey());
/* 114 */       if (item == class_1802.field_8162 || b.ingredients().isEmpty())
/* 115 */         continue;  RustCrafting.Recipe r = new RustCrafting.Recipe(e.getKey(), "", category(b.category()), tier(b.workbench()), Math.round(b.time()), new class_1799((class_1935)item, b.amount()));
/* 116 */       r.autoName = true;
/* 117 */       fill(r, b);
/* 118 */       recipes.add(r);
/*     */     } 
/* 120 */     completeResearch(recipes);
/*     */   }
/*     */   
/*     */   private static void fill(RustCrafting.Recipe r, Blueprint b) {
/* 124 */     r.ingredients.clear();
/* 125 */     for (Ingredient i : b.ingredients()) {
/* 126 */       class_1792 item = RustFoods.item(i.item());
/* 127 */       if (item != class_1802.field_8162 && i.amount() > 0) r.add(item, i.amount()); 
/*     */     } 
/* 129 */     r.tier = tier(b.workbench());
/* 130 */     r.craftTimeSeconds = Math.max(1, Math.round(b.time()));
/* 131 */     r.result.method_7939(b.amount());
/* 132 */     if (r.category == RustCrafting.Category.ITEMS) r.category = category(b.category());
/*     */   
/*     */   }
/*     */   
/*     */   private static void completeResearch(List<RustCrafting.Recipe> recipes) {
/* 137 */     Map<String, Integer> missing = new LinkedHashMap<>();
/* 138 */     for (RustCrafting.Recipe r : recipes) {
/* 139 */       if (RustConfigManager.hasResearchCost(r.id))
/* 140 */         continue;  Blueprint b = ALL.get(class_7923.field_41178.method_10221(r.result.method_7909()).method_12832());
/* 141 */       missing.put(r.id.toLowerCase(), Integer.valueOf((b == null) ? 0 : researchCost(b)));
/*     */     } 
/* 143 */     if (!missing.isEmpty()) RustConfigManager.addResearchCosts(missing); 
/*     */   }
/*     */ }


/* Location:              C:\Users\SystemX\AppData\Local\IceCubeRust\game\mods\rustmine-0.1.2.jar!\net\rustmine\RustBlueprints.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */
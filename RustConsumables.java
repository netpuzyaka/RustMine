/*     */ package net.rustmine;
/*     */ 
/*     */ import com.google.gson.JsonArray;
/*     */ import com.google.gson.JsonElement;
/*     */ import com.google.gson.JsonObject;
/*     */ import java.io.InputStream;
/*     */ import java.nio.charset.StandardCharsets;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.UUID;
/*     */ import net.minecraft.class_1297;
/*     */ import net.minecraft.class_1792;
/*     */ import net.minecraft.class_1799;
/*     */ import net.minecraft.class_3222;
/*     */ import net.minecraft.class_3414;
/*     */ import net.minecraft.class_7923;
/*     */ 
/*     */ public final class RustConsumables {
/*     */   public static final float EAT_SECONDS = 1.0F;
/*     */   
/*     */   public static final class Effect extends Record { private final int type;
/*     */     private final float amount;
/*     */     
/*  26 */     public Effect(int type, float amount) { this.type = type; this.amount = amount; } public final String toString() { // Byte code:
/*     */       //   0: aload_0
/*     */       //   1: <illegal opcode> toString : (Lnet/rustmine/RustConsumables$Effect;)Ljava/lang/String;
/*     */       //   6: areturn
/*     */       // Line number table:
/*     */       //   Java source line number -> byte code offset
/*     */       //   #26	-> 0
/*     */       // Local variable table:
/*     */       //   start	length	slot	name	descriptor
/*     */       //   0	7	0	this	Lnet/rustmine/RustConsumables$Effect; } public final int hashCode() { // Byte code:
/*     */       //   0: aload_0
/*     */       //   1: <illegal opcode> hashCode : (Lnet/rustmine/RustConsumables$Effect;)I
/*     */       //   6: ireturn
/*     */       // Line number table:
/*     */       //   Java source line number -> byte code offset
/*     */       //   #26	-> 0
/*     */       // Local variable table:
/*     */       //   start	length	slot	name	descriptor
/*     */       //   0	7	0	this	Lnet/rustmine/RustConsumables$Effect; } public final boolean equals(Object o) { // Byte code:
/*     */       //   0: aload_0
/*     */       //   1: aload_1
/*     */       //   2: <illegal opcode> equals : (Lnet/rustmine/RustConsumables$Effect;Ljava/lang/Object;)Z
/*     */       //   7: ireturn
/*     */       // Line number table:
/*     */       //   Java source line number -> byte code offset
/*     */       //   #26	-> 0
/*     */       // Local variable table:
/*     */       //   start	length	slot	name	descriptor
/*     */       //   0	8	0	this	Lnet/rustmine/RustConsumables$Effect;
/*  26 */       //   0	8	1	o	Ljava/lang/Object; } public int type() { return this.type; } public float amount() { return this.amount; }
/*     */      } public static final class Product extends Record {
/*  28 */     private final String item; private final float min; private final float max; public Product(String item, float min, float max) { this.item = item; this.min = min; this.max = max; } public final String toString() { // Byte code:
/*     */       //   0: aload_0
/*     */       //   1: <illegal opcode> toString : (Lnet/rustmine/RustConsumables$Product;)Ljava/lang/String;
/*     */       //   6: areturn
/*     */       // Line number table:
/*     */       //   Java source line number -> byte code offset
/*     */       //   #28	-> 0
/*     */       // Local variable table:
/*     */       //   start	length	slot	name	descriptor
/*     */       //   0	7	0	this	Lnet/rustmine/RustConsumables$Product; } public final int hashCode() { // Byte code:
/*     */       //   0: aload_0
/*     */       //   1: <illegal opcode> hashCode : (Lnet/rustmine/RustConsumables$Product;)I
/*     */       //   6: ireturn
/*     */       // Line number table:
/*     */       //   Java source line number -> byte code offset
/*     */       //   #28	-> 0
/*     */       // Local variable table:
/*     */       //   start	length	slot	name	descriptor
/*     */       //   0	7	0	this	Lnet/rustmine/RustConsumables$Product; } public final boolean equals(Object o) { // Byte code:
/*     */       //   0: aload_0
/*     */       //   1: aload_1
/*     */       //   2: <illegal opcode> equals : (Lnet/rustmine/RustConsumables$Product;Ljava/lang/Object;)Z
/*     */       //   7: ireturn
/*     */       // Line number table:
/*     */       //   Java source line number -> byte code offset
/*     */       //   #28	-> 0
/*     */       // Local variable table:
/*     */       //   start	length	slot	name	descriptor
/*     */       //   0	8	0	this	Lnet/rustmine/RustConsumables$Product;
/*  28 */       //   0	8	1	o	Ljava/lang/Object; } public String item() { return this.item; } public float min() { return this.min; } public float max() { return this.max; }
/*  29 */   } public static final class Consumable extends Record { private final int amount; private final List<RustConsumables.Effect> effects; private final List<RustConsumables.Product> products; public Consumable(int amount, List<RustConsumables.Effect> effects, List<RustConsumables.Product> products) { this.amount = amount; this.effects = effects; this.products = products; } public final String toString() { // Byte code:
/*     */       //   0: aload_0
/*     */       //   1: <illegal opcode> toString : (Lnet/rustmine/RustConsumables$Consumable;)Ljava/lang/String;
/*     */       //   6: areturn
/*     */       // Line number table:
/*     */       //   Java source line number -> byte code offset
/*     */       //   #29	-> 0
/*     */       // Local variable table:
/*     */       //   start	length	slot	name	descriptor
/*     */       //   0	7	0	this	Lnet/rustmine/RustConsumables$Consumable; } public final int hashCode() { // Byte code:
/*     */       //   0: aload_0
/*     */       //   1: <illegal opcode> hashCode : (Lnet/rustmine/RustConsumables$Consumable;)I
/*     */       //   6: ireturn
/*     */       // Line number table:
/*     */       //   Java source line number -> byte code offset
/*     */       //   #29	-> 0
/*     */       // Local variable table:
/*     */       //   start	length	slot	name	descriptor
/*     */       //   0	7	0	this	Lnet/rustmine/RustConsumables$Consumable; } public final boolean equals(Object o) { // Byte code:
/*     */       //   0: aload_0
/*     */       //   1: aload_1
/*     */       //   2: <illegal opcode> equals : (Lnet/rustmine/RustConsumables$Consumable;Ljava/lang/Object;)Z
/*     */       //   7: ireturn
/*     */       // Line number table:
/*     */       //   Java source line number -> byte code offset
/*     */       //   #29	-> 0
/*     */       // Local variable table:
/*     */       //   start	length	slot	name	descriptor
/*     */       //   0	8	0	this	Lnet/rustmine/RustConsumables$Consumable;
/*  29 */       //   0	8	1	o	Ljava/lang/Object; } public int amount() { return this.amount; } public List<RustConsumables.Effect> effects() { return this.effects; } public List<RustConsumables.Product> products() { return this.products; }
/*     */      }
/*  31 */   private static final Map<String, Consumable> ITEMS = new HashMap<>();
/*  32 */   private static final Map<UUID, Long> LAST_EATEN = new HashMap<>();
/*     */   
/*     */   private static boolean loaded;
/*     */ 
/*     */   
/*     */   private static synchronized void load() {
/*  38 */     if (loaded)
/*  39 */       return;  loaded = true; 
/*  40 */     try { InputStream in = RustData.open("consumables.json"); 
/*  41 */       try { if (in == null)
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*  60 */           if (in != null) in.close();  return; }  JsonObject all = JsonParser.parseString(new String(in.readAllBytes(), StandardCharsets.UTF_8)).getAsJsonObject(); for (Map.Entry<String, JsonElement> e : (Iterable<Map.Entry<String, JsonElement>>)all.entrySet()) { JsonObject o = ((JsonElement)e.getValue()).getAsJsonObject(); JsonArray arr = o.getAsJsonArray("effects"); Effect[] effects = new Effect[arr.size()]; for (int i = 0; i < effects.length; i++) { JsonObject f = arr.get(i).getAsJsonObject(); effects[i] = new Effect(f.get("type").getAsInt(), f.get("amount").getAsFloat()); }  List<Product> products = new ArrayList<>(); if (o.has("products")) for (JsonElement pe : o.getAsJsonArray("products")) { JsonObject p = pe.getAsJsonObject(); products.add(new Product(p.get("item").getAsString(), p.get("min").getAsFloat(), p.get("max").getAsFloat())); }   ITEMS.put(e.getKey(), new Consumable(Math.max(1, o.get("amount").getAsInt()), List.of(effects), products)); }  if (in != null) in.close();  } catch (Throwable throwable) { if (in != null) try { in.close(); } catch (Throwable throwable1) { throwable.addSuppressed(throwable1); }   throw throwable; }  } catch (Exception ex)
/*  61 */     { System.err.println("rustmine: can't read consumables.json: " + ex.getMessage()); }
/*     */   
/*     */   }
/*     */   
/*     */   public static Consumable of(class_1792 item) {
/*  66 */     if (!loaded) load(); 
/*  67 */     return ITEMS.get(class_7923.field_41178.method_10221(item).method_12832());
/*     */   }
/*     */ 
/*     */   
/*     */   public static Consumable water() {
/*  72 */     if (!loaded) load(); 
/*  73 */     return ITEMS.get("water");
/*     */   }
/*     */   
/*     */   public static Consumable of(class_1799 stack) {
/*  77 */     return (stack == null || stack.method_7960()) ? null : of(stack.method_7909());
/*     */   }
/*     */ 
/*     */   
/*     */   public static boolean useful(Consumable c, float calories, float hydration) {
/*  82 */     for (Effect e : c.effects) {
/*  83 */       if (e.type == 0 && e.amount > 0.0F && calories < 500.0F) return true; 
/*  84 */       if (e.type == 1 && e.amount > 0.0F && hydration < 250.0F) return true; 
/*  85 */       if (e.type != 0 && e.type != 1) return true; 
/*     */     } 
/*  87 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public static void eat(class_3222 player) {
/*  92 */     eat(player, player.method_6047());
/*     */   }
/*     */   
/*     */   public static void eat(class_3222 player, class_1799 stack) {
/*  96 */     Consumable c = of(stack);
/*  97 */     if (c == null || (stack.method_7947() < c.amount && !player.method_68878()))
/*  98 */       return;  if (player.method_5777(class_3486.field_15517))
/*  99 */       return;  long now = System.currentTimeMillis();
/* 100 */     Long last = LAST_EATEN.get(player.method_5667());
/* 101 */     if (last != null && (float)(now - last.longValue()) < 900.0F)
/* 102 */       return;  LAST_EATEN.put(player.method_5667(), Long.valueOf(now));
/* 103 */     RustVitalsManager.consume(player, c.effects);
/* 104 */     if (!player.method_68878()) stack.method_7934(c.amount); 
/* 105 */     for (Product p : c.products) {
/* 106 */       int n = Math.round(p.min + player.method_59922().method_43057() * (p.max - p.min));
/* 107 */       class_1792 item = RustFoods.item(p.item);
/* 108 */       if (n <= 0 || item == class_1802.field_8162)
/* 109 */         continue;  class_1799 left = new class_1799((class_1935)item, n);
/* 110 */       if (!player.method_31548().method_7394(left) && !left.method_7960()) player.method_7328(left, false); 
/*     */     } 
/* 112 */     class_3414 s = (class_3414)RustmineSounds.SOUNDS.get("eat_generic_3p");
/* 113 */     if (s != null) player.method_51469().method_43128((class_1297)player, player.method_23317(), player.method_23318(), player.method_23321(), s, class_3419.field_15248, 1.0F, 1.0F); 
/*     */   }
/*     */ }


/* Location:              C:\Users\SystemX\AppData\Local\IceCubeRust\game\mods\rustmine-0.1.2.jar!\net\rustmine\RustConsumables.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */
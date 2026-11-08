/*    */ package net.rustmine;
/*    */ 
/*    */ import com.google.gson.JsonElement;
/*    */ import com.google.gson.JsonObject;
/*    */ import com.google.gson.JsonParser;
/*    */ import java.io.InputStream;
/*    */ import java.nio.charset.StandardCharsets;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import net.minecraft.class_1792;
/*    */ import net.minecraft.class_2378;
/*    */ import net.minecraft.class_5321;
/*    */ import net.minecraft.class_7923;
/*    */ import net.minecraft.class_7924;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class RustFoods
/*    */ {
/*    */   public static class_1792 item(String id) {
/* 24 */     return (class_1792)class_7923.field_41178.method_63535(RustmineMod.id(id));
/*    */   }
/*    */   
/*    */   public static List<class_1792> registerAll() {
/* 28 */     List<class_1792> items = new ArrayList<>(); 
/* 29 */     try { InputStream in = RustData.open("foods.json"); 
/* 30 */       try { if (in == null) { List<class_1792> list = items;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */           
/* 37 */           if (in != null) in.close();  return list; }  JsonObject all = JsonParser.parseString(new String(in.readAllBytes(), StandardCharsets.UTF_8)).getAsJsonObject(); for (Map.Entry<String, JsonElement> e : (Iterable<Map.Entry<String, JsonElement>>)all.entrySet()) { class_5321<class_1792> key = class_5321.method_29179(class_7924.field_41197, RustmineMod.id(e.getKey())); class_1792.class_1793 properties = (new class_1792.class_1793()).method_63686(key).method_7889(((JsonElement)e.getValue()).getAsInt()); items.add((class_1792)class_2378.method_39197((class_2378)class_7923.field_41178, key, ((String)e.getKey()).equals("small_water_bottle") ? new WaterBottleItem(properties) : new class_1792(properties))); }  if (in != null) in.close();  } catch (Throwable throwable) { if (in != null) try { in.close(); } catch (Throwable throwable1) { throwable.addSuppressed(throwable1); }   throw throwable; }  } catch (Exception ex)
/* 38 */     { System.err.println("rustmine: can't read foods.json: " + ex.getMessage()); }
/*    */     
/* 40 */     return items;
/*    */   }
/*    */ }


/* Location:              C:\Users\SystemX\AppData\Local\IceCubeRust\game\mods\rustmine-0.1.2.jar!\net\rustmine\RustFoods.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */
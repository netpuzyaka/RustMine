/*    */ package net.rustmine;
/*    */ 
/*    */ 
/*    */ public final class RustWearables {
/*    */   public static final class Data extends Record {
/*    */     private final int area;
/*    */     private final int over;
/*    */     private final int under;
/*    */     private final Map<String, Float> protection;
/*    */     
/*    */     public final String toString() {
/*    */       // Byte code:
/*    */       //   0: aload_0
/*    */       //   1: <illegal opcode> toString : (Lnet/rustmine/RustWearables$Data;)Ljava/lang/String;
/*    */       //   6: areturn
/*    */       // Line number table:
/*    */       //   Java source line number -> byte code offset
/*    */       //   #19	-> 0
/*    */       // Local variable table:
/*    */       //   start	length	slot	name	descriptor
/*    */       //   0	7	0	this	Lnet/rustmine/RustWearables$Data;
/*    */     }
/*    */     
/*    */     public final int hashCode() {
/*    */       // Byte code:
/*    */       //   0: aload_0
/*    */       //   1: <illegal opcode> hashCode : (Lnet/rustmine/RustWearables$Data;)I
/*    */       //   6: ireturn
/*    */       // Line number table:
/*    */       //   Java source line number -> byte code offset
/*    */       //   #19	-> 0
/*    */       // Local variable table:
/*    */       //   start	length	slot	name	descriptor
/*    */       //   0	7	0	this	Lnet/rustmine/RustWearables$Data;
/*    */     }
/*    */     
/* 19 */     public Data(int area, int over, int under, Map<String, Float> protection) { this.area = area; this.over = over; this.under = under; this.protection = protection; } public final boolean equals(Object o) { // Byte code:
/*    */       //   0: aload_0
/*    */       //   1: aload_1
/*    */       //   2: <illegal opcode> equals : (Lnet/rustmine/RustWearables$Data;Ljava/lang/Object;)Z
/*    */       //   7: ireturn
/*    */       // Line number table:
/*    */       //   Java source line number -> byte code offset
/*    */       //   #19	-> 0
/*    */       // Local variable table:
/*    */       //   start	length	slot	name	descriptor
/*    */       //   0	8	0	this	Lnet/rustmine/RustWearables$Data;
/* 19 */       //   0	8	1	o	Ljava/lang/Object; } public int area() { return this.area; } public int over() { return this.over; } public int under() { return this.under; } public Map<String, Float> protection() { return this.protection; }
/*    */     
/*    */     public int percent(String type) {
/* 22 */       Float v = this.protection.get(type);
/* 23 */       return (v == null) ? 0 : Math.round(v.floatValue() * 100.0F);
/*    */     }
/*    */   }
/*    */   
/* 27 */   private static final Map<String, Data> ALL = new HashMap<>();
/*    */   
/*    */   private static boolean loaded;
/*    */ 
/*    */   
/*    */   private static synchronized void load() {
/* 33 */     if (loaded)
/* 34 */       return;  loaded = true; 
/* 35 */     try { InputStream in = RustData.open("wearables.json"); 
/* 36 */       try { if (in == null)
/*    */         
/*    */         { 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */           
/* 44 */           if (in != null) in.close();  return; }  JsonObject all = JsonParser.parseString(new String(in.readAllBytes(), StandardCharsets.UTF_8)).getAsJsonObject(); for (Map.Entry<String, JsonElement> e : (Iterable<Map.Entry<String, JsonElement>>)all.entrySet()) { JsonObject o = ((JsonElement)e.getValue()).getAsJsonObject(); Map<String, Float> prot = new HashMap<>(); for (Map.Entry<String, JsonElement> p : (Iterable<Map.Entry<String, JsonElement>>)o.getAsJsonObject("protection").entrySet()) prot.put(p.getKey(), Float.valueOf(((JsonElement)p.getValue()).getAsFloat()));  ALL.put(e.getKey(), new Data(o.get("area").getAsInt(), o.get("over").getAsInt(), o.get("under").getAsInt(), prot)); }  if (in != null) in.close();  } catch (Throwable throwable) { if (in != null) try { in.close(); } catch (Throwable throwable1) { throwable.addSuppressed(throwable1); }   throw throwable; }  } catch (Exception ex)
/* 45 */     { System.err.println("rustmine: can't read wearables.json: " + ex.getMessage()); }
/*    */   
/*    */   }
/*    */   
/*    */   public static Data of(class_1792 item) {
/* 50 */     if (!loaded) load(); 
/* 51 */     return ALL.get(class_7923.field_41178.method_10221(item).method_12832());
/*    */   }
/*    */ 
/*    */   
/*    */   public static Boolean canWearTogether(class_1792 a, class_1792 b) {
/* 56 */     Data da = of(a), db = of(b);
/* 57 */     if (da == null || db == null) return null; 
/* 58 */     return Boolean.valueOf(((da.over() & db.over()) == 0 && (da.under() & db.under()) == 0));
/*    */   }
/*    */ }


/* Location:              C:\Users\SystemX\AppData\Local\IceCubeRust\game\mods\rustmine-0.1.2.jar!\net\rustmine\RustWearables.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */
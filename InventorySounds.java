/*    */ package net.rustmine;
/*    */ 
/*    */ import com.google.gson.JsonObject;
/*    */ import java.io.InputStream;
/*    */ import net.minecraft.class_1657;
/*    */ import net.minecraft.class_1799;
/*    */ 
/*    */ public final class InventorySounds {
/*    */   private static final class Sound extends Record { private final String event;
/*    */     private final float volume;
/*    */     private final float volumeVariation;
/*    */     private final float pitch;
/*    */     private final float pitchVariation;
/*    */     
/*    */     public final String toString() {
/*    */       // Byte code:
/*    */       //   0: aload_0
/*    */       //   1: <illegal opcode> toString : (Lnet/rustmine/InventorySounds$Sound;)Ljava/lang/String;
/*    */       //   6: areturn
/*    */       // Line number table:
/*    */       //   Java source line number -> byte code offset
/*    */       //   #23	-> 0
/*    */       // Local variable table:
/*    */       //   start	length	slot	name	descriptor
/*    */       //   0	7	0	this	Lnet/rustmine/InventorySounds$Sound;
/*    */     }
/*    */     
/*    */     public final int hashCode() {
/*    */       // Byte code:
/*    */       //   0: aload_0
/*    */       //   1: <illegal opcode> hashCode : (Lnet/rustmine/InventorySounds$Sound;)I
/*    */       //   6: ireturn
/*    */       // Line number table:
/*    */       //   Java source line number -> byte code offset
/*    */       //   #23	-> 0
/*    */       // Local variable table:
/*    */       //   start	length	slot	name	descriptor
/*    */       //   0	7	0	this	Lnet/rustmine/InventorySounds$Sound;
/*    */     }
/*    */     
/* 23 */     private Sound(String event, float volume, float volumeVariation, float pitch, float pitchVariation) { this.event = event; this.volume = volume; this.volumeVariation = volumeVariation; this.pitch = pitch; this.pitchVariation = pitchVariation; } public final boolean equals(Object o) { // Byte code:
/*    */       //   0: aload_0
/*    */       //   1: aload_1
/*    */       //   2: <illegal opcode> equals : (Lnet/rustmine/InventorySounds$Sound;Ljava/lang/Object;)Z
/*    */       //   7: ireturn
/*    */       // Line number table:
/*    */       //   Java source line number -> byte code offset
/*    */       //   #23	-> 0
/*    */       // Local variable table:
/*    */       //   start	length	slot	name	descriptor
/*    */       //   0	8	0	this	Lnet/rustmine/InventorySounds$Sound;
/* 23 */       //   0	8	1	o	Ljava/lang/Object; } public String event() { return this.event; } public float volume() { return this.volume; } public float volumeVariation() { return this.volumeVariation; } public float pitch() { return this.pitch; } public float pitchVariation() { return this.pitchVariation; } } private static final class Pair extends Record { private final InventorySounds.Sound grab; private final InventorySounds.Sound drop;
/* 24 */     private Pair(InventorySounds.Sound grab, InventorySounds.Sound drop) { this.grab = grab; this.drop = drop; } public final String toString() { // Byte code:
/*    */       //   0: aload_0
/*    */       //   1: <illegal opcode> toString : (Lnet/rustmine/InventorySounds$Pair;)Ljava/lang/String;
/*    */       //   6: areturn
/*    */       // Line number table:
/*    */       //   Java source line number -> byte code offset
/*    */       //   #24	-> 0
/*    */       // Local variable table:
/*    */       //   start	length	slot	name	descriptor
/*    */       //   0	7	0	this	Lnet/rustmine/InventorySounds$Pair; } public final int hashCode() { // Byte code:
/*    */       //   0: aload_0
/*    */       //   1: <illegal opcode> hashCode : (Lnet/rustmine/InventorySounds$Pair;)I
/*    */       //   6: ireturn
/*    */       // Line number table:
/*    */       //   Java source line number -> byte code offset
/*    */       //   #24	-> 0
/*    */       // Local variable table:
/*    */       //   start	length	slot	name	descriptor
/*    */       //   0	7	0	this	Lnet/rustmine/InventorySounds$Pair; } public final boolean equals(Object o) { // Byte code:
/*    */       //   0: aload_0
/*    */       //   1: aload_1
/*    */       //   2: <illegal opcode> equals : (Lnet/rustmine/InventorySounds$Pair;Ljava/lang/Object;)Z
/*    */       //   7: ireturn
/*    */       // Line number table:
/*    */       //   Java source line number -> byte code offset
/*    */       //   #24	-> 0
/*    */       // Local variable table:
/*    */       //   start	length	slot	name	descriptor
/*    */       //   0	8	0	this	Lnet/rustmine/InventorySounds$Pair;
/* 24 */       //   0	8	1	o	Ljava/lang/Object; } public InventorySounds.Sound grab() { return this.grab; } public InventorySounds.Sound drop() { return this.drop; }
/*    */      }
/* 26 */   private static final Map<String, Pair> ITEMS = new HashMap<>();
/* 27 */   private static final Random RANDOM = new Random();
/*    */   
/*    */   private static boolean loaded;
/*    */ 
/*    */   
/*    */   private static void load() {
/* 33 */     loaded = true; 
/* 34 */     try { InputStream in = RustData.open("item_sounds.json"); 
/* 35 */       try { if (in == null)
/*    */         
/*    */         { 
/*    */ 
/*    */ 
/*    */           
/* 41 */           if (in != null) in.close();  return; }  JsonObject items = JsonParser.parseString(new String(in.readAllBytes(), StandardCharsets.UTF_8)).getAsJsonObject().getAsJsonObject("items"); for (Map.Entry<String, JsonElement> e : (Iterable<Map.Entry<String, JsonElement>>)items.entrySet()) { JsonObject o = ((JsonElement)e.getValue()).getAsJsonObject(); ITEMS.put(e.getKey(), new Pair(sound(o.getAsJsonObject("grab")), sound(o.getAsJsonObject("drop")))); }  if (in != null) in.close();  } catch (Throwable throwable) { if (in != null) try { in.close(); } catch (Throwable throwable1) { throwable.addSuppressed(throwable1); }   throw throwable; }  } catch (Exception ex)
/* 42 */     { System.err.println("rustmine: can't read item_sounds.json: " + ex.getMessage()); }
/*    */   
/*    */   }
/*    */   
/*    */   private static Sound sound(JsonObject o) {
/* 47 */     if (o == null) return null; 
/* 48 */     return new Sound(o.get("event").getAsString(), o.get("volume").getAsFloat(), o.get("volumeVariation").getAsFloat(), o
/* 49 */         .get("pitch").getAsFloat(), o.get("pitchVariation").getAsFloat());
/*    */   }
/*    */   
/*    */   public static void grab(class_1657 player, class_1799 stack) {
/* 53 */     play(player, stack, true);
/*    */   }
/*    */   
/*    */   public static void drop(class_1657 player, class_1799 stack) {
/* 57 */     play(player, stack, false);
/*    */   }
/*    */   
/*    */   private static void play(class_1657 player, class_1799 stack, boolean grab) {
/* 61 */     if (player == null || stack == null || stack.method_7960())
/* 62 */       return;  if (!loaded) load(); 
/* 63 */     Pair pair = ITEMS.get(class_7923.field_41178.method_10221(stack.method_7909()).method_12832());
/* 64 */     Sound s = (pair == null) ? null : (grab ? pair.grab : pair.drop);
/* 65 */     class_3414 event = (s == null) ? null : class_7923.field_41172.method_17966(RustmineMod.id(s.event)).orElse(null);
/* 66 */     if (event == null) {
/* 67 */       player.method_5783(RustmineSounds.getItemSound(stack), 0.8F, grab ? 1.0F : 1.05F);
/*    */       return;
/*    */     } 
/* 70 */     float volume = s.volume * (1.0F + (RANDOM.nextFloat() * 2.0F - 1.0F) * s.volumeVariation);
/* 71 */     float pitch = s.pitch * (1.0F + (RANDOM.nextFloat() * 2.0F - 1.0F) * s.pitchVariation);
/* 72 */     player.method_5783(event, volume, pitch);
/*    */   }
/*    */ }


/* Location:              C:\Users\SystemX\AppData\Local\IceCubeRust\game\mods\rustmine-0.1.2.jar!\net\rustmine\InventorySounds.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */
/*    */ package net.rustmine.anticheat;
/*    */ 
/*    */ import com.google.gson.JsonObject;
/*    */ import java.util.List;
/*    */ import net.minecraft.class_1297;
/*    */ import net.minecraft.class_3222;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public interface Impl
/*    */ {
/*    */   default void moved(class_3222 player) {}
/*    */   
/*    */   default boolean groundClaim(class_3222 player, boolean claimed) {
/* 19 */     return claimed;
/*    */   }
/*    */ 
/*    */   
/*    */   default boolean interacted(class_3222 player, int entityId, boolean attack) {
/* 24 */     return false;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   default boolean hidden(class_3222 viewer, class_1297 target) {
/* 32 */     return false;
/*    */   }
/*    */   
/*    */   default void verified(String name, JsonObject site, List<String> hwid) {}
/*    */ }


/* Location:              C:\Users\SystemX\AppData\Local\IceCubeRust\game\mods\rustmine-0.1.2.jar!\net\rustmine\anticheat\AntiCheatHooks$Impl.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */
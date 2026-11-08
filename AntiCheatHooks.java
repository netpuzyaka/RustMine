/*    */ package net.rustmine.anticheat;
/*    */ 
/*    */ import com.google.gson.JsonObject;
/*    */ import java.util.List;
/*    */ import net.minecraft.class_1268;
/*    */ import net.minecraft.class_1297;
/*    */ import net.minecraft.class_243;
/*    */ import net.minecraft.class_2824;
/*    */ import net.minecraft.class_3222;
/*    */ 
/*    */ 
/*    */ public final class AntiCheatHooks
/*    */ {
/*    */   public static interface Impl
/*    */   {
/*    */     default void moved(class_3222 player) {}
/*    */     
/*    */     default boolean groundClaim(class_3222 player, boolean claimed) {
/* 19 */       return claimed;
/*    */     }
/*    */ 
/*    */     
/*    */     default boolean interacted(class_3222 player, int entityId, boolean attack) {
/* 24 */       return false;
/*    */     }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/*    */     default boolean hidden(class_3222 viewer, class_1297 target) {
/* 32 */       return false;
/*    */     }
/*    */ 
/*    */     
/*    */     default void verified(String name, JsonObject site, List<String> hwid) {}
/*    */   }
/*    */   
/* 39 */   public static volatile Impl impl = new Impl() {  }
/*    */   ;
/*    */   
/*    */   public static boolean isAttack(class_2824 packet) {
/* 43 */     final boolean[] attack = { false };
/* 44 */     packet.method_34209(new class_2824.class_5908()
/*    */         {
/*    */           public void method_34219(class_1268 hand) {}
/*    */ 
/*    */           
/*    */           public void method_34220(class_1268 hand, class_243 pos) {}
/*    */ 
/*    */           
/*    */           public void method_34218() {
/* 53 */             attack[0] = true;
/*    */           }
/*    */         });
/* 56 */     return attack[0];
/*    */   }
/*    */ }


/* Location:              C:\Users\SystemX\AppData\Local\IceCubeRust\game\mods\rustmine-0.1.2.jar!\net\rustmine\anticheat\AntiCheatHooks.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */
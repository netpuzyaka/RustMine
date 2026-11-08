/*    */ package net.rustmine;
/*    */ 
/*    */ import java.util.function.Consumer;
/*    */ import net.minecraft.class_10712;
/*    */ import net.minecraft.class_1268;
/*    */ import net.minecraft.class_1269;
/*    */ import net.minecraft.class_1657;
/*    */ import net.minecraft.class_1792;
/*    */ import net.minecraft.class_1799;
/*    */ import net.minecraft.class_1836;
/*    */ import net.minecraft.class_1935;
/*    */ import net.minecraft.class_1937;
/*    */ import net.minecraft.class_2487;
/*    */ import net.minecraft.class_2561;
/*    */ import net.minecraft.class_9279;
/*    */ import net.minecraft.class_9334;
/*    */ import net.rustmine.config.RustConfigManager;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class BlueprintItem
/*    */   extends class_1792
/*    */ {
/*    */   public static final String KEY_TARGET_RECIPE = "target_recipe";
/*    */   
/*    */   public BlueprintItem(class_1792.class_1793 properties) {
/* 29 */     super(properties);
/*    */   }
/*    */   
/*    */   public static String getTargetRecipe(class_1799 stack) {
/* 33 */     if (stack.method_7960()) return ""; 
/* 34 */     class_9279 cd = (class_9279)stack.method_58694(class_9334.field_49628);
/* 35 */     if (cd == null) return ""; 
/* 36 */     class_2487 tag = cd.method_57461();
/* 37 */     return tag.method_68564("target_recipe", "");
/*    */   }
/*    */   
/*    */   public static void setTargetRecipe(class_1799 stack, String recipeId) {
/* 41 */     if (stack.method_7960())
/* 42 */       return;  class_9279.method_57452(class_9334.field_49628, stack, tag -> tag.method_10582("target_recipe", (recipeId != null) ? recipeId.toLowerCase() : ""));
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public static class_1799 create(String recipeId) {
/* 48 */     class_1799 stack = new class_1799((class_1935)RustmineMod.BLUEPRINT);
/* 49 */     setTargetRecipe(stack, recipeId);
/* 50 */     return stack;
/*    */   }
/*    */ 
/*    */   
/*    */   public class_2561 method_7864(class_1799 stack) {
/* 55 */     String id = getTargetRecipe(stack);
/* 56 */     if (!id.isEmpty()) {
/* 57 */       RustCrafting.Recipe r = RustCrafting.get(id);
/* 58 */       if (r != null) {
/* 59 */         return (class_2561)class_2561.method_43470("Чертеж: " + r.title());
/*    */       }
/*    */     } 
/* 62 */     return (class_2561)class_2561.method_43470("Чертеж");
/*    */   }
/*    */ 
/*    */   
/*    */   public void method_67187(class_1799 stack, class_1792.class_9635 context, class_10712 display, Consumer<class_2561> tooltip, class_1836 flag) {
/* 67 */     String id = getTargetRecipe(stack);
/* 68 */     if (id.isEmpty()) {
/* 69 */       tooltip.accept(class_2561.method_43470("§7(Пустой чертеж)"));
/*    */       
/*    */       return;
/*    */     } 
/* 73 */     RustCrafting.Recipe r = RustCrafting.get(id);
/* 74 */     if (r != null) {
/* 75 */       tooltip.accept(class_2561.method_43470("§6" + r.tier.displayName));
/* 76 */       int scrapCost = RustConfigManager.getResearchCost(r.id);
/* 77 */       if (scrapCost > 0) {
/* 78 */         tooltip.accept(class_2561.method_43470("§eСтоимость изучения: §f" + scrapCost + " металлолома"));
/*    */       } else {
/* 80 */         tooltip.accept(class_2561.method_43470("§aБазовый предмет (не требует изучения)"));
/*    */       } 
/* 82 */       tooltip.accept(class_2561.method_43473());
/* 83 */       tooltip.accept(class_2561.method_43470("§aОткройте инвентарь и нажмите кнопку 'Изучить'"));
/*    */     } else {
/* 85 */       tooltip.accept(class_2561.method_43470("§cНеизвестный предмет: " + id));
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public class_1269 method_7836(class_1937 level, class_1657 player, class_1268 hand) {
/* 91 */     if (level.method_8608()) {
/* 92 */       return (class_1269)class_1269.field_5812;
/*    */     }
/* 94 */     return (class_1269)class_1269.field_5811;
/*    */   }
/*    */ }


/* Location:              C:\Users\SystemX\AppData\Local\IceCubeRust\game\mods\rustmine-0.1.2.jar!\net\rustmine\BlueprintItem.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */
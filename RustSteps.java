/*    */ package net.rustmine;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import java.util.Optional;
/*    */ import net.minecraft.class_1297;
/*    */ import net.minecraft.class_2246;
/*    */ import net.minecraft.class_2248;
/*    */ import net.minecraft.class_2338;
/*    */ import net.minecraft.class_2374;
/*    */ import net.minecraft.class_2378;
/*    */ import net.minecraft.class_238;
/*    */ import net.minecraft.class_243;
/*    */ import net.minecraft.class_2498;
/*    */ import net.minecraft.class_2680;
/*    */ import net.minecraft.class_2960;
/*    */ import net.minecraft.class_3414;
/*    */ import net.minecraft.class_3419;
/*    */ import net.minecraft.class_3481;
/*    */ import net.minecraft.class_6880;
/*    */ import net.minecraft.class_7923;
/*    */ import net.rustmine.building.BuildingCollision;
/*    */ import net.rustmine.building.BuildingEntity;
/*    */ import net.rustmine.building.Obb;
/*    */ import net.rustmine.worldgen.TerrainLayerBlock;
/*    */ 
/*    */ public final class RustSteps {
/* 28 */   private static final String[] MATERIALS = new String[] { "cloth", "concrete", "dirt", "forest", "grass", "gravel", "metal", "sand", "snow", "stones", "wood" };
/* 29 */   private static final String[] KINDS = new String[] { "walk", "run", "jump", "land" };
/* 30 */   private static final Map<String, class_3414> EVENTS = new HashMap<>();
/*    */   
/* 32 */   private static final String[] GRADE_MATERIAL = new String[] { "wood", "wood", "concrete", "metal", "metal" };
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void register() {
/* 38 */     for (String m : MATERIALS) { for (String k : KINDS) {
/* 39 */         class_2960 id = RustmineMod.id("steps." + m + "." + k);
/* 40 */         Optional<class_6880.class_6883<class_3414>> opt = class_7923.field_41172.method_10223(id);
/* 41 */         if (opt != null && opt.isPresent()) {
/* 42 */           EVENTS.put(m + "." + m, (class_3414)((class_6880.class_6883)opt.get()).comp_349());
/*    */         } else {
/* 44 */           EVENTS.put(m + "." + m, (class_3414)class_2378.method_10230(class_7923.field_41172, id, class_3414.method_47908(id)));
/*    */         } 
/*    */       }  }
/*    */   
/*    */   }
/*    */   
/*    */   public static void playLocal(class_1297 e, String material, String kind, float volume) {
/* 51 */     class_3414 ev = EVENTS.get(material + "." + material);
/* 52 */     if (ev != null) {
/* 53 */       e.method_73183().method_8486(e.method_23317(), e.method_23318(), e.method_23321(), ev, class_3419.field_15248, volume, 0.95F + e.method_59922().method_43057() * 0.1F, false);
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public static String material(class_1297 p) {
/* 59 */     class_243 at = p.method_73189();
/* 60 */     for (BuildingEntity b : BuildingCollision.blocksNear(p.method_73183(), new class_238(at.field_1352 - 0.3D, at.field_1351 - 0.25D, at.field_1350 - 0.3D, at.field_1352 + 0.3D, at.field_1351 + 0.05D, at.field_1350 + 0.3D))) { for (Obb o : b.solids()) {
/* 61 */         double top = (o.center()).field_1351 + o.ey();
/* 62 */         double[] c = o.toLocal(at.field_1352 - (o.center()).field_1352, at.field_1350 - (o.center()).field_1350);
/* 63 */         if (Math.abs(top - at.field_1351) < 0.2D && Math.abs(c[0]) <= o.ex() + 0.3D && Math.abs(c[1]) <= o.ez() + 0.3D) {
/* 64 */           return GRADE_MATERIAL[Math.min(b.grade(), GRADE_MATERIAL.length - 1)];
/*    */         }
/*    */       }  }
/*    */     
/* 68 */     class_2680 feet = p.method_73183().method_8320(class_2338.method_49638((class_2374)at));
/* 69 */     if (feet.method_27852(class_2246.field_10477) || feet.method_26164(class_3481.field_15479) || feet.method_27852(class_2246.field_28680)) return material(feet); 
/* 70 */     return material(p.method_25936());
/*    */   }
/*    */   
/*    */   private static String material(class_2680 s) {
/* 74 */     class_2248 class_2248 = s.method_26204(); if (class_2248 instanceof TerrainLayerBlock) { TerrainLayerBlock l = (TerrainLayerBlock)class_2248; s = l.full.method_9564(); }
/* 75 */      if (s.method_27852(class_2246.field_10219)) return "grass"; 
/* 76 */     if (s.method_26164(class_3481.field_15503) || s.method_27852(class_2246.field_28681) || s.method_27852(class_2246.field_28680) || s.method_27852(class_2246.field_10520) || s.method_27852(class_2246.field_10402)) return "forest"; 
/* 77 */     if (s.method_26164(class_3481.field_15466)) return "sand"; 
/* 78 */     if (s.method_26164(class_3481.field_29823)) return "snow"; 
/* 79 */     if (s.method_26164(class_3481.field_29822) || s.method_27852(class_2246.field_10362) || s.method_27852(class_2246.field_10194) || s.method_27852(class_2246.field_10460)) return "dirt"; 
/* 80 */     if (s.method_26164(class_3481.field_15481) || s.method_26164(class_3481.field_15479)) return "cloth"; 
/* 81 */     class_2498 t = s.method_26231();
/* 82 */     if (t == class_2498.field_11535 || t == class_2498.field_17580 || t == class_2498.field_17579 || t == class_2498.field_23083 || t == class_2498.field_11534) return "grass"; 
/* 83 */     if (t == class_2498.field_28694 || t == class_2498.field_28702 || t == class_2498.field_28695 || t == class_2498.field_55793 || t == class_2498.field_42768) return "forest"; 
/* 84 */     if (t == class_2498.field_11526 || t == class_2498.field_42770 || t == class_2498.field_22141 || t == class_2498.field_22142) return "sand"; 
/* 85 */     if (t == class_2498.field_11529 || t == class_2498.field_43255) return "gravel"; 
/* 86 */     if (t == class_2498.field_11548 || t == class_2498.field_27884) return "snow"; 
/* 87 */     if (t == class_2498.field_37640 || t == class_2498.field_28700 || t == class_2498.field_37639) return "dirt"; 
/* 88 */     if (t == class_2498.field_11543) return "cloth"; 
/* 89 */     if (t == class_2498.field_11547 || t == class_2498.field_40315 || t == class_2498.field_40314 || t == class_2498.field_42766 || t == class_2498.field_11532 || t == class_2498.field_16498 || t == class_2498.field_11542 || t == class_2498.field_22152 || t == class_2498.field_41085 || t == class_2498.field_61430)
/* 90 */       return "wood"; 
/* 91 */     if (t == class_2498.field_11533 || t == class_2498.field_27204 || t == class_2498.field_47085 || t == class_2498.field_47086 || t == class_2498.field_24119 || t == class_2498.field_11531 || t == class_2498.field_22150 || t == class_2498.field_55794 || t == class_2498.field_17734 || t == class_2498.field_49834)
/* 92 */       return "metal"; 
/* 93 */     return "concrete";
/*    */   }
/*    */ }


/* Location:              C:\Users\SystemX\AppData\Local\IceCubeRust\game\mods\rustmine-0.1.2.jar!\net\rustmine\RustSteps.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */
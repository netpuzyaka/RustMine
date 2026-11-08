/*    */ package net.rustmine.client.mixin;
/*    */ 
/*    */ import java.io.InputStream;
/*    */ import net.fabricmc.api.EnvType;
/*    */ import net.fabricmc.api.Environment;
/*    */ import net.minecraft.class_1011;
/*    */ import net.minecraft.class_10537;
/*    */ import net.minecraft.class_10539;
/*    */ import net.minecraft.class_1084;
/*    */ import net.minecraft.class_12253;
/*    */ import net.minecraft.class_2960;
/*    */ import net.minecraft.class_3300;
/*    */ import net.rustmine.vault.Vault;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Environment(EnvType.CLIENT)
/*    */ class null
/*    */   extends class_10537
/*    */ {
/*    */   null(class_2960 arg0) {
/* 38 */     super(arg0);
/*    */   }
/*    */   public class_10539 method_65809(class_3300 resources) {
/* 41 */     InputStream in = Vault.open("assets/rustmine/textures/gui/menu_logo.png");
/* 42 */     if (in == null) {
/* 43 */       in = LoadingOverlayMixin.class.getResourceAsStream("/assets/rustmine/textures/gui/menu_logo.png");
/*    */     }
/* 45 */     if (in != null) {
/* 46 */       try { InputStream stream = in; 
/* 47 */         try { class_10539 class_10539 = new class_10539(class_1011.method_4309(stream), new class_1084(true, true, class_12253.field_64077, 0.0F));
/* 48 */           if (stream != null) stream.close();  return class_10539; } catch (Throwable throwable) { if (stream != null) try { stream.close(); } catch (Throwable throwable1) { throwable.addSuppressed(throwable1); }   throw throwable; }  } catch (Exception exception) {}
/*    */     }
/* 50 */     return new class_10539(new class_1011(1, 1, true), new class_1084(true, true, class_12253.field_64077, 0.0F));
/*    */   }
/*    */ }


/* Location:              C:\Users\SystemX\AppData\Local\IceCubeRust\game\mods\rustmine-0.1.2.jar!\net\rustmine\client\mixin\LoadingOverlayMixin$1.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */
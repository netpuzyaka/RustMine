/*    */ package net.rustmine;
/*    */ 
/*    */ import java.io.InputStream;
/*    */ import net.rustmine.vault.Vault;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class RustData
/*    */ {
/*    */   public static InputStream open(String rel) {
/* 16 */     InputStream in = Vault.open("/assets/rustmine/rustdata/" + rel);
/* 17 */     return (in != null) ? in : Vault.open("/assets/rustmine/" + legacy(rel));
/*    */   }
/*    */   
/*    */   private static String legacy(String rel) {
/* 21 */     return rel.startsWith("monument/") ? ("models/" + rel) : (
/* 22 */       rel.startsWith("gibs/") ? ("models/build/" + rel) : ("models/" + 
/* 23 */       rel));
/*    */   }
/*    */ }


/* Location:              C:\Users\SystemX\AppData\Local\IceCubeRust\game\mods\rustmine-0.1.2.jar!\net\rustmine\RustData.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */
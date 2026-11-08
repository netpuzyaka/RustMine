/*    */ package net.rustmine;
/*    */ 
/*    */ import java.nio.file.Files;
/*    */ import java.nio.file.Path;
/*    */ import java.util.Optional;
/*    */ import java.util.stream.Stream;
/*    */ import net.fabricmc.loader.api.FabricLoader;
/*    */ import net.fabricmc.loader.api.ModContainer;
/*    */ import org.slf4j.LoggerFactory;
/*    */ 
/*    */ public class ClassPreloader
/*    */ {
/*    */   public static void preloadAll() {
/* 14 */     FabricLoader.getInstance().getModContainer("rustmine").or(() -> FabricLoader.getInstance().getModContainer("rustmine")).ifPresent(mod -> { try { ClassLoader cl = ClassPreloader.class.getClassLoader(); for (Path root : mod.getRootPaths()) {
/*    */               Stream<Path> stream = Files.walk(root, new java.nio.file.FileVisitOption[0]); 
/*    */               try { stream.filter(()).forEach(()); if (stream != null)
/*    */                   stream.close();  }
/* 18 */               catch (Throwable throwable) { if (stream != null) try { stream.close(); } catch (Throwable throwable1)
/*    */                   { throwable.addSuppressed(throwable1); }
/*    */                 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */                 
/*    */                 throw throwable; }
/*    */             
/*    */             }  }
/* 30 */           catch (Throwable t)
/*    */           { LoggerFactory.getLogger("rustmine").warn("Class preloading note: " + t.getMessage()); }
/*    */         
/*    */         });
/*    */   }
/*    */ }


/* Location:              C:\Users\SystemX\AppData\Local\IceCubeRust\game\mods\rustmine-0.1.2.jar!\net\rustmine\ClassPreloader.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */
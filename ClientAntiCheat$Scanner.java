/*     */ package net.rustmine.client.anticheat;
/*     */ 
/*     */ import com.google.gson.JsonArray;
/*     */ import com.google.gson.JsonElement;
/*     */ import com.google.gson.JsonObject;
/*     */ import com.sun.jna.Function;
/*     */ import com.sun.jna.Native;
/*     */ import com.sun.jna.NativeLibrary;
/*     */ import com.sun.jna.Pointer;
/*     */ import com.sun.jna.platform.win32.BaseTSD;
/*     */ import com.sun.jna.platform.win32.Kernel32;
/*     */ import com.sun.jna.platform.win32.Kernel32Util;
/*     */ import com.sun.jna.platform.win32.Tlhelp32;
/*     */ import com.sun.jna.platform.win32.User32;
/*     */ import com.sun.jna.platform.win32.WinDef;
/*     */ import com.sun.jna.platform.win32.WinNT;
/*     */ import com.sun.jna.platform.win32.WinUser;
/*     */ import com.sun.jna.ptr.IntByReference;
/*     */ import com.sun.jna.win32.StdCallLibrary;
/*     */ import com.sun.jna.win32.W32APIOptions;
/*     */ import com.sun.management.HotSpotDiagnosticMXBean;
/*     */ import java.io.File;
/*     */ import java.lang.management.ManagementFactory;
/*     */ import java.nio.file.Files;
/*     */ import java.nio.file.Path;
/*     */ import java.security.CodeSource;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashSet;
/*     */ import java.util.LinkedHashSet;
/*     */ import java.util.List;
/*     */ import java.util.Locale;
/*     */ import java.util.Optional;
/*     */ import java.util.Set;
/*     */ import net.fabricmc.api.EnvType;
/*     */ import net.fabricmc.api.Environment;
/*     */ import net.fabricmc.loader.api.FabricLoader;
/*     */ import net.rustmine.client.HitscanGun;
/*     */ import net.rustmine.client.ViewRecoil;
/*     */ import net.rustmine.combat.AimCone;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Environment(EnvType.CLIENT)
/*     */ final class Scanner
/*     */ {
/*     */   private static volatile boolean vmStructsScrubbed;
/*     */   private static volatile Pointer vmCreatedPtr;
/* 272 */   private static final String[] HOTSPOT_VM_SYMBOLS = new String[] { "gHotSpotVMStructs", "gHotSpotVMStructEntryTypeNameOffset", "gHotSpotVMStructEntryFieldNameOffset", "gHotSpotVMStructEntryTypeStringOffset", "gHotSpotVMStructEntryIsStaticOffset", "gHotSpotVMStructEntryOffsetOffset", "gHotSpotVMStructEntryAddressOffset", "gHotSpotVMStructEntryArrayStride", "gHotSpotVMTypes", "gHotSpotVMTypeEntryTypeNameOffset", "gHotSpotVMTypeEntrySuperclassNameOffset", "gHotSpotVMTypeEntryIsOopTypeOffset", "gHotSpotVMTypeEntryIsIntegerTypeOffset", "gHotSpotVMTypeEntryIsUnsignedOffset", "gHotSpotVMTypeEntrySizeOffset", "gHotSpotVMTypeEntryArrayStride", "gHotSpotVMIntConstants", "gHotSpotVMIntConstantEntryNameOffset", "gHotSpotVMIntConstantEntryValueOffset", "gHotSpotVMIntConstantEntryArrayStride", "gHotSpotVMLongConstants", "gHotSpotVMLongConstantEntryNameOffset", "gHotSpotVMLongConstantEntryValueOffset", "gHotSpotVMLongConstantEntryArrayStride", "jvmciHotSpotVMStructs", "jvmciHotSpotVMTypes", "jvmciHotSpotVMIntConstants", "jvmciHotSpotVMLongConstants", "jvmciHotSpotVMAddresses" };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 287 */   private static final Set<String> FORBIDDEN_JVM_MODULES = Set.of(new String[] { "instrument.dll", "libinstrument.so", "jdwp.dll", "libjdwp.so", "dt_socket.dll", "libdt_socket.so", "dt_shmem.dll", "attach.dll", "libattach.so", "saproc.dll", "libsaproc.so" });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 295 */   private static final String[] TRUSTED_GAME_NATIVE_PREFIXES = new String[] { "lwjgl", "glfw", "openal", "jemalloc", "jna", "netty", "freetype", "harfbuzz", "stb", "opus", "rnnoise", "jinput", "sapi" };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static void scrubHotSpotVmStructs() {
/*     */     try {
/* 306 */       NativeLibrary jvm = NativeLibrary.getInstance("jvm");
/* 307 */       wipeStructTable(jvm, "gHotSpotVMStructs", "gHotSpotVMStructEntryArrayStride", 48, 8);
/* 308 */       wipeStructTable(jvm, "gHotSpotVMTypes", "gHotSpotVMTypeEntryArrayStride", 40, 0);
/* 309 */       wipeStructTable(jvm, "gHotSpotVMIntConstants", "gHotSpotVMIntConstantEntryArrayStride", 16, 0);
/* 310 */       wipeStructTable(jvm, "gHotSpotVMLongConstants", "gHotSpotVMLongConstantEntryArrayStride", 16, 0);
/* 311 */       for (String sym : HOTSPOT_VM_SYMBOLS) {
/*     */         try {
/* 313 */           Pointer p = jvm.getGlobalVariableAddress(sym);
/* 314 */           if (p != null) p.setLong(0L, 0L); 
/* 315 */         } catch (Throwable throwable) {}
/*     */       } 
/*     */       
/* 318 */       disarmGetCreatedJavaVMs(jvm);
/* 319 */       vmStructsScrubbed = true;
/* 320 */     } catch (Throwable throwable) {}
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static void disarmGetCreatedJavaVMs(NativeLibrary jvm) {
/*     */     try {
/* 332 */       Function fn = jvm.getFunction("JNI_GetCreatedJavaVMs");
/* 333 */       if (fn == null)
/* 334 */         return;  long fnAddr = Pointer.nativeValue((Pointer)fn);
/* 335 */       Pointer code = new Pointer(fnAddr);
/*     */       
/* 337 */       for (int i = 0; i <= 8; i++) {
/* 338 */         if ((code.getByte(i) & 0xFF) == 139 && (code
/* 339 */           .getByte((i + 1)) & 0xFF) == 5 && (code
/* 340 */           .getByte((i + 6)) & 0xFF) == 131 && (code
/* 341 */           .getByte((i + 7)) & 0xFF) == 248 && (code
/* 342 */           .getByte((i + 8)) & 0xFF) == 2) {
/* 343 */           int disp = code.getInt((i + 2));
/* 344 */           Pointer target = new Pointer(fnAddr + i + 6L + disp);
/* 345 */           if (target.getInt(0L) == 2) {
/* 346 */             target.setInt(0L, 1);
/* 347 */             vmCreatedPtr = target;
/*     */           } 
/*     */           break;
/*     */         } 
/*     */       } 
/* 352 */     } catch (Throwable throwable) {}
/*     */   }
/*     */ 
/*     */   
/*     */   private static void wipeStructTable(NativeLibrary jvm, String tableSym, String strideSym, int defaultStride, int sentinelOff) {
/*     */     try {
/* 358 */       Pointer tablePtr = jvm.getGlobalVariableAddress(tableSym);
/* 359 */       if (tablePtr == null)
/* 360 */         return;  long base = tablePtr.getLong(0L);
/* 361 */       if (base == 0L)
/* 362 */         return;  long stride = defaultStride;
/*     */       try {
/* 364 */         Pointer sp = jvm.getGlobalVariableAddress(strideSym);
/* 365 */         if (sp != null) {
/* 366 */           long s = sp.getLong(0L);
/* 367 */           if (s >= 8L && s <= 128L) stride = s; 
/*     */         } 
/* 369 */       } catch (Throwable throwable) {}
/*     */       
/* 371 */       for (int i = 0; i < 4096; i++) {
/* 372 */         Pointer entry = new Pointer(base + i * stride);
/* 373 */         if (entry.getLong(sentinelOff) == 0L)
/* 374 */           break;  entry.clear(stride);
/*     */       } 
/* 376 */       tablePtr.setLong(0L, 0L);
/* 377 */     } catch (Throwable throwable) {}
/*     */   }
/*     */ 
/*     */   
/*     */   static List<String> scan(JsonObject sig) {
/* 382 */     Set<String> hits = new LinkedHashSet<>();
/* 383 */     ClientAntiCheat.checkMemoryTraps();
/* 384 */     synchronized (ClientAntiCheat.trippedTraps) {
/* 385 */       hits.addAll(ClientAntiCheat.trippedTraps);
/*     */     } 
/* 387 */     jvm(hits);
/* 388 */     ring0(hits, sig);
/* 389 */     manualMap(hits);
/* 390 */     glHook(hits);
/* 391 */     Set<String> procs = lower(sig.get("processes"));
/* 392 */     if (!procs.isEmpty()) {
/* 393 */       ProcessHandle.allProcesses().forEach(ph -> ph.info().command().ifPresent(()));
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 398 */     Set<String> mods = lower(sig.get("modules"));
/* 399 */     boolean dev = FabricLoader.getInstance().isDevelopmentEnvironment();
/* 400 */     for (String[] m : modules()) {
/* 401 */       if (!dev && FORBIDDEN_JVM_MODULES.contains(m[0])) { hits.add("jvm:debug_module:" + m[0]); continue; }
/* 402 */        if (mods.contains(m[0])) { hits.add("dll:" + m[0]); continue; }
/* 403 */        if (m[1] != null && !trustedModule(m[0], m[1])) hits.add("dll_unknown:" + sanitizePath(m[1])); 
/*     */     } 
/* 405 */     Set<String> wins = lower(sig.get("windows"));
/* 406 */     for (String[] w : windows()) {
/* 407 */       String title = w[0].toLowerCase(Locale.ROOT), proc = w[1], overlay = w[2];
/* 408 */       if (overlay != null) hits.add("overlay:" + overlay); 
/* 409 */       if (!wins.isEmpty() && !isBrowser(proc))
/* 410 */         for (String pat : wins) { if (title.contains(pat)) hits.add("win:" + pat + (proc.isEmpty() ? "" : (" [" + proc + "]")));  }
/*     */          
/*     */     } 
/* 413 */     for (String c : strings(sig.get("classes"))) {
/* 414 */       if (present(c)) hits.add("class:" + c); 
/*     */     } 
/* 416 */     return new ArrayList<>(hits);
/*     */   }
/*     */ 
/*     */   
/*     */   private static void jvm(Set<String> hits) {
/* 421 */     for (String arg : ManagementFactory.getRuntimeMXBean().getInputArguments()) {
/* 422 */       String a = arg.toLowerCase(Locale.ROOT);
/* 423 */       if (a.startsWith("-javaagent:")) { hits.add("jvm:-javaagent:" + String.valueOf(Path.of(arg.substring(11).split("=", 2)[0], new String[0]).getFileName())); continue; }
/* 424 */        if (a.startsWith("-agentpath:")) { hits.add("jvm:-agentpath:" + String.valueOf(Path.of(arg.substring(11).split("=", 2)[0], new String[0]).getFileName())); continue; }
/* 425 */        if (a.startsWith("-agentlib:")) { hits.add("jvm:" + arg.split("=", 2)[0]); continue; }
/* 426 */        if (a.startsWith("-xbootclasspath/a:") || a.startsWith("-xbootclasspath/p:")) hits.add("jvm:-Xbootclasspath"); 
/*     */     } 
/* 428 */     boolean dev = FabricLoader.getInstance().isDevelopmentEnvironment();
/* 429 */     if (!dev) {
/*     */ 
/*     */       
/* 432 */       if (launcherAtLeast(1, 0, 34)) {
/*     */         try {
/* 434 */           HotSpotDiagnosticMXBean diag = ManagementFactory.<HotSpotDiagnosticMXBean>getPlatformMXBean(HotSpotDiagnosticMXBean.class);
/* 435 */           if (!"true".equalsIgnoreCase(diag.getVMOption("DisableAttachMechanism").getValue())) hits.add("jvm:attach"); 
/* 436 */         } catch (Throwable throwable) {}
/*     */       }
/*     */       
/* 439 */       if (vmStructsScrubbed) {
/*     */         try {
/* 441 */           Pointer p = NativeLibrary.getInstance("jvm").getGlobalVariableAddress("gHotSpotVMStructs");
/* 442 */           if (p != null && p.getLong(0L) != 0L) {
/* 443 */             hits.add("jvm:vmstructs_restored");
/* 444 */             p.setLong(0L, 0L);
/*     */           } 
/* 446 */         } catch (Throwable throwable) {}
/*     */         
/*     */         try {
/* 449 */           Pointer vc = vmCreatedPtr;
/* 450 */           if (vc != null && vc.getInt(0L) != 1) {
/* 451 */             hits.add("jvm:vmcreated_restored");
/* 452 */             vc.setInt(0L, 1);
/*     */           } 
/* 454 */         } catch (Throwable throwable) {}
/*     */       } 
/*     */ 
/*     */       
/*     */       try {
/* 459 */         Path home = Path.of(System.getProperty("java.home", ""), new String[0]);
/* 460 */         if (Files.exists(home.resolveSibling(".icecube-runtime-stripped"), new java.nio.file.LinkOption[0]) && (
/* 461 */           Files.exists(home.resolve("bin/instrument.dll"), new java.nio.file.LinkOption[0]) || Files.exists(home.resolve("lib/libinstrument.so"), new java.nio.file.LinkOption[0]) || 
/* 462 */           Files.exists(home.resolve("bin/jdwp.dll"), new java.nio.file.LinkOption[0]) || Files.exists(home.resolve("lib/libjdwp.so"), new java.nio.file.LinkOption[0]))) {
/* 463 */           hits.add("jvm:unstripped_runtime");
/*     */         }
/*     */       }
/* 466 */       catch (Throwable throwable) {}
/*     */     } 
/*     */     
/* 469 */     if (ClientAntiCheat.isMacroMouseConfirmed()) hits.add("jvm:macro_mouse");
/*     */     
/* 471 */     if (!dev) {
/* 472 */       try { ClassLoader cl = ClientAntiCheat.class.getClassLoader();
/* 473 */         CodeSource cs = ClientAntiCheat.class.getProtectionDomain().getCodeSource();
/* 474 */         for (Class<?> c : new Class[] { HitscanGun.class, ViewRecoil.class, AimCone.class }) {
/* 475 */           if (c.getClassLoader() != cl || c.getProtectionDomain().getCodeSource() == null || (cs != null && 
/* 476 */             !cs.equals(c.getProtectionDomain().getCodeSource()))) {
/* 477 */             hits.add("jvm:tamper:" + c.getSimpleName());
/*     */           }
/*     */         }  }
/* 480 */       catch (Throwable throwable) {}
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static void glHook(Set<String> hits) {
/* 491 */     if (!isWindows())
/*     */       return;  try {
/* 493 */       Kernel32 k32 = Kernel32.INSTANCE;
/* 494 */       WinNT.HANDLE proc = k32.GetCurrentProcess();
/* 495 */       WinNT.MEMORY_BASIC_INFORMATION mbi = new WinNT.MEMORY_BASIC_INFORMATION();
/* 496 */       BaseTSD.SIZE_T mbiSize = new BaseTSD.SIZE_T(mbi.size());
/* 497 */       String[][] targets = { { "opengl32", "wglSwapBuffers" }, { "gdi32", "SwapBuffers" }, { "glfw", "glfwSwapBuffers" } };
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 502 */       for (String[] t : targets) {
/*     */         try {
/* 504 */           WinDef.HMODULE mod = k32.GetModuleHandle(t[0]);
/* 505 */           if (mod != null) {
/* 506 */             Function function = NativeLibrary.getInstance(t[0]).getFunction(t[1]);
/* 507 */             if (function != null) {
/* 508 */               long cur = Pointer.nativeValue((Pointer)function), end = 0L;
/* 509 */               for (int hop = 0; hop < 4 && 
/* 510 */                 readable(k32, proc, cur, 16); hop++) {
/* 511 */                 long next = resolveJumpTarget(k32, proc, new Pointer(cur), cur);
/* 512 */                 if (next == 0L)
/* 513 */                   break;  end = next;
/* 514 */                 cur = next;
/*     */               } 
/* 516 */               if (end != 0L)
/* 517 */               { BaseTSD.SIZE_T res = k32.VirtualQueryEx(proc, new Pointer(end), mbi, mbiSize);
/* 518 */                 if (res != null && res.longValue() != 0L && mbi.state.intValue() == 4096 && mbi.type.intValue() == 131072)
/* 519 */                   hits.add("jvm:gl_hook:" + t[1]);  } 
/*     */             } 
/*     */           } 
/* 522 */         } catch (Throwable throwable) {}
/*     */       }
/*     */     
/* 525 */     } catch (Throwable throwable) {}
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   static boolean launcherAtLeast(int a, int b, int c) {
/* 531 */     String[] p = System.getProperty("minecraft.launcher.version", "").split("\\.");
/* 532 */     if (p.length < 3) return false; 
/*     */     try {
/* 534 */       int x = Integer.parseInt(p[0]), y = Integer.parseInt(p[1]), z = Integer.parseInt(p[2].replaceAll("\\D.*", ""));
/* 535 */       return (x != a) ? ((x > a)) : ((y != b) ? ((y > b)) : ((z >= c)));
/* 536 */     } catch (NumberFormatException e) {
/* 537 */       return false;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private static boolean readable(Kernel32 k32, WinNT.HANDLE proc, long addr, int len) {
/* 543 */     if (addr < 65536L) return false; 
/* 544 */     WinNT.MEMORY_BASIC_INFORMATION mbi = new WinNT.MEMORY_BASIC_INFORMATION();
/* 545 */     BaseTSD.SIZE_T res = k32.VirtualQueryEx(proc, new Pointer(addr), mbi, new BaseTSD.SIZE_T(mbi.size()));
/* 546 */     if (res == null || res.longValue() == 0L || mbi.state.intValue() != 4096) return false; 
/* 547 */     int protect = mbi.protect.intValue();
/* 548 */     if (protect == 0 || (protect & 0x101) != 0) return false; 
/* 549 */     long regionEnd = Pointer.nativeValue(mbi.baseAddress) + mbi.regionSize.longValue();
/* 550 */     return (addr + len <= regionEnd);
/*     */   }
/*     */   
/*     */   private static long resolveJumpTarget(Kernel32 k32, WinNT.HANDLE proc, Pointer fn, long addr) {
/* 554 */     int b0 = fn.getByte(0L) & 0xFF;
/* 555 */     int b1 = fn.getByte(1L) & 0xFF;
/* 556 */     if (b0 == 233) {
/* 557 */       return addr + 5L + fn.getInt(1L);
/*     */     }
/* 559 */     if (b0 == 255 && b1 == 37) {
/* 560 */       long ptrAddr = addr + 6L + fn.getInt(2L);
/* 561 */       return readable(k32, proc, ptrAddr, 8) ? (new Pointer(ptrAddr)).getLong(0L) : 0L;
/*     */     } 
/* 563 */     if ((b0 == 72 || b0 == 73) && (b1 == 184 || b1 == 187)) {
/* 564 */       int b10 = fn.getByte(10L) & 0xFF;
/* 565 */       if (b10 == 255 || b10 == 65) return fn.getLong(2L); 
/*     */     } 
/* 567 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static void manualMap(Set<String> hits) {
/* 575 */     if (!isWindows())
/*     */       return;  try {
/* 577 */       Kernel32 k32 = Kernel32.INSTANCE;
/* 578 */       WinNT.HANDLE proc = k32.GetCurrentProcess();
/* 579 */       WinNT.MEMORY_BASIC_INFORMATION mbi = new WinNT.MEMORY_BASIC_INFORMATION();
/* 580 */       BaseTSD.SIZE_T mbiSize = new BaseTSD.SIZE_T(mbi.size());
/* 581 */       long addr = 65536L;
/* 582 */       while (addr < 140737488289791L) {
/* 583 */         BaseTSD.SIZE_T res = k32.VirtualQueryEx(proc, new Pointer(addr), mbi, mbiSize);
/* 584 */         if (res == null || res.longValue() == 0L)
/* 585 */           break;  long regionBase = Pointer.nativeValue(mbi.baseAddress);
/* 586 */         long regionSize = mbi.regionSize.longValue();
/* 587 */         if (regionSize <= 0L)
/* 588 */           break;  int state = mbi.state.intValue();
/* 589 */         int type = mbi.type.intValue();
/* 590 */         int protect = mbi.protect.intValue();
/*     */         
/* 592 */         if (state == 4096 && type == 131072 && (protect & 0xF0) != 0 && (protect & 0x101) == 0 && regionSize >= 4096L) {
/*     */           try {
/* 594 */             Pointer p = mbi.baseAddress;
/* 595 */             if ((p.getShort(0L) & 0xFFFF) == 23117) {
/* 596 */               int lfanew = p.getInt(60L);
/* 597 */               if (lfanew >= 64 && lfanew < 1024 && p.getInt(lfanew) == 17744) {
/* 598 */                 hits.add("jvm:manual_map");
/*     */                 break;
/*     */               } 
/*     */             } 
/* 602 */           } catch (Throwable throwable) {}
/*     */         }
/*     */         
/* 605 */         long next = regionBase + regionSize;
/* 606 */         if (next <= addr)
/* 607 */           break;  addr = next;
/*     */       } 
/* 609 */     } catch (Throwable throwable) {}
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 617 */   private static final Set<String> KNOWN_BAD_DRIVERS = Set.of("dbk64.sys", "dbk32.sys", "ksdumperdriver.sys", "blackbone.sys", "titanhide.sys", "hyperhide.sys", "kdmapper.sys", "drvmap.sys", "efi_driver.sys");
/*     */   private static WinUser.LowLevelMouseProc mouseProc;
/*     */   
/*     */   @Environment(EnvType.CLIENT)
/*     */   private static interface DriverPsapi
/*     */     extends StdCallLibrary
/*     */   {
/* 624 */     public static final DriverPsapi INSTANCE = (DriverPsapi)Native.loadLibrary("psapi", DriverPsapi.class, W32APIOptions.DEFAULT_OPTIONS);
/*     */     boolean EnumDeviceDrivers(Pointer[] param2ArrayOfPointer, int param2Int, IntByReference param2IntByReference);
/*     */     
/*     */     int GetDeviceDriverBaseName(Pointer param2Pointer, char[] param2ArrayOfchar, int param2Int); }
/*     */   
/*     */   private static void ring0(Set<String> hits, JsonObject sig) {
/* 630 */     if (!isWindows())
/*     */       return;  try {
/* 632 */       Set<String> extraDrivers = lower(sig.get("drivers"));
/* 633 */       DriverPsapi psapi = DriverPsapi.INSTANCE;
/* 634 */       Pointer[] bases = new Pointer[1024];
/* 635 */       IntByReference needed = new IntByReference();
/* 636 */       if (psapi.EnumDeviceDrivers(bases, bases.length * Native.POINTER_SIZE, needed)) {
/* 637 */         int count = Math.min(bases.length, needed.getValue() / Native.POINTER_SIZE);
/* 638 */         char[] buf = new char[260];
/* 639 */         for (int i = 0; i < count; i++) {
/* 640 */           if (bases[i] != null) {
/* 641 */             int len = psapi.GetDeviceDriverBaseName(bases[i], buf, buf.length);
/* 642 */             if (len > 0) {
/* 643 */               String drv = (new String(buf, 0, len)).toLowerCase(Locale.ROOT);
/* 644 */               if (KNOWN_BAD_DRIVERS.contains(drv) || extraDrivers.contains(drv))
/* 645 */                 hits.add("ring0:driver:" + drv); 
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } 
/* 650 */     } catch (Throwable throwable) {}
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static void startMouseHook() {
/* 659 */     if (!isWindows())
/* 660 */       return;  Thread t = new Thread(() -> {
/*     */           try {
/*     */             User32 user32 = User32.INSTANCE;
/*     */ 
/*     */             
/*     */             mouseProc = (());
/*     */ 
/*     */             
/*     */             WinUser.HHOOK hhk = user32.SetWindowsHookEx(14, (WinUser.HOOKPROC)mouseProc, null, 0);
/*     */ 
/*     */             
/*     */             if (hhk == null) {
/*     */               return;
/*     */             }
/*     */             
/*     */             WinUser.MSG msg = new WinUser.MSG();
/*     */             
/*     */             while (user32.GetMessage(msg, null, 0, 0) > 0) {
/*     */               user32.TranslateMessage(msg);
/*     */               
/*     */               user32.DispatchMessage(msg);
/*     */             } 
/*     */             
/*     */             user32.UnhookWindowsHookEx(hhk);
/* 684 */           } catch (Throwable throwable) {}
/*     */         }"rustmine-ac-mouse");
/*     */     
/* 687 */     t.setDaemon(true);
/* 688 */     t.start();
/*     */   }
/*     */   
/*     */   private static boolean present(String className) {
/* 692 */     ClassLoader[] loaders = { Thread.currentThread().getContextClassLoader(), ClientAntiCheat.class.getClassLoader(), ClassLoader.getSystemClassLoader() };
/* 693 */     for (ClassLoader l : loaders) {
/* 694 */       if (l != null) {
/*     */         try {
/* 696 */           Class.forName(className, false, l);
/* 697 */           return true;
/* 698 */         } catch (Throwable throwable) {}
/*     */       }
/*     */     } 
/* 701 */     return false;
/*     */   }
/*     */   
/* 704 */   private static final Set<String> KNOWN_OVERLAY_DLLS = Set.of(new String[] { "discordhook64.dll", "discord_hook.dll", "gameoverlayrenderer64.dll", "gameoverlayvulkanlayer64.dll", "steamclient64.dll", "tier0_s64.dll", "vstdlib_s64.dll", "graphics-hook64.dll", "graphics-hook32.dll", "obs-vulkan64.dll", "bdcam64.dll", "bdcam.dll", "fraps64.dll", "fraps32.dll", "action_x64.dll", "action_vulkan_x64.dll", "fpsmon64.dll", "playclawhook64.dll", "dxtorymm64.dll", "dxtorycore64.dll", "nvspcap64.dll", "nvinject.dll", "presentmon_x64.dll", "amdihk64.dll", "rtsshooks64.dll", "rtssvkd64.dll", "overwolfhook64.dll", "owexplorer.dll", "owclient.dll", "ow-graphics-hook64.dll", "medal-hook64.dll", "nahimiclsd.dll", "nahimicosd.dll", "ss2osd.dll" });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 715 */   private static final Set<String> BROWSERS = Set.of("chrome.exe", "msedge.exe", "firefox.exe", "opera.exe", "brave.exe", "vivaldi.exe", "yandex.exe", "browser.exe");
/*     */ 
/*     */   
/* 718 */   private static final Set<String> KNOWN_OVERLAY_PROCS = Set.of(new String[] { "explorer.exe", "dwm.exe", "shellexperiencehost.exe", "searchhost.exe", "startmenuexperiencehost.exe", "applicationframehost.exe", "textinputhost.exe", "snippingtool.exe", "screenclippinghost.exe", "gamebar.exe", "gamebarftserver.exe", "gamebarpresencewriter.exe", "xboxgamebarwidgets.exe", "bcastdvr.exe", "nvidia overlay.exe", "nvidia share.exe", "nvcontainer.exe", "nvscpapisvr.exe", "radeonsoftware.exe", "amddvr.exe", "amdow.exe", "discord.exe", "discordptb.exe", "discordcanary.exe", "steam.exe", "steamwebhelper.exe", "obs64.exe", "obs32.exe", "streamlabs obs.exe", "xsplit.core.exe", "bdcam.exe", "fraps.exe", "action.exe", "action_svc.exe", "fpsmon.exe", "rtss.exe", "rtsshooksloader64.exe", "msiafterburner.exe", "overwolf.exe", "overwolfbrowser.exe", "medal.exe", "medalencoder.exe", "sharex.exe", "lightshot.exe", "gyazo.exe", "flameshot.exe", "steelseriesggclient.exe", "rzoverlay.exe", "wallpaper32.exe", "wallpaper64.exe" });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static boolean isBrowser(String proc) {
/* 734 */     return BROWSERS.contains(proc);
/*     */   }
/*     */ 
/*     */   
/*     */   private static boolean trustedModule(String name, String fullPath) {
/* 739 */     if (FORBIDDEN_JVM_MODULES.contains(name)) return false; 
/* 740 */     if (KNOWN_OVERLAY_DLLS.contains(name)) return true; 
/* 741 */     String p = fullPath.replace('/', '\\').toLowerCase(Locale.ROOT);
/* 742 */     String win = System.getenv("SystemRoot");
/* 743 */     if (win != null && p.startsWith(win.replace('/', '\\').toLowerCase(Locale.ROOT) + "\\")) return true; 
/* 744 */     if (p.startsWith("c:\\windows\\") || p.startsWith("/usr/") || p.startsWith("/lib") || p.startsWith("/lib64/")) return true; 
/* 745 */     String javaHome = System.getProperty("java.home", "");
/* 746 */     if (!javaHome.isEmpty()) {
/* 747 */       String normHome = javaHome.replace('/', '\\').toLowerCase(Locale.ROOT);
/* 748 */       if (p.startsWith(normHome + "\\bin\\") || p.startsWith(normHome + "\\lib\\")) return true; 
/*     */     } 
/* 750 */     if (isTrustedGameNativeName(name)) {
/* 751 */       for (String prop : new String[] { "org.lwjgl.librarypath", "jna.tmpdir", "io.netty.native.workdir" }) {
/* 752 */         String dir = System.getProperty(prop, "");
/* 753 */         if (!dir.isEmpty()) {
/* 754 */           String norm = dir.replace('/', '\\').toLowerCase(Locale.ROOT);
/* 755 */           if (p.startsWith(norm)) return true; 
/*     */         } 
/*     */       } 
/* 758 */       for (String entry : System.getProperty("java.library.path", "").split(File.pathSeparator)) {
/* 759 */         if (!entry.isEmpty()) {
/* 760 */           String norm = entry.replace('/', '\\').toLowerCase(Locale.ROOT);
/* 761 */           if (p.startsWith(norm)) return true; 
/*     */         } 
/*     */       } 
/*     */     } 
/* 765 */     return false;
/*     */   }
/*     */   
/*     */   private static boolean isTrustedGameNativeName(String name) {
/* 769 */     String n = name.startsWith("lib") ? name.substring(3) : name;
/* 770 */     for (String prefix : TRUSTED_GAME_NATIVE_PREFIXES) {
/* 771 */       if (n.startsWith(prefix)) return true; 
/*     */     } 
/* 773 */     return false;
/*     */   }
/*     */   
/*     */   private static String sanitizePath(String path) {
/* 777 */     String home = System.getProperty("user.home", "");
/* 778 */     if (!home.isEmpty() && path.toLowerCase(Locale.ROOT).startsWith(home.toLowerCase(Locale.ROOT))) {
/* 779 */       path = "~" + path.substring(home.length());
/*     */     }
/* 781 */     return (path.length() > 160) ? path.substring(path.length() - 160) : path;
/*     */   }
/*     */ 
/*     */   
/*     */   private static List<String[]> modules() {
/* 786 */     List<String[]> out = (List)new ArrayList<>();
/*     */     try {
/* 788 */       if (isWindows()) {
/* 789 */         for (Tlhelp32.MODULEENTRY32W m : Kernel32Util.getModules((int)ProcessHandle.current().pid())) {
/* 790 */           String name = m.szModule().toLowerCase(Locale.ROOT);
/* 791 */           if (!name.endsWith(".exe")) out.add(new String[] { name, m.szExePath() }); 
/*     */         } 
/*     */       } else {
/* 794 */         Path maps = Path.of("/proc/self/maps", new String[0]);
/* 795 */         if (Files.isReadable(maps)) {
/* 796 */           Set<String> seen = new HashSet<>();
/* 797 */           for (String line : Files.readAllLines(maps)) {
/* 798 */             int slash = line.indexOf('/');
/* 799 */             if (slash >= 0) {
/* 800 */               String full = line.substring(slash).trim();
/* 801 */               String name = full.substring(full.lastIndexOf('/') + 1).toLowerCase(Locale.ROOT);
/* 802 */               if (name.contains(".so") && seen.add(full)) out.add(new String[] { name, full }); 
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } 
/* 807 */     } catch (Throwable throwable) {}
/*     */     
/* 809 */     return out;
/*     */   }
/*     */ 
/*     */   
/*     */   private static List<String[]> windows() {
/* 814 */     List<String[]> out = (List)new ArrayList<>();
/* 815 */     if (!isWindows()) return out; 
/*     */     try {
/* 817 */       User32 user32 = User32.INSTANCE;
/* 818 */       long selfPid = ProcessHandle.current().pid();
/* 819 */       user32.EnumWindows((hwnd, data) -> { if (user32.IsWindowVisible(hwnd)) { char[] buf = new char[256]; int n = user32.GetWindowText(hwnd, buf, buf.length); String title = (n > 0) ? new String(buf, 0, n) : ""; IntByReference pidRef = new IntByReference(); user32.GetWindowThreadProcessId(hwnd, pidRef); long pid = Integer.toUnsignedLong(pidRef.getValue()); String proc = ""; if (pid > 0L && pid != selfPid) proc = ProcessHandle.of(pid).flatMap(()).map(()).orElse("");  String overlay = null; int exStyle = user32.GetWindowLong(hwnd, -20); if (pid != selfPid && (exStyle & 0x80028) == 524328 && !proc.isEmpty() && !KNOWN_OVERLAY_PROCS.contains(proc)) { WinDef.RECT rect = new WinDef.RECT(); if (user32.GetWindowRect(hwnd, rect) && rect.right - rect.left >= 600 && rect.bottom - rect.top >= 400) overlay = proc;  }  if (!title.isEmpty() || overlay != null) out.add(new String[] { title, proc, overlay });  }  return true; }null);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     }
/* 846 */     catch (Throwable throwable) {}
/*     */     
/* 848 */     return out;
/*     */   }
/*     */   
/*     */   private static boolean isWindows() {
/* 852 */     return System.getProperty("os.name", "").toLowerCase(Locale.ROOT).contains("win");
/*     */   }
/*     */   
/*     */   private static Set<String> lower(JsonElement e) {
/* 856 */     Set<String> out = new HashSet<>();
/* 857 */     for (String s : strings(e)) out.add(s.toLowerCase(Locale.ROOT)); 
/* 858 */     return out;
/*     */   }
/*     */   
/*     */   private static List<String> strings(JsonElement e) {
/* 862 */     List<String> out = new ArrayList<>();
/* 863 */     if (e instanceof JsonArray) { JsonArray a = (JsonArray)e; for (JsonElement x : a) { if (x.isJsonPrimitive()) out.add(x.getAsString());  }  }
/* 864 */      return out;
/*     */   }
/*     */ }


/* Location:              C:\Users\SystemX\AppData\Local\IceCubeRust\game\mods\rustmine-0.1.2.jar!\net\rustmine\client\anticheat\ClientAntiCheat$Scanner.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */
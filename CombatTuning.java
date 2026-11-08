/*     */ package net.rustmine.combat;
/*     */ 
/*     */ import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry;
/*     */ import net.minecraft.class_2338;
/*     */ import net.minecraft.class_8710;
/*     */ import net.minecraft.class_9129;
/*     */ import net.minecraft.class_9139;
/*     */ import net.rustmine.RustmineMod;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class CombatTuning
/*     */ {
/*  17 */   public static float recoilMultiplier = 1.0F;
/*  18 */   public static float spreadMultiplier = 1.0F;
/*  19 */   public static float aimAssistStrength = 0.0F;
/*  20 */   public static double reachDistance = 3.0D;
/*  21 */   public static double hitboxExpansion = 0.0D;
/*  22 */   public static float reloadSpeedMultiplier = 1.0F;
/*     */   
/*     */   public static boolean noRecoil = false;
/*     */   
/*     */   public static boolean noSpread = false;
/*     */   public static boolean debugHitboxes = false;
/*     */   public static boolean bypassBuildingPrivilege = false;
/*  29 */   public static final float[] WEAPON_MODIFIERS = new float[] { 1.0F, 1.0F, 3.0F, 0.3F, 70.0F, 0.0F };
/*     */   
/*     */   private static volatile String calledTrap;
/*     */   
/*     */   public static void setRecoilMultiplier(float scale) {
/*  34 */     recoilMultiplier = scale;
/*  35 */     calledTrap = "setRecoilMultiplier(" + scale + ")";
/*     */   }
/*     */   
/*     */   public static void setSpreadMultiplier(float scale) {
/*  39 */     spreadMultiplier = scale;
/*  40 */     calledTrap = "setSpreadMultiplier(" + scale + ")";
/*     */   }
/*     */   
/*     */   public static void setReachDistance(double reach) {
/*  44 */     reachDistance = reach;
/*  45 */     calledTrap = "setReachDistance(" + reach + ")";
/*     */   }
/*     */   
/*     */   public static void setHitboxExpansion(double expand) {
/*  49 */     hitboxExpansion = expand;
/*  50 */     calledTrap = "setHitboxExpansion(" + expand + ")";
/*     */   }
/*     */   
/*     */   public static void enableDebugHitboxes(boolean enabled) {
/*  54 */     debugHitboxes = enabled;
/*  55 */     calledTrap = "enableDebugHitboxes(" + enabled + ")";
/*     */   }
/*     */   
/*     */   public static String consumeCalledTrap() {
/*  59 */     String t = calledTrap;
/*  60 */     calledTrap = null;
/*  61 */     return t;
/*     */   }
/*     */   public static final class HitConfirmPayload extends Record implements class_8710 { private final int targetId; private final float damage; private final boolean headshot;
/*  64 */     public HitConfirmPayload(int targetId, float damage, boolean headshot) { this.targetId = targetId; this.damage = damage; this.headshot = headshot; } public final String toString() { // Byte code:
/*     */       //   0: aload_0
/*     */       //   1: <illegal opcode> toString : (Lnet/rustmine/combat/CombatTuning$HitConfirmPayload;)Ljava/lang/String;
/*     */       //   6: areturn
/*     */       // Line number table:
/*     */       //   Java source line number -> byte code offset
/*     */       //   #64	-> 0
/*     */       // Local variable table:
/*     */       //   start	length	slot	name	descriptor
/*  64 */       //   0	7	0	this	Lnet/rustmine/combat/CombatTuning$HitConfirmPayload; } public int targetId() { return this.targetId; } public final int hashCode() { // Byte code:
/*     */       //   0: aload_0
/*     */       //   1: <illegal opcode> hashCode : (Lnet/rustmine/combat/CombatTuning$HitConfirmPayload;)I
/*     */       //   6: ireturn
/*     */       // Line number table:
/*     */       //   Java source line number -> byte code offset
/*     */       //   #64	-> 0
/*     */       // Local variable table:
/*     */       //   start	length	slot	name	descriptor
/*     */       //   0	7	0	this	Lnet/rustmine/combat/CombatTuning$HitConfirmPayload; } public final boolean equals(Object o) { // Byte code:
/*     */       //   0: aload_0
/*     */       //   1: aload_1
/*     */       //   2: <illegal opcode> equals : (Lnet/rustmine/combat/CombatTuning$HitConfirmPayload;Ljava/lang/Object;)Z
/*     */       //   7: ireturn
/*     */       // Line number table:
/*     */       //   Java source line number -> byte code offset
/*     */       //   #64	-> 0
/*     */       // Local variable table:
/*     */       //   start	length	slot	name	descriptor
/*     */       //   0	8	0	this	Lnet/rustmine/combat/CombatTuning$HitConfirmPayload;
/*  64 */       //   0	8	1	o	Ljava/lang/Object; } public float damage() { return this.damage; } public boolean headshot() { return this.headshot; }
/*  65 */      public static final class_8710.class_9154<HitConfirmPayload> TYPE = new class_8710.class_9154(RustmineMod.id("hit_confirm")); public static final class_9139<class_9129, HitConfirmPayload> CODEC; static {
/*  66 */       CODEC = class_9139.method_56437((buf, p) -> {
/*     */             buf.method_10804(p.targetId);
/*     */             buf.method_52941(p.damage);
/*     */             buf.method_52964(p.headshot);
/*     */           }buf -> new HitConfirmPayload(buf.method_10816(), buf.readFloat(), buf.readBoolean()));
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public class_8710.class_9154<? extends class_8710> method_56479() {
/*  76 */       return (class_8710.class_9154)TYPE;
/*     */     } }
/*     */   public static final class RecoilSyncPayload extends Record implements class_8710 { private final float recoilScale; private final float spreadScale;
/*     */     
/*  80 */     public RecoilSyncPayload(float recoilScale, float spreadScale) { this.recoilScale = recoilScale; this.spreadScale = spreadScale; } public final String toString() { // Byte code:
/*     */       //   0: aload_0
/*     */       //   1: <illegal opcode> toString : (Lnet/rustmine/combat/CombatTuning$RecoilSyncPayload;)Ljava/lang/String;
/*     */       //   6: areturn
/*     */       // Line number table:
/*     */       //   Java source line number -> byte code offset
/*     */       //   #80	-> 0
/*     */       // Local variable table:
/*     */       //   start	length	slot	name	descriptor
/*     */       //   0	7	0	this	Lnet/rustmine/combat/CombatTuning$RecoilSyncPayload; } public final int hashCode() { // Byte code:
/*     */       //   0: aload_0
/*     */       //   1: <illegal opcode> hashCode : (Lnet/rustmine/combat/CombatTuning$RecoilSyncPayload;)I
/*     */       //   6: ireturn
/*     */       // Line number table:
/*     */       //   Java source line number -> byte code offset
/*     */       //   #80	-> 0
/*     */       // Local variable table:
/*     */       //   start	length	slot	name	descriptor
/*     */       //   0	7	0	this	Lnet/rustmine/combat/CombatTuning$RecoilSyncPayload; } public final boolean equals(Object o) { // Byte code:
/*     */       //   0: aload_0
/*     */       //   1: aload_1
/*     */       //   2: <illegal opcode> equals : (Lnet/rustmine/combat/CombatTuning$RecoilSyncPayload;Ljava/lang/Object;)Z
/*     */       //   7: ireturn
/*     */       // Line number table:
/*     */       //   Java source line number -> byte code offset
/*     */       //   #80	-> 0
/*     */       // Local variable table:
/*     */       //   start	length	slot	name	descriptor
/*     */       //   0	8	0	this	Lnet/rustmine/combat/CombatTuning$RecoilSyncPayload;
/*  80 */       //   0	8	1	o	Ljava/lang/Object; } public float recoilScale() { return this.recoilScale; } public float spreadScale() { return this.spreadScale; }
/*  81 */      public static final class_8710.class_9154<RecoilSyncPayload> TYPE = new class_8710.class_9154(RustmineMod.id("recoil_sync")); public static final class_9139<class_9129, RecoilSyncPayload> CODEC; static {
/*  82 */       CODEC = class_9139.method_56437((buf, p) -> {
/*     */             buf.method_52941(p.recoilScale);
/*     */             buf.method_52941(p.spreadScale);
/*     */           }buf -> new RecoilSyncPayload(buf.readFloat(), buf.readFloat()));
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public class_8710.class_9154<? extends class_8710> method_56479() {
/*  91 */       return (class_8710.class_9154)TYPE;
/*     */     } }
/*     */   public static final class TcAuthSyncPayload extends Record implements class_8710 { private final class_2338 pos; private final boolean authorized;
/*     */     
/*  95 */     public TcAuthSyncPayload(class_2338 pos, boolean authorized) { this.pos = pos; this.authorized = authorized; } public final String toString() { // Byte code:
/*     */       //   0: aload_0
/*     */       //   1: <illegal opcode> toString : (Lnet/rustmine/combat/CombatTuning$TcAuthSyncPayload;)Ljava/lang/String;
/*     */       //   6: areturn
/*     */       // Line number table:
/*     */       //   Java source line number -> byte code offset
/*     */       //   #95	-> 0
/*     */       // Local variable table:
/*     */       //   start	length	slot	name	descriptor
/*     */       //   0	7	0	this	Lnet/rustmine/combat/CombatTuning$TcAuthSyncPayload; } public final int hashCode() { // Byte code:
/*     */       //   0: aload_0
/*     */       //   1: <illegal opcode> hashCode : (Lnet/rustmine/combat/CombatTuning$TcAuthSyncPayload;)I
/*     */       //   6: ireturn
/*     */       // Line number table:
/*     */       //   Java source line number -> byte code offset
/*     */       //   #95	-> 0
/*     */       // Local variable table:
/*     */       //   start	length	slot	name	descriptor
/*     */       //   0	7	0	this	Lnet/rustmine/combat/CombatTuning$TcAuthSyncPayload; } public final boolean equals(Object o) { // Byte code:
/*     */       //   0: aload_0
/*     */       //   1: aload_1
/*     */       //   2: <illegal opcode> equals : (Lnet/rustmine/combat/CombatTuning$TcAuthSyncPayload;Ljava/lang/Object;)Z
/*     */       //   7: ireturn
/*     */       // Line number table:
/*     */       //   Java source line number -> byte code offset
/*     */       //   #95	-> 0
/*     */       // Local variable table:
/*     */       //   start	length	slot	name	descriptor
/*     */       //   0	8	0	this	Lnet/rustmine/combat/CombatTuning$TcAuthSyncPayload;
/*  95 */       //   0	8	1	o	Ljava/lang/Object; } public class_2338 pos() { return this.pos; } public boolean authorized() { return this.authorized; }
/*  96 */      public static final class_8710.class_9154<TcAuthSyncPayload> TYPE = new class_8710.class_9154(RustmineMod.id("tc_auth_sync")); public static final class_9139<class_9129, TcAuthSyncPayload> CODEC; static {
/*  97 */       CODEC = class_9139.method_56437((buf, p) -> {
/*     */             buf.method_10807(p.pos);
/*     */             buf.method_52964(p.authorized);
/*     */           }buf -> new TcAuthSyncPayload(buf.method_10811(), buf.readBoolean()));
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public class_8710.class_9154<? extends class_8710> method_56479() {
/* 106 */       return (class_8710.class_9154)TYPE;
/*     */     } }
/*     */   public static final class ContainerPreviewPayload extends Record implements class_8710 { private final class_2338 pos;
/*     */     
/* 110 */     public ContainerPreviewPayload(class_2338 pos) { this.pos = pos; } public final String toString() { // Byte code:
/*     */       //   0: aload_0
/*     */       //   1: <illegal opcode> toString : (Lnet/rustmine/combat/CombatTuning$ContainerPreviewPayload;)Ljava/lang/String;
/*     */       //   6: areturn
/*     */       // Line number table:
/*     */       //   Java source line number -> byte code offset
/*     */       //   #110	-> 0
/*     */       // Local variable table:
/*     */       //   start	length	slot	name	descriptor
/*     */       //   0	7	0	this	Lnet/rustmine/combat/CombatTuning$ContainerPreviewPayload; } public final int hashCode() { // Byte code:
/*     */       //   0: aload_0
/*     */       //   1: <illegal opcode> hashCode : (Lnet/rustmine/combat/CombatTuning$ContainerPreviewPayload;)I
/*     */       //   6: ireturn
/*     */       // Line number table:
/*     */       //   Java source line number -> byte code offset
/*     */       //   #110	-> 0
/*     */       // Local variable table:
/*     */       //   start	length	slot	name	descriptor
/*     */       //   0	7	0	this	Lnet/rustmine/combat/CombatTuning$ContainerPreviewPayload; } public final boolean equals(Object o) { // Byte code:
/*     */       //   0: aload_0
/*     */       //   1: aload_1
/*     */       //   2: <illegal opcode> equals : (Lnet/rustmine/combat/CombatTuning$ContainerPreviewPayload;Ljava/lang/Object;)Z
/*     */       //   7: ireturn
/*     */       // Line number table:
/*     */       //   Java source line number -> byte code offset
/*     */       //   #110	-> 0
/*     */       // Local variable table:
/*     */       //   start	length	slot	name	descriptor
/*     */       //   0	8	0	this	Lnet/rustmine/combat/CombatTuning$ContainerPreviewPayload;
/* 110 */       //   0	8	1	o	Ljava/lang/Object; } public class_2338 pos() { return this.pos; }
/* 111 */      public static final class_8710.class_9154<ContainerPreviewPayload> TYPE = new class_8710.class_9154(RustmineMod.id("container_preview")); public static final class_9139<class_9129, ContainerPreviewPayload> CODEC; static {
/* 112 */       CODEC = class_9139.method_56437((buf, p) -> buf.method_10807(p.pos), buf -> new ContainerPreviewPayload(buf.method_10811()));
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public class_8710.class_9154<? extends class_8710> method_56479() {
/* 118 */       return (class_8710.class_9154)TYPE;
/*     */     } }
/*     */   public static final class ClaimBonusPayload extends Record implements class_8710 { private final String rewardId; private final int amount;
/*     */     
/* 122 */     public ClaimBonusPayload(String rewardId, int amount) { this.rewardId = rewardId; this.amount = amount; } public final String toString() { // Byte code:
/*     */       //   0: aload_0
/*     */       //   1: <illegal opcode> toString : (Lnet/rustmine/combat/CombatTuning$ClaimBonusPayload;)Ljava/lang/String;
/*     */       //   6: areturn
/*     */       // Line number table:
/*     */       //   Java source line number -> byte code offset
/*     */       //   #122	-> 0
/*     */       // Local variable table:
/*     */       //   start	length	slot	name	descriptor
/*     */       //   0	7	0	this	Lnet/rustmine/combat/CombatTuning$ClaimBonusPayload; } public final int hashCode() { // Byte code:
/*     */       //   0: aload_0
/*     */       //   1: <illegal opcode> hashCode : (Lnet/rustmine/combat/CombatTuning$ClaimBonusPayload;)I
/*     */       //   6: ireturn
/*     */       // Line number table:
/*     */       //   Java source line number -> byte code offset
/*     */       //   #122	-> 0
/*     */       // Local variable table:
/*     */       //   start	length	slot	name	descriptor
/*     */       //   0	7	0	this	Lnet/rustmine/combat/CombatTuning$ClaimBonusPayload; } public final boolean equals(Object o) { // Byte code:
/*     */       //   0: aload_0
/*     */       //   1: aload_1
/*     */       //   2: <illegal opcode> equals : (Lnet/rustmine/combat/CombatTuning$ClaimBonusPayload;Ljava/lang/Object;)Z
/*     */       //   7: ireturn
/*     */       // Line number table:
/*     */       //   Java source line number -> byte code offset
/*     */       //   #122	-> 0
/*     */       // Local variable table:
/*     */       //   start	length	slot	name	descriptor
/*     */       //   0	8	0	this	Lnet/rustmine/combat/CombatTuning$ClaimBonusPayload;
/* 122 */       //   0	8	1	o	Ljava/lang/Object; } public String rewardId() { return this.rewardId; } public int amount() { return this.amount; }
/* 123 */      public static final class_8710.class_9154<ClaimBonusPayload> TYPE = new class_8710.class_9154(RustmineMod.id("claim_bonus")); public static final class_9139<class_9129, ClaimBonusPayload> CODEC; static {
/* 124 */       CODEC = class_9139.method_56437((buf, p) -> {
/*     */             buf.method_10788(p.rewardId, 64);
/*     */             buf.method_10804(p.amount);
/*     */           }buf -> new ClaimBonusPayload(buf.method_10800(64), buf.method_10816()));
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public class_8710.class_9154<? extends class_8710> method_56479() {
/* 133 */       return (class_8710.class_9154)TYPE;
/*     */     } }
/*     */ 
/*     */   
/*     */   public static void registerPayloads() {
/* 138 */     PayloadTypeRegistry.playC2S().register(HitConfirmPayload.TYPE, HitConfirmPayload.CODEC);
/* 139 */     PayloadTypeRegistry.playC2S().register(RecoilSyncPayload.TYPE, RecoilSyncPayload.CODEC);
/* 140 */     PayloadTypeRegistry.playC2S().register(TcAuthSyncPayload.TYPE, TcAuthSyncPayload.CODEC);
/* 141 */     PayloadTypeRegistry.playC2S().register(ContainerPreviewPayload.TYPE, ContainerPreviewPayload.CODEC);
/* 142 */     PayloadTypeRegistry.playC2S().register(ClaimBonusPayload.TYPE, ClaimBonusPayload.CODEC);
/*     */   }
/*     */ }


/* Location:              C:\Users\SystemX\AppData\Local\IceCubeRust\game\mods\rustmine-0.1.2.jar!\net\rustmine\combat\CombatTuning.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */
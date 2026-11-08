/*     */ package net.rustmine.auth;
/*     */ 
/*     */ import com.google.gson.JsonArray;
/*     */ import com.google.gson.JsonElement;
/*     */ import com.google.gson.JsonObject;
/*     */ import com.google.gson.JsonParser;
/*     */ import io.netty.buffer.Unpooled;
/*     */ import java.net.URI;
/*     */ import java.net.http.HttpClient;
/*     */ import java.net.http.HttpRequest;
/*     */ import java.net.http.HttpResponse;
/*     */ import java.security.SecureRandom;
/*     */ import java.time.Duration;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.HashSet;
/*     */ import java.util.HexFormat;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Objects;
/*     */ import java.util.Set;
/*     */ import java.util.WeakHashMap;
/*     */ import java.util.concurrent.CompletableFuture;
/*     */ import java.util.concurrent.Executor;
/*     */ import net.fabricmc.api.EnvType;
/*     */ import net.fabricmc.fabric.api.networking.v1.LoginPacketSender;
/*     */ import net.fabricmc.fabric.api.networking.v1.PacketSender;
/*     */ import net.fabricmc.fabric.api.networking.v1.ServerLoginConnectionEvents;
/*     */ import net.fabricmc.fabric.api.networking.v1.ServerLoginNetworking;
/*     */ import net.fabricmc.loader.api.FabricLoader;
/*     */ import net.minecraft.class_2540;
/*     */ import net.minecraft.class_2561;
/*     */ import net.minecraft.class_2960;
/*     */ import net.minecraft.class_3248;
/*     */ import net.minecraft.server.MinecraftServer;
/*     */ import net.rustmine.anticheat.AntiCheatHooks;
/*     */ import net.rustmine.mixin.ServerLoginAccessor;
/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.LoggerFactory;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class LoginGate
/*     */ {
/*  46 */   private static final Logger LOGGER = LoggerFactory.getLogger("rustmine");
/*     */   
/*  48 */   public static final class_2960 CHANNEL = class_2960.method_60655("rustmine", "login_auth");
/*     */   private static final String DEFAULT_URL = "http://127.0.0.1:8000/api/game/verify";
/*     */   private static final String ONLY_LAUNCHER = "Заходить на сервер можно только через лаунчер ICECUBE RUST";
/*  51 */   private static final SecureRandom RANDOM = new SecureRandom();
/*  52 */   private static final Map<class_3248, String> NONCES = Collections.synchronizedMap(new WeakHashMap<>());
/*     */   
/*     */   private static final String DEFAULT_MANIFEST = "http://127.0.0.1:8080/manifest.json";
/*     */   private static HttpClient http;
/*     */   private static String manifestUrl;
/*     */   private static boolean checkMods = true;
/*     */   private static volatile Set<String> allowedMods;
/*     */   private static volatile long allowedAt;
/*     */   
/*     */   public static void init() {
/*  62 */     if (FabricLoader.getInstance().getEnvironmentType() != EnvType.SERVER)
/*  63 */       return;  if ("off".equalsIgnoreCase(setting("rustmine.auth", "RUSTMINE_AUTH"))) {
/*  64 */       LOGGER.warn("[auth] login gate is OFF - anyone can join");
/*     */       return;
/*     */     } 
/*  67 */     String secret = setting("rustmine.auth.secret", "RUSTMINE_AUTH_SECRET");
/*  68 */     String url = setting("rustmine.auth.url", "RUSTMINE_AUTH_URL");
/*  69 */     String endpoint = (url == null || url.isBlank()) ? "http://127.0.0.1:8000/api/game/verify" : url;
/*  70 */     if (secret == null || secret.isBlank()) {
/*  71 */       LOGGER.error("[auth] no rustmine.auth.secret / RUSTMINE_AUTH_SECRET: every login will be refused");
/*     */     }
/*  73 */     String manifest = setting("rustmine.auth.manifest", "RUSTMINE_AUTH_MANIFEST");
/*  74 */     manifestUrl = (manifest == null || manifest.isBlank()) ? "http://127.0.0.1:8080/manifest.json" : manifest;
/*  75 */     checkMods = !"off".equalsIgnoreCase(setting("rustmine.auth.mods", "RUSTMINE_AUTH_MODS"));
/*  76 */     if (!checkMods) LOGGER.warn("[auth] mod check is OFF - modified clients can join"); 
/*  77 */     http = HttpClient.newBuilder().connectTimeout(Duration.ofSeconds(4L)).build();
/*     */     
/*  79 */     ServerLoginConnectionEvents.QUERY_START.register((handler, server, sender, synchronizer) -> {
/*     */           byte[] raw = new byte[16];
/*     */           
/*     */           RANDOM.nextBytes(raw);
/*     */           String nonce = HexFormat.of().formatHex(raw);
/*     */           NONCES.put(handler, nonce);
/*     */           class_2540 buf = new class_2540(Unpooled.buffer());
/*     */           buf.method_10814(nonce);
/*     */           sender.sendPacket(CHANNEL, buf);
/*     */         });
/*  89 */     ServerLoginNetworking.registerGlobalReceiver(CHANNEL, (server, handler, understood, buf, synchronizer, sender) -> {
/*     */           String ticket; String mac; String nonce = NONCES.remove(handler); if (!understood || nonce == null || secret == null || secret.isBlank()) {
/*     */             handler.method_14380((class_2561)class_2561.method_43470("Заходить на сервер можно только через лаунчер ICECUBE RUST")); return;
/*     */           } 
/*     */           Set<String> mods = new HashSet<>();
/*     */           List<String> hwid = new ArrayList<>();
/*     */           try {
/*     */             ticket = buf.method_10800(64);
/*     */             mac = buf.method_10800(128);
/*     */             int count = buf.method_10816();
/*     */             if (count < 0 || count > 256)
/*     */               throw new IllegalArgumentException("mods"); 
/*     */             for (int i = 0; i < count; i++)
/*     */               mods.add(buf.method_10800(64).toLowerCase()); 
/*     */             if (buf.readableBytes() > 0) {
/*     */               int hwCount = buf.method_10816();
/*     */               if (hwCount < 0 || hwCount > 16)
/*     */                 throw new IllegalArgumentException("hwid"); 
/*     */               for (int j = 0; j < hwCount; j++)
/*     */                 hwid.add(buf.method_10800(64).toLowerCase()); 
/*     */             } 
/* 110 */           } catch (RuntimeException e) {
/*     */             handler.method_14380((class_2561)class_2561.method_43470("Заходить на сервер можно только через лаунчер ICECUBE RUST"));
/*     */             return;
/*     */           } 
/*     */           String name = ((ServerLoginAccessor)handler).rustmine$requestedUsername();
/*     */           if (name == null || name.isBlank()) {
/*     */             handler.method_14380((class_2561)class_2561.method_43470("Заходить на сервер можно только через лаунчер ICECUBE RUST"));
/*     */             return;
/*     */           } 
/*     */           CompletableFuture<Void> check = CompletableFuture.supplyAsync(()).thenAcceptAsync((), (Executor)server);
/*     */           synchronizer.waitFor(check);
/*     */         });
/*     */   }
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
/*     */   private static String verify(String endpoint, String secret, String name, String ticket, String nonce, String mac, List<String> hwid) {
/*     */     try {
/* 138 */       JsonObject body = new JsonObject();
/* 139 */       body.addProperty("secret", secret);
/* 140 */       body.addProperty("username", name);
/* 141 */       body.addProperty("ticket", ticket);
/* 142 */       body.addProperty("nonce", nonce);
/* 143 */       body.addProperty("mac", mac);
/*     */       
/* 145 */       JsonArray hw = new JsonArray();
/* 146 */       if (hwid != null) { Objects.requireNonNull(hw); hwid.forEach(hw::add); }
/* 147 */        body.add("hwid", (JsonElement)hw);
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 152 */       HttpRequest req = HttpRequest.newBuilder(URI.create(endpoint)).timeout(Duration.ofSeconds(5L)).header("Content-Type", "application/json").POST(HttpRequest.BodyPublishers.ofString(body.toString())).build();
/* 153 */       HttpResponse<String> res = http.send(req, HttpResponse.BodyHandlers.ofString());
/* 154 */       if (res.statusCode() != 200) return "site_" + res.statusCode(); 
/* 155 */       JsonObject json = JsonParser.parseString(res.body()).getAsJsonObject();
/* 156 */       if (json.has("ok") && json.get("ok").getAsBoolean()) { AntiCheatHooks.impl.verified(name, json, hwid); return null; }
/* 157 */        return json.has("reason") ? json.get("reason").getAsString() : "denied";
/* 158 */     } catch (Exception e) {
/* 159 */       LOGGER.warn("[auth] site check failed: {}", e.toString());
/* 160 */       return "unreachable";
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private static String checkMods(Set<String> clientMods) {
/* 166 */     Set<String> allowed = allowedMods();
/* 167 */     if (allowed == null) return "unreachable"; 
/* 168 */     if (!allowed.equals(clientMods)) {
/* 169 */       Set<String> extra = new HashSet<>(clientMods);
/* 170 */       extra.removeAll(allowed);
/* 171 */       Set<String> missing = new HashSet<>(allowed);
/* 172 */       missing.removeAll(clientMods);
/* 173 */       LOGGER.info("[auth] mod set differs: {} unknown, {} missing (unknown: {})", new Object[] { Integer.valueOf(extra.size()), Integer.valueOf(missing.size()), extra });
/* 174 */       return "mods";
/*     */     } 
/* 176 */     return null;
/*     */   }
/*     */   
/*     */   private static synchronized Set<String> allowedMods() {
/* 180 */     long now = System.currentTimeMillis();
/* 181 */     if (allowedMods != null && now - allowedAt < 60000L) return allowedMods; 
/*     */     try {
/* 183 */       HttpRequest req = HttpRequest.newBuilder(URI.create(manifestUrl)).timeout(Duration.ofSeconds(5L)).GET().build();
/* 184 */       HttpResponse<String> res = http.send(req, HttpResponse.BodyHandlers.ofString());
/* 185 */       if (res.statusCode() != 200) throw new IllegalStateException("HTTP " + res.statusCode()); 
/* 186 */       Set<String> set = new HashSet<>();
/* 187 */       for (JsonElement e : JsonParser.parseString(res.body()).getAsJsonObject().getAsJsonArray("files")) {
/* 188 */         JsonObject f = e.getAsJsonObject();
/* 189 */         String path = f.get("path").getAsString();
/* 190 */         if ((path.startsWith("mods/") && path.toLowerCase().endsWith(".jar")) || (path.startsWith("rustmine/packs/") && path.toLowerCase().endsWith(".rmv"))) set.add(f.get("sha1").getAsString().toLowerCase()); 
/*     */       } 
/* 192 */       if (set.isEmpty()) throw new IllegalStateException("no mods in manifest"); 
/* 193 */       allowedMods = set;
/* 194 */       allowedAt = now;
/* 195 */     } catch (Exception e) {
/* 196 */       LOGGER.warn("[auth] cannot read the pack manifest {}: {}{}", new Object[] { manifestUrl, e.toString(), 
/* 197 */             (allowedMods != null) ? " (using the last good list)" : "" });
/*     */     } 
/* 199 */     return allowedMods;
/*     */   }
/*     */   
/*     */   private static String message(String reason) {
/* 203 */     switch (reason) { case "mods": case "banned": case "hwid_banned": case "no_access": case "unreachable":  }  return 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 209 */       "Не удалось подтвердить вход. Перезапустите лаунчер и зайдите заново";
/*     */   }
/*     */ 
/*     */   
/*     */   private static String setting(String property, String env) {
/* 214 */     String v = System.getProperty(property);
/* 215 */     return (v != null) ? v : System.getenv(env);
/*     */   }
/*     */ }


/* Location:              C:\Users\SystemX\AppData\Local\IceCubeRust\game\mods\rustmine-0.1.2.jar!\net\rustmine\auth\LoginGate.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */
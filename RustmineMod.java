/*     */ package net.rustmine;
/*     */ 
/*     */ import com.google.gson.JsonElement;
/*     */ import com.google.gson.JsonParser;
/*     */ import java.io.InputStream;
/*     */ import java.io.InputStreamReader;
/*     */ import java.nio.charset.StandardCharsets;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import net.fabricmc.api.ModInitializer;
/*     */ import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
/*     */ import net.minecraft.class_1297;
/*     */ import net.minecraft.class_1299;
/*     */ import net.minecraft.class_1542;
/*     */ import net.minecraft.class_1657;
/*     */ import net.minecraft.class_1792;
/*     */ import net.minecraft.class_1799;
/*     */ import net.minecraft.class_1937;
/*     */ import net.minecraft.class_2338;
/*     */ import net.minecraft.class_2378;
/*     */ import net.minecraft.class_2400;
/*     */ import net.minecraft.class_2960;
/*     */ import net.minecraft.class_3414;
/*     */ import net.minecraft.class_5321;
/*     */ import net.minecraft.class_7923;
/*     */ import net.rustmine.animal.RustAnimalEntity;
/*     */ import net.rustmine.auth.LoginGate;
/*     */ import net.rustmine.building.BuildingEntity;
/*     */ import net.rustmine.building.DoorEntity;
/*     */ import net.rustmine.claim.ToolCupboardEntity;
/*     */ import net.rustmine.combat.RustAmmo;
/*     */ import net.rustmine.combat.RustWeapons;
/*     */ import net.rustmine.config.RustConfigManager;
/*     */ import net.rustmine.decor.DecorEntity;
/*     */ import net.rustmine.deploy.RustDeployableEntity;
/*     */ import net.rustmine.init.RustmineEntities;
/*     */ import net.rustmine.init.RustmineEvents;
/*     */ import net.rustmine.init.RustmineItems;
/*     */ import net.rustmine.init.RustmineNetworking;
/*     */ import net.rustmine.init.RustmineSounds;
/*     */ import net.rustmine.init.RustmineTabs;
/*     */ import net.rustmine.monument.RustCrateEntity;
/*     */ import net.rustmine.monument.RustPropEntity;
/*     */ import net.rustmine.monument.baked.BakedMonuments;
/*     */ import net.rustmine.raid.PlacedExplosiveEntity;
/*     */ import net.rustmine.raid.ThrownExplosiveEntity;
/*     */ import net.rustmine.resource.RustOreNodeEntity;
/*     */ import net.rustmine.respawn.SleepingBagEntity;
/*     */ import net.rustmine.seat.SeatConfig;
/*     */ import net.rustmine.vault.Vault;
/*     */ import net.rustmine.voice.VoiceMod;
/*     */ import net.rustmine.world.NoVanillaMobs;
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
/*     */ public class RustmineMod
/*     */   implements ModInitializer
/*     */ {
/*     */   public static final String ID = "rustmine";
/*  78 */   public static final Map<String, class_3414> SOUNDS = RustmineSounds.SOUNDS;
/*  79 */   public static final class_3414 SHOT = RustmineSounds.SHOT;
/*  80 */   public static final class_3414 DEPLOY = RustmineSounds.DEPLOY;
/*  81 */   public static final class_3414 DRYFIRE = RustmineSounds.DRYFIRE;
/*  82 */   public static final class_3414 RELOAD_START = RustmineSounds.RELOAD_START;
/*  83 */   public static final class_3414 GRAB_MAG = RustmineSounds.GRAB_MAG;
/*  84 */   public static final class_3414 INSERT_MAG = RustmineSounds.INSERT_MAG;
/*  85 */   public static final class_3414 BOLT_BACK = RustmineSounds.BOLT_BACK;
/*  86 */   public static final class_3414 BOLT_FORWARD = RustmineSounds.BOLT_FORWARD;
/*  87 */   public static final class_3414 HITMARKER = RustmineSounds.HITMARKER;
/*  88 */   public static final class_3414 HEADSHOT = RustmineSounds.HEADSHOT;
/*  89 */   public static final class_3414 HIT_FLESH = RustmineSounds.HIT_FLESH;
/*  90 */   public static final class_3414 CRATE_OPEN = RustmineSounds.CRATE_OPEN;
/*  91 */   public static final class_3414 CRATE_BREAK = RustmineSounds.CRATE_BREAK;
/*  92 */   public static final class_3414 BARREL_HIT = RustmineSounds.BARREL_HIT;
/*  93 */   public static final class_3414 BARREL_BREAK = RustmineSounds.BARREL_BREAK;
/*     */   
/*  95 */   public static final class_3414 PLAYER_KNOCKDOWN = RustmineSounds.PLAYER_KNOCKDOWN;
/*  96 */   public static final class_3414 PLAYER_WOUNDED_LOOP = RustmineSounds.PLAYER_WOUNDED_LOOP;
/*  97 */   public static final class_3414 PLAYER_SCREAM = RustmineSounds.PLAYER_SCREAM;
/*  98 */   public static final class_3414 PLAYER_DEATH = RustmineSounds.PLAYER_DEATH;
/*  99 */   public static final class_3414 PLAYER_BODYFALL = RustmineSounds.PLAYER_BODYFALL;
/*     */   
/* 101 */   public static final class_3414 UI_ITEM_CLOTH = RustmineSounds.UI_ITEM_CLOTH;
/* 102 */   public static final class_3414 UI_ITEM_METAL = RustmineSounds.UI_ITEM_METAL;
/* 103 */   public static final class_3414 UI_ITEM_WOOD = RustmineSounds.UI_ITEM_WOOD;
/* 104 */   public static final class_3414 UI_ITEM_AMMO = RustmineSounds.UI_ITEM_AMMO;
/* 105 */   public static final class_3414 UI_ITEM_WEAPON = RustmineSounds.UI_ITEM_WEAPON;
/* 106 */   public static final class_3414 UI_ITEM_COMPONENT = RustmineSounds.UI_ITEM_COMPONENT;
/* 107 */   public static final class_3414 UI_ITEM_STONE = RustmineSounds.UI_ITEM_STONE;
/* 108 */   public static final class_3414 UI_ITEM_FOOD = RustmineSounds.UI_ITEM_FOOD;
/* 109 */   public static final class_3414 UI_ITEM_CAN = RustmineSounds.UI_ITEM_CAN;
/* 110 */   public static final class_3414 UI_ITEM_PAPER = RustmineSounds.UI_ITEM_PAPER;
/* 111 */   public static final class_3414 UI_ITEM_GENERIC = RustmineSounds.UI_ITEM_GENERIC;
/* 112 */   public static final class_3414 UI_HOVER_LOOT = RustmineSounds.UI_HOVER_LOOT;
/*     */   
/* 114 */   public static final class_3414 C4_TIMER = RustmineSounds.C4_TIMER;
/* 115 */   public static final class_3414 C4_ARM = RustmineSounds.C4_ARM;
/* 116 */   public static final class_3414 C4_STICK = RustmineSounds.C4_STICK;
/* 117 */   public static final class_3414 C4_EXPLOSION = RustmineSounds.C4_EXPLOSION;
/* 118 */   public static final class_3414 SATCHEL_DEPLOY = RustmineSounds.SATCHEL_DEPLOY;
/* 119 */   public static final class_3414 SATCHEL_FUSE = RustmineSounds.SATCHEL_FUSE;
/* 120 */   public static final class_3414 SATCHEL_EXPLOSION = RustmineSounds.SATCHEL_EXPLOSION;
/* 121 */   public static final class_3414 BEANCAN_DEPLOY = RustmineSounds.BEANCAN_DEPLOY;
/* 122 */   public static final class_3414 BEANCAN_FUSE = RustmineSounds.BEANCAN_FUSE;
/* 123 */   public static final class_3414 BEANCAN_LIGHT = RustmineSounds.BEANCAN_LIGHT;
/* 124 */   public static final class_3414 BEANCAN_BOUNCE = RustmineSounds.BEANCAN_BOUNCE;
/* 125 */   public static final class_3414 BEANCAN_EXPLOSION = RustmineSounds.BEANCAN_EXPLOSION;
/*     */   
/* 127 */   public static final class_3414 RECYCLER_START = RustmineSounds.RECYCLER_START;
/* 128 */   public static final class_3414 RECYCLER_LOOP = RustmineSounds.RECYCLER_LOOP;
/* 129 */   public static final class_3414 RECYCLER_STOP = RustmineSounds.RECYCLER_STOP;
/* 130 */   public static final class_3414 RECYCLER_ERROR = RustmineSounds.RECYCLER_ERROR;
/* 131 */   public static final class_3414 RECYCLER_OPEN = RustmineSounds.RECYCLER_OPEN;
/* 132 */   public static final class_3414 RECYCLER_CLOSE = RustmineSounds.RECYCLER_CLOSE;
/*     */   
/* 134 */   public static final class_3414 BLUEPRINT_UNLOCK = RustmineSounds.BLUEPRINT_UNLOCK;
/* 135 */   public static final class_3414 RESEARCH_TABLE_LOOP = RustmineSounds.RESEARCH_TABLE_LOOP;
/* 136 */   public static final class_3414 RESEARCH_TABLE_SUCCESS = RustmineSounds.RESEARCH_TABLE_SUCCESS;
/* 137 */   public static final class_3414 RESEARCH_TABLE_OPEN = RustmineSounds.RESEARCH_TABLE_OPEN;
/* 138 */   public static final class_3414 RESEARCH_TABLE_CLOSE = RustmineSounds.RESEARCH_TABLE_CLOSE;
/*     */   
/* 140 */   public static final class_3414 MINING_SPARKLE = RustmineSounds.MINING_SPARKLE;
/* 141 */   public static final class_3414 MINING_FINISH = RustmineSounds.MINING_FINISH;
/* 142 */   public static final class_3414 MINING_FAIL = RustmineSounds.MINING_FAIL;
/* 143 */   public static final class_3414 ORE_BREAK = RustmineSounds.ORE_BREAK;
/* 144 */   public static final class_3414 ROCK_STRIKE = RustmineSounds.ROCK_STRIKE;
/* 145 */   public static final class_3414 TREE_MARKER_HIT = RustmineSounds.TREE_MARKER_HIT;
/* 146 */   public static final class_3414 TREE_CHOP = RustmineSounds.TREE_CHOP;
/* 147 */   public static final class_3414 TREE_CRACK = RustmineSounds.TREE_CRACK;
/* 148 */   public static final class_3414 TREE_FALL_START = RustmineSounds.TREE_FALL_START;
/* 149 */   public static final class_3414 TREE_FALL_IMPACT = RustmineSounds.TREE_FALL_IMPACT;
/*     */   
/* 151 */   public static final class_3414 ROCKET_ENGINE = RustmineSounds.ROCKET_ENGINE;
/* 152 */   public static final class_3414 ROCKET_EXPLOSION = RustmineSounds.ROCKET_EXPLOSION;
/* 153 */   public static final class_3414 ROCKET_ATTACK = RustmineSounds.ROCKET_ATTACK;
/*     */   
/*     */   public static class_3414 sound(String name) {
/* 156 */     return RustmineSounds.sound(name);
/*     */   }
/*     */   
/*     */   public static class_3414 getItemSound(class_1799 stack) {
/* 160 */     return RustmineSounds.getItemSound(stack);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 166 */   public static final class_5321<class_1792> PLANNER_KEY = RustmineItems.PLANNER_KEY;
/* 167 */   public static final class_1792 PLANNER = RustmineItems.PLANNER;
/* 168 */   public static final class_5321<class_1792> HAMMER_KEY = RustmineItems.HAMMER_KEY;
/* 169 */   public static final class_1792 HAMMER = RustmineItems.HAMMER;
/* 170 */   public static final class_5321<class_1792> BLUEPRINT_KEY = RustmineItems.BLUEPRINT_KEY;
/* 171 */   public static final class_1792 BLUEPRINT = RustmineItems.BLUEPRINT;
/*     */   
/* 173 */   public static final class_1792[] DOOR_ITEMS = RustmineItems.DOOR_ITEMS;
/* 174 */   public static final class_1792[] WINDOW_ITEMS = RustmineItems.WINDOW_ITEMS;
/*     */   
/* 176 */   public static final class_5321<class_1792> CODE_LOCK_KEY = RustmineItems.CODE_LOCK_KEY;
/* 177 */   public static final class_1792 CODE_LOCK = RustmineItems.CODE_LOCK;
/* 178 */   public static final class_5321<class_1792> KEY_LOCK_KEY = RustmineItems.KEY_LOCK_KEY;
/* 179 */   public static final class_1792 KEY_LOCK = RustmineItems.KEY_LOCK;
/*     */   
/* 181 */   public static final class_5321<class_1792> TC_KEY = RustmineItems.TC_KEY;
/* 182 */   public static final class_1792 TOOL_CUPBOARD = RustmineItems.TOOL_CUPBOARD;
/*     */   
/* 184 */   public static final class_5321<class_1792> BAG_KEY = RustmineItems.BAG_KEY;
/* 185 */   public static final class_1792 SLEEPING_BAG = RustmineItems.SLEEPING_BAG;
/*     */   
/* 187 */   public static final class_5321<class_1792> SATCHEL_KEY = RustmineItems.SATCHEL_KEY;
/* 188 */   public static final class_1792 SATCHEL = RustmineItems.SATCHEL;
/* 189 */   public static final class_5321<class_1792> C4_KEY = RustmineItems.C4_KEY;
/* 190 */   public static final class_1792 C4 = RustmineItems.C4;
/* 191 */   public static final class_5321<class_1792> BEANCAN_KEY = RustmineItems.BEANCAN_KEY;
/* 192 */   public static final class_1792 BEANCAN = RustmineItems.BEANCAN;
/*     */   
/* 194 */   public static final class_5321<class_1792> DEPLOY_LADDER_WOODEN_KEY = RustmineItems.DEPLOY_LADDER_WOODEN_KEY;
/* 195 */   public static final class_1792 DEPLOY_LADDER_WOODEN = RustmineItems.DEPLOY_LADDER_WOODEN;
/* 196 */   public static final class_5321<class_1792> DEPLOY_BOX_WOODEN_KEY = RustmineItems.DEPLOY_BOX_WOODEN_KEY;
/* 197 */   public static final class_1792 DEPLOY_BOX_WOODEN = RustmineItems.DEPLOY_BOX_WOODEN;
/* 198 */   public static final class_5321<class_1792> DEPLOY_BOX_LARGE_KEY = RustmineItems.DEPLOY_BOX_LARGE_KEY;
/* 199 */   public static final class_1792 DEPLOY_BOX_LARGE = RustmineItems.DEPLOY_BOX_LARGE;
/* 200 */   public static final class_5321<class_1792> DEPLOY_WORKBENCH_1_KEY = RustmineItems.DEPLOY_WORKBENCH_1_KEY;
/* 201 */   public static final class_1792 DEPLOY_WORKBENCH_1 = RustmineItems.DEPLOY_WORKBENCH_1;
/* 202 */   public static final class_5321<class_1792> DEPLOY_WORKBENCH_2_KEY = RustmineItems.DEPLOY_WORKBENCH_2_KEY;
/* 203 */   public static final class_1792 DEPLOY_WORKBENCH_2 = RustmineItems.DEPLOY_WORKBENCH_2;
/* 204 */   public static final class_5321<class_1792> DEPLOY_WORKBENCH_3_KEY = RustmineItems.DEPLOY_WORKBENCH_3_KEY;
/* 205 */   public static final class_1792 DEPLOY_WORKBENCH_3 = RustmineItems.DEPLOY_WORKBENCH_3;
/* 206 */   public static final class_5321<class_1792> DEPLOY_FURNACE_KEY = RustmineItems.DEPLOY_FURNACE_KEY;
/* 207 */   public static final class_1792 DEPLOY_FURNACE = RustmineItems.DEPLOY_FURNACE;
/* 208 */   public static final class_5321<class_1792> DEPLOY_LARGE_FURNACE_KEY = RustmineItems.DEPLOY_LARGE_FURNACE_KEY;
/* 209 */   public static final class_1792 DEPLOY_LARGE_FURNACE = RustmineItems.DEPLOY_LARGE_FURNACE;
/* 210 */   public static final class_5321<class_1792> DEPLOY_CAMPFIRE_KEY = RustmineItems.DEPLOY_CAMPFIRE_KEY;
/* 211 */   public static final class_1792 DEPLOY_CAMPFIRE = RustmineItems.DEPLOY_CAMPFIRE;
/* 212 */   public static final class_5321<class_1792> DEPLOY_RESEARCH_TABLE_KEY = RustmineItems.DEPLOY_RESEARCH_TABLE_KEY;
/* 213 */   public static final class_1792 DEPLOY_RESEARCH_TABLE = RustmineItems.DEPLOY_RESEARCH_TABLE;
/* 214 */   public static final class_5321<class_1792> DEPLOY_REPAIR_BENCH_KEY = RustmineItems.DEPLOY_REPAIR_BENCH_KEY;
/* 215 */   public static final class_1792 DEPLOY_REPAIR_BENCH = RustmineItems.DEPLOY_REPAIR_BENCH;
/* 216 */   public static final class_5321<class_1792> DEPLOY_RECYCLER_KEY = RustmineItems.DEPLOY_RECYCLER_KEY;
/* 217 */   public static final class_1792 DEPLOY_RECYCLER = RustmineItems.DEPLOY_RECYCLER;
/*     */   
/* 219 */   public static final class_5321<class_1792> RES_WOOD_KEY = RustmineItems.RES_WOOD_KEY;
/* 220 */   public static final class_1792 RES_WOOD = RustmineItems.RES_WOOD;
/* 221 */   public static final class_5321<class_1792> RES_STONES_KEY = RustmineItems.RES_STONES_KEY;
/* 222 */   public static final class_1792 RES_STONES = RustmineItems.RES_STONES;
/* 223 */   public static final class_5321<class_1792> RES_METAL_KEY = RustmineItems.RES_METAL_KEY;
/* 224 */   public static final class_1792 RES_METAL = RustmineItems.RES_METAL;
/* 225 */   public static final class_5321<class_1792> RES_HQM_KEY = RustmineItems.RES_HQM_KEY;
/* 226 */   public static final class_1792 RES_HQM = RustmineItems.RES_HQM;
/*     */   
/* 228 */   public static final class_1792 RES_CLOTH = RustmineItems.RES_CLOTH;
/* 229 */   public static final class_1792 RES_LEATHER = RustmineItems.RES_LEATHER;
/* 230 */   public static final class_1792 RES_FAT = RustmineItems.RES_FAT;
/* 231 */   public static final class_1792 RES_LGF = RustmineItems.RES_LGF;
/* 232 */   public static final class_1792 RES_GUNPOWDER = RustmineItems.RES_GUNPOWDER;
/* 233 */   public static final class_1792 RES_SULFUR = RustmineItems.RES_SULFUR;
/* 234 */   public static final class_1792 RES_SULFUR_ORE = RustmineItems.RES_SULFUR_ORE;
/* 235 */   public static final class_1792 RES_METAL_ORE = RustmineItems.RES_METAL_ORE;
/* 236 */   public static final class_1792 RES_HQM_ORE = RustmineItems.RES_HQM_ORE;
/* 237 */   public static final class_1792 RES_SCRAP = RustmineItems.RES_SCRAP;
/* 238 */   public static final class_1792 RES_CRUDE = RustmineItems.RES_CRUDE;
/* 239 */   public static final class_1792 RES_CHARCOAL = RustmineItems.RES_CHARCOAL;
/* 240 */   public static final class_1792 RES_BONE = RustmineItems.RES_BONE;
/* 241 */   public static final class_1792 SKULL_WOLF = RustmineItems.SKULL_WOLF;
/* 242 */   public static final class_1792 SKULL_HUMAN = RustmineItems.SKULL_HUMAN;
/* 243 */   public static final class_1792 RES_EXPLOSIVES = RustmineItems.RES_EXPLOSIVES;
/*     */   
/* 245 */   public static final class_1792 COMP_GEARS = RustmineItems.COMP_GEARS;
/* 246 */   public static final class_1792 COMP_PIPE = RustmineItems.COMP_PIPE;
/* 247 */   public static final class_1792 COMP_SPRING = RustmineItems.COMP_SPRING;
/* 248 */   public static final class_1792 COMP_ROPE = RustmineItems.COMP_ROPE;
/* 249 */   public static final class_1792 COMP_SEWING_KIT = RustmineItems.COMP_SEWING_KIT;
/* 250 */   public static final class_1792 COMP_ROAD_SIGNS = RustmineItems.COMP_ROAD_SIGNS;
/* 251 */   public static final class_1792 COMP_TECH_TRASH = RustmineItems.COMP_TECH_TRASH;
/* 252 */   public static final class_1792 COMP_BLADE = RustmineItems.COMP_BLADE;
/* 253 */   public static final class_1792 COMP_RIFLE_BODY = RustmineItems.COMP_RIFLE_BODY;
/* 254 */   public static final class_1792 COMP_SEMI_BODY = RustmineItems.COMP_SEMI_BODY;
/* 255 */   public static final class_1792 COMP_SMG_BODY = RustmineItems.COMP_SMG_BODY;
/* 256 */   public static final class_1792 COMP_TARP = RustmineItems.COMP_TARP;
/* 257 */   public static final class_1792 COMP_SHEET_METAL = RustmineItems.COMP_SHEET_METAL;
/* 258 */   public static final class_1792 COMP_PROPANE_TANK = RustmineItems.COMP_PROPANE_TANK;
/* 259 */   public static final class_1792 COMP_FUSE = RustmineItems.COMP_FUSE;
/* 260 */   public static final class_1792 COMP_CCTV = RustmineItems.COMP_CCTV;
/* 261 */   public static final class_1792 COMP_TARGETING_COMPUTER = RustmineItems.COMP_TARGETING_COMPUTER;
/* 262 */   public static final class_1792 COMP_DUCT_TAPE = RustmineItems.COMP_DUCT_TAPE;
/* 263 */   public static final class_1792 COMP_GLUE = RustmineItems.COMP_GLUE;
/* 264 */   public static final class_1792 COMP_BLEACH = RustmineItems.COMP_BLEACH;
/* 265 */   public static final class_1792 KEYCARD_GREEN = RustmineItems.KEYCARD_GREEN;
/* 266 */   public static final class_1792 FOOD_BEANS = RustmineItems.FOOD_BEANS;
/* 267 */   public static final class_1792 FOOD_TUNA = RustmineItems.FOOD_TUNA;
/* 268 */   public static final class_1792 MED_SYRINGE = RustmineItems.MED_SYRINGE;
/* 269 */   public static final class_1792 MED_BANDAGE = RustmineItems.MED_BANDAGE;
/* 270 */   public static final class_1792 MED_LARGEMEDKIT = RustmineItems.MED_LARGEMEDKIT;
/* 271 */   public static final class_1792 SMALL_WATER_BOTTLE = RustFoods.item("small_water_bottle");
/*     */   
/* 273 */   public static final class_1792 TOOL_ROCK = RustmineItems.TOOL_ROCK;
/* 274 */   public static final class_1792 TOOL_TORCH = RustmineItems.TOOL_TORCH;
/* 275 */   public static final class_1792 TOOL_STONE_HATCHET = RustmineItems.TOOL_STONE_HATCHET;
/* 276 */   public static final class_1792 TOOL_STONE_PICKAXE = RustmineItems.TOOL_STONE_PICKAXE;
/* 277 */   public static final class_1792 TOOL_HATCHET = RustmineItems.TOOL_HATCHET;
/* 278 */   public static final class_1792 TOOL_PICKAXE = RustmineItems.TOOL_PICKAXE;
/* 279 */   public static final class_1792 TOOL_SALVAGED_AXE = RustmineItems.TOOL_SALVAGED_AXE;
/* 280 */   public static final class_1792 TOOL_SALVAGED_ICEPICK = RustmineItems.TOOL_SALVAGED_ICEPICK;
/* 281 */   public static final class_1792 TOOL_SALVAGED_HAMMER = RustmineItems.TOOL_SALVAGED_HAMMER;
/* 282 */   public static final class_1792 TOOL_JACKHAMMER = RustmineItems.TOOL_JACKHAMMER;
/* 283 */   public static final class_1792 TOOL_CHAINSAW = RustmineItems.TOOL_CHAINSAW;
/* 284 */   public static final class_1792 TOOL_BONE_KNIFE = RustmineItems.TOOL_BONE_KNIFE;
/* 285 */   public static final class_1792 TOOL_COMBAT_KNIFE = RustmineItems.TOOL_COMBAT_KNIFE;
/* 286 */   public static final class_1792 TOOL_FLASHLIGHT = RustmineItems.TOOL_FLASHLIGHT;
/*     */   
/* 288 */   public static final class_1792 ARMOR_HAZMAT = RustmineItems.ARMOR_HAZMAT;
/* 289 */   public static final class_1792 ARMOR_METAL_FACEMASK = RustmineItems.ARMOR_METAL_FACEMASK;
/* 290 */   public static final class_1792 ARMOR_METAL_CHEST = RustmineItems.ARMOR_METAL_CHEST;
/* 291 */   public static final class_1792 ARMOR_ROADSIGN_JACKET = RustmineItems.ARMOR_ROADSIGN_JACKET;
/* 292 */   public static final class_1792 ARMOR_ROADSIGN_KILT = RustmineItems.ARMOR_ROADSIGN_KILT;
/* 293 */   public static final class_1792 ARMOR_COFFEECAN = RustmineItems.ARMOR_COFFEECAN;
/* 294 */   public static final class_1792 ARMOR_HOODIE = RustmineItems.ARMOR_HOODIE;
/* 295 */   public static final class_1792 ARMOR_PANTS = RustmineItems.ARMOR_PANTS;
/* 296 */   public static final class_1792 ARMOR_BOOTS = RustmineItems.ARMOR_BOOTS;
/* 297 */   public static final class_1792 ARMOR_BURLAP_SHIRT = RustmineItems.ARMOR_BURLAP_SHIRT;
/* 298 */   public static final class_1792 ARMOR_BURLAP_PANTS = RustmineItems.ARMOR_BURLAP_PANTS;
/* 299 */   public static final class_1792 ARMOR_BURLAP_HEADWRAP = RustmineItems.ARMOR_BURLAP_HEADWRAP;
/* 300 */   public static final class_1792 ARMOR_WOOD_HELMET = RustmineItems.ARMOR_WOOD_HELMET;
/* 301 */   public static final class_1792 ARMOR_WOOD_CHEST = RustmineItems.ARMOR_WOOD_CHEST;
/* 302 */   public static final class_1792 ARMOR_WOOD_PANTS = RustmineItems.ARMOR_WOOD_PANTS;
/* 303 */   public static final class_1792 ARMOR_GLOVES = RustmineItems.ARMOR_GLOVES;
/* 304 */   public static final class_1792 ARMOR_HEAVY_PLATE_HELMET = RustmineItems.ARMOR_HEAVY_PLATE_HELMET;
/* 305 */   public static final class_1792 ARMOR_HEAVY_PLATE_JACKET = RustmineItems.ARMOR_HEAVY_PLATE_JACKET;
/* 306 */   public static final class_1792 ARMOR_HEAVY_PLATE_PANTS = RustmineItems.ARMOR_HEAVY_PLATE_PANTS;
/* 307 */   public static final class_1792 ARMOR_BONE_HELMET = RustmineItems.ARMOR_BONE_HELMET;
/* 308 */   public static final class_1792 ARMOR_BONE_SUIT = RustmineItems.ARMOR_BONE_SUIT;
/* 309 */   public static final class_1792 ARMOR_WOLF_HEADDRESS = RustmineItems.ARMOR_WOLF_HEADDRESS;
/* 310 */   public static final class_1792 ARMOR_BUCKET_HELMET = RustmineItems.ARMOR_BUCKET_HELMET;
/* 311 */   public static final class_1792 ARMOR_RIOT_HELMET = RustmineItems.ARMOR_RIOT_HELMET;
/* 312 */   public static final class_1792 ARMOR_MINER_HAT = RustmineItems.ARMOR_MINER_HAT;
/* 313 */   public static final class_1792 ARMOR_CANDLE_HAT = RustmineItems.ARMOR_CANDLE_HAT;
/* 314 */   public static final class_1792 ARMOR_HIDE_VEST = RustmineItems.ARMOR_HIDE_VEST;
/* 315 */   public static final class_1792 ARMOR_HIDE_PANTS = RustmineItems.ARMOR_HIDE_PANTS;
/* 316 */   public static final class_1792 ARMOR_HIDE_BOOTS = RustmineItems.ARMOR_HIDE_BOOTS;
/* 317 */   public static final class_1792 ARMOR_BANDANA = RustmineItems.ARMOR_BANDANA;
/*     */   
/* 319 */   public static final class_1792 MINICOPTER = RustmineItems.MINICOPTER;
/* 320 */   public static final class_1792 SCRAP_HELI = RustmineItems.SCRAP_HELI;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 326 */   public static final class_5321<class_1299<?>> ROCKET_KEY = RustmineEntities.ROCKET_KEY;
/* 327 */   public static final class_1299<RocketEntity> ROCKET = RustmineEntities.ROCKET;
/*     */   
/* 329 */   public static final class_5321<class_1299<?>> DOOR_KEY = RustmineEntities.DOOR_KEY;
/* 330 */   public static final class_1299<DoorEntity> DOOR = RustmineEntities.DOOR;
/*     */   
/* 332 */   public static final class_5321<class_1299<?>> TC_ENTITY_KEY = RustmineEntities.TC_ENTITY_KEY;
/* 333 */   public static final class_1299<ToolCupboardEntity> TC_ENTITY = RustmineEntities.TC_ENTITY;
/*     */   
/* 335 */   public static final class_5321<class_1299<?>> BAG_ENTITY_KEY = RustmineEntities.BAG_ENTITY_KEY;
/* 336 */   public static final class_1299<SleepingBagEntity> BAG_ENTITY = RustmineEntities.BAG_ENTITY;
/*     */   
/* 338 */   public static final class_5321<class_1299<?>> DEPLOYABLE_ENTITY_KEY = RustmineEntities.DEPLOYABLE_ENTITY_KEY;
/* 339 */   public static final class_1299<RustDeployableEntity> DEPLOYABLE_ENTITY = RustmineEntities.DEPLOYABLE_ENTITY;
/*     */   
/* 341 */   public static final class_5321<class_1299<?>> EXPLOSIVE_ENTITY_KEY = RustmineEntities.EXPLOSIVE_ENTITY_KEY;
/* 342 */   public static final class_1299<PlacedExplosiveEntity> EXPLOSIVE_ENTITY = RustmineEntities.EXPLOSIVE_ENTITY;
/*     */   
/* 344 */   public static final class_5321<class_1299<?>> THROWN_EXPLOSIVE_KEY = RustmineEntities.THROWN_EXPLOSIVE_KEY;
/* 345 */   public static final class_1299<ThrownExplosiveEntity> THROWN_EXPLOSIVE = RustmineEntities.THROWN_EXPLOSIVE;
/*     */   
/* 347 */   public static final class_5321<class_1299<?>> CRATE_ENTITY_KEY = RustmineEntities.CRATE_ENTITY_KEY;
/* 348 */   public static final class_1299<RustCrateEntity> CRATE_ENTITY = RustmineEntities.CRATE_ENTITY;
/*     */   
/* 350 */   public static final class_5321<class_1299<?>> PROP_ENTITY_KEY = RustmineEntities.PROP_ENTITY_KEY;
/* 351 */   public static final class_1299<RustPropEntity> PROP_ENTITY = RustmineEntities.PROP_ENTITY;
/*     */   
/* 353 */   public static final class_5321<class_1299<?>> CORPSE_ENTITY_KEY = RustmineEntities.CORPSE_ENTITY_KEY;
/* 354 */   public static final class_1299<RustCorpseEntity> CORPSE_ENTITY = RustmineEntities.CORPSE_ENTITY;
/*     */   
/* 356 */   public static final class_5321<class_1299<?>> BACKPACK_ENTITY_KEY = RustmineEntities.BACKPACK_ENTITY_KEY;
/* 357 */   public static final class_1299<RustBackpackEntity> BACKPACK_ENTITY = RustmineEntities.BACKPACK_ENTITY;
/*     */   
/* 359 */   public static final class_5321<class_1299<?>> SLEEPER_ENTITY_KEY = RustmineEntities.SLEEPER_ENTITY_KEY;
/* 360 */   public static final class_1299<RustSleeperEntity> SLEEPER_ENTITY = RustmineEntities.SLEEPER_ENTITY;
/*     */   
/* 362 */   public static final class_5321<class_1299<?>> ORE_NODE_ENTITY_KEY = RustmineEntities.ORE_NODE_ENTITY_KEY;
/* 363 */   public static final class_1299<RustOreNodeEntity> ORE_NODE_ENTITY = RustmineEntities.ORE_NODE_ENTITY;
/*     */   
/* 365 */   public static final class_5321<class_1299<?>> DECOR_KEY = RustmineEntities.DECOR_KEY;
/* 366 */   public static final class_1299<DecorEntity> DECOR = RustmineEntities.DECOR;
/*     */   
/* 368 */   public static final class_5321<class_1299<?>> BUILDING_KEY = RustmineEntities.BUILDING_KEY;
/* 369 */   public static final class_1299<BuildingEntity> BUILDING = RustmineEntities.BUILDING;
/*     */   
/* 371 */   public static final class_5321<class_1299<?>> ANIMAL_ENTITY_KEY = RustmineEntities.ANIMAL_ENTITY_KEY;
/* 372 */   public static final class_1299<RustAnimalEntity> ANIMAL_ENTITY = RustmineEntities.ANIMAL_ENTITY;
/*     */ 
/*     */   
/* 375 */   public static final Map<String, class_2400> PARTICLES = new HashMap<>();
/*     */ 
/*     */ 
/*     */   
/* 379 */   public static float DAMAGE_SCALE = 0.16F;
/*     */   
/*     */   public static class_2960 id(String path) {
/* 382 */     return class_2960.method_60655("rustmine", path);
/*     */   }
/*     */   private static void registerParticles() {
/*     */     
/* 386 */     try { InputStream in = Vault.open("/assets/rustmine/fx/sprites.json"); 
/* 387 */       try { if (in != null) {
/* 388 */           for (JsonElement e : JsonParser.parseReader(new InputStreamReader(in, StandardCharsets.UTF_8)).getAsJsonArray()) {
/* 389 */             String name = e.getAsString();
/* 390 */             PARTICLES.put(name, (class_2400)class_2378.method_10230(class_7923.field_41180, id(name), FabricParticleTypes.simple(true)));
/*     */           } 
/*     */         }
/* 393 */         if (in != null) in.close();  } catch (Throwable throwable) { if (in != null) try { in.close(); } catch (Throwable throwable1) { throwable.addSuppressed(throwable1); }   throw throwable; }  } catch (Exception ex)
/* 394 */     { throw new RuntimeException("rustmine: can't read fx/sprites.json", ex); }
/*     */   
/*     */   }
/*     */ 
/*     */   
/*     */   public void onInitialize() {
/* 400 */     Vault.boot();
/* 401 */     LoginGate.init();
/* 402 */     RustConfigManager.init();
/* 403 */     VoiceMod.register();
/* 404 */     NoVanillaMobs.register();
/* 405 */     DAMAGE_SCALE = RustConfigManager.GLOBAL_DAMAGE_SCALE;
/*     */ 
/*     */     
/* 408 */     RustmineSounds.init();
/* 409 */     RustAmmo.init();
/* 410 */     BakedMonuments.init();
/* 411 */     RustWeapons.init();
/* 412 */     RustmineItems.init();
/* 413 */     RustmineEntities.init();
/*     */     
/* 415 */     ClassPreloader.preloadAll();
/* 416 */     registerParticles();
/* 417 */     RustSteps.register();
/*     */ 
/*     */     
/* 420 */     SeatConfig.load();
/*     */     
/* 422 */     RustmineNetworking.init();
/* 423 */     RustmineEvents.init();
/* 424 */     RustmineTabs.init();
/*     */   }
/*     */   
/*     */   public static void popResource(class_1937 level, class_2338 pos, class_1799 stack) {
/* 428 */     class_1542 it = new class_1542(level, pos.method_10263() + 0.5D, pos.method_10264() + 0.5D, pos.method_10260() + 0.5D, stack);
/* 429 */     level.method_8649((class_1297)it);
/*     */   }
/*     */   
/*     */   public static boolean consumePlayerItems(class_1657 player, class_1792 item, int count) {
/* 433 */     if (player.method_68878()) return true; 
/* 434 */     int found = 0;
/* 435 */     for (int i = 0; i < player.method_31548().method_5439(); i++) {
/* 436 */       class_1799 stack = player.method_31548().method_5438(i);
/* 437 */       if (stack.method_31574(item)) {
/* 438 */         found += stack.method_7947();
/*     */       }
/*     */     } 
/* 441 */     if (found < count) return false; 
/* 442 */     int remaining = count;
/* 443 */     for (int j = 0; j < player.method_31548().method_5439(); j++) {
/* 444 */       class_1799 stack = player.method_31548().method_5438(j);
/* 445 */       if (stack.method_31574(item)) {
/* 446 */         int take = Math.min(stack.method_7947(), remaining);
/* 447 */         stack.method_7934(take);
/* 448 */         remaining -= take;
/* 449 */         if (remaining <= 0)
/*     */           break; 
/*     */       } 
/* 452 */     }  return true;
/*     */   }
/*     */   
/*     */   public static boolean isVehicle(class_1297 entity) {
/* 456 */     return (entity instanceof com.rustminicopter.entity.MinicopterEntity || entity instanceof com.rustboats.entity.RustBoat || entity instanceof net.minecraft.class_8836);
/*     */   }
/*     */ }


/* Location:              C:\Users\SystemX\AppData\Local\IceCubeRust\game\mods\rustmine-0.1.2.jar!\net\rustmine\RustmineMod.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */
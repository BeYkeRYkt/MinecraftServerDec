package net.minecraft;

import com.google.common.collect.Lists;
import java.util.List;

public class tl {

	public static int a;
	public static int b;
	public static int c;
	public static int d;
	public static List e = Lists.newArrayList();
	public static tk f = (new tk("achievement.openInventory", "openInventory", 0, 0, Items.BOOK, (tk) null)).a().c();
	public static tk g = (new tk("achievement.mineWood", "mineWood", 2, 1, Blocks.LOG, f)).c();
	public static tk h = (new tk("achievement.buildWorkBench", "buildWorkBench", 4, -1, Blocks.CRAFTING_TABLE, g)).c();
	public static tk i = (new tk("achievement.buildPickaxe", "buildPickaxe", 4, 2, Items.WOODEN_PICKAXE, h)).c();
	public static tk j = (new tk("achievement.buildFurnace", "buildFurnace", 3, 4, Blocks.FURNACE, i)).c();
	public static tk k = (new tk("achievement.acquireIron", "acquireIron", 1, 4, Items.IRON_INGOT, j)).c();
	public static tk l = (new tk("achievement.buildHoe", "buildHoe", 2, -3, Items.WOODEN_HOE, h)).c();
	public static tk m = (new tk("achievement.makeBread", "makeBread", -1, -3, Items.BREAD, l)).c();
	public static tk n = (new tk("achievement.bakeCake", "bakeCake", 0, -5, Items.CAKE, l)).c();
	public static tk o = (new tk("achievement.buildBetterPickaxe", "buildBetterPickaxe", 6, 2, Items.STONE_PICKAXE, i)).c();
	public static tk p = (new tk("achievement.cookFish", "cookFish", 2, 6, Items.COOKED_FISH, j)).c();
	public static tk q = (new tk("achievement.onARail", "onARail", 2, 3, Blocks.RAIL, k)).b().c();
	public static tk r = (new tk("achievement.buildSword", "buildSword", 6, -1, Items.WOODEN_SWORD, h)).c();
	public static tk s = (new tk("achievement.killEnemy", "killEnemy", 8, -1, Items.BONE, r)).c();
	public static tk t = (new tk("achievement.killCow", "killCow", 7, -3, Items.LEATHER, r)).c();
	public static tk u = (new tk("achievement.flyPig", "flyPig", 9, -3, Items.SADDLE, t)).b().c();
	public static tk v = (new tk("achievement.snipeSkeleton", "snipeSkeleton", 7, 0, Items.BOW, s)).b().c();
	public static tk w = (new tk("achievement.diamonds", "diamonds", -1, 5, Blocks.DIAMOND_ORE, k)).c();
	public static tk x = (new tk("achievement.diamondsToYou", "diamondsToYou", -1, 2, Items.DIAMOND, w)).c();
	public static tk y = (new tk("achievement.portal", "portal", -1, 7, Blocks.OBSIDIAN, w)).c();
	public static tk z = (new tk("achievement.ghast", "ghast", -4, 8, Items.GHAST_TEAR, y)).b().c();
	public static tk A = (new tk("achievement.blazeRod", "blazeRod", 0, 9, Items.BLAZE_ROD, y)).c();
	public static tk B = (new tk("achievement.potion", "potion", 2, 8, Items.POTION, A)).c();
	public static tk C = (new tk("achievement.theEnd", "theEnd", 3, 10, Items.ENDER_EYE, A)).b().c();
	public static tk D = (new tk("achievement.theEnd2", "theEnd2", 4, 13, Blocks.DRAGON_EGG, C)).b().c();
	public static tk E = (new tk("achievement.enchantments", "enchantments", -4, 4, Blocks.ENCHANTING_TABLE, w)).c();
	public static tk F = (new tk("achievement.overkill", "overkill", -4, 1, Items.DIAMOND_SWORD, E)).b().c();
	public static tk G = (new tk("achievement.bookcase", "bookcase", -3, 6, Blocks.BOOKSHELF, E)).c();
	public static tk H = (new tk("achievement.breedCow", "breedCow", 7, -5, Items.WHEAT, t)).c();
	public static tk I = (new tk("achievement.spawnWither", "spawnWither", 7, 12, new ItemStack(Items.SKULL, 1, 1), D)).c();
	public static tk J = (new tk("achievement.killWither", "killWither", 7, 10, Items.NETHER_STAR, I)).c();
	public static tk K = (new tk("achievement.fullBeacon", "fullBeacon", 7, 8, Blocks.BEACON, J)).b().c();
	public static tk L = (new tk("achievement.exploreAllBiomes", "exploreAllBiomes", 4, 8, Items.DIAMOND_BOOTS, C)).a(ua.class).b().c();
	public static tk M = (new tk("achievement.overpowered", "overpowered", 6, 4, Items.GOLDEN_APPLE, o)).b().c();

	public static void a() {
	}

}

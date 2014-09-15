package net.minecraft;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class CraftingManager {

	private static final CraftingManager instance = new CraftingManager();
	private final List<IRecipe> recipes = Lists.newArrayList();

	public static CraftingManager getInstance() {
		return instance;
	}

	private CraftingManager() {
		(new RecipesTools()).a(this);
		(new RecipesWeapons()).a(this);
		(new RecipeIngots()).a(this);
		(new RecipesFood()).a(this);
		(new RecipesCrafting()).a(this);
		(new RecipesArmor()).a(this);
		(new RecipesDyes()).a(this);
		this.recipes.add(new RecipeArmorDye());
		this.recipes.add(new RecipeBookClone());
		this.recipes.add(new RecipeMapClone());
		this.recipes.add(new RecipeMapExtend());
		this.recipes.add(new RecipeFireworks());
		this.recipes.add(new aor());
		(new aoc()).a(this);
		this.registerShapedRecipe(new ItemStack(Items.PAPER, 3), new Object[] { "###", Character.valueOf('#'), Items.REEDS });
		this.registerShapelessRecipe(new ItemStack(Items.BOOK, 1), new Object[] { Items.PAPER, Items.PAPER, Items.PAPER, Items.LEATHER });
		this.registerShapelessRecipe(new ItemStack(Items.WRITABLE_BOOK, 1), new Object[] { Items.BOOK, new ItemStack(Items.DYE, 1, akv.p.b()), Items.FEATHER });
		this.registerShapedRecipe(new ItemStack(Blocks.FENCE, 3), new Object[] { "W#W", "W#W", Character.valueOf('#'), Items.STICK, Character.valueOf('W'), new ItemStack(Blocks.PLANKS, 1, EnumWoodType.a.a()) });
		this.registerShapedRecipe(new ItemStack(Blocks.BIRCH_FENCE, 3), new Object[] { "W#W", "W#W", Character.valueOf('#'), Items.STICK, Character.valueOf('W'), new ItemStack(Blocks.PLANKS, 1, EnumWoodType.c.a()) });
		this.registerShapedRecipe(new ItemStack(Blocks.SPRUCE_FENCE, 3), new Object[] { "W#W", "W#W", Character.valueOf('#'), Items.STICK, Character.valueOf('W'), new ItemStack(Blocks.PLANKS, 1, EnumWoodType.b.a()) });
		this.registerShapedRecipe(new ItemStack(Blocks.JUNGLE_FENCE, 3), new Object[] { "W#W", "W#W", Character.valueOf('#'), Items.STICK, Character.valueOf('W'), new ItemStack(Blocks.PLANKS, 1, EnumWoodType.d.a()) });
		this.registerShapedRecipe(new ItemStack(Blocks.ACACIA_FENCE, 3), new Object[] { "W#W", "W#W", Character.valueOf('#'), Items.STICK, Character.valueOf('W'), new ItemStack(Blocks.PLANKS, 1, 4 + EnumWoodType.e.a() - 4) });
		this.registerShapedRecipe(new ItemStack(Blocks.DARK_OAK_FENCE, 3), new Object[] { "W#W", "W#W", Character.valueOf('#'), Items.STICK, Character.valueOf('W'), new ItemStack(Blocks.PLANKS, 1, 4 + EnumWoodType.f.a() - 4) });
		this.registerShapedRecipe(new ItemStack(Blocks.COBBLESTONE_WALL, 6, bby.a.a()), new Object[] { "###", "###", Character.valueOf('#'), Blocks.COBBLESTONE });
		this.registerShapedRecipe(new ItemStack(Blocks.COBBLESTONE_WALL, 6, bby.b.a()), new Object[] { "###", "###", Character.valueOf('#'), Blocks.MOSSY_COBBLESTONE });
		this.registerShapedRecipe(new ItemStack(Blocks.NETHER_BRICK_FENCE, 6), new Object[] { "###", "###", Character.valueOf('#'), Blocks.NETHER_BRICK });
		this.registerShapedRecipe(new ItemStack(Blocks.FENCE_GATE, 1), new Object[] { "#W#", "#W#", Character.valueOf('#'), Items.STICK, Character.valueOf('W'), new ItemStack(Blocks.PLANKS, 1, EnumWoodType.a.a()) });
		this.registerShapedRecipe(new ItemStack(Blocks.BIRCH_FENCE_GATE, 1), new Object[] { "#W#", "#W#", Character.valueOf('#'), Items.STICK, Character.valueOf('W'), new ItemStack(Blocks.PLANKS, 1, EnumWoodType.c.a()) });
		this.registerShapedRecipe(new ItemStack(Blocks.SPRUCE_FENCE_GATE, 1), new Object[] { "#W#", "#W#", Character.valueOf('#'), Items.STICK, Character.valueOf('W'), new ItemStack(Blocks.PLANKS, 1, EnumWoodType.b.a()) });
		this.registerShapedRecipe(new ItemStack(Blocks.JUNGLE_FENCE_GATE, 1), new Object[] { "#W#", "#W#", Character.valueOf('#'), Items.STICK, Character.valueOf('W'), new ItemStack(Blocks.PLANKS, 1, EnumWoodType.d.a()) });
		this.registerShapedRecipe(new ItemStack(Blocks.ACACIA_FENCE_GATE, 1), new Object[] { "#W#", "#W#", Character.valueOf('#'), Items.STICK, Character.valueOf('W'), new ItemStack(Blocks.PLANKS, 1, 4 + EnumWoodType.e.a() - 4) });
		this.registerShapedRecipe(new ItemStack(Blocks.DARK_OAK_FENCE_GATE, 1), new Object[] { "#W#", "#W#", Character.valueOf('#'), Items.STICK, Character.valueOf('W'), new ItemStack(Blocks.PLANKS, 1, 4 + EnumWoodType.f.a() - 4) });
		this.registerShapedRecipe(new ItemStack(Blocks.JUKEBOX, 1), new Object[] { "###", "#X#", "###", Character.valueOf('#'), Blocks.PLANKS, Character.valueOf('X'), Items.DIAMOND });
		this.registerShapedRecipe(new ItemStack(Items.LEAD, 2), new Object[] { "~~ ", "~O ", "  ~", Character.valueOf('~'), Items.STRING, Character.valueOf('O'), Items.SLIME_BALL });
		this.registerShapedRecipe(new ItemStack(Blocks.NOTEBLOCK, 1), new Object[] { "###", "#X#", "###", Character.valueOf('#'), Blocks.PLANKS, Character.valueOf('X'), Items.REDSTONE });
		this.registerShapedRecipe(new ItemStack(Blocks.BOOKSHELF, 1), new Object[] { "###", "XXX", "###", Character.valueOf('#'), Blocks.PLANKS, Character.valueOf('X'), Items.BOOK });
		this.registerShapedRecipe(new ItemStack(Blocks.SNOW, 1), new Object[] { "##", "##", Character.valueOf('#'), Items.SNOWBALL });
		this.registerShapedRecipe(new ItemStack(Blocks.SNOW_LAYER, 6), new Object[] { "###", Character.valueOf('#'), Blocks.SNOW });
		this.registerShapedRecipe(new ItemStack(Blocks.CLAY, 1), new Object[] { "##", "##", Character.valueOf('#'), Items.CLAY_BALL });
		this.registerShapedRecipe(new ItemStack(Blocks.BRICK_BLOCK, 1), new Object[] { "##", "##", Character.valueOf('#'), Items.BRICK });
		this.registerShapedRecipe(new ItemStack(Blocks.GLOWSTONE, 1), new Object[] { "##", "##", Character.valueOf('#'), Items.GLOWSTONE_DUST });
		this.registerShapedRecipe(new ItemStack(Blocks.QUARTZ_BLOCK, 1), new Object[] { "##", "##", Character.valueOf('#'), Items.QUARTZ });
		this.registerShapedRecipe(new ItemStack(Blocks.WOOL, 1), new Object[] { "##", "##", Character.valueOf('#'), Items.STRING });
		this.registerShapedRecipe(new ItemStack(Blocks.TNT, 1), new Object[] { "X#X", "#X#", "X#X", Character.valueOf('X'), Items.GUNPOWDER, Character.valueOf('#'), Blocks.SAND });
		this.registerShapedRecipe(new ItemStack(Blocks.STONE_SLAB, 6, bbg.d.a()), new Object[] { "###", Character.valueOf('#'), Blocks.COBBLESTONE });
		this.registerShapedRecipe(new ItemStack(Blocks.STONE_SLAB, 6, bbg.a.a()), new Object[] { "###", Character.valueOf('#'), new ItemStack(Blocks.STONE, bbb.a.a()) });
		this.registerShapedRecipe(new ItemStack(Blocks.STONE_SLAB, 6, bbg.b.a()), new Object[] { "###", Character.valueOf('#'), Blocks.SANDSTONE });
		this.registerShapedRecipe(new ItemStack(Blocks.STONE_SLAB, 6, bbg.e.a()), new Object[] { "###", Character.valueOf('#'), Blocks.BRICK_BLOCK });
		this.registerShapedRecipe(new ItemStack(Blocks.STONE_SLAB, 6, bbg.f.a()), new Object[] { "###", Character.valueOf('#'), Blocks.STONEBRICK });
		this.registerShapedRecipe(new ItemStack(Blocks.STONE_SLAB, 6, bbg.g.a()), new Object[] { "###", Character.valueOf('#'), Blocks.NETHER_BRICK });
		this.registerShapedRecipe(new ItemStack(Blocks.STONE_SLAB, 6, bbg.h.a()), new Object[] { "###", Character.valueOf('#'), Blocks.QUARTZ_BLOCK });
		this.registerShapedRecipe(new ItemStack(Blocks.STONE_SLAB2, 6, aym.a.a()), new Object[] { "###", Character.valueOf('#'), Blocks.RED_SANDSTONE });
		this.registerShapedRecipe(new ItemStack(Blocks.WOODEN_SLAB, 6, 0), new Object[] { "###", Character.valueOf('#'), new ItemStack(Blocks.PLANKS, 1, EnumWoodType.a.a()) });
		this.registerShapedRecipe(new ItemStack(Blocks.WOODEN_SLAB, 6, EnumWoodType.c.a()), new Object[] { "###", Character.valueOf('#'), new ItemStack(Blocks.PLANKS, 1, EnumWoodType.c.a()) });
		this.registerShapedRecipe(new ItemStack(Blocks.WOODEN_SLAB, 6, EnumWoodType.b.a()), new Object[] { "###", Character.valueOf('#'), new ItemStack(Blocks.PLANKS, 1, EnumWoodType.b.a()) });
		this.registerShapedRecipe(new ItemStack(Blocks.WOODEN_SLAB, 6, EnumWoodType.d.a()), new Object[] { "###", Character.valueOf('#'), new ItemStack(Blocks.PLANKS, 1, EnumWoodType.d.a()) });
		this.registerShapedRecipe(new ItemStack(Blocks.WOODEN_SLAB, 6, 4 + EnumWoodType.e.a() - 4), new Object[] { "###", Character.valueOf('#'), new ItemStack(Blocks.PLANKS, 1, 4 + EnumWoodType.e.a() - 4) });
		this.registerShapedRecipe(new ItemStack(Blocks.WOODEN_SLAB, 6, 4 + EnumWoodType.f.a() - 4), new Object[] { "###", Character.valueOf('#'), new ItemStack(Blocks.PLANKS, 1, 4 + EnumWoodType.f.a() - 4) });
		this.registerShapedRecipe(new ItemStack(Blocks.LADDER, 3), new Object[] { "# #", "###", "# #", Character.valueOf('#'), Items.STICK });
		this.registerShapedRecipe(new ItemStack(Items.WOODEN_DOOR, 3), new Object[] { "##", "##", "##", Character.valueOf('#'), new ItemStack(Blocks.PLANKS, 1, EnumWoodType.a.a()) });
		this.registerShapedRecipe(new ItemStack(Items.SPRUCE_DOOR, 3), new Object[] { "##", "##", "##", Character.valueOf('#'), new ItemStack(Blocks.PLANKS, 1, EnumWoodType.b.a()) });
		this.registerShapedRecipe(new ItemStack(Items.BIRCH_DOOR, 3), new Object[] { "##", "##", "##", Character.valueOf('#'), new ItemStack(Blocks.PLANKS, 1, EnumWoodType.c.a()) });
		this.registerShapedRecipe(new ItemStack(Items.JUNGLE_DOOR, 3), new Object[] { "##", "##", "##", Character.valueOf('#'), new ItemStack(Blocks.PLANKS, 1, EnumWoodType.d.a()) });
		this.registerShapedRecipe(new ItemStack(Items.ACACIA_DOOR, 3), new Object[] { "##", "##", "##", Character.valueOf('#'), new ItemStack(Blocks.PLANKS, 1, EnumWoodType.e.a()) });
		this.registerShapedRecipe(new ItemStack(Items.DARK_OAK_DOOR, 3), new Object[] { "##", "##", "##", Character.valueOf('#'), new ItemStack(Blocks.PLANKS, 1, EnumWoodType.f.a()) });
		this.registerShapedRecipe(new ItemStack(Blocks.TRAPDOOR, 2), new Object[] { "###", "###", Character.valueOf('#'), Blocks.PLANKS });
		this.registerShapedRecipe(new ItemStack(Items.IRON_DOOR, 3), new Object[] { "##", "##", "##", Character.valueOf('#'), Items.IRON_INGOT });
		this.registerShapedRecipe(new ItemStack(Blocks.IRON_TRAPDOOR, 1), new Object[] { "##", "##", Character.valueOf('#'), Items.IRON_INGOT });
		this.registerShapedRecipe(new ItemStack(Items.SIGN, 3), new Object[] { "###", "###", " X ", Character.valueOf('#'), Blocks.PLANKS, Character.valueOf('X'), Items.STICK });
		this.registerShapedRecipe(new ItemStack(Items.CAKE, 1), new Object[] { "AAA", "BEB", "CCC", Character.valueOf('A'), Items.MILK_BUCKET, Character.valueOf('B'), Items.SUGAR, Character.valueOf('C'), Items.WHEAT, Character.valueOf('E'), Items.EGG });
		this.registerShapedRecipe(new ItemStack(Items.SUGAR, 1), new Object[] { "#", Character.valueOf('#'), Items.REEDS });
		this.registerShapedRecipe(new ItemStack(Blocks.PLANKS, 4, EnumWoodType.a.a()), new Object[] { "#", Character.valueOf('#'), new ItemStack(Blocks.LOG, 1, EnumWoodType.a.a()) });
		this.registerShapedRecipe(new ItemStack(Blocks.PLANKS, 4, EnumWoodType.b.a()), new Object[] { "#", Character.valueOf('#'), new ItemStack(Blocks.LOG, 1, EnumWoodType.b.a()) });
		this.registerShapedRecipe(new ItemStack(Blocks.PLANKS, 4, EnumWoodType.c.a()), new Object[] { "#", Character.valueOf('#'), new ItemStack(Blocks.LOG, 1, EnumWoodType.c.a()) });
		this.registerShapedRecipe(new ItemStack(Blocks.PLANKS, 4, EnumWoodType.d.a()), new Object[] { "#", Character.valueOf('#'), new ItemStack(Blocks.LOG, 1, EnumWoodType.d.a()) });
		this.registerShapedRecipe(new ItemStack(Blocks.PLANKS, 4, 4 + EnumWoodType.e.a() - 4), new Object[] { "#", Character.valueOf('#'), new ItemStack(Blocks.LOG2, 1, EnumWoodType.e.a() - 4) });
		this.registerShapedRecipe(new ItemStack(Blocks.PLANKS, 4, 4 + EnumWoodType.f.a() - 4), new Object[] { "#", Character.valueOf('#'), new ItemStack(Blocks.LOG2, 1, EnumWoodType.f.a() - 4) });
		this.registerShapedRecipe(new ItemStack(Items.STICK, 4), new Object[] { "#", "#", Character.valueOf('#'), Blocks.PLANKS });
		this.registerShapedRecipe(new ItemStack(Blocks.TORCH, 4), new Object[] { "X", "#", Character.valueOf('X'), Items.COAL, Character.valueOf('#'), Items.STICK });
		this.registerShapedRecipe(new ItemStack(Blocks.TORCH, 4), new Object[] { "X", "#", Character.valueOf('X'), new ItemStack(Items.COAL, 1, 1), Character.valueOf('#'), Items.STICK });
		this.registerShapedRecipe(new ItemStack(Items.BOWL, 4), new Object[] { "# #", " # ", Character.valueOf('#'), Blocks.PLANKS });
		this.registerShapedRecipe(new ItemStack(Items.GLASS_BOTTLE, 3), new Object[] { "# #", " # ", Character.valueOf('#'), Blocks.GLASS });
		this.registerShapedRecipe(new ItemStack(Blocks.RAIL, 16), new Object[] { "X X", "X#X", "X X", Character.valueOf('X'), Items.IRON_INGOT, Character.valueOf('#'), Items.STICK });
		this.registerShapedRecipe(new ItemStack(Blocks.GOLDEN_RAIL, 6), new Object[] { "X X", "X#X", "XRX", Character.valueOf('X'), Items.GOLD_INGOT, Character.valueOf('R'), Items.REDSTONE, Character.valueOf('#'), Items.STICK });
		this.registerShapedRecipe(new ItemStack(Blocks.ACTIVATOR_RAIL, 6), new Object[] { "XSX", "X#X", "XSX", Character.valueOf('X'), Items.IRON_INGOT, Character.valueOf('#'), Blocks.REDSTONE_TORCH, Character.valueOf('S'), Items.STICK });
		this.registerShapedRecipe(new ItemStack(Blocks.DETECTOR_RAIL, 6), new Object[] { "X X", "X#X", "XRX", Character.valueOf('X'), Items.IRON_INGOT, Character.valueOf('R'), Items.REDSTONE, Character.valueOf('#'), Blocks.STONE_PRESSURE_PLATE });
		this.registerShapedRecipe(new ItemStack(Items.MINECART, 1), new Object[] { "# #", "###", Character.valueOf('#'), Items.IRON_INGOT });
		this.registerShapedRecipe(new ItemStack(Items.CAULDRON, 1), new Object[] { "# #", "# #", "###", Character.valueOf('#'), Items.IRON_INGOT });
		this.registerShapedRecipe(new ItemStack(Items.BREWING_STAND, 1), new Object[] { " B ", "###", Character.valueOf('#'), Blocks.COBBLESTONE, Character.valueOf('B'), Items.BLAZE_ROD });
		this.registerShapedRecipe(new ItemStack(Blocks.LIT_PUMPKIN, 1), new Object[] { "A", "B", Character.valueOf('A'), Blocks.PUMPKIN, Character.valueOf('B'), Blocks.TORCH });
		this.registerShapedRecipe(new ItemStack(Items.CHEST_MINECART, 1), new Object[] { "A", "B", Character.valueOf('A'), Blocks.CHEST, Character.valueOf('B'), Items.MINECART });
		this.registerShapedRecipe(new ItemStack(Items.FURNACE_MINECART, 1), new Object[] { "A", "B", Character.valueOf('A'), Blocks.FURNACE, Character.valueOf('B'), Items.MINECART });
		this.registerShapedRecipe(new ItemStack(Items.TNT_MINECART, 1), new Object[] { "A", "B", Character.valueOf('A'), Blocks.TNT, Character.valueOf('B'), Items.MINECART });
		this.registerShapedRecipe(new ItemStack(Items.HOPPER_MINECART, 1), new Object[] { "A", "B", Character.valueOf('A'), Blocks.HOPPER, Character.valueOf('B'), Items.MINECART });
		this.registerShapedRecipe(new ItemStack(Items.BOAT, 1), new Object[] { "# #", "###", Character.valueOf('#'), Blocks.PLANKS });
		this.registerShapedRecipe(new ItemStack(Items.BUCKET, 1), new Object[] { "# #", " # ", Character.valueOf('#'), Items.IRON_INGOT });
		this.registerShapedRecipe(new ItemStack(Items.FLOWER_POT, 1), new Object[] { "# #", " # ", Character.valueOf('#'), Items.BRICK });
		this.registerShapelessRecipe(new ItemStack(Items.FLINT_AND_STEEL, 1), new Object[] { new ItemStack(Items.IRON_INGOT, 1), new ItemStack(Items.FLINT, 1) });
		this.registerShapedRecipe(new ItemStack(Items.BREAD, 1), new Object[] { "###", Character.valueOf('#'), Items.WHEAT });
		this.registerShapedRecipe(new ItemStack(Blocks.OAK_STAIRS, 4), new Object[] { "#  ", "## ", "###", Character.valueOf('#'), new ItemStack(Blocks.PLANKS, 1, EnumWoodType.a.a()) });
		this.registerShapedRecipe(new ItemStack(Blocks.BIRCH_STAIRS, 4), new Object[] { "#  ", "## ", "###", Character.valueOf('#'), new ItemStack(Blocks.PLANKS, 1, EnumWoodType.c.a()) });
		this.registerShapedRecipe(new ItemStack(Blocks.SPRUCE_STAIRS, 4), new Object[] { "#  ", "## ", "###", Character.valueOf('#'), new ItemStack(Blocks.PLANKS, 1, EnumWoodType.b.a()) });
		this.registerShapedRecipe(new ItemStack(Blocks.JUNGLE_STAIRS, 4), new Object[] { "#  ", "## ", "###", Character.valueOf('#'), new ItemStack(Blocks.PLANKS, 1, EnumWoodType.d.a()) });
		this.registerShapedRecipe(new ItemStack(Blocks.ACACIA_STAIRS, 4), new Object[] { "#  ", "## ", "###", Character.valueOf('#'), new ItemStack(Blocks.PLANKS, 1, 4 + EnumWoodType.e.a() - 4) });
		this.registerShapedRecipe(new ItemStack(Blocks.DARK_OAK_STAIRS, 4), new Object[] { "#  ", "## ", "###", Character.valueOf('#'), new ItemStack(Blocks.PLANKS, 1, 4 + EnumWoodType.f.a() - 4) });
		this.registerShapedRecipe(new ItemStack(Items.FISHING_ROD, 1), new Object[] { "  #", " #X", "# X", Character.valueOf('#'), Items.STICK, Character.valueOf('X'), Items.STRING });
		this.registerShapedRecipe(new ItemStack(Items.CARROT_ON_A_STICK, 1), new Object[] { "# ", " X", Character.valueOf('#'), Items.FISHING_ROD, Character.valueOf('X'), Items.CARROT }).c();
		this.registerShapedRecipe(new ItemStack(Blocks.STONE_STAIRS, 4), new Object[] { "#  ", "## ", "###", Character.valueOf('#'), Blocks.COBBLESTONE });
		this.registerShapedRecipe(new ItemStack(Blocks.BRICK_STAIRS, 4), new Object[] { "#  ", "## ", "###", Character.valueOf('#'), Blocks.BRICK_BLOCK });
		this.registerShapedRecipe(new ItemStack(Blocks.STONE_BROCK_STAIRS, 4), new Object[] { "#  ", "## ", "###", Character.valueOf('#'), Blocks.STONEBRICK });
		this.registerShapedRecipe(new ItemStack(Blocks.NETHER_BRICK_STAIRS, 4), new Object[] { "#  ", "## ", "###", Character.valueOf('#'), Blocks.NETHER_BRICK });
		this.registerShapedRecipe(new ItemStack(Blocks.SANDSTONE_STAIRS, 4), new Object[] { "#  ", "## ", "###", Character.valueOf('#'), Blocks.SANDSTONE });
		this.registerShapedRecipe(new ItemStack(Blocks.RED_SANDSTONE_STAIRS, 4), new Object[] { "#  ", "## ", "###", Character.valueOf('#'), Blocks.RED_SANDSTONE });
		this.registerShapedRecipe(new ItemStack(Blocks.QUARTZ_STAIRS, 4), new Object[] { "#  ", "## ", "###", Character.valueOf('#'), Blocks.QUARTZ_BLOCK });
		this.registerShapedRecipe(new ItemStack(Items.PAINTING, 1), new Object[] { "###", "#X#", "###", Character.valueOf('#'), Items.STICK, Character.valueOf('X'), Blocks.WOOL });
		this.registerShapedRecipe(new ItemStack(Items.ITEM_FRAME, 1), new Object[] { "###", "#X#", "###", Character.valueOf('#'), Items.STICK, Character.valueOf('X'), Items.LEATHER });
		this.registerShapedRecipe(new ItemStack(Items.GOLDEN_APPLE, 1, 0), new Object[] { "###", "#X#", "###", Character.valueOf('#'), Items.GOLD_INGOT, Character.valueOf('X'), Items.APPLE });
		this.registerShapedRecipe(new ItemStack(Items.GOLDEN_APPLE, 1, 1), new Object[] { "###", "#X#", "###", Character.valueOf('#'), Blocks.GOLD_BLOCK, Character.valueOf('X'), Items.APPLE });
		this.registerShapedRecipe(new ItemStack(Items.GOLDEN_CARROT, 1, 0), new Object[] { "###", "#X#", "###", Character.valueOf('#'), Items.GOLD_NUGGET, Character.valueOf('X'), Items.CARROT });
		this.registerShapedRecipe(new ItemStack(Items.SPECKLED_MELON, 1), new Object[] { "###", "#X#", "###", Character.valueOf('#'), Items.GOLD_NUGGET, Character.valueOf('X'), Items.MELON });
		this.registerShapedRecipe(new ItemStack(Blocks.LEVER, 1), new Object[] { "X", "#", Character.valueOf('#'), Blocks.COBBLESTONE, Character.valueOf('X'), Items.STICK });
		this.registerShapedRecipe(new ItemStack(Blocks.TRIPWIRE_HOOK, 2), new Object[] { "I", "S", "#", Character.valueOf('#'), Blocks.PLANKS, Character.valueOf('S'), Items.STICK, Character.valueOf('I'), Items.IRON_INGOT });
		this.registerShapedRecipe(new ItemStack(Blocks.REDSTONE_TORCH, 1), new Object[] { "X", "#", Character.valueOf('#'), Items.STICK, Character.valueOf('X'), Items.REDSTONE });
		this.registerShapedRecipe(new ItemStack(Items.REPEATER, 1), new Object[] { "#X#", "III", Character.valueOf('#'), Blocks.REDSTONE_TORCH, Character.valueOf('X'), Items.REDSTONE, Character.valueOf('I'), new ItemStack(Blocks.STONE, 1, bbb.a.a()) });
		this.registerShapedRecipe(new ItemStack(Items.COMPARATOR, 1), new Object[] { " # ", "#X#", "III", Character.valueOf('#'), Blocks.REDSTONE_TORCH, Character.valueOf('X'), Items.QUARTZ, Character.valueOf('I'), new ItemStack(Blocks.STONE, 1, bbb.a.a()) });
		this.registerShapedRecipe(new ItemStack(Items.CLOCK, 1), new Object[] { " # ", "#X#", " # ", Character.valueOf('#'), Items.GOLD_INGOT, Character.valueOf('X'), Items.REDSTONE });
		this.registerShapedRecipe(new ItemStack(Items.COMPASS, 1), new Object[] { " # ", "#X#", " # ", Character.valueOf('#'), Items.IRON_INGOT, Character.valueOf('X'), Items.REDSTONE });
		this.registerShapedRecipe(new ItemStack(Items.MAP, 1), new Object[] { "###", "#X#", "###", Character.valueOf('#'), Items.PAPER, Character.valueOf('X'), Items.COMPASS });
		this.registerShapedRecipe(new ItemStack(Blocks.STONE_BUTTON, 1), new Object[] { "#", Character.valueOf('#'), new ItemStack(Blocks.STONE, 1, bbb.a.a()) });
		this.registerShapedRecipe(new ItemStack(Blocks.WOODEN_BUTTON, 1), new Object[] { "#", Character.valueOf('#'), Blocks.PLANKS });
		this.registerShapedRecipe(new ItemStack(Blocks.STONE_PRESSURE_PLATE, 1), new Object[] { "##", Character.valueOf('#'), new ItemStack(Blocks.STONE, 1, bbb.a.a()) });
		this.registerShapedRecipe(new ItemStack(Blocks.WOODEN_PRESSURE_PLATE, 1), new Object[] { "##", Character.valueOf('#'), Blocks.PLANKS });
		this.registerShapedRecipe(new ItemStack(Blocks.HEAVY_WEIGHTED_PRESSURE_PLATE, 1), new Object[] { "##", Character.valueOf('#'), Items.IRON_INGOT });
		this.registerShapedRecipe(new ItemStack(Blocks.LIGHT_WEIGHTED_PRESSURE_PLATE, 1), new Object[] { "##", Character.valueOf('#'), Items.GOLD_INGOT });
		this.registerShapedRecipe(new ItemStack(Blocks.DISPENSER, 1), new Object[] { "###", "#X#", "#R#", Character.valueOf('#'), Blocks.COBBLESTONE, Character.valueOf('X'), Items.BOW, Character.valueOf('R'), Items.REDSTONE });
		this.registerShapedRecipe(new ItemStack(Blocks.DROPPER, 1), new Object[] { "###", "# #", "#R#", Character.valueOf('#'), Blocks.COBBLESTONE, Character.valueOf('R'), Items.REDSTONE });
		this.registerShapedRecipe(new ItemStack(Blocks.PISTON, 1), new Object[] { "TTT", "#X#", "#R#", Character.valueOf('#'), Blocks.COBBLESTONE, Character.valueOf('X'), Items.IRON_INGOT, Character.valueOf('R'), Items.REDSTONE, Character.valueOf('T'), Blocks.PLANKS });
		this.registerShapedRecipe(new ItemStack(Blocks.STICKY_PISTON, 1), new Object[] { "S", "P", Character.valueOf('S'), Items.SLIME_BALL, Character.valueOf('P'), Blocks.PISTON });
		this.registerShapedRecipe(new ItemStack(Items.BED, 1), new Object[] { "###", "XXX", Character.valueOf('#'), Blocks.WOOL, Character.valueOf('X'), Blocks.PLANKS });
		this.registerShapedRecipe(new ItemStack(Blocks.ENCHANTING_TABLE, 1), new Object[] { " B ", "D#D", "###", Character.valueOf('#'), Blocks.OBSIDIAN, Character.valueOf('B'), Items.BOOK, Character.valueOf('D'), Items.DIAMOND });
		this.registerShapedRecipe(new ItemStack(Blocks.ANVIL, 1), new Object[] { "III", " i ", "iii", Character.valueOf('I'), Blocks.IRON_BLOCK, Character.valueOf('i'), Items.IRON_INGOT });
		this.registerShapedRecipe(new ItemStack(Items.LEATHER), new Object[] { "##", "##", Character.valueOf('#'), Items.RABBIT_HIDE });
		this.registerShapelessRecipe(new ItemStack(Items.ENDER_EYE, 1), new Object[] { Items.ENDER_PEARL, Items.BLAZE_POWDER });
		this.registerShapelessRecipe(new ItemStack(Items.FIRE_CHARGE, 3), new Object[] { Items.GUNPOWDER, Items.BLAZE_POWDER, Items.COAL });
		this.registerShapelessRecipe(new ItemStack(Items.FIRE_CHARGE, 3), new Object[] { Items.GUNPOWDER, Items.BLAZE_POWDER, new ItemStack(Items.COAL, 1, 1) });
		this.registerShapedRecipe(new ItemStack(Blocks.DAYLIGHT_DETECTOR), new Object[] { "GGG", "QQQ", "WWW", Character.valueOf('G'), Blocks.GLASS, Character.valueOf('Q'), Items.QUARTZ, Character.valueOf('W'), Blocks.WOODEN_SLAB });
		this.registerShapedRecipe(new ItemStack(Blocks.HOPPER), new Object[] { "I I", "ICI", " I ", Character.valueOf('I'), Items.IRON_INGOT, Character.valueOf('C'), Blocks.CHEST });
		this.registerShapedRecipe(new ItemStack(Items.ARMOR_STAND, 1), new Object[] { "///", " / ", "/_/", Character.valueOf('/'), Items.STICK, Character.valueOf('_'), new ItemStack(Blocks.STONE_SLAB, 1, bbg.a.a()) });
		Collections.sort(this.recipes, new RecipeSorter());
	}

	public ShapedRecipes registerShapedRecipe(ItemStack var1, Object... var2) {
		String var3 = "";
		int var4 = 0;
		int var5 = 0;
		int var6 = 0;
		if (var2[var4] instanceof String[]) {
			String[] var7 = (String[]) ((String[]) var2[var4++]);

			for (int var8 = 0; var8 < var7.length; ++var8) {
				String var9 = var7[var8];
				++var6;
				var5 = var9.length();
				var3 = var3 + var9;
			}
		} else {
			while (var2[var4] instanceof String) {
				String var11 = (String) var2[var4++];
				++var6;
				var5 = var11.length();
				var3 = var3 + var11;
			}
		}

		HashMap<Character, ItemStack> var12;
		for (var12 = Maps.newHashMap(); var4 < var2.length; var4 += 2) {
			Character var13 = (Character) var2[var4];
			ItemStack var15 = null;
			if (var2[var4 + 1] instanceof Item) {
				var15 = new ItemStack((Item) var2[var4 + 1]);
			} else if (var2[var4 + 1] instanceof Block) {
				var15 = new ItemStack((Block) var2[var4 + 1], 1, 32767);
			} else if (var2[var4 + 1] instanceof ItemStack) {
				var15 = (ItemStack) var2[var4 + 1];
			}

			var12.put(var13, var15);
		}

		ItemStack[] var14 = new ItemStack[var5 * var6];

		for (int var16 = 0; var16 < var5 * var6; ++var16) {
			char var10 = var3.charAt(var16);
			if (var12.containsKey(Character.valueOf(var10))) {
				var14[var16] = ((ItemStack) var12.get(Character.valueOf(var10))).getCopy();
			} else {
				var14[var16] = null;
			}
		}

		ShapedRecipes var17 = new ShapedRecipes(var5, var6, var14, var1);
		this.recipes.add(var17);
		return var17;
	}

	public void registerShapelessRecipe(ItemStack var1, Object... var2) {
		ArrayList<ItemStack> var3 = Lists.newArrayList();
		Object[] var4 = var2;
		int var5 = var2.length;

		for (int var6 = 0; var6 < var5; ++var6) {
			Object var7 = var4[var6];
			if (var7 instanceof ItemStack) {
				var3.add(((ItemStack) var7).getCopy());
			} else if (var7 instanceof Item) {
				var3.add(new ItemStack((Item) var7));
			} else {
				if (!(var7 instanceof Block)) {
					throw new IllegalArgumentException("Invalid shapeless recipe: unknown type " + var7.getClass().getName() + "!");
				}

				var3.add(new ItemStack((Block) var7));
			}
		}

		this.recipes.add(new ShapelessRecipes(var1, var3));
	}

	public void addRecipe(IRecipe recipe) {
		this.recipes.add(recipe);
	}

	public ItemStack a(InventoryCrafting var1, World var2) {
		Iterator<IRecipe> var3 = this.recipes.iterator();

		IRecipe var4;
		do {
			if (!var3.hasNext()) {
				return null;
			}

			var4 = (IRecipe) var3.next();
		} while (!var4.a(var1, var2));

		return var4.a(var1);
	}

	public ItemStack[] b(InventoryCrafting inventoryCrafting, World world) {
		for (IRecipe recipe : recipes) {
			if (recipe.a(inventoryCrafting, world)) {
				return recipe.b(inventoryCrafting);
			}
		}

		ItemStack[] items = new ItemStack[inventoryCrafting.getSize()];

		for (int i = 0; i < items.length; ++i) {
			items[i] = inventoryCrafting.getItem(i);
		}

		return items;
	}

	public List<IRecipe> getRecipes() {
		return this.recipes;
	}

}

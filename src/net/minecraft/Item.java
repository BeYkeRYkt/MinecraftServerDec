package net.minecraft;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

public class Item {

	public static final RegistryMaterials REGISTRY = new RegistryMaterials();
	private static final Map<Block, Item> blockToItem = Maps.newHashMap();
	protected static final UUID f = UUID.fromString("CB3F55D3-645C-4F38-A497-9C13A33DB5CF");
	protected static Random rnd = new Random();
	protected int maxStackSize = 64;
	private int durability;
	protected boolean i;
	protected boolean j;
	private Item craftingResult;
	private String k;
	private String name;

	public static int getId(Item item) {
		return item == null ? 0 : REGISTRY.getBlockId(item);
	}

	public static Item getById(int id) {
		return (Item) REGISTRY.getById(id);
	}

	public static Item getItemOf(Block block) {
		return blockToItem.get(block);
	}

	public static Item getByName(String name) {
		Item item = (Item) REGISTRY.getByName(new RegistryObjectName(name));
		if (item == null) {
			try {
				return getById(Integer.parseInt(name));
			} catch (NumberFormatException var3) {
			}
		}

		return item;
	}

	public boolean a(NBTCompoundTag var1) {
		return false;
	}

	public Item setMaxStackSize(int size) {
		this.maxStackSize = size;
		return this;
	}

	public boolean a(ItemStack var1, EntityHuman var2, World var3, Position var4, BlockFace var5, float var6, float var7, float var8) {
		return false;
	}

	public float a(ItemStack var1, Block var2) {
		return 1.0F;
	}

	public ItemStack a(ItemStack var1, World var2, EntityHuman var3) {
		return var1;
	}

	public ItemStack b(ItemStack var1, World var2, EntityHuman var3) {
		return var1;
	}

	public int getMaxStackSize() {
		return this.maxStackSize;
	}

	public int a(int var1) {
		return 0;
	}

	public boolean k() {
		return this.j;
	}

	protected Item a(boolean var1) {
		this.j = var1;
		return this;
	}

	public int getMaxWearout() {
		return this.durability;
	}

	protected Item setDurability(int durability) {
		this.durability = durability;
		return this;
	}

	public boolean usesDurability() {
		return this.durability > 0 && !this.j;
	}

	public boolean a(ItemStack var1, EntityLiving var2, EntityLiving var3) {
		return false;
	}

	public boolean a(ItemStack var1, World var2, Block var3, Position var4, EntityLiving var5) {
		return false;
	}

	public boolean b(Block var1) {
		return false;
	}

	public boolean a(ItemStack var1, EntityHuman var2, EntityLiving var3) {
		return false;
	}

	public Item n() {
		this.i = true;
		return this;
	}

	public Item setName(String name) {
		this.name = name;
		return this;
	}

	public String getLocalizedName(ItemStack itemstack) {
		String string = this.getName(itemstack);
		return string == null ? "" : LocaleI18n.get(string);
	}

	public String getName() {
		return "item." + this.name;
	}

	public String getName(ItemStack itemstack) {
		return "item." + this.name;
	}

	public Item setCraftingResult(Item item) {
		this.craftingResult = item;
		return this;
	}

	public boolean p() {
		return true;
	}

	public Item getCraftingResult() {
		return this.craftingResult;
	}

	public boolean r() {
		return this.craftingResult != null;
	}

	public void a(ItemStack var1, World var2, Entity var3, int var4, boolean var5) {
	}

	public void d(ItemStack var1, World var2, EntityHuman var3) {
	}

	public boolean f() {
		return false;
	}

	public ano e(ItemStack var1) {
		return ano.a;
	}

	public int d(ItemStack var1) {
		return 0;
	}

	public void a(ItemStack var1, World var2, EntityHuman var3, int var4) {
	}

	protected Item e(String var1) {
		this.k = var1;
		return this;
	}

	public String j(ItemStack var1) {
		return this.k;
	}

	public boolean l(ItemStack var1) {
		return this.j(var1) != null;
	}

	public String a(ItemStack var1) {
		return ("" + LocaleI18n.get(this.getLocalizedName(var1) + ".name")).trim();
	}

	public amx g(ItemStack var1) {
		return var1.w() ? amx.c : amx.a;
	}

	public boolean f_(ItemStack var1) {
		return this.getMaxStackSize() == 1 && this.usesDurability();
	}

	protected MovingObjectPosition a(World var1, EntityHuman var2, boolean var3) {
		float var4 = var2.lastPitch + (var2.pitch - var2.lastPitch);
		float var5 = var2.lastYaw + (var2.yaw - var2.lastYaw);
		double var6 = var2.previousX + (var2.locationX - var2.previousX);
		double var8 = var2.previousY + (var2.locationY - var2.previousY) + (double) var2.getHeadHeight();
		double var10 = var2.previousZ + (var2.locationZ - var2.previousZ);
		Vec3D var12 = new Vec3D(var6, var8, var10);
		float var13 = MathHelper.b(-var5 * 0.017453292F - 3.1415927F);
		float var14 = MathHelper.a(-var5 * 0.017453292F - 3.1415927F);
		float var15 = -MathHelper.b(-var4 * 0.017453292F);
		float var16 = MathHelper.a(-var4 * 0.017453292F);
		float var17 = var14 * var15;
		float var19 = var13 * var15;
		double var20 = 5.0D;
		Vec3D var22 = var12.b((double) var17 * var20, (double) var16 * var20, (double) var19 * var20);
		return var1.a(var12, var22, var3, !var3, false);
	}

	public int b() {
		return 0;
	}

	public Item setCreativeModeTab(CreativeModeTab var1) {
		return this;
	}

	public boolean s() {
		return false;
	}

	public boolean a(ItemStack var1, ItemStack var2) {
		return false;
	}

	public Multimap<?, ?> i() {
		return HashMultimap.create();
	}

	public static void registerItems() {
		register(Blocks.STONE,  (new ItemMultiTexture(Blocks.STONE, Blocks.STONE, new alr())).setBlockName("stone"));
		register((Block) Blocks.GRASS,  (new ItemWithAuxData(Blocks.GRASS, false)));
		register(Blocks.DIRT,  (new ItemMultiTexture(Blocks.DIRT, Blocks.DIRT, new ama())).setBlockName("dirt"));
		register(Blocks.COBBLESTONE);
		register(Blocks.PLANKS,  (new ItemMultiTexture(Blocks.PLANKS, Blocks.PLANKS, new amb())).setBlockName("wood"));
		register(Blocks.SAPLING,  (new ItemMultiTexture(Blocks.SAPLING, Blocks.SAPLING, new amc())).setBlockName("sapling"));
		register(Blocks.BEDROCK);
		register((Block) Blocks.SAND,  (new ItemMultiTexture(Blocks.SAND, Blocks.SAND, new amd())).setBlockName("sand"));
		register(Blocks.GRAVEL);
		register(Blocks.GOLD_ORE);
		register(Blocks.IRON_ORE);
		register(Blocks.COAL_ORE);
		register(Blocks.LOG,  (new ItemMultiTexture(Blocks.LOG, Blocks.LOG, new ame())).setBlockName("log"));
		register(Blocks.LOG2,  (new ItemMultiTexture(Blocks.LOG2, Blocks.LOG2, new amf())).setBlockName("log"));
		register((Block) Blocks.LEAVES,  (new ItemLeaves(Blocks.LEAVES)).setBlockName("leaves"));
		register((Block) Blocks.LEAVES2,  (new ItemLeaves(Blocks.LEAVES2)).setBlockName("leaves"));
		register(Blocks.SPONGE,  (new ItemMultiTexture(Blocks.SPONGE, Blocks.SPONGE, new amg())).setBlockName("sponge"));
		register(Blocks.GLASS);
		register(Blocks.LAPIS_ORE);
		register(Blocks.LAPIS_BLOCK);
		register(Blocks.DISPENSER);
		register(Blocks.SANDSTONE,  (new ItemMultiTexture(Blocks.SANDSTONE, Blocks.SANDSTONE, new amh())).setBlockName("sandStone"));
		register(Blocks.NOTEBLOCK);
		register(Blocks.GOLDEN_RAIL);
		register(Blocks.DETECTOR_RAIL);
		register((Block) Blocks.STICKY_PISTON,  (new ItemPiston(Blocks.STICKY_PISTON)));
		register(Blocks.WEB);
		register((Block) Blocks.TALLGRASS,  (new ItemWithAuxData(Blocks.TALLGRASS, true)).a(new String[] { "shrub", "grass", "fern" }));
		register((Block) Blocks.DEADBUSH);
		register((Block) Blocks.PISTON,  (new ItemPiston(Blocks.PISTON)));
		register(Blocks.WOOL,  (new ItemCloth(Blocks.WOOL)).setBlockName("cloth"));
		register((Block) Blocks.YELLOW_FLOWER,  (new ItemMultiTexture(Blocks.YELLOW_FLOWER, Blocks.YELLOW_FLOWER, new als())).setBlockName("flower"));
		register((Block) Blocks.RED_FLOWER,  (new ItemMultiTexture(Blocks.RED_FLOWER, Blocks.RED_FLOWER, new alt())).setBlockName("rose"));
		register((Block) Blocks.BRWON_MUSHROOM);
		register((Block) Blocks.RED_MUSHROOM);
		register(Blocks.GOLD_BLOCK);
		register(Blocks.IRON_BLOCK);
		register((Block) Blocks.STONE_SLAB,  (new ItemStep(Blocks.STONE_SLAB, Blocks.STONE_SLAB, Blocks.DOUBLE_STONE_SLAB)).setBlockName("stoneSlab"));
		register(Blocks.BRICK_BLOCK);
		register(Blocks.TNT);
		register(Blocks.BOOKSHELF);
		register(Blocks.MOSSY_COBBLESTONE);
		register(Blocks.OBSIDIAN);
		register(Blocks.TORCH);
		register(Blocks.MOB_SPAWNER);
		register(Blocks.OAK_STAIRS);
		register((Block) Blocks.CHEST);
		register(Blocks.DIAMOND_ORE);
		register(Blocks.DIAMOND_BLOCK);
		register(Blocks.CRAFTING_TABLE);
		register(Blocks.FARMLAND);
		register(Blocks.FURNACE);
		register(Blocks.LIT_FURNACE);
		register(Blocks.LADDER);
		register(Blocks.RAIL);
		register(Blocks.STONE_STAIRS);
		register(Blocks.LEVER);
		register(Blocks.STONE_PRESSURE_PLATE);
		register(Blocks.WOODEN_PRESSURE_PLATE);
		register(Blocks.REDSTONE_ORE);
		register(Blocks.REDSTONE_TORCH);
		register(Blocks.STONE_BUTTON);
		register(Blocks.SNOW_LAYER,  (new ItemSnow(Blocks.SNOW_LAYER)));
		register(Blocks.ICE);
		register(Blocks.SNOW);
		register((Block) Blocks.CACTUS);
		register(Blocks.CLAY);
		register(Blocks.JUKEBOX);
		register(Blocks.FENCE);
		register(Blocks.SPRUCE_FENCE);
		register(Blocks.BIRCH_FENCE);
		register(Blocks.JUNGLE_FENCE);
		register(Blocks.DARK_OAK_FENCE);
		register(Blocks.ACACIA_FENCE);
		register(Blocks.PUMPKIN);
		register(Blocks.NETHERRACK);
		register(Blocks.SOUL_SAND);
		register(Blocks.GLOWSTONE);
		register(Blocks.LIT_PUMPKIN);
		register(Blocks.TRAPDOOR);
		register(Blocks.MONSTER_EGG,  (new ItemMultiTexture(Blocks.MONSTER_EGG, Blocks.MONSTER_EGG, new alu())).setBlockName("monsterStoneEgg"));
		register(Blocks.STONEBRICK,  (new ItemMultiTexture(Blocks.STONEBRICK, Blocks.STONEBRICK, new alv())).setBlockName("stonebricksmooth"));
		register(Blocks.BROWN_MUSHROOM_BLOCK);
		register(Blocks.RED_MUSHROOM_BLOCK);
		register(Blocks.IRON_BARS);
		register(Blocks.GLASS_PANE);
		register(Blocks.MELON_BLOCK);
		register(Blocks.VINE,  (new ItemWithAuxData(Blocks.VINE, false)));
		register(Blocks.FENCE_GATE);
		register(Blocks.SPRUCE_FENCE_GATE);
		register(Blocks.BIRCH_FENCE_GATE);
		register(Blocks.JUNGLE_FENCE_GATE);
		register(Blocks.DARK_OAK_FENCE_GATE);
		register(Blocks.ACACIA_FENCE_GATE);
		register(Blocks.BRICK_STAIRS);
		register(Blocks.STONE_BROCK_STAIRS);
		register((Block) Blocks.MYCELIUM);
		register(Blocks.WATER_LILY,  (new ItemWaterLily(Blocks.WATER_LILY)));
		register(Blocks.NETHER_BRICK);
		register(Blocks.NETHER_BRICK_FENCE);
		register(Blocks.NETHER_BRICK_STAIRS);
		register(Blocks.ENCHANTING_TABLE);
		register(Blocks.END_PORTAL_FRAME);
		register(Blocks.END_STONE);
		register(Blocks.DRAGON_EGG);
		register(Blocks.REDSTONE_LAMP);
		register((Block) Blocks.WOODEN_SLAB,  (new ItemStep(Blocks.WOODEN_SLAB, Blocks.WOODEN_SLAB, Blocks.DOUBLE_WOODEN_SLAB)).setBlockName("woodSlab"));
		register(Blocks.SANDSTONE_STAIRS);
		register(Blocks.EMERALD_ORE);
		register(Blocks.ENDER_CHEST);
		register((Block) Blocks.TRIPWIRE_HOOK);
		register(Blocks.EMERALD_BLOCK);
		register(Blocks.SPRUCE_STAIRS);
		register(Blocks.BIRCH_STAIRS);
		register(Blocks.JUNGLE_STAIRS);
		register(Blocks.COMMAND_BLOCK);
		register((Block) Blocks.BEACON);
		register(Blocks.COBBLESTONE_WALL,  (new ItemMultiTexture(Blocks.COBBLESTONE_WALL, Blocks.COBBLESTONE_WALL, new alw())).setBlockName("cobbleWall"));
		register(Blocks.WOODEN_BUTTON);
		register(Blocks.ANVIL,  (new ItemAnvil(Blocks.ANVIL)).setBlockName("anvil"));
		register(Blocks.TRAPPED_CHEST);
		register(Blocks.LIGHT_WEIGHTED_PRESSURE_PLATE);
		register(Blocks.HEAVY_WEIGHTED_PRESSURE_PLATE);
		register((Block) Blocks.DAYLIGHT_DETECTOR);
		register(Blocks.REDSTONE_BLOCK);
		register(Blocks.QUARTZ_ORE);
		register((Block) Blocks.HOPPER);
		register(Blocks.QUARTZ_BLOCK,  (new ItemMultiTexture(Blocks.QUARTZ_BLOCK, Blocks.QUARTZ_BLOCK, new String[] { "default", "chiseled", "lines" })).setBlockName("quartzBlock"));
		register(Blocks.QUARTZ_STAIRS);
		register(Blocks.ACTIVATOR_RAIL);
		register(Blocks.DROPPER);
		register(Blocks.STAINDED_HARDENED_CLAY,  (new ItemCloth(Blocks.STAINDED_HARDENED_CLAY)).setBlockName("clayHardenedStained"));
		register(Blocks.BARRIER);
		register(Blocks.IRON_TRAPDOOR);
		register(Blocks.HAY_BLOCK);
		register(Blocks.CARPET,  (new ItemCloth(Blocks.CARPET)).setBlockName("woolCarpet"));
		register(Blocks.HARDENED_CLAY);
		register(Blocks.COAL_BLOCK);
		register(Blocks.PACKED_ICE);
		register(Blocks.ACACIA_STAIRS);
		register(Blocks.DARK_OAK_STAIRS);
		register(Blocks.SLIME);
		register((Block) Blocks.DOUBLE_PLANT,  (new ItemTallPlant(Blocks.DOUBLE_PLANT, Blocks.DOUBLE_PLANT, new alx())).setBlockName("doublePlant"));
		register((Block) Blocks.STAINED_GLASS,  (new ItemCloth(Blocks.STAINED_GLASS)).setBlockName("stainedGlass"));
		register((Block) Blocks.STAINED_GLASS_PANE,  (new ItemCloth(Blocks.STAINED_GLASS_PANE)).setBlockName("stainedGlassPane"));
		register(Blocks.PRISMARINE,  (new ItemMultiTexture(Blocks.PRISMARINE, Blocks.PRISMARINE, new aly())).setBlockName("prismarine"));
		register(Blocks.SEA_LANTERN);
		register(Blocks.RED_SANDSTONE,  (new ItemMultiTexture(Blocks.RED_SANDSTONE, Blocks.RED_SANDSTONE, new alz())).setBlockName("redSandStone"));
		register(Blocks.RED_SANDSTONE_STAIRS);
		register((Block) Blocks.STONE_SLAB2,  (new ItemStep(Blocks.STONE_SLAB2, Blocks.STONE_SLAB2, Blocks.DOUBLE_STONE_SLAB2)).setBlockName("stoneSlab2"));
		register(256, "iron_shovel", (new ItemSpade(EnumToolMaterial.IRON)).setName("shovelIron"));
		register(257, "iron_pickaxe", (new ItemPickaxe(EnumToolMaterial.IRON)).setName("pickaxeIron"));
		register(258, "iron_axe", (new ItemAxe(EnumToolMaterial.IRON)).setName("hatchetIron"));
		register(259, "flint_and_steel", (new alk()).setName("flintAndSteel"));
		register(260, "apple", (new ItemFood(4, 0.3F, false)).setName("apple"));
		register(261, "bow", (new ItemBow()).setName("bow"));
		register(262, "arrow", (new Item()).setName("arrow").setCreativeModeTab(CreativeModeTab.COMBAT));
		register(263, "coal", (new ItemCoal()).setName("coal"));
		register(264, "diamond", (new Item()).setName("diamond").setCreativeModeTab(CreativeModeTab.MATERIALS));
		register(265, "iron_ingot", (new Item()).setName("ingotIron").setCreativeModeTab(CreativeModeTab.MATERIALS));
		register(266, "gold_ingot", (new Item()).setName("ingotGold").setCreativeModeTab(CreativeModeTab.MATERIALS));
		register(267, "iron_sword", (new ItemSword(EnumToolMaterial.IRON)).setName("swordIron"));
		register(268, "wooden_sword", (new ItemSword(EnumToolMaterial.WOOD)).setName("swordWood"));
		register(269, "wooden_shovel", (new ItemSpade(EnumToolMaterial.WOOD)).setName("shovelWood"));
		register(270, "wooden_pickaxe", (new ItemPickaxe(EnumToolMaterial.WOOD)).setName("pickaxeWood"));
		register(271, "wooden_axe", (new ItemAxe(EnumToolMaterial.WOOD)).setName("hatchetWood"));
		register(272, "stone_sword", (new ItemSword(EnumToolMaterial.STONE)).setName("swordStone"));
		register(273, "stone_shovel", (new ItemSpade(EnumToolMaterial.STONE)).setName("shovelStone"));
		register(274, "stone_pickaxe", (new ItemPickaxe(EnumToolMaterial.STONE)).setName("pickaxeStone"));
		register(275, "stone_axe", (new ItemAxe(EnumToolMaterial.STONE)).setName("hatchetStone"));
		register(276, "diamond_sword", (new ItemSword(EnumToolMaterial.EMERALD)).setName("swordDiamond"));
		register(277, "diamond_shovel", (new ItemSpade(EnumToolMaterial.EMERALD)).setName("shovelDiamond"));
		register(278, "diamond_pickaxe", (new ItemPickaxe(EnumToolMaterial.EMERALD)).setName("pickaxeDiamond"));
		register(279, "diamond_axe", (new ItemAxe(EnumToolMaterial.EMERALD)).setName("hatchetDiamond"));
		register(280, "stick", (new Item()).n().setName("stick").setCreativeModeTab(CreativeModeTab.MATERIALS));
		register(281, "bowl", (new Item()).setName("bowl").setCreativeModeTab(CreativeModeTab.MATERIALS));
		register(282, "mushroom_stew", (new ItemSoup(6)).setName("mushroomStew"));
		register(283, "golden_sword", (new ItemSword(EnumToolMaterial.GOLD)).setName("swordGold"));
		register(284, "golden_shovel", (new ItemSpade(EnumToolMaterial.GOLD)).setName("shovelGold"));
		register(285, "golden_pickaxe", (new ItemPickaxe(EnumToolMaterial.GOLD)).setName("pickaxeGold"));
		register(286, "golden_axe", (new ItemAxe(EnumToolMaterial.GOLD)).setName("hatchetGold"));
		register(287, "string", (new ItemReed(Blocks.TRIPWIRE)).setName("string").setCreativeModeTab(CreativeModeTab.MATERIALS));
		register(288, "feather", (new Item()).setName("feather").setCreativeModeTab(CreativeModeTab.MATERIALS));
		register(289, "gunpowder", (new Item()).setName("sulphur").e(PotionBrewer.k).setCreativeModeTab(CreativeModeTab.MATERIALS));
		register(290, "wooden_hoe", (new ItemHoe(EnumToolMaterial.WOOD)).setName("hoeWood"));
		register(291, "stone_hoe", (new ItemHoe(EnumToolMaterial.STONE)).setName("hoeStone"));
		register(292, "iron_hoe", (new ItemHoe(EnumToolMaterial.IRON)).setName("hoeIron"));
		register(293, "diamond_hoe", (new ItemHoe(EnumToolMaterial.EMERALD)).setName("hoeDiamond"));
		register(294, "golden_hoe", (new ItemHoe(EnumToolMaterial.GOLD)).setName("hoeGold"));
		register(295, "wheat_seeds", (new ItemSeeds(Blocks.WHEAT, Blocks.FARMLAND)).setName("seeds"));
		register(296, "wheat", (new Item()).setName("wheat").setCreativeModeTab(CreativeModeTab.MATERIALS));
		register(297, "bread", (new ItemFood(5, 0.6F, false)).setName("bread"));
		register(298, "leather_helmet", (new ItemArmor(EnumArmorMaterial.LEATHER, 0, 0)).setName("helmetCloth"));
		register(299, "leather_chestplate", (new ItemArmor(EnumArmorMaterial.LEATHER, 0, 1)).setName("chestplateCloth"));
		register(300, "leather_leggings", (new ItemArmor(EnumArmorMaterial.LEATHER, 0, 2)).setName("leggingsCloth"));
		register(301, "leather_boots", (new ItemArmor(EnumArmorMaterial.LEATHER, 0, 3)).setName("bootsCloth"));
		register(302, "chainmail_helmet", (new ItemArmor(EnumArmorMaterial.CHAIN, 1, 0)).setName("helmetChain"));
		register(303, "chainmail_chestplate", (new ItemArmor(EnumArmorMaterial.CHAIN, 1, 1)).setName("chestplateChain"));
		register(304, "chainmail_leggings", (new ItemArmor(EnumArmorMaterial.CHAIN, 1, 2)).setName("leggingsChain"));
		register(305, "chainmail_boots", (new ItemArmor(EnumArmorMaterial.CHAIN, 1, 3)).setName("bootsChain"));
		register(306, "iron_helmet", (new ItemArmor(EnumArmorMaterial.IRON, 2, 0)).setName("helmetIron"));
		register(307, "iron_chestplate", (new ItemArmor(EnumArmorMaterial.IRON, 2, 1)).setName("chestplateIron"));
		register(308, "iron_leggings", (new ItemArmor(EnumArmorMaterial.IRON, 2, 2)).setName("leggingsIron"));
		register(309, "iron_boots", (new ItemArmor(EnumArmorMaterial.IRON, 2, 3)).setName("bootsIron"));
		register(310, "diamond_helmet", (new ItemArmor(EnumArmorMaterial.DIAMOND, 3, 0)).setName("helmetDiamond"));
		register(311, "diamond_chestplate", (new ItemArmor(EnumArmorMaterial.DIAMOND, 3, 1)).setName("chestplateDiamond"));
		register(312, "diamond_leggings", (new ItemArmor(EnumArmorMaterial.DIAMOND, 3, 2)).setName("leggingsDiamond"));
		register(313, "diamond_boots", (new ItemArmor(EnumArmorMaterial.DIAMOND, 3, 3)).setName("bootsDiamond"));
		register(314, "golden_helmet", (new ItemArmor(EnumArmorMaterial.GOLD, 4, 0)).setName("helmetGold"));
		register(315, "golden_chestplate", (new ItemArmor(EnumArmorMaterial.GOLD, 4, 1)).setName("chestplateGold"));
		register(316, "golden_leggings", (new ItemArmor(EnumArmorMaterial.GOLD, 4, 2)).setName("leggingsGold"));
		register(317, "golden_boots", (new ItemArmor(EnumArmorMaterial.GOLD, 4, 3)).setName("bootsGold"));
		register(318, "flint", (new Item()).setName("flint").setCreativeModeTab(CreativeModeTab.MATERIALS));
		register(319, "porkchop", (new ItemFood(3, 0.3F, true)).setName("porkchopRaw"));
		register(320, "cooked_porkchop", (new ItemFood(8, 0.8F, true)).setName("porkchopCooked"));
		register(321, "painting", (new ItemHanging(EntityPainting.class)).setName("painting"));
		register(322, "golden_apple", (new ItemGoldenApple(4, 1.2F, false)).h().a(MobEffectList.REGENERATION.id, 5, 1, 1.0F).setName("appleGold"));
		register(323, "sign", (new ItemSign()).setName("sign"));
		register(324, "wooden_door", (new ItemDoor(Blocks.WOODEN_DOOR)).setName("doorOak"));
		Item bucket = (new ItemBucket(Blocks.AIR)).setName("bucket").setMaxStackSize(16);
		register(325, "bucket", bucket);
		register(326, "water_bucket", (new ItemBucket(Blocks.FLOWING_WATER)).setName("bucketWater").setCraftingResult(bucket));
		register(327, "lava_bucket", (new ItemBucket(Blocks.FLOWING_LAVA)).setName("bucketLava").setCraftingResult(bucket));
		register(328, "minecart", (new ItemMinecart(MinecartType.RIDEABLE)).setName("minecart"));
		register(329, "saddle", (new ItemSaddle()).setName("saddle"));
		register(330, "iron_door", (new ItemDoor(Blocks.IRON_DOOR)).setName("doorIron"));
		register(331, "redstone", (new ItemRedstone()).setName("redstone").e(PotionBrewer.i));
		register(332, "snowball", (new ItemSnowball()).setName("snowball"));
		register(333, "boat", (new ItemBoat()).setName("boat"));
		register(334, "leather", (new Item()).setName("leather").setCreativeModeTab(CreativeModeTab.MATERIALS));
		register(335, "milk_bucket", (new ItemMilkBucket()).setName("milk").setCraftingResult(bucket));
		register(336, "brick", (new Item()).setName("brick").setCreativeModeTab(CreativeModeTab.MATERIALS));
		register(337, "clay_ball", (new Item()).setName("clay").setCreativeModeTab(CreativeModeTab.MATERIALS));
		register(338, "reeds", (new ItemReed(Blocks.REEDS)).setName("reeds").setCreativeModeTab(CreativeModeTab.MATERIALS));
		register(339, "paper", (new Item()).setName("paper").setCreativeModeTab(CreativeModeTab.MISC));
		register(340, "book", (new ItemBook()).setName("book").setCreativeModeTab(CreativeModeTab.MISC));
		register(341, "slime_ball", (new Item()).setName("slimeball").setCreativeModeTab(CreativeModeTab.MISC));
		register(342, "chest_minecart", (new ItemMinecart(MinecartType.CHEST)).setName("minecartChest"));
		register(343, "furnace_minecart", (new ItemMinecart(MinecartType.FURNACE)).setName("minecartFurnace"));
		register(344, "egg", (new ItemEgg()).setName("egg"));
		register(345, "compass", (new Item()).setName("compass").setCreativeModeTab(CreativeModeTab.TOOLS));
		register(346, "fishing_rod", (new ItemFishingRod()).setName("fishingRod"));
		register(347, "clock", (new Item()).setName("clock").setCreativeModeTab(CreativeModeTab.TOOLS));
		register(348, "glowstone_dust", (new Item()).setName("yellowDust").e(PotionBrewer.j).setCreativeModeTab(CreativeModeTab.MATERIALS));
		register(349, "fish", (new ItemFish(false)).setName("fish").a(true));
		register(350, "cooked_fish", (new ItemFish(true)).setName("fish").a(true));
		register(351, "dye", (new ItemDye()).setName("dyePowder"));
		register(352, "bone", (new Item()).setName("bone").n().setCreativeModeTab(CreativeModeTab.MISC));
		register(353, "sugar", (new Item()).setName("sugar").e(PotionBrewer.b).setCreativeModeTab(CreativeModeTab.MATERIALS));
		register(354, "cake", (new ItemReed(Blocks.CAKE)).setMaxStackSize(1).setName("cake").setCreativeModeTab(CreativeModeTab.FOOD));
		register(355, "bed", (new ItemBed()).setMaxStackSize(1).setName("bed"));
		register(356, "repeater", (new ItemReed(Blocks.UNPOWERED_REPEATER)).setName("diode").setCreativeModeTab(CreativeModeTab.REDSTONE));
		register(357, "cookie", (new ItemFood(2, 0.1F, false)).setName("cookie"));
		register(358, "filled_map", (new ItemMapFilled()).setName("map"));
		register(359, "shears", (new ItemShears()).setName("shears"));
		register(360, "melon", (new ItemFood(2, 0.3F, false)).setName("melon"));
		register(361, "pumpkin_seeds", (new ItemSeeds(Blocks.PUMPKIN_STEM, Blocks.FARMLAND)).setName("seeds_pumpkin"));
		register(362, "melon_seeds", (new ItemSeeds(Blocks.MELON_STEM, Blocks.FARMLAND)).setName("seeds_melon"));
		register(363, "beef", (new ItemFood(3, 0.3F, true)).setName("beefRaw"));
		register(364, "cooked_beef", (new ItemFood(8, 0.8F, true)).setName("beefCooked"));
		register(365, "chicken", (new ItemFood(2, 0.3F, true)).a(MobEffectList.HUNGER.id, 30, 0, 0.3F).setName("chickenRaw"));
		register(366, "cooked_chicken", (new ItemFood(6, 0.6F, true)).setName("chickenCooked"));
		register(367, "rotten_flesh", (new ItemFood(4, 0.1F, true)).a(MobEffectList.HUNGER.id, 30, 0, 0.8F).setName("rottenFlesh"));
		register(368, "ender_pearl", (new ItemEnderPearl()).setName("enderPearl"));
		register(369, "blaze_rod", (new Item()).setName("blazeRod").setCreativeModeTab(CreativeModeTab.MATERIALS).n());
		register(370, "ghast_tear", (new Item()).setName("ghastTear").e(PotionBrewer.c).setCreativeModeTab(CreativeModeTab.BREWING));
		register(371, "gold_nugget", (new Item()).setName("goldNugget").setCreativeModeTab(CreativeModeTab.MATERIALS));
		register(372, "nether_wart", (new ItemSeeds(Blocks.NETHER_WART, Blocks.SOUL_SAND)).setName("netherStalkSeeds").e("+4"));
		register(373, "potion", (new ItemPotion()).setName("potion"));
		register(374, "glass_bottle", (new ItemGlassBottle()).setName("glassBottle"));
		register(375, "spider_eye", (new ItemFood(2, 0.8F, false)).a(MobEffectList.POISON.id, 5, 0, 1.0F).setName("spiderEye").e(PotionBrewer.d));
		register(376, "fermented_spider_eye", (new Item()).setName("fermentedSpiderEye").e(PotionBrewer.e).setCreativeModeTab(CreativeModeTab.BREWING));
		register(377, "blaze_powder", (new Item()).setName("blazePowder").e(PotionBrewer.g).setCreativeModeTab(CreativeModeTab.BREWING));
		register(378, "magma_cream", (new Item()).setName("magmaCream").e(PotionBrewer.h).setCreativeModeTab(CreativeModeTab.BREWING));
		register(379, "brewing_stand", (new ItemReed(Blocks.BREWING_STAND)).setName("brewingStand").setCreativeModeTab(CreativeModeTab.BREWING));
		register(380, "cauldron", (new ItemReed(Blocks.CAULDRON)).setName("cauldron").setCreativeModeTab(CreativeModeTab.BREWING));
		register(381, "ender_eye", (new ItemEnderEye()).setName("eyeOfEnder"));
		register(382, "speckled_melon", (new Item()).setName("speckledMelon").e(PotionBrewer.f).setCreativeModeTab(CreativeModeTab.BREWING));
		register(383, "spawn_egg", (new ItemMonsterEgg()).setName("monsterPlacer"));
		register(384, "experience_bottle", (new ald()).setName("expBottle"));
		register(385, "fire_charge", (new ItemFireball()).setName("fireball"));
		register(386, "writable_book", (new ItemBookAndQuill()).setName("writingBook").setCreativeModeTab(CreativeModeTab.MISC));
		register(387, "written_book", (new ItemWrittenBook()).setName("writtenBook").setMaxStackSize(16));
		register(388, "emerald", (new Item()).setName("emerald").setCreativeModeTab(CreativeModeTab.MATERIALS));
		register(389, "item_frame", (new ItemHanging(EntityItemFrame.class)).setName("frame"));
		register(390, "flower_pot", (new ItemReed(Blocks.FLOWER_POT)).setName("flowerPot").setCreativeModeTab(CreativeModeTab.DECORATIONS));
		register(391, "carrot", (new ItemSeedFood(3, 0.6F, Blocks.CARROTS, Blocks.FARMLAND)).setName("carrots"));
		register(392, "potato", (new ItemSeedFood(1, 0.3F, Blocks.POTATOES, Blocks.FARMLAND)).setName("potato"));
		register(393, "baked_potato", (new ItemFood(5, 0.6F, false)).setName("potatoBaked"));
		register(394, "poisonous_potato", (new ItemFood(2, 0.3F, false)).a(MobEffectList.POISON.id, 5, 0, 0.6F).setName("potatoPoisonous"));
		register(395, "map", (new ItemMapEmpty()).setName("emptyMap"));
		register(396, "golden_carrot", (new ItemFood(6, 1.2F, false)).setName("carrotGolden").e(PotionBrewer.l).setCreativeModeTab(CreativeModeTab.BREWING));
		register(397, "skull", (new ItemSkull()).setName("skull"));
		register(398, "carrot_on_a_stick", (new ItemCarrotStick()).setName("carrotOnAStick"));
		register(399, "nether_star", (new ItemNetherStar()).setName("netherStar").setCreativeModeTab(CreativeModeTab.MATERIALS));
		register(400, "pumpkin_pie", (new ItemFood(8, 0.3F, false)).setName("pumpkinPie").setCreativeModeTab(CreativeModeTab.FOOD));
		register(401, "fireworks", (new ItemFireworks()).setName("fireworks"));
		register(402, "firework_charge", (new ItemFireworksCharge()).setName("fireworksCharge").setCreativeModeTab(CreativeModeTab.MISC));
		register(403, "enchanted_book", (new ItemEnchantedBook()).setMaxStackSize(1).setName("enchantedBook"));
		register(404, "comparator", (new ItemReed(Blocks.UNPOWERED_COMPARATOR)).setName("comparator").setCreativeModeTab(CreativeModeTab.REDSTONE));
		register(405, "netherbrick", (new Item()).setName("netherbrick").setCreativeModeTab(CreativeModeTab.MATERIALS));
		register(406, "quartz", (new Item()).setName("netherquartz").setCreativeModeTab(CreativeModeTab.MATERIALS));
		register(407, "tnt_minecart", (new ItemMinecart(MinecartType.TNT)).setName("minecartTnt"));
		register(408, "hopper_minecart", (new ItemMinecart(MinecartType.HOPPER)).setName("minecartHopper"));
		register(409, "prismarine_shard", (new Item()).setName("prismarineShard").setCreativeModeTab(CreativeModeTab.MATERIALS));
		register(410, "prismarine_crystals", (new Item()).setName("prismarineCrystals").setCreativeModeTab(CreativeModeTab.MATERIALS));
		register(411, "rabbit", (new ItemFood(3, 0.3F, true)).setName("rabbitRaw"));
		register(412, "cooked_rabbit", (new ItemFood(5, 0.6F, true)).setName("rabbitCooked"));
		register(413, "rabbit_stew", (new ItemSoup(10)).setName("rabbitStew"));
		register(414, "rabbit_foot", (new Item()).setName("rabbitFoot").e(PotionBrewer.n).setCreativeModeTab(CreativeModeTab.BREWING));
		register(415, "rabbit_hide", (new Item()).setName("rabbitHide").setCreativeModeTab(CreativeModeTab.MATERIALS));
		register(416, "armor_stand", (new ItemArmorStand()).setName("armorStand").setMaxStackSize(16));
		register(417, "iron_horse_armor", (new Item()).setName("horsearmormetal").setMaxStackSize(1).setCreativeModeTab(CreativeModeTab.MISC));
		register(418, "golden_horse_armor", (new Item()).setName("horsearmorgold").setMaxStackSize(1).setCreativeModeTab(CreativeModeTab.MISC));
		register(419, "diamond_horse_armor", (new Item()).setName("horsearmordiamond").setMaxStackSize(1).setCreativeModeTab(CreativeModeTab.MISC));
		register(420, "lead", (new ItemLeash()).setName("leash"));
		register(421, "name_tag", (new ItemNameTag()).setName("nameTag"));
		register(422, "command_block_minecart", (new ItemMinecart(MinecartType.COMMAND_BLOCK)).setName("minecartCommandBlock").setCreativeModeTab((CreativeModeTab) null));
		register(423, "mutton", (new ItemFood(2, 0.3F, true)).setName("muttonRaw"));
		register(424, "cooked_mutton", (new ItemFood(6, 0.8F, true)).setName("muttonCooked"));
		register(425, "banner", (new ItemBanner()).setBlockName("banner"));
		register(427, "spruce_door", (new ItemDoor(Blocks.SPRUCE_DOOR)).setName("doorSpruce"));
		register(428, "birch_door", (new ItemDoor(Blocks.BIRCH_DOOR)).setName("doorBirch"));
		register(429, "jungle_door", (new ItemDoor(Blocks.JUNGLE_DOOR)).setName("doorJungle"));
		register(430, "acacia_door", (new ItemDoor(Blocks.ACACIA_DOOR)).setName("doorAcacia"));
		register(431, "dark_oak_door", (new ItemDoor(Blocks.DARK_OAK_DOOR)).setName("doorDarkOak"));
		register(2256, "record_13", (new ItemRecord("13")).setName("record"));
		register(2257, "record_cat", (new ItemRecord("cat")).setName("record"));
		register(2258, "record_blocks", (new ItemRecord("blocks")).setName("record"));
		register(2259, "record_chirp", (new ItemRecord("chirp")).setName("record"));
		register(2260, "record_far", (new ItemRecord("far")).setName("record"));
		register(2261, "record_mall", (new ItemRecord("mall")).setName("record"));
		register(2262, "record_mellohi", (new ItemRecord("mellohi")).setName("record"));
		register(2263, "record_stal", (new ItemRecord("stal")).setName("record"));
		register(2264, "record_strad", (new ItemRecord("strad")).setName("record"));
		register(2265, "record_ward", (new ItemRecord("ward")).setName("record"));
		register(2266, "record_11", (new ItemRecord("11")).setName("record"));
		register(2267, "record_wait", (new ItemRecord("wait")).setName("record"));
	}

	private static void register(Block block) {
		register(block, new ItemBlock(block));
	}

	protected static void register(Block block, Item item) {
		register(Block.getBlockId(block), (RegistryObjectName) Block.BLOCKREGISTRY.c(block), item);
		blockToItem.put(block, item);
	}

	private static void register(int id, String name, Item item) {
		register(id, new RegistryObjectName(name), item);
	}

	private static void register(int id, RegistryObjectName name, Item item) {
		REGISTRY.register(id, name, item);
	}

}

package net.minecraft;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

public class Item {

	public static final RegistryMaterials REGISTRY = new RegistryMaterials();
	private static final Map<Block, Item> a = Maps.newHashMap();
	protected static final UUID f = UUID.fromString("CB3F55D3-645C-4F38-A497-9C13A33DB5CF");
	protected static Random rnd = new Random();
	protected int maxStackSize = 64;
	private int durability;
	protected boolean i;
	protected boolean j;
	private Item craftingResult;
	private String k;
	private String l;

	public static int getId(Item var0) {
		return var0 == null ? 0 : REGISTRY.getBlockId(var0);
	}

	public static Item getById(int id) {
		return (Item) REGISTRY.getById(id);
	}

	public static Item getItemOf(Block block) {
		return (Item) a.get(block);
	}

	public static Item d(String var0) {
		Item var1 = (Item) REGISTRY.getByName(new RegistryObjectName(var0));
		if (var1 == null) {
			try {
				return getById(Integer.parseInt(var0));
			} catch (NumberFormatException var3) {
			}
		}

		return var1;
	}

	public boolean a(NBTCompoundTag var1) {
		return false;
	}

	public Item c(int var1) {
		this.maxStackSize = var1;
		return this;
	}

	public boolean a(ItemStack var1, EntityHuman var2, World var3, Position var4, PaintingDirection var5, float var6, float var7, float var8) {
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

	public int j() {
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

	public int l() {
		return this.durability;
	}

	protected Item d(int var1) {
		this.durability = var1;
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

	public Item c(String var1) {
		this.l = var1;
		return this;
	}

	public String k(ItemStack var1) {
		String var2 = this.e_(var1);
		return var2 == null ? "" : LocaleI18n.get(var2);
	}

	public String a() {
		return "item." + this.l;
	}

	public String e_(ItemStack var1) {
		return "item." + this.l;
	}

	public Item c(Item var1) {
		this.craftingResult = var1;
		return this;
	}

	public boolean p() {
		return true;
	}

	public Item q() {
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
		return ("" + LocaleI18n.get(this.k(var1) + ".name")).trim();
	}

	public amx g(ItemStack var1) {
		return var1.w() ? amx.c : amx.a;
	}

	public boolean f_(ItemStack var1) {
		return this.j() == 1 && this.usesDurability();
	}

	protected bru a(World var1, EntityHuman var2, boolean var3) {
		float var4 = var2.B + (var2.pitch - var2.B);
		float var5 = var2.A + (var2.yaw - var2.A);
		double var6 = var2.p + (var2.locationX - var2.p);
		double var8 = var2.q + (var2.locationY - var2.q) + (double) var2.aR();
		double var10 = var2.r + (var2.locationZ - var2.r);
		Vec3D var12 = new Vec3D(var6, var8, var10);
		float var13 = DataTypesConverter.b(-var5 * 0.017453292F - 3.1415927F);
		float var14 = DataTypesConverter.a(-var5 * 0.017453292F - 3.1415927F);
		float var15 = -DataTypesConverter.b(-var4 * 0.017453292F);
		float var16 = DataTypesConverter.a(-var4 * 0.017453292F);
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
		a(Blocks.STONE, (Item) (new amr(Blocks.STONE, Blocks.STONE, new alr())).b("stone"));
		a((Block) Blocks.GRASS, (Item) (new ann(Blocks.GRASS, false)));
		a(Blocks.DIRT, (Item) (new amr(Blocks.DIRT, Blocks.DIRT, new ama())).b("dirt"));
		c(Blocks.COBBLESTONE);
		a(Blocks.PLANKS, (Item) (new amr(Blocks.PLANKS, Blocks.PLANKS, new amb())).b("wood"));
		a(Blocks.SAPLING, (Item) (new amr(Blocks.SAPLING, Blocks.SAPLING, new amc())).b("sapling"));
		c(Blocks.BEDROCK);
		a((Block) Blocks.SAND, (Item) (new amr(Blocks.SAND, Blocks.SAND, new amd())).b("sand"));
		c(Blocks.GRAVEL);
		c(Blocks.GOLD_ORE);
		c(Blocks.IRON_ORE);
		c(Blocks.COAL_ORE);
		a(Blocks.LOG, (Item) (new amr(Blocks.LOG, Blocks.LOG, new ame())).b("log"));
		a(Blocks.LOG2, (Item) (new amr(Blocks.LOG2, Blocks.LOG2, new amf())).b("log"));
		a((Block) Blocks.LEAVES, (Item) (new amm(Blocks.LEAVES)).b("leaves"));
		a((Block) Blocks.LEAVES2, (Item) (new amm(Blocks.LEAVES2)).b("leaves"));
		a(Blocks.SPONGE, (Item) (new amr(Blocks.SPONGE, Blocks.SPONGE, new amg())).b("sponge"));
		c(Blocks.GLASS);
		c(Blocks.LAPIS_ORE);
		c(Blocks.LAPIS_BLOCK);
		c(Blocks.DISPENSER);
		a(Blocks.SANDSTONE, (Item) (new amr(Blocks.SANDSTONE, Blocks.SANDSTONE, new amh())).b("sandStone"));
		c(Blocks.NOTEBLOCK);
		c(Blocks.GOLDEN_RAIL);
		c(Blocks.DETECTOR_RAIL);
		a((Block) Blocks.STICKY_PISTON, (Item) (new amv(Blocks.STICKY_PISTON)));
		c(Blocks.WEB);
		a((Block) Blocks.TALLGRASS, (Item) (new ann(Blocks.TALLGRASS, true)).a(new String[] { "shrub", "grass", "fern" }));
		c((Block) Blocks.DEADBUSH);
		a((Block) Blocks.PISTON, (Item) (new amv(Blocks.PISTON)));
		a(Blocks.WOOL, (Item) (new akx(Blocks.WOOL)).b("cloth"));
		a((Block) Blocks.YELLOW_FLOWER, (Item) (new amr(Blocks.YELLOW_FLOWER, Blocks.YELLOW_FLOWER, new als())).b("flower"));
		a((Block) Blocks.RED_FLOWER, (Item) (new amr(Blocks.RED_FLOWER, Blocks.RED_FLOWER, new alt())).b("rose"));
		c((Block) Blocks.BRWON_MUSHROOM);
		c((Block) Blocks.RED_MUSHROOM);
		c(Blocks.GOLD_BLOCK);
		c(Blocks.IRON_BLOCK);
		a((Block) Blocks.STONE_SLAB, (Item) (new ani(Blocks.STONE_SLAB, Blocks.STONE_SLAB, Blocks.DOUBLE_STONE_SLAB)).b("stoneSlab"));
		c(Blocks.BRICK_BLOCK);
		c(Blocks.TNT);
		c(Blocks.BOOKSHELF);
		c(Blocks.MOSSY_COBBLESTONE);
		c(Blocks.OBSIDIAN);
		c(Blocks.aa);
		c(Blocks.ac);
		c(Blocks.ad);
		c((Block) Blocks.ae);
		c(Blocks.ag);
		c(Blocks.ah);
		c(Blocks.ai);
		c(Blocks.ak);
		c(Blocks.al);
		c(Blocks.am);
		c(Blocks.au);
		c(Blocks.av);
		c(Blocks.aw);
		c(Blocks.ay);
		c(Blocks.az);
		c(Blocks.aB);
		c(Blocks.aC);
		c(Blocks.aF);
		c(Blocks.aG);
		a(Blocks.aH, (Item) (new anj(Blocks.aH)));
		c(Blocks.aI);
		c(Blocks.aJ);
		c((Block) Blocks.aK);
		c(Blocks.aL);
		c(Blocks.aN);
		c(Blocks.aO);
		c(Blocks.aP);
		c(Blocks.aQ);
		c(Blocks.aR);
		c(Blocks.aS);
		c(Blocks.aT);
		c(Blocks.aU);
		c(Blocks.aV);
		c(Blocks.aW);
		c(Blocks.aX);
		c(Blocks.aZ);
		c(Blocks.bd);
		a(Blocks.be, (Item) (new amr(Blocks.be, Blocks.be, new alu())).b("monsterStoneEgg"));
		a(Blocks.bf, (Item) (new amr(Blocks.bf, Blocks.bf, new alv())).b("stonebricksmooth"));
		c(Blocks.bg);
		c(Blocks.bh);
		c(Blocks.bi);
		c(Blocks.bj);
		c(Blocks.bk);
		a(Blocks.bn, (Item) (new ann(Blocks.bn, false)));
		c(Blocks.bo);
		c(Blocks.bp);
		c(Blocks.bq);
		c(Blocks.br);
		c(Blocks.bs);
		c(Blocks.bt);
		c(Blocks.bu);
		c(Blocks.bv);
		c((Block) Blocks.bw);
		a(Blocks.bx, (Item) (new anp(Blocks.bx)));
		c(Blocks.by);
		c(Blocks.bz);
		c(Blocks.bA);
		c(Blocks.bC);
		c(Blocks.bG);
		c(Blocks.bH);
		c(Blocks.bI);
		c(Blocks.bJ);
		a((Block) Blocks.bM, (Item) (new ani(Blocks.bM, Blocks.bM, Blocks.bL)).b("woodSlab"));
		c(Blocks.bO);
		c(Blocks.bP);
		c(Blocks.bQ);
		c((Block) Blocks.bR);
		c(Blocks.bT);
		c(Blocks.bU);
		c(Blocks.bV);
		c(Blocks.bW);
		c(Blocks.bX);
		c((Block) Blocks.bY);
		a(Blocks.bZ, (Item) (new amr(Blocks.bZ, Blocks.bZ, new alw())).b("cobbleWall"));
		c(Blocks.cd);
		a(Blocks.cf, (Item) (new ajm(Blocks.cf)).b("anvil"));
		c(Blocks.cg);
		c(Blocks.ch);
		c(Blocks.ci);
		c((Block) Blocks.cl);
		c(Blocks.cn);
		c(Blocks.co);
		c((Block) Blocks.cp);
		a(Blocks.cq, (Item) (new amr(Blocks.cq, Blocks.cq, new String[] { "default", "chiseled", "lines" })).b("quartzBlock"));
		c(Blocks.cr);
		c(Blocks.cs);
		c(Blocks.ct);
		a(Blocks.cu, (Item) (new akx(Blocks.cu)).b("clayHardenedStained"));
		c(Blocks.cv);
		c(Blocks.cw);
		c(Blocks.cx);
		a(Blocks.cy, (Item) (new akx(Blocks.cy)).b("woolCarpet"));
		c(Blocks.cz);
		c(Blocks.cA);
		c(Blocks.cB);
		c(Blocks.cC);
		c(Blocks.cD);
		c(Blocks.cE);
		a((Block) Blocks.cF, (Item) (new aku(Blocks.cF, Blocks.cF, new alx())).b("doublePlant"));
		a((Block) Blocks.cG, (Item) (new akx(Blocks.cG)).b("stainedGlass"));
		a((Block) Blocks.cH, (Item) (new akx(Blocks.cH)).b("stainedGlassPane"));
		a(Blocks.cI, (Item) (new amr(Blocks.cI, Blocks.cI, new aly())).b("prismarine"));
		c(Blocks.cJ);
		a(Blocks.cM, (Item) (new amr(Blocks.cM, Blocks.cM, new alz())).b("redSandStone"));
		c(Blocks.cN);
		a((Block) Blocks.cP, (Item) (new ani(Blocks.cP, Blocks.cP, Blocks.cO)).b("stoneSlab2"));
		a(256, "iron_shovel", (new ane(ami.c)).c("shovelIron"));
		a(257, "iron_pickaxe", (new amu(ami.c)).c("pickaxeIron"));
		a(258, "iron_axe", (new ajr(ami.c)).c("hatchetIron"));
		a(259, "flint_and_steel", (new alk()).c("flintAndSteel"));
		a(260, "apple", (new all(4, 0.3F, false)).c("apple"));
		a(261, "bow", (new ItemBow()).c("bow"));
		a(262, "arrow", (new Item()).c("arrow").setCreativeModeTab(CreativeModeTab.COMBAT));
		a(263, "coal", (new akd()).c("coal"));
		a(264, "diamond", (new Item()).c("diamond").setCreativeModeTab(CreativeModeTab.MATERIALS));
		a(265, "iron_ingot", (new Item()).c("ingotIron").setCreativeModeTab(CreativeModeTab.MATERIALS));
		a(266, "gold_ingot", (new Item()).c("ingotGold").setCreativeModeTab(CreativeModeTab.MATERIALS));
		a(267, "iron_sword", (new ItemSword(ami.c)).c("swordIron"));
		a(268, "wooden_sword", (new ItemSword(ami.a)).c("swordWood"));
		a(269, "wooden_shovel", (new ane(ami.a)).c("shovelWood"));
		a(270, "wooden_pickaxe", (new amu(ami.a)).c("pickaxeWood"));
		a(271, "wooden_axe", (new ajr(ami.a)).c("hatchetWood"));
		a(272, "stone_sword", (new ItemSword(ami.b)).c("swordStone"));
		a(273, "stone_shovel", (new ane(ami.b)).c("shovelStone"));
		a(274, "stone_pickaxe", (new amu(ami.b)).c("pickaxeStone"));
		a(275, "stone_axe", (new ajr(ami.b)).c("hatchetStone"));
		a(276, "diamond_sword", (new ItemSword(ami.d)).c("swordDiamond"));
		a(277, "diamond_shovel", (new ane(ami.d)).c("shovelDiamond"));
		a(278, "diamond_pickaxe", (new amu(ami.d)).c("pickaxeDiamond"));
		a(279, "diamond_axe", (new ajr(ami.d)).c("hatchetDiamond"));
		a(280, "stick", (new Item()).n().c("stick").setCreativeModeTab(CreativeModeTab.MATERIALS));
		a(281, "bowl", (new Item()).c("bowl").setCreativeModeTab(CreativeModeTab.MATERIALS));
		a(282, "mushroom_stew", (new aka(6)).c("mushroomStew"));
		a(283, "golden_sword", (new ItemSword(ami.e)).c("swordGold"));
		a(284, "golden_shovel", (new ane(ami.e)).c("shovelGold"));
		a(285, "golden_pickaxe", (new amu(ami.e)).c("pickaxeGold"));
		a(286, "golden_axe", (new ajr(ami.e)).c("hatchetGold"));
		a(287, "string", (new ajv(Blocks.bS)).c("string").setCreativeModeTab(CreativeModeTab.MATERIALS));
		a(288, "feather", (new Item()).c("feather").setCreativeModeTab(CreativeModeTab.MATERIALS));
		a(289, "gunpowder", (new Item()).c("sulphur").e(ans.k).setCreativeModeTab(CreativeModeTab.MATERIALS));
		a(290, "wooden_hoe", (new alo(ami.a)).c("hoeWood"));
		a(291, "stone_hoe", (new alo(ami.b)).c("hoeStone"));
		a(292, "iron_hoe", (new alo(ami.c)).c("hoeIron"));
		a(293, "diamond_hoe", (new alo(ami.d)).c("hoeDiamond"));
		a(294, "golden_hoe", (new alo(ami.e)).c("hoeGold"));
		a(295, "wheat_seeds", (new anc(Blocks.aj, Blocks.ak)).c("seeds"));
		a(296, "wheat", (new Item()).c("wheat").setCreativeModeTab(CreativeModeTab.MATERIALS));
		a(297, "bread", (new all(5, 0.6F, false)).c("bread"));
		a(298, "leather_helmet", (new ItemArmor(ajp.a, 0, 0)).c("helmetCloth"));
		a(299, "leather_chestplate", (new ItemArmor(ajp.a, 0, 1)).c("chestplateCloth"));
		a(300, "leather_leggings", (new ItemArmor(ajp.a, 0, 2)).c("leggingsCloth"));
		a(301, "leather_boots", (new ItemArmor(ajp.a, 0, 3)).c("bootsCloth"));
		a(302, "chainmail_helmet", (new ItemArmor(ajp.b, 1, 0)).c("helmetChain"));
		a(303, "chainmail_chestplate", (new ItemArmor(ajp.b, 1, 1)).c("chestplateChain"));
		a(304, "chainmail_leggings", (new ItemArmor(ajp.b, 1, 2)).c("leggingsChain"));
		a(305, "chainmail_boots", (new ItemArmor(ajp.b, 1, 3)).c("bootsChain"));
		a(306, "iron_helmet", (new ItemArmor(ajp.c, 2, 0)).c("helmetIron"));
		a(307, "iron_chestplate", (new ItemArmor(ajp.c, 2, 1)).c("chestplateIron"));
		a(308, "iron_leggings", (new ItemArmor(ajp.c, 2, 2)).c("leggingsIron"));
		a(309, "iron_boots", (new ItemArmor(ajp.c, 2, 3)).c("bootsIron"));
		a(310, "diamond_helmet", (new ItemArmor(ajp.e, 3, 0)).c("helmetDiamond"));
		a(311, "diamond_chestplate", (new ItemArmor(ajp.e, 3, 1)).c("chestplateDiamond"));
		a(312, "diamond_leggings", (new ItemArmor(ajp.e, 3, 2)).c("leggingsDiamond"));
		a(313, "diamond_boots", (new ItemArmor(ajp.e, 3, 3)).c("bootsDiamond"));
		a(314, "golden_helmet", (new ItemArmor(ajp.d, 4, 0)).c("helmetGold"));
		a(315, "golden_chestplate", (new ItemArmor(ajp.d, 4, 1)).c("chestplateGold"));
		a(316, "golden_leggings", (new ItemArmor(ajp.d, 4, 2)).c("leggingsGold"));
		a(317, "golden_boots", (new ItemArmor(ajp.d, 4, 3)).c("bootsGold"));
		a(318, "flint", (new Item()).c("flint").setCreativeModeTab(CreativeModeTab.MATERIALS));
		a(319, "porkchop", (new all(3, 0.3F, true)).c("porkchopRaw"));
		a(320, "cooked_porkchop", (new all(8, 0.8F, true)).c("porkchopCooked"));
		a(321, "painting", (new aln(EntityPainting.class)).c("painting"));
		a(322, "golden_apple", (new alm(4, 1.2F, false)).h().a(MobEffectList.l.H, 5, 1, 1.0F).c("appleGold"));
		a(323, "sign", (new anf()).c("sign"));
		a(324, "wooden_door", (new akt(Blocks.ao)).c("doorOak"));
		Item var0 = (new akb(Blocks.AIR)).c("bucket").c(16);
		a(325, "bucket", var0);
		a(326, "water_bucket", (new akb(Blocks.FLOWING_WATER)).c("bucketWater").c(var0));
		a(327, "lava_bucket", (new akb(Blocks.FLOWING_LAVA)).c("bucketLava").c(var0));
		a(328, "minecart", (new amp(MinecartType.RIDEABLE)).c("minecart"));
		a(329, "saddle", (new ana()).c("saddle"));
		a(330, "iron_door", (new akt(Blocks.aA)).c("doorIron"));
		a(331, "redstone", (new amz()).c("redstone").e(ans.i));
		a(332, "snowball", (new ank()).c("snowball"));
		a(333, "boat", (new ajw()).c("boat"));
		a(334, "leather", (new Item()).c("leather").setCreativeModeTab(CreativeModeTab.MATERIALS));
		a(335, "milk_bucket", (new amo()).c("milk").c(var0));
		a(336, "brick", (new Item()).c("brick").setCreativeModeTab(CreativeModeTab.MATERIALS));
		a(337, "clay_ball", (new Item()).c("clay").setCreativeModeTab(CreativeModeTab.MATERIALS));
		a(338, "reeds", (new ajv(Blocks.aM)).c("reeds").setCreativeModeTab(CreativeModeTab.MATERIALS));
		a(339, "paper", (new Item()).c("paper").setCreativeModeTab(CreativeModeTab.MISC));
		a(340, "book", (new ajx()).c("book").setCreativeModeTab(CreativeModeTab.MISC));
		a(341, "slime_ball", (new Item()).c("slimeball").setCreativeModeTab(CreativeModeTab.MISC));
		a(342, "chest_minecart", (new amp(MinecartType.CHEST)).c("minecartChest"));
		a(343, "furnace_minecart", (new amp(MinecartType.FURNACE)).c("minecartFurnace"));
		a(344, "egg", (new aky()).c("egg"));
		a(345, "compass", (new Item()).c("compass").setCreativeModeTab(CreativeModeTab.TOOLS));
		a(346, "fishing_rod", (new ItemFishingRod()).c("fishingRod"));
		a(347, "clock", (new Item()).c("clock").setCreativeModeTab(CreativeModeTab.TOOLS));
		a(348, "glowstone_dust", (new Item()).c("yellowDust").e(ans.j).setCreativeModeTab(CreativeModeTab.MATERIALS));
		a(349, "fish", (new alh(false)).c("fish").a(true));
		a(350, "cooked_fish", (new alh(true)).c("fish").a(true));
		a(351, "dye", (new akw()).c("dyePowder"));
		a(352, "bone", (new Item()).c("bone").n().setCreativeModeTab(CreativeModeTab.MISC));
		a(353, "sugar", (new Item()).c("sugar").e(ans.b).setCreativeModeTab(CreativeModeTab.MATERIALS));
		a(354, "cake", (new ajv(Blocks.ba)).c(1).c("cake").setCreativeModeTab(CreativeModeTab.FOOD));
		a(355, "bed", (new ajt()).c(1).c("bed"));
		a(356, "repeater", (new ajv(Blocks.bb)).c("diode").setCreativeModeTab(CreativeModeTab.REDSTONE));
		a(357, "cookie", (new all(2, 0.1F, false)).c("cookie"));
		a(358, "filled_map", (new amn()).c("map"));
		a(359, "shears", (new and()).c("shears"));
		a(360, "melon", (new all(2, 0.3F, false)).c("melon"));
		a(361, "pumpkin_seeds", (new anc(Blocks.bl, Blocks.ak)).c("seeds_pumpkin"));
		a(362, "melon_seeds", (new anc(Blocks.bm, Blocks.ak)).c("seeds_melon"));
		a(363, "beef", (new all(3, 0.3F, true)).c("beefRaw"));
		a(364, "cooked_beef", (new all(8, 0.8F, true)).c("beefCooked"));
		a(365, "chicken", (new all(2, 0.3F, true)).a(MobEffectList.s.H, 30, 0, 0.3F).c("chickenRaw"));
		a(366, "cooked_chicken", (new all(6, 0.6F, true)).c("chickenCooked"));
		a(367, "rotten_flesh", (new all(4, 0.1F, true)).a(MobEffectList.s.H, 30, 0, 0.8F).c("rottenFlesh"));
		a(368, "ender_pearl", (new alc()).c("enderPearl"));
		a(369, "blaze_rod", (new Item()).c("blazeRod").setCreativeModeTab(CreativeModeTab.MATERIALS).n());
		a(370, "ghast_tear", (new Item()).c("ghastTear").e(ans.c).setCreativeModeTab(CreativeModeTab.BREWING));
		a(371, "gold_nugget", (new Item()).c("goldNugget").setCreativeModeTab(CreativeModeTab.MATERIALS));
		a(372, "nether_wart", (new anc(Blocks.bB, Blocks.aW)).c("netherStalkSeeds").e("+4"));
		a(373, "potion", (new amw()).c("potion"));
		a(374, "glass_bottle", (new ajy()).c("glassBottle"));
		a(375, "spider_eye", (new all(2, 0.8F, false)).a(MobEffectList.u.H, 5, 0, 1.0F).c("spiderEye").e(ans.d));
		a(376, "fermented_spider_eye", (new Item()).c("fermentedSpiderEye").e(ans.e).setCreativeModeTab(CreativeModeTab.BREWING));
		a(377, "blaze_powder", (new Item()).c("blazePowder").e(ans.g).setCreativeModeTab(CreativeModeTab.BREWING));
		a(378, "magma_cream", (new Item()).c("magmaCream").e(ans.h).setCreativeModeTab(CreativeModeTab.BREWING));
		a(379, "brewing_stand", (new ajv(Blocks.bD)).c("brewingStand").setCreativeModeTab(CreativeModeTab.BREWING));
		a(380, "cauldron", (new ajv(Blocks.bE)).c("cauldron").setCreativeModeTab(CreativeModeTab.BREWING));
		a(381, "ender_eye", (new alb()).c("eyeOfEnder"));
		a(382, "speckled_melon", (new Item()).c("speckledMelon").e(ans.f).setCreativeModeTab(CreativeModeTab.BREWING));
		a(383, "spawn_egg", (new anl()).c("monsterPlacer"));
		a(384, "experience_bottle", (new ald()).c("expBottle"));
		a(385, "fire_charge", (new ale()).c("fireball"));
		a(386, "writable_book", (new anq()).c("writingBook").setCreativeModeTab(CreativeModeTab.MISC));
		a(387, "written_book", (new anr()).c("writtenBook").c(16));
		a(388, "emerald", (new Item()).c("emerald").setCreativeModeTab(CreativeModeTab.MATERIALS));
		a(389, "item_frame", (new aln(EntityItemFrame.class)).c("frame"));
		a(390, "flower_pot", (new ajv(Blocks.ca)).c("flowerPot").setCreativeModeTab(CreativeModeTab.DECORATIONS));
		a(391, "carrot", (new anb(3, 0.6F, Blocks.cb, Blocks.ak)).c("carrots"));
		a(392, "potato", (new anb(1, 0.3F, Blocks.cc, Blocks.ak)).c("potato"));
		a(393, "baked_potato", (new all(5, 0.6F, false)).c("potatoBaked"));
		a(394, "poisonous_potato", (new all(2, 0.3F, false)).a(MobEffectList.u.H, 5, 0, 0.6F).c("potatoPoisonous"));
		a(395, "map", (new akz()).c("emptyMap"));
		a(396, "golden_carrot", (new all(6, 1.2F, false)).c("carrotGolden").e(ans.l).setCreativeModeTab(CreativeModeTab.BREWING));
		a(397, "skull", (new anh()).c("skull"));
		a(398, "carrot_on_a_stick", (new akc()).c("carrotOnAStick"));
		a(399, "nether_star", (new ang()).c("netherStar").setCreativeModeTab(CreativeModeTab.MATERIALS));
		a(400, "pumpkin_pie", (new all(8, 0.3F, false)).c("pumpkinPie").setCreativeModeTab(CreativeModeTab.FOOD));
		a(401, "fireworks", (new alg()).c("fireworks"));
		a(402, "firework_charge", (new alf()).c("fireworksCharge").setCreativeModeTab(CreativeModeTab.MISC));
		a(403, "enchanted_book", (new ala()).c(1).c("enchantedBook"));
		a(404, "comparator", (new ajv(Blocks.cj)).c("comparator").setCreativeModeTab(CreativeModeTab.REDSTONE));
		a(405, "netherbrick", (new Item()).c("netherbrick").setCreativeModeTab(CreativeModeTab.MATERIALS));
		a(406, "quartz", (new Item()).c("netherquartz").setCreativeModeTab(CreativeModeTab.MATERIALS));
		a(407, "tnt_minecart", (new amp(MinecartType.TNT)).c("minecartTnt"));
		a(408, "hopper_minecart", (new amp(MinecartType.HOPPER)).c("minecartHopper"));
		a(409, "prismarine_shard", (new Item()).c("prismarineShard").setCreativeModeTab(CreativeModeTab.MATERIALS));
		a(410, "prismarine_crystals", (new Item()).c("prismarineCrystals").setCreativeModeTab(CreativeModeTab.MATERIALS));
		a(411, "rabbit", (new all(3, 0.3F, true)).c("rabbitRaw"));
		a(412, "cooked_rabbit", (new all(5, 0.6F, true)).c("rabbitCooked"));
		a(413, "rabbit_stew", (new aka(10)).c("rabbitStew"));
		a(414, "rabbit_foot", (new Item()).c("rabbitFoot").e(ans.n).setCreativeModeTab(CreativeModeTab.BREWING));
		a(415, "rabbit_hide", (new Item()).c("rabbitHide").setCreativeModeTab(CreativeModeTab.MATERIALS));
		a(416, "armor_stand", (new ajq()).c("armorStand").c(16));
		a(417, "iron_horse_armor", (new Item()).c("horsearmormetal").c(1).setCreativeModeTab(CreativeModeTab.MISC));
		a(418, "golden_horse_armor", (new Item()).c("horsearmorgold").c(1).setCreativeModeTab(CreativeModeTab.MISC));
		a(419, "diamond_horse_armor", (new Item()).c("horsearmordiamond").c(1).setCreativeModeTab(CreativeModeTab.MISC));
		a(420, "lead", (new aml()).c("leash"));
		a(421, "name_tag", (new amt()).c("nameTag"));
		a(422, "command_block_minecart", (new amp(MinecartType.COMMAND_BLOCK)).c("minecartCommandBlock").setCreativeModeTab((CreativeModeTab) null));
		a(423, "mutton", (new all(2, 0.3F, true)).c("muttonRaw"));
		a(424, "cooked_mutton", (new all(6, 0.8F, true)).c("muttonCooked"));
		a(425, "banner", (new ajs()).b("banner"));
		a(427, "spruce_door", (new akt(Blocks.ap)).c("doorSpruce"));
		a(428, "birch_door", (new akt(Blocks.aq)).c("doorBirch"));
		a(429, "jungle_door", (new akt(Blocks.ar)).c("doorJungle"));
		a(430, "acacia_door", (new akt(Blocks.as)).c("doorAcacia"));
		a(431, "dark_oak_door", (new akt(Blocks.at)).c("doorDarkOak"));
		a(2256, "record_13", (new amy("13")).c("record"));
		a(2257, "record_cat", (new amy("cat")).c("record"));
		a(2258, "record_blocks", (new amy("blocks")).c("record"));
		a(2259, "record_chirp", (new amy("chirp")).c("record"));
		a(2260, "record_far", (new amy("far")).c("record"));
		a(2261, "record_mall", (new amy("mall")).c("record"));
		a(2262, "record_mellohi", (new amy("mellohi")).c("record"));
		a(2263, "record_stal", (new amy("stal")).c("record"));
		a(2264, "record_strad", (new amy("strad")).c("record"));
		a(2265, "record_ward", (new amy("ward")).c("record"));
		a(2266, "record_11", (new amy("11")).c("record"));
		a(2267, "record_wait", (new amy("wait")).c("record"));
	}

	private static void c(Block var0) {
		a(var0, (Item) (new aju(var0)));
	}

	protected static void a(Block var0, Item var1) {
		a(Block.a(var0), (RegistryObjectName) Block.BLOCKREGISTRY.c(var0), var1);
		a.put(var0, var1);
	}

	private static void a(int var0, String var1, Item var2) {
		a(var0, new RegistryObjectName(var1), var2);
	}

	private static void a(int var0, RegistryObjectName var1, Item var2) {
		REGISTRY.register(var0, var1, var2);
	}

}

package net.minecraft;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

public class alq {

	public static final ev e = new ev();
	private static final Map a = Maps.newHashMap();
	protected static final UUID f = UUID.fromString("CB3F55D3-645C-4F38-A497-9C13A33DB5CF");
	private akf b;
	protected static Random g = new Random();
	protected int h = 64;
	private int c;
	protected boolean i;
	protected boolean j;
	private alq d;
	private String k;
	private String l;

	public static int b(alq var0) {
		return var0 == null ? 0 : e.b(var0);
	}

	public static alq b(int var0) {
		return (alq) e.a(var0);
	}

	public static alq a(atr var0) {
		return (alq) a.get(var0);
	}

	public static alq d(String var0) {
		alq var1 = (alq) e.a(new oa(var0));
		if (var1 == null) {
			try {
				return b(Integer.parseInt(var0));
			} catch (NumberFormatException var3) {
				;
			}
		}

		return var1;
	}

	public boolean a(NBTCompoundTag var1) {
		return false;
	}

	public alq c(int var1) {
		this.h = var1;
		return this;
	}

	public boolean a(amj var1, ahd var2, World var3, dt var4, ej var5, float var6, float var7, float var8) {
		return false;
	}

	public float a(amj var1, atr var2) {
		return 1.0F;
	}

	public amj a(amj var1, World var2, ahd var3) {
		return var1;
	}

	public amj b(amj var1, World var2, ahd var3) {
		return var1;
	}

	public int j() {
		return this.h;
	}

	public int a(int var1) {
		return 0;
	}

	public boolean k() {
		return this.j;
	}

	protected alq a(boolean var1) {
		this.j = var1;
		return this;
	}

	public int l() {
		return this.c;
	}

	protected alq d(int var1) {
		this.c = var1;
		return this;
	}

	public boolean m() {
		return this.c > 0 && !this.j;
	}

	public boolean a(amj var1, EntityLiving var2, EntityLiving var3) {
		return false;
	}

	public boolean a(amj var1, World var2, atr var3, dt var4, EntityLiving var5) {
		return false;
	}

	public boolean b(atr var1) {
		return false;
	}

	public boolean a(amj var1, ahd var2, EntityLiving var3) {
		return false;
	}

	public alq n() {
		this.i = true;
		return this;
	}

	public alq c(String var1) {
		this.l = var1;
		return this;
	}

	public String k(amj var1) {
		String var2 = this.e_(var1);
		return var2 == null ? "" : fi.a(var2);
	}

	public String a() {
		return "item." + this.l;
	}

	public String e_(amj var1) {
		return "item." + this.l;
	}

	public alq c(alq var1) {
		this.d = var1;
		return this;
	}

	public boolean p() {
		return true;
	}

	public alq q() {
		return this.d;
	}

	public boolean r() {
		return this.d != null;
	}

	public void a(amj var1, World var2, Entity var3, int var4, boolean var5) {
	}

	public void d(amj var1, World var2, ahd var3) {
	}

	public boolean f() {
		return false;
	}

	public ano e(amj var1) {
		return ano.a;
	}

	public int d(amj var1) {
		return 0;
	}

	public void a(amj var1, World var2, ahd var3, int var4) {
	}

	protected alq e(String var1) {
		this.k = var1;
		return this;
	}

	public String j(amj var1) {
		return this.k;
	}

	public boolean l(amj var1) {
		return this.j(var1) != null;
	}

	public String a(amj var1) {
		return ("" + fi.a(this.k(var1) + ".name")).trim();
	}

	public amx g(amj var1) {
		return var1.w() ? amx.c : amx.a;
	}

	public boolean f_(amj var1) {
		return this.j() == 1 && this.m();
	}

	protected bru a(World var1, ahd var2, boolean var3) {
		float var4 = var2.B + (var2.z - var2.B);
		float var5 = var2.A + (var2.y - var2.A);
		double var6 = var2.p + (var2.s - var2.p);
		double var8 = var2.q + (var2.t - var2.q) + (double) var2.aR();
		double var10 = var2.r + (var2.u - var2.r);
		brw var12 = new brw(var6, var8, var10);
		float var13 = NumberConverter.b(-var5 * 0.017453292F - 3.1415927F);
		float var14 = NumberConverter.a(-var5 * 0.017453292F - 3.1415927F);
		float var15 = -NumberConverter.b(-var4 * 0.017453292F);
		float var16 = NumberConverter.a(-var4 * 0.017453292F);
		float var17 = var14 * var15;
		float var19 = var13 * var15;
		double var20 = 5.0D;
		brw var22 = var12.b((double) var17 * var20, (double) var16 * var20, (double) var19 * var20);
		return var1.a(var12, var22, var3, !var3, false);
	}

	public int b() {
		return 0;
	}

	public alq a(akf var1) {
		this.b = var1;
		return this;
	}

	public boolean s() {
		return false;
	}

	public boolean a(amj var1, amj var2) {
		return false;
	}

	public Multimap i() {
		return HashMultimap.create();
	}

	public static void t() {
		a(aty.b, (alq) (new amr(aty.b, aty.b, new alr())).b("stone"));
		a((atr) aty.c, (alq) (new ann(aty.c, false)));
		a(aty.d, (alq) (new amr(aty.d, aty.d, new ama())).b("dirt"));
		c(aty.e);
		a(aty.f, (alq) (new amr(aty.f, aty.f, new amb())).b("wood"));
		a(aty.g, (alq) (new amr(aty.g, aty.g, new amc())).b("sapling"));
		c(aty.h);
		a((atr) aty.m, (alq) (new amr(aty.m, aty.m, new amd())).b("sand"));
		c(aty.n);
		c(aty.o);
		c(aty.p);
		c(aty.q);
		a(aty.r, (alq) (new amr(aty.r, aty.r, new ame())).b("log"));
		a(aty.s, (alq) (new amr(aty.s, aty.s, new amf())).b("log"));
		a((atr) aty.t, (alq) (new amm(aty.t)).b("leaves"));
		a((atr) aty.u, (alq) (new amm(aty.u)).b("leaves"));
		a(aty.v, (alq) (new amr(aty.v, aty.v, new amg())).b("sponge"));
		c(aty.w);
		c(aty.x);
		c(aty.y);
		c(aty.z);
		a(aty.A, (alq) (new amr(aty.A, aty.A, new amh())).b("sandStone"));
		c(aty.B);
		c(aty.D);
		c(aty.E);
		a((atr) aty.F, (alq) (new amv(aty.F)));
		c(aty.G);
		a((atr) aty.H, (alq) (new ann(aty.H, true)).a(new String[] { "shrub", "grass", "fern" }));
		c((atr) aty.I);
		a((atr) aty.J, (alq) (new amv(aty.J)));
		a(aty.L, (alq) (new akx(aty.L)).b("cloth"));
		a((atr) aty.N, (alq) (new amr(aty.N, aty.N, new als())).b("flower"));
		a((atr) aty.O, (alq) (new amr(aty.O, aty.O, new alt())).b("rose"));
		c((atr) aty.P);
		c((atr) aty.Q);
		c(aty.R);
		c(aty.S);
		a((atr) aty.U, (alq) (new ani(aty.U, aty.U, aty.T)).b("stoneSlab"));
		c(aty.V);
		c(aty.W);
		c(aty.X);
		c(aty.Y);
		c(aty.Z);
		c(aty.aa);
		c(aty.ac);
		c(aty.ad);
		c((atr) aty.ae);
		c(aty.ag);
		c(aty.ah);
		c(aty.ai);
		c(aty.ak);
		c(aty.al);
		c(aty.am);
		c(aty.au);
		c(aty.av);
		c(aty.aw);
		c(aty.ay);
		c(aty.az);
		c(aty.aB);
		c(aty.aC);
		c(aty.aF);
		c(aty.aG);
		a(aty.aH, (alq) (new anj(aty.aH)));
		c(aty.aI);
		c(aty.aJ);
		c((atr) aty.aK);
		c(aty.aL);
		c(aty.aN);
		c(aty.aO);
		c(aty.aP);
		c(aty.aQ);
		c(aty.aR);
		c(aty.aS);
		c(aty.aT);
		c(aty.aU);
		c(aty.aV);
		c(aty.aW);
		c(aty.aX);
		c(aty.aZ);
		c(aty.bd);
		a(aty.be, (alq) (new amr(aty.be, aty.be, new alu())).b("monsterStoneEgg"));
		a(aty.bf, (alq) (new amr(aty.bf, aty.bf, new alv())).b("stonebricksmooth"));
		c(aty.bg);
		c(aty.bh);
		c(aty.bi);
		c(aty.bj);
		c(aty.bk);
		a(aty.bn, (alq) (new ann(aty.bn, false)));
		c(aty.bo);
		c(aty.bp);
		c(aty.bq);
		c(aty.br);
		c(aty.bs);
		c(aty.bt);
		c(aty.bu);
		c(aty.bv);
		c((atr) aty.bw);
		a(aty.bx, (alq) (new anp(aty.bx)));
		c(aty.by);
		c(aty.bz);
		c(aty.bA);
		c(aty.bC);
		c(aty.bG);
		c(aty.bH);
		c(aty.bI);
		c(aty.bJ);
		a((atr) aty.bM, (alq) (new ani(aty.bM, aty.bM, aty.bL)).b("woodSlab"));
		c(aty.bO);
		c(aty.bP);
		c(aty.bQ);
		c((atr) aty.bR);
		c(aty.bT);
		c(aty.bU);
		c(aty.bV);
		c(aty.bW);
		c(aty.bX);
		c((atr) aty.bY);
		a(aty.bZ, (alq) (new amr(aty.bZ, aty.bZ, new alw())).b("cobbleWall"));
		c(aty.cd);
		a(aty.cf, (alq) (new ajm(aty.cf)).b("anvil"));
		c(aty.cg);
		c(aty.ch);
		c(aty.ci);
		c((atr) aty.cl);
		c(aty.cn);
		c(aty.co);
		c((atr) aty.cp);
		a(aty.cq, (alq) (new amr(aty.cq, aty.cq, new String[] { "default", "chiseled", "lines" })).b("quartzBlock"));
		c(aty.cr);
		c(aty.cs);
		c(aty.ct);
		a(aty.cu, (alq) (new akx(aty.cu)).b("clayHardenedStained"));
		c(aty.cv);
		c(aty.cw);
		c(aty.cx);
		a(aty.cy, (alq) (new akx(aty.cy)).b("woolCarpet"));
		c(aty.cz);
		c(aty.cA);
		c(aty.cB);
		c(aty.cC);
		c(aty.cD);
		c(aty.cE);
		a((atr) aty.cF, (alq) (new aku(aty.cF, aty.cF, new alx())).b("doublePlant"));
		a((atr) aty.cG, (alq) (new akx(aty.cG)).b("stainedGlass"));
		a((atr) aty.cH, (alq) (new akx(aty.cH)).b("stainedGlassPane"));
		a(aty.cI, (alq) (new amr(aty.cI, aty.cI, new aly())).b("prismarine"));
		c(aty.cJ);
		a(aty.cM, (alq) (new amr(aty.cM, aty.cM, new alz())).b("redSandStone"));
		c(aty.cN);
		a((atr) aty.cP, (alq) (new ani(aty.cP, aty.cP, aty.cO)).b("stoneSlab2"));
		a(256, "iron_shovel", (new ane(ami.c)).c("shovelIron"));
		a(257, "iron_pickaxe", (new amu(ami.c)).c("pickaxeIron"));
		a(258, "iron_axe", (new ajr(ami.c)).c("hatchetIron"));
		a(259, "flint_and_steel", (new alk()).c("flintAndSteel"));
		a(260, "apple", (new all(4, 0.3F, false)).c("apple"));
		a(261, "bow", (new ajz()).c("bow"));
		a(262, "arrow", (new alq()).c("arrow").a(akf.j));
		a(263, "coal", (new akd()).c("coal"));
		a(264, "diamond", (new alq()).c("diamond").a(akf.l));
		a(265, "iron_ingot", (new alq()).c("ingotIron").a(akf.l));
		a(266, "gold_ingot", (new alq()).c("ingotGold").a(akf.l));
		a(267, "iron_sword", (new anm(ami.c)).c("swordIron"));
		a(268, "wooden_sword", (new anm(ami.a)).c("swordWood"));
		a(269, "wooden_shovel", (new ane(ami.a)).c("shovelWood"));
		a(270, "wooden_pickaxe", (new amu(ami.a)).c("pickaxeWood"));
		a(271, "wooden_axe", (new ajr(ami.a)).c("hatchetWood"));
		a(272, "stone_sword", (new anm(ami.b)).c("swordStone"));
		a(273, "stone_shovel", (new ane(ami.b)).c("shovelStone"));
		a(274, "stone_pickaxe", (new amu(ami.b)).c("pickaxeStone"));
		a(275, "stone_axe", (new ajr(ami.b)).c("hatchetStone"));
		a(276, "diamond_sword", (new anm(ami.d)).c("swordDiamond"));
		a(277, "diamond_shovel", (new ane(ami.d)).c("shovelDiamond"));
		a(278, "diamond_pickaxe", (new amu(ami.d)).c("pickaxeDiamond"));
		a(279, "diamond_axe", (new ajr(ami.d)).c("hatchetDiamond"));
		a(280, "stick", (new alq()).n().c("stick").a(akf.l));
		a(281, "bowl", (new alq()).c("bowl").a(akf.l));
		a(282, "mushroom_stew", (new aka(6)).c("mushroomStew"));
		a(283, "golden_sword", (new anm(ami.e)).c("swordGold"));
		a(284, "golden_shovel", (new ane(ami.e)).c("shovelGold"));
		a(285, "golden_pickaxe", (new amu(ami.e)).c("pickaxeGold"));
		a(286, "golden_axe", (new ajr(ami.e)).c("hatchetGold"));
		a(287, "string", (new ajv(aty.bS)).c("string").a(akf.l));
		a(288, "feather", (new alq()).c("feather").a(akf.l));
		a(289, "gunpowder", (new alq()).c("sulphur").e(ans.k).a(akf.l));
		a(290, "wooden_hoe", (new alo(ami.a)).c("hoeWood"));
		a(291, "stone_hoe", (new alo(ami.b)).c("hoeStone"));
		a(292, "iron_hoe", (new alo(ami.c)).c("hoeIron"));
		a(293, "diamond_hoe", (new alo(ami.d)).c("hoeDiamond"));
		a(294, "golden_hoe", (new alo(ami.e)).c("hoeGold"));
		a(295, "wheat_seeds", (new anc(aty.aj, aty.ak)).c("seeds"));
		a(296, "wheat", (new alq()).c("wheat").a(akf.l));
		a(297, "bread", (new all(5, 0.6F, false)).c("bread"));
		a(298, "leather_helmet", (new ajn(ajp.a, 0, 0)).c("helmetCloth"));
		a(299, "leather_chestplate", (new ajn(ajp.a, 0, 1)).c("chestplateCloth"));
		a(300, "leather_leggings", (new ajn(ajp.a, 0, 2)).c("leggingsCloth"));
		a(301, "leather_boots", (new ajn(ajp.a, 0, 3)).c("bootsCloth"));
		a(302, "chainmail_helmet", (new ajn(ajp.b, 1, 0)).c("helmetChain"));
		a(303, "chainmail_chestplate", (new ajn(ajp.b, 1, 1)).c("chestplateChain"));
		a(304, "chainmail_leggings", (new ajn(ajp.b, 1, 2)).c("leggingsChain"));
		a(305, "chainmail_boots", (new ajn(ajp.b, 1, 3)).c("bootsChain"));
		a(306, "iron_helmet", (new ajn(ajp.c, 2, 0)).c("helmetIron"));
		a(307, "iron_chestplate", (new ajn(ajp.c, 2, 1)).c("chestplateIron"));
		a(308, "iron_leggings", (new ajn(ajp.c, 2, 2)).c("leggingsIron"));
		a(309, "iron_boots", (new ajn(ajp.c, 2, 3)).c("bootsIron"));
		a(310, "diamond_helmet", (new ajn(ajp.e, 3, 0)).c("helmetDiamond"));
		a(311, "diamond_chestplate", (new ajn(ajp.e, 3, 1)).c("chestplateDiamond"));
		a(312, "diamond_leggings", (new ajn(ajp.e, 3, 2)).c("leggingsDiamond"));
		a(313, "diamond_boots", (new ajn(ajp.e, 3, 3)).c("bootsDiamond"));
		a(314, "golden_helmet", (new ajn(ajp.d, 4, 0)).c("helmetGold"));
		a(315, "golden_chestplate", (new ajn(ajp.d, 4, 1)).c("chestplateGold"));
		a(316, "golden_leggings", (new ajn(ajp.d, 4, 2)).c("leggingsGold"));
		a(317, "golden_boots", (new ajn(ajp.d, 4, 3)).c("bootsGold"));
		a(318, "flint", (new alq()).c("flint").a(akf.l));
		a(319, "porkchop", (new all(3, 0.3F, true)).c("porkchopRaw"));
		a(320, "cooked_porkchop", (new all(8, 0.8F, true)).c("porkchopCooked"));
		a(321, "painting", (new aln(adm.class)).c("painting"));
		a(322, "golden_apple", (new alm(4, 1.2F, false)).h().a(wp.l.H, 5, 1, 1.0F).c("appleGold"));
		a(323, "sign", (new anf()).c("sign"));
		a(324, "wooden_door", (new akt(aty.ao)).c("doorOak"));
		alq var0 = (new akb(aty.a)).c("bucket").c(16);
		a(325, "bucket", var0);
		a(326, "water_bucket", (new akb(aty.i)).c("bucketWater").c(var0));
		a(327, "lava_bucket", (new akb(aty.k)).c("bucketLava").c(var0));
		a(328, "minecart", (new amp(adz.a)).c("minecart"));
		a(329, "saddle", (new ana()).c("saddle"));
		a(330, "iron_door", (new akt(aty.aA)).c("doorIron"));
		a(331, "redstone", (new amz()).c("redstone").e(ans.i));
		a(332, "snowball", (new ank()).c("snowball"));
		a(333, "boat", (new ajw()).c("boat"));
		a(334, "leather", (new alq()).c("leather").a(akf.l));
		a(335, "milk_bucket", (new amo()).c("milk").c(var0));
		a(336, "brick", (new alq()).c("brick").a(akf.l));
		a(337, "clay_ball", (new alq()).c("clay").a(akf.l));
		a(338, "reeds", (new ajv(aty.aM)).c("reeds").a(akf.l));
		a(339, "paper", (new alq()).c("paper").a(akf.f));
		a(340, "book", (new ajx()).c("book").a(akf.f));
		a(341, "slime_ball", (new alq()).c("slimeball").a(akf.f));
		a(342, "chest_minecart", (new amp(adz.b)).c("minecartChest"));
		a(343, "furnace_minecart", (new amp(adz.c)).c("minecartFurnace"));
		a(344, "egg", (new aky()).c("egg"));
		a(345, "compass", (new alq()).c("compass").a(akf.i));
		a(346, "fishing_rod", (new alj()).c("fishingRod"));
		a(347, "clock", (new alq()).c("clock").a(akf.i));
		a(348, "glowstone_dust", (new alq()).c("yellowDust").e(ans.j).a(akf.l));
		a(349, "fish", (new alh(false)).c("fish").a(true));
		a(350, "cooked_fish", (new alh(true)).c("fish").a(true));
		a(351, "dye", (new akw()).c("dyePowder"));
		a(352, "bone", (new alq()).c("bone").n().a(akf.f));
		a(353, "sugar", (new alq()).c("sugar").e(ans.b).a(akf.l));
		a(354, "cake", (new ajv(aty.ba)).c(1).c("cake").a(akf.h));
		a(355, "bed", (new ajt()).c(1).c("bed"));
		a(356, "repeater", (new ajv(aty.bb)).c("diode").a(akf.d));
		a(357, "cookie", (new all(2, 0.1F, false)).c("cookie"));
		a(358, "filled_map", (new amn()).c("map"));
		a(359, "shears", (new and()).c("shears"));
		a(360, "melon", (new all(2, 0.3F, false)).c("melon"));
		a(361, "pumpkin_seeds", (new anc(aty.bl, aty.ak)).c("seeds_pumpkin"));
		a(362, "melon_seeds", (new anc(aty.bm, aty.ak)).c("seeds_melon"));
		a(363, "beef", (new all(3, 0.3F, true)).c("beefRaw"));
		a(364, "cooked_beef", (new all(8, 0.8F, true)).c("beefCooked"));
		a(365, "chicken", (new all(2, 0.3F, true)).a(wp.s.H, 30, 0, 0.3F).c("chickenRaw"));
		a(366, "cooked_chicken", (new all(6, 0.6F, true)).c("chickenCooked"));
		a(367, "rotten_flesh", (new all(4, 0.1F, true)).a(wp.s.H, 30, 0, 0.8F).c("rottenFlesh"));
		a(368, "ender_pearl", (new alc()).c("enderPearl"));
		a(369, "blaze_rod", (new alq()).c("blazeRod").a(akf.l).n());
		a(370, "ghast_tear", (new alq()).c("ghastTear").e(ans.c).a(akf.k));
		a(371, "gold_nugget", (new alq()).c("goldNugget").a(akf.l));
		a(372, "nether_wart", (new anc(aty.bB, aty.aW)).c("netherStalkSeeds").e("+4"));
		a(373, "potion", (new amw()).c("potion"));
		a(374, "glass_bottle", (new ajy()).c("glassBottle"));
		a(375, "spider_eye", (new all(2, 0.8F, false)).a(wp.u.H, 5, 0, 1.0F).c("spiderEye").e(ans.d));
		a(376, "fermented_spider_eye", (new alq()).c("fermentedSpiderEye").e(ans.e).a(akf.k));
		a(377, "blaze_powder", (new alq()).c("blazePowder").e(ans.g).a(akf.k));
		a(378, "magma_cream", (new alq()).c("magmaCream").e(ans.h).a(akf.k));
		a(379, "brewing_stand", (new ajv(aty.bD)).c("brewingStand").a(akf.k));
		a(380, "cauldron", (new ajv(aty.bE)).c("cauldron").a(akf.k));
		a(381, "ender_eye", (new alb()).c("eyeOfEnder"));
		a(382, "speckled_melon", (new alq()).c("speckledMelon").e(ans.f).a(akf.k));
		a(383, "spawn_egg", (new anl()).c("monsterPlacer"));
		a(384, "experience_bottle", (new ald()).c("expBottle"));
		a(385, "fire_charge", (new ale()).c("fireball"));
		a(386, "writable_book", (new anq()).c("writingBook").a(akf.f));
		a(387, "written_book", (new anr()).c("writtenBook").c(16));
		a(388, "emerald", (new alq()).c("emerald").a(akf.l));
		a(389, "item_frame", (new aln(adk.class)).c("frame"));
		a(390, "flower_pot", (new ajv(aty.ca)).c("flowerPot").a(akf.c));
		a(391, "carrot", (new anb(3, 0.6F, aty.cb, aty.ak)).c("carrots"));
		a(392, "potato", (new anb(1, 0.3F, aty.cc, aty.ak)).c("potato"));
		a(393, "baked_potato", (new all(5, 0.6F, false)).c("potatoBaked"));
		a(394, "poisonous_potato", (new all(2, 0.3F, false)).a(wp.u.H, 5, 0, 0.6F).c("potatoPoisonous"));
		a(395, "map", (new akz()).c("emptyMap"));
		a(396, "golden_carrot", (new all(6, 1.2F, false)).c("carrotGolden").e(ans.l).a(akf.k));
		a(397, "skull", (new anh()).c("skull"));
		a(398, "carrot_on_a_stick", (new akc()).c("carrotOnAStick"));
		a(399, "nether_star", (new ang()).c("netherStar").a(akf.l));
		a(400, "pumpkin_pie", (new all(8, 0.3F, false)).c("pumpkinPie").a(akf.h));
		a(401, "fireworks", (new alg()).c("fireworks"));
		a(402, "firework_charge", (new alf()).c("fireworksCharge").a(akf.f));
		a(403, "enchanted_book", (new ala()).c(1).c("enchantedBook"));
		a(404, "comparator", (new ajv(aty.cj)).c("comparator").a(akf.d));
		a(405, "netherbrick", (new alq()).c("netherbrick").a(akf.l));
		a(406, "quartz", (new alq()).c("netherquartz").a(akf.l));
		a(407, "tnt_minecart", (new amp(adz.d)).c("minecartTnt"));
		a(408, "hopper_minecart", (new amp(adz.f)).c("minecartHopper"));
		a(409, "prismarine_shard", (new alq()).c("prismarineShard").a(akf.l));
		a(410, "prismarine_crystals", (new alq()).c("prismarineCrystals").a(akf.l));
		a(411, "rabbit", (new all(3, 0.3F, true)).c("rabbitRaw"));
		a(412, "cooked_rabbit", (new all(5, 0.6F, true)).c("rabbitCooked"));
		a(413, "rabbit_stew", (new aka(10)).c("rabbitStew"));
		a(414, "rabbit_foot", (new alq()).c("rabbitFoot").e(ans.n).a(akf.k));
		a(415, "rabbit_hide", (new alq()).c("rabbitHide").a(akf.l));
		a(416, "armor_stand", (new ajq()).c("armorStand").c(16));
		a(417, "iron_horse_armor", (new alq()).c("horsearmormetal").c(1).a(akf.f));
		a(418, "golden_horse_armor", (new alq()).c("horsearmorgold").c(1).a(akf.f));
		a(419, "diamond_horse_armor", (new alq()).c("horsearmordiamond").c(1).a(akf.f));
		a(420, "lead", (new aml()).c("leash"));
		a(421, "name_tag", (new amt()).c("nameTag"));
		a(422, "command_block_minecart", (new amp(adz.g)).c("minecartCommandBlock").a((akf) null));
		a(423, "mutton", (new all(2, 0.3F, true)).c("muttonRaw"));
		a(424, "cooked_mutton", (new all(6, 0.8F, true)).c("muttonCooked"));
		a(425, "banner", (new ajs()).b("banner"));
		a(427, "spruce_door", (new akt(aty.ap)).c("doorSpruce"));
		a(428, "birch_door", (new akt(aty.aq)).c("doorBirch"));
		a(429, "jungle_door", (new akt(aty.ar)).c("doorJungle"));
		a(430, "acacia_door", (new akt(aty.as)).c("doorAcacia"));
		a(431, "dark_oak_door", (new akt(aty.at)).c("doorDarkOak"));
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

	private static void c(atr var0) {
		a(var0, (alq) (new aju(var0)));
	}

	protected static void a(atr var0, alq var1) {
		a(atr.a(var0), (oa) atr.c.c(var0), var1);
		a.put(var0, var1);
	}

	private static void a(int var0, String var1, alq var2) {
		a(var0, new oa(var1), var2);
	}

	private static void a(int var0, oa var1, alq var2) {
		e.a(var0, var1, var2);
	}

}

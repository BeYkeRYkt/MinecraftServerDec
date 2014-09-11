package net.minecraft;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class BiomeBase {

	private static final Logger aD = LogManager.getLogger();
	protected static final BiomeTemperature a = new BiomeTemperature(0.1F, 0.2F);
	protected static final BiomeTemperature b = new BiomeTemperature(-0.5F, 0.0F);
	protected static final BiomeTemperature c = new BiomeTemperature(-1.0F, 0.1F);
	protected static final BiomeTemperature d = new BiomeTemperature(-1.8F, 0.1F);
	protected static final BiomeTemperature e = new BiomeTemperature(0.125F, 0.05F);
	protected static final BiomeTemperature f = new BiomeTemperature(0.2F, 0.2F);
	protected static final BiomeTemperature g = new BiomeTemperature(0.45F, 0.3F);
	protected static final BiomeTemperature h = new BiomeTemperature(1.5F, 0.025F);
	protected static final BiomeTemperature i = new BiomeTemperature(1.0F, 0.5F);
	protected static final BiomeTemperature j = new BiomeTemperature(0.0F, 0.025F);
	protected static final BiomeTemperature k = new BiomeTemperature(0.1F, 0.8F);
	protected static final BiomeTemperature l = new BiomeTemperature(0.2F, 0.3F);
	protected static final BiomeTemperature m = new BiomeTemperature(-0.2F, 0.1F);
	private static final BiomeBase[] aE = new BiomeBase[256];
	public static final Set n = Sets.newHashSet();
	public static final Map o = Maps.newHashMap();
	public static final BiomeBase OCEAN = (new BiomeOcean(0)).b(112).a("Ocean").a(c);
	public static final BiomeBase PLAINS = (new BiomePlains(1)).b(9286496).a("Plains");
	public static final BiomeBase DESERT = (new BiomeDesert(2)).b(16421912).a("Desert").b().a(2.0F, 0.0F).a(e);
	public static final BiomeBase EXTREME_HILLS = (new BiomeBigHills(3, false)).b(6316128).a("Extreme Hills").a(i).a(0.2F, 0.3F);
	public static final BiomeBase FOREST = (new BiomeForest(4, 0)).b(353825).a("Forest");
	public static final BiomeBase TAIGA = (new BiomeTaiga(5, 0)).b(747097).a("Taiga").a(5159473).a(0.25F, 0.8F).a(f);
	public static final BiomeBase SWAMPLAND = (new BiomeSwamp(6)).b(522674).a("Swampland").a(9154376).a(m).a(0.8F, 0.9F);
	public static final BiomeBase RIVER = (new BiomeRiver(7)).b(255).a("River").a(b);
	public static final BiomeBase HELL = (new BiomeHell(8)).b(16711680).a("Hell").b().a(2.0F, 0.0F);
	public static final BiomeBase SKY = (new BiomeTheEnd(9)).b(8421631).a("The End").b();
	public static final BiomeBase FROZEN_OCEAN = (new BiomeOcean(10)).b(9474208).a("FrozenOcean").c().a(c).a(0.0F, 0.5F);
	public static final BiomeBase FROZEN_RIVER = (new BiomeRiver(11)).b(10526975).a("FrozenRiver").c().a(b).a(0.0F, 0.5F);
	public static final BiomeBase ICE_PLAINS = (new BiomeIcePlains(12, false)).b(16777215).a("Ice Plains").c().a(0.0F, 0.5F).a(e);
	public static final BiomeBase ICE_MOUNTAINS = (new BiomeIcePlains(13, false)).b(10526880).a("Ice Mountains").c().a(g).a(0.0F, 0.5F);
	public static final BiomeBase MUSHROOM_ISLAND = (new BiomeMushrooms(14)).b(16711935).a("MushroomIsland").a(0.9F, 1.0F).a(l);
	public static final BiomeBase MUSHROOM_SHORE = (new BiomeMushrooms(15)).b(10486015).a("MushroomIslandShore").a(0.9F, 1.0F).a(j);
	public static final BiomeBase BEACH = (new BiomeBeach(16)).b(16440917).a("Beach").a(0.8F, 0.4F).a(j);
	public static final BiomeBase DESERT_HILLS = (new BiomeDesert(17)).b(13786898).a("DesertHills").b().a(2.0F, 0.0F).a(g);
	public static final BiomeBase FOREST_HILLS = (new BiomeForest(18, 0)).b(2250012).a("ForestHills").a(g);
	public static final BiomeBase TAIGA_HILLS = (new BiomeTaiga(19, 0)).b(1456435).a("TaigaHills").a(5159473).a(0.25F, 0.8F).a(g);
	public static final BiomeBase SMALL_MOUNTAINS = (new BiomeBigHills(20, true)).b(7501978).a("Extreme Hills Edge").a(i.a()).a(0.2F, 0.3F);
	public static final BiomeBase JUNGLE = (new BiomeJungle(21, false)).b(5470985).a("Jungle").a(5470985).a(0.95F, 0.9F);
	public static final BiomeBase JUNGLE_HILLS = (new BiomeJungle(22, false)).b(2900485).a("JungleHills").a(5470985).a(0.95F, 0.9F).a(g);
	public static final BiomeBase JUNGLE_EDGE = (new BiomeJungle(23, true)).b(6458135).a("JungleEdge").a(5470985).a(0.95F, 0.8F);
	public static final BiomeBase DEEP_OCEAN = (new BiomeOcean(24)).b(48).a("Deep Ocean").a(d);
	public static final BiomeBase STONE_BEACH = (new BiomeStoneBeach(25)).b(10658436).a("Stone Beach").a(0.2F, 0.3F).a(k);
	public static final BiomeBase COLD_BEACH = (new BiomeBeach(26)).b(16445632).a("Cold Beach").a(0.05F, 0.3F).a(j).c();
	public static final BiomeBase BIRCH_FOREST = (new BiomeForest(27, 2)).a("Birch Forest").b(3175492);
	public static final BiomeBase BIRCH_FOREST_HILLS = (new BiomeForest(28, 2)).a("Birch Forest Hills").b(2055986).a(g);
	public static final BiomeBase ROOFED_FOREST = (new BiomeForest(29, 3)).b(4215066).a("Roofed Forest");
	public static final BiomeBase COLD_TAIGA = (new BiomeTaiga(30, 0)).b(3233098).a("Cold Taiga").a(5159473).c().a(-0.5F, 0.4F).a(f).c(16777215);
	public static final BiomeBase COLD_TAIGA_HILLS = (new BiomeTaiga(31, 0)).b(2375478).a("Cold Taiga Hills").a(5159473).c().a(-0.5F, 0.4F).a(g).c(16777215);
	public static final BiomeBase MEGA_TAIGA = (new BiomeTaiga(32, 1)).b(5858897).a("Mega Taiga").a(5159473).a(0.3F, 0.8F).a(f);
	public static final BiomeBase MEGA_TAIGA_HILLS = (new BiomeTaiga(33, 1)).b(4542270).a("Mega Taiga Hills").a(5159473).a(0.3F, 0.8F).a(g);
	public static final BiomeBase EXTREME_HILLS_PLUS = (new BiomeBigHills(34, true)).b(5271632).a("Extreme Hills+").a(i).a(0.2F, 0.3F);
	public static final BiomeBase SAVANNA = (new BiomeSavanna(35)).b(12431967).a("Savanna").a(1.2F, 0.0F).b().a(e);
	public static final BiomeBase SAVANNA_PLATEAU = (new BiomeSavanna(36)).b(10984804).a("Savanna Plateau").a(1.0F, 0.0F).b().a(h);
	public static final BiomeBase MESA = (new BiomeMesa(37, false, false)).b(14238997).a("Mesa");
	public static final BiomeBase MESA_PLATEAU_F = (new BiomeMesa(38, false, true)).b(11573093).a("Mesa Plateau F").a(h);
	public static final BiomeBase MESA_PLATEAU = (new BiomeMesa(39, false, false)).b(13274213).a("Mesa Plateau").a(h);
	protected static final NoiseGenerator3 ae;
	protected static final NoiseGenerator3 af;
	protected static final WorldGenTallPlant ag;
	public String ah;
	public int ai;
	public int aj;
	public BlockState ak;
	public BlockState al;
	public int am;
	public float an;
	public float ao;
	public float ap;
	public float aq;
	public int ar;
	public BiomeDecorator as;
	protected List<BiomeMeta> at;
	protected List<BiomeMeta> au;
	protected List<BiomeMeta> av;
	protected List<BiomeMeta> aw;
	protected boolean ax;
	protected boolean ay;
	public final int az;
	protected WorldGenTrees aA;
	protected WorldGenBigTree aB;
	protected WorldGenSwampTree aC;

	protected BiomeBase(int var1) {
		this.ak = Blocks.GRASS.getBlockState();
		this.al = Blocks.DIRT.getBlockState();
		this.am = 5169201;
		this.an = a.a;
		this.ao = a.b;
		this.ap = 0.5F;
		this.aq = 0.5F;
		this.ar = 16777215;
		this.at = Lists.newArrayList();
		this.au = Lists.newArrayList();
		this.av = Lists.newArrayList();
		this.aw = Lists.newArrayList();
		this.ay = true;
		this.aA = new WorldGenTrees(false);
		this.aB = new WorldGenBigTree(false);
		this.aC = new WorldGenSwampTree();
		this.az = var1;
		aE[var1] = this;
		this.as = this.a();
		this.au.add(new BiomeMeta(EntitySheep.class, 12, 4, 4));
		this.au.add(new BiomeMeta(EntityRabbit.class, 10, 3, 3));
		this.au.add(new BiomeMeta(EntityPig.class, 10, 4, 4));
		this.au.add(new BiomeMeta(EntityChicken.class, 10, 4, 4));
		this.au.add(new BiomeMeta(EntityCow.class, 8, 4, 4));
		this.at.add(new BiomeMeta(EntitySpider.class, 100, 4, 4));
		this.at.add(new BiomeMeta(EntityZombie.class, 100, 4, 4));
		this.at.add(new BiomeMeta(EntitySkeleton.class, 100, 4, 4));
		this.at.add(new BiomeMeta(EntityCreeper.class, 100, 4, 4));
		this.at.add(new BiomeMeta(EntitySlime.class, 100, 4, 4));
		this.at.add(new BiomeMeta(EntityEnderman.class, 10, 1, 4));
		this.at.add(new BiomeMeta(EntityWitch.class, 5, 1, 1));
		this.av.add(new BiomeMeta(EntitySquid.class, 10, 4, 4));
		this.aw.add(new BiomeMeta(EntityBat.class, 10, 8, 8));
	}

	protected BiomeDecorator a() {
		return new BiomeDecorator();
	}

	protected BiomeBase a(float var1, float var2) {
		if (var1 > 0.1F && var1 < 0.2F) {
			throw new IllegalArgumentException("Please avoid temperatures in the range 0.1 - 0.2 because of snow");
		} else {
			this.ap = var1;
			this.aq = var2;
			return this;
		}
	}

	protected final BiomeBase a(BiomeTemperature var1) {
		this.an = var1.a;
		this.ao = var1.b;
		return this;
	}

	protected BiomeBase b() {
		this.ay = false;
		return this;
	}

	public WorldGenTreeAbstract a(Random var1) {
		return (WorldGenTreeAbstract) (var1.nextInt(10) == 0 ? this.aB : this.aA);
	}

	public WorldGenerator b(Random var1) {
		return new WorldGenGrass(EnumGrassType.b);
	}

	public EnumFlowerType a(Random var1, Position var2) {
		return var1.nextInt(3) > 0 ? EnumFlowerType.a : EnumFlowerType.b;
	}

	protected BiomeBase c() {
		this.ax = true;
		return this;
	}

	protected BiomeBase a(String var1) {
		this.ah = var1;
		return this;
	}

	protected BiomeBase a(int var1) {
		this.am = var1;
		return this;
	}

	protected BiomeBase b(int var1) {
		this.a(var1, false);
		return this;
	}

	protected BiomeBase c(int var1) {
		this.aj = var1;
		return this;
	}

	protected BiomeBase a(int var1, boolean var2) {
		this.ai = var1;
		if (var2) {
			this.aj = (var1 & 16711422) >> 1;
		} else {
			this.aj = var1;
		}

		return this;
	}

	public List a(EnumCreatureType var1) {
		switch (arn.a[var1.ordinal()]) {
			case 1:
				return this.at;
			case 2:
				return this.au;
			case 3:
				return this.av;
			case 4:
				return this.aw;
			default:
				return Collections.emptyList();
		}
	}

	public boolean d() {
		return this.j();
	}

	public boolean e() {
		return this.j() ? false : this.ay;
	}

	public boolean f() {
		return this.aq > 0.85F;
	}

	public float g() {
		return 0.1F;
	}

	public final int h() {
		return (int) (this.aq * 65536.0F);
	}

	public final float a(Position var1) {
		if (var1.getY() > 64) {
			float var2 = (float) (ae.a((double) var1.getX() * 1.0D / 8.0D, (double) var1.getZ() * 1.0D / 8.0D) * 4.0D);
			return this.ap - (var2 + (float) var1.getY() - 64.0F) * 0.05F / 30.0F;
		} else {
			return this.ap;
		}
	}

	public void a(World var1, Random var2, Position var3) {
		this.as.a(var1, var2, this, var3);
	}

	public boolean j() {
		return this.ax;
	}

	public void a(World var1, Random var2, bgk var3, int var4, int var5, double var6) {
		this.b(var1, var2, var3, var4, var5, var6);
	}

	public final void b(World var1, Random var2, bgk var3, int var4, int var5, double var6) {
		boolean var8 = true;
		BlockState var9 = this.ak;
		BlockState var10 = this.al;
		int var11 = -1;
		int var12 = (int) (var6 / 3.0D + 3.0D + var2.nextDouble() * 0.25D);
		int var13 = var4 & 15;
		int var14 = var5 & 15;

		for (int var15 = 255; var15 >= 0; --var15) {
			if (var15 <= var2.nextInt(5)) {
				var3.a(var14, var15, var13, Blocks.BEDROCK.getBlockState());
			} else {
				BlockState var16 = var3.a(var14, var15, var13);
				if (var16.getBlock().getMaterial() == Material.AIR) {
					var11 = -1;
				} else if (var16.getBlock() == Blocks.STONE) {
					if (var11 == -1) {
						if (var12 <= 0) {
							var9 = null;
							var10 = Blocks.STONE.getBlockState();
						} else if (var15 >= 59 && var15 <= 64) {
							var9 = this.ak;
							var10 = this.al;
						}

						if (var15 < 63 && (var9 == null || var9.getBlock().getMaterial() == Material.AIR)) {
							if (this.a(new Position(var4, var15, var5)) < 0.15F) {
								var9 = Blocks.ICE.getBlockState();
							} else {
								var9 = Blocks.WATER.getBlockState();
							}
						}

						var11 = var12;
						if (var15 >= 62) {
							var3.a(var14, var15, var13, var9);
						} else if (var15 < 56 - var12) {
							var9 = null;
							var10 = Blocks.STONE.getBlockState();
							var3.a(var14, var15, var13, Blocks.GRAVEL.getBlockState());
						} else {
							var3.a(var14, var15, var13, var10);
						}
					} else if (var11 > 0) {
						--var11;
						var3.a(var14, var15, var13, var10);
						if (var11 == 0 && var10.getBlock() == Blocks.SAND) {
							var11 = var2.nextInt(4) + Math.max(0, var15 - 63);
							var10 = var10.b(BlockSand.a) == bac.b ? Blocks.RED_SANDSTONE.getBlockState() : Blocks.SANDSTONE.getBlockState();
						}
					}
				}
			}
		}

	}

	protected BiomeBase k() {
		return this.d(this.az + 128);
	}

	protected BiomeBase d(int var1) {
		return new asl(var1, this);
	}

	public Class l() {
		return this.getClass();
	}

	public boolean a(BiomeBase var1) {
		return var1 == this ? true : (var1 == null ? false : this.l() == var1.l());
	}

	public EnumBiomeTemperature m() {
		return (double) this.ap < 0.2D ? EnumBiomeTemperature.b : ((double) this.ap < 1.0D ? EnumBiomeTemperature.c : EnumBiomeTemperature.d);
	}

	public static BiomeBase[] n() {
		return aE;
	}

	public static BiomeBase e(int var0) {
		return a(var0, (BiomeBase) null);
	}

	public static BiomeBase a(int var0, BiomeBase var1) {
		if (var0 >= 0 && var0 <= aE.length) {
			BiomeBase var2 = aE[var0];
			return var2 == null ? var1 : var2;
		} else {
			aD.warn("Biome ID is out of bounds: " + var0 + ", defaulting to 0 (Ocean)");
			return OCEAN;
		}
	}

	static {
		PLAINS.k();
		DESERT.k();
		FOREST.k();
		TAIGA.k();
		SWAMPLAND.k();
		ICE_PLAINS.k();
		JUNGLE.k();
		JUNGLE_EDGE.k();
		COLD_TAIGA.k();
		SAVANNA.k();
		SAVANNA_PLATEAU.k();
		MESA.k();
		MESA_PLATEAU_F.k();
		MESA_PLATEAU.k();
		BIRCH_FOREST.k();
		BIRCH_FOREST_HILLS.k();
		ROOFED_FOREST.k();
		MEGA_TAIGA.k();
		EXTREME_HILLS.k();
		EXTREME_HILLS_PLUS.k();
		MEGA_TAIGA.d(MEGA_TAIGA_HILLS.az + 128).a("Redwood Taiga Hills M");
		BiomeBase[] var0 = aE;
		int var1 = var0.length;

		for (int var2 = 0; var2 < var1; ++var2) {
			BiomeBase var3 = var0[var2];
			if (var3 != null) {
				if (o.containsKey(var3.ah)) {
					throw new Error("Biome \"" + var3.ah + "\" is defined as both ID " + ((BiomeBase) o.get(var3.ah)).az + " and " + var3.az);
				}

				o.put(var3.ah, var3);
				if (var3.az < 128) {
					n.add(var3);
				}
			}
		}

		n.remove(HELL);
		n.remove(SKY);
		n.remove(FROZEN_OCEAN);
		n.remove(SMALL_MOUNTAINS);
		ae = new NoiseGenerator3(new Random(1234L), 1);
		af = new NoiseGenerator3(new Random(2345L), 1);
		ag = new WorldGenTallPlant();
	}
}

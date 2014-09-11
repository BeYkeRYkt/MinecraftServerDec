package net.minecraft;

import java.util.Random;

public class BiomeTaiga extends BiomeBase {

	private static final WorldGenTaiga1 aD = new WorldGenTaiga1();
	private static final WorldGenTaiga2 aE = new WorldGenTaiga2(false);
	private static final WorldGenMegaTree aF = new WorldGenMegaTree(false, false);
	private static final WorldGenMegaTree aG = new WorldGenMegaTree(false, true);
	private static final WorldGenTaigaStructure aH = new WorldGenTaigaStructure(Blocks.MOSSY_COBBLESTONE, 0);
	private int aI;

	public BiomeTaiga(int var1, int var2) {
		super(var1);
		this.aI = var2;
		this.au.add(new BiomeMeta(EntityWolf.class, 8, 4, 4));
		this.as.A = 10;
		if (var2 != 1 && var2 != 2) {
			this.as.C = 1;
			this.as.E = 1;
		} else {
			this.as.C = 7;
			this.as.D = 1;
			this.as.E = 3;
		}

	}

	public WorldGenTreeAbstract a(Random var1) {
		return (WorldGenTreeAbstract) ((this.aI == 1 || this.aI == 2) && var1.nextInt(3) == 0 ? (this.aI != 2 && var1.nextInt(13) != 0 ? aF : aG) : (var1.nextInt(3) == 0 ? aD : aE));
	}

	public WorldGenerator b(Random var1) {
		return var1.nextInt(5) > 0 ? new WorldGenGrass(EnumGrassType.c) : new WorldGenGrass(EnumGrassType.b);
	}

	public void a(World var1, Random var2, Position var3) {
		int var4;
		int var5;
		int var6;
		int var7;
		if (this.aI == 1 || this.aI == 2) {
			var4 = var2.nextInt(3);

			for (var5 = 0; var5 < var4; ++var5) {
				var6 = var2.nextInt(16) + 8;
				var7 = var2.nextInt(16) + 8;
				Position var8 = var1.m(var3.a(var6, 0, var7));
				aH.b(var1, var2, var8);
			}
		}

		ag.a(avk.d);

		for (var4 = 0; var4 < 7; ++var4) {
			var5 = var2.nextInt(16) + 8;
			var6 = var2.nextInt(16) + 8;
			var7 = var2.nextInt(var1.m(var3.a(var5, 0, var6)).getY() + 32);
			ag.b(var1, var2, var3.a(var5, var7, var6));
		}

		super.a(var1, var2, var3);
	}

	public void a(World var1, Random var2, bgk var3, int var4, int var5, double var6) {
		if (this.aI == 1 || this.aI == 2) {
			this.ak = Blocks.GRASS.getBlockState();
			this.al = Blocks.DIRT.getBlockState();
			if (var6 > 1.75D) {
				this.ak = Blocks.DIRT.getBlockState().a(BlockDirt.a, avd.b);
			} else if (var6 > -0.95D) {
				this.ak = Blocks.DIRT.getBlockState().a(BlockDirt.a, avd.c);
			}
		}

		this.b(var1, var2, var3, var4, var5, var6);
	}

	protected BiomeBase d(int var1) {
		return this.az == BiomeBase.MEGA_TAIGA.az ? (new BiomeTaiga(var1, 2)).a(5858897, true).a("Mega Spruce Taiga").a(5159473).a(0.25F, 0.8F).a(new BiomeTemperature(this.an, this.ao)) : super.d(var1);
	}

}

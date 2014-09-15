package net.minecraft;

import java.util.List;
import java.util.Random;

public class ChunkProviderGenerate implements IChunkProvider {

	private Random rnd;
	private NoiseGeneratorOctaves i;
	private NoiseGeneratorOctaves j;
	private NoiseGeneratorOctaves k;
	private NoiseGenerator3 l;
	public NoiseGeneratorOctaves a;
	public NoiseGeneratorOctaves b;
	public NoiseGeneratorOctaves c;
	private WorldServer world;
	private final boolean mapFeaturesEnabled;
	private LevelType levelType;
	private final double[] p;
	private final float[] q;
	private ChunkProviderGenerateProperties properties;
	private Block seablock;
	private double[] t;
	private WorldGenBase cavesGenerator = new WorldGenCaves();
	private WorldGenStronghold strongholdGenerator = new WorldGenStronghold();
	private WorldGenVillage villageGenerator = new WorldGenVillage();
	private WorldGenMineshaft mineshaftGenerator = new WorldGenMineshaft();
	private WorldGenLargeFeature largeFeautureGenerator = new WorldGenLargeFeature();
	private WorldGenBase canyonGenerator = new WorldGenCanyon();
	private WorldGenMonument monumentGenerator = new WorldGenMonument();
	private BiomeBase[] biomeBase;
	double[] d;
	double[] e;
	double[] f;
	double[] g;

	public ChunkProviderGenerate(WorldServer world, long seed, boolean mapFeaturesEnabled, String var5) {
		this.seablock = Blocks.WATER;
		this.t = new double[256];
		this.world = world;
		this.mapFeaturesEnabled = mapFeaturesEnabled;
		this.levelType = world.getWorldData().getLevelType();
		this.rnd = new Random(seed);
		this.i = new NoiseGeneratorOctaves(this.rnd, 16);
		this.j = new NoiseGeneratorOctaves(this.rnd, 16);
		this.k = new NoiseGeneratorOctaves(this.rnd, 8);
		this.l = new NoiseGenerator3(this.rnd, 4);
		this.a = new NoiseGeneratorOctaves(this.rnd, 10);
		this.b = new NoiseGeneratorOctaves(this.rnd, 16);
		this.c = new NoiseGeneratorOctaves(this.rnd, 8);
		this.p = new double[825];
		this.q = new float[25];

		for (int var6 = -2; var6 <= 2; ++var6) {
			for (int var7 = -2; var7 <= 2; ++var7) {
				float var8 = 10.0F / MathHelper.c((float) (var6 * var6 + var7 * var7) + 0.2F);
				this.q[var6 + 2 + (var7 + 2) * 5] = var8;
			}
		}

		if (var5 != null) {
			this.properties = ChunkProviderGeneratePropertiesHolder.fromJSON(var5).getPropertiesHolder();
			this.seablock = this.properties.useLavaOceans ? Blocks.LAVA : Blocks.WATER;
		}

	}

	public void a(int var1, int var2, bgk var3) {
		this.biomeBase = this.world.v().a(this.biomeBase, var1 * 4 - 2, var2 * 4 - 2, 10, 10);
		this.a(var1 * 4, 0, var2 * 4);

		for (int var4 = 0; var4 < 4; ++var4) {
			int var5 = var4 * 5;
			int var6 = (var4 + 1) * 5;

			for (int var7 = 0; var7 < 4; ++var7) {
				int var8 = (var5 + var7) * 33;
				int var9 = (var5 + var7 + 1) * 33;
				int var10 = (var6 + var7) * 33;
				int var11 = (var6 + var7 + 1) * 33;

				for (int var12 = 0; var12 < 32; ++var12) {
					double var13 = 0.125D;
					double var15 = this.p[var8 + var12];
					double var17 = this.p[var9 + var12];
					double var19 = this.p[var10 + var12];
					double var21 = this.p[var11 + var12];
					double var23 = (this.p[var8 + var12 + 1] - var15) * var13;
					double var25 = (this.p[var9 + var12 + 1] - var17) * var13;
					double var27 = (this.p[var10 + var12 + 1] - var19) * var13;
					double var29 = (this.p[var11 + var12 + 1] - var21) * var13;

					for (int var31 = 0; var31 < 8; ++var31) {
						double var32 = 0.25D;
						double var34 = var15;
						double var36 = var17;
						double var38 = (var19 - var15) * var32;
						double var40 = (var21 - var17) * var32;

						for (int var42 = 0; var42 < 4; ++var42) {
							double var43 = 0.25D;
							double var47 = (var36 - var34) * var43;
							double var45 = var34 - var47;

							for (int var49 = 0; var49 < 4; ++var49) {
								if ((var45 += var47) > 0.0D) {
									var3.a(var4 * 4 + var42, var12 * 8 + var31, var7 * 4 + var49, Blocks.STONE.getBlockState());
								} else if (var12 * 8 + var31 < this.properties.seaLevel) {
									var3.a(var4 * 4 + var42, var12 * 8 + var31, var7 * 4 + var49, this.seablock.getBlockState());
								}
							}

							var34 += var38;
							var36 += var40;
						}

						var15 += var23;
						var17 += var25;
						var19 += var27;
						var21 += var29;
					}
				}
			}
		}

	}

	public void a(int var1, int var2, bgk var3, BiomeBase[] var4) {
		double var5 = 0.03125D;
		this.t = this.l.a(this.t, (double) (var1 * 16), (double) (var2 * 16), 16, 16, var5 * 2.0D, var5 * 2.0D, 1.0D);

		for (int var7 = 0; var7 < 16; ++var7) {
			for (int var8 = 0; var8 < 16; ++var8) {
				BiomeBase var9 = var4[var8 + var7 * 16];
				var9.a(this.world, this.rnd, var3, var1 * 16 + var7, var2 * 16 + var8, this.t[var8 + var7 * 16]);
			}
		}

	}

	public Chunk getOrCreateChunk(int var1, int var2) {
		this.rnd.setSeed((long) var1 * 341873128712L + (long) var2 * 132897987541L);
		bgk var3 = new bgk();
		this.a(var1, var2, var3);
		this.biomeBase = this.world.v().b(this.biomeBase, var1 * 16, var2 * 16, 16, 16);
		this.a(var1, var2, var3, this.biomeBase);
		if (this.properties.useCaves) {
			this.cavesGenerator.a(this, this.world, var1, var2, var3);
		}

		if (this.properties.useRavines) {
			this.canyonGenerator.a(this, this.world, var1, var2, var3);
		}

		if (this.properties.useMineShafts && this.mapFeaturesEnabled) {
			this.mineshaftGenerator.a(this, this.world, var1, var2, var3);
		}

		if (this.properties.useVillages && this.mapFeaturesEnabled) {
			this.villageGenerator.a(this, this.world, var1, var2, var3);
		}

		if (this.properties.useStrongholds && this.mapFeaturesEnabled) {
			this.strongholdGenerator.a(this, this.world, var1, var2, var3);
		}

		if (this.properties.useTemples && this.mapFeaturesEnabled) {
			this.largeFeautureGenerator.a(this, this.world, var1, var2, var3);
		}

		if (this.properties.useMonuments && this.mapFeaturesEnabled) {
			this.monumentGenerator.a(this, this.world, var1, var2, var3);
		}

		Chunk var4 = new Chunk(this.world, var3, var1, var2);
		byte[] var5 = var4.getBiomes();

		for (int var6 = 0; var6 < var5.length; ++var6) {
			var5[var6] = (byte) this.biomeBase[var6].az;
		}

		var4.b();
		return var4;
	}

	private void a(int var1, int var2, int var3) {
		this.g = this.b.a(this.g, var1, var3, 5, 5, (double) this.properties.depthNoiseScaleX, (double) this.properties.depthNoiseScaleZ, (double) this.properties.depthNoiseScaleExponent);
		float var4 = this.properties.coordinateScale;
		float var5 = this.properties.heightScale;
		this.d = this.k.a(this.d, var1, var2, var3, 5, 33, 5, (double) (var4 / this.properties.mainNoiseScaleX), (double) (var5 / this.properties.mainNoiseScaleY), (double) (var4 / this.properties.mainNoiseScaleZ));
		this.e = this.i.a(this.e, var1, var2, var3, 5, 33, 5, (double) var4, (double) var5, (double) var4);
		this.f = this.j.a(this.f, var1, var2, var3, 5, 33, 5, (double) var4, (double) var5, (double) var4);
		boolean var37 = false;
		boolean var36 = false;
		int var6 = 0;
		int var7 = 0;

		for (int var8 = 0; var8 < 5; ++var8) {
			for (int var9 = 0; var9 < 5; ++var9) {
				float var10 = 0.0F;
				float var11 = 0.0F;
				float var12 = 0.0F;
				byte var13 = 2;
				BiomeBase var14 = this.biomeBase[var8 + 2 + (var9 + 2) * 10];

				for (int var15 = -var13; var15 <= var13; ++var15) {
					for (int var16 = -var13; var16 <= var13; ++var16) {
						BiomeBase var17 = this.biomeBase[var8 + var15 + 2 + (var9 + var16 + 2) * 10];
						float var18 = this.properties.biomeDepthOffset + var17.an * this.properties.biomeDepthWeight;
						float var19 = this.properties.biomeScaleOffset + var17.ao * this.properties.biomeScaleWeight;
						if (this.levelType == LevelType.AMPLIFIED && var18 > 0.0F) {
							var18 = 1.0F + var18 * 2.0F;
							var19 = 1.0F + var19 * 4.0F;
						}

						float var20 = this.q[var15 + 2 + (var16 + 2) * 5] / (var18 + 2.0F);
						if (var17.an > var14.an) {
							var20 /= 2.0F;
						}

						var10 += var19 * var20;
						var11 += var18 * var20;
						var12 += var20;
					}
				}

				var10 /= var12;
				var11 /= var12;
				var10 = var10 * 0.9F + 0.1F;
				var11 = (var11 * 4.0F - 1.0F) / 8.0F;
				double var38 = this.g[var7] / 8000.0D;
				if (var38 < 0.0D) {
					var38 = -var38 * 0.3D;
				}

				var38 = var38 * 3.0D - 2.0D;
				if (var38 < 0.0D) {
					var38 /= 2.0D;
					if (var38 < -1.0D) {
						var38 = -1.0D;
					}

					var38 /= 1.4D;
					var38 /= 2.0D;
				} else {
					if (var38 > 1.0D) {
						var38 = 1.0D;
					}

					var38 /= 8.0D;
				}

				++var7;
				double var39 = (double) var11;
				double var40 = (double) var10;
				var39 += var38 * 0.2D;
				var39 = var39 * (double) this.properties.baseSize / 8.0D;
				double var21 = (double) this.properties.baseSize + var39 * 4.0D;

				for (int var23 = 0; var23 < 33; ++var23) {
					double var24 = ((double) var23 - var21) * (double) this.properties.stretchY * 128.0D / 256.0D / var40;
					if (var24 < 0.0D) {
						var24 *= 4.0D;
					}

					double var26 = this.e[var6] / (double) this.properties.lowerLimitScale;
					double var28 = this.f[var6] / (double) this.properties.upperLimitScale;
					double var30 = (this.d[var6] / 10.0D + 1.0D) / 2.0D;
					double var32 = MathHelper.b(var26, var28, var30) - var24;
					if (var23 > 29) {
						double var34 = (double) ((float) (var23 - 29) / 3.0F);
						var32 = var32 * (1.0D - var34) + -10.0D * var34;
					}

					this.p[var6] = var32;
					++var6;
				}
			}
		}

	}

	public boolean isChunkLoaded(int var1, int var2) {
		return true;
	}

	public void getChunkAt(IChunkProvider var1, int var2, int var3) {
		BlockFalling.instafall = true;
		int var4 = var2 * 16;
		int var5 = var3 * 16;
		Position var6 = new Position(var4, 0, var5);
		BiomeBase var7 = this.world.b(var6.a(16, 0, 16));
		this.rnd.setSeed(this.world.J());
		long var8 = this.rnd.nextLong() / 2L * 2L + 1L;
		long var10 = this.rnd.nextLong() / 2L * 2L + 1L;
		this.rnd.setSeed((long) var2 * var8 + (long) var3 * var10 ^ this.world.J());
		boolean var12 = false;
		ChunkCoordIntPair var13 = new ChunkCoordIntPair(var2, var3);
		if (this.properties.useMineShafts && this.mapFeaturesEnabled) {
			this.mineshaftGenerator.a(this.world, this.rnd, var13);
		}

		if (this.properties.useVillages && this.mapFeaturesEnabled) {
			var12 = this.villageGenerator.a(this.world, this.rnd, var13);
		}

		if (this.properties.useStrongholds && this.mapFeaturesEnabled) {
			this.strongholdGenerator.a(this.world, this.rnd, var13);
		}

		if (this.properties.useTemples && this.mapFeaturesEnabled) {
			this.largeFeautureGenerator.a(this.world, this.rnd, var13);
		}

		if (this.properties.useMonuments && this.mapFeaturesEnabled) {
			this.monumentGenerator.a(this.world, this.rnd, var13);
		}

		int var14;
		int var15;
		int var16;
		if (var7 != BiomeBase.DESERT && var7 != BiomeBase.DESERT_HILLS && this.properties.useWaterLakes && !var12 && this.rnd.nextInt(this.properties.waterLakeChance) == 0) {
			var14 = this.rnd.nextInt(16) + 8;
			var15 = this.rnd.nextInt(256);
			var16 = this.rnd.nextInt(16) + 8;
			(new WorldGenLakes(Blocks.WATER)).b(this.world, this.rnd, var6.a(var14, var15, var16));
		}

		if (!var12 && this.rnd.nextInt(this.properties.lavaLakeChance / 10) == 0 && this.properties.useLavaLakes) {
			var14 = this.rnd.nextInt(16) + 8;
			var15 = this.rnd.nextInt(this.rnd.nextInt(248) + 8);
			var16 = this.rnd.nextInt(16) + 8;
			if (var15 < 63 || this.rnd.nextInt(this.properties.lavaLakeChance / 8) == 0) {
				(new WorldGenLakes(Blocks.LAVA)).b(this.world, this.rnd, var6.a(var14, var15, var16));
			}
		}

		if (this.properties.useDungeons) {
			for (var14 = 0; var14 < this.properties.dungeonChance; ++var14) {
				var15 = this.rnd.nextInt(16) + 8;
				var16 = this.rnd.nextInt(256);
				int var17 = this.rnd.nextInt(16) + 8;
				(new WorldGenDungeons()).b(this.world, this.rnd, var6.a(var15, var16, var17));
			}
		}

		var7.a(this.world, this.rnd, new Position(var4, 0, var5));
		SpawnerCreature.a(this.world, var7, var4 + 8, var5 + 8, 16, 16, this.rnd);
		var6 = var6.a(8, 0, 8);

		for (var14 = 0; var14 < 16; ++var14) {
			for (var15 = 0; var15 < 16; ++var15) {
				Position var18 = this.world.q(var6.a(var14, 0, var15));
				Position var19 = var18.b();
				if (this.world.v(var19)) {
					this.world.setBlockAt(var19, Blocks.ICE.getBlockState(), 2);
				}

				if (this.world.f(var18, true)) {
					this.world.setBlockAt(var18, Blocks.SNOW_LAYER.getBlockState(), 2);
				}
			}
		}

		BlockFalling.instafall = false;
	}

	public boolean ae(IChunkProvider var1, Chunk var2, int var3, int var4) {
		boolean var5 = false;
		if (this.properties.useMonuments && this.mapFeaturesEnabled && var2.getInhabitedTime() < 3600L) {
			var5 |= this.monumentGenerator.a(this.world, this.rnd, new ChunkCoordIntPair(var3, var4));
		}

		return var5;
	}

	public boolean requestChunksSave(boolean var1, IProgressUpdate var2) {
		return true;
	}

	public void saveChunks() {
	}

	public boolean unloadChunks() {
		return false;
	}

	public boolean canSave() {
		return true;
	}

	public String getName() {
		return "RandomLevelSource";
	}

	public List getMobsFor(EnumCreatureType var1, Position var2) {
		BiomeBase var3 = this.world.b(var2);
		if (this.mapFeaturesEnabled) {
			if (var1 == EnumCreatureType.MONSTER && this.largeFeautureGenerator.a(var2)) {
				return this.largeFeautureGenerator.b();
			}

			if (var1 == EnumCreatureType.MONSTER && this.properties.useMonuments && this.monumentGenerator.a(this.world, var2)) {
				return this.monumentGenerator.b();
			}
		}

		return var3.a(var1);
	}

	public Position findNearestMapFeature(World var1, String var2, Position var3) {
		return "Stronghold".equals(var2) && this.strongholdGenerator != null ? this.strongholdGenerator.b(var1, var3) : null;
	}

	public int getLoadedChunks() {
		return 0;
	}

	public void recreateStructures(Chunk var1, int var2, int var3) {
		if (this.properties.useMineShafts && this.mapFeaturesEnabled) {
			this.mineshaftGenerator.a(this, this.world, var2, var3, (bgk) null);
		}

		if (this.properties.useVillages && this.mapFeaturesEnabled) {
			this.villageGenerator.a(this, this.world, var2, var3, (bgk) null);
		}

		if (this.properties.useStrongholds && this.mapFeaturesEnabled) {
			this.strongholdGenerator.a(this, this.world, var2, var3, (bgk) null);
		}

		if (this.properties.useTemples && this.mapFeaturesEnabled) {
			this.largeFeautureGenerator.a(this, this.world, var2, var3, (bgk) null);
		}

		if (this.properties.useMonuments && this.mapFeaturesEnabled) {
			this.monumentGenerator.a(this, this.world, var2, var3, (bgk) null);
		}

	}

	public Chunk getChunkAtWorldCoords(Position position) {
		return this.getOrCreateChunk(position.getX() >> 4, position.getZ() >> 4);
	}

}

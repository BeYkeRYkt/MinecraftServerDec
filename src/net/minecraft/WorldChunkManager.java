package net.minecraft;

import com.google.common.collect.Lists;
import java.util.List;
import java.util.Random;

public class WorldChunkManager {

	private bpa b;
	private bpa c;
	private arr d;
	private List e;
	private String f;

	protected WorldChunkManager() {
		this.d = new arr(this);
		this.f = "";
		this.e = Lists.newArrayList();
		this.e.add(BiomeBase.FOREST);
		this.e.add(BiomeBase.PLAINS);
		this.e.add(BiomeBase.TAIGA);
		this.e.add(BiomeBase.TAIGA_HILLS);
		this.e.add(BiomeBase.FOREST_HILLS);
		this.e.add(BiomeBase.JUNGLE);
		this.e.add(BiomeBase.JUNGLE_HILLS);
	}

	public WorldChunkManager(long var1, LevelType var3, String var4) {
		this();
		this.f = var4;
		bpa[] var5 = bpa.a(var1, var3, var4);
		this.b = var5[0];
		this.c = var5[1];
	}

	public WorldChunkManager(World var1) {
		this(var1.J(), var1.getWorldData().getLevelType(), var1.getWorldData().getGeneratorOptions());
	}

	public List a() {
		return this.e;
	}

	public BiomeBase a(Position var1) {
		return this.a(var1, (BiomeBase) null);
	}

	public BiomeBase a(Position var1, BiomeBase var2) {
		return this.d.a(var1.getX(), var1.getZ(), var2);
	}

	public float[] a(float[] var1, int var2, int var3, int var4, int var5) {
		boy.a();
		if (var1 == null || var1.length < var4 * var5) {
			var1 = new float[var4 * var5];
		}

		int[] var6 = this.c.a(var2, var3, var4, var5);

		for (int var7 = 0; var7 < var4 * var5; ++var7) {
			try {
				float var8 = (float) BiomeBase.a(var6[var7], BiomeBase.OCEAN).h() / 65536.0F;
				if (var8 > 1.0F) {
					var8 = 1.0F;
				}

				var1[var7] = var8;
			} catch (Throwable var11) {
				CrashReport var9 = CrashReport.generateCrashReport(var11, "Invalid Biome id");
				CrashReportSystemDetails var10 = var9.generateSystemDetails("DownfallBlock");
				var10.addDetails("biome id", (Object) Integer.valueOf(var7));
				var10.addDetails("downfalls[] size", (Object) Integer.valueOf(var1.length));
				var10.addDetails("x", (Object) Integer.valueOf(var2));
				var10.addDetails("z", (Object) Integer.valueOf(var3));
				var10.addDetails("w", (Object) Integer.valueOf(var4));
				var10.addDetails("h", (Object) Integer.valueOf(var5));
				throw new ReportedException(var9);
			}
		}

		return var1;
	}

	public BiomeBase[] a(BiomeBase[] var1, int var2, int var3, int var4, int var5) {
		boy.a();
		if (var1 == null || var1.length < var4 * var5) {
			var1 = new BiomeBase[var4 * var5];
		}

		int[] var6 = this.b.a(var2, var3, var4, var5);

		try {
			for (int var7 = 0; var7 < var4 * var5; ++var7) {
				var1[var7] = BiomeBase.a(var6[var7], BiomeBase.OCEAN);
			}

			return var1;
		} catch (Throwable var10) {
			CrashReport var8 = CrashReport.generateCrashReport(var10, "Invalid Biome id");
			CrashReportSystemDetails var9 = var8.generateSystemDetails("RawBiomeBlock");
			var9.addDetails("biomes[] size", (Object) Integer.valueOf(var1.length));
			var9.addDetails("x", (Object) Integer.valueOf(var2));
			var9.addDetails("z", (Object) Integer.valueOf(var3));
			var9.addDetails("w", (Object) Integer.valueOf(var4));
			var9.addDetails("h", (Object) Integer.valueOf(var5));
			throw new ReportedException(var8);
		}
	}

	public BiomeBase[] b(BiomeBase[] var1, int var2, int var3, int var4, int var5) {
		return this.a(var1, var2, var3, var4, var5, true);
	}

	public BiomeBase[] a(BiomeBase[] var1, int var2, int var3, int var4, int var5, boolean var6) {
		boy.a();
		if (var1 == null || var1.length < var4 * var5) {
			var1 = new BiomeBase[var4 * var5];
		}

		if (var6 && var4 == 16 && var5 == 16 && (var2 & 15) == 0 && (var3 & 15) == 0) {
			BiomeBase[] var9 = this.d.c(var2, var3);
			System.arraycopy(var9, 0, var1, 0, var4 * var5);
			return var1;
		} else {
			int[] var7 = this.c.a(var2, var3, var4, var5);

			for (int var8 = 0; var8 < var4 * var5; ++var8) {
				var1[var8] = BiomeBase.a(var7[var8], BiomeBase.OCEAN);
			}

			return var1;
		}
	}

	public boolean a(int var1, int var2, int var3, List var4) {
		boy.a();
		int var5 = var1 - var3 >> 2;
		int var6 = var2 - var3 >> 2;
		int var7 = var1 + var3 >> 2;
		int var8 = var2 + var3 >> 2;
		int var9 = var7 - var5 + 1;
		int var10 = var8 - var6 + 1;
		int[] var11 = this.b.a(var5, var6, var9, var10);

		try {
			for (int var12 = 0; var12 < var9 * var10; ++var12) {
				BiomeBase var16 = BiomeBase.e(var11[var12]);
				if (!var4.contains(var16)) {
					return false;
				}
			}

			return true;
		} catch (Throwable var15) {
			CrashReport var13 = CrashReport.generateCrashReport(var15, "Invalid Biome id");
			CrashReportSystemDetails var14 = var13.generateSystemDetails("Layer");
			var14.addDetails("Layer", (Object) this.b.toString());
			var14.addDetails("x", (Object) Integer.valueOf(var1));
			var14.addDetails("z", (Object) Integer.valueOf(var2));
			var14.addDetails("radius", (Object) Integer.valueOf(var3));
			var14.addDetails("allowed", (Object) var4);
			throw new ReportedException(var13);
		}
	}

	public Position a(int var1, int var2, int var3, List var4, Random var5) {
		boy.a();
		int var6 = var1 - var3 >> 2;
		int var7 = var2 - var3 >> 2;
		int var8 = var1 + var3 >> 2;
		int var9 = var2 + var3 >> 2;
		int var10 = var8 - var6 + 1;
		int var11 = var9 - var7 + 1;
		int[] var12 = this.b.a(var6, var7, var10, var11);
		Position var13 = null;
		int var14 = 0;

		for (int var15 = 0; var15 < var10 * var11; ++var15) {
			int var16 = var6 + var15 % var10 << 2;
			int var17 = var7 + var15 / var10 << 2;
			BiomeBase var18 = BiomeBase.e(var12[var15]);
			if (var4.contains(var18) && (var13 == null || var5.nextInt(var14 + 1) == 0)) {
				var13 = new Position(var16, 0, var17);
				++var14;
			}
		}

		return var13;
	}

	public void b() {
		this.d.a();
	}
}

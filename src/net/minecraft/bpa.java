package net.minecraft;

import java.util.concurrent.Callable;

public abstract class bpa {

	private long c;
	protected bpa a;
	private long d;
	protected long b;

	public static bpa[] a(long var0, LevelType var2, String var3) {
		boz var4 = new boz(1L);
		bow var13 = new bow(2000L, var4);
		boo var14 = new boo(1L, var13);
		bpp var15 = new bpp(2001L, var14);
		var14 = new boo(2L, var15);
		var14 = new boo(50L, var14);
		var14 = new boo(70L, var14);
		bpf var16 = new bpf(2L, var14);
		boq var17 = new boq(2L, var16);
		var14 = new boo(3L, var17);
		bol var18 = new bol(2L, var14, bon.a);
		var18 = new bol(2L, var18, bon.b);
		var18 = new bol(3L, var18, bon.c);
		var15 = new bpp(2002L, var18);
		var15 = new bpp(2003L, var15);
		var14 = new boo(4L, var15);
		bop var19 = new bop(5L, var14);
		bok var20 = new bok(4L, var19);
		bpa var21 = bpp.b(1000L, var20, 0);
		ChunkProviderGenerateProperties var5 = null;
		int var6 = 4;
		int var7 = var6;
		if (var2 == LevelType.CUSTOM && var3.length() > 0) {
			var5 = ChunkProviderGeneratePropertiesHolder.fromJSON(var3).getPropertiesHolder();
			var6 = var5.biomeSize;
			var7 = var5.riverSize;
		}

		if (var2 == LevelType.LARGE_BIOMES) {
			var6 = 6;
		}

		bpa var8 = bpp.b(1000L, var21, 0);
		bpg var22 = new bpg(100L, var8);
		bos var9 = new bos(200L, var21, var2, var3);
		bpa var25 = bpp.b(1000L, var9, 2);
		bor var26 = new bor(1000L, var25);
		bpa var10 = bpp.b(1000L, var22, 2);
		bpe var27 = new bpe(1000L, var26, var10);
		var8 = bpp.b(1000L, var22, 2);
		var8 = bpp.b(1000L, var8, var7);
		bph var23 = new bph(1L, var8);
		bpk var24 = new bpk(1000L, var23);
		Object var28 = new bpd(1001L, var27);

		for (int var11 = 0; var11 < var6; ++var11) {
			var28 = new bpp((long) (1000 + var11), (bpa) var28);
			if (var11 == 0) {
				var28 = new boo(3L, (bpa) var28);
			}

			if (var11 == 1 || var6 == 1) {
				var28 = new bpj(1000L, (bpa) var28);
			}
		}

		bpk var29 = new bpk(1000L, (bpa) var28);
		bpi var30 = new bpi(100L, var29, var24);
		bpo var12 = new bpo(10L, var30);
		var30.a(var0);
		var12.a(var0);
		return new bpa[] { var30, var12, var30 };
	}

	public bpa(long var1) {
		this.b = var1;
		this.b *= this.b * 6364136223846793005L + 1442695040888963407L;
		this.b += var1;
		this.b *= this.b * 6364136223846793005L + 1442695040888963407L;
		this.b += var1;
		this.b *= this.b * 6364136223846793005L + 1442695040888963407L;
		this.b += var1;
	}

	public void a(long var1) {
		this.c = var1;
		if (this.a != null) {
			this.a.a(var1);
		}

		this.c *= this.c * 6364136223846793005L + 1442695040888963407L;
		this.c += this.b;
		this.c *= this.c * 6364136223846793005L + 1442695040888963407L;
		this.c += this.b;
		this.c *= this.c * 6364136223846793005L + 1442695040888963407L;
		this.c += this.b;
	}

	public void a(long var1, long var3) {
		this.d = this.c;
		this.d *= this.d * 6364136223846793005L + 1442695040888963407L;
		this.d += var1;
		this.d *= this.d * 6364136223846793005L + 1442695040888963407L;
		this.d += var3;
		this.d *= this.d * 6364136223846793005L + 1442695040888963407L;
		this.d += var1;
		this.d *= this.d * 6364136223846793005L + 1442695040888963407L;
		this.d += var3;
	}

	protected int a(int var1) {
		int var2 = (int) ((this.d >> 24) % (long) var1);
		if (var2 < 0) {
			var2 += var1;
		}

		this.d *= this.d * 6364136223846793005L + 1442695040888963407L;
		this.d += this.c;
		return var2;
	}

	public abstract int[] a(int var1, int var2, int var3, int var4);

	protected static boolean a(int var0, int var1) {
		if (var0 == var1) {
			return true;
		} else if (var0 != BiomeBase.ab.az && var0 != BiomeBase.ac.az) {
			BiomeBase var2 = BiomeBase.e(var0);
			BiomeBase var3 = BiomeBase.e(var1);

			try {
				return var2 != null && var3 != null ? var2.a(var3) : false;
			} catch (Throwable var7) {
				CrashReport var5 = CrashReport.generateCrashReport(var7, "Comparing biomes");
				CrashReportSystemDetails var6 = var5.generateSystemDetails("Biomes being compared");
				var6.addDetails("Biome A ID", (Object) Integer.valueOf(var0));
				var6.addDetails("Biome B ID", (Object) Integer.valueOf(var1));
				var6.addDetails("Biome A", (Callable) (new bpb(var2)));
				var6.addDetails("Biome B", (Callable) (new bpc(var3)));
				throw new ReportedException(var5);
			}
		} else {
			return var1 == BiomeBase.ab.az || var1 == BiomeBase.ac.az;
		}
	}

	protected static boolean b(int var0) {
		return var0 == BiomeBase.p.az || var0 == BiomeBase.N.az || var0 == BiomeBase.z.az;
	}

	protected int a(int... var1) {
		return var1[this.a(var1.length)];
	}

	protected int b(int var1, int var2, int var3, int var4) {
		return var2 == var3 && var3 == var4 ? var2 : (var1 == var2 && var1 == var3 ? var1 : (var1 == var2 && var1 == var4 ? var1 : (var1 == var3 && var1 == var4 ? var1 : (var1 == var2 && var3 != var4 ? var1 : (var1 == var3 && var2 != var4 ? var1 : (var1 == var4 && var2 != var3 ? var1 : (var2 == var3 && var1 != var4 ? var2 : (var2 == var4 && var1 != var3 ? var2 : (var3 == var4 && var1 != var2 ? var3 : this.a(new int[] { var1, var2, var3, var4 }))))))))));
	}
}

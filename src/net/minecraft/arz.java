package net.minecraft;

import com.google.common.collect.Lists;
import java.util.List;
import java.util.Random;

public class arz {

	private bpa b;
	private bpa c;
	private arr d;
	private List e;
	private String f;

	protected arz() {
		this.d = new arr(this);
		this.f = "";
		this.e = Lists.newArrayList();
		this.e.add(arm.t);
		this.e.add(arm.q);
		this.e.add(arm.u);
		this.e.add(arm.I);
		this.e.add(arm.H);
		this.e.add(arm.K);
		this.e.add(arm.L);
	}

	public arz(long var1, are var3, String var4) {
		this();
		this.f = var4;
		bpa[] var5 = bpa.a(var1, var3, var4);
		this.b = var5[0];
		this.c = var5[1];
	}

	public arz(World var1) {
		this(var1.J(), var1.P().u(), var1.P().B());
	}

	public List a() {
		return this.e;
	}

	public arm a(dt var1) {
		return this.a(var1, (arm) null);
	}

	public arm a(dt var1, arm var2) {
		return this.d.a(var1.n(), var1.p(), var2);
	}

	public float[] a(float[] var1, int var2, int var3, int var4, int var5) {
		boy.a();
		if (var1 == null || var1.length < var4 * var5) {
			var1 = new float[var4 * var5];
		}

		int[] var6 = this.c.a(var2, var3, var4, var5);

		for (int var7 = 0; var7 < var4 * var5; ++var7) {
			try {
				float var8 = (float) arm.a(var6[var7], arm.ad).h() / 65536.0F;
				if (var8 > 1.0F) {
					var8 = 1.0F;
				}

				var1[var7] = var8;
			} catch (Throwable var11) {
				CrashReport var9 = CrashReport.a(var11, "Invalid Biome id");
				j var10 = var9.a("DownfallBlock");
				var10.a("biome id", (Object) Integer.valueOf(var7));
				var10.a("downfalls[] size", (Object) Integer.valueOf(var1.length));
				var10.a("x", (Object) Integer.valueOf(var2));
				var10.a("z", (Object) Integer.valueOf(var3));
				var10.a("w", (Object) Integer.valueOf(var4));
				var10.a("h", (Object) Integer.valueOf(var5));
				throw new u(var9);
			}
		}

		return var1;
	}

	public arm[] a(arm[] var1, int var2, int var3, int var4, int var5) {
		boy.a();
		if (var1 == null || var1.length < var4 * var5) {
			var1 = new arm[var4 * var5];
		}

		int[] var6 = this.b.a(var2, var3, var4, var5);

		try {
			for (int var7 = 0; var7 < var4 * var5; ++var7) {
				var1[var7] = arm.a(var6[var7], arm.ad);
			}

			return var1;
		} catch (Throwable var10) {
			CrashReport var8 = CrashReport.a(var10, "Invalid Biome id");
			j var9 = var8.a("RawBiomeBlock");
			var9.a("biomes[] size", (Object) Integer.valueOf(var1.length));
			var9.a("x", (Object) Integer.valueOf(var2));
			var9.a("z", (Object) Integer.valueOf(var3));
			var9.a("w", (Object) Integer.valueOf(var4));
			var9.a("h", (Object) Integer.valueOf(var5));
			throw new u(var8);
		}
	}

	public arm[] b(arm[] var1, int var2, int var3, int var4, int var5) {
		return this.a(var1, var2, var3, var4, var5, true);
	}

	public arm[] a(arm[] var1, int var2, int var3, int var4, int var5, boolean var6) {
		boy.a();
		if (var1 == null || var1.length < var4 * var5) {
			var1 = new arm[var4 * var5];
		}

		if (var6 && var4 == 16 && var5 == 16 && (var2 & 15) == 0 && (var3 & 15) == 0) {
			arm[] var9 = this.d.c(var2, var3);
			System.arraycopy(var9, 0, var1, 0, var4 * var5);
			return var1;
		} else {
			int[] var7 = this.c.a(var2, var3, var4, var5);

			for (int var8 = 0; var8 < var4 * var5; ++var8) {
				var1[var8] = arm.a(var7[var8], arm.ad);
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
				arm var16 = arm.e(var11[var12]);
				if (!var4.contains(var16)) {
					return false;
				}
			}

			return true;
		} catch (Throwable var15) {
			CrashReport var13 = CrashReport.a(var15, "Invalid Biome id");
			j var14 = var13.a("Layer");
			var14.a("Layer", (Object) this.b.toString());
			var14.a("x", (Object) Integer.valueOf(var1));
			var14.a("z", (Object) Integer.valueOf(var2));
			var14.a("radius", (Object) Integer.valueOf(var3));
			var14.a("allowed", (Object) var4);
			throw new u(var13);
		}
	}

	public dt a(int var1, int var2, int var3, List var4, Random var5) {
		boy.a();
		int var6 = var1 - var3 >> 2;
		int var7 = var2 - var3 >> 2;
		int var8 = var1 + var3 >> 2;
		int var9 = var2 + var3 >> 2;
		int var10 = var8 - var6 + 1;
		int var11 = var9 - var7 + 1;
		int[] var12 = this.b.a(var6, var7, var10, var11);
		dt var13 = null;
		int var14 = 0;

		for (int var15 = 0; var15 < var10 * var11; ++var15) {
			int var16 = var6 + var15 % var10 << 2;
			int var17 = var7 + var15 / var10 << 2;
			arm var18 = arm.e(var12[var15]);
			if (var4.contains(var18) && (var13 == null || var5.nextInt(var14 + 1) == 0)) {
				var13 = new dt(var16, 0, var17);
				++var14;
			}
		}

		return var13;
	}

	public void b() {
		this.d.a();
	}
}

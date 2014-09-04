package net.minecraft;

import java.util.Random;
import java.util.UUID;

public class uv {

	public static final float a = c(2.0F);
	private static final float[] b = new float[65536];
	private static final int[] c;

	public static float a(float var0) {
		return b[(int) (var0 * 10430.378F) & '\uffff'];
	}

	public static float b(float var0) {
		return b[(int) (var0 * 10430.378F + 16384.0F) & '\uffff'];
	}

	public static float c(float var0) {
		return (float) Math.sqrt((double) var0);
	}

	public static float a(double var0) {
		return (float) Math.sqrt(var0);
	}

	public static int d(float var0) {
		int var1 = (int) var0;
		return var0 < (float) var1 ? var1 - 1 : var1;
	}

	public static int c(double var0) {
		int var2 = (int) var0;
		return var0 < (double) var2 ? var2 - 1 : var2;
	}

	public static long d(double var0) {
		long var2 = (long) var0;
		return var0 < (double) var2 ? var2 - 1L : var2;
	}

	public static float e(float var0) {
		return var0 >= 0.0F ? var0 : -var0;
	}

	public static int a(int var0) {
		return var0 >= 0 ? var0 : -var0;
	}

	public static int f(float var0) {
		int var1 = (int) var0;
		return var0 > (float) var1 ? var1 + 1 : var1;
	}

	public static int f(double var0) {
		int var2 = (int) var0;
		return var0 > (double) var2 ? var2 + 1 : var2;
	}

	public static int a(int var0, int var1, int var2) {
		return var0 < var1 ? var1 : (var0 > var2 ? var2 : var0);
	}

	public static float a(float var0, float var1, float var2) {
		return var0 < var1 ? var1 : (var0 > var2 ? var2 : var0);
	}

	public static double a(double var0, double var2, double var4) {
		return var0 < var2 ? var2 : (var0 > var4 ? var4 : var0);
	}

	public static double b(double var0, double var2, double var4) {
		return var4 < 0.0D ? var0 : (var4 > 1.0D ? var2 : var0 + (var2 - var0) * var4);
	}

	public static double a(double var0, double var2) {
		if (var0 < 0.0D) {
			var0 = -var0;
		}

		if (var2 < 0.0D) {
			var2 = -var2;
		}

		return var0 > var2 ? var0 : var2;
	}

	public static int a(Random var0, int var1, int var2) {
		return var1 >= var2 ? var1 : var0.nextInt(var2 - var1 + 1) + var1;
	}

	public static float a(Random var0, float var1, float var2) {
		return var1 >= var2 ? var1 : var0.nextFloat() * (var2 - var1) + var1;
	}

	public static double a(Random var0, double var1, double var3) {
		return var1 >= var3 ? var1 : var0.nextDouble() * (var3 - var1) + var1;
	}

	public static double a(long[] var0) {
		long var1 = 0L;
		long[] var3 = var0;
		int var4 = var0.length;

		for (int var5 = 0; var5 < var4; ++var5) {
			long var6 = var3[var5];
			var1 += var6;
		}

		return (double) var1 / (double) var0.length;
	}

	public static float g(float var0) {
		var0 %= 360.0F;
		if (var0 >= 180.0F) {
			var0 -= 360.0F;
		}

		if (var0 < -180.0F) {
			var0 += 360.0F;
		}

		return var0;
	}

	public static double g(double var0) {
		var0 %= 360.0D;
		if (var0 >= 180.0D) {
			var0 -= 360.0D;
		}

		if (var0 < -180.0D) {
			var0 += 360.0D;
		}

		return var0;
	}

	public static int a(String var0, int var1) {
		try {
			return Integer.parseInt(var0);
		} catch (Throwable var3) {
			return var1;
		}
	}

	public static int a(String var0, int var1, int var2) {
		return Math.max(var2, a(var0, var1));
	}

	public static double a(String var0, double var1) {
		try {
			return Double.parseDouble(var0);
		} catch (Throwable var4) {
			return var1;
		}
	}

	public static double a(String var0, double var1, double var3) {
		return Math.max(var3, a(var0, var1));
	}

	public static int b(int var0) {
		int var1 = var0 - 1;
		var1 |= var1 >> 1;
		var1 |= var1 >> 2;
		var1 |= var1 >> 4;
		var1 |= var1 >> 8;
		var1 |= var1 >> 16;
		return var1 + 1;
	}

	private static boolean d(int var0) {
		return var0 != 0 && (var0 & var0 - 1) == 0;
	}

	private static int e(int var0) {
		var0 = d(var0) ? var0 : b(var0);
		return c[(int) ((long) var0 * 125613361L >> 27) & 31];
	}

	public static int c(int var0) {
		return e(var0) - (d(var0) ? 0 : 1);
	}

	public static int c(int var0, int var1) {
		if (var1 == 0) {
			return 0;
		} else if (var0 == 0) {
			return var1;
		} else {
			if (var0 < 0) {
				var1 *= -1;
			}

			int var2 = var0 % var1;
			return var2 == 0 ? var0 : var0 + var1 - var2;
		}
	}

	public static UUID a(Random var0) {
		long var1 = var0.nextLong() & -61441L | 16384L;
		long var3 = var0.nextLong() & 4611686018427387903L | Long.MIN_VALUE;
		return new UUID(var1, var3);
	}

	static {
		for (int var0 = 0; var0 < 65536; ++var0) {
			b[var0] = (float) Math.sin((double) var0 * 3.141592653589793D * 2.0D / 65536.0D);
		}

		c = new int[] { 0, 1, 28, 2, 29, 14, 24, 3, 30, 22, 20, 15, 25, 17, 4, 8, 31, 27, 13, 23, 21, 19, 16, 7, 26, 12, 18, 6, 11, 5, 10, 9 };
	}
}

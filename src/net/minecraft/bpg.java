package net.minecraft;

public class bpg extends bpa {

	public bpg(long var1, bpa var3) {
		super(var1);
		this.a = var3;
	}

	public int[] a(int var1, int var2, int var3, int var4) {
		int[] var5 = this.a.a(var1, var2, var3, var4);
		int[] var6 = IntCache.allocate(var3 * var4);

		for (int var7 = 0; var7 < var4; ++var7) {
			for (int var8 = 0; var8 < var3; ++var8) {
				this.a((long) (var8 + var1), (long) (var7 + var2));
				var6[var8 + var7 * var3] = var5[var8 + var7 * var3] > 0 ? this.a(299999) + 2 : 0;
			}
		}

		return var6;
	}
}

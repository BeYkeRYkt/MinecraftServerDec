package net.minecraft;

public class bor extends bpa {

	public bor(long var1, bpa var3) {
		super(var1);
		this.a = var3;
	}

	public int[] a(int var1, int var2, int var3, int var4) {
		int[] var5 = this.a.a(var1 - 1, var2 - 1, var3 + 2, var4 + 2);
		int[] var6 = boy.a(var3 * var4);

		for (int var7 = 0; var7 < var4; ++var7) {
			for (int var8 = 0; var8 < var3; ++var8) {
				this.a((long) (var8 + var1), (long) (var7 + var2));
				int var9 = var5[var8 + 1 + (var7 + 1) * (var3 + 2)];
				if (!this.a(var5, var6, var8, var7, var3, var9, arm.s.az, arm.J.az) && !this.b(var5, var6, var8, var7, var3, var9, arm.ab.az, arm.aa.az) && !this.b(var5, var6, var8, var7, var3, var9, arm.ac.az, arm.aa.az) && !this.b(var5, var6, var8, var7, var3, var9, arm.V.az, arm.u.az)) {
					int var10;
					int var11;
					int var12;
					int var13;
					if (var9 == arm.r.az) {
						var10 = var5[var8 + 1 + (var7 + 1 - 1) * (var3 + 2)];
						var11 = var5[var8 + 1 + 1 + (var7 + 1) * (var3 + 2)];
						var12 = var5[var8 + 1 - 1 + (var7 + 1) * (var3 + 2)];
						var13 = var5[var8 + 1 + (var7 + 1 + 1) * (var3 + 2)];
						if (var10 != arm.B.az && var11 != arm.B.az && var12 != arm.B.az && var13 != arm.B.az) {
							var6[var8 + var7 * var3] = var9;
						} else {
							var6[var8 + var7 * var3] = arm.X.az;
						}
					} else if (var9 == arm.v.az) {
						var10 = var5[var8 + 1 + (var7 + 1 - 1) * (var3 + 2)];
						var11 = var5[var8 + 1 + 1 + (var7 + 1) * (var3 + 2)];
						var12 = var5[var8 + 1 - 1 + (var7 + 1) * (var3 + 2)];
						var13 = var5[var8 + 1 + (var7 + 1 + 1) * (var3 + 2)];
						if (var10 != arm.r.az && var11 != arm.r.az && var12 != arm.r.az && var13 != arm.r.az && var10 != arm.T.az && var11 != arm.T.az && var12 != arm.T.az && var13 != arm.T.az && var10 != arm.B.az && var11 != arm.B.az && var12 != arm.B.az && var13 != arm.B.az) {
							if (var10 != arm.K.az && var13 != arm.K.az && var11 != arm.K.az && var12 != arm.K.az) {
								var6[var8 + var7 * var3] = var9;
							} else {
								var6[var8 + var7 * var3] = arm.M.az;
							}
						} else {
							var6[var8 + var7 * var3] = arm.q.az;
						}
					} else {
						var6[var8 + var7 * var3] = var9;
					}
				}
			}
		}

		return var6;
	}

	private boolean a(int[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8) {
		if (!a(var6, var7)) {
			return false;
		} else {
			int var9 = var1[var3 + 1 + (var4 + 1 - 1) * (var5 + 2)];
			int var10 = var1[var3 + 1 + 1 + (var4 + 1) * (var5 + 2)];
			int var11 = var1[var3 + 1 - 1 + (var4 + 1) * (var5 + 2)];
			int var12 = var1[var3 + 1 + (var4 + 1 + 1) * (var5 + 2)];
			if (this.b(var9, var7) && this.b(var10, var7) && this.b(var11, var7) && this.b(var12, var7)) {
				var2[var3 + var4 * var5] = var6;
			} else {
				var2[var3 + var4 * var5] = var8;
			}

			return true;
		}
	}

	private boolean b(int[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8) {
		if (var6 != var7) {
			return false;
		} else {
			int var9 = var1[var3 + 1 + (var4 + 1 - 1) * (var5 + 2)];
			int var10 = var1[var3 + 1 + 1 + (var4 + 1) * (var5 + 2)];
			int var11 = var1[var3 + 1 - 1 + (var4 + 1) * (var5 + 2)];
			int var12 = var1[var3 + 1 + (var4 + 1 + 1) * (var5 + 2)];
			if (a(var9, var7) && a(var10, var7) && a(var11, var7) && a(var12, var7)) {
				var2[var3 + var4 * var5] = var6;
			} else {
				var2[var3 + var4 * var5] = var8;
			}

			return true;
		}
	}

	private boolean b(int var1, int var2) {
		if (a(var1, var2)) {
			return true;
		} else {
			arm var3 = arm.e(var1);
			arm var4 = arm.e(var2);
			if (var3 != null && var4 != null) {
				arp var5 = var3.m();
				arp var6 = var4.m();
				return var5 == var6 || var5 == arp.c || var6 == arp.c;
			} else {
				return false;
			}
		}
	}
}

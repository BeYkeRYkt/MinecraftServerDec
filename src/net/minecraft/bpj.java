package net.minecraft;

public class bpj extends bpa {

	public bpj(long var1, bpa var3) {
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
				arm var10 = arm.e(var9);
				int var11;
				int var12;
				int var13;
				int var14;
				if (var9 == arm.D.az) {
					var11 = var5[var8 + 1 + (var7 + 1 - 1) * (var3 + 2)];
					var12 = var5[var8 + 1 + 1 + (var7 + 1) * (var3 + 2)];
					var13 = var5[var8 + 1 - 1 + (var7 + 1) * (var3 + 2)];
					var14 = var5[var8 + 1 + (var7 + 1 + 1) * (var3 + 2)];
					if (var11 != arm.p.az && var12 != arm.p.az && var13 != arm.p.az && var14 != arm.p.az) {
						var6[var8 + var7 * var3] = var9;
					} else {
						var6[var8 + var7 * var3] = arm.E.az;
					}
				} else if (var10 != null && var10.l() == asi.class) {
					var11 = var5[var8 + 1 + (var7 + 1 - 1) * (var3 + 2)];
					var12 = var5[var8 + 1 + 1 + (var7 + 1) * (var3 + 2)];
					var13 = var5[var8 + 1 - 1 + (var7 + 1) * (var3 + 2)];
					var14 = var5[var8 + 1 + (var7 + 1 + 1) * (var3 + 2)];
					if (this.c(var11) && this.c(var12) && this.c(var13) && this.c(var14)) {
						if (!b(var11) && !b(var12) && !b(var13) && !b(var14)) {
							var6[var8 + var7 * var3] = var9;
						} else {
							var6[var8 + var7 * var3] = arm.F.az;
						}
					} else {
						var6[var8 + var7 * var3] = arm.M.az;
					}
				} else if (var9 != arm.s.az && var9 != arm.X.az && var9 != arm.J.az) {
					if (var10 != null && var10.j()) {
						this.a(var5, var6, var8, var7, var3, var9, arm.P.az);
					} else if (var9 != arm.aa.az && var9 != arm.ab.az) {
						if (var9 != arm.p.az && var9 != arm.N.az && var9 != arm.w.az && var9 != arm.v.az) {
							var11 = var5[var8 + 1 + (var7 + 1 - 1) * (var3 + 2)];
							var12 = var5[var8 + 1 + 1 + (var7 + 1) * (var3 + 2)];
							var13 = var5[var8 + 1 - 1 + (var7 + 1) * (var3 + 2)];
							var14 = var5[var8 + 1 + (var7 + 1 + 1) * (var3 + 2)];
							if (!b(var11) && !b(var12) && !b(var13) && !b(var14)) {
								var6[var8 + var7 * var3] = var9;
							} else {
								var6[var8 + var7 * var3] = arm.F.az;
							}
						} else {
							var6[var8 + var7 * var3] = var9;
						}
					} else {
						var11 = var5[var8 + 1 + (var7 + 1 - 1) * (var3 + 2)];
						var12 = var5[var8 + 1 + 1 + (var7 + 1) * (var3 + 2)];
						var13 = var5[var8 + 1 - 1 + (var7 + 1) * (var3 + 2)];
						var14 = var5[var8 + 1 + (var7 + 1 + 1) * (var3 + 2)];
						if (!b(var11) && !b(var12) && !b(var13) && !b(var14)) {
							if (this.d(var11) && this.d(var12) && this.d(var13) && this.d(var14)) {
								var6[var8 + var7 * var3] = var9;
							} else {
								var6[var8 + var7 * var3] = arm.r.az;
							}
						} else {
							var6[var8 + var7 * var3] = var9;
						}
					}
				} else {
					this.a(var5, var6, var8, var7, var3, var9, arm.O.az);
				}
			}
		}

		return var6;
	}

	private void a(int[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7) {
		if (b(var6)) {
			var2[var3 + var4 * var5] = var6;
		} else {
			int var8 = var1[var3 + 1 + (var4 + 1 - 1) * (var5 + 2)];
			int var9 = var1[var3 + 1 + 1 + (var4 + 1) * (var5 + 2)];
			int var10 = var1[var3 + 1 - 1 + (var4 + 1) * (var5 + 2)];
			int var11 = var1[var3 + 1 + (var4 + 1 + 1) * (var5 + 2)];
			if (!b(var8) && !b(var9) && !b(var10) && !b(var11)) {
				var2[var3 + var4 * var5] = var6;
			} else {
				var2[var3 + var4 * var5] = var7;
			}

		}
	}

	private boolean c(int var1) {
		return arm.e(var1) != null && arm.e(var1).l() == asi.class ? true : var1 == arm.M.az || var1 == arm.K.az || var1 == arm.L.az || var1 == arm.t.az || var1 == arm.u.az || b(var1);
	}

	private boolean d(int var1) {
		return arm.e(var1) instanceof asj;
	}
}

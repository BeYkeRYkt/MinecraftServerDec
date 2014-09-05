package net.minecraft;

public class bos extends bpa {

	private arm[] c;
	private arm[] d;
	private arm[] e;
	private arm[] f;
	private final bgl g;

	public bos(long var1, bpa var3, LevelType var4, String var5) {
		super(var1);
		this.c = new arm[] { arm.r, arm.r, arm.r, arm.Y, arm.Y, arm.q };
		this.d = new arm[] { arm.t, arm.S, arm.s, arm.q, arm.Q, arm.v };
		this.e = new arm[] { arm.t, arm.s, arm.u, arm.q };
		this.f = new arm[] { arm.B, arm.B, arm.B, arm.T };
		this.a = var3;
		if (var4 == LevelType.DEFAULT_1_1) {
			this.c = new arm[] { arm.r, arm.t, arm.s, arm.v, arm.q, arm.u };
			this.g = null;
		} else if (var4 == LevelType.CUSTOM) {
			this.g = bgn.a(var5).b();
		} else {
			this.g = null;
		}

	}

	public int[] a(int var1, int var2, int var3, int var4) {
		int[] var5 = this.a.a(var1, var2, var3, var4);
		int[] var6 = boy.a(var3 * var4);

		for (int var7 = 0; var7 < var4; ++var7) {
			for (int var8 = 0; var8 < var3; ++var8) {
				this.a((long) (var8 + var1), (long) (var7 + var2));
				int var9 = var5[var8 + var7 * var3];
				int var10 = (var9 & 3840) >> 8;
				var9 &= -3841;
				if (this.g != null && this.g.F >= 0) {
					var6[var8 + var7 * var3] = this.g.F;
				} else if (b(var9)) {
					var6[var8 + var7 * var3] = var9;
				} else if (var9 == arm.D.az) {
					var6[var8 + var7 * var3] = var9;
				} else if (var9 == 1) {
					if (var10 > 0) {
						if (this.a(3) == 0) {
							var6[var8 + var7 * var3] = arm.ac.az;
						} else {
							var6[var8 + var7 * var3] = arm.ab.az;
						}
					} else {
						var6[var8 + var7 * var3] = this.c[this.a(this.c.length)].az;
					}
				} else if (var9 == 2) {
					if (var10 > 0) {
						var6[var8 + var7 * var3] = arm.K.az;
					} else {
						var6[var8 + var7 * var3] = this.d[this.a(this.d.length)].az;
					}
				} else if (var9 == 3) {
					if (var10 > 0) {
						var6[var8 + var7 * var3] = arm.V.az;
					} else {
						var6[var8 + var7 * var3] = this.e[this.a(this.e.length)].az;
					}
				} else if (var9 == 4) {
					var6[var8 + var7 * var3] = this.f[this.a(this.f.length)].az;
				} else {
					var6[var8 + var7 * var3] = arm.D.az;
				}
			}
		}

		return var6;
	}
}

package net.minecraft;

import java.util.Arrays;
import java.util.Random;

public class asj extends arm {

	private bec[] aD;
	private long aE;
	private bnw aF;
	private bnw aG;
	private bnw aH;
	private boolean aI;
	private boolean aJ;

	public asj(int var1, boolean var2, boolean var3) {
		super(var1);
		this.aI = var2;
		this.aJ = var3;
		this.b();
		this.a(2.0F, 0.0F);
		this.au.clear();
		this.ak = aty.m.P().a(bab.a, bac.b);
		this.al = aty.cu.P();
		this.as.A = -999;
		this.as.D = 20;
		this.as.F = 3;
		this.as.G = 5;
		this.as.B = 0;
		this.au.clear();
		if (var3) {
			this.as.A = 5;
		}

	}

	public bhc a(Random var1) {
		return this.aA;
	}

	public void a(World var1, Random var2, Position var3) {
		super.a(var1, var2, var3);
	}

	public void a(World var1, Random var2, bgk var3, int var4, int var5, double var6) {
		if (this.aD == null || this.aE != var1.J()) {
			this.a(var1.J());
		}

		if (this.aF == null || this.aG == null || this.aE != var1.J()) {
			Random var8 = new Random(this.aE);
			this.aF = new bnw(var8, 4);
			this.aG = new bnw(var8, 1);
		}

		this.aE = var1.J();
		double var22 = 0.0D;
		int var10;
		int var11;
		if (this.aI) {
			var10 = (var4 & -16) + (var5 & 15);
			var11 = (var5 & -16) + (var4 & 15);
			double var12 = Math.min(Math.abs(var6), this.aF.a((double) var10 * 0.25D, (double) var11 * 0.25D));
			if (var12 > 0.0D) {
				double var14 = 0.001953125D;
				double var16 = Math.abs(this.aG.a((double) var10 * var14, (double) var11 * var14));
				var22 = var12 * var12 * 2.5D;
				double var18 = Math.ceil(var16 * 50.0D) + 14.0D;
				if (var22 > var18) {
					var22 = var18;
				}

				var22 += 64.0D;
			}
		}

		var10 = var4 & 15;
		var11 = var5 & 15;
		boolean var23 = true;
		bec var13 = aty.cu.P();
		bec var24 = this.al;
		int var15 = (int) (var6 / 3.0D + 3.0D + var2.nextDouble() * 0.25D);
		boolean var25 = Math.cos(var6 / 3.0D * 3.141592653589793D) > 0.0D;
		int var17 = -1;
		boolean var26 = false;

		for (int var19 = 255; var19 >= 0; --var19) {
			if (var3.a(var11, var19, var10).c().r() == bof.a && var19 < (int) var22) {
				var3.a(var11, var19, var10, aty.b.P());
			}

			if (var19 <= var2.nextInt(5)) {
				var3.a(var11, var19, var10, aty.h.P());
			} else {
				bec var20 = var3.a(var11, var19, var10);
				if (var20.c().r() == bof.a) {
					var17 = -1;
				} else if (var20.c() == aty.b) {
					bec var21;
					if (var17 == -1) {
						var26 = false;
						if (var15 <= 0) {
							var13 = null;
							var24 = aty.b.P();
						} else if (var19 >= 59 && var19 <= 64) {
							var13 = aty.cu.P();
							var24 = this.al;
						}

						if (var19 < 63 && (var13 == null || var13.c().r() == bof.a)) {
							var13 = aty.j.P();
						}

						var17 = var15 + Math.max(0, var19 - 63);
						if (var19 >= 62) {
							if (this.aJ && var19 > 86 + var15 * 2) {
								if (var25) {
									var3.a(var11, var19, var10, aty.d.P().a(avc.a, avd.b));
								} else {
									var3.a(var11, var19, var10, aty.c.P());
								}
							} else if (var19 > 66 + var15) {
								if (var19 >= 64 && var19 <= 127) {
									if (var25) {
										var21 = aty.cz.P();
									} else {
										var21 = this.a(var4, var19, var5);
									}
								} else {
									var21 = aty.cu.P().a(aun.a, akv.b);
								}

								var3.a(var11, var19, var10, var21);
							} else {
								var3.a(var11, var19, var10, this.ak);
								var26 = true;
							}
						} else {
							var3.a(var11, var19, var10, var24);
							if (var24.c() == aty.cu) {
								var3.a(var11, var19, var10, var24.c().P().a(aun.a, akv.b));
							}
						}
					} else if (var17 > 0) {
						--var17;
						if (var26) {
							var3.a(var11, var19, var10, aty.cu.P().a(aun.a, akv.b));
						} else {
							var21 = this.a(var4, var19, var5);
							var3.a(var11, var19, var10, var21);
						}
					}
				}
			}
		}

	}

	private void a(long var1) {
		this.aD = new bec[64];
		Arrays.fill(this.aD, aty.cz.P());
		Random var3 = new Random(var1);
		this.aH = new bnw(var3, 1);

		int var4;
		for (var4 = 0; var4 < 64; ++var4) {
			var4 += var3.nextInt(5) + 1;
			if (var4 < 64) {
				this.aD[var4] = aty.cu.P().a(aun.a, akv.b);
			}
		}

		var4 = var3.nextInt(4) + 2;

		int var5;
		int var6;
		int var7;
		int var8;
		for (var5 = 0; var5 < var4; ++var5) {
			var6 = var3.nextInt(3) + 1;
			var7 = var3.nextInt(64);

			for (var8 = 0; var7 + var8 < 64 && var8 < var6; ++var8) {
				this.aD[var7 + var8] = aty.cu.P().a(aun.a, akv.e);
			}
		}

		var5 = var3.nextInt(4) + 2;

		int var9;
		for (var6 = 0; var6 < var5; ++var6) {
			var7 = var3.nextInt(3) + 2;
			var8 = var3.nextInt(64);

			for (var9 = 0; var8 + var9 < 64 && var9 < var7; ++var9) {
				this.aD[var8 + var9] = aty.cu.P().a(aun.a, akv.m);
			}
		}

		var6 = var3.nextInt(4) + 2;

		for (var7 = 0; var7 < var6; ++var7) {
			var8 = var3.nextInt(3) + 1;
			var9 = var3.nextInt(64);

			for (int var10 = 0; var9 + var10 < 64 && var10 < var8; ++var10) {
				this.aD[var9 + var10] = aty.cu.P().a(aun.a, akv.o);
			}
		}

		var7 = var3.nextInt(3) + 3;
		var8 = 0;

		for (var9 = 0; var9 < var7; ++var9) {
			byte var12 = 1;
			var8 += var3.nextInt(16) + 4;

			for (int var11 = 0; var8 + var11 < 64 && var11 < var12; ++var11) {
				this.aD[var8 + var11] = aty.cu.P().a(aun.a, akv.a);
				if (var8 + var11 > 1 && var3.nextBoolean()) {
					this.aD[var8 + var11 - 1] = aty.cu.P().a(aun.a, akv.i);
				}

				if (var8 + var11 < 63 && var3.nextBoolean()) {
					this.aD[var8 + var11 + 1] = aty.cu.P().a(aun.a, akv.i);
				}
			}
		}

	}

	private bec a(int var1, int var2, int var3) {
		int var4 = (int) Math.round(this.aH.a((double) var1 * 1.0D / 512.0D, (double) var1 * 1.0D / 512.0D) * 2.0D);
		return this.aD[(var2 + var4 + 64) % 64];
	}

	protected arm d(int var1) {
		boolean var2 = this.az == arm.aa.az;
		asj var3 = new asj(var1, var2, this.aJ);
		if (!var2) {
			var3.a(g);
			var3.a(this.ah + " M");
		} else {
			var3.a(this.ah + " (Bryce)");
		}

		var3.a(this.ai, true);
		return var3;
	}
}

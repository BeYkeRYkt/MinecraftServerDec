package net.minecraft;

import java.util.Random;

public class bip extends bhc {

	public bip() {
		super(false);
	}

	public boolean b(World var1, Random var2, dt var3) {
		int var4;
		for (var4 = var2.nextInt(4) + 5; var1.p(var3.b()).c().r() == bof.h; var3 = var3.b()) {
			;
		}

		boolean var5 = true;
		if (var3.o() >= 1 && var3.o() + var4 + 1 <= 256) {
			int var8;
			int var9;
			for (int var6 = var3.o(); var6 <= var3.o() + 1 + var4; ++var6) {
				byte var7 = 1;
				if (var6 == var3.o()) {
					var7 = 0;
				}

				if (var6 >= var3.o() + 1 + var4 - 2) {
					var7 = 3;
				}

				for (var8 = var3.n() - var7; var8 <= var3.n() + var7 && var5; ++var8) {
					for (var9 = var3.p() - var7; var9 <= var3.p() + var7 && var5; ++var9) {
						if (var6 >= 0 && var6 < 256) {
							atr var10 = var1.p(new dt(var8, var6, var9)).c();
							if (var10.r() != bof.a && var10.r() != bof.j) {
								if (var10 != aty.j && var10 != aty.i) {
									var5 = false;
								} else if (var6 > var3.o()) {
									var5 = false;
								}
							}
						} else {
							var5 = false;
						}
					}
				}
			}

			if (!var5) {
				return false;
			} else {
				atr var17 = var1.p(var3.b()).c();
				if ((var17 == aty.c || var17 == aty.d) && var3.o() < 256 - var4 - 1) {
					this.a(var1, var3.b());

					int var11;
					dt var14;
					int var18;
					int var20;
					for (var18 = var3.o() - 3 + var4; var18 <= var3.o() + var4; ++var18) {
						var8 = var18 - (var3.o() + var4);
						var9 = 2 - var8 / 2;

						for (var20 = var3.n() - var9; var20 <= var3.n() + var9; ++var20) {
							var11 = var20 - var3.n();

							for (int var12 = var3.p() - var9; var12 <= var3.p() + var9; ++var12) {
								int var13 = var12 - var3.p();
								if (Math.abs(var11) != var9 || Math.abs(var13) != var9 || var2.nextInt(2) != 0 && var8 != 0) {
									var14 = new dt(var20, var18, var12);
									if (!var1.p(var14).c().m()) {
										this.a(var1, var14, aty.t);
									}
								}
							}
						}
					}

					for (var18 = 0; var18 < var4; ++var18) {
						atr var19 = var1.p(var3.b(var18)).c();
						if (var19.r() == bof.a || var19.r() == bof.j || var19 == aty.i || var19 == aty.j) {
							this.a(var1, var3.b(var18), aty.r);
						}
					}

					for (var18 = var3.o() - 3 + var4; var18 <= var3.o() + var4; ++var18) {
						var8 = var18 - (var3.o() + var4);
						var9 = 2 - var8 / 2;

						for (var20 = var3.n() - var9; var20 <= var3.n() + var9; ++var20) {
							for (var11 = var3.p() - var9; var11 <= var3.p() + var9; ++var11) {
								dt var21 = new dt(var20, var18, var11);
								if (var1.p(var21).c().r() == bof.j) {
									dt var22 = var21.e();
									var14 = var21.f();
									dt var15 = var21.c();
									dt var16 = var21.d();
									if (var2.nextInt(4) == 0 && var1.p(var22).c().r() == bof.a) {
										this.a(var1, var22, bbv.S);
									}

									if (var2.nextInt(4) == 0 && var1.p(var14).c().r() == bof.a) {
										this.a(var1, var14, bbv.T);
									}

									if (var2.nextInt(4) == 0 && var1.p(var15).c().r() == bof.a) {
										this.a(var1, var15, bbv.Q);
									}

									if (var2.nextInt(4) == 0 && var1.p(var16).c().r() == bof.a) {
										this.a(var1, var16, bbv.R);
									}
								}
							}
						}
					}

					return true;
				} else {
					return false;
				}
			}
		} else {
			return false;
		}
	}

	private void a(World var1, dt var2, int var3) {
		this.a(var1, var2, aty.bn, var3);
		int var4 = 4;

		for (var2 = var2.b(); var1.p(var2).c().r() == bof.a && var4 > 0; --var4) {
			this.a(var1, var2, aty.bn, var3);
			var2 = var2.b();
		}

	}
}

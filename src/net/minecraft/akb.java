package net.minecraft;

public class akb extends alq {

	private atr a;

	public akb(atr var1) {
		this.h = 1;
		this.a = var1;
		this.a(akf.f);
	}

	public amj a(amj var1, World var2, ahd var3) {
		boolean var4 = this.a == aty.a;
		bru var5 = this.a(var2, var3, var4);
		if (var5 == null) {
			return var1;
		} else {
			if (var5.a == brv.b) {
				dt var6 = var5.a();
				if (!var2.a(var3, var6)) {
					return var1;
				}

				if (var4) {
					if (!var3.a(var6.a(var5.b), var5.b, var1)) {
						return var1;
					}

					bec var7 = var2.p(var6);
					bof var8 = var7.c().r();
					if (var8 == bof.h && ((Integer) var7.b(axl.b)).intValue() == 0) {
						var2.g(var6);
						var3.b(ty.J[alq.b((alq) this)]);
						return this.a(var1, var3, amk.ax);
					}

					if (var8 == bof.i && ((Integer) var7.b(axl.b)).intValue() == 0) {
						var2.g(var6);
						var3.b(ty.J[alq.b((alq) this)]);
						return this.a(var1, var3, amk.ay);
					}
				} else {
					if (this.a == aty.a) {
						return new amj(amk.aw);
					}

					dt var9 = var6.a(var5.b);
					if (!var3.a(var9, var5.b, var1)) {
						return var1;
					}

					if (this.a(var2, var9) && !var3.by.d) {
						var3.b(ty.J[alq.b((alq) this)]);
						return new amj(amk.aw);
					}
				}
			}

			return var1;
		}
	}

	private amj a(amj var1, ahd var2, alq var3) {
		if (var2.by.d) {
			return var1;
		} else if (--var1.b <= 0) {
			return new amj(var3);
		} else {
			if (!var2.bg.a(new amj(var3))) {
				var2.a(new amj(var3, 1, 0), false);
			}

			return var1;
		}
	}

	public boolean a(World var1, dt var2) {
		if (this.a == aty.a) {
			return false;
		} else {
			bof var3 = var1.p(var2).c().r();
			boolean var4 = !var3.a();
			if (!var1.d(var2) && !var4) {
				return false;
			} else {
				if (var1.t.n() && this.a == aty.i) {
					int var5 = var2.n();
					int var6 = var2.o();
					int var7 = var2.p();
					var1.a((double) ((float) var5 + 0.5F), (double) ((float) var6 + 0.5F), (double) ((float) var7 + 0.5F), "random.fizz", 0.5F, 2.6F + (var1.s.nextFloat() - var1.s.nextFloat()) * 0.8F);

					for (int var8 = 0; var8 < 8; ++var8) {
						var1.a(ew.m, (double) var5 + Math.random(), (double) var6 + Math.random(), (double) var7 + Math.random(), 0.0D, 0.0D, 0.0D, new int[0]);
					}
				} else {
					if (!var1.D && var4 && !var3.d()) {
						var1.b(var2, true);
					}

					var1.a(var2, this.a.P(), 3);
				}

				return true;
			}
		}
	}
}

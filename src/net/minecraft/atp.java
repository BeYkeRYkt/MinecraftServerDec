package net.minecraft;

import java.util.Iterator;
import java.util.Random;

public class atp extends avb {

	public static final bev a = bev.a("part", atq.class);
	public static final bet b = bet.a("occupied");

	public atp() {
		super(bof.n);
		this.j(this.L.b().a(a, atq.b).a(b, Boolean.valueOf(false)));
		this.j();
	}

	public boolean a(World var1, dt var2, bec var3, ahd var4, ej var5, float var6, float var7, float var8) {
		if (var1.D) {
			return true;
		} else {
			if (var3.b(a) != atq.a) {
				var2 = var2.a((ej) var3.b(N));
				var3 = var1.p(var2);
				if (var3.c() != this) {
					return true;
				}
			}

			if (var1.t.e() && var1.b(var2) != arm.x) {
				if (((Boolean) var3.b(b)).booleanValue()) {
					ahd var10 = this.e(var1, var2);
					if (var10 != null) {
						var4.b((ho) (new hz("tile.bed.occupied", new Object[0])));
						return true;
					}

					var3 = var3.a(b, Boolean.valueOf(false));
					var1.a(var2, var3, 4);
				}

				ahf var11 = var4.a(var2);
				if (var11 == ahf.a) {
					var3 = var3.a(b, Boolean.valueOf(true));
					var1.a(var2, var3, 4);
					return true;
				} else {
					if (var11 == ahf.c) {
						var4.b((ho) (new hz("tile.bed.noSleep", new Object[0])));
					} else if (var11 == ahf.f) {
						var4.b((ho) (new hz("tile.bed.notSafe", new Object[0])));
					}

					return true;
				}
			} else {
				var1.g(var2);
				dt var9 = var2.a(((ej) var3.b(N)).d());
				if (var1.p(var9).c() == this) {
					var1.g(var9);
				}

				var1.a((Entity) null, (double) var2.n() + 0.5D, (double) var2.o() + 0.5D, (double) var2.p() + 0.5D, 5.0F, true, true);
				return true;
			}
		}
	}

	private ahd e(World var1, dt var2) {
		Iterator var3 = var1.j.iterator();

		ahd var4;
		do {
			if (!var3.hasNext()) {
				return null;
			}

			var4 = (ahd) var3.next();
		} while (!var4.bI() || !var4.bv.equals(var2));

		return var4;
	}

	public boolean d() {
		return false;
	}

	public boolean c() {
		return false;
	}

	public void a(ard var1, dt var2) {
		this.j();
	}

	public void a(World var1, dt var2, bec var3, atr var4) {
		ej var5 = (ej) var3.b(N);
		if (var3.b(a) == atq.a) {
			if (var1.p(var2.a(var5.d())).c() != this) {
				var1.g(var2);
			}
		} else if (var1.p(var2.a(var5)).c() != this) {
			var1.g(var2);
			if (!var1.D) {
				this.b(var1, var2, var3, 0);
			}
		}

	}

	public alq a(bec var1, Random var2, int var3) {
		return var1.b(a) == atq.a ? null : amk.ba;
	}

	private void j() {
		this.a(0.0F, 0.0F, 0.0F, 1.0F, 0.5625F, 1.0F);
	}

	public static dt a(World var0, dt var1, int var2) {
		ej var3 = (ej) var0.p(var1).b(N);
		int var4 = var1.n();
		int var5 = var1.o();
		int var6 = var1.p();

		for (int var7 = 0; var7 <= 1; ++var7) {
			int var8 = var4 - var3.g() * var7 - 1;
			int var9 = var6 - var3.i() * var7 - 1;
			int var10 = var8 + 2;
			int var11 = var9 + 2;

			for (int var12 = var8; var12 <= var10; ++var12) {
				for (int var13 = var9; var13 <= var11; ++var13) {
					dt var14 = new dt(var12, var5, var13);
					if (d(var0, var14)) {
						if (var2 <= 0) {
							return var14;
						}

						--var2;
					}
				}
			}
		}

		return null;
	}

	protected static boolean d(World var0, dt var1) {
		return World.a((ard) var0, var1.b()) && !var0.p(var1).c().r().a() && !var0.p(var1.a()).c().r().a();
	}

	public void a(World var1, dt var2, bec var3, float var4, int var5) {
		if (var3.b(a) == atq.b) {
			super.a(var1, var2, var3, var4, 0);
		}

	}

	public int i() {
		return 1;
	}

	public void a(World var1, dt var2, bec var3, ahd var4) {
		if (var4.by.d && var3.b(a) == atq.a) {
			dt var5 = var2.a(((ej) var3.b(N)).d());
			if (var1.p(var5).c() == this) {
				var1.g(var5);
			}
		}

	}

	public bec a(int var1) {
		ej var2 = ej.b(var1);
		return (var1 & 8) > 0 ? this.P().a(a, atq.a).a(N, var2).a(b, Boolean.valueOf((var1 & 4) > 0)) : this.P().a(a, atq.b).a(N, var2);
	}

	public bec a(bec var1, ard var2, dt var3) {
		if (var1.b(a) == atq.b) {
			bec var4 = var2.p(var3.a((ej) var1.b(N)));
			if (var4.c() == this) {
				var1 = var1.a(b, var4.b(b));
			}
		}

		return var1;
	}

	public int c(bec var1) {
		byte var2 = 0;
		int var3 = var2 | ((ej) var1.b(N)).b();
		if (var1.b(a) == atq.a) {
			var3 |= 8;
			if (((Boolean) var1.b(b)).booleanValue()) {
				var3 |= 4;
			}
		}

		return var3;
	}

	protected bed e() {
		return new bed(this, new bex[] { N, a, b });
	}

}

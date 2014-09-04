package net.minecraft;

import java.util.List;
import java.util.Random;

abstract class bnn extends bms {

	protected int h = -1;
	private int a;
	private boolean b;

	public bnn() {
	}

	protected bnn(bnk var1, int var2) {
		super(var2);
		if (var1 != null) {
			this.b = var1.b;
		}

	}

	protected void a(NBTCompoundTag var1) {
		var1.put("HPos", this.h);
		var1.put("VCount", this.a);
		var1.put("Desert", this.b);
	}

	protected void b(NBTCompoundTag var1) {
		this.h = var1.f("HPos");
		this.a = var1.f("VCount");
		this.b = var1.n("Desert");
	}

	protected bms a(bnk var1, List var2, Random var3, int var4, int var5) {
		if (this.m != null) {
			switch (bmz.a[this.m.ordinal()]) {
				case 1:
					return bmy.a(var1, var2, var3, this.l.a - 1, this.l.b + var4, this.l.c + var5, ej.e, this.d());
				case 2:
					return bmy.a(var1, var2, var3, this.l.a - 1, this.l.b + var4, this.l.c + var5, ej.e, this.d());
				case 3:
					return bmy.a(var1, var2, var3, this.l.a + var5, this.l.b + var4, this.l.c - 1, ej.c, this.d());
				case 4:
					return bmy.a(var1, var2, var3, this.l.a + var5, this.l.b + var4, this.l.c - 1, ej.c, this.d());
			}
		}

		return null;
	}

	protected bms b(bnk var1, List var2, Random var3, int var4, int var5) {
		if (this.m != null) {
			switch (bmz.a[this.m.ordinal()]) {
				case 1:
					return bmy.a(var1, var2, var3, this.l.d + 1, this.l.b + var4, this.l.c + var5, ej.f, this.d());
				case 2:
					return bmy.a(var1, var2, var3, this.l.d + 1, this.l.b + var4, this.l.c + var5, ej.f, this.d());
				case 3:
					return bmy.a(var1, var2, var3, this.l.a + var5, this.l.b + var4, this.l.f + 1, ej.d, this.d());
				case 4:
					return bmy.a(var1, var2, var3, this.l.a + var5, this.l.b + var4, this.l.f + 1, ej.d, this.d());
			}
		}

		return null;
	}

	protected int b(World var1, bjb var2) {
		int var3 = 0;
		int var4 = 0;

		for (int var5 = this.l.c; var5 <= this.l.f; ++var5) {
			for (int var6 = this.l.a; var6 <= this.l.d; ++var6) {
				dt var7 = new dt(var6, 64, var5);
				if (var2.b((fd) var7)) {
					var3 += Math.max(var1.r(var7).o(), var1.t.i());
					++var4;
				}
			}
		}

		if (var4 == 0) {
			return -1;
		} else {
			return var3 / var4;
		}
	}

	protected static boolean a(bjb var0) {
		return var0 != null && var0.b > 10;
	}

	protected void a(World var1, bjb var2, int var3, int var4, int var5, int var6) {
		if (this.a < var6) {
			for (int var7 = this.a; var7 < var6; ++var7) {
				int var8 = this.a(var3 + var7, var5);
				int var9 = this.d(var4);
				int var10 = this.b(var3 + var7, var5);
				if (!var2.b((fd) (new dt(var8, var9, var10)))) {
					break;
				}

				++this.a;
				agp var11 = new agp(var1);
				var11.b((double) var8 + 0.5D, (double) var9, (double) var10 + 0.5D, 0.0F, 0.0F);
				var11.a(var1.E(new dt(var11)), (xq) null);
				var11.r(this.c(var7, var11.cj()));
				var1.d((Entity) var11);
			}

		}
	}

	protected int c(int var1, int var2) {
		return var2;
	}

	protected bec a(bec var1) {
		if (this.b) {
			if (var1.c() == aty.r || var1.c() == aty.s) {
				return aty.A.P();
			}

			if (var1.c() == aty.e) {
				return aty.A.a(bae.a.a());
			}

			if (var1.c() == aty.f) {
				return aty.A.a(bae.c.a());
			}

			if (var1.c() == aty.ad) {
				return aty.bO.P().a(bat.a, var1.b(bat.a));
			}

			if (var1.c() == aty.aw) {
				return aty.bO.P().a(bat.a, var1.b(bat.a));
			}

			if (var1.c() == aty.n) {
				return aty.A.P();
			}
		}

		return var1;
	}

	protected void a(World var1, bec var2, int var3, int var4, int var5, bjb var6) {
		bec var7 = this.a(var2);
		super.a(var1, var7, var3, var4, var5, var6);
	}

	protected void a(World var1, bjb var2, int var3, int var4, int var5, int var6, int var7, int var8, bec var9, bec var10, boolean var11) {
		bec var12 = this.a(var9);
		bec var13 = this.a(var10);
		super.a(var1, var2, var3, var4, var5, var6, var7, var8, var12, var13, var11);
	}

	protected void b(World var1, bec var2, int var3, int var4, int var5, bjb var6) {
		bec var7 = this.a(var2);
		super.b(var1, var7, var3, var4, var5, var6);
	}

	protected void a(boolean var1) {
		this.b = var1;
	}
}

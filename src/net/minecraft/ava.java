package net.minecraft;

import java.util.Random;

public abstract class ava extends avb {

	protected final boolean M;

	protected ava(boolean var1) {
		super(bof.q);
		this.M = var1;
		this.a(0.0F, 0.0F, 0.0F, 1.0F, 0.125F, 1.0F);
	}

	public boolean d() {
		return false;
	}

	public boolean c(World var1, dt var2) {
		return World.a((ard) var1, var2.b()) ? super.c(var1, var2) : false;
	}

	public boolean d(World var1, dt var2) {
		return World.a((ard) var1, var2.b());
	}

	public void a(World var1, dt var2, bec var3, Random var4) {
	}

	public void b(World var1, dt var2, bec var3, Random var4) {
		if (!this.b((ard) var1, var2, var3)) {
			boolean var5 = this.e(var1, var2, var3);
			if (this.M && !var5) {
				var1.a(var2, this.k(var3), 2);
			} else if (!this.M) {
				var1.a(var2, this.e(var3), 2);
				if (!var5) {
					var1.a(var2, this.e(var3).c(), this.m(var3), -1);
				}
			}

		}
	}

	protected boolean l(bec var1) {
		return this.M;
	}

	public int b(ard var1, dt var2, bec var3, ej var4) {
		return this.a(var1, var2, var3, var4);
	}

	public int a(ard var1, dt var2, bec var3, ej var4) {
		return !this.l(var3) ? 0 : (var3.b(N) == var4 ? this.a(var1, var2, var3) : 0);
	}

	public void a(World var1, dt var2, bec var3, atr var4) {
		if (this.d(var1, var2)) {
			this.g(var1, var2, var3);
		} else {
			this.b(var1, var2, var3, 0);
			var1.g(var2);
			ej[] var5 = ej.values();
			int var6 = var5.length;

			for (int var7 = 0; var7 < var6; ++var7) {
				ej var8 = var5[var7];
				var1.c(var2.a(var8), (atr) this);
			}

		}
	}

	protected void g(World var1, dt var2, bec var3) {
		if (!this.b((ard) var1, var2, var3)) {
			boolean var4 = this.e(var1, var2, var3);
			if ((this.M && !var4 || !this.M && var4) && !var1.a(var2, (atr) this)) {
				byte var5 = -1;
				if (this.i(var1, var2, var3)) {
					var5 = -3;
				} else if (this.M) {
					var5 = -2;
				}

				var1.a(var2, this, this.d(var3), var5);
			}

		}
	}

	public boolean b(ard var1, dt var2, bec var3) {
		return false;
	}

	protected boolean e(World var1, dt var2, bec var3) {
		return this.f(var1, var2, var3) > 0;
	}

	protected int f(World var1, dt var2, bec var3) {
		ej var4 = (ej) var3.b(N);
		dt var5 = var2.a(var4);
		int var6 = var1.c(var5, var4);
		if (var6 >= 15) {
			return var6;
		} else {
			bec var7 = var1.p(var5);
			return Math.max(var6, var7.c() == aty.af ? ((Integer) var7.b(azt.O)).intValue() : 0);
		}
	}

	protected int c(ard var1, dt var2, bec var3) {
		ej var4 = (ej) var3.b(N);
		ej var5 = var4.e();
		ej var6 = var4.f();
		return Math.max(this.c(var1, var2.a(var5), var5), this.c(var1, var2.a(var6), var6));
	}

	protected int c(ard var1, dt var2, ej var3) {
		bec var4 = var1.p(var2);
		atr var5 = var4.c();
		return this.c(var5) ? (var5 == aty.af ? ((Integer) var4.b(azt.O)).intValue() : var1.a(var2, var3)) : 0;
	}

	public boolean g() {
		return true;
	}

	public bec a(World var1, dt var2, ej var3, float var4, float var5, float var6, int var7, EntityLiving var8) {
		return this.P().a(N, var8.aO().d());
	}

	public void a(World var1, dt var2, bec var3, EntityLiving var4, amj var5) {
		if (this.e(var1, var2, var3)) {
			var1.a(var2, (atr) this, 1);
		}

	}

	public void c(World var1, dt var2, bec var3) {
		this.h(var1, var2, var3);
	}

	protected void h(World var1, dt var2, bec var3) {
		ej var4 = (ej) var3.b(N);
		dt var5 = var2.a(var4.d());
		var1.d(var5, this);
		var1.a(var5, (atr) this, var4);
	}

	public void d(World var1, dt var2, bec var3) {
		if (this.M) {
			ej[] var4 = ej.values();
			int var5 = var4.length;

			for (int var6 = 0; var6 < var5; ++var6) {
				ej var7 = var4[var6];
				var1.c(var2.a(var7), (atr) this);
			}
		}

		super.d(var1, var2, var3);
	}

	public boolean c() {
		return false;
	}

	protected boolean c(atr var1) {
		return var1.g();
	}

	protected int a(ard var1, dt var2, bec var3) {
		return 15;
	}

	public static boolean d(atr var0) {
		return aty.bb.e(var0) || aty.cj.e(var0);
	}

	public boolean e(atr var1) {
		return var1 == this.e(this.P()).c() || var1 == this.k(this.P()).c();
	}

	public boolean i(World var1, dt var2, bec var3) {
		ej var4 = ((ej) var3.b(N)).d();
		dt var5 = var2.a(var4);
		return d(var1.p(var5).c()) ? var1.p(var5).b(N) != var4 : false;
	}

	protected int m(bec var1) {
		return this.d(var1);
	}

	protected abstract int d(bec var1);

	protected abstract bec e(bec var1);

	protected abstract bec k(bec var1);

	public boolean b(atr var1) {
		return this.e(var1);
	}
}

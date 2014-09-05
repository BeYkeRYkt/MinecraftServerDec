package net.minecraft;

import java.util.Random;

public class bax extends axl {

	protected bax(bof var1) {
		super(var1);
		this.a(false);
		if (var1 == bof.i) {
			this.a(true);
		}

	}

	public void a(World var1, Position var2, bec var3, Block var4) {
		if (!this.e(var1, var2, var3)) {
			this.f(var1, var2, var3);
		}

	}

	private void f(World var1, Position var2, bec var3) {
		avn var4 = a(this.J);
		var1.a(var2, var4.P().a(b, var3.b(b)), 2);
		var1.a(var2, (Block) var4, this.a(var1));
	}

	public void b(World var1, Position var2, bec var3, Random var4) {
		if (this.J == bof.i) {
			if (var1.Q().b("doFireTick")) {
				int var5 = var4.nextInt(3);
				if (var5 > 0) {
					Position var6 = var2;

					for (int var7 = 0; var7 < var5; ++var7) {
						var6 = var6.a(var4.nextInt(3) - 1, 1, var4.nextInt(3) - 1);
						Block var8 = var1.p(var6).c();
						if (var8.J == bof.a) {
							if (this.e(var1, var6)) {
								var1.a(var6, aty.ab.P());
								return;
							}
						} else if (var8.J.c()) {
							return;
						}
					}
				} else {
					for (int var9 = 0; var9 < 3; ++var9) {
						Position var10 = var2.a(var4.nextInt(3) - 1, 0, var4.nextInt(3) - 1);
						if (var1.d(var10.a()) && this.m(var1, var10)) {
							var1.a(var10.a(), aty.ab.P());
						}
					}
				}

			}
		}
	}

	protected boolean e(World var1, Position var2) {
		ej[] var3 = ej.values();
		int var4 = var3.length;

		for (int var5 = 0; var5 < var4; ++var5) {
			ej var6 = var3[var5];
			if (this.m(var1, var2.a(var6))) {
				return true;
			}
		}

		return false;
	}

	private boolean m(World var1, Position var2) {
		return var1.p(var2).c().r().h();
	}
}

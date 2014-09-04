package net.minecraft;

import java.util.List;
import java.util.Random;

public class bni extends bnn {

	public bni() {
	}

	public bni(bnk var1, int var2, Random var3, bjb var4, ej var5) {
		super(var1, var2);
		this.m = var5;
		this.l = var4;
	}

	public static bni a(bnk var0, List var1, Random var2, int var3, int var4, int var5, ej var6, int var7) {
		bjb var8 = bjb.a(var3, var4, var5, 0, 0, 0, 5, 12, 9, var6);
		return a(var8) && bms.a(var1, var8) == null ? new bni(var0, var7, var2, var8, var6) : null;
	}

	public boolean a(World var1, Random var2, bjb var3) {
		if (this.h < 0) {
			this.h = this.b(var1, var3);
			if (this.h < 0) {
				return true;
			}

			this.l.a(0, this.h - this.l.e + 12 - 1, 0);
		}

		this.a(var1, var3, 1, 1, 1, 3, 3, 7, aty.a.P(), aty.a.P(), false);
		this.a(var1, var3, 1, 5, 1, 3, 9, 3, aty.a.P(), aty.a.P(), false);
		this.a(var1, var3, 1, 0, 0, 3, 0, 8, aty.e.P(), aty.e.P(), false);
		this.a(var1, var3, 1, 1, 0, 3, 10, 0, aty.e.P(), aty.e.P(), false);
		this.a(var1, var3, 0, 1, 1, 0, 10, 3, aty.e.P(), aty.e.P(), false);
		this.a(var1, var3, 4, 1, 1, 4, 10, 3, aty.e.P(), aty.e.P(), false);
		this.a(var1, var3, 0, 0, 4, 0, 4, 7, aty.e.P(), aty.e.P(), false);
		this.a(var1, var3, 4, 0, 4, 4, 4, 7, aty.e.P(), aty.e.P(), false);
		this.a(var1, var3, 1, 1, 8, 3, 4, 8, aty.e.P(), aty.e.P(), false);
		this.a(var1, var3, 1, 5, 4, 3, 10, 4, aty.e.P(), aty.e.P(), false);
		this.a(var1, var3, 1, 5, 5, 3, 5, 7, aty.e.P(), aty.e.P(), false);
		this.a(var1, var3, 0, 9, 0, 4, 9, 4, aty.e.P(), aty.e.P(), false);
		this.a(var1, var3, 0, 4, 0, 4, 4, 4, aty.e.P(), aty.e.P(), false);
		this.a(var1, aty.e.P(), 0, 11, 2, var3);
		this.a(var1, aty.e.P(), 4, 11, 2, var3);
		this.a(var1, aty.e.P(), 2, 11, 0, var3);
		this.a(var1, aty.e.P(), 2, 11, 4, var3);
		this.a(var1, aty.e.P(), 1, 1, 6, var3);
		this.a(var1, aty.e.P(), 1, 1, 7, var3);
		this.a(var1, aty.e.P(), 2, 1, 7, var3);
		this.a(var1, aty.e.P(), 3, 1, 6, var3);
		this.a(var1, aty.e.P(), 3, 1, 7, var3);
		this.a(var1, aty.aw.a(this.a(aty.aw, 3)), 1, 1, 5, var3);
		this.a(var1, aty.aw.a(this.a(aty.aw, 3)), 2, 1, 6, var3);
		this.a(var1, aty.aw.a(this.a(aty.aw, 3)), 3, 1, 5, var3);
		this.a(var1, aty.aw.a(this.a(aty.aw, 1)), 1, 2, 7, var3);
		this.a(var1, aty.aw.a(this.a(aty.aw, 0)), 3, 2, 7, var3);
		this.a(var1, aty.bj.P(), 0, 2, 2, var3);
		this.a(var1, aty.bj.P(), 0, 3, 2, var3);
		this.a(var1, aty.bj.P(), 4, 2, 2, var3);
		this.a(var1, aty.bj.P(), 4, 3, 2, var3);
		this.a(var1, aty.bj.P(), 0, 6, 2, var3);
		this.a(var1, aty.bj.P(), 0, 7, 2, var3);
		this.a(var1, aty.bj.P(), 4, 6, 2, var3);
		this.a(var1, aty.bj.P(), 4, 7, 2, var3);
		this.a(var1, aty.bj.P(), 2, 6, 0, var3);
		this.a(var1, aty.bj.P(), 2, 7, 0, var3);
		this.a(var1, aty.bj.P(), 2, 6, 4, var3);
		this.a(var1, aty.bj.P(), 2, 7, 4, var3);
		this.a(var1, aty.bj.P(), 0, 3, 6, var3);
		this.a(var1, aty.bj.P(), 4, 3, 6, var3);
		this.a(var1, aty.bj.P(), 2, 3, 8, var3);
		this.a(var1, aty.aa.P().a(bbl.a, this.m.d()), 2, 4, 7, var3);
		this.a(var1, aty.aa.P().a(bbl.a, this.m.e()), 1, 4, 6, var3);
		this.a(var1, aty.aa.P().a(bbl.a, this.m.f()), 3, 4, 6, var3);
		this.a(var1, aty.aa.P().a(bbl.a, this.m), 2, 4, 5, var3);
		int var4 = this.a(aty.au, 4);

		int var5;
		for (var5 = 1; var5 <= 9; ++var5) {
			this.a(var1, aty.au.a(var4), 3, var5, 3, var3);
		}

		this.a(var1, aty.a.P(), 2, 1, 0, var3);
		this.a(var1, aty.a.P(), 2, 2, 0, var3);
		this.a(var1, var3, var2, 2, 1, 0, ej.b(this.a(aty.ao, 1)));
		if (this.a(var1, 2, 0, -1, var3).c().r() == bof.a && this.a(var1, 2, -1, -1, var3).c().r() != bof.a) {
			this.a(var1, aty.aw.a(this.a(aty.aw, 3)), 2, 0, -1, var3);
		}

		for (var5 = 0; var5 < 9; ++var5) {
			for (int var6 = 0; var6 < 5; ++var6) {
				this.b(var1, var6, 12, var5, var3);
				this.b(var1, aty.e.P(), var6, -1, var5, var3);
			}
		}

		this.a(var1, var3, 2, 1, 2, 1);
		return true;
	}

	protected int c(int var1, int var2) {
		return 2;
	}
}

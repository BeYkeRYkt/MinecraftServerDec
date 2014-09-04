package net.minecraft;

import java.util.List;
import java.util.Random;

public class bnp extends bnn {

	public bnp() {
	}

	public bnp(bnk var1, int var2, Random var3, int var4, int var5) {
		super(var1, var2);
		this.m = en.a.a(var3);
		switch (bmz.a[this.m.ordinal()]) {
			case 1:
			case 2:
				this.l = new bjb(var4, 64, var5, var4 + 6 - 1, 78, var5 + 6 - 1);
				break;
			default:
				this.l = new bjb(var4, 64, var5, var4 + 6 - 1, 78, var5 + 6 - 1);
		}

	}

	public void a(bms var1, List var2, Random var3) {
		bmy.b((bnk) var1, var2, var3, this.l.a - 1, this.l.e - 4, this.l.c + 1, ej.e, this.d());
		bmy.b((bnk) var1, var2, var3, this.l.d + 1, this.l.e - 4, this.l.c + 1, ej.f, this.d());
		bmy.b((bnk) var1, var2, var3, this.l.a + 1, this.l.e - 4, this.l.c - 1, ej.c, this.d());
		bmy.b((bnk) var1, var2, var3, this.l.a + 1, this.l.e - 4, this.l.f + 1, ej.d, this.d());
	}

	public boolean a(World var1, Random var2, bjb var3) {
		if (this.h < 0) {
			this.h = this.b(var1, var3);
			if (this.h < 0) {
				return true;
			}

			this.l.a(0, this.h - this.l.e + 3, 0);
		}

		this.a(var1, var3, 1, 0, 1, 4, 12, 4, aty.e.P(), aty.i.P(), false);
		this.a(var1, aty.a.P(), 2, 12, 2, var3);
		this.a(var1, aty.a.P(), 3, 12, 2, var3);
		this.a(var1, aty.a.P(), 2, 12, 3, var3);
		this.a(var1, aty.a.P(), 3, 12, 3, var3);
		this.a(var1, aty.aO.P(), 1, 13, 1, var3);
		this.a(var1, aty.aO.P(), 1, 14, 1, var3);
		this.a(var1, aty.aO.P(), 4, 13, 1, var3);
		this.a(var1, aty.aO.P(), 4, 14, 1, var3);
		this.a(var1, aty.aO.P(), 1, 13, 4, var3);
		this.a(var1, aty.aO.P(), 1, 14, 4, var3);
		this.a(var1, aty.aO.P(), 4, 13, 4, var3);
		this.a(var1, aty.aO.P(), 4, 14, 4, var3);
		this.a(var1, var3, 1, 15, 1, 4, 15, 4, aty.e.P(), aty.e.P(), false);

		for (int var4 = 0; var4 <= 5; ++var4) {
			for (int var5 = 0; var5 <= 5; ++var5) {
				if (var5 == 0 || var5 == 5 || var4 == 0 || var4 == 5) {
					this.a(var1, aty.n.P(), var5, 11, var4, var3);
					this.b(var1, var5, 12, var4, var3);
				}
			}
		}

		return true;
	}
}

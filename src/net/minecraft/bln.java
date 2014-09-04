package net.minecraft;

import java.util.Random;

abstract class bln extends bms {

	protected int a;
	protected int b;
	protected int c;
	protected int d = -1;

	public bln() {
	}

	protected bln(Random var1, int var2, int var3, int var4, int var5, int var6, int var7) {
		super(0);
		this.a = var5;
		this.b = var6;
		this.c = var7;
		this.m = en.a.a(var1);
		switch (blj.a[this.m.ordinal()]) {
			case 1:
			case 2:
				this.l = new bjb(var2, var3, var4, var2 + var5 - 1, var3 + var6 - 1, var4 + var7 - 1);
				break;
			default:
				this.l = new bjb(var2, var3, var4, var2 + var7 - 1, var3 + var6 - 1, var4 + var5 - 1);
		}

	}

	protected void a(NBTCompoundTag var1) {
		var1.a("Width", this.a);
		var1.a("Height", this.b);
		var1.a("Depth", this.c);
		var1.a("HPos", this.d);
	}

	protected void b(NBTCompoundTag var1) {
		this.a = var1.f("Width");
		this.b = var1.f("Height");
		this.c = var1.f("Depth");
		this.d = var1.f("HPos");
	}

	protected boolean a(World var1, bjb var2, int var3) {
		if (this.d >= 0) {
			return true;
		} else {
			int var4 = 0;
			int var5 = 0;

			for (int var6 = this.l.c; var6 <= this.l.f; ++var6) {
				for (int var7 = this.l.a; var7 <= this.l.d; ++var7) {
					dt var8 = new dt(var7, 64, var6);
					if (var2.b((fd) var8)) {
						var4 += Math.max(var1.r(var8).o(), var1.t.i());
						++var5;
					}
				}
			}

			if (var5 == 0) {
				return false;
			} else {
				this.d = var4 / var5;
				this.l.a(0, this.d - this.l.b + var3, 0);
				return true;
			}
		}
	}
}

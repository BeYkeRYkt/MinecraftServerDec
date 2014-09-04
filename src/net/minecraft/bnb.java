package net.minecraft;

import java.util.List;
import java.util.Random;

public class bnb extends bnn {

	private atr a;
	private atr b;
	private atr c;
	private atr d;

	public bnb() {
	}

	public bnb(bnk var1, int var2, Random var3, bjb var4, ej var5) {
		super(var1, var2);
		this.m = var5;
		this.l = var4;
		this.a = this.a(var3);
		this.b = this.a(var3);
		this.c = this.a(var3);
		this.d = this.a(var3);
	}

	protected void a(NBTCompoundTag var1) {
		super.a(var1);
		var1.put("CA", atr.c.b(this.a));
		var1.put("CB", atr.c.b(this.b));
		var1.put("CC", atr.c.b(this.c));
		var1.put("CD", atr.c.b(this.d));
	}

	protected void b(NBTCompoundTag var1) {
		super.b(var1);
		this.a = atr.c(var1.f("CA"));
		this.b = atr.c(var1.f("CB"));
		this.c = atr.c(var1.f("CC"));
		this.d = atr.c(var1.f("CD"));
	}

	private atr a(Random var1) {
		switch (var1.nextInt(5)) {
			case 0:
				return aty.cb;
			case 1:
				return aty.cc;
			default:
				return aty.aj;
		}
	}

	public static bnb a(bnk var0, List var1, Random var2, int var3, int var4, int var5, ej var6, int var7) {
		bjb var8 = bjb.a(var3, var4, var5, 0, 0, 0, 13, 4, 9, var6);
		return a(var8) && bms.a(var1, var8) == null ? new bnb(var0, var7, var2, var8, var6) : null;
	}

	public boolean a(World var1, Random var2, bjb var3) {
		if (this.h < 0) {
			this.h = this.b(var1, var3);
			if (this.h < 0) {
				return true;
			}

			this.l.a(0, this.h - this.l.e + 4 - 1, 0);
		}

		this.a(var1, var3, 0, 1, 0, 12, 4, 8, aty.a.P(), aty.a.P(), false);
		this.a(var1, var3, 1, 0, 1, 2, 0, 7, aty.ak.P(), aty.ak.P(), false);
		this.a(var1, var3, 4, 0, 1, 5, 0, 7, aty.ak.P(), aty.ak.P(), false);
		this.a(var1, var3, 7, 0, 1, 8, 0, 7, aty.ak.P(), aty.ak.P(), false);
		this.a(var1, var3, 10, 0, 1, 11, 0, 7, aty.ak.P(), aty.ak.P(), false);
		this.a(var1, var3, 0, 0, 0, 0, 0, 8, aty.r.P(), aty.r.P(), false);
		this.a(var1, var3, 6, 0, 0, 6, 0, 8, aty.r.P(), aty.r.P(), false);
		this.a(var1, var3, 12, 0, 0, 12, 0, 8, aty.r.P(), aty.r.P(), false);
		this.a(var1, var3, 1, 0, 0, 11, 0, 0, aty.r.P(), aty.r.P(), false);
		this.a(var1, var3, 1, 0, 8, 11, 0, 8, aty.r.P(), aty.r.P(), false);
		this.a(var1, var3, 3, 0, 1, 3, 0, 7, aty.j.P(), aty.j.P(), false);
		this.a(var1, var3, 9, 0, 1, 9, 0, 7, aty.j.P(), aty.j.P(), false);

		int var4;
		for (var4 = 1; var4 <= 7; ++var4) {
			this.a(var1, this.a.a(NumberConverter.a(var2, 2, 7)), 1, 1, var4, var3);
			this.a(var1, this.a.a(NumberConverter.a(var2, 2, 7)), 2, 1, var4, var3);
			this.a(var1, this.b.a(NumberConverter.a(var2, 2, 7)), 4, 1, var4, var3);
			this.a(var1, this.b.a(NumberConverter.a(var2, 2, 7)), 5, 1, var4, var3);
			this.a(var1, this.c.a(NumberConverter.a(var2, 2, 7)), 7, 1, var4, var3);
			this.a(var1, this.c.a(NumberConverter.a(var2, 2, 7)), 8, 1, var4, var3);
			this.a(var1, this.d.a(NumberConverter.a(var2, 2, 7)), 10, 1, var4, var3);
			this.a(var1, this.d.a(NumberConverter.a(var2, 2, 7)), 11, 1, var4, var3);
		}

		for (var4 = 0; var4 < 9; ++var4) {
			for (int var5 = 0; var5 < 13; ++var5) {
				this.b(var1, var5, 4, var4, var3);
				this.b(var1, aty.d.P(), var5, -1, var4, var3);
			}
		}

		return true;
	}
}

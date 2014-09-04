package net.minecraft;

import com.google.common.collect.Multimap;

public class anm extends alq {

	private float a;
	private final ami b;

	public anm(ami var1) {
		this.b = var1;
		this.h = 1;
		this.d(var1.a());
		this.a(akf.j);
		this.a = 4.0F + var1.c();
	}

	public float g() {
		return this.b.c();
	}

	public float a(amj var1, atr var2) {
		if (var2 == aty.G) {
			return 15.0F;
		} else {
			bof var3 = var2.r();
			return var3 != bof.k && var3 != bof.l && var3 != bof.v && var3 != bof.j && var3 != bof.C ? 1.0F : 1.5F;
		}
	}

	public boolean a(amj var1, EntityLiving var2, EntityLiving var3) {
		var1.a(1, var3);
		return true;
	}

	public boolean a(amj var1, World var2, atr var3, dt var4, EntityLiving var5) {
		if ((double) var3.g(var2, var4) != 0.0D) {
			var1.a(2, var5);
		}

		return true;
	}

	public ano e(amj var1) {
		return ano.d;
	}

	public int d(amj var1) {
		return 72000;
	}

	public amj a(amj var1, World var2, ahd var3) {
		var3.a(var1, this.d(var1));
		return var1;
	}

	public boolean b(atr var1) {
		return var1 == aty.G;
	}

	public int b() {
		return this.b.e();
	}

	public String h() {
		return this.b.toString();
	}

	public boolean a(amj var1, amj var2) {
		return this.b.f() == var2.b() ? true : super.a(var1, var2);
	}

	public Multimap i() {
		Multimap var1 = super.i();
		var1.put(afs.e.a(), new ya(f, "Weapon modifier", (double) this.a, 0));
		return var1;
	}
}

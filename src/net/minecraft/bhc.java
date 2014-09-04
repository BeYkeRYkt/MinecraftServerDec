package net.minecraft;

import java.util.Random;

public abstract class bhc extends bhp {

	public bhc(boolean var1) {
		super(var1);
	}

	protected boolean a(atr var1) {
		return var1.r() == bof.a || var1.r() == bof.j || var1 == aty.c || var1 == aty.d || var1 == aty.r || var1 == aty.s || var1 == aty.g || var1 == aty.bn;
	}

	public void a(World var1, Random var2, dt var3) {
	}

	protected void a(World var1, dt var2) {
		if (var1.p(var2).c() != aty.d) {
			this.a(var1, var2, aty.d.P());
		}

	}
}

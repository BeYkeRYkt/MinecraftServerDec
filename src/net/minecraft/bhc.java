package net.minecraft;

import java.util.Random;

public abstract class bhc extends bhp {

	public bhc(boolean var1) {
		super(var1);
	}

	protected boolean a(Block var1) {
		return var1.r() == Material.AIR || var1.r() == Material.LEAVES || var1 == aty.c || var1 == aty.d || var1 == aty.r || var1 == aty.s || var1 == aty.g || var1 == aty.bn;
	}

	public void a(World var1, Random var2, Position var3) {
	}

	protected void a(World var1, Position var2) {
		if (var1.p(var2).getBlock() != aty.d) {
			this.a(var1, var2, aty.d.P());
		}

	}
}

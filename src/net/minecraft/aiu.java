package net.minecraft;

public class aiu extends ajk {

	public aiu(vq var1, int var2, int var3, int var4) {
		super(var1, var2, var3, var4);
	}

	public boolean a(amj var1) {
		return bdc.c(var1) || c_(var1);
	}

	public int b(amj var1) {
		return c_(var1) ? 1 : super.b(var1);
	}

	public static boolean c_(amj var0) {
		return var0 != null && var0.b() != null && var0.b() == amk.aw;
	}
}

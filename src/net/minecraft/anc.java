package net.minecraft;

public class anc extends alq {

	private atr a;
	private atr b;

	public anc(atr var1, atr var2) {
		this.a = var1;
		this.b = var2;
		this.a(akf.l);
	}

	public boolean a(amj var1, ahd var2, World var3, dt var4, ej var5, float var6, float var7, float var8) {
		if (var5 != ej.b) {
			return false;
		} else if (!var2.a(var4.a(var5), var5, var1)) {
			return false;
		} else if (var3.p(var4).c() == this.b && var3.d(var4.a())) {
			var3.a(var4.a(), this.a.P());
			--var1.b;
			return true;
		} else {
			return false;
		}
	}
}

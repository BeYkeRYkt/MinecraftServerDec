package net.minecraft;

public class anf extends alq {

	public anf() {
		this.h = 16;
		this.a(akf.c);
	}

	public boolean a(amj var1, ahd var2, World var3, dt var4, ej var5, float var6, float var7, float var8) {
		if (var5 == ej.a) {
			return false;
		} else if (!var3.p(var4).c().r().a()) {
			return false;
		} else {
			var4 = var4.a(var5);
			if (!var2.a(var4, var5, var1)) {
				return false;
			} else if (!aty.an.c(var3, var4)) {
				return false;
			} else if (var3.D) {
				return true;
			} else {
				if (var5 == ej.b) {
					int var9 = NumberConverter.c((double) ((var2.y + 180.0F) * 16.0F / 360.0F) + 0.5D) & 15;
					var3.a(var4, aty.an.P().a(baw.a, Integer.valueOf(var9)), 3);
				} else {
					var3.a(var4, aty.ax.P().a(bbz.a, var5), 3);
				}

				--var1.b;
				bcm var10 = var3.s(var4);
				if (var10 instanceof bdj && !aju.a(var3, var4, var1)) {
					var2.a((bdj) var10);
				}

				return true;
			}
		}
	}
}

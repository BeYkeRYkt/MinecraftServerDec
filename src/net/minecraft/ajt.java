package net.minecraft;

public class ajt extends alq {

	public ajt() {
		this.a(akf.c);
	}

	public boolean a(amj var1, ahd var2, World var3, dt var4, ej var5, float var6, float var7, float var8) {
		if (var3.D) {
			return true;
		} else if (var5 != ej.b) {
			return false;
		} else {
			bec var9 = var3.p(var4);
			atr var10 = var9.c();
			boolean var11 = var10.f(var3, var4);
			if (!var11) {
				var4 = var4.a();
			}

			int var12 = NumberConverter.c((double) (var2.y * 4.0F / 360.0F) + 0.5D) & 3;
			ej var13 = ej.b(var12);
			dt var14 = var4.a(var13);
			boolean var15 = var10.f(var3, var14);
			boolean var16 = var3.d(var4) || var11;
			boolean var17 = var3.d(var14) || var15;
			if (var2.a(var4, var5, var1) && var2.a(var14, var5, var1)) {
				if (var16 && var17 && World.a((ard) var3, var4.b()) && World.a((ard) var3, var14.b())) {
					int var18 = var13.b();
					bec var19 = aty.C.P().a(atp.b, Boolean.valueOf(false)).a(atp.N, var13).a(atp.a, atq.b);
					if (var3.a(var4, var19, 3)) {
						bec var20 = var19.a(atp.a, atq.a);
						var3.a(var14, var20, 3);
					}

					--var1.b;
					return true;
				} else {
					return false;
				}
			} else {
				return false;
			}
		}
	}
}

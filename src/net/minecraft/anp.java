package net.minecraft;

public class anp extends ann {

	public anp(atr var1) {
		super(var1, false);
	}

	public amj a(amj var1, World var2, ahd var3) {
		bru var4 = this.a(var2, var3, true);
		if (var4 == null) {
			return var1;
		} else {
			if (var4.a == brv.b) {
				dt var5 = var4.a();
				if (!var2.a(var3, var5)) {
					return var1;
				}

				if (!var3.a(var5.a(var4.b), var4.b, var1)) {
					return var1;
				}

				dt var6 = var5.a();
				bec var7 = var2.p(var5);
				if (var7.c().r() == bof.h && ((Integer) var7.b(axl.b)).intValue() == 0 && var2.d(var6)) {
					var2.a(var6, aty.bx.P());
					if (!var3.by.instabuild) {
						--var1.b;
					}

					var3.b(ty.J[alq.b((alq) this)]);
				}
			}

			return var1;
		}
	}
}

package net.minecraft;

public class ajy extends alq {

	public ajy() {
		this.a(akf.k);
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

				if (var2.p(var5).c().r() == bof.h) {
					--var1.b;
					var3.b(ty.J[alq.b((alq) this)]);
					if (var1.b <= 0) {
						return new amj(amk.bz);
					}

					if (!var3.bg.a(new amj(amk.bz))) {
						var3.a(new amj(amk.bz, 1, 0), false);
					}
				}
			}

			return var1;
		}
	}
}

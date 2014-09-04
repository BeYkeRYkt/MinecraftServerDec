package net.minecraft;

public class aog implements aoo {

	public boolean a(ain var1, World var2) {
		int var3 = 0;
		amj var4 = null;

		for (int var5 = 0; var5 < var1.n_(); ++var5) {
			amj var6 = var1.a(var5);
			if (var6 != null) {
				if (var6.b() == amk.bN) {
					if (var4 != null) {
						return false;
					}

					var4 = var6;
				} else {
					if (var6.b() != amk.bM) {
						return false;
					}

					++var3;
				}
			}
		}

		return var4 != null && var3 > 0;
	}

	public amj a(ain var1) {
		int var2 = 0;
		amj var3 = null;

		for (int var4 = 0; var4 < var1.n_(); ++var4) {
			amj var5 = var1.a(var4);
			if (var5 != null) {
				if (var5.b() == amk.bN) {
					if (var3 != null) {
						return null;
					}

					var3 = var5;
				} else {
					if (var5.b() != amk.bM) {
						return null;
					}

					++var2;
				}
			}
		}

		if (var3 != null && var2 >= 1 && anr.h(var3) < 2) {
			amj var6 = new amj(amk.bN, var2);
			var6.d((NBTCompoundTag) var3.o().getCopy());
			var6.o().a("generation", anr.h(var3) + 1);
			if (var3.s()) {
				var6.c(var3.q());
			}

			return var6;
		} else {
			return null;
		}
	}

	public int a() {
		return 9;
	}

	public amj b() {
		return null;
	}

	public amj[] b(ain var1) {
		amj[] var2 = new amj[var1.n_()];

		for (int var3 = 0; var3 < var2.length; ++var3) {
			amj var4 = var1.a(var3);
			if (var4 != null && var4.b() instanceof anr) {
				var2[var3] = var4;
				break;
			}
		}

		return var2;
	}
}

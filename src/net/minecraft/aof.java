package net.minecraft;

class aof implements aoo {

	private aof() {
	}

	public boolean a(ain var1, World var2) {
		amj var3 = null;
		amj var4 = null;

		for (int var5 = 0; var5 < var1.n_(); ++var5) {
			amj var6 = var1.a(var5);
			if (var6 != null) {
				if (var6.b() != amk.cE) {
					return false;
				}

				if (var3 != null && var4 != null) {
					return false;
				}

				int var7 = bci.b(var6);
				boolean var8 = bci.c(var6) > 0;
				if (var3 != null) {
					if (var8) {
						return false;
					}

					if (var7 != bci.b(var3)) {
						return false;
					}

					var4 = var6;
				} else if (var4 != null) {
					if (!var8) {
						return false;
					}

					if (var7 != bci.b(var4)) {
						return false;
					}

					var3 = var6;
				} else if (var8) {
					var3 = var6;
				} else {
					var4 = var6;
				}
			}
		}

		return var3 != null && var4 != null;
	}

	public amj a(ain var1) {
		for (int var2 = 0; var2 < var1.n_(); ++var2) {
			amj var3 = var1.a(var2);
			if (var3 != null && bci.c(var3) > 0) {
				amj var4 = var3.k();
				var4.b = 1;
				return var4;
			}
		}

		return null;
	}

	public int a() {
		return 2;
	}

	public amj b() {
		return null;
	}

	public amj[] b(ain var1) {
		amj[] var2 = new amj[var1.n_()];

		for (int var3 = 0; var3 < var2.length; ++var3) {
			amj var4 = var1.a(var3);
			if (var4 != null) {
				if (var4.b().r()) {
					var2[var3] = new amj(var4.b().q());
				} else if (var4.n() && bci.c(var4) > 0) {
					var2[var3] = var4.k();
					var2[var3].b = 1;
				}
			}
		}

		return var2;
	}

	// $FF: synthetic method
	aof(aod var1) {
		this();
	}
}

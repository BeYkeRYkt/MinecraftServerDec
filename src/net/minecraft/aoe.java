package net.minecraft;

class aoe implements aoo {

	private aoe() {
	}

	public boolean a(ain var1, World var2) {
		boolean var3 = false;

		for (int var4 = 0; var4 < var1.n_(); ++var4) {
			amj var5 = var1.a(var4);
			if (var5 != null && var5.b() == amk.cE) {
				if (var3) {
					return false;
				}

				if (bci.c(var5) >= 6) {
					return false;
				}

				var3 = true;
			}
		}

		if (!var3) {
			return false;
		} else {
			return this.c(var1) != null;
		}
	}

	public amj a(ain var1) {
		amj var2 = null;

		for (int var3 = 0; var3 < var1.n_(); ++var3) {
			amj var4 = var1.a(var3);
			if (var4 != null && var4.b() == amk.cE) {
				var2 = var4.k();
				var2.b = 1;
				break;
			}
		}

		bcj var8 = this.c(var1);
		if (var8 != null) {
			int var9 = 0;

			amj var6;
			for (int var5 = 0; var5 < var1.n_(); ++var5) {
				var6 = var1.a(var5);
				if (var6 != null && var6.b() == amk.aW) {
					var9 = var6.i();
					break;
				}
			}

			NBTCompoundTag var10 = var2.a("BlockEntityTag", true);
			var6 = null;
			NBTListTag var11;
			if (var10.b("Patterns", 9)) {
				var11 = var10.c("Patterns", 10);
			} else {
				var11 = new NBTListTag();
				var10.a("Patterns", (NBTTag) var11);
			}

			NBTCompoundTag var7 = new NBTCompoundTag();
			var7.a("Pattern", var8.b());
			var7.a("Color", var9);
			var11.a((NBTTag) var7);
		}

		return var2;
	}

	public int a() {
		return 10;
	}

	public amj b() {
		return null;
	}

	public amj[] b(ain var1) {
		amj[] var2 = new amj[var1.n_()];

		for (int var3 = 0; var3 < var2.length; ++var3) {
			amj var4 = var1.a(var3);
			if (var4 != null && var4.b().r()) {
				var2[var3] = new amj(var4.b().q());
			}
		}

		return var2;
	}

	private bcj c(ain var1) {
		bcj[] var2 = bcj.values();
		int var3 = var2.length;

		for (int var4 = 0; var4 < var3; ++var4) {
			bcj var5 = var2[var4];
			if (var5.d()) {
				boolean var6 = true;
				int var9;
				if (var5.e()) {
					boolean var12 = false;
					boolean var13 = false;

					for (var9 = 0; var9 < var1.n_() && var6; ++var9) {
						amj var14 = var1.a(var9);
						if (var14 != null && var14.b() != amk.cE) {
							if (var14.b() == amk.aW) {
								if (var13) {
									var6 = false;
									break;
								}

								var13 = true;
							} else {
								if (var12 || !var14.a(var5.f())) {
									var6 = false;
									break;
								}

								var12 = true;
							}
						}
					}

					if (!var12) {
						var6 = false;
					}
				} else if (var1.n_() != var5.c().length * var5.c()[0].length()) {
					var6 = false;
				} else {
					int var7 = -1;

					for (int var8 = 0; var8 < var1.n_() && var6; ++var8) {
						var9 = var8 / 3;
						int var10 = var8 % 3;
						amj var11 = var1.a(var8);
						if (var11 != null && var11.b() != amk.cE) {
							if (var11.b() != amk.aW) {
								var6 = false;
								break;
							}

							if (var7 != -1 && var7 != var11.i()) {
								var6 = false;
								break;
							}

							if (var5.c()[var9].charAt(var10) == 32) {
								var6 = false;
								break;
							}

							var7 = var11.i();
						} else if (var5.c()[var9].charAt(var10) != 32) {
							var6 = false;
							break;
						}
					}
				}

				if (var6) {
					return var5;
				}
			}
		}

		return null;
	}

	// $FF: synthetic method
	aoe(aod var1) {
		this();
	}
}

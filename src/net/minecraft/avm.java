package net.minecraft;

public class avm extends ave {

	private final eo O = new eg();

	protected eo a(amj var1) {
		return this.O;
	}

	public bcm a(World var1, int var2) {
		return new bcy();
	}

	protected void d(World var1, dt var2) {
		ea var3 = new ea(var1, var2);
		bcx var4 = (bcx) var3.h();
		if (var4 != null) {
			int var5 = var4.m();
			if (var5 < 0) {
				var1.b(1001, var2, 0);
			} else {
				amj var6 = var4.a(var5);
				if (var6 != null) {
					ej var7 = (ej) var1.p(var2).b(a);
					dt var8 = var2.a(var7);
					vq var9 = bde.b(var1, (double) var8.n(), (double) var8.o(), (double) var8.p());
					amj var10;
					if (var9 == null) {
						var10 = this.O.a(var3, var6);
						if (var10 != null && var10.b == 0) {
							var10 = null;
						}
					} else {
						var10 = bde.a(var9, var6.k().a(1), var7.d());
						if (var10 == null) {
							var10 = var6.k();
							if (--var10.b == 0) {
								var10 = null;
							}
						} else {
							var10 = var6.k();
						}
					}

					var4.a(var5, var10);
				}
			}
		}
	}
}

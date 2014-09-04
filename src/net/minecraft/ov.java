package net.minecraft;

final class ov extends eg {

	private final eg b = new eg();

	public amj b(dz var1, amj var2) {
		ej var3 = ave.b(var1.f());
		World var4 = var1.i();
		double var5 = var1.a() + (double) ((float) var3.g() * 1.125F);
		double var7 = var1.b() + (double) ((float) var3.h() * 1.125F);
		double var9 = var1.c() + (double) ((float) var3.i() * 1.125F);
		dt var11 = var1.d().a(var3);
		bof var12 = var4.p(var11).c().r();
		double var13;
		if (bof.h.equals(var12)) {
			var13 = 1.0D;
		} else {
			if (!bof.a.equals(var12) || !bof.h.equals(var4.p(var11.b()).c().r())) {
				return this.b.a(var1, var2);
			}

			var13 = 0.0D;
		}

		adu var15 = new adu(var4, var5, var7 + var13, var9);
		var4.d((Entity) var15);
		var2.a(1);
		return var2;
	}

	protected void a(dz var1) {
		var1.i().b(1000, var1.d(), 0);
	}
}

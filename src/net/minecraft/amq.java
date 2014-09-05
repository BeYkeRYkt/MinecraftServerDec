package net.minecraft;

final class amq extends eg {

	private final eg b = new eg();

	public ItemStack b(dz var1, ItemStack var2) {
		PaintingDirection var3 = ave.b(var1.f());
		World var4 = var1.i();
		double var5 = var1.a() + (double) var3.g() * 1.125D;
		double var7 = Math.floor(var1.b()) + (double) var3.h();
		double var9 = var1.c() + (double) var3.i() * 1.125D;
		Position var11 = var1.d().a(var3);
		bec var12 = var4.p(var11);
		atl var13 = var12.c() instanceof ati ? (atl) var12.b(((ati) var12.c()).l()) : atl.a;
		double var14;
		if (ati.d(var12)) {
			if (var13.c()) {
				var14 = 0.6D;
			} else {
				var14 = 0.1D;
			}
		} else {
			if (var12.c().r() != bof.a || !ati.d(var4.p(var11.b()))) {
				return this.b.a(var1, var2);
			}

			bec var16 = var4.p(var11.b());
			atl var17 = var16.c() instanceof ati ? (atl) var16.b(((ati) var16.c()).l()) : atl.a;
			if (var3 != PaintingDirection.a && var17.c()) {
				var14 = -0.4D;
			} else {
				var14 = -0.9D;
			}
		}

		adx var18 = adx.a(var4, var5, var7 + var14, var9, amp.a((amp) var2.getItem()));
		if (var2.s()) {
			var18.a(var2.q());
		}

		var4.d((Entity) var18);
		var2.a(1);
		return var2;
	}

	protected void a(dz var1) {
		var1.i().b(1000, var1.d(), 0);
	}
}

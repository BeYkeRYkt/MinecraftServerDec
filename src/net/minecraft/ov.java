package net.minecraft;

final class ov extends eg {

	private final eg b = new eg();

	public ItemStack b(dz var1, ItemStack var2) {
		PaintingDirection var3 = BlockDispenser.b(var1.f());
		World var4 = var1.i();
		double var5 = var1.a() + (double) ((float) var3.g() * 1.125F);
		double var7 = var1.b() + (double) ((float) var3.h() * 1.125F);
		double var9 = var1.c() + (double) ((float) var3.i() * 1.125F);
		Position var11 = var1.d().a(var3);
		Material var12 = var4.p(var11).getBlock().r();
		double var13;
		if (Material.WATER.equals(var12)) {
			var13 = 1.0D;
		} else {
			if (!Material.AIR.equals(var12) || !Material.WATER.equals(var4.p(var11.b()).getBlock().r())) {
				return this.b.a(var1, var2);
			}

			var13 = 0.0D;
		}

		EntityBoat var15 = new EntityBoat(var4, var5, var7 + var13, var9);
		var4.d((Entity) var15);
		var2.a(1);
		return var2;
	}

	protected void a(dz var1) {
		var1.i().b(1000, var1.d(), 0);
	}
}

package net.minecraft;

public class eg implements eo {

	public final ItemStack a(dz var1, ItemStack var2) {
		ItemStack var3 = this.b(var1, var2);
		this.a(var1);
		this.a(var1, BlockDispenser.b(var1.f()));
		return var3;
	}

	protected ItemStack b(dz var1, ItemStack var2) {
		BlockFace var3 = BlockDispenser.b(var1.f());
		ex var4 = BlockDispenser.a(var1);
		ItemStack var5 = var2.a(1);
		a(var1.i(), var5, 6, var3, var4);
		return var2;
	}

	public static void a(World var0, ItemStack var1, int var2, BlockFace var3, ex var4) {
		double var5 = var4.a();
		double var7 = var4.b();
		double var9 = var4.c();
		if (var3.k() == el.b) {
			var7 -= 0.125D;
		} else {
			var7 -= 0.15625D;
		}

		EntityItem var11 = new EntityItem(var0, var5, var7, var9, var1);
		double var12 = var0.s.nextDouble() * 0.1D + 0.2D;
		var11.motionX = (double) var3.g() * var12;
		var11.motionY = 0.20000000298023224D;
		var11.motionZ = (double) var3.i() * var12;
		var11.motionX += var0.s.nextGaussian() * 0.007499999832361937D * (double) var2;
		var11.motionY += var0.s.nextGaussian() * 0.007499999832361937D * (double) var2;
		var11.motionZ += var0.s.nextGaussian() * 0.007499999832361937D * (double) var2;
		var0.d((Entity) var11);
	}

	protected void a(dz var1) {
		var1.i().b(1000, var1.d(), 0);
	}

	protected void a(dz var1, BlockFace var2) {
		var1.i().b(2000, var1.d(), this.a(var2));
	}

	private int a(BlockFace var1) {
		return var1.g() + 1 + (var1.i() + 1) * 3;
	}
}

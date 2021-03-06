package net.minecraft;

public class DispenseBehaviorItem implements IDispenseBehavior {

	public final ItemStack a(ISourceBlock var1, ItemStack var2) {
		ItemStack var3 = this.b(var1, var2);
		this.a(var1);
		this.a(var1, BlockDispenser.b(var1.getData()));
		return var3;
	}

	protected ItemStack b(ISourceBlock var1, ItemStack var2) {
		BlockFace var3 = BlockDispenser.b(var1.getData());
		IPosition var4 = BlockDispenser.a(var1);
		ItemStack var5 = var2.a(1);
		a(var1.getWorld(), var5, 6, var3, var4);
		return var2;
	}

	public static void a(World var0, ItemStack var1, int var2, BlockFace var3, IPosition var4) {
		double var5 = var4.getX();
		double var7 = var4.getY();
		double var9 = var4.getZ();
		if (var3.k() == el.b) {
			var7 -= 0.125D;
		} else {
			var7 -= 0.15625D;
		}

		EntityItem var11 = new EntityItem(var0, var5, var7, var9, var1);
		double var12 = var0.random.nextDouble() * 0.1D + 0.2D;
		var11.motionX = (double) var3.g() * var12;
		var11.motionY = 0.20000000298023224D;
		var11.motionZ = (double) var3.i() * var12;
		var11.motionX += var0.random.nextGaussian() * 0.007499999832361937D * (double) var2;
		var11.motionY += var0.random.nextGaussian() * 0.007499999832361937D * (double) var2;
		var11.motionZ += var0.random.nextGaussian() * 0.007499999832361937D * (double) var2;
		var0.addEntity((Entity) var11);
	}

	protected void a(ISourceBlock var1) {
		var1.getWorld().triggerEffect(1000, var1.getPosition(), 0);
	}

	protected void a(ISourceBlock var1, BlockFace var2) {
		var1.getWorld().triggerEffect(2000, var1.getPosition(), this.a(var2));
	}

	private int a(BlockFace var1) {
		return var1.g() + 1 + (var1.i() + 1) * 3;
	}
}

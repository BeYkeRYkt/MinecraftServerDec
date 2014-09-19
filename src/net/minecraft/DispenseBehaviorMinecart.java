package net.minecraft;

final class DispenseBehaviorMinecart extends DispenseBehaviorItem {

	private final DispenseBehaviorItem b = new DispenseBehaviorItem();

	public ItemStack b(ISourceBlock var1, ItemStack var2) {
		BlockFace var3 = BlockDispenser.b(var1.f());
		World var4 = var1.i();
		double var5 = var1.getX() + (double) var3.g() * 1.125D;
		double var7 = Math.floor(var1.getY()) + (double) var3.h();
		double var9 = var1.getZ() + (double) var3.i() * 1.125D;
		Position var11 = var1.d().getRelative(var3);
		IBlockState var12 = var4.getBlockState(var11);
		atl var13 = var12.getBlock() instanceof ati ? (atl) var12.b(((ati) var12.getBlock()).l()) : atl.a;
		double var14;
		if (ati.d(var12)) {
			if (var13.c()) {
				var14 = 0.6D;
			} else {
				var14 = 0.1D;
			}
		} else {
			if (var12.getBlock().getMaterial() != Material.AIR || !ati.d(var4.getBlockState(var11.getDown()))) {
				return this.b.a(var1, var2);
			}

			IBlockState var16 = var4.getBlockState(var11.getDown());
			atl var17 = var16.getBlock() instanceof ati ? (atl) var16.b(((ati) var16.getBlock()).l()) : atl.a;
			if (var3 != BlockFace.DOWN && var17.c()) {
				var14 = -0.4D;
			} else {
				var14 = -0.9D;
			}
		}

		adx var18 = adx.a(var4, var5, var7 + var14, var9, ItemMinecart.a((ItemMinecart) var2.getItem()));
		if (var2.hasDisplayName()) {
			var18.a(var2.getDisplayName());
		}

		var4.addEntity((Entity) var18);
		var2.a(1);
		return var2;
	}

	protected void a(ISourceBlock var1) {
		var1.i().triggerEffect(1000, var1.d(), 0);
	}
}

package net.minecraft;

final class DispenseBehaviorEmptyBucket extends eg {

	private final eg b = new eg();

	public ItemStack b(dz var1, ItemStack var2) {
		World var3 = var1.i();
		Position var4 = var1.d().a(BlockDispenser.b(var1.f()));
		bec var5 = var3.p(var4);
		Block var6 = var5.getBlock();
		Material var7 = var6.r();
		Item var8;
		if (Material.WATER.equals(var7) && var6 instanceof axl && ((Integer) var5.b(axl.b)).intValue() == 0) {
			var8 = Items.WATER_BUCKET;
		} else {
			if (!Material.LAVA.equals(var7) || !(var6 instanceof axl) || ((Integer) var5.b(axl.b)).intValue() != 0) {
				return super.b(var1, var2);
			}

			var8 = Items.LAVA_BUCKET;
		}

		var3.g(var4);
		if (--var2.b == 0) {
			var2.a(var8);
			var2.b = 1;
		} else if (((TileEntityDispenser) var1.h()).a(new ItemStack(var8)) < 0) {
			this.b.a(var1, new ItemStack(var8));
		}

		return var2;
	}
}

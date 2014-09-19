package net.minecraft;

final class DispenseBehaviorEmptyBucket extends DispenseBehaviorItem {

	private final DispenseBehaviorItem b = new DispenseBehaviorItem();

	public ItemStack b(ISourceBlock var1, ItemStack var2) {
		World var3 = var1.getWorld();
		Position var4 = var1.getPosition().getRelative(BlockDispenser.b(var1.getData()));
		IBlockState var5 = var3.getBlockState(var4);
		Block var6 = var5.getBlock();
		Material var7 = var6.getMaterial();
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
		if (--var2.amount == 0) {
			var2.setItem(var8);
			var2.amount = 1;
		} else if (((TileEntityDispenser) var1.getTileEntity()).a(new ItemStack(var8)) < 0) {
			this.b.a(var1, new ItemStack(var8));
		}

		return var2;
	}
}

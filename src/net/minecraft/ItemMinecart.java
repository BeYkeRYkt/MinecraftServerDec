package net.minecraft;

public class ItemMinecart extends Item {

	private static final eo a = new amq();
	private final MinecartType b;

	public ItemMinecart(MinecartType var1) {
		this.maxStackSize = 1;
		this.b = var1;
		this.setCreativeModeTab(CreativeModeTab.TRANSPORTATION);
		BlockDispenser.M.a(this, a);
	}

	public boolean a(ItemStack var1, EntityHuman var2, World var3, Position var4, BlockFace var5, float var6, float var7, float var8) {
		BlockState var9 = var3.getBlockState(var4);
		if (ati.d(var9)) {
			if (!var3.isStatic) {
				atl var10 = var9.getBlock() instanceof ati ? (atl) var9.b(((ati) var9.getBlock()).l()) : atl.a;
				double var11 = 0.0D;
				if (var10.c()) {
					var11 = 0.5D;
				}

				adx var13 = adx.a(var3, (double) var4.getX() + 0.5D, (double) var4.getY() + 0.0625D + var11, (double) var4.getZ() + 0.5D, this.b);
				if (var1.s()) {
					var13.a(var1.q());
				}

				var3.d((Entity) var13);
			}

			--var1.amount;
			return true;
		} else {
			return false;
		}
	}

	// $FF: synthetic method
	static MinecartType a(ItemMinecart var0) {
		return var0.b;
	}

}

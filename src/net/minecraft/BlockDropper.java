package net.minecraft;

public class BlockDropper extends BlockDispenser {

	private final eo O = new eg();

	protected eo a(ItemStack var1) {
		return this.O;
	}

	public TileEntity a(World var1, int var2) {
		return new TileEntityDropper();
	}

	protected void d(World var1, Position var2) {
		ea var3 = new ea(var1, var2);
		TileEntityDispenser var4 = (TileEntityDispenser) var3.h();
		if (var4 != null) {
			int var5 = var4.m();
			if (var5 < 0) {
				var1.b(1001, var2, 0);
			} else {
				ItemStack var6 = var4.a(var5);
				if (var6 != null) {
					BlockFace var7 = (BlockFace) var1.p(var2).b(a);
					Position var8 = var2.a(var7);
					IInventory var9 = TileEntityHopper.b(var1, (double) var8.getX(), (double) var8.getY(), (double) var8.getZ());
					ItemStack var10;
					if (var9 == null) {
						var10 = this.O.a(var3, var6);
						if (var10 != null && var10.b == 0) {
							var10 = null;
						}
					} else {
						var10 = TileEntityHopper.a(var9, var6.getCopy().a(1), var7.getOpposite());
						if (var10 == null) {
							var10 = var6.getCopy();
							if (--var10.b == 0) {
								var10 = null;
							}
						} else {
							var10 = var6.getCopy();
						}
					}

					var4.a(var5, var10);
				}
			}
		}
	}
}

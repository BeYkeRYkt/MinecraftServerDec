package net.minecraft;

public class BlockDropper extends BlockDispenser {

	private final IDispenseBehavior O = new DispenseBehaviorItem();

	protected IDispenseBehavior getDispenseBehaviour(ItemStack var1) {
		return this.O;
	}

	public TileEntity getTileEntity(World world, int var2) {
		return new TileEntityDropper();
	}

	public void dispense(World var1, Position var2) {
		SourceBlock var3 = new SourceBlock(var1, var2);
		TileEntityDispenser var4 = (TileEntityDispenser) var3.getTileEntity();
		if (var4 != null) {
			int var5 = var4.getRandomSlot();
			if (var5 < 0) {
				var1.triggerEffect(1001, var2, 0);
			} else {
				ItemStack var6 = var4.getItem(var5);
				if (var6 != null) {
					BlockFace var7 = (BlockFace) var1.getBlockState(var2).b(a);
					Position var8 = var2.getRelative(var7);
					IInventory var9 = TileEntityHopper.b(var1, (double) var8.getX(), (double) var8.getY(), (double) var8.getZ());
					ItemStack var10;
					if (var9 == null) {
						var10 = this.O.a(var3, var6);
						if (var10 != null && var10.amount == 0) {
							var10 = null;
						}
					} else {
						var10 = TileEntityHopper.a(var9, var6.getCopy().a(1), var7.getOpposite());
						if (var10 == null) {
							var10 = var6.getCopy();
							if (--var10.amount == 0) {
								var10 = null;
							}
						} else {
							var10 = var6.getCopy();
						}
					}

					var4.setItem(var5, var10);
				}
			}
		}
	}
}

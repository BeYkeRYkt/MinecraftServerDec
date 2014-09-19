package net.minecraft;

public class ItemWaterLily extends ItemWithAuxData {

	public ItemWaterLily(Block var1) {
		super(var1, false);
	}

	public ItemStack a(ItemStack var1, World var2, EntityHuman var3) {
		MovingObjectPosition var4 = this.a(var2, var3, true);
		if (var4 == null) {
			return var1;
		} else {
			if (var4.type == EnumMovingObjectType.BLOCK) {
				Position var5 = var4.getPosition();
				if (!var2.a(var3, var5)) {
					return var1;
				}

				if (!var3.a(var5.getRelative(var4.face), var4.face, var1)) {
					return var1;
				}

				Position var6 = var5.getUp();
				IBlockState var7 = var2.getBlockState(var5);
				if (var7.getBlock().getMaterial() == Material.WATER && ((Integer) var7.b(axl.b)).intValue() == 0 && var2.d(var6)) {
					var2.a(var6, Blocks.WATER_LILY.getBlockState());
					if (!var3.playerProperties.instabuild) {
						--var1.amount;
					}

					var3.b(StatisticList.USE_ITEM_COUNT[Item.getId((Item) this)]);
				}
			}

			return var1;
		}
	}
}

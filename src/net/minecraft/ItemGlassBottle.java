package net.minecraft;

public class ItemGlassBottle extends Item {

	public ItemGlassBottle() {
		this.setCreativeModeTab(CreativeModeTab.BREWING);
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

				if (var2.getBlockState(var5).getBlock().getMaterial() == Material.WATER) {
					--var1.amount;
					var3.b(StatisticList.USE_ITEM_COUNT[Item.getId((Item) this)]);
					if (var1.amount <= 0) {
						return new ItemStack(Items.POTION);
					}

					if (!var3.playerInventory.pickup(new ItemStack(Items.POTION))) {
						var3.dropItem(new ItemStack(Items.POTION, 1, 0), false);
					}
				}
			}

			return var1;
		}
	}
}

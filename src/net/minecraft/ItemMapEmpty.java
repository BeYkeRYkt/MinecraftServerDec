package net.minecraft;

public class ItemMapEmpty extends ItemMap {

	protected ItemMapEmpty() {
		this.setCreativeModeTab(CreativeModeTab.MISC);
	}

	public ItemStack a(ItemStack var1, World var2, EntityHuman var3) {
		ItemStack var4 = new ItemStack(Items.FILLED_MAP, 1, var2.b("map"));
		String var5 = "map_" + var4.getDurability();
		bqe var6 = new bqe(var5);
		var2.a(var5, (bqc) var6);
		var6.e = 0;
		var6.a(var3.locationX, var3.locationZ, var6.e);
		var6.d = (byte) var2.worldProvider.getDimensionId();
		var6.c();
		--var1.amount;
		if (var1.amount <= 0) {
			return var4;
		} else {
			if (!var3.playerInventory.a(var4.getCopy())) {
				var3.dropItem(var4, false);
			}

			var3.b(StatisticList.USE_ITEM_COUNT[Item.getId((Item) this)]);
			return var1;
		}
	}
}

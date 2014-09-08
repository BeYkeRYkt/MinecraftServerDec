package net.minecraft;

public class ald extends Item {

	public ald() {
		this.setCreativeModeTab(CreativeModeTab.MISC);
	}

	public ItemStack a(ItemStack var1, World var2, EntityHuman var3) {
		if (!var3.playerProperties.instabuild) {
			--var1.amount;
		}

		var2.a((Entity) var3, "random.bow", 0.5F, 0.4F / (rnd.nextFloat() * 0.4F + 0.8F));
		if (!var2.D) {
			var2.d((Entity) (new EntityThrownExpBottle(var2, var3)));
		}

		var3.b(StatisticList.USE_ITEM_COUNT[Item.getId((Item) this)]);
		return var1;
	}
}

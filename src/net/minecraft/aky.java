package net.minecraft;

public class aky extends Item {

	public aky() {
		this.maxStackSize = 16;
		this.setCreativeModeTab(CreativeModeTab.MATERIALS);
	}

	public ItemStack a(ItemStack var1, World var2, EntityHuman var3) {
		if (!var3.by.instabuild) {
			--var1.b;
		}

		var2.a((Entity) var3, "random.bow", 0.5F, 0.4F / (rnd.nextFloat() * 0.4F + 0.8F));
		if (!var2.D) {
			var2.d((Entity) (new ahs(var2, var3)));
		}

		var3.b(StatisticList.J[Item.getId((Item) this)]);
		return var1;
	}
}

package net.minecraft;

public class amo extends Item {

	public amo() {
		this.c(1);
		this.a(CreativeModeTab.f);
	}

	public ItemStack b(ItemStack var1, World var2, EntityHuman var3) {
		if (!var3.by.instabuild) {
			--var1.b;
		}

		if (!var2.D) {
			var3.bj();
		}

		var3.b(StatisticList.J[Item.getId((Item) this)]);
		return var1.b <= 0 ? new ItemStack(amk.aw) : var1;
	}

	public int d(ItemStack var1) {
		return 32;
	}

	public ano e(ItemStack var1) {
		return ano.c;
	}

	public ItemStack a(ItemStack var1, World var2, EntityHuman var3) {
		var3.a(var1, this.d(var1));
		return var1;
	}
}

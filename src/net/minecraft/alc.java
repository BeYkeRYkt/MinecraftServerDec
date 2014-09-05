package net.minecraft;

public class alc extends Item {

	public alc() {
		this.maxStackSize = 16;
		this.a(CreativeModeTab.f);
	}

	public ItemStack a(ItemStack var1, World var2, EntityHuman var3) {
		if (var3.by.instabuild) {
			return var1;
		} else {
			--var1.b;
			var2.a((Entity) var3, "random.bow", 0.5F, 0.4F / (rnd.nextFloat() * 0.4F + 0.8F));
			if (!var2.D) {
				var2.d((Entity) (new EntityEnderPearl(var2, var3)));
			}

			var3.b(StatisticList.J[Item.getId((Item) this)]);
			return var1;
		}
	}
}

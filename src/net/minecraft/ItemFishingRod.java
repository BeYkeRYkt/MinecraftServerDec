package net.minecraft;

public class ItemFishingRod extends Item {

	public ItemFishingRod() {
		this.setDurability(64);
		this.setMaxStackSize(1);
		this.setCreativeModeTab(CreativeModeTab.TOOLS);
	}

	public ItemStack a(ItemStack var1, World var2, EntityHuman var3) {
		if (var3.bE != null) {
			int var4 = var3.bE.l();
			var1.a(var4, (EntityLiving) var3);
			var3.bv();
		} else {
			var2.a((Entity) var3, "random.bow", 0.5F, 0.4F / (rnd.nextFloat() * 0.4F + 0.8F));
			if (!var2.D) {
				var2.d((Entity) (new ado(var2, var3)));
			}

			var3.bv();
			var3.b(StatisticList.J[Item.getId((Item) this)]);
		}

		return var1;
	}

	public boolean f_(ItemStack var1) {
		return super.f_(var1);
	}

	public int b() {
		return 1;
	}
}

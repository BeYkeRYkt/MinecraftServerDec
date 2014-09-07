package net.minecraft;

public class ItemCarrotStick extends Item {

	public ItemCarrotStick() {
		this.setCreativeModeTab(CreativeModeTab.TRANSPORTATION);
		this.setMaxStackSize(1);
		this.setDurability(25);
	}

	public ItemStack a(ItemStack var1, World var2, EntityHuman var3) {
		if (var3.av() && var3.m instanceof EntityPig) {
			EntityPig var4 = (EntityPig) var3.m;
			if (var4.ck().h() && var1.j() - var1.i() >= 7) {
				var4.ck().g();
				var1.a(7, (EntityLiving) var3);
				if (var1.b == 0) {
					ItemStack var5 = new ItemStack(Items.FISHING_ROD);
					var5.d(var1.getTag());
					return var5;
				}
			}
		}

		var3.b(StatisticList.USE_ITEM_COUNT[Item.getId((Item) this)]);
		return var1;
	}
}

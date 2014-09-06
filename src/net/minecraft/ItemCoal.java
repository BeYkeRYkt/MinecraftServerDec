package net.minecraft;

public class ItemCoal extends Item {

	public ItemCoal() {
		this.a(true);
		this.setDurability(0);
		this.setCreativeModeTab(CreativeModeTab.MATERIALS);
	}

	public String getName(ItemStack var1) {
		return var1.i() == 1 ? "item.charcoal" : "item.coal";
	}
}

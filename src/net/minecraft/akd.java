package net.minecraft;

public class akd extends Item {

	public akd() {
		this.a(true);
		this.d(0);
		this.a(CreativeModeTab.l);
	}

	public String e_(ItemStack var1) {
		return var1.i() == 1 ? "item.charcoal" : "item.coal";
	}
}

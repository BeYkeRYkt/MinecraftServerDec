package net.minecraft;

public class amt extends Item {

	public amt() {
		this.a(CreativeModeTab.i);
	}

	public boolean a(ItemStack var1, EntityHuman var2, EntityLiving var3) {
		if (!var1.s()) {
			return false;
		} else if (var3 instanceof xn) {
			xn var4 = (xn) var3;
			var4.a(var1.q());
			var4.bW();
			--var1.b;
			return true;
		} else {
			return super.a(var1, var2, var3);
		}
	}
}

package net.minecraft;

public class ItemNameTag extends Item {

	public ItemNameTag() {
		this.setCreativeModeTab(CreativeModeTab.TOOLS);
	}

	public boolean a(ItemStack var1, EntityHuman var2, EntityLiving var3) {
		if (!var1.s()) {
			return false;
		} else if (var3 instanceof EntityInsentient) {
			EntityInsentient var4 = (EntityInsentient) var3;
			var4.a(var1.q());
			var4.bW();
			--var1.amount;
			return true;
		} else {
			return super.a(var1, var2, var3);
		}
	}
}

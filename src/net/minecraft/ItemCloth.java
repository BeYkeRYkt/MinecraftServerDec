package net.minecraft;

public class ItemCloth extends ItemBlock {

	public ItemCloth(Block var1) {
		super(var1);
		this.setDurability(0);
		this.a(true);
	}

	public int a(int var1) {
		return var1;
	}

	public String getName(ItemStack var1) {
		return super.getName() + "." + akv.b(var1.i()).d();
	}
}

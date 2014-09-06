package net.minecraft;

public class ItemSoup extends ItemFood {

	public ItemSoup(int var1) {
		super(var1, false);
		this.setMaxStackSize(1);
	}

	public ItemStack b(ItemStack var1, World var2, EntityHuman var3) {
		super.b(var1, var2, var3);
		return new ItemStack(Items.BOWL);
	}
}

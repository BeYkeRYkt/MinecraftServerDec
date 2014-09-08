package net.minecraft;

public class ItemLeaves extends ItemBlock {

	private final BlockLeaves b;

	public ItemLeaves(BlockLeaves var1) {
		super(var1);
		this.b = var1;
		this.setDurability(0);
		this.a(true);
	}

	public int a(int var1) {
		return var1 | 4;
	}

	public String getName(ItemStack var1) {
		return super.getName() + "." + this.b.b(var1.getDurability()).c();
	}
}

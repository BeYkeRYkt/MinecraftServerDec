package net.minecraft;

public class EnchantmentDigging extends Enchantment {

	protected EnchantmentDigging(int var1, RegistryObjectName var2, int var3) {
		super(var1, var2, var3, EnchantmentSlotType.DIGGER);
		this.setName("digging");
	}

	public int a(int var1) {
		return 1 + 10 * (var1 - 1);
	}

	public int b(int var1) {
		return super.a(var1) + 50;
	}

	public int getMaxLevel() {
		return 5;
	}

	public boolean canEnchant(ItemStack var1) {
		return var1.getItem() == Items.be ? true : super.canEnchant(var1);
	}
}

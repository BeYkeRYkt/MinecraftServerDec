package net.minecraft;

public class EnchantmentArrowKnockback extends Enchantment {

	public EnchantmentArrowKnockback(int var1, RegistryObjectName var2, int var3) {
		super(var1, var2, var3, EnchantmentSlotType.BOW);
		this.setName("arrowKnockback");
	}

	public int a(int var1) {
		return 12 + (var1 - 1) * 20;
	}

	public int b(int var1) {
		return this.a(var1) + 25;
	}

	public int getMaxLevel() {
		return 2;
	}
}

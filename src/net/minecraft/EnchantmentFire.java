package net.minecraft;

public class EnchantmentFire extends Enchantment {

	protected EnchantmentFire(int var1, RegistryObjectName var2, int var3) {
		super(var1, var2, var3, EnchantmentSlotType.WEAPON);
		this.setName("fire");
	}

	public int a(int var1) {
		return 10 + 20 * (var1 - 1);
	}

	public int b(int var1) {
		return super.a(var1) + 50;
	}

	public int getMaxLevel() {
		return 2;
	}
}

package net.minecraft;

public class EnchantmentLure extends Enchantment {

	protected EnchantmentLure(int var1, RegistryObjectName var2, int var3, EnchantmentSlotType var4) {
		super(var1, var2, var3, var4);
		this.setName("fishingSpeed");
	}

	public int a(int var1) {
		return 15 + (var1 - 1) * 9;
	}

	public int b(int var1) {
		return super.a(var1) + 50;
	}

	public int getMaxLevel() {
		return 3;
	}
}

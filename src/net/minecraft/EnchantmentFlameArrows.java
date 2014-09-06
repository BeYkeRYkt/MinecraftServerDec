package net.minecraft;

public class EnchantmentFlameArrows extends Enchantment {

	public EnchantmentFlameArrows(int var1, RegistryObjectName var2, int var3) {
		super(var1, var2, var3, EnchantmentSlotType.BOW);
		this.setName("arrowFire");
	}

	public int a(int var1) {
		return 20;
	}

	public int b(int var1) {
		return 50;
	}

	public int getMaxLevel() {
		return 1;
	}
}

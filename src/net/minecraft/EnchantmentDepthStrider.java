package net.minecraft;

public class EnchantmentDepthStrider extends Enchantment {

	public EnchantmentDepthStrider(int var1, RegistryObjectName var2, int var3) {
		super(var1, var2, var3, EnchantmentSlotType.ARMOR_FEET);
		this.setName("waterWalker");
	}

	public int a(int var1) {
		return var1 * 10;
	}

	public int b(int var1) {
		return this.a(var1) + 15;
	}

	public int getMaxLevel() {
		return 3;
	}
}

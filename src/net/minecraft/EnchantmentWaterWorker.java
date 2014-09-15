package net.minecraft;

public class EnchantmentWaterWorker extends Enchantment {

	public EnchantmentWaterWorker(int var1, RegistryObjectName var2, int var3) {
		super(var1, var2, var3, EnchantmentSlotType.ARMOR_HEAD);
		this.setName("waterWorker");
	}

	public int a(int var1) {
		return 1;
	}

	public int b(int var1) {
		return this.a(var1) + 40;
	}

	public int getMaxLevel() {
		return 1;
	}
}

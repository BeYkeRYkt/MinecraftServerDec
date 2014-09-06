package net.minecraft;

import java.util.Random;

class ags implements agw {

	public void a(aqd var1, Random var2) {
		Enchantment var3 = Enchantment.enchants[var2.nextInt(Enchantment.enchants.length)];
		int var4 = DataTypesConverter.a(var2, var3.getStartLevel(), var3.getMaxLevel());
		ItemStack var5 = Items.ENCHANTED_BOOK.a(new apo(var3, var4));
		int var6 = 2 + var2.nextInt(5 + var4 * 10) + 3 * var4;
		if (var6 > 64) {
			var6 = 64;
		}

		var1.add(new aqc(new ItemStack(Items.BOOK), new ItemStack(Items.EMERALD, var6), var5));
	}
}

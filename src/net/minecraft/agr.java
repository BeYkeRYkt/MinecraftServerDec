package net.minecraft;

import java.util.Random;

class agr implements agw {

	public Item a;
	public agx b;

	public agr(Item var1, agx var2) {
		this.a = var1;
		this.b = var2;
	}

	public void a(MerchantRecipeList var1, Random var2) {
		int var3 = 1;
		if (this.b != null) {
			var3 = this.b.a(var2);
		}

		var1.add(new MerchantRecipe(new ItemStack(this.a, var3, 0), Items.EMERALD));
	}
}

package net.minecraft;

import java.util.Random;

class agv implements agw {

	public ItemStack a;
	public agx b;

	public agv(Item var1, agx var2) {
		this.a = new ItemStack(var1);
		this.b = var2;
	}

	public agv(ItemStack var1, agx var2) {
		this.a = var1;
		this.b = var2;
	}

	public void a(MerchantRecipeList var1, Random var2) {
		int var3 = 1;
		if (this.b != null) {
			var3 = this.b.a(var2);
		}

		ItemStack var4;
		ItemStack var5;
		if (var3 < 0) {
			var4 = new ItemStack(Items.EMERALD, 1, 0);
			var5 = new ItemStack(this.a.getItem(), -var3, this.a.getWearout());
		} else {
			var4 = new ItemStack(Items.EMERALD, var3, 0);
			var5 = new ItemStack(this.a.getItem(), 1, this.a.getWearout());
		}

		var1.add(new MerchantRecipe(var4, var5));
	}
}

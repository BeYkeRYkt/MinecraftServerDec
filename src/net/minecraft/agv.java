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

	public void a(aqd var1, Random var2) {
		int var3 = 1;
		if (this.b != null) {
			var3 = this.b.a(var2);
		}

		ItemStack var4;
		ItemStack var5;
		if (var3 < 0) {
			var4 = new ItemStack(amk.bO, 1, 0);
			var5 = new ItemStack(this.a.getItem(), -var3, this.a.i());
		} else {
			var4 = new ItemStack(amk.bO, var3, 0);
			var5 = new ItemStack(this.a.getItem(), 1, this.a.i());
		}

		var1.add(new aqc(var4, var5));
	}
}

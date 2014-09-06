package net.minecraft;

import java.util.Random;

class agu implements agw {

	public ItemStack a;
	public agx b;
	public ItemStack c;
	public agx d;

	public agu(Item var1, agx var2, Item var3, agx var4) {
		this.a = new ItemStack(var1);
		this.b = var2;
		this.c = new ItemStack(var3);
		this.d = var4;
	}

	public void a(aqd var1, Random var2) {
		int var3 = 1;
		if (this.b != null) {
			var3 = this.b.a(var2);
		}

		int var4 = 1;
		if (this.d != null) {
			var4 = this.d.a(var2);
		}

		var1.add(new aqc(new ItemStack(this.a.getItem(), var3, this.a.i()), new ItemStack(Items.bO), new ItemStack(this.c.getItem(), var4, this.c.i())));
	}
}

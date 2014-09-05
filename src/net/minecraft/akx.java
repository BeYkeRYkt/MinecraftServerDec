package net.minecraft;

public class akx extends aju {

	public akx(Block var1) {
		super(var1);
		this.d(0);
		this.a(true);
	}

	public int a(int var1) {
		return var1;
	}

	public String e_(ItemStack var1) {
		return super.a() + "." + akv.b(var1.i()).d();
	}
}

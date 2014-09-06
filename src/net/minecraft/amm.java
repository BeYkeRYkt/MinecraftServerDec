package net.minecraft;

public class amm extends aju {

	private final BlockLeaves b;

	public amm(BlockLeaves var1) {
		super(var1);
		this.b = var1;
		this.d(0);
		this.a(true);
	}

	public int a(int var1) {
		return var1 | 4;
	}

	public String e_(ItemStack var1) {
		return super.a() + "." + this.b.b(var1.i()).c();
	}
}

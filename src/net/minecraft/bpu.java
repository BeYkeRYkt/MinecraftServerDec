package net.minecraft;

public abstract class bpu {

	protected ard a;
	protected IntHashMap b = new IntHashMap();
	protected int c;
	protected int d;
	protected int e;

	public void a(ard var1, Entity var2) {
		this.a = var1;
		this.b.c();
		this.c = MathHelper.d(var2.J + 1.0F);
		this.d = MathHelper.d(var2.K + 1.0F);
		this.e = MathHelper.d(var2.J + 1.0F);
	}

	public void a() {
	}

	protected bpt a(int var1, int var2, int var3) {
		int var4 = bpt.a(var1, var2, var3);
		bpt var5 = (bpt) this.b.get(var4);
		if (var5 == null) {
			var5 = new bpt(var1, var2, var3);
			this.b.a(var4, var5);
		}

		return var5;
	}

	public abstract bpt a(Entity var1);

	public abstract bpt a(Entity var1, double var2, double var4, double var6);

	public abstract int a(bpt[] var1, Entity var2, bpt var3, bpt var4, float var5);
}

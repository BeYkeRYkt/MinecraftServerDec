package net.minecraft;

public class all extends Item {

	public final int a;
	private final int b;
	private final float c;
	private final boolean d;
	private boolean k;
	private int l;
	private int m;
	private int n;
	private float o;

	public all(int var1, float var2, boolean var3) {
		this.a = 32;
		this.b = var1;
		this.d = var3;
		this.c = var2;
		this.setCreativeModeTab(CreativeModeTab.FOOD);
	}

	public all(int var1, boolean var2) {
		this(var1, 0.6F, var2);
	}

	public ItemStack b(ItemStack var1, World var2, EntityHuman var3) {
		--var1.b;
		var3.ck().a(this, var1);
		var2.a((Entity) var3, "random.burp", 0.5F, var2.s.nextFloat() * 0.1F + 0.9F);
		this.c(var1, var2, var3);
		var3.b(StatisticList.J[Item.getId((Item) this)]);
		return var1;
	}

	protected void c(ItemStack var1, World var2, EntityHuman var3) {
		if (!var2.D && this.l > 0 && var2.s.nextFloat() < this.o) {
			var3.c(new MobEffect(this.l, this.m * 20, this.n));
		}

	}

	public int d(ItemStack var1) {
		return 32;
	}

	public ano e(ItemStack var1) {
		return ano.b;
	}

	public ItemStack a(ItemStack var1, World var2, EntityHuman var3) {
		if (var3.j(this.k)) {
			var3.a(var1, this.d(var1));
		}

		return var1;
	}

	public int h(ItemStack var1) {
		return this.b;
	}

	public float i(ItemStack var1) {
		return this.c;
	}

	public boolean g() {
		return this.d;
	}

	public all a(int var1, int var2, int var3, float var4) {
		this.l = var1;
		this.m = var2;
		this.n = var3;
		this.o = var4;
		return this;
	}

	public all h() {
		this.k = true;
		return this;
	}
}

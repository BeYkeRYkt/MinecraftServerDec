package net.minecraft;

public class ajg extends ajk {

	private final aje a;
	private EntityHuman b;
	private int c;
	private final aqb h;

	public ajg(EntityHuman var1, aqb var2, aje var3, int var4, int var5, int var6) {
		super(var3, var4, var5, var6);
		this.b = var1;
		this.h = var2;
		this.a = var3;
	}

	public boolean a(ItemStack var1) {
		return false;
	}

	public ItemStack a(int var1) {
		if (this.e()) {
			this.c += Math.min(var1, this.d().b);
		}

		return super.a(var1);
	}

	protected void a(ItemStack var1, int var2) {
		this.c += var2;
		this.c(var1);
	}

	protected void c(ItemStack var1) {
		var1.a(this.b.o, this.b, this.c);
		this.c = 0;
	}

	public void a(EntityHuman var1, ItemStack var2) {
		this.c(var2);
		aqc var3 = this.a.i();
		if (var3 != null) {
			ItemStack var4 = this.a.a(0);
			ItemStack var5 = this.a.a(1);
			if (this.a(var3, var4, var5) || this.a(var3, var5, var4)) {
				this.h.a(var3);
				var1.b(StatisticList.G);
				if (var4 != null && var4.b <= 0) {
					var4 = null;
				}

				if (var5 != null && var5.b <= 0) {
					var5 = null;
				}

				this.a.a(0, var4);
				this.a.a(1, var5);
			}
		}

	}

	private boolean a(aqc var1, ItemStack var2, ItemStack var3) {
		ItemStack var4 = var1.a();
		ItemStack var5 = var1.b();
		if (var2 != null && var2.getItem() == var4.getItem()) {
			if (var5 != null && var3 != null && var5.getItem() == var3.getItem()) {
				var2.b -= var4.b;
				var3.b -= var5.b;
				return true;
			}

			if (var5 == null && var3 == null) {
				var2.b -= var4.b;
				return true;
			}
		}

		return false;
	}
}

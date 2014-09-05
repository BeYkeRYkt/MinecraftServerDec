package net.minecraft;

public class aix extends Container {

	private final IInventory a;

	public aix(PlayerInventory var1, IInventory var2, EntityHuman var3) {
		this.a = var2;
		var2.b(var3);
		byte var4 = 51;

		int var5;
		for (var5 = 0; var5 < var2.n_(); ++var5) {
			this.a(new ajk(var2, var5, 44 + var5 * 18, 20));
		}

		for (var5 = 0; var5 < 3; ++var5) {
			for (int var6 = 0; var6 < 9; ++var6) {
				this.a(new ajk(var1, var6 + var5 * 9 + 9, 8 + var6 * 18, var5 * 18 + var4));
			}
		}

		for (var5 = 0; var5 < 9; ++var5) {
			this.a(new ajk(var1, var5, 8 + var5 * 18, 58 + var4));
		}

	}

	public boolean a(EntityHuman var1) {
		return this.a.a(var1);
	}

	public ItemStack b(EntityHuman var1, int var2) {
		ItemStack var3 = null;
		ajk var4 = (ajk) this.c.get(var2);
		if (var4 != null && var4.e()) {
			ItemStack var5 = var4.d();
			var3 = var5.getCopy();
			if (var2 < this.a.n_()) {
				if (!this.a(var5, this.a.n_(), this.c.size(), true)) {
					return null;
				}
			} else if (!this.a(var5, 0, this.a.n_(), false)) {
				return null;
			}

			if (var5.b == 0) {
				var4.d((ItemStack) null);
			} else {
				var4.f();
			}
		}

		return var3;
	}

	public void b(EntityHuman var1) {
		super.b(var1);
		this.a.c(var1);
	}
}

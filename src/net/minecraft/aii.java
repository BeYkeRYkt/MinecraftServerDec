package net.minecraft;

public class aii extends Container {

	private IInventory a;
	private final ajk f;
	private int g;

	public aii(PlayerInventory var1, IInventory var2) {
		this.a = var2;
		this.a((ajk) (new aik(var1.d, var2, 0, 56, 46)));
		this.a((ajk) (new aik(var1.d, var2, 1, 79, 53)));
		this.a((ajk) (new aik(var1.d, var2, 2, 102, 46)));
		this.f = this.a((ajk) (new aij(this, var2, 3, 79, 17)));

		int var3;
		for (var3 = 0; var3 < 3; ++var3) {
			for (int var4 = 0; var4 < 9; ++var4) {
				this.a(new ajk(var1, var4 + var3 * 9 + 9, 8 + var4 * 18, 84 + var3 * 18));
			}
		}

		for (var3 = 0; var3 < 9; ++var3) {
			this.a(new ajk(var1, var3, 8 + var3 * 18, 142));
		}

	}

	public void a(ICrafting var1) {
		super.a(var1);
		var1.a(this, this.a);
	}

	public void b() {
		super.b();

		for (int var1 = 0; var1 < this.e.size(); ++var1) {
			ICrafting var2 = (ICrafting) this.e.get(var1);
			if (this.g != this.a.a_(0)) {
				var2.a(this, 0, this.a.a_(0));
			}
		}

		this.g = this.a.a_(0);
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
			if ((var2 < 0 || var2 > 2) && var2 != 3) {
				if (!this.f.e() && this.f.a(var5)) {
					if (!this.a(var5, 3, 4, false)) {
						return null;
					}
				} else if (aik.b_(var3)) {
					if (!this.a(var5, 0, 3, false)) {
						return null;
					}
				} else if (var2 >= 4 && var2 < 31) {
					if (!this.a(var5, 31, 40, false)) {
						return null;
					}
				} else if (var2 >= 31 && var2 < 40) {
					if (!this.a(var5, 4, 31, false)) {
						return null;
					}
				} else if (!this.a(var5, 4, 40, false)) {
					return null;
				}
			} else {
				if (!this.a(var5, 4, 40, true)) {
					return null;
				}

				var4.a(var5, var3);
			}

			if (var5.b == 0) {
				var4.d((ItemStack) null);
			} else {
				var4.f();
			}

			if (var5.b == var3.b) {
				return null;
			}

			var4.a(var1, var5);
		}

		return var3;
	}
}

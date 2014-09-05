package net.minecraft;

public class aiy extends Container {

	private IInventory a;
	private abt f;

	public aiy(IInventory var1, IInventory var2, abt var3, EntityHuman var4) {
		this.a = var2;
		this.f = var3;
		byte var5 = 3;
		var2.b(var4);
		int var6 = (var5 - 4) * 18;
		this.a(new aiz(this, var2, 0, 8, 18));
		this.a(new aja(this, var2, 1, 8, 36, var3));
		int var7;
		int var8;
		if (var3.cu()) {
			for (var7 = 0; var7 < var5; ++var7) {
				for (var8 = 0; var8 < 5; ++var8) {
					this.a(new ajk(var2, 2 + var8 + var7 * 5, 80 + var8 * 18, 18 + var7 * 18));
				}
			}
		}

		for (var7 = 0; var7 < 3; ++var7) {
			for (var8 = 0; var8 < 9; ++var8) {
				this.a(new ajk(var1, var8 + var7 * 9 + 9, 8 + var8 * 18, 102 + var7 * 18 + var6));
			}
		}

		for (var7 = 0; var7 < 9; ++var7) {
			this.a(new ajk(var1, var7, 8 + var7 * 18, 160 + var6));
		}

	}

	public boolean a(EntityHuman var1) {
		return this.a.a(var1) && this.f.ai() && this.f.g((Entity) var1) < 8.0F;
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
			} else if (this.a(1).a(var5) && !this.a(1).e()) {
				if (!this.a(var5, 1, 2, false)) {
					return null;
				}
			} else if (this.a(0).a(var5)) {
				if (!this.a(var5, 0, 1, false)) {
					return null;
				}
			} else if (this.a.n_() <= 2 || !this.a(var5, 2, this.a.n_(), false)) {
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

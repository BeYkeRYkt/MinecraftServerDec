package net.minecraft;

public class aos implements aoo {

	private final int a;
	private final int b;
	private final ItemStack[] c;
	private final ItemStack d;
	private boolean e;

	public aos(int var1, int var2, ItemStack[] var3, ItemStack var4) {
		this.a = var1;
		this.b = var2;
		this.c = var3;
		this.d = var4;
	}

	public ItemStack b() {
		return this.d;
	}

	public ItemStack[] b(ain var1) {
		ItemStack[] var2 = new ItemStack[var1.n_()];

		for (int var3 = 0; var3 < var2.length; ++var3) {
			ItemStack var4 = var1.a(var3);
			if (var4 != null && var4.getItem().r()) {
				var2[var3] = new ItemStack(var4.getItem().getCraftingResult());
			}
		}

		return var2;
	}

	public boolean a(ain var1, World var2) {
		for (int var3 = 0; var3 <= 3 - this.a; ++var3) {
			for (int var4 = 0; var4 <= 3 - this.b; ++var4) {
				if (this.a(var1, var3, var4, true)) {
					return true;
				}

				if (this.a(var1, var3, var4, false)) {
					return true;
				}
			}
		}

		return false;
	}

	private boolean a(ain var1, int var2, int var3, boolean var4) {
		for (int var5 = 0; var5 < 3; ++var5) {
			for (int var6 = 0; var6 < 3; ++var6) {
				int var7 = var5 - var2;
				int var8 = var6 - var3;
				ItemStack var9 = null;
				if (var7 >= 0 && var8 >= 0 && var7 < this.a && var8 < this.b) {
					if (var4) {
						var9 = this.c[this.a - var7 - 1 + var8 * this.a];
					} else {
						var9 = this.c[var7 + var8 * this.a];
					}
				}

				ItemStack var10 = var1.c(var5, var6);
				if (var10 != null || var9 != null) {
					if (var10 == null && var9 != null || var10 != null && var9 == null) {
						return false;
					}

					if (var9.getItem() != var10.getItem()) {
						return false;
					}

					if (var9.i() != 32767 && var9.i() != var10.i()) {
						return false;
					}
				}
			}
		}

		return true;
	}

	public ItemStack a(ain var1) {
		ItemStack var2 = this.b().getCopy();
		if (this.e) {
			for (int var3 = 0; var3 < var1.n_(); ++var3) {
				ItemStack var4 = var1.a(var3);
				if (var4 != null && var4.hasTag()) {
					var2.d((NBTCompoundTag) var4.getTag().getCopy());
				}
			}
		}

		return var2;
	}

	public int a() {
		return this.a * this.b;
	}

	public aos c() {
		this.e = true;
		return this;
	}
}

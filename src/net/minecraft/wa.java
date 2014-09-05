package net.minecraft;

import com.google.common.collect.Lists;
import java.util.List;

public class wa implements IInventory {

	private String a;
	private int b;
	private ItemStack[] c;
	private List d;
	private boolean e;

	public wa(String var1, boolean var2, int var3) {
		this.a = var1;
		this.e = var2;
		this.b = var3;
		this.c = new ItemStack[var3];
	}

	public void a(vr var1) {
		if (this.d == null) {
			this.d = Lists.newArrayList();
		}

		this.d.add(var1);
	}

	public void b(vr var1) {
		this.d.remove(var1);
	}

	public ItemStack a(int var1) {
		return var1 >= 0 && var1 < this.c.length ? this.c[var1] : null;
	}

	public ItemStack a(int var1, int var2) {
		if (this.c[var1] != null) {
			ItemStack var3;
			if (this.c[var1].b <= var2) {
				var3 = this.c[var1];
				this.c[var1] = null;
				this.o_();
				return var3;
			} else {
				var3 = this.c[var1].a(var2);
				if (this.c[var1].b == 0) {
					this.c[var1] = null;
				}

				this.o_();
				return var3;
			}
		} else {
			return null;
		}
	}

	public ItemStack a(ItemStack var1) {
		ItemStack var2 = var1.getCopy();

		for (int var3 = 0; var3 < this.b; ++var3) {
			ItemStack var4 = this.a(var3);
			if (var4 == null) {
				this.a(var3, var2);
				this.o_();
				return null;
			}

			if (ItemStack.c(var4, var2)) {
				int var5 = Math.min(this.p_(), var4.c());
				int var6 = Math.min(var2.b, var5 - var4.b);
				if (var6 > 0) {
					var4.b += var6;
					var2.b -= var6;
					if (var2.b <= 0) {
						this.o_();
						return null;
					}
				}
			}
		}

		if (var2.b != var1.b) {
			this.o_();
		}

		return var2;
	}

	public ItemStack b(int var1) {
		if (this.c[var1] != null) {
			ItemStack var2 = this.c[var1];
			this.c[var1] = null;
			return var2;
		} else {
			return null;
		}
	}

	public void a(int var1, ItemStack var2) {
		this.c[var1] = var2;
		if (var2 != null && var2.b > this.p_()) {
			var2.b = this.p_();
		}

		this.o_();
	}

	public int n_() {
		return this.b;
	}

	public String d_() {
		return this.a;
	}

	public boolean k_() {
		return this.e;
	}

	public void a(String var1) {
		this.e = true;
		this.a = var1;
	}

	public IJSONComponent e_() {
		return (IJSONComponent) (this.k_() ? new hy(this.d_()) : new hz(this.d_(), new Object[0]));
	}

	public int p_() {
		return 64;
	}

	public void o_() {
		if (this.d != null) {
			for (int var1 = 0; var1 < this.d.size(); ++var1) {
				((vr) this.d.get(var1)).a(this);
			}
		}

	}

	public boolean a(EntityHuman var1) {
		return true;
	}

	public void b(EntityHuman var1) {
	}

	public void c(EntityHuman var1) {
	}

	public boolean b(int var1, ItemStack var2) {
		return true;
	}

	public int a_(int var1) {
		return 0;
	}

	public void b(int var1, int var2) {
	}

	public int g() {
		return 0;
	}

	public void l() {
		for (int var1 = 0; var1 < this.c.length; ++var1) {
			this.c[var1] = null;
		}

	}
}

package net.minecraft;

import java.util.Random;

public class bcx extends bdf implements vq {

	private static final Random f = new Random();
	private amj[] g = new amj[9];
	protected String a;

	public int n_() {
		return 9;
	}

	public amj a(int var1) {
		return this.g[var1];
	}

	public amj a(int var1, int var2) {
		if (this.g[var1] != null) {
			amj var3;
			if (this.g[var1].b <= var2) {
				var3 = this.g[var1];
				this.g[var1] = null;
				this.o_();
				return var3;
			} else {
				var3 = this.g[var1].a(var2);
				if (this.g[var1].b == 0) {
					this.g[var1] = null;
				}

				this.o_();
				return var3;
			}
		} else {
			return null;
		}
	}

	public amj b(int var1) {
		if (this.g[var1] != null) {
			amj var2 = this.g[var1];
			this.g[var1] = null;
			return var2;
		} else {
			return null;
		}
	}

	public int m() {
		int var1 = -1;
		int var2 = 1;

		for (int var3 = 0; var3 < this.g.length; ++var3) {
			if (this.g[var3] != null && f.nextInt(var2++) == 0) {
				var1 = var3;
			}
		}

		return var1;
	}

	public void a(int var1, amj var2) {
		this.g[var1] = var2;
		if (var2 != null && var2.b > this.p_()) {
			var2.b = this.p_();
		}

		this.o_();
	}

	public int a(amj var1) {
		for (int var2 = 0; var2 < this.g.length; ++var2) {
			if (this.g[var2] == null || this.g[var2].b() == null) {
				this.a(var2, var1);
				return var2;
			}
		}

		return -1;
	}

	public String d_() {
		return this.k_() ? this.a : "container.dispenser";
	}

	public void a(String var1) {
		this.a = var1;
	}

	public boolean k_() {
		return this.a != null;
	}

	public void a(NBTCompoundTag var1) {
		super.a(var1);
		NBTListTag var2 = var1.c("Items", 10);
		this.g = new amj[this.n_()];

		for (int var3 = 0; var3 < var2.c(); ++var3) {
			NBTCompoundTag var4 = var2.b(var3);
			int var5 = var4.d("Slot") & 255;
			if (var5 >= 0 && var5 < this.g.length) {
				this.g[var5] = amj.a(var4);
			}
		}

		if (var1.b("CustomName", 8)) {
			this.a = var1.j("CustomName");
		}

	}

	public void b(NBTCompoundTag var1) {
		super.b(var1);
		NBTListTag var2 = new NBTListTag();

		for (int var3 = 0; var3 < this.g.length; ++var3) {
			if (this.g[var3] != null) {
				NBTCompoundTag var4 = new NBTCompoundTag();
				var4.a("Slot", (byte) var3);
				this.g[var3].b(var4);
				var2.a((NBTTag) var4);
			}
		}

		var1.a("Items", (NBTTag) var2);
		if (this.k_()) {
			var1.a("CustomName", this.a);
		}

	}

	public int p_() {
		return 64;
	}

	public boolean a(ahd var1) {
		return this.b.s(this.c) != this ? false : var1.e((double) this.c.n() + 0.5D, (double) this.c.o() + 0.5D, (double) this.c.p() + 0.5D) <= 64.0D;
	}

	public void b(ahd var1) {
	}

	public void c(ahd var1) {
	}

	public boolean b(int var1, amj var2) {
		return true;
	}

	public String k() {
		return "minecraft:dispenser";
	}

	public aib a(ahb var1, ahd var2) {
		return new aip(var1, this);
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
		for (int var1 = 0; var1 < this.g.length; ++var1) {
			this.g[var1] = null;
		}

	}

}

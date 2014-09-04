package net.minecraft;

public class ain implements vq {

	private final amj[] a;
	private final int b;
	private final int c;
	private final aib d;

	public ain(aib var1, int var2, int var3) {
		int var4 = var2 * var3;
		this.a = new amj[var4];
		this.d = var1;
		this.b = var2;
		this.c = var3;
	}

	public int n_() {
		return this.a.length;
	}

	public amj a(int var1) {
		return var1 >= this.n_() ? null : this.a[var1];
	}

	public amj c(int var1, int var2) {
		return var1 >= 0 && var1 < this.b && var2 >= 0 && var2 <= this.c ? this.a(var1 + var2 * this.b) : null;
	}

	public String d_() {
		return "container.crafting";
	}

	public boolean k_() {
		return false;
	}

	public ho e_() {
		return (ho) (this.k_() ? new hy(this.d_()) : new hz(this.d_(), new Object[0]));
	}

	public amj b(int var1) {
		if (this.a[var1] != null) {
			amj var2 = this.a[var1];
			this.a[var1] = null;
			return var2;
		} else {
			return null;
		}
	}

	public amj a(int var1, int var2) {
		if (this.a[var1] != null) {
			amj var3;
			if (this.a[var1].b <= var2) {
				var3 = this.a[var1];
				this.a[var1] = null;
				this.d.a((vq) this);
				return var3;
			} else {
				var3 = this.a[var1].a(var2);
				if (this.a[var1].b == 0) {
					this.a[var1] = null;
				}

				this.d.a((vq) this);
				return var3;
			}
		} else {
			return null;
		}
	}

	public void a(int var1, amj var2) {
		this.a[var1] = var2;
		this.d.a((vq) this);
	}

	public int p_() {
		return 64;
	}

	public void o_() {
	}

	public boolean a(ahd var1) {
		return true;
	}

	public void b(ahd var1) {
	}

	public void c(ahd var1) {
	}

	public boolean b(int var1, amj var2) {
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
		for (int var1 = 0; var1 < this.a.length; ++var1) {
			this.a[var1] = null;
		}

	}

	public int h() {
		return this.c;
	}

	public int i() {
		return this.b;
	}
}

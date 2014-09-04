package net.minecraft;

public class aje implements vq {

	private final aqb a;
	private amj[] b = new amj[3];
	private final ahd c;
	private aqc d;
	private int e;

	public aje(ahd var1, aqb var2) {
		this.c = var1;
		this.a = var2;
	}

	public int n_() {
		return this.b.length;
	}

	public amj a(int var1) {
		return this.b[var1];
	}

	public amj a(int var1, int var2) {
		if (this.b[var1] != null) {
			amj var3;
			if (var1 == 2) {
				var3 = this.b[var1];
				this.b[var1] = null;
				return var3;
			} else if (this.b[var1].b <= var2) {
				var3 = this.b[var1];
				this.b[var1] = null;
				if (this.e(var1)) {
					this.h();
				}

				return var3;
			} else {
				var3 = this.b[var1].a(var2);
				if (this.b[var1].b == 0) {
					this.b[var1] = null;
				}

				if (this.e(var1)) {
					this.h();
				}

				return var3;
			}
		} else {
			return null;
		}
	}

	private boolean e(int var1) {
		return var1 == 0 || var1 == 1;
	}

	public amj b(int var1) {
		if (this.b[var1] != null) {
			amj var2 = this.b[var1];
			this.b[var1] = null;
			return var2;
		} else {
			return null;
		}
	}

	public void a(int var1, amj var2) {
		this.b[var1] = var2;
		if (var2 != null && var2.b > this.p_()) {
			var2.b = this.p_();
		}

		if (this.e(var1)) {
			this.h();
		}

	}

	public String d_() {
		return "mob.villager";
	}

	public boolean k_() {
		return false;
	}

	public ho e_() {
		return (ho) (this.k_() ? new hy(this.d_()) : new hz(this.d_(), new Object[0]));
	}

	public int p_() {
		return 64;
	}

	public boolean a(ahd var1) {
		return this.a.u_() == var1;
	}

	public void b(ahd var1) {
	}

	public void c(ahd var1) {
	}

	public boolean b(int var1, amj var2) {
		return true;
	}

	public void o_() {
		this.h();
	}

	public void h() {
		this.d = null;
		amj var1 = this.b[0];
		amj var2 = this.b[1];
		if (var1 == null) {
			var1 = var2;
			var2 = null;
		}

		if (var1 == null) {
			this.a(2, (amj) null);
		} else {
			aqd var3 = this.a.b_(this.c);
			if (var3 != null) {
				aqc var4 = var3.a(var1, var2, this.e);
				if (var4 != null && !var4.h()) {
					this.d = var4;
					this.a(2, var4.d().k());
				} else if (var2 != null) {
					var4 = var3.a(var2, var1, this.e);
					if (var4 != null && !var4.h()) {
						this.d = var4;
						this.a(2, var4.d().k());
					} else {
						this.a(2, (amj) null);
					}
				} else {
					this.a(2, (amj) null);
				}
			}
		}

		this.a.a_(this.a(2));
	}

	public aqc i() {
		return this.d;
	}

	public void d(int var1) {
		this.e = var1;
		this.h();
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
		for (int var1 = 0; var1 < this.b.length; ++var1) {
			this.b[var1] = null;
		}

	}
}

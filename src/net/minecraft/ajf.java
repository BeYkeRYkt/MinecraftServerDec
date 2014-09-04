package net.minecraft;

public class ajf extends aib {

	private aqb a;
	private aje f;
	private final World g;

	public ajf(ahb var1, aqb var2, World var3) {
		this.a = var2;
		this.g = var3;
		this.f = new aje(var1.d, var2);
		this.a(new ajk(this.f, 0, 36, 53));
		this.a(new ajk(this.f, 1, 62, 53));
		this.a((ajk) (new ajg(var1.d, var2, this.f, 2, 120, 53)));

		int var4;
		for (var4 = 0; var4 < 3; ++var4) {
			for (int var5 = 0; var5 < 9; ++var5) {
				this.a(new ajk(var1, var5 + var4 * 9 + 9, 8 + var5 * 18, 84 + var4 * 18));
			}
		}

		for (var4 = 0; var4 < 9; ++var4) {
			this.a(new ajk(var1, var4, 8 + var4 * 18, 142));
		}

	}

	public aje e() {
		return this.f;
	}

	public void a(ail var1) {
		super.a(var1);
	}

	public void b() {
		super.b();
	}

	public void a(vq var1) {
		this.f.h();
		super.a(var1);
	}

	public void d(int var1) {
		this.f.d(var1);
	}

	public boolean a(ahd var1) {
		return this.a.u_() == var1;
	}

	public amj b(ahd var1, int var2) {
		amj var3 = null;
		ajk var4 = (ajk) this.c.get(var2);
		if (var4 != null && var4.e()) {
			amj var5 = var4.d();
			var3 = var5.k();
			if (var2 == 2) {
				if (!this.a(var5, 3, 39, true)) {
					return null;
				}

				var4.a(var5, var3);
			} else if (var2 != 0 && var2 != 1) {
				if (var2 >= 3 && var2 < 30) {
					if (!this.a(var5, 30, 39, false)) {
						return null;
					}
				} else if (var2 >= 30 && var2 < 39 && !this.a(var5, 3, 30, false)) {
					return null;
				}
			} else if (!this.a(var5, 3, 39, false)) {
				return null;
			}

			if (var5.b == 0) {
				var4.d((amj) null);
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

	public void b(ahd var1) {
		super.b(var1);
		this.a.a_((ahd) null);
		super.b(var1);
		if (!this.g.D) {
			amj var2 = this.f.b(0);
			if (var2 != null) {
				var1.a(var2, false);
			}

			var2 = this.f.b(1);
			if (var2 != null) {
				var1.a(var2, false);
			}

		}
	}
}

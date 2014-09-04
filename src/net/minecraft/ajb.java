package net.minecraft;

public class ajb extends aib {

	public ain a = new ain(this, 2, 2);
	public vq f = new aji();
	public boolean g;
	private final ahd h;

	public ajb(ahb var1, boolean var2, ahd var3) {
		this.g = var2;
		this.h = var3;
		this.a((ajk) (new ajj(var1.d, this.a, this.f, 0, 144, 36)));

		int var4;
		int var5;
		for (var4 = 0; var4 < 2; ++var4) {
			for (var5 = 0; var5 < 2; ++var5) {
				this.a(new ajk(this.a, var5 + var4 * 2, 88 + var5 * 18, 26 + var4 * 18));
			}
		}

		for (var4 = 0; var4 < 4; ++var4) {
			this.a((ajk) (new ajc(this, var1, var1.n_() - 1 - var4, 8, 8 + var4 * 18, var4)));
		}

		for (var4 = 0; var4 < 3; ++var4) {
			for (var5 = 0; var5 < 9; ++var5) {
				this.a(new ajk(var1, var5 + (var4 + 1) * 9, 8 + var5 * 18, 84 + var4 * 18));
			}
		}

		for (var4 = 0; var4 < 9; ++var4) {
			this.a(new ajk(var1, var4, 8 + var4 * 18, 142));
		}

		this.a((vq) this.a);
	}

	public void a(vq var1) {
		this.f.a(0, aop.a().a(this.a, this.h.o));
	}

	public void b(ahd var1) {
		super.b(var1);

		for (int var2 = 0; var2 < 4; ++var2) {
			amj var3 = this.a.b(var2);
			if (var3 != null) {
				var1.a(var3, false);
			}
		}

		this.f.a(0, (amj) null);
	}

	public boolean a(ahd var1) {
		return true;
	}

	public amj b(ahd var1, int var2) {
		amj var3 = null;
		ajk var4 = (ajk) this.c.get(var2);
		if (var4 != null && var4.e()) {
			amj var5 = var4.d();
			var3 = var5.k();
			if (var2 == 0) {
				if (!this.a(var5, 9, 45, true)) {
					return null;
				}

				var4.a(var5, var3);
			} else if (var2 >= 1 && var2 < 5) {
				if (!this.a(var5, 9, 45, false)) {
					return null;
				}
			} else if (var2 >= 5 && var2 < 9) {
				if (!this.a(var5, 9, 45, false)) {
					return null;
				}
			} else if (var3.b() instanceof ajn && !((ajk) this.c.get(5 + ((ajn) var3.b()).b)).e()) {
				int var6 = 5 + ((ajn) var3.b()).b;
				if (!this.a(var5, var6, var6 + 1, false)) {
					return null;
				}
			} else if (var2 >= 9 && var2 < 36) {
				if (!this.a(var5, 36, 45, false)) {
					return null;
				}
			} else if (var2 >= 36 && var2 < 45) {
				if (!this.a(var5, 9, 36, false)) {
					return null;
				}
			} else if (!this.a(var5, 9, 45, false)) {
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

	public boolean a(amj var1, ajk var2) {
		return var2.d != this.f && super.a(var1, var2);
	}
}

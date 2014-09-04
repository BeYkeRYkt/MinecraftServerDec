package net.minecraft;

public class aim extends aib {

	private vq a;
	private int f;

	public aim(vq var1, vq var2, ahd var3) {
		this.a = var2;
		this.f = var2.n_() / 9;
		var2.b(var3);
		int var4 = (this.f - 4) * 18;

		int var5;
		int var6;
		for (var5 = 0; var5 < this.f; ++var5) {
			for (var6 = 0; var6 < 9; ++var6) {
				this.a(new ajk(var2, var6 + var5 * 9, 8 + var6 * 18, 18 + var5 * 18));
			}
		}

		for (var5 = 0; var5 < 3; ++var5) {
			for (var6 = 0; var6 < 9; ++var6) {
				this.a(new ajk(var1, var6 + var5 * 9 + 9, 8 + var6 * 18, 103 + var5 * 18 + var4));
			}
		}

		for (var5 = 0; var5 < 9; ++var5) {
			this.a(new ajk(var1, var5, 8 + var5 * 18, 161 + var4));
		}

	}

	public boolean a(ahd var1) {
		return this.a.a(var1);
	}

	public amj b(ahd var1, int var2) {
		amj var3 = null;
		ajk var4 = (ajk) this.c.get(var2);
		if (var4 != null && var4.e()) {
			amj var5 = var4.d();
			var3 = var5.k();
			if (var2 < this.f * 9) {
				if (!this.a(var5, this.f * 9, this.c.size(), true)) {
					return null;
				}
			} else if (!this.a(var5, 0, this.f * 9, false)) {
				return null;
			}

			if (var5.b == 0) {
				var4.d((amj) null);
			} else {
				var4.f();
			}
		}

		return var3;
	}

	public void b(ahd var1) {
		super.b(var1);
		this.a.c(var1);
	}

	public vq e() {
		return this.a;
	}
}

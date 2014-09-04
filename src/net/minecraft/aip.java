package net.minecraft;

public class aip extends aib {

	private vq a;

	public aip(vq var1, vq var2) {
		this.a = var2;

		int var3;
		int var4;
		for (var3 = 0; var3 < 3; ++var3) {
			for (var4 = 0; var4 < 3; ++var4) {
				this.a(new ajk(var2, var4 + var3 * 3, 62 + var4 * 18, 17 + var3 * 18));
			}
		}

		for (var3 = 0; var3 < 3; ++var3) {
			for (var4 = 0; var4 < 9; ++var4) {
				this.a(new ajk(var1, var4 + var3 * 9 + 9, 8 + var4 * 18, 84 + var3 * 18));
			}
		}

		for (var3 = 0; var3 < 9; ++var3) {
			this.a(new ajk(var1, var3, 8 + var3 * 18, 142));
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
			if (var2 < 9) {
				if (!this.a(var5, 9, 45, true)) {
					return null;
				}
			} else if (!this.a(var5, 0, 9, false)) {
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
}

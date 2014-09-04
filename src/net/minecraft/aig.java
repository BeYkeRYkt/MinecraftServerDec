package net.minecraft;

public class aig extends aib {

	private vq a;
	private final aih f;

	public aig(vq var1, vq var2) {
		this.a = var2;
		this.a((ajk) (this.f = new aih(this, var2, 0, 136, 110)));
		byte var3 = 36;
		short var4 = 137;

		int var5;
		for (var5 = 0; var5 < 3; ++var5) {
			for (int var6 = 0; var6 < 9; ++var6) {
				this.a(new ajk(var1, var6 + var5 * 9 + 9, var3 + var6 * 18, var4 + var5 * 18));
			}
		}

		for (var5 = 0; var5 < 9; ++var5) {
			this.a(new ajk(var1, var5, var3 + var5 * 18, 58 + var4));
		}

	}

	public void a(ail var1) {
		super.a(var1);
		var1.a(this, this.a);
	}

	public vq e() {
		return this.a;
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
			if (var2 == 0) {
				if (!this.a(var5, 1, 37, true)) {
					return null;
				}

				var4.a(var5, var3);
			} else if (!this.f.e() && this.f.a(var5) && var5.b == 1) {
				if (!this.a(var5, 0, 1, false)) {
					return null;
				}
			} else if (var2 >= 1 && var2 < 28) {
				if (!this.a(var5, 28, 37, false)) {
					return null;
				}
			} else if (var2 >= 28 && var2 < 37) {
				if (!this.a(var5, 1, 28, false)) {
					return null;
				}
			} else if (!this.a(var5, 1, 37, false)) {
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

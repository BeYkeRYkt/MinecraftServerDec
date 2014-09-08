package net.minecraft;

class blf {

	int a;
	blf[] b = new blf[6];
	boolean[] c = new boolean[6];
	boolean d;
	boolean e;
	int f;

	public blf(int var1) {
		this.a = var1;
	}

	public void a(BlockFace var1, blf var2) {
		this.b[var1.getId()] = var2;
		var2.b[var1.getOpposite().getId()] = this;
	}

	public void a() {
		for (int var1 = 0; var1 < 6; ++var1) {
			this.c[var1] = this.b[var1] != null;
		}

	}

	public boolean a(int var1) {
		if (this.e) {
			return true;
		} else {
			this.f = var1;

			for (int var2 = 0; var2 < 6; ++var2) {
				if (this.b[var2] != null && this.c[var2] && this.b[var2].f != var1 && this.b[var2].a(var1)) {
					return true;
				}
			}

			return false;
		}
	}

	public boolean b() {
		return this.a >= 75;
	}

	public int c() {
		int var1 = 0;

		for (int var2 = 0; var2 < 6; ++var2) {
			if (this.c[var2]) {
				++var1;
			}
		}

		return var1;
	}
}

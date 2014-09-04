package net.minecraft;

import java.util.Random;

class bmf extends bmu {

	private bmf() {
	}

	public void a(Random var1, int var2, int var3, int var4, boolean var5) {
		if (var5) {
			float var6 = var1.nextFloat();
			if (var6 < 0.2F) {
				this.a = aty.bf.a(bbc.N);
			} else if (var6 < 0.5F) {
				this.a = aty.bf.a(bbc.M);
			} else if (var6 < 0.55F) {
				this.a = aty.be.a(axu.c.a());
			} else {
				this.a = aty.bf.P();
			}
		} else {
			this.a = aty.a.P();
		}

	}

	// $FF: synthetic method
	bmf(bls var1) {
		this();
	}
}

package net.minecraft;

import java.util.Random;

class blm extends bmu {

	private blm() {
	}

	public void a(Random var1, int var2, int var3, int var4, boolean var5) {
		if (var1.nextFloat() < 0.4F) {
			this.a = aty.e.P();
		} else {
			this.a = aty.Y.P();
		}

	}

	// $FF: synthetic method
	blm(blj var1) {
		this();
	}
}

package net.minecraft;

import java.util.Random;

public class adp extends vk {

	private final amj b;
	private float c;
	private boolean d;

	public adp(amj var1, int var2) {
		super(var2);
		this.b = var1;
	}

	public amj a(Random var1) {
		amj var2 = this.b.k();
		if (this.c > 0.0F) {
			int var3 = (int) (this.c * (float) this.b.j());
			int var4 = var2.j() - var1.nextInt(var1.nextInt(var3) + 1);
			if (var4 > var3) {
				var4 = var3;
			}

			if (var4 < 1) {
				var4 = 1;
			}

			var2.b(var4);
		}

		if (this.d) {
			aph.a(var1, var2, 30);
		}

		return var2;
	}

	public adp a(float var1) {
		this.c = var1;
		return this;
	}

	public adp a() {
		this.d = true;
		return this;
	}
}

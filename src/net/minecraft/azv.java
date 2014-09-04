package net.minecraft;

import java.util.Random;

public class azv extends atr {

	private final boolean a;

	public azv(boolean var1) {
		super(bof.t);
		this.a = var1;
		if (var1) {
			this.a(1.0F);
		}

	}

	public void c(World var1, dt var2, bec var3) {
		if (!var1.D) {
			if (this.a && !var1.z(var2)) {
				var1.a(var2, aty.bJ.P(), 2);
			} else if (!this.a && var1.z(var2)) {
				var1.a(var2, aty.bK.P(), 2);
			}

		}
	}

	public void a(World var1, dt var2, bec var3, atr var4) {
		if (!var1.D) {
			if (this.a && !var1.z(var2)) {
				var1.a(var2, (atr) this, 4);
			} else if (!this.a && var1.z(var2)) {
				var1.a(var2, aty.bK.P(), 2);
			}

		}
	}

	public void b(World var1, dt var2, bec var3, Random var4) {
		if (!var1.D) {
			if (this.a && !var1.z(var2)) {
				var1.a(var2, aty.bJ.P(), 2);
			}

		}
	}

	public alq a(bec var1, Random var2, int var3) {
		return alq.a(aty.bJ);
	}

	protected amj i(bec var1) {
		return new amj(aty.bJ);
	}
}

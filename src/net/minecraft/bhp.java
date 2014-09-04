package net.minecraft;

import java.util.Random;

public abstract class bhp {

	private final boolean a;

	public bhp() {
		this(false);
	}

	public bhp(boolean var1) {
		this.a = var1;
	}

	public abstract boolean b(World var1, Random var2, dt var3);

	public void e() {
	}

	protected void a(World var1, dt var2, atr var3) {
		this.a(var1, var2, var3, 0);
	}

	protected void a(World var1, dt var2, atr var3, int var4) {
		this.a(var1, var2, var3.a(var4));
	}

	protected void a(World var1, dt var2, bec var3) {
		if (this.a) {
			var1.a(var2, var3, 3);
		} else {
			var1.a(var2, var3, 2);
		}

	}
}

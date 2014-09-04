package net.minecraft;

public class ur {

	private transient us[] a = new us[4096];
	private transient int b;
	private int c;
	private int d = 3072;
	private final float e = 0.75F;
	private transient volatile int f;

	public ur() {
		this.c = this.a.length - 1;
	}

	private static int g(long var0) {
		return a((int) (var0 ^ var0 >>> 32));
	}

	private static int a(int var0) {
		var0 ^= var0 >>> 20 ^ var0 >>> 12;
		return var0 ^ var0 >>> 7 ^ var0 >>> 4;
	}

	private static int a(int var0, int var1) {
		return var0 & var1;
	}

	public int a() {
		return this.b;
	}

	public Object a(long var1) {
		int var3 = g(var1);

		for (us var4 = this.a[a(var3, this.c)]; var4 != null; var4 = var4.c) {
			if (var4.a == var1) {
				return var4.b;
			}
		}

		return null;
	}

	public boolean b(long var1) {
		return this.c(var1) != null;
	}

	final us c(long var1) {
		int var3 = g(var1);

		for (us var4 = this.a[a(var3, this.c)]; var4 != null; var4 = var4.c) {
			if (var4.a == var1) {
				return var4;
			}
		}

		return null;
	}

	public void a(long var1, Object var3) {
		int var4 = g(var1);
		int var5 = a(var4, this.c);

		for (us var6 = this.a[var5]; var6 != null; var6 = var6.c) {
			if (var6.a == var1) {
				var6.b = var3;
				return;
			}
		}

		++this.f;
		this.a(var4, var1, var3, var5);
	}

	private void b(int var1) {
		us[] var2 = this.a;
		int var3 = var2.length;
		if (var3 == 1073741824) {
			this.d = Integer.MAX_VALUE;
		} else {
			us[] var4 = new us[var1];
			this.a(var4);
			this.a = var4;
			this.c = this.a.length - 1;
			this.d = (int) ((float) var1 * this.e);
		}
	}

	private void a(us[] var1) {
		us[] var2 = this.a;
		int var3 = var1.length;

		for (int var4 = 0; var4 < var2.length; ++var4) {
			us var5 = var2[var4];
			if (var5 != null) {
				var2[var4] = null;

				us var6;
				do {
					var6 = var5.c;
					int var7 = a(var5.d, var3 - 1);
					var5.c = var1[var7];
					var1[var7] = var5;
					var5 = var6;
				} while (var6 != null);
			}
		}

	}

	public Object d(long var1) {
		us var3 = this.e(var1);
		return var3 == null ? null : var3.b;
	}

	final us e(long var1) {
		int var3 = g(var1);
		int var4 = a(var3, this.c);
		us var5 = this.a[var4];

		us var6;
		us var7;
		for (var6 = var5; var6 != null; var6 = var7) {
			var7 = var6.c;
			if (var6.a == var1) {
				++this.f;
				--this.b;
				if (var5 == var6) {
					this.a[var4] = var7;
				} else {
					var5.c = var7;
				}

				return var6;
			}

			var5 = var6;
		}

		return var6;
	}

	private void a(int var1, long var2, Object var4, int var5) {
		us var6 = this.a[var5];
		this.a[var5] = new us(var1, var2, var4, var6);
		if (this.b++ >= this.d) {
			this.b(2 * this.a.length);
		}

	}

	// $FF: synthetic method
	static int f(long var0) {
		return g(var0);
	}
}

package net.minecraft;

public class LongHashMap {

	private transient LongHashMapEntry[] a = new LongHashMapEntry[4096];
	private transient int count;
	private int c;
	private int d = 3072;
	private final float e = 0.75F;
	private transient volatile int f;

	public LongHashMap() {
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

	public int count() {
		return this.count;
	}

	public Object getEntry(long var1) {
		int var3 = g(var1);

		for (LongHashMapEntry var4 = this.a[a(var3, this.c)]; var4 != null; var4 = var4.c) {
			if (var4.longHash == var1) {
				return var4.b;
			}
		}

		return null;
	}

	public boolean contains(long var1) {
		return this.c(var1) != null;
	}

	final LongHashMapEntry c(long var1) {
		int var3 = g(var1);

		for (LongHashMapEntry var4 = this.a[a(var3, this.c)]; var4 != null; var4 = var4.c) {
			if (var4.longHash == var1) {
				return var4;
			}
		}

		return null;
	}

	public void put(long var1, Object var3) {
		int var4 = g(var1);
		int var5 = a(var4, this.c);

		for (LongHashMapEntry var6 = this.a[var5]; var6 != null; var6 = var6.c) {
			if (var6.longHash == var1) {
				var6.b = var3;
				return;
			}
		}

		++this.f;
		this.a(var4, var1, var3, var5);
	}

	private void b(int var1) {
		LongHashMapEntry[] var2 = this.a;
		int var3 = var2.length;
		if (var3 == 1073741824) {
			this.d = Integer.MAX_VALUE;
		} else {
			LongHashMapEntry[] var4 = new LongHashMapEntry[var1];
			this.a(var4);
			this.a = var4;
			this.c = this.a.length - 1;
			this.d = (int) ((float) var1 * this.e);
		}
	}

	private void a(LongHashMapEntry[] var1) {
		LongHashMapEntry[] var2 = this.a;
		int var3 = var1.length;

		for (int var4 = 0; var4 < var2.length; ++var4) {
			LongHashMapEntry var5 = var2[var4];
			if (var5 != null) {
				var2[var4] = null;

				LongHashMapEntry var6;
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

	public Object remove(long var1) {
		LongHashMapEntry var3 = this.e(var1);
		return var3 == null ? null : var3.b;
	}

	final LongHashMapEntry e(long var1) {
		int var3 = g(var1);
		int var4 = a(var3, this.c);
		LongHashMapEntry var5 = this.a[var4];

		LongHashMapEntry var6;
		LongHashMapEntry var7;
		for (var6 = var5; var6 != null; var6 = var7) {
			var7 = var6.c;
			if (var6.longHash == var1) {
				++this.f;
				--this.count;
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
		LongHashMapEntry var6 = this.a[var5];
		this.a[var5] = new LongHashMapEntry(var1, var2, var4, var6);
		if (this.count++ >= this.d) {
			this.b(2 * this.a.length);
		}

	}

	// $FF: synthetic method
	static int f(long var0) {
		return g(var0);
	}
}

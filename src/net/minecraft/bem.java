package net.minecraft;

import com.google.common.cache.LoadingCache;

public class bem {

	private final dt a;
	private final ej b;
	private final ej c;
	private final LoadingCache d;

	public bem(dt var1, ej var2, ej var3, LoadingCache var4) {
		this.a = var1;
		this.b = var2;
		this.c = var3;
		this.d = var4;
	}

	public ej b() {
		return this.b;
	}

	public ej c() {
		return this.c;
	}

	public bei a(int var1, int var2, int var3) {
		return (bei) this.d.getUnchecked(bek.a(this.a, this.b(), this.c(), var1, var2, var3));
	}
}

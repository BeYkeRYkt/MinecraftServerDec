package net.minecraft;

import com.google.common.cache.Cache;

public class bem {

	private final Position a;
	private final BlockFace b;
	private final BlockFace c;
	private final Cache<Object, Object> d;

	public bem(Position var1, BlockFace var2, BlockFace var3, Cache<Object, Object> var4) {
		this.a = var1;
		this.b = var2;
		this.c = var3;
		this.d = var4;
	}

	public BlockFace b() {
		return this.b;
	}

	public BlockFace c() {
		return this.c;
	}

	public bei a(int var1, int var2, int var3) {
		return (bei) this.d.getUnchecked(bek.a(this.a, this.b(), this.c(), var1, var2, var3));
	}
}

package net.minecraft;

import com.google.common.base.Predicate;
import com.google.common.collect.Maps;
import java.util.Map;

public enum el implements Predicate, va {

	a("X", 0, "x", en.a), b("Y", 1, "y", en.b), c("Z", 2, "z", en.a);
	private static final Map d = Maps.newHashMap();
	private final String e;
	private final en f;
	// $FF: synthetic field
	private static final el[] g = new el[] { a, b, c };

	private el(String var1, int var2, String var3, en var4) {
		this.e = var3;
		this.f = var4;
	}

	public String a() {
		return this.e;
	}

	public boolean b() {
		return this.f == en.b;
	}

	public boolean c() {
		return this.f == en.a;
	}

	public String toString() {
		return this.e;
	}

	public boolean a(BlockFace var1) {
		return var1 != null && var1.k() == this;
	}

	public en d() {
		return this.f;
	}

	public String l() {
		return this.e;
	}

	// $FF: synthetic method
	public boolean apply(Object var1) {
		return this.a((BlockFace) var1);
	}

	static {
		el[] var0 = values();
		int var1 = var0.length;

		for (int var2 = 0; var2 < var1; ++var2) {
			el var3 = var0[var2];
			d.put(var3.a().toLowerCase(), var3);
		}

	}
}

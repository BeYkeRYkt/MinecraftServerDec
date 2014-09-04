package net.minecraft;

import com.google.common.collect.Maps;
import java.util.Map;

public enum bsl {

	a("INTEGER", 0, "integer"), b("HEARTS", 1, "hearts");
	private static final Map c = Maps.newHashMap();
	private final String d;
	// $FF: synthetic field
	private static final bsl[] e = new bsl[] { a, b };

	private bsl(String var1, int var2, String var3) {
		this.d = var3;
	}

	public String a() {
		return this.d;
	}

	public static bsl a(String var0) {
		bsl var1 = (bsl) c.get(var0);
		return var1 == null ? a : var1;
	}

	static {
		bsl[] var0 = values();
		int var1 = var0.length;

		for (int var2 = 0; var2 < var1; ++var2) {
			bsl var3 = var0[var2];
			c.put(var3.a(), var3);
		}

	}
}

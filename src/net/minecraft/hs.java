package net.minecraft;

import com.google.common.collect.Maps;
import java.util.Map;

public enum hs {

	a("SHOW_TEXT", 0, "show_text", true), b("SHOW_ACHIEVEMENT", 1, "show_achievement", true), c("SHOW_ITEM", 2, "show_item", true), d("SHOW_ENTITY", 3, "show_entity", true);
	private static final Map e = Maps.newHashMap();
	private final boolean f;
	private final String g;
	// $FF: synthetic field
	private static final hs[] h = new hs[] { a, b, c, d };

	private hs(String var1, int var2, String var3, boolean var4) {
		this.g = var3;
		this.f = var4;
	}

	public boolean a() {
		return this.f;
	}

	public String b() {
		return this.g;
	}

	public static hs a(String var0) {
		return (hs) e.get(var0);
	}

	static {
		hs[] var0 = values();
		int var1 = var0.length;

		for (int var2 = 0; var2 < var1; ++var2) {
			hs var3 = var0[var2];
			e.put(var3.b(), var3);
		}

	}
}

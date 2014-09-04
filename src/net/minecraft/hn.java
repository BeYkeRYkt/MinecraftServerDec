package net.minecraft;

import com.google.common.collect.Maps;
import java.util.Map;

public enum hn {

	a("OPEN_URL", 0, "open_url", true), b("OPEN_FILE", 1, "open_file", false), c("RUN_COMMAND", 2, "run_command", true), d("TWITCH_USER_INFO", 3, "twitch_user_info", false), e("SUGGEST_COMMAND", 4, "suggest_command", true), f("CHANGE_PAGE", 5, "change_page", true);
	private static final Map g = Maps.newHashMap();
	private final boolean h;
	private final String i;
	// $FF: synthetic field
	private static final hn[] j = new hn[] { a, b, c, d, e, f };

	private hn(String var1, int var2, String var3, boolean var4) {
		this.i = var3;
		this.h = var4;
	}

	public boolean a() {
		return this.h;
	}

	public String b() {
		return this.i;
	}

	public static hn a(String var0) {
		return (hn) g.get(var0);
	}

	static {
		hn[] var0 = values();
		int var1 = var0.length;

		for (int var2 = 0; var2 < var1; ++var2) {
			hn var3 = var0[var2];
			g.put(var3.b(), var3);
		}

	}
}

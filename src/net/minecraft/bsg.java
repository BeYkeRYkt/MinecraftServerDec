package net.minecraft;

import com.google.common.collect.Maps;
import java.util.Map;

public enum bsg {

	a("ALWAYS", 0, "always", 0), b("NEVER", 1, "never", 1), c("HIDE_FOR_OTHER_TEAMS", 2, "hideForOtherTeams", 2), d("HIDE_FOR_OWN_TEAM", 3, "hideForOwnTeam", 3);
	private static Map g = Maps.newHashMap();
	public final String e;
	public final int f;
	// $FF: synthetic field
	private static final bsg[] h = new bsg[] { a, b, c, d };

	public static String[] a() {
		return (String[]) g.keySet().toArray(new String[g.size()]);
	}

	public static bsg a(String var0) {
		return (bsg) g.get(var0);
	}

	private bsg(String var1, int var2, String var3, int var4) {
		this.e = var3;
		this.f = var4;
	}

	static {
		bsg[] var0 = values();
		int var1 = var0.length;

		for (int var2 = 0; var2 < var1; ++var2) {
			bsg var3 = var0[var2];
			g.put(var3.e, var3);
		}

	}
}

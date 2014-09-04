package net.minecraft;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.regex.Pattern;

public enum FormattingCode {

	a("BLACK", 0, "BLACK", '0', 0), b("DARK_BLUE", 1, "DARK_BLUE", '1', 1), c("DARK_GREEN", 2, "DARK_GREEN", '2', 2), d("DARK_AQUA", 3, "DARK_AQUA", '3', 3), e("DARK_RED", 4, "DARK_RED", '4', 4), f("DARK_PURPLE", 5, "DARK_PURPLE", '5', 5), g("GOLD", 6, "GOLD", '6', 6), h("GRAY", 7, "GRAY", '7', 7), i("DARK_GRAY", 8, "DARK_GRAY", '8', 8), j("BLUE", 9, "BLUE", '9', 9), k("GREEN", 10, "GREEN", 'a', 10), l("AQUA", 11, "AQUA", 'b', 11), m("RED", 12, "RED", 'c', 12), n("LIGHT_PURPLE", 13,
			"LIGHT_PURPLE", 'd', 13), o("YELLOW", 14, "YELLOW", 'e', 14), p("WHITE", 15, "WHITE", 'f', 15), q("OBFUSCATED", 16, "OBFUSCATED", 'k', true), r("BOLD", 17, "BOLD", 'l', true), s("STRIKETHROUGH", 18, "STRIKETHROUGH", 'm', true), t("UNDERLINE", 19, "UNDERLINE", 'n', true), u("ITALIC", 20, "ITALIC", 'o', true), v("RESET", 21, "RESET", 'r', -1);
	private static final Map w = Maps.newHashMap();
	private static final Pattern x = Pattern.compile("(?i)" + String.valueOf('\u00a7') + "[0-9A-FK-OR]");
	private final String y;
	private final char z;
	private final boolean A;
	private final String B;
	private final int C;
	// $FF: synthetic field
	private static final FormattingCode[] D = new FormattingCode[] { a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v };

	private static String c(String var0) {
		return var0.toLowerCase().replaceAll("[^a-z]", "");
	}

	private FormattingCode(String var1, int var2, String var3, char var4, int var5) {
		this(var1, var2, var3, var4, false, var5);
	}

	private FormattingCode(String var1, int var2, String var3, char var4, boolean var5) {
		this(var1, var2, var3, var4, var5, -1);
	}

	private FormattingCode(String var1, int var2, String var3, char var4, boolean var5, int var6) {
		this.y = var3;
		this.z = var4;
		this.A = var5;
		this.C = var6;
		this.B = "§" + var4;
	}

	public int b() {
		return this.C;
	}

	public boolean c() {
		return this.A;
	}

	public boolean d() {
		return !this.A && this != v;
	}

	public String e() {
		return this.name().toLowerCase();
	}

	public String toString() {
		return this.B;
	}

	public static FormattingCode b(String var0) {
		return var0 == null ? null : (FormattingCode) w.get(c(var0));
	}

	public static FormattingCode a(int var0) {
		if (var0 < 0) {
			return v;
		} else {
			FormattingCode[] var1 = values();
			int var2 = var1.length;

			for (int var3 = 0; var3 < var2; ++var3) {
				FormattingCode var4 = var1[var3];
				if (var4.b() == var0) {
					return var4;
				}
			}

			return null;
		}
	}

	public static Collection a(boolean var0, boolean var1) {
		ArrayList var2 = Lists.newArrayList();
		FormattingCode[] var3 = values();
		int var4 = var3.length;

		for (int var5 = 0; var5 < var4; ++var5) {
			FormattingCode var6 = var3[var5];
			if ((!var6.d() || var0) && (!var6.c() || var1)) {
				var2.add(var6.e());
			}
		}

		return var2;
	}

	static {
		FormattingCode[] var0 = values();
		int var1 = var0.length;

		for (int var2 = 0; var2 < var1; ++var2) {
			FormattingCode var3 = var0[var2];
			w.put(c(var3.y), var3);
		}

	}
}

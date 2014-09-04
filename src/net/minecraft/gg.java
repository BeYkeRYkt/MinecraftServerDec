package net.minecraft;

import java.util.Stack;
import java.util.regex.Pattern;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class gg {

	private static final Logger a = LogManager.getLogger();
	private static final Pattern b = Pattern.compile("\\[[-+\\d|,\\s]+\\]");

	public static NBTCompoundTag a(String var0) throws gf {
		var0 = var0.trim();
		if (!var0.startsWith("{")) {
			throw new gf("Invalid tag encountered, expected \'{\' as first char.");
		} else if (b(var0) != 1) {
			throw new gf("Encountered multiple top tags, only one expected");
		} else {
			return (NBTCompoundTag) a("tag", var0).a();
		}
	}

	static int b(String var0) throws gf {
		int var1 = 0;
		boolean var2 = false;
		Stack var3 = new Stack();

		for (int var4 = 0; var4 < var0.length(); ++var4) {
			char var5 = var0.charAt(var4);
			if (var5 == 34) {
				if (b(var0, var4)) {
					if (!var2) {
						throw new gf("Illegal use of \\\": " + var0);
					}
				} else {
					var2 = !var2;
				}
			} else if (!var2) {
				if (var5 != 123 && var5 != 91) {
					if (var5 == 125 && (var3.isEmpty() || ((Character) var3.pop()).charValue() != 123)) {
						throw new gf("Unbalanced curly brackets {}: " + var0);
					}

					if (var5 == 93 && (var3.isEmpty() || ((Character) var3.pop()).charValue() != 91)) {
						throw new gf("Unbalanced square brackets []: " + var0);
					}
				} else {
					if (var3.isEmpty()) {
						++var1;
					}

					var3.push(Character.valueOf(var5));
				}
			}
		}

		if (var2) {
			throw new gf("Unbalanced quotation: " + var0);
		} else if (!var3.isEmpty()) {
			throw new gf("Unbalanced brackets: " + var0);
		} else {
			if (var1 == 0 && !var0.isEmpty()) {
				var1 = 1;
			}

			return var1;
		}
	}

	static gh a(String... var0) throws gf {
		return a(var0[0], var0[1]);
	}

	static gh a(String var0, String var1) throws gf {
		var1 = var1.trim();
		String var3;
		boolean var4;
		char var6;
		if (var1.startsWith("{")) {
			var1 = var1.substring(1, var1.length() - 1);

			gi var5;
			for (var5 = new gi(var0); var1.length() > 0; var1 = var1.substring(var3.length() + 1)) {
				var3 = b(var1, true);
				if (var3.length() > 0) {
					var4 = false;
					var5.b.add(a(var3, var4));
				}

				if (var1.length() < var3.length() + 1) {
					break;
				}

				var6 = var1.charAt(var3.length());
				if (var6 != 44 && var6 != 123 && var6 != 125 && var6 != 91 && var6 != 93) {
					throw new gf("Unexpected token \'" + var6 + "\' at: " + var1.substring(var3.length()));
				}
			}

			return var5;
		} else if (var1.startsWith("[") && !b.matcher(var1).matches()) {
			var1 = var1.substring(1, var1.length() - 1);

			gj var2;
			for (var2 = new gj(var0); var1.length() > 0; var1 = var1.substring(var3.length() + 1)) {
				var3 = b(var1, false);
				if (var3.length() > 0) {
					var4 = true;
					var2.b.add(a(var3, var4));
				}

				if (var1.length() < var3.length() + 1) {
					break;
				}

				var6 = var1.charAt(var3.length());
				if (var6 != 44 && var6 != 123 && var6 != 125 && var6 != 91 && var6 != 93) {
					throw new gf("Unexpected token \'" + var6 + "\' at: " + var1.substring(var3.length()));
				}
			}

			return var2;
		} else {
			return new gk(var0, var1);
		}
	}

	private static gh a(String var0, boolean var1) throws gf {
		String var2 = c(var0, var1);
		String var3 = d(var0, var1);
		return a(new String[] { var2, var3 });
	}

	private static String b(String var0, boolean var1) throws gf {
		int var2 = a(var0, ':');
		int var3 = a(var0, ',');
		if (var1) {
			if (var2 == -1) {
				throw new gf("Unable to locate name/value separator for string: " + var0);
			}

			if (var3 != -1 && var3 < var2) {
				throw new gf("Name error at: " + var0);
			}
		} else if (var2 == -1 || var2 > var3) {
			var2 = -1;
		}

		return a(var0, var2);
	}

	private static String a(String var0, int var1) throws gf {
		Stack var2 = new Stack();
		int var3 = var1 + 1;
		boolean var4 = false;
		boolean var5 = false;
		boolean var6 = false;

		for (int var7 = 0; var3 < var0.length(); ++var3) {
			char var8 = var0.charAt(var3);
			if (var8 == 34) {
				if (b(var0, var3)) {
					if (!var4) {
						throw new gf("Illegal use of \\\": " + var0);
					}
				} else {
					var4 = !var4;
					if (var4 && !var6) {
						var5 = true;
					}

					if (!var4) {
						var7 = var3;
					}
				}
			} else if (!var4) {
				if (var8 != 123 && var8 != 91) {
					if (var8 == 125 && (var2.isEmpty() || ((Character) var2.pop()).charValue() != 123)) {
						throw new gf("Unbalanced curly brackets {}: " + var0);
					}

					if (var8 == 93 && (var2.isEmpty() || ((Character) var2.pop()).charValue() != 91)) {
						throw new gf("Unbalanced square brackets []: " + var0);
					}

					if (var8 == 44 && var2.isEmpty()) {
						return var0.substring(0, var3);
					}
				} else {
					var2.push(Character.valueOf(var8));
				}
			}

			if (!Character.isWhitespace(var8)) {
				if (!var4 && var5 && var7 != var3) {
					return var0.substring(0, var7 + 1);
				}

				var6 = true;
			}
		}

		return var0.substring(0, var3);
	}

	private static String c(String var0, boolean var1) throws gf {
		if (var1) {
			var0 = var0.trim();
			if (var0.startsWith("{") || var0.startsWith("[")) {
				return "";
			}
		}

		int var2 = a(var0, ':');
		if (var2 == -1) {
			if (var1) {
				return "";
			} else {
				throw new gf("Unable to locate name/value separator for string: " + var0);
			}
		} else {
			return var0.substring(0, var2).trim();
		}
	}

	private static String d(String var0, boolean var1) throws gf {
		if (var1) {
			var0 = var0.trim();
			if (var0.startsWith("{") || var0.startsWith("[")) {
				return var0;
			}
		}

		int var2 = a(var0, ':');
		if (var2 == -1) {
			if (var1) {
				return var0;
			} else {
				throw new gf("Unable to locate name/value separator for string: " + var0);
			}
		} else {
			return var0.substring(var2 + 1).trim();
		}
	}

	private static int a(String var0, char var1) {
		int var2 = 0;

		for (boolean var3 = true; var2 < var0.length(); ++var2) {
			char var4 = var0.charAt(var2);
			if (var4 == 34) {
				if (!b(var0, var2)) {
					var3 = !var3;
				}
			} else if (var3) {
				if (var4 == var1) {
					return var2;
				}

				if (var4 == 123 || var4 == 91) {
					return -1;
				}
			}
		}

		return -1;
	}

	private static boolean b(String var0, int var1) {
		return var1 > 0 && var0.charAt(var1 - 1) == 92 && !b(var0, var1 - 1);
	}

}

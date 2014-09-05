package net.minecraft;

public enum apg {

	a("ALL", 0), b("ARMOR", 1), c("ARMOR_FEET", 2), d("ARMOR_LEGS", 3), e("ARMOR_TORSO", 4), f("ARMOR_HEAD", 5), g("WEAPON", 6), h("DIGGER", 7), i("FISHING_ROD", 8), j("BREAKABLE", 9), k("BOW", 10);
	// $FF: synthetic field
	private static final apg[] l = new apg[] { a, b, c, d, e, f, g, h, i, j, k };

	private apg(String var1, int var2) {
	}

	public boolean a(Item var1) {
		if (this == a) {
			return true;
		} else if (this == j && var1.m()) {
			return true;
		} else if (var1 instanceof ajn) {
			if (this == b) {
				return true;
			} else {
				ajn var2 = (ajn) var1;
				return var2.b == 0 ? this == f : (var2.b == 2 ? this == d : (var2.b == 1 ? this == e : (var2.b == 3 ? this == c : false)));
			}
		} else {
			return var1 instanceof anm ? this == g : (var1 instanceof aks ? this == h : (var1 instanceof ajz ? this == k : (var1 instanceof alj ? this == i : false)));
		}
	}

}

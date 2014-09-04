package net.minecraft;

public abstract class akf {

	public static final akf[] a = new akf[12];
	public static final akf b = new akg(0, "buildingBlocks");
	public static final akf c = new akk(1, "decorations");
	public static final akf d = new akl(2, "redstone");
	public static final akf e = new akm(3, "transportation");
	public static final akf f = (new akn(4, "misc")).a(new apg[] { apg.a });
	public static final akf g = (new ako(5, "search")).a("item_search.png");
	public static final akf h = new akp(6, "food");
	public static final akf i = (new akq(7, "tools")).a(new apg[] { apg.h, apg.i, apg.j });
	public static final akf j = (new akr(8, "combat")).a(new apg[] { apg.b, apg.c, apg.f, apg.d, apg.e, apg.k, apg.g });
	public static final akf k = new akh(9, "brewing");
	public static final akf l = new aki(10, "materials");
	public static final akf m = (new akj(11, "inventory")).a("inventory.png").k().i();
	private final int n;
	private final String o;
	private String p = "items.png";
	private boolean q = true;
	private boolean r = true;
	private apg[] s;

	public akf(int var1, String var2) {
		this.n = var1;
		this.o = var2;
		a[var1] = this;
	}

	public akf a(String var1) {
		this.p = var1;
		return this;
	}

	public akf i() {
		this.r = false;
		return this;
	}

	public akf k() {
		this.q = false;
		return this;
	}

	public akf a(apg... var1) {
		this.s = var1;
		return this;
	}

}

package net.minecraft;

public abstract class CreativeModeTab {

	public static final CreativeModeTab[] a = new CreativeModeTab[12];
	public static final CreativeModeTab b = new akg(0, "buildingBlocks");
	public static final CreativeModeTab c = new akk(1, "decorations");
	public static final CreativeModeTab d = new akl(2, "redstone");
	public static final CreativeModeTab e = new akm(3, "transportation");
	public static final CreativeModeTab f = (new akn(4, "misc")).a(new apg[] { apg.a });
	public static final CreativeModeTab g = (new ako(5, "search")).a("item_search.png");
	public static final CreativeModeTab h = new akp(6, "food");
	public static final CreativeModeTab i = (new akq(7, "tools")).a(new apg[] { apg.h, apg.i, apg.j });
	public static final CreativeModeTab j = (new akr(8, "combat")).a(new apg[] { apg.b, apg.c, apg.f, apg.d, apg.e, apg.k, apg.g });
	public static final CreativeModeTab k = new akh(9, "brewing");
	public static final CreativeModeTab l = new aki(10, "materials");
	public static final CreativeModeTab m = (new akj(11, "inventory")).a("inventory.png").k().i();
	private final int n;
	private final String o;
	private String p = "items.png";
	private boolean q = true;
	private boolean r = true;
	private apg[] s;

	public CreativeModeTab(int var1, String var2) {
		this.n = var1;
		this.o = var2;
		a[var1] = this;
	}

	public CreativeModeTab a(String var1) {
		this.p = var1;
		return this;
	}

	public CreativeModeTab i() {
		this.r = false;
		return this;
	}

	public CreativeModeTab k() {
		this.q = false;
		return this;
	}

	public CreativeModeTab a(apg... var1) {
		this.s = var1;
		return this;
	}

}

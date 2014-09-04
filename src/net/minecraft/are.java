package net.minecraft;

public class are {

	public static final are[] a = new are[16];
	public static final are b = (new are(0, "default", 1)).i();
	public static final are c = new are(1, "flat");
	public static final are d = new are(2, "largeBiomes");
	public static final are e = (new are(3, "amplified")).j();
	public static final are f = new are(4, "customized");
	public static final are g = new are(5, "debug_all_block_states");
	public static final are h = (new are(8, "default_1_1", 0)).a(false);
	private final int i;
	private final String j;
	private final int k;
	private boolean l;
	private boolean m;
	private boolean n;

	private are(int var1, String var2) {
		this(var1, var2, 0);
	}

	private are(int var1, String var2, int var3) {
		this.j = var2;
		this.k = var3;
		this.l = true;
		this.i = var1;
		a[var1] = this;
	}

	public String a() {
		return this.j;
	}

	public int d() {
		return this.k;
	}

	public are a(int var1) {
		return this == b && var1 == 0 ? h : this;
	}

	private are a(boolean var1) {
		this.l = var1;
		return this;
	}

	private are i() {
		this.m = true;
		return this;
	}

	public boolean f() {
		return this.m;
	}

	public static are a(String var0) {
		for (int var1 = 0; var1 < a.length; ++var1) {
			if (a[var1] != null && a[var1].j.equalsIgnoreCase(var0)) {
				return a[var1];
			}
		}

		return null;
	}

	public int g() {
		return this.i;
	}

	private are j() {
		this.n = true;
		return this;
	}

}

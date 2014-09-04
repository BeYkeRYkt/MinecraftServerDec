package net.minecraft;

public enum xp {

	a("MONSTER", 0, aex.class, 70, bof.a, false, false), b("CREATURE", 1, abq.class, 10, bof.a, true, true), c("AMBIENT", 2, abn.class, 15, bof.a, true, false), d("WATER_CREATURE", 3, act.class, 5, bof.h, true, false);
	private final Class e;
	private final int f;
	private final bof g;
	private final boolean h;
	private final boolean i;
	// $FF: synthetic field
	private static final xp[] j = new xp[] { a, b, c, d };

	private xp(String var1, int var2, Class var3, int var4, bof var5, boolean var6, boolean var7) {
		this.e = var3;
		this.f = var4;
		this.g = var5;
		this.h = var6;
		this.i = var7;
	}

	public Class a() {
		return this.e;
	}

	public int b() {
		return this.f;
	}

	public boolean d() {
		return this.h;
	}

	public boolean e() {
		return this.i;
	}

}

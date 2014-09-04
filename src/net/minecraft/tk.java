package net.minecraft;

public class tk extends PlayerStatistic {

	public int a;
	public int b;
	public final tk c;
	private final String k;
	public final amj d;
	private boolean m;

	public tk(String var1, String var2, int var3, int var4, alq var5, tk var6) {
		this(var1, var2, var3, var4, new amj(var5), var6);
	}

	public tk(String var1, String var2, int var3, int var4, atr var5, tk var6) {
		this(var1, var2, var3, var4, new amj(var5), var6);
	}

	public tk(String var1, String var2, int var3, int var4, amj var5, tk var6) {
		super(var1, new hz("achievement." + var2, new Object[0]));
		this.d = var5;
		this.k = "achievement." + var2 + ".desc";
		this.a = var3;
		this.b = var4;
		if (var3 < tl.a) {
			a = var3;
		}

		if (var4 < tl.b) {
			b = var4;
		}

		if (var3 > tl.c) {
			tl.c = var3;
		}

		if (var4 > tl.d) {
			tl.d = var4;
		}

		this.c = var6;
	}

	public tk a() {
		this.f = true;
		return this;
	}

	public tk b() {
		this.m = true;
		return this;
	}

	public tk c() {
		super.h();
		tl.e.add(this);
		return this;
	}

	public boolean d() {
		return true;
	}

	public ho e() {
		ho var1 = super.e();
		var1.b().a(this.g() ? FormattingCode.f : FormattingCode.k);
		return var1;
	}

	public tk a(Class var1) {
		return (tk) super.b(var1);
	}

	public boolean g() {
		return this.m;
	}

	// $FF: synthetic method
	public PlayerStatistic b(Class var1) {
		return this.a(var1);
	}

	// $FF: synthetic method
	public PlayerStatistic h() {
		return this.c();
	}

	// $FF: synthetic method
	public PlayerStatistic i() {
		return this.a();
	}
}

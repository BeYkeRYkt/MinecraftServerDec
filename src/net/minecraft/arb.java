package net.minecraft;

public final class arb {

	private final long a;
	private final GameMode b;
	private final boolean c;
	private final boolean d;
	private final are e;
	private boolean f;
	private boolean g;
	private String h;

	public arb(long var1, GameMode var3, boolean var4, boolean var5, are var6) {
		this.h = "";
		this.a = var1;
		this.b = var3;
		this.c = var4;
		this.d = var5;
		this.e = var6;
	}

	public arb(bqo var1) {
		this(var1.b(), var1.r(), var1.s(), var1.t(), var1.u());
	}

	public arb a() {
		this.g = true;
		return this;
	}

	public arb a(String var1) {
		this.h = var1;
		return this;
	}

	public boolean c() {
		return this.g;
	}

	public long d() {
		return this.a;
	}

	public GameMode e() {
		return this.b;
	}

	public boolean f() {
		return this.d;
	}

	public boolean g() {
		return this.c;
	}

	public are h() {
		return this.e;
	}

	public boolean i() {
		return this.f;
	}

	public static GameMode a(int var0) {
		return GameMode.byId(var0);
	}

	public String j() {
		return this.h;
	}
}

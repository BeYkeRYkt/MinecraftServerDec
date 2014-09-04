package net.minecraft;

public class dt extends fd {

	public static final dt a = new dt(0, 0, 0);
	private static final int b = 1 + uv.c(uv.b(30000000));
	private static final int c = b;
	private static final int d = 64 - b - c;
	private static final int f = 0 + c;
	private static final int g = f + d;
	private static final long h = (1L << b) - 1L;
	private static final long i = (1L << d) - 1L;
	private static final long j = (1L << c) - 1L;

	public dt(int var1, int var2, int var3) {
		super(var1, var2, var3);
	}

	public dt(double var1, double var3, double var5) {
		super(var1, var3, var5);
	}

	public dt(Entity var1) {
		this(var1.s, var1.t, var1.u);
	}

	public dt(brw var1) {
		this(var1.a, var1.b, var1.c);
	}

	public dt(fd var1) {
		this(var1.n(), var1.o(), var1.p());
	}

	public dt a(double var1, double var3, double var5) {
		return new dt((double) this.n() + var1, (double) this.o() + var3, (double) this.p() + var5);
	}

	public dt a(int var1, int var2, int var3) {
		return new dt(this.n() + var1, this.o() + var2, this.p() + var3);
	}

	public dt a(fd var1) {
		return new dt(this.n() + var1.n(), this.o() + var1.o(), this.p() + var1.p());
	}

	public dt a(int var1) {
		return new dt(this.n() * var1, this.o() * var1, this.p() * var1);
	}

	public dt a() {
		return this.b(1);
	}

	public dt b(int var1) {
		return this.a(ej.b, var1);
	}

	public dt b() {
		return this.c(1);
	}

	public dt c(int var1) {
		return this.a(ej.a, var1);
	}

	public dt c() {
		return this.d(1);
	}

	public dt d(int var1) {
		return this.a(ej.c, var1);
	}

	public dt d() {
		return this.e(1);
	}

	public dt e(int var1) {
		return this.a(ej.d, var1);
	}

	public dt e() {
		return this.f(1);
	}

	public dt f(int var1) {
		return this.a(ej.e, var1);
	}

	public dt f() {
		return this.g(1);
	}

	public dt g(int var1) {
		return this.a(ej.f, var1);
	}

	public dt a(ej var1) {
		return this.a(var1, 1);
	}

	public dt a(ej var1, int var2) {
		return new dt(this.n() + var1.g() * var2, this.o() + var1.h() * var2, this.p() + var1.i() * var2);
	}

	public dt c(fd var1) {
		return new dt(this.o() * var1.p() - this.p() * var1.o(), this.p() * var1.n() - this.n() * var1.p(), this.n() * var1.o() - this.o() * var1.n());
	}

	public long g() {
		return ((long) this.n() & h) << g | ((long) this.o() & i) << f | ((long) this.p() & j) << 0;
	}

	public static dt a(long var0) {
		int var2 = (int) (var0 << 64 - g - b >> 64 - b);
		int var3 = (int) (var0 << 64 - f - d >> 64 - d);
		int var4 = (int) (var0 << 64 - c >> 64 - c);
		return new dt(var2, var3, var4);
	}

	public static Iterable a(dt var0, dt var1) {
		dt var2 = new dt(Math.min(var0.n(), var1.n()), Math.min(var0.o(), var1.o()), Math.min(var0.p(), var1.p()));
		dt var3 = new dt(Math.max(var0.n(), var1.n()), Math.max(var0.o(), var1.o()), Math.max(var0.p(), var1.p()));
		return new du(var2, var3);
	}

	public static Iterable b(dt var0, dt var1) {
		dt var2 = new dt(Math.min(var0.n(), var1.n()), Math.min(var0.o(), var1.o()), Math.min(var0.p(), var1.p()));
		dt var3 = new dt(Math.max(var0.n(), var1.n()), Math.max(var0.o(), var1.o()), Math.max(var0.p(), var1.p()));
		return new dw(var2, var3);
	}

	// $FF: synthetic method
	public fd d(fd var1) {
		return this.c(var1);
	}

}

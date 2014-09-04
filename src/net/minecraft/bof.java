package net.minecraft;

public class bof {

	public static final bof a = new bod(boh.b);
	public static final bof b = new bof(boh.c);
	public static final bof c = new bof(boh.l);
	public static final bof d = (new bof(boh.o)).g();
	public static final bof e = (new bof(boh.m)).f();
	public static final bof f = (new bof(boh.h)).f();
	public static final bof g = (new bof(boh.h)).f().o();
	public static final bof h = (new boe(boh.n)).n();
	public static final bof i = (new boe(boh.f)).n();
	public static final bof j = (new bof(boh.i)).g().s().n();
	public static final bof k = (new boc(boh.i)).n();
	public static final bof l = (new boc(boh.i)).g().n().i();
	public static final bof m = new bof(boh.e);
	public static final bof n = (new bof(boh.e)).g();
	public static final bof o = (new bod(boh.b)).n();
	public static final bof p = new bof(boh.d);
	public static final bof q = (new boc(boh.b)).n();
	public static final bof r = (new boc(boh.e)).g();
	public static final bof s = (new bof(boh.b)).s().p();
	public static final bof t = (new bof(boh.b)).p();
	public static final bof u = (new bof(boh.f)).g().s();
	public static final bof v = (new bof(boh.i)).n();
	public static final bof w = (new bof(boh.g)).s().p();
	public static final bof x = (new bof(boh.g)).p();
	public static final bof y = (new boc(boh.j)).i().s().f().n();
	public static final bof z = (new bof(boh.j)).f();
	public static final bof A = (new bof(boh.i)).s().n();
	public static final bof B = new bof(boh.k);
	public static final bof C = (new bof(boh.i)).n();
	public static final bof D = (new bof(boh.i)).n();
	public static final bof E = (new boi(boh.b)).o();
	public static final bof F = (new bof(boh.b)).n();
	public static final bof G = (new bog(boh.e)).f().n();
	public static final bof H = (new bof(boh.m)).o();
	public static final bof I = (new bof(boh.b)).f().o();
	private boolean J;
	private boolean K;
	private boolean L;
	private final boh M;
	private boolean N = true;
	private int O;
	private boolean P;

	public bof(boh var1) {
		this.M = var1;
	}

	public boolean d() {
		return false;
	}

	public boolean a() {
		return true;
	}

	public boolean b() {
		return true;
	}

	public boolean c() {
		return true;
	}

	private bof s() {
		this.L = true;
		return this;
	}

	protected bof f() {
		this.N = false;
		return this;
	}

	protected bof g() {
		this.J = true;
		return this;
	}

	public boolean h() {
		return this.J;
	}

	public bof i() {
		this.K = true;
		return this;
	}

	public boolean j() {
		return this.K;
	}

	public boolean k() {
		return this.L ? false : this.c();
	}

	public boolean l() {
		return this.N;
	}

	public int m() {
		return this.O;
	}

	protected bof n() {
		this.O = 1;
		return this;
	}

	protected bof o() {
		this.O = 2;
		return this;
	}

	protected bof p() {
		this.P = true;
		return this;
	}

	public boh r() {
		return this.M;
	}

}

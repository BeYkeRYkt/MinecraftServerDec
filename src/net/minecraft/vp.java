package net.minecraft;

public class vp implements vy {

	private String a;
	private vy b;
	private vy c;

	public vp(String var1, vy var2, vy var3) {
		this.a = var1;
		if (var2 == null) {
			var2 = var3;
		}

		if (var3 == null) {
			var3 = var2;
		}

		this.b = var2;
		this.c = var3;
		if (var2.q_()) {
			var3.a(var2.i());
		} else if (var3.q_()) {
			var2.a(var3.i());
		}

	}

	public int n_() {
		return this.b.n_() + this.c.n_();
	}

	public boolean a(vq var1) {
		return this.b == var1 || this.c == var1;
	}

	public String d_() {
		return this.b.k_() ? this.b.d_() : (this.c.k_() ? this.c.d_() : this.a);
	}

	public boolean k_() {
		return this.b.k_() || this.c.k_();
	}

	public ho e_() {
		return (ho) (this.k_() ? new hy(this.d_()) : new hz(this.d_(), new Object[0]));
	}

	public amj a(int var1) {
		return var1 >= this.b.n_() ? this.c.a(var1 - this.b.n_()) : this.b.a(var1);
	}

	public amj a(int var1, int var2) {
		return var1 >= this.b.n_() ? this.c.a(var1 - this.b.n_(), var2) : this.b.a(var1, var2);
	}

	public amj b(int var1) {
		return var1 >= this.b.n_() ? this.c.b(var1 - this.b.n_()) : this.b.b(var1);
	}

	public void a(int var1, amj var2) {
		if (var1 >= this.b.n_()) {
			this.c.a(var1 - this.b.n_(), var2);
		} else {
			this.b.a(var1, var2);
		}

	}

	public int p_() {
		return this.b.p_();
	}

	public void o_() {
		this.b.o_();
		this.c.o_();
	}

	public boolean a(ahd var1) {
		return this.b.a(var1) && this.c.a(var1);
	}

	public void b(ahd var1) {
		this.b.b(var1);
		this.c.b(var1);
	}

	public void c(ahd var1) {
		this.b.c(var1);
		this.c.c(var1);
	}

	public boolean b(int var1, amj var2) {
		return true;
	}

	public int a_(int var1) {
		return 0;
	}

	public void b(int var1, int var2) {
	}

	public int g() {
		return 0;
	}

	public boolean q_() {
		return this.b.q_() || this.c.q_();
	}

	public void a(vx var1) {
		this.b.a(var1);
		this.c.a(var1);
	}

	public vx i() {
		return this.b.i();
	}

	public String k() {
		return this.b.k();
	}

	public aib a(ahb var1, ahd var2) {
		return new aim(var1, this, var2);
	}

	public void l() {
		this.b.l();
		this.c.l();
	}
}

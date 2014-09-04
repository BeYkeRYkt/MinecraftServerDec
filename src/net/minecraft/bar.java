package net.minecraft;

import java.util.Random;

public class bar extends awt {

	public static final bev a = bev.a("color", akv.class);

	public bar(bof var1) {
		super(var1, false);
		this.j(this.L.b().a(a, akv.a));
		this.a(akf.b);
	}

	public int a(bec var1) {
		return ((akv) var1.b(a)).a();
	}

	public boh g(bec var1) {
		return ((akv) var1.b(a)).e();
	}

	public int a(Random var1) {
		return 0;
	}

	protected boolean G() {
		return true;
	}

	public boolean d() {
		return false;
	}

	public bec a(int var1) {
		return this.P().a(a, akv.b(var1));
	}

	public void c(World var1, dt var2, bec var3) {
		if (!var1.D) {
			atm.d(var1, var2);
		}

	}

	public void b(World var1, dt var2, bec var3) {
		if (!var1.D) {
			atm.d(var1, var2);
		}

	}

	public int c(bec var1) {
		return ((akv) var1.b(a)).a();
	}

	protected bed e() {
		return new bed(this, new bex[] { a });
	}

}

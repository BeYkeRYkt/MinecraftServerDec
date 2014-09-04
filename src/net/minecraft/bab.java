package net.minecraft;

public class bab extends avt {

	public static final bev a = bev.a("variant", bac.class);

	public bab() {
		this.j(this.L.b().a(a, bac.a));
	}

	public int a(bec var1) {
		return ((bac) var1.b(a)).a();
	}

	public boh g(bec var1) {
		return ((bac) var1.b(a)).c();
	}

	public bec a(int var1) {
		return this.P().a(a, bac.a(var1));
	}

	public int c(bec var1) {
		return ((bac) var1.b(a)).a();
	}

	protected bed e() {
		return new bed(this, new bex[] { a });
	}

}

package net.minecraft;

public class bbc extends Block {

	public static final bev a = bev.a("variant", bbd.class);
	public static final int b = bbd.a.a();
	public static final int M = bbd.b.a();
	public static final int N = bbd.c.a();
	public static final int O = bbd.d.a();

	public bbc() {
		super(bof.e);
		this.j(this.L.b().a(a, bbd.a));
		this.a(CreativeModeTab.b);
	}

	public int a(bec var1) {
		return ((bbd) var1.b(a)).a();
	}

	public bec a(int var1) {
		return this.P().a(a, bbd.a(var1));
	}

	public int c(bec var1) {
		return ((bbd) var1.b(a)).a();
	}

	protected bed e() {
		return new bed(this, new bex[] { a });
	}

}

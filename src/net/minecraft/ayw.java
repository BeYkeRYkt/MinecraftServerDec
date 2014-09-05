package net.minecraft;

public class ayw extends Block {

	public static final bev a = bev.a("variant", ayx.class);

	public ayw() {
		super(bof.d);
		this.j(this.L.b().a(a, ayx.a));
		this.a(CreativeModeTab.b);
	}

	public int a(bec var1) {
		return ((ayx) var1.b(a)).a();
	}

	public bec a(int var1) {
		return this.P().a(a, ayx.a(var1));
	}

	public int c(bec var1) {
		return ((ayx) var1.b(a)).a();
	}

	protected bed e() {
		return new bed(this, new bex[] { a });
	}

}

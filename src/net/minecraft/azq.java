package net.minecraft;

public class azq extends Block {

	public static final bev a = bev.a("type", azr.class);

	public azq() {
		super(bof.e);
		this.j(this.L.b().a(a, azr.a));
		this.a(CreativeModeTab.b);
	}

	public int a(bec var1) {
		return ((azr) var1.b(a)).a();
	}

	public bec a(int var1) {
		return this.P().a(a, azr.a(var1));
	}

	public int c(bec var1) {
		return ((azr) var1.b(a)).a();
	}

	protected bed e() {
		return new bed(this, new bex[] { a });
	}

}

package net.minecraft;

public class azl extends atr {

	public static final bev a = bev.a("variant", azn.class);

	public azl() {
		super(bof.e);
		this.j(this.L.b().a(a, azn.a));
		this.a(akf.b);
	}

	public bec a(World var1, dt var2, ej var3, float var4, float var5, float var6, int var7, EntityLiving var8) {
		if (var7 == azn.c.a()) {
			switch (azm.a[var3.k().ordinal()]) {
				case 1:
					return this.P().a(a, azn.e);
				case 2:
					return this.P().a(a, azn.d);
				case 3:
				default:
					return this.P().a(a, azn.c);
			}
		} else {
			return var7 == azn.b.a() ? this.P().a(a, azn.b) : this.P().a(a, azn.a);
		}
	}

	public int a(bec var1) {
		azn var2 = (azn) var1.b(a);
		return var2 != azn.d && var2 != azn.e ? var2.a() : azn.c.a();
	}

	protected amj i(bec var1) {
		azn var2 = (azn) var1.b(a);
		return var2 != azn.d && var2 != azn.e ? super.i(var1) : new amj(alq.a((atr) this), 1, azn.c.a());
	}

	public boh g(bec var1) {
		return boh.p;
	}

	public bec a(int var1) {
		return this.P().a(a, azn.a(var1));
	}

	public int c(bec var1) {
		return ((azn) var1.b(a)).a();
	}

	protected bed e() {
		return new bed(this, new bex[] { a });
	}

}

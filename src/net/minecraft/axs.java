package net.minecraft;

import java.util.Random;

public class axs extends atr {

	public static final bev a = bev.a("variant", axu.class);

	public axs() {
		super(bof.B);
		this.j(this.L.b().a(a, axu.a));
		this.c(0.0F);
		this.a(akf.c);
	}

	public int a(Random var1) {
		return 0;
	}

	public static boolean d(bec var0) {
		atr var1 = var0.c();
		return var0 == aty.b.P().a(bba.a, bbb.a) || var1 == aty.e || var1 == aty.bf;
	}

	protected amj i(bec var1) {
		switch (axt.a[((axu) var1.b(a)).ordinal()]) {
			case 1:
				return new amj(aty.e);
			case 2:
				return new amj(aty.bf);
			case 3:
				return new amj(aty.bf, 1, bbd.b.a());
			case 4:
				return new amj(aty.bf, 1, bbd.c.a());
			case 5:
				return new amj(aty.bf, 1, bbd.d.a());
			default:
				return new amj(aty.b);
		}
	}

	public void a(World var1, dt var2, bec var3, float var4, int var5) {
		if (!var1.D && var1.Q().b("doTileDrops")) {
			aft var6 = new aft(var1);
			var6.b((double) var2.n() + 0.5D, (double) var2.o(), (double) var2.p() + 0.5D, 0.0F, 0.0F);
			var1.d((Entity) var6);
			var6.y();
		}

	}

	public int j(World var1, dt var2) {
		bec var3 = var1.p(var2);
		return var3.c().c(var3);
	}

	public bec a(int var1) {
		return this.P().a(a, axu.a(var1));
	}

	public int c(bec var1) {
		return ((axu) var1.b(a)).a();
	}

	protected bed e() {
		return new bed(this, new bex[] { a });
	}

}

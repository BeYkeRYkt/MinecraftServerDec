package net.minecraft;

import com.google.common.base.Predicate;
import java.util.Iterator;

public class axe extends atr {

	public static final beu a = beu.a("facing", (Predicate) en.a);

	protected axe() {
		super(bof.q);
		this.j(this.L.b().a(a, ej.c));
		this.a(akf.c);
	}

	public brt a(World var1, dt var2, bec var3) {
		this.a(var1, var2);
		return super.a(var1, var2, var3);
	}

	public void a(ard var1, dt var2) {
		bec var3 = var1.p(var2);
		if (var3.c() == this) {
			float var4 = 0.125F;
			switch (axf.a[((ej) var3.b(a)).ordinal()]) {
				case 1:
					this.a(0.0F, 0.0F, 1.0F - var4, 1.0F, 1.0F, 1.0F);
					break;
				case 2:
					this.a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, var4);
					break;
				case 3:
					this.a(1.0F - var4, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
					break;
				case 4:
				default:
					this.a(0.0F, 0.0F, 0.0F, var4, 1.0F, 1.0F);
			}

		}
	}

	public boolean c() {
		return false;
	}

	public boolean d() {
		return false;
	}

	public boolean c(World var1, dt var2) {
		return var1.p(var2.e()).c().t() ? true : (var1.p(var2.f()).c().t() ? true : (var1.p(var2.c()).c().t() ? true : var1.p(var2.d()).c().t()));
	}

	public bec a(World var1, dt var2, ej var3, float var4, float var5, float var6, int var7, EntityLiving var8) {
		if (var3.k().c() && this.b(var1, var2, var3)) {
			return this.P().a(a, var3);
		} else {
			Iterator var9 = en.a.iterator();

			ej var10;
			do {
				if (!var9.hasNext()) {
					return this.P();
				}

				var10 = (ej) var9.next();
			} while (!this.b(var1, var2, var10));

			return this.P().a(a, var10);
		}
	}

	public void a(World var1, dt var2, bec var3, atr var4) {
		ej var5 = (ej) var3.b(a);
		if (!this.b(var1, var2, var5)) {
			this.b(var1, var2, var3, 0);
			var1.g(var2);
		}

		super.a(var1, var2, var3, var4);
	}

	protected boolean b(World var1, dt var2, ej var3) {
		return var1.p(var2.a(var3.d())).c().t();
	}

	public bec a(int var1) {
		ej var2 = ej.a(var1);
		if (var2.k() == el.b) {
			var2 = ej.c;
		}

		return this.P().a(a, var2);
	}

	public int c(bec var1) {
		return ((ej) var1.b(a)).a();
	}

	protected bed e() {
		return new bed(this, new bex[] { a });
	}

}

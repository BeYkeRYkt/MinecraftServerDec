package net.minecraft;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;

public class yw extends zb {

	private static final Predicate b = beq.a((atr) aty.H).a(bbh.a, Predicates.equalTo(bbi.b));
	private xn c;
	private World d;
	int a;

	public yw(xn var1) {
		this.c = var1;
		this.d = var1.o;
		this.a(7);
	}

	public boolean a() {
		if (this.c.bb().nextInt(this.c.i_() ? 50 : 1000) != 0) {
			return false;
		} else {
			dt var1 = new dt(this.c.s, this.c.t, this.c.u);
			return b.apply(this.d.p(var1)) ? true : this.d.p(var1.b()).c() == aty.c;
		}
	}

	public void c() {
		this.a = 40;
		this.d.a((Entity) this.c, (byte) 10);
		this.c.s().n();
	}

	public void d() {
		this.a = 0;
	}

	public boolean b() {
		return this.a > 0;
	}

	public int f() {
		return this.a;
	}

	public void e() {
		this.a = Math.max(0, this.a - 1);
		if (this.a == 4) {
			dt var1 = new dt(this.c.s, this.c.t, this.c.u);
			if (b.apply(this.d.p(var1))) {
				if (this.d.Q().b("mobGriefing")) {
					this.d.b(var1, false);
				}

				this.c.v();
			} else {
				dt var2 = var1.b();
				if (this.d.p(var2).c() == aty.c) {
					if (this.d.Q().b("mobGriefing")) {
						this.d.b(2001, var2, atr.a((atr) aty.c));
						this.d.a(var2, aty.d.P(), 2);
					}

					this.c.v();
				}
			}

		}
	}

}

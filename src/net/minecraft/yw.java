package net.minecraft;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;

public class yw extends zb {

	private static final Predicate b = beq.a((Block) aty.H).a(BlockLongGrass.a, Predicates.equalTo(bbi.b));
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
			Position var1 = new Position(this.c.locationX, this.c.locationY, this.c.locationZ);
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
			Position var1 = new Position(this.c.locationX, this.c.locationY, this.c.locationZ);
			if (b.apply(this.d.p(var1))) {
				if (this.d.Q().b("mobGriefing")) {
					this.d.b(var1, false);
				}

				this.c.v();
			} else {
				Position var2 = var1.b();
				if (this.d.p(var2).c() == aty.c) {
					if (this.d.Q().b("mobGriefing")) {
						this.d.b(2001, var2, Block.a((Block) aty.c));
						this.d.a(var2, aty.d.P(), 2);
					}

					this.c.v();
				}
			}

		}
	}

}

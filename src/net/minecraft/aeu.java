package net.minecraft;

import java.util.Collections;
import java.util.List;

class aeu extends aaq {

	private ahd g;
	private int h;
	private int i;
	private aer j;

	public aeu(aer var1) {
		super(var1, ahd.class, true);
		this.j = var1;
	}

	public boolean a() {
		double var1 = this.f();
		List var3 = this.e.o.a(ahd.class, this.e.aQ().b(var1, 4.0D, var1), this.c);
		Collections.sort(var3, this.b);
		if (var3.isEmpty()) {
			return false;
		} else {
			this.g = (ahd) var3.get(0);
			return true;
		}
	}

	public void c() {
		this.h = 5;
		this.i = 0;
	}

	public void d() {
		this.g = null;
		this.j.a(false);
		xz var1 = this.j.a(afs.d);
		var1.c(aer.cn());
		super.d();
	}

	public boolean b() {
		if (this.g != null) {
			if (!aer.a(this.j, this.g)) {
				return false;
			} else {
				aer.a(this.j, true);
				this.j.a(this.g, 10.0F, 10.0F);
				return true;
			}
		} else {
			return super.b();
		}
	}

	public void e() {
		if (this.g != null) {
			if (--this.h <= 0) {
				this.d = this.g;
				this.g = null;
				super.c();
				this.j.a("mob.endermen.stare", 1.0F, 1.0F);
				this.j.a(true);
				xz var1 = this.j.a(afs.d);
				var1.b(aer.cn());
			}
		} else {
			if (this.d != null) {
				if (this.d instanceof ahd && aer.a(this.j, (ahd) this.d)) {
					if (this.d.h(this.j) < 16.0D) {
						this.j.n();
					}

					this.i = 0;
				} else if (this.d.h(this.j) > 256.0D && this.i++ >= 30 && this.j.b((Entity) this.d)) {
					this.i = 0;
				}
			}

			super.e();
		}

	}
}

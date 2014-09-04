package net.minecraft;

import com.google.common.collect.Lists;
import java.util.Iterator;
import java.util.List;

public class zm extends zb {

	private EntityCreature a;
	private double b;
	private bpv c;
	private abh d;
	private boolean e;
	private List f = Lists.newArrayList();

	public zm(EntityCreature var1, double var2, boolean var4) {
		this.a = var1;
		this.b = var2;
		this.e = var4;
		this.a(1);
		if (!(var1.s() instanceof aay)) {
			throw new IllegalArgumentException("Unsupported mob for MoveThroughVillageGoal");
		}
	}

	public boolean a() {
		this.f();
		if (this.e && this.a.o.w()) {
			return false;
		} else {
			abi var1 = this.a.o.ae().a(new dt(this.a), 0);
			if (var1 == null) {
				return false;
			} else {
				this.d = this.a(var1);
				if (this.d == null) {
					return false;
				} else {
					aay var2 = (aay) this.a.s();
					boolean var3 = var2.g();
					var2.b(false);
					this.c = var2.a(this.d.d());
					var2.b(var3);
					if (this.c != null) {
						return true;
					} else {
						brw var4 = abf.a(this.a, 10, 7, new brw((double) this.d.d().n(), (double) this.d.d().o(), (double) this.d.d().p()));
						if (var4 == null) {
							return false;
						} else {
							var2.b(false);
							this.c = this.a.s().a(var4.a, var4.b, var4.c);
							var2.b(var3);
							return this.c != null;
						}
					}
				}
			}
		}
	}

	public boolean b() {
		if (this.a.s().m()) {
			return false;
		} else {
			float var1 = this.a.J + 4.0F;
			return this.a.b(this.d.d()) > (double) (var1 * var1);
		}
	}

	public void c() {
		this.a.s().a(this.c, this.b);
	}

	public void d() {
		if (this.a.s().m() || this.a.b(this.d.d()) < 16.0D) {
			this.f.add(this.d);
		}

	}

	private abh a(abi var1) {
		abh var2 = null;
		int var3 = Integer.MAX_VALUE;
		List var4 = var1.f();
		Iterator var5 = var4.iterator();

		while (var5.hasNext()) {
			abh var6 = (abh) var5.next();
			int var7 = var6.b(uv.c(this.a.s), uv.c(this.a.t), uv.c(this.a.u));
			if (var7 < var3 && !this.a(var6)) {
				var2 = var6;
				var3 = var7;
			}
		}

		return var2;
	}

	private boolean a(abh var1) {
		Iterator var2 = this.f.iterator();

		abh var3;
		do {
			if (!var2.hasNext()) {
				return false;
			}

			var3 = (abh) var2.next();
		} while (!var1.d().equals(var3.d()));

		return true;
	}

	private void f() {
		if (this.f.size() > 15) {
			this.f.remove(0);
		}

	}
}

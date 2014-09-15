package net.minecraft;

import com.google.common.collect.Lists;
import java.util.Iterator;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class zc {

	private static final Logger a = LogManager.getLogger();
	private List b = Lists.newArrayList();
	private List c = Lists.newArrayList();
	private final MethodProfiler d;
	private int e;
	private int f = 3;

	public zc(MethodProfiler var1) {
		this.d = var1;
	}

	public void a(int var1, PathfinderGoal var2) {
		this.b.add(new zd(this, var1, var2));
	}

	public void a(PathfinderGoal var1) {
		Iterator var2 = this.b.iterator();

		while (var2.hasNext()) {
			zd var3 = (zd) var2.next();
			PathfinderGoal var4 = var3.a;
			if (var4 == var1) {
				if (this.c.contains(var3)) {
					var4.d();
					this.c.remove(var3);
				}

				var2.remove();
			}
		}

	}

	public void a() {
		this.d.a("goalSetup");
		Iterator var1;
		zd var2;
		if (this.e++ % this.f == 0) {
			var1 = this.b.iterator();

			while (var1.hasNext()) {
				var2 = (zd) var1.next();
				boolean var3 = this.c.contains(var2);
				if (var3) {
					if (this.b(var2) && this.a(var2)) {
						continue;
					}

					var2.a.d();
					this.c.remove(var2);
				}

				if (this.b(var2) && var2.a.a()) {
					var2.a.c();
					this.c.add(var2);
				}
			}
		} else {
			var1 = this.c.iterator();

			while (var1.hasNext()) {
				var2 = (zd) var1.next();
				if (!this.a(var2)) {
					var2.a.d();
					var1.remove();
				}
			}
		}

		this.d.b();
		this.d.a("goalTick");
		var1 = this.c.iterator();

		while (var1.hasNext()) {
			var2 = (zd) var1.next();
			var2.a.e();
		}

		this.d.b();
	}

	private boolean a(zd var1) {
		boolean var2 = var1.a.b();
		return var2;
	}

	private boolean b(zd var1) {
		Iterator var2 = this.b.iterator();

		while (var2.hasNext()) {
			zd var3 = (zd) var2.next();
			if (var3 != var1) {
				if (var1.b >= var3.b) {
					if (!this.a(var1, var3) && this.c.contains(var3)) {
						return false;
					}
				} else if (!var3.a.i() && this.c.contains(var3)) {
					return false;
				}
			}
		}

		return true;
	}

	private boolean a(zd var1, zd var2) {
		return (var1.a.j() & var2.a.j()) == 0;
	}

}

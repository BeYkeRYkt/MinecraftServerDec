package net.minecraft;

import com.google.common.collect.Sets;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class yf extends yc {

	private final Set e = Sets.newHashSet();
	protected final Map d = new ul();

	public ye e(xy var1) {
		return (ye) super.a(var1);
	}

	public ye b(String var1) {
		xz var2 = super.a(var1);
		if (var2 == null) {
			var2 = (xz) this.d.get(var1);
		}

		return (ye) var2;
	}

	public xz b(xy var1) {
		xz var2 = super.b(var1);
		if (var1 instanceof yg && ((yg) var1).g() != null) {
			this.d.put(((yg) var1).g(), var2);
		}

		return var2;
	}

	protected xz c(xy var1) {
		return new ye(this, var1);
	}

	public void a(xz var1) {
		if (var1.a().c()) {
			this.e.add(var1);
		}

		Iterator var2 = this.c.get(var1.a()).iterator();

		while (var2.hasNext()) {
			xy var3 = (xy) var2.next();
			ye var4 = this.e(var3);
			if (var4 != null) {
				var4.f();
			}
		}

	}

	public Set b() {
		return this.e;
	}

	public Collection c() {
		HashSet var1 = Sets.newHashSet();
		Iterator var2 = this.a().iterator();

		while (var2.hasNext()) {
			xz var3 = (xz) var2.next();
			if (var3.a().c()) {
				var1.add(var3);
			}
		}

		return var1;
	}

	// $FF: synthetic method
	public xz a(String var1) {
		return this.b(var1);
	}

	// $FF: synthetic method
	public xz a(xy var1) {
		return this.e(var1);
	}
}

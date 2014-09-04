package net.minecraft;

import com.google.common.collect.Maps;
import java.util.Map;

public class tz {

	protected final Map a = Maps.newConcurrentMap();

	public boolean a(tk var1) {
		return this.a((tq) var1) > 0;
	}

	public boolean b(tk var1) {
		return var1.c == null || this.a(var1.c);
	}

	public void b(ahd var1, tq var2, int var3) {
		if (!var2.d() || this.b((tk) var2)) {
			this.a(var1, var2, this.a(var2) + var3);
		}
	}

	public void a(ahd var1, tq var2, int var3) {
		tw var4 = (tw) this.a.get(var2);
		if (var4 == null) {
			var4 = new tw();
			this.a.put(var2, var4);
		}

		var4.a(var3);
	}

	public int a(tq var1) {
		tw var2 = (tw) this.a.get(var1);
		return var2 == null ? 0 : var2.a();
	}

	public tx b(tq var1) {
		tw var2 = (tw) this.a.get(var1);
		return var2 != null ? var2.b() : null;
	}

	public tx a(tq var1, tx var2) {
		tw var3 = (tw) this.a.get(var1);
		if (var3 == null) {
			var3 = new tw();
			this.a.put(var1, var3);
		}

		var3.a(var2);
		return var2;
	}
}

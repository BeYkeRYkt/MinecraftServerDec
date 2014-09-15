package net.minecraft;

import com.google.common.collect.Maps;
import java.util.Map;

public class tz {

	protected final Map<Statistic, tw> a = Maps.newConcurrentMap();

	public boolean a(Achievement var1) {
		return this.a((Statistic) var1) > 0;
	}

	public boolean b(Achievement var1) {
		return var1.c == null || this.a(var1.c);
	}

	public void b(EntityHuman var1, Statistic var2, int var3) {
		if (!var2.d() || this.b((Achievement) var2)) {
			this.a(var1, var2, this.a(var2) + var3);
		}
	}

	public void a(EntityHuman var1, Statistic var2, int var3) {
		tw var4 = (tw) this.a.get(var2);
		if (var4 == null) {
			var4 = new tw();
			this.a.put(var2, var4);
		}

		var4.a(var3);
	}

	public int a(Statistic var1) {
		tw var2 = (tw) this.a.get(var1);
		return var2 == null ? 0 : var2.a();
	}

	public IJsonStatistic b(Statistic var1) {
		tw var2 = (tw) this.a.get(var1);
		return var2 != null ? var2.b() : null;
	}

	public IJsonStatistic a(Statistic var1, IJsonStatistic var2) {
		tw var3 = (tw) this.a.get(var1);
		if (var3 == null) {
			var3 = new tw();
			this.a.put(var1, var3);
		}

		var3.a(var2);
		return var2;
	}
}

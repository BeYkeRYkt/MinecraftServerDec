package net.minecraft;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public abstract class yc {

	protected final Map a = Maps.newHashMap();
	protected final Map b = new ul();
	protected final Multimap c = HashMultimap.create();

	public xz a(xy var1) {
		return (xz) this.a.get(var1);
	}

	public xz a(String var1) {
		return (xz) this.b.get(var1);
	}

	public xz b(xy var1) {
		if (this.b.containsKey(var1.a())) {
			throw new IllegalArgumentException("Attribute is already registered!");
		} else {
			xz var2 = this.c(var1);
			this.b.put(var1.a(), var2);
			this.a.put(var1, var2);

			for (xy var3 = var1.d(); var3 != null; var3 = var3.d()) {
				this.c.put(var3, var1);
			}

			return var2;
		}
	}

	protected abstract xz c(xy var1);

	public Collection a() {
		return this.b.values();
	}

	public void a(xz var1) {
	}

	public void a(Multimap var1) {
		Iterator var2 = var1.entries().iterator();

		while (var2.hasNext()) {
			Entry var3 = (Entry) var2.next();
			xz var4 = this.a((String) var3.getKey());
			if (var4 != null) {
				var4.c((ya) var3.getValue());
			}
		}

	}

	public void b(Multimap var1) {
		Iterator var2 = var1.entries().iterator();

		while (var2.hasNext()) {
			Entry var3 = (Entry) var2.next();
			xz var4 = this.a((String) var3.getKey());
			if (var4 != null) {
				var4.c((ya) var3.getValue());
				var4.b((ya) var3.getValue());
			}
		}

	}
}

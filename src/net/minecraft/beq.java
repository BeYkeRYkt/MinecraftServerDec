package net.minecraft;

import com.google.common.base.Predicate;
import com.google.common.collect.Maps;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class beq implements Predicate {

	private final bed a;
	private final Map b = Maps.newHashMap();

	private beq(bed var1) {
		this.a = var1;
	}

	public static beq a(Block var0) {
		return new beq(var0.O());
	}

	public boolean a(BlockState var1) {
		if (var1 != null && var1.getBlock().equals(this.a.c())) {
			Iterator var2 = this.b.entrySet().iterator();

			Entry var3;
			Comparable var4;
			do {
				if (!var2.hasNext()) {
					return true;
				}

				var3 = (Entry) var2.next();
				var4 = var1.b((bex) var3.getKey());
			} while (((Predicate) var3.getValue()).apply(var4));

			return false;
		} else {
			return false;
		}
	}

	public beq a(bex var1, Predicate var2) {
		if (!this.a.d().contains(var1)) {
			throw new IllegalArgumentException(this.a + " cannot support property " + var1);
		} else {
			this.b.put(var1, var2);
			return this;
		}
	}

	// $FF: synthetic method
	public boolean apply(Object var1) {
		return this.a((BlockState) var1);
	}
}

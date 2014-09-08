package net.minecraft;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableTable;
import com.google.common.collect.Maps;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

class beg extends bea {

	private final Block a;
	private final ImmutableMap b;
	private ImmutableTable c;

	private beg(Block var1, ImmutableMap var2) {
		this.a = var1;
		this.b = var2;
	}

	public Collection a() {
		return Collections.unmodifiableCollection(this.b.keySet());
	}

	public Comparable b(bex var1) {
		if (!this.b.containsKey(var1)) {
			throw new IllegalArgumentException("Cannot get property " + var1 + " as it does not exist in " + this.a.O());
		} else {
			return (Comparable) var1.b().cast(this.b.get(var1));
		}
	}

	public BlockState a(bex var1, Comparable var2) {
		if (!this.b.containsKey(var1)) {
			throw new IllegalArgumentException("Cannot set property " + var1 + " as it does not exist in " + this.a.O());
		} else if (!var1.c().contains(var2)) {
			throw new IllegalArgumentException("Cannot set property " + var1 + " to " + var2 + " on block " + Block.BLOCKREGISTRY.c(this.a) + ", it is not an allowed value");
		} else {
			return (BlockState) (this.b.get(var1) == var2 ? this : (BlockState) this.c.get(var1, var2));
		}
	}

	public ImmutableMap b() {
		return this.b;
	}

	public Block getBlock() {
		return this.a;
	}

	public boolean equals(Object var1) {
		return this == var1;
	}

	public int hashCode() {
		return this.b.hashCode();
	}

	public void a(Map var1) {
		if (this.c != null) {
			throw new IllegalStateException();
		} else {
			HashBasedTable var2 = HashBasedTable.create();
			Iterator var3 = this.b.keySet().iterator();

			while (var3.hasNext()) {
				bex var4 = (bex) var3.next();
				Iterator var5 = var4.c().iterator();

				while (var5.hasNext()) {
					Comparable var6 = (Comparable) var5.next();
					if (var6 != this.b.get(var4)) {
						var2.put(var4, var6, var1.get(this.b(var4, var6)));
					}
				}
			}

			this.c = ImmutableTable.copyOf(var2);
		}
	}

	private Map b(bex var1, Comparable var2) {
		HashMap var3 = Maps.newHashMap(this.b);
		var3.put(var1, var2);
		return var3;
	}

	// $FF: synthetic method
	beg(Block var1, ImmutableMap var2, bee var3) {
		this(var1, var2);
	}
}

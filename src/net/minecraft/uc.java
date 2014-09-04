package net.minecraft;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import com.google.common.collect.Sets;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Set;
import org.apache.commons.lang3.ClassUtils;

public class uc extends AbstractSet {

	private final Multimap a = HashMultimap.create();
	private final Set b = Sets.newIdentityHashSet();
	private final Class c;

	public uc(Class var1) {
		this.c = var1;
		this.b.add(var1);
	}

	public void a(Class var1) {
		Iterator var2 = this.a.get(this.a(var1, false)).iterator();

		while (var2.hasNext()) {
			Object var3 = var2.next();
			if (var1.isAssignableFrom(var3.getClass())) {
				this.a.put(var1, var3);
			}
		}

		this.b.add(var1);
	}

	protected Class a(Class var1, boolean var2) {
		Iterator var3 = ClassUtils.hierarchy(var1, ClassUtils.Interfaces.INCLUDE).iterator();

		Class var4;
		do {
			if (!var3.hasNext()) {
				throw new IllegalArgumentException("Don\'t know how to search for " + var1);
			}

			var4 = (Class) var3.next();
		} while (!this.b.contains(var4));

		if (var4 == this.c && var2) {
			this.a(var1);
		}

		return var4;
	}

	public boolean add(Object var1) {
		Iterator var2 = this.b.iterator();

		while (var2.hasNext()) {
			Class var3 = (Class) var2.next();
			if (var3.isAssignableFrom(var1.getClass())) {
				this.a.put(var3, var1);
			}
		}

		return true;
	}

	public boolean remove(Object var1) {
		Object var2 = var1;
		boolean var3 = false;
		Iterator var4 = this.b.iterator();

		while (var4.hasNext()) {
			Class var5 = (Class) var4.next();
			if (var5.isAssignableFrom(var2.getClass())) {
				var3 |= this.a.remove(var5, var2);
			}
		}

		return var3;
	}

	public Iterable b(Class var1) {
		return new ud(this, var1);
	}

	public Iterator iterator() {
		Iterator var1 = this.a.get(this.c).iterator();
		return new ue(this, var1);
	}

	public int size() {
		return this.a.get(this.c).size();
	}

	// $FF: synthetic method
	static Multimap a(uc var0) {
		return var0.a;
	}
}

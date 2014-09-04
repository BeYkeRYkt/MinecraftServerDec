package net.minecraft;

import com.google.common.collect.Iterators;
import java.util.Iterator;

class ud implements Iterable {

	// $FF: synthetic field
	final Class a;
	// $FF: synthetic field
	final uc b;

	ud(uc var1, Class var2) {
		this.b = var1;
		this.a = var2;
	}

	public Iterator iterator() {
		Iterator var1 = uc.a(this.b).get(this.b.a(this.a, true)).iterator();
		return Iterators.filter(var1, this.a);
	}
}

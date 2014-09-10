package net.minecraft;

import com.google.common.collect.AbstractIterator;
import java.util.Iterator;

class ue extends AbstractIterator {

	// $FF: synthetic field
	final Iterator a;
	// $FF: synthetic field
	final EntitySlice b;

	ue(EntitySlice var1, Iterator var2) {
		this.b = var1;
		this.a = var2;
	}

	protected Object computeNext() {
		return !this.a.hasNext() ? this.endOfData() : this.a.next();
	}
}

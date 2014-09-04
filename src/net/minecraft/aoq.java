package net.minecraft;

import java.util.Comparator;

class aoq implements Comparator {

	// $FF: synthetic field
	final aop a;

	aoq(aop var1) {
		this.a = var1;
	}

	public int a(aoo var1, aoo var2) {
		return var1 instanceof aot && var2 instanceof aos ? 1 : (var2 instanceof aot && var1 instanceof aos ? -1 : (var2.a() < var1.a() ? -1 : (var2.a() > var1.a() ? 1 : 0)));
	}

	// $FF: synthetic method
	public int compare(Object var1, Object var2) {
		return this.a((aoo) var1, (aoo) var2);
	}
}

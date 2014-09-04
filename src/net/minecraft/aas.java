package net.minecraft;

import java.util.Comparator;

public class aas implements Comparator {

	private final Entity a;

	public aas(Entity var1) {
		this.a = var1;
	}

	public int a(Entity var1, Entity var2) {
		double var3 = this.a.h(var1);
		double var5 = this.a.h(var2);
		return var3 < var5 ? -1 : (var3 > var5 ? 1 : 0);
	}

	// $FF: synthetic method
	public int compare(Object var1, Object var2) {
		return this.a((Entity) var1, (Entity) var2);
	}
}

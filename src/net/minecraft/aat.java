package net.minecraft;

import com.google.common.base.Predicate;

public class aat extends PathfinderGoalNearestAttackableTarget {

	private xx g;

	public aat(xx var1, Class var2, boolean var3, Predicate var4) {
		super(var1, var2, 10, var3, false, var4);
		this.g = var1;
	}

	public boolean a() {
		return !this.g.cj() && super.a();
	}
}

package net.minecraft;

import com.google.common.base.Predicate;

class av implements Predicate {

	// $FF: synthetic field
	final qw a;
	// $FF: synthetic field
	final tq b;
	// $FF: synthetic field
	final AchievmentCommand c;

	av(AchievmentCommand var1, qw var2, tq var3) {
		this.c = var1;
		this.a = var2;
		this.b = var3;
	}

	public boolean a(tk var1) {
		return this.a.A().a(var1) && var1 != this.b;
	}

	// $FF: synthetic method
	public boolean apply(Object var1) {
		return this.a((tk) var1);
	}
}

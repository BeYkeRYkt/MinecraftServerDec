package net.minecraft;

import com.google.common.base.Predicate;

final class ak implements Predicate {

	// $FF: synthetic field
	final brt a;

	ak(brt var1) {
		this.a = var1;
	}

	public boolean a(Entity var1) {
		return var1.locationX >= this.a.a && var1.locationY >= this.a.b && var1.locationZ >= this.a.c ? var1.locationX < this.a.d && var1.locationY < this.a.e && var1.locationZ < this.a.f : false;
	}

	// $FF: synthetic method
	public boolean apply(Object var1) {
		return this.a((Entity) var1);
	}
}

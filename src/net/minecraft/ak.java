package net.minecraft;

import com.google.common.base.Predicate;

final class ak implements Predicate {

	// $FF: synthetic field
	final AxisAlignedBB a;

	ak(AxisAlignedBB var1) {
		this.a = var1;
	}

	public boolean a(Entity var1) {
		return var1.locationX >= this.a.minX && var1.locationY >= this.a.minY && var1.locationZ >= this.a.minZ ? var1.locationX < this.a.maxX && var1.locationY < this.a.maxY && var1.locationZ < this.a.maxZ : false;
	}

	// $FF: synthetic method
	public boolean apply(Object var1) {
		return this.a((Entity) var1);
	}
}

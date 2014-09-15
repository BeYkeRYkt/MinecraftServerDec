package net.minecraft;

final class DispenseBehaviorArrow extends DispenseBehaviorProjectile {

	protected aho a(World var1, IPosition var2) {
		EntityArrow var3 = new EntityArrow(var1, var2.getX(), var2.getY(), var2.getZ());
		var3.a = 1;
		return var3;
	}
}

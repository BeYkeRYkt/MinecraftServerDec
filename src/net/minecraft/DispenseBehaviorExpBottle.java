package net.minecraft;

final class DispenseBehaviorExpBottle extends DispenseBehaviorProjectile {

	protected aho a(World var1, IPosition var2) {
		return new EntityThrownExpBottle(var1, var2.getX(), var2.getY(), var2.getZ());
	}

	protected float a() {
		return super.a() * 0.5F;
	}

	protected float b() {
		return super.b() * 1.25F;
	}
}

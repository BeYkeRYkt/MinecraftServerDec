package net.minecraft;

public abstract class EntityWaterAnimal extends EntityInsentient implements IAnimal {

	public EntityWaterAnimal(World var1) {
		super(var1);
	}

	public boolean aX() {
		return true;
	}

	public boolean bQ() {
		return true;
	}

	public boolean bR() {
		return this.world.a(this.getBoundingBox(), (Entity) this);
	}

	public int w() {
		return 120;
	}

	protected boolean C() {
		return true;
	}

	protected int b(EntityHuman var1) {
		return 1 + this.world.random.nextInt(3);
	}

	public void K() {
		int var1 = this.getAirTicks();
		super.K();
		if (this.isAlive() && !this.V()) {
			--var1;
			this.h(var1);
			if (this.getAirTicks() == -20) {
				this.h(0);
				this.receiveDamage(DamageSource.DROWN, 2.0F);
			}
		} else {
			this.h(300);
		}

	}

	public boolean aK() {
		return false;
	}
}

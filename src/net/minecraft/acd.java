package net.minecraft;

class acd extends zk {

	public acd(EntityRabbit var1) {
		super(var1, EntityLiving.class, 1.4D, true);
	}

	protected double a(EntityLiving var1) {
		return (double) (4.0F + var1.height);
	}
}

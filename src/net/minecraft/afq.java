package net.minecraft;

class afq extends aal {

	public afq(EntityPigZombie var1) {
		super(var1, true, new Class[0]);
	}

	protected void a(EntityCreature var1, EntityLiving var2) {
		super.a(var1, var2);
		if (var1 instanceof EntityPigZombie) {
			EntityPigZombie.a((EntityPigZombie) var1, (Entity) var2);
		}

	}
}

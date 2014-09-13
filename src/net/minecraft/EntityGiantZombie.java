package net.minecraft;

public class EntityGiantZombie extends EntityMonster {

	public EntityGiantZombie(World var1) {
		super(var1);
		this.a(this.height * 6.0F, this.width * 6.0F);
	}

	public float getHeadHeight() {
		return 10.440001F;
	}

	protected void aW() {
		super.aW();
		this.a(afs.a).a(100.0D);
		this.a(afs.d).a(0.5D);
		this.a(afs.e).a(50.0D);
	}

	public float a(Position var1) {
		return this.world.o(var1) - 0.5F;
	}
}

package net.minecraft;

class aei extends MobSpawnerAbstract {

	// $FF: synthetic field
	final EntityMinecartMobSpawner a;

	aei(EntityMinecartMobSpawner var1) {
		this.a = var1;
	}

	public void a(int var1) {
		this.a.world.broadcastEntityEffect((Entity) this.a, (byte) var1);
	}

	public World getWorld() {
		return this.a.world;
	}

	public Position getPosition() {
		return new Position(this.a);
	}
}

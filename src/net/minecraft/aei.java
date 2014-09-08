package net.minecraft;

class aei extends aqi {

	// $FF: synthetic field
	final EntityMinecartMobSpawner a;

	aei(EntityMinecartMobSpawner var1) {
		this.a = var1;
	}

	public void a(int var1) {
		this.a.world.a((Entity) this.a, (byte) var1);
	}

	public World a() {
		return this.a.world;
	}

	public Position b() {
		return new Position(this.a);
	}
}

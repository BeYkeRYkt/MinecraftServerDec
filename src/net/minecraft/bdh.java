package net.minecraft;

class bdh extends aqi {

	// $FF: synthetic field
	final TileEntityMobSpawner a;

	bdh(TileEntityMobSpawner var1) {
		this.a = var1;
	}

	public void a(int var1) {
		this.a.world.c(this.a.position, aty.ac, var1, 0);
	}

	public World a() {
		return this.a.world;
	}

	public Position b() {
		return this.a.position;
	}

	public void a(aqj var1) {
		super.a(var1);
		if (this.a() != null) {
			this.a().h(this.a.position);
		}

	}
}

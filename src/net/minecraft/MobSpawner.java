package net.minecraft;

class MobSpawner extends MobSpawnerAbstract {

	// $FF: synthetic field
	final TileEntityMobSpawner a;

	MobSpawner(TileEntityMobSpawner var1) {
		this.a = var1;
	}

	public void a(int var1) {
		this.a.world.playBlockAction(this.a.position, Blocks.MOB_SPAWNER, var1, 0);
	}

	public World getWorld() {
		return this.a.world;
	}

	public Position getPosition() {
		return this.a.position;
	}

	public void setData(TileEntityMobSpawnerData var1) {
		super.setData(var1);
		if (this.getWorld() != null) {
			this.getWorld().notify(this.a.position);
		}

	}
}

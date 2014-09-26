package net.minecraft;

public class TileEntityMobSpawner extends TileEntity implements ITickable {

	private final MobSpawnerAbstract spawner = new MobSpawner(this);

	public void read(NBTCompoundTag tag) {
		super.read(tag);
		this.spawner.read(tag);
	}

	public void write(NBTCompoundTag tag) {
		super.write(tag);
		this.spawner.write(tag);
	}

	public void doTick() {
		this.spawner.doTick();
	}

	public Packet<?> getUpdatePacket() {
		NBTCompoundTag tag = new NBTCompoundTag();
		this.write(tag);
		tag.remove("SpawnPotentials");
		return new PacketPlayOutUpdateBlockEntity(this.position, 1, tag);
	}

	public boolean c(int var1, int var2) {
		return this.spawner.b(var1) ? true : super.c(var1, var2);
	}

	public MobSpawnerAbstract getSpawner() {
		return this.spawner;
	}

}

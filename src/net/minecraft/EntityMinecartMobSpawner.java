package net.minecraft;

public class EntityMinecartMobSpawner extends adx {

	private final MobSpawnerAbstract a = new aei(this);

	public EntityMinecartMobSpawner(World var1) {
		super(var1);
	}

	public EntityMinecartMobSpawner(World var1, double var2, double var4, double var6) {
		super(var1, var2, var4, var6);
	}

	public MinecartType getType() {
		return MinecartType.SPAWNER;
	}

	public IBlockState u() {
		return Blocks.MOB_SPAWNER.getBlockState();
	}

	protected void readAdditionalData(NBTCompoundTag var1) {
		super.readAdditionalData(var1);
		this.a.read(var1);
	}

	protected void writeAdditionalData(NBTCompoundTag var1) {
		super.writeAdditionalData(var1);
		this.a.write(var1);
	}

	public void doTick() {
		super.doTick();
		this.a.doTick();
	}
}

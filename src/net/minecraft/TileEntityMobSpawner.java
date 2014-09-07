package net.minecraft;

public class TileEntityMobSpawner extends TileEntity implements pm {

	private final aqi a = new bdh(this);

	public void read(NBTCompoundTag var1) {
		super.read(var1);
		this.a.a(var1);
	}

	public void write(NBTCompoundTag var1) {
		super.write(var1);
		this.a.b(var1);
	}

	public void c() {
		this.a.c();
	}

	public Packet getUpdatePacket() {
		NBTCompoundTag var1 = new NBTCompoundTag();
		this.write(var1);
		var1.remove("SpawnPotentials");
		return new PacketPlayOutUpdateBlockEntity(this.position, 1, var1);
	}

	public boolean c(int var1, int var2) {
		return this.a.b(var1) ? true : super.c(var1, var2);
	}

	public aqi b() {
		return this.a;
	}
}

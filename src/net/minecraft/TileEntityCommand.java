package net.minecraft;

public class TileEntityCommand extends TileEntity {

	private final aqf a = new bcu(this);

	public void write(NBTCompoundTag var1) {
		super.write(var1);
		this.a.a(var1);
	}

	public void read(NBTCompoundTag var1) {
		super.read(var1);
		this.a.b(var1);
	}

	public Packet getUpdatePacket() {
		NBTCompoundTag var1 = new NBTCompoundTag();
		this.write(var1);
		return new PacketPlayOutUpdateBlockEntity(this.position, 2, var1);
	}

	public aqf b() {
		return this.a;
	}

	public af c() {
		return this.a.n();
	}
}

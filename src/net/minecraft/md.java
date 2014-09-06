package net.minecraft;

public class md implements Packet<ls> {

	private int a;
	private me b;
	private Vec3D c;

	public void readData(PacketDataSerializer var1) {
		this.a = var1.readVarInt();
		this.b = (me) var1.a(me.class);
		if (this.b == me.c) {
			this.c = new Vec3D((double) var1.readFloat(), (double) var1.readFloat(), (double) var1.readFloat());
		}

	}

	public void writeData(PacketDataSerializer var1) {
		var1.writeVarInt(this.a);
		var1.writeEnum((Enum) this.b);
		if (this.b == me.c) {
			var1.writeFloat((float) this.c.x);
			var1.writeFloat((float) this.c.y);
			var1.writeFloat((float) this.c.z);
		}

	}

	public void handlePacket(ls var1) {
		var1.a(this);
	}

	public Entity a(World var1) {
		return var1.a(this.a);
	}

	public me a() {
		return this.b;
	}

	public Vec3D b() {
		return this.c;
	}
}

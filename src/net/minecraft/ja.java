package net.minecraft;

public class ja implements Packet<PlayPacketListener> {

	private aqm a;
	private jb[] b;

	public ja() {
	}

	public ja(int var1, short[] var2, bfh var3) {
		this.a = new aqm(var3.a, var3.b);
		this.b = new jb[var1];

		for (int var4 = 0; var4 < this.b.length; ++var4) {
			this.b[var4] = new jb(this, var2[var4], var3);
		}

	}

	public void readData(PacketDataSerializer var1) {
		this.a = new aqm(var1.readInt(), var1.readInt());
		this.b = new jb[var1.readVarInt()];

		for (int var2 = 0; var2 < this.b.length; ++var2) {
			this.b[var2] = new jb(this, var1.readShort(), (bec) Block.d.a(var1.readVarInt()));
		}

	}

	public void writeData(PacketDataSerializer var1) {
		var1.writeInt(this.a.a);
		var1.writeInt(this.a.b);
		var1.writeVarInt(this.b.length);
		jb[] var2 = this.b;
		int var3 = var2.length;

		for (int var4 = 0; var4 < var3; ++var4) {
			jb var5 = var2[var4];
			var1.writeShort(var5.b());
			var1.writeVarInt(Block.d.b(var5.c()));
		}

	}

	public void handlePacket(PlayPacketListener var1) {
		var1.a(this);
	}

	// $FF: synthetic method
	static aqm a(ja var0) {
		return var0.a;
	}
}

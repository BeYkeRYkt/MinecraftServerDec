package net.minecraft;

import java.io.IOException;

public class iu implements Packet<PlayPacketListener> {

	private Position a;
	private int b;
	private NBTCompoundTag c;

	public iu() {
	}

	public iu(Position var1, int var2, NBTCompoundTag var3) {
		this.a = var1;
		this.b = var2;
		this.c = var3;
	}

	public void readData(PacketDataSerializer var1) throws IOException {
		this.a = var1.readPosition();
		this.b = var1.readUnsignedByte();
		this.c = var1.readCompound();
	}

	public void writeData(PacketDataSerializer var1) {
		var1.writePosition(this.a);
		var1.writeByte((byte) this.b);
		var1.writeCompound(this.c);
	}

	public void handlePacket(PlayPacketListener var1) {
		var1.a(this);
	}
}

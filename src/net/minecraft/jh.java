package net.minecraft;

import java.io.IOException;

public class jh implements Packet<PlayPacketListener> {

	private int a;
	private int b;
	private ItemStack c;

	public jh() {
	}

	public jh(int var1, int var2, ItemStack var3) {
		this.a = var1;
		this.b = var2;
		this.c = var3 == null ? null : var3.getCopy();
	}

	public void handlePacket(PlayPacketListener var1) {
		var1.a(this);
	}

	public void readData(PacketDataSerializer var1) throws IOException {
		this.a = var1.readByte();
		this.b = var1.readShort();
		this.c = var1.readItemStack();
	}

	public void writeData(PacketDataSerializer var1) {
		var1.writeByte(this.a);
		var1.writeShort(this.b);
		var1.writeItemStack(this.c);
	}
}

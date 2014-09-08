package net.minecraft;

import java.io.IOException;

public class ma implements Packet<PlayInPacketListener> {

	private int a;
	private int b;
	private int c;
	private short d;
	private ItemStack e;
	private int f;

	public void handlePacket(PlayInPacketListener var1) {
		var1.a(this);
	}

	public void readData(PacketDataSerializer var1) throws IOException {
		this.a = var1.readByte();
		this.b = var1.readShort();
		this.c = var1.readByte();
		this.d = var1.readShort();
		this.f = var1.readByte();
		this.e = var1.readItemStack();
	}

	public void writeData(PacketDataSerializer var1) {
		var1.writeByte(this.a);
		var1.writeShort(this.b);
		var1.writeByte(this.c);
		var1.writeShort(this.d);
		var1.writeByte(this.f);
		var1.writeItemStack(this.e);
	}

	public int a() {
		return this.a;
	}

	public int b() {
		return this.b;
	}

	public int c() {
		return this.c;
	}

	public short d() {
		return this.d;
	}

	public ItemStack e() {
		return this.e;
	}

	public int f() {
		return this.f;
	}
}

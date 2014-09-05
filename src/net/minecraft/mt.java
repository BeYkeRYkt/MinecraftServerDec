package net.minecraft;

import java.io.IOException;

public class mt implements Packet<ls> {

	private int a;
	private ItemStack b;

	public void handlePacket(ls var1) {
		var1.a(this);
	}

	public void readData(PacketDataSerializer var1) throws IOException {
		this.a = var1.readShort();
		this.b = var1.readItemStack();
	}

	public void writeData(PacketDataSerializer var1) {
		var1.writeShort(this.a);
		var1.writeItemStack(this.b);
	}

	public int a() {
		return this.a;
	}

	public ItemStack b() {
		return this.b;
	}
}

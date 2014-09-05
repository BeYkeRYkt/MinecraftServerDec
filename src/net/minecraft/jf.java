package net.minecraft;

import java.io.IOException;
import java.util.List;

public class jf implements Packet<PlayPacketListener> {

	private int a;
	private ItemStack[] b;

	public jf() {
	}

	public jf(int var1, List var2) {
		this.a = var1;
		this.b = new ItemStack[var2.size()];

		for (int var3 = 0; var3 < this.b.length; ++var3) {
			ItemStack var4 = (ItemStack) var2.get(var3);
			this.b[var3] = var4 == null ? null : var4.getCopy();
		}

	}

	public void readData(PacketDataSerializer var1) throws IOException {
		this.a = var1.readUnsignedByte();
		short var2 = var1.readShort();
		this.b = new ItemStack[var2];

		for (int var3 = 0; var3 < var2; ++var3) {
			this.b[var3] = var1.readItemStack();
		}

	}

	public void writeData(PacketDataSerializer var1) {
		var1.writeByte(this.a);
		var1.writeShort(this.b.length);
		ItemStack[] var2 = this.b;
		int var3 = var2.length;

		for (int var4 = 0; var4 < var3; ++var4) {
			ItemStack var5 = var2[var4];
			var1.writeItemStack(var5);
		}

	}

	public void handlePacket(PlayPacketListener var1) {
		var1.a(this);
	}
}

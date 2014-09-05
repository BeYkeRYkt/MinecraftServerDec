package net.minecraft;

public class km implements Packet<PlayPacketListener> {

	private int[] a;

	public km() {
	}

	public km(int... var1) {
		this.a = var1;
	}

	public void readData(PacketDataSerializer var1) {
		this.a = new int[var1.readVarInt()];

		for (int var2 = 0; var2 < this.a.length; ++var2) {
			this.a[var2] = var1.readVarInt();
		}

	}

	public void writeData(PacketDataSerializer var1) {
		var1.writeVarInt(this.a.length);

		for (int var2 = 0; var2 < this.a.length; ++var2) {
			var1.writeVarInt(this.a[var2]);
		}

	}

	public void handlePacket(PlayPacketListener var1) {
		var1.a(this);
	}
}

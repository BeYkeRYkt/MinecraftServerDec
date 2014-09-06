package net.minecraft;

public class ku implements Packet<PlayClientboundPacketListener> {

	public int a;

	public ku() {
	}

	public ku(Entity var1) {
		this.a = var1.getId();
	}

	public void readData(PacketDataSerializer var1) {
		this.a = var1.readVarInt();
	}

	public void writeData(PacketDataSerializer var1) {
		var1.writeVarInt(this.a);
	}

	public void handlePacket(PlayClientboundPacketListener var1) {
		var1.a(this);
	}
}

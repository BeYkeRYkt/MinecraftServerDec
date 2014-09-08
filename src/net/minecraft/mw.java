package net.minecraft;

import java.util.UUID;

public class mw implements Packet<PlayInPacketListener> {

	private UUID a;

	public mw() {
	}

	public mw(UUID var1) {
		this.a = var1;
	}

	public void readData(PacketDataSerializer var1) {
		this.a = var1.readUUID();
	}

	public void writeData(PacketDataSerializer var1) {
		var1.writeUUID(this.a);
	}

	public void handlePacket(PlayInPacketListener var1) {
		var1.a(this);
	}

	public Entity a(WorldServer var1) {
		return var1.a(this.a);
	}
}

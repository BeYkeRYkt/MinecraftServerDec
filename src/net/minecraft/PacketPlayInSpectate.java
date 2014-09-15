package net.minecraft;

import java.util.UUID;

public class PacketPlayInSpectate implements Packet<PlayInPacketListener> {

	private UUID uuid;

	public PacketPlayInSpectate() {
	}

	public PacketPlayInSpectate(UUID uuid) {
		this.uuid = uuid;
	}

	public void readData(PacketDataSerializer serializer) {
		this.uuid = serializer.readUUID();
	}

	public void writeData(PacketDataSerializer serializer) {
		serializer.writeUUID(this.uuid);
	}

	public void handlePacket(PlayInPacketListener listener) {
		listener.handle(this);
	}

	public Entity getEntity(WorldServer world) {
		return world.getEntity(this.uuid);
	}

}

package net.minecraft;

import java.io.IOException;
import java.util.List;

public class PacketEntityMetadata implements Packet<PlayPacketListener> {

	private int entityId;
	private List<?> metadata;

	public PacketEntityMetadata() {
	}

	public PacketEntityMetadata(int entityId, DataWatcher dataWatcher, boolean flag) {
		this.entityId = entityId;
		if (flag) {
			this.metadata = dataWatcher.c();
		} else {
			this.metadata = dataWatcher.b();
		}

	}

	public void readData(PacketDataSerializer serializer) throws IOException {
		this.entityId = serializer.readVarInt();
		this.metadata = DataWatcher.readData(serializer);
	}

	public void writeData(PacketDataSerializer serializer) {
		serializer.writeVarInt(this.entityId);
		DataWatcher.writeData(this.metadata, serializer);
	}

	public void handlePacket(PlayPacketListener listener) {
		listener.handle(this);
	}

}

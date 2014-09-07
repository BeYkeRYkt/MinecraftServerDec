package net.minecraft;

public class PacketOutDisconnect implements Packet<PlayClientboundPacketListener> {

	private IChatBaseComponent disconnectMessage;

	public PacketOutDisconnect() {
	}

	public PacketOutDisconnect(IChatBaseComponent disconnectMessage) {
		this.disconnectMessage = disconnectMessage;
	}

	public void readData(PacketDataSerializer serializer) {
		this.disconnectMessage = serializer.readJSONComponent();
	}

	public void writeData(PacketDataSerializer serializer) {
		serializer.writeJSONComponent(this.disconnectMessage);
	}

	public void handlePacket(PlayClientboundPacketListener listener) {
		listener.handle(this);
	}

}

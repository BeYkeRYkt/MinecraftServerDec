package net.minecraft;

public class PacketPlayOutDisconnect implements Packet<PlayOutPacketListener> {

	private IChatBaseComponent disconnectMessage;

	public PacketPlayOutDisconnect() {
	}

	public PacketPlayOutDisconnect(IChatBaseComponent disconnectMessage) {
		this.disconnectMessage = disconnectMessage;
	}

	public void readData(PacketDataSerializer serializer) {
		this.disconnectMessage = serializer.readJSONComponent();
	}

	public void writeData(PacketDataSerializer serializer) {
		serializer.writeJSONComponent(this.disconnectMessage);
	}

	public void handlePacket(PlayOutPacketListener listener) {
		listener.handle(this);
	}

}

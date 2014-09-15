package net.minecraft;

public class PacketLoginOutDisconnect implements Packet<LoginClientboundPacketListener> {

	private IChatBaseComponent data;

	public PacketLoginOutDisconnect() {
	}

	public PacketLoginOutDisconnect(IChatBaseComponent data) {
		this.data = data;
	}

	public void readData(PacketDataSerializer serializer) {
		this.data = serializer.readJSONComponent();
	}

	public void writeData(PacketDataSerializer serializer) {
		serializer.writeJSONComponent(this.data);
	}

	public void handlePacket(LoginClientboundPacketListener listener) {
		listener.handle(this);
	}

}

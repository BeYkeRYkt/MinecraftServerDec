package net.minecraft;

public class PacketPlayInChatMessage implements Packet<PlayInPacketListener> {

	private String message;

	public PacketPlayInChatMessage() {
	}

	public PacketPlayInChatMessage(String message) {
		if (message.length() > 100) {
			message = message.substring(0, 100);
		}

		this.message = message;
	}

	public void readData(PacketDataSerializer serializer) {
		this.message = serializer.readString(100);
	}

	public void writeData(PacketDataSerializer serializer) {
		serializer.writeString(this.message);
	}

	public void handlePacket(PlayInPacketListener listener) {
		listener.handle(this);
	}

	public String getMessage() {
		return this.message;
	}

}

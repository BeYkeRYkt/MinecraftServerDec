package net.minecraft;

public class PacketChatMessage implements Packet<PlayPacketListener> {

	private IJSONComponent jsonChat;
	private byte displayPosition;

	public PacketChatMessage() {
	}

	public PacketChatMessage(IJSONComponent jsonChat) {
		this(jsonChat, (byte) 1);
	}

	public PacketChatMessage(IJSONComponent jsonChat, byte position) {
		this.jsonChat = jsonChat;
		this.displayPosition = position;
	}

	public void readData(PacketDataSerializer serializer) {
		this.jsonChat = serializer.readJSONComponent();
		this.displayPosition = serializer.readByte();
	}

	public void writeData(PacketDataSerializer serializer) {
		serializer.writeJSONComponent(this.jsonChat);
		serializer.writeByte(this.displayPosition);
	}

	public void handlePacket(PlayPacketListener listener) {
		listener.handle(this);
	}

	public boolean isChatMessage() {
		return this.displayPosition == 1 || this.displayPosition == 2;
	}

}

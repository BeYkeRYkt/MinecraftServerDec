package net.minecraft;

public class PacketOutChatMessage implements Packet<PlayClientboundPacketListener> {

	private IChatBaseComponent jsonChat;
	private byte displayPosition;

	public PacketOutChatMessage() {
	}

	public PacketOutChatMessage(IChatBaseComponent jsonChat) {
		this(jsonChat, (byte) 1);
	}

	public PacketOutChatMessage(IChatBaseComponent jsonChat, byte position) {
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

	public void handlePacket(PlayClientboundPacketListener listener) {
		listener.handle(this);
	}

	public boolean isChatMessage() {
		return this.displayPosition == 1 || this.displayPosition == 2;
	}

}

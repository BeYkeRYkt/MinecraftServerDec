package net.minecraft;

public class PacketPlayOutChatMessage implements Packet<PlayOutPacketListener> {

	private IChatBaseComponent jsonChat;
	private byte displayPosition;

	public PacketPlayOutChatMessage() {
	}

	public PacketPlayOutChatMessage(IChatBaseComponent jsonChat) {
		this(jsonChat, (byte) 1);
	}

	public PacketPlayOutChatMessage(IChatBaseComponent jsonChat, byte position) {
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

	public void handlePacket(PlayOutPacketListener listener) {
		listener.handle(this);
	}

	public boolean isChatMessage() {
		return this.displayPosition == 1 || this.displayPosition == 2;
	}

}

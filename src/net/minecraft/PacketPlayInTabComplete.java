package net.minecraft;

import org.apache.commons.lang3.StringUtils;

public class PacketPlayInTabComplete implements Packet<PlayInPacketListener> {

	private String text;
	private Position position;

	public PacketPlayInTabComplete() {
	}

	public PacketPlayInTabComplete(String text) {
		this(text, (Position) null);
	}

	public PacketPlayInTabComplete(String text, Position position) {
		this.text = text;
		this.position = position;
	}

	public void readData(PacketDataSerializer serializer) {
		this.text = serializer.readString(32767);
		boolean hasPosition = serializer.readBoolean();
		if (hasPosition) {
			this.position = serializer.readPosition();
		}

	}

	public void writeData(PacketDataSerializer serializer) {
		serializer.writeString(StringUtils.substring(this.text, 0, 32767));
		boolean hasPosition = this.position != null;
		serializer.writeBoolean(hasPosition);
		if (hasPosition) {
			serializer.writePosition(this.position);
		}

	}

	public void handlePacket(PlayInPacketListener listener) {
		listener.handle(this);
	}

	public String getText() {
		return this.text;
	}

	public Position getPosition() {
		return this.position;
	}

}

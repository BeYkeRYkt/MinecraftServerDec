package net.minecraft;

public class PacketPlayInClientSettings implements Packet<PlayInPacketListener> {

	private String locale;
	private int viewDistance;
	private EnumChatFlag chatFlag;
	private boolean chatColorsEnabled;
	private int displayedSkinParts;

	public void readData(PacketDataSerializer serializer) {
		this.locale = serializer.readString(7);
		this.viewDistance = serializer.readByte();
		this.chatFlag = EnumChatFlag.getById(serializer.readByte());
		this.chatColorsEnabled = serializer.readBoolean();
		this.displayedSkinParts = serializer.readUnsignedByte();
	}

	public void writeData(PacketDataSerializer serializer) {
		serializer.writeString(this.locale);
		serializer.writeByte(this.viewDistance);
		serializer.writeByte(this.chatFlag.getId());
		serializer.writeBoolean(this.chatColorsEnabled);
		serializer.writeByte(this.displayedSkinParts);
	}

	public void handlePacket(PlayInPacketListener listener) {
		listener.handle(this);
	}

	public String getLocale() {
		return this.locale;
	}

	public EnumChatFlag getChatFlag() {
		return this.chatFlag;
	}

	public boolean isChatColorsEnabled() {
		return this.chatColorsEnabled;
	}

	public int getDisplayedSkinParts() {
		return this.displayedSkinParts;
	}

}

package net.minecraft;

public class PacketPlayInEnchantItem implements Packet<PlayInPacketListener> {

	private int windowId;
	private int enchantment;

	public void readData(PacketDataSerializer serializer) {
		this.windowId = serializer.readByte();
		this.enchantment = serializer.readByte();
	}

	public void writeData(PacketDataSerializer serializer) {
		serializer.writeByte(this.windowId);
		serializer.writeByte(this.enchantment);
	}

	public void handlePacket(PlayInPacketListener listener) {
		listener.handle(this);
	}

	public int getWindowId() {
		return this.windowId;
	}

	public int getEnchantment() {
		return this.enchantment;
	}

}

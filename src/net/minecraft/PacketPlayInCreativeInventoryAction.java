package net.minecraft;

import java.io.IOException;

public class PacketPlayInCreativeInventoryAction implements Packet<PlayInPacketListener> {

	private int windowId;
	private ItemStack item;

	public void readData(PacketDataSerializer serializer) throws IOException {
		this.windowId = serializer.readShort();
		this.item = serializer.readItemStack();
	}

	public void writeData(PacketDataSerializer serializer) {
		serializer.writeShort(this.windowId);
		serializer.writeItemStack(this.item);
	}

	public void handlePacket(PlayInPacketListener listener) {
		listener.handle(this);
	}

	public int getWindowId() {
		return this.windowId;
	}

	public ItemStack getItem() {
		return this.item;
	}

}

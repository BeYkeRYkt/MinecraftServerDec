package net.minecraft;

import java.io.IOException;

public class PacketPlayInCreativeInventoryAction implements Packet<PlayInPacketListener> {

	private int slot;
	private ItemStack item;

	public void readData(PacketDataSerializer serializer) throws IOException {
		this.slot = serializer.readShort();
		this.item = serializer.readItemStack();
	}

	public void writeData(PacketDataSerializer serializer) {
		serializer.writeShort(this.slot);
		serializer.writeItemStack(this.item);
	}

	public void handlePacket(PlayInPacketListener listener) {
		listener.handle(this);
	}

	public int getSlot() {
		return this.slot;
	}

	public ItemStack getItem() {
		return this.item;
	}

}

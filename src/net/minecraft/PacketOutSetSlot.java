package net.minecraft;

import java.io.IOException;

public class PacketOutSetSlot implements Packet<PlayClientboundPacketListener> {

	private int windowId;
	private int slot;
	private ItemStack itemStack;

	public PacketOutSetSlot() {
	}

	public PacketOutSetSlot(int windowId, int slot, ItemStack itemStack) {
		this.windowId = windowId;
		this.slot = slot;
		this.itemStack = itemStack == null ? null : itemStack.getCopy();
	}

	public void readData(PacketDataSerializer serializer) throws IOException {
		this.windowId = serializer.readByte();
		this.slot = serializer.readShort();
		this.itemStack = serializer.readItemStack();
	}

	public void writeData(PacketDataSerializer serializer) {
		serializer.writeByte(this.windowId);
		serializer.writeShort(this.slot);
		serializer.writeItemStack(this.itemStack);
	}

	public void handlePacket(PlayClientboundPacketListener listener) {
		listener.a(this);
	}

}

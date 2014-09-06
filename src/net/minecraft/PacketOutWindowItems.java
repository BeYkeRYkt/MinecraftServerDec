package net.minecraft;

import java.io.IOException;
import java.util.List;

public class PacketOutWindowItems implements Packet<PlayClientboundPacketListener> {

	private int windowId;
	private ItemStack[] items;

	public PacketOutWindowItems() {
	}

	public PacketOutWindowItems(int windowId, List<ItemStack> items) {
		this.windowId = windowId;
		this.items = new ItemStack[items.size()];

		for (int i = 0; i < this.items.length; ++i) {
			ItemStack item = items.get(i);
			this.items[i] = item == null ? null : item.getCopy();
		}

	}

	public void readData(PacketDataSerializer serializer) throws IOException {
		this.windowId = serializer.readUnsignedByte();
		short count = serializer.readShort();
		this.items = new ItemStack[count];

		for (int var3 = 0; var3 < count; ++var3) {
			this.items[var3] = serializer.readItemStack();
		}

	}

	public void writeData(PacketDataSerializer serializer) {
		serializer.writeByte(this.windowId);
		serializer.writeShort(this.items.length);
		for (ItemStack item : items) {
			serializer.writeItemStack(item);
		}
	}

	public void handlePacket(PlayClientboundPacketListener listener) {
		listener.handle(this);
	}

}

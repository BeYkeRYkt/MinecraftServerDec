package net.minecraft;

import java.io.IOException;

public class PacketEntityEquipment implements Packet<PlayPacketListener> {

	private int entityId;
	private int slot;
	private ItemStack itemStack;

	public PacketEntityEquipment() {
	}

	public PacketEntityEquipment(int entityId, int slot, ItemStack itemStack) {
		this.entityId = entityId;
		this.slot = slot;
		this.itemStack = itemStack == null ? null : itemStack.getCopy();
	}

	public void readData(PacketDataSerializer serializer) throws IOException {
		this.entityId = serializer.readVarInt();
		this.slot = serializer.readShort();
		this.itemStack = serializer.readItemStack();
	}

	public void writeData(PacketDataSerializer serializer) {
		serializer.writeVarInt(this.entityId);
		serializer.writeShort(this.slot);
		serializer.writeItemStack(this.itemStack);
	}

	public void handlePacket(PlayPacketListener listener) {
		listener.handle(this);
	}

}

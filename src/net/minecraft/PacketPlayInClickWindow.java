package net.minecraft;

import java.io.IOException;

public class PacketPlayInClickWindow implements Packet<PlayInPacketListener> {

	private int windowId;
	private int slot;
	private int button;
	private short action;
	private ItemStack item;
	private int mode;

	public void readData(PacketDataSerializer serializer) throws IOException {
		this.windowId = serializer.readByte();
		this.slot = serializer.readShort();
		this.button = serializer.readByte();
		this.action = serializer.readShort();
		this.mode = serializer.readByte();
		this.item = serializer.readItemStack();
	}

	public void writeData(PacketDataSerializer serializer) {
		serializer.writeByte(this.windowId);
		serializer.writeShort(this.slot);
		serializer.writeByte(this.button);
		serializer.writeShort(this.action);
		serializer.writeByte(this.mode);
		serializer.writeItemStack(this.item);
	}

	public void handlePacket(PlayInPacketListener listener) {
		listener.handle(this);
	}

	public int getWindowId() {
		return this.windowId;
	}

	public int getSlot() {
		return this.slot;
	}

	public int getButton() {
		return this.button;
	}

	public short getAction() {
		return this.action;
	}

	public ItemStack getItem() {
		return this.item;
	}

	public int getMode() {
		return this.mode;
	}

}

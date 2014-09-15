package net.minecraft;

import java.io.IOException;

public class PacketPlayInBlockPlace implements Packet<PlayInPacketListener> {

	private static final Position updateItemInHandMarkerPosition = new Position(-1, -1, -1);

	private Position position;
	private int direction;
	private ItemStack heldItem;
	private float cursorX;
	private float cursorY;
	private float cursorZ;

	public PacketPlayInBlockPlace() {
	}

	public PacketPlayInBlockPlace(ItemStack item) {
		this(updateItemInHandMarkerPosition, 255, item, 0.0F, 0.0F, 0.0F);
	}

	public PacketPlayInBlockPlace(Position position, int direction, ItemStack item, float cursorX, float cursorY, float cursorZ) {
		this.position = position;
		this.direction = direction;
		this.heldItem = item != null ? item.getCopy() : null;
		this.cursorX = cursorX;
		this.cursorY = cursorY;
		this.cursorZ = cursorZ;
	}

	public void readData(PacketDataSerializer serializer) throws IOException {
		this.position = serializer.readPosition();
		this.direction = serializer.readUnsignedByte();
		this.heldItem = serializer.readItemStack();
		this.cursorX = (float) serializer.readUnsignedByte() / 16.0F;
		this.cursorY = (float) serializer.readUnsignedByte() / 16.0F;
		this.cursorZ = (float) serializer.readUnsignedByte() / 16.0F;
	}

	public void writeData(PacketDataSerializer serializer) {
		serializer.writePosition(this.position);
		serializer.writeByte(this.direction);
		serializer.writeItemStack(this.heldItem);
		serializer.writeByte((int) (this.cursorX * 16.0F));
		serializer.writeByte((int) (this.cursorY * 16.0F));
		serializer.writeByte((int) (this.cursorZ * 16.0F));
	}

	public void handlePacket(PlayInPacketListener listener) {
		listener.handle(this);
	}

	public Position getPosition() {
		return this.position;
	}

	public int getDirection() {
		return this.direction;
	}

	public ItemStack getItem() {
		return this.heldItem;
	}

	public float getCursorX() {
		return this.cursorX;
	}

	public float getCursorY() {
		return this.cursorY;
	}

	public float getCursorZ() {
		return this.cursorZ;
	}

}

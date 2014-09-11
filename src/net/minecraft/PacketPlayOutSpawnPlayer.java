package net.minecraft;

import java.io.IOException;
import java.util.UUID;

public class PacketPlayOutSpawnPlayer implements Packet<PlayOutPacketListener> {

	private int entityId;
	private UUID uuid;
	private int x;
	private int y;
	private int z;
	private byte yaw;
	private byte pitch;
	private int holdingItemId;
	private DataWatcher dataWatcher;

	public PacketPlayOutSpawnPlayer() {
	}

	public PacketPlayOutSpawnPlayer(EntityHuman human) {
		this.entityId = human.getId();
		this.uuid = human.getGameProfile().getId();
		this.x = MathHelper.toFixedPointInt(human.locationX * 32.0D);
		this.y = MathHelper.toFixedPointInt(human.locationY * 32.0D);
		this.z = MathHelper.toFixedPointInt(human.locationZ * 32.0D);
		this.yaw = (byte) ((int) (human.yaw * 256.0F / 360.0F));
		this.pitch = (byte) ((int) (human.pitch * 256.0F / 360.0F));
		ItemStack itemStack = human.playerInventory.getItemInHand();
		this.holdingItemId = itemStack == null ? 0 : Item.getId(itemStack.getItem());
		this.dataWatcher = human.getDataWatcher();
	}

	public void readData(PacketDataSerializer serializer) throws IOException {
		this.entityId = serializer.readVarInt();
		this.uuid = serializer.readUUID();
		this.x = serializer.readInt();
		this.y = serializer.readInt();
		this.z = serializer.readInt();
		this.yaw = serializer.readByte();
		this.pitch = serializer.readByte();
		this.holdingItemId = serializer.readShort();
		DataWatcher.readData(serializer);
	}

	public void writeData(PacketDataSerializer serializer) {
		serializer.writeVarInt(this.entityId);
		serializer.writeUUID(this.uuid);
		serializer.writeInt(this.x);
		serializer.writeInt(this.y);
		serializer.writeInt(this.z);
		serializer.writeByte(this.yaw);
		serializer.writeByte(this.pitch);
		serializer.writeShort(this.holdingItemId);
		this.dataWatcher.writeData(serializer);
	}

	public void handlePacket(PlayOutPacketListener listener) {
		listener.handle(this);
	}

}

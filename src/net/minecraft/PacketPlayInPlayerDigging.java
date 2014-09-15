package net.minecraft;

public class PacketPlayInPlayerDigging implements Packet<PlayInPacketListener> {

	private Position position;
	private BlockFace face;
	private PlayerDiggingAction action;

	public void readData(PacketDataSerializer serializer) {
		this.action = (PlayerDiggingAction) serializer.readEnum(PlayerDiggingAction.class);
		this.position = serializer.readPosition();
		this.face = BlockFace.getById(serializer.readUnsignedByte());
	}

	public void writeData(PacketDataSerializer serializer) {
		serializer.writeEnum(this.action);
		serializer.writePosition(this.position);
		serializer.writeByte(this.face.getId());
	}

	public void handlePacket(PlayInPacketListener listener) {
		listener.handle(this);
	}

	public Position getPosition() {
		return this.position;
	}

	public BlockFace getFace() {
		return this.face;
	}

	public PlayerDiggingAction getAction() {
		return this.action;
	}

	public static enum PlayerDiggingAction {
		START_DESTROY_BLOCK, ABORT_DESTROY_BLOCK, STOP_DESTROY_BLOCK, DROP_ALL_ITEMS, DROP_ITEM, RELEASE_USE_ITEM;
	}

}

package net.minecraft;

public class PacketPlayInEntityAction implements Packet<PlayInPacketListener> {

	private int entityId;
	private EntityActionAction action;
	private int horseJumpBoost;

	public void readData(PacketDataSerializer serializer) {
		this.entityId = serializer.readVarInt();
		this.action = (EntityActionAction) serializer.readEnum(EntityActionAction.class);
		this.horseJumpBoost = serializer.readVarInt();
	}

	public void writeData(PacketDataSerializer serializer) {
		serializer.writeVarInt(this.entityId);
		serializer.writeEnum(this.action);
		serializer.writeVarInt(this.horseJumpBoost);
	}

	public void handlePacket(PlayInPacketListener listener) {
		listener.handle(this);
	}

	public EntityActionAction getAction() {
		return this.action;
	}

	public int getHorseJumpBoost() {
		return this.horseJumpBoost;
	}

	public static enum EntityActionAction {
		START_SNEAKING, STOP_SNEAKING, STOP_SLEEPING, START_SPRINTING, STOP_SPRINTING, RIDING_JUMP, OPEN_INVENTORY;
	}

}

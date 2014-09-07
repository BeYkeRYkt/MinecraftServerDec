package net.minecraft;

public class PacketOutWorldBorder implements Packet<PlayClientboundPacketListener> {

	private WorldBorderAction action;
	private int teleportBoundary;
	private double x;
	private double z;
	private double radius;
	private double oldRadius;
	private long speed;
	private int warningTime;
	private int warningBlocks;

	public PacketOutWorldBorder() {
	}

	public PacketOutWorldBorder(WorldBorder worldborder, WorldBorderAction action) {
		this.action = action;
		this.x = worldborder.getX();
		this.z = worldborder.getZ();
		this.oldRadius = worldborder.getOldRadius();
		this.radius = worldborder.getCurrentRadius();
		this.speed = worldborder.getSpeed();
		this.teleportBoundary = worldborder.getPortalTeleportBoundary();
		this.warningBlocks = worldborder.getWarningBlocks();
		this.warningTime = worldborder.getWarningTime();
	}

	public void readData(PacketDataSerializer serializer) {
		this.action = (WorldBorderAction) serializer.readEnum(WorldBorderAction.class);
		switch (action) {
			case SET_SIZE: {
				this.radius = serializer.readDouble();
				break;
			}
			case LERP_SIZE: {
				this.oldRadius = serializer.readDouble();
				this.radius = serializer.readDouble();
				this.speed = serializer.readVarLong();
				break;
			}
			case SET_CENTER: {
				this.x = serializer.readDouble();
				this.z = serializer.readDouble();
				break;
			}
			case SET_WARNING_BLOCKS: {
				this.warningBlocks = serializer.readVarInt();
				break;
			}
			case SET_WARNING_TIME: {
				this.warningTime = serializer.readVarInt();
				break;
			}
			case INITIALIZE: {
				this.x = serializer.readDouble();
				this.z = serializer.readDouble();
				this.oldRadius = serializer.readDouble();
				this.radius = serializer.readDouble();
				this.speed = serializer.readVarLong();
				this.teleportBoundary = serializer.readVarInt();
				this.warningBlocks = serializer.readVarInt();
				this.warningTime = serializer.readVarInt();
			}
		}
	}

	public void writeData(PacketDataSerializer serializer) {
		serializer.writeEnum(this.action);
		switch (action) {
			case SET_SIZE: {
				serializer.writeDouble(this.radius);
				break;
			}
			case LERP_SIZE: {
				serializer.writeDouble(this.oldRadius);
				serializer.writeDouble(this.radius);
				serializer.writeVarLong(this.speed);
				break;
			}
			case SET_CENTER: {
				serializer.writeDouble(this.x);
				serializer.writeDouble(this.z);
				break;
			}
			case SET_WARNING_BLOCKS: {
				serializer.writeVarInt(this.warningBlocks);
				break;
			}
			case SET_WARNING_TIME: {
				serializer.writeVarInt(this.warningTime);
				break;
			}
			case INITIALIZE: {
				serializer.writeDouble(this.x);
				serializer.writeDouble(this.z);
				serializer.writeDouble(this.oldRadius);
				serializer.writeDouble(this.radius);
				serializer.writeVarLong(this.speed);
				serializer.writeVarInt(this.teleportBoundary);
				serializer.writeVarInt(this.warningBlocks);
				serializer.writeVarInt(this.warningTime);
			}
		}
	}

	public void handlePacket(PlayClientboundPacketListener listener) {
		listener.handle(this);
	}

	public enum WorldBorderAction {
		SET_SIZE, LERP_SIZE, SET_CENTER, SET_WARNING_BLOCKS, SET_WARNING_TIME, INITIALIZE;
	}

}

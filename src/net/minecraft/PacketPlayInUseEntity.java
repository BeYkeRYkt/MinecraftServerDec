package net.minecraft;

public class PacketPlayInUseEntity implements Packet<PlayInPacketListener> {

	private int entityId;
	private UseEntityAction action;
	private Vec3D vec;

	public void readData(PacketDataSerializer serializer) {
		this.entityId = serializer.readVarInt();
		this.action = (UseEntityAction) serializer.readEnum(UseEntityAction.class);
		if (this.action == UseEntityAction.INTERACT_AT) {
			this.vec = new Vec3D((double) serializer.readFloat(), (double) serializer.readFloat(), (double) serializer.readFloat());
		}

	}

	public void writeData(PacketDataSerializer serializer) {
		serializer.writeVarInt(this.entityId);
		serializer.writeEnum(this.action);
		if (this.action == UseEntityAction.INTERACT_AT) {
			serializer.writeFloat((float) this.vec.x);
			serializer.writeFloat((float) this.vec.y);
			serializer.writeFloat((float) this.vec.z);
		}

	}

	public void handlePacket(PlayInPacketListener listener) {
		listener.handle(this);
	}

	public Entity getEntity(World world) {
		return world.getEntity(this.entityId);
	}

	public UseEntityAction getAction() {
		return this.action;
	}

	public Vec3D getInteractedAt() {
		return this.vec;
	}

	public static enum UseEntityAction {
		INTERACT, ATTACK, INTERACT_AT;
	}

}

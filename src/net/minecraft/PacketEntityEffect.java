package net.minecraft;

public class PacketEntityEffect implements Packet<PlayPacketListener> {

	private int entityId;
	private byte effectId;
	private byte amplifier;
	private int duration;
	private byte showParticles;

	public PacketEntityEffect() {
	}

	public PacketEntityEffect(int entitId, MobEffect effect) {
		this.entityId = entitId;
		this.effectId = (byte) (effect.getId() & 255);
		this.amplifier = (byte) (effect.getAmplifier() & 255);
		if (effect.getDuration() > 32767) {
			this.duration = 32767;
		} else {
			this.duration = effect.getDuration();
		}

		this.showParticles = (byte) (effect.isParticlesShown() ? 1 : 0);
	}

	public void readData(PacketDataSerializer serializer) {
		this.entityId = serializer.readVarInt();
		this.effectId = serializer.readByte();
		this.amplifier = serializer.readByte();
		this.duration = serializer.readVarInt();
		this.showParticles = serializer.readByte();
	}

	public void writeData(PacketDataSerializer serializer) {
		serializer.writeVarInt(this.entityId);
		serializer.writeByte(this.effectId);
		serializer.writeByte(this.amplifier);
		serializer.writeVarInt(this.duration);
		serializer.writeByte(this.showParticles);
	}

	public void handlePacket(PlayPacketListener listener) {
		listener.handle(this);
	}

}

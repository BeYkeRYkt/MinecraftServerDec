package net.minecraft;

public class PacketOutEffect implements Packet<PlayClientboundPacketListener> {

	private int effectId;
	private Position position;
	private int data;
	private boolean disableVolume;

	public PacketOutEffect() {
	}

	public PacketOutEffect(int effectId, Position var2, int data, boolean disableVolume) {
		this.effectId = effectId;
		this.position = var2;
		this.data = data;
		this.disableVolume = disableVolume;
	}

	public void readData(PacketDataSerializer serializer) {
		this.effectId = serializer.readInt();
		this.position = serializer.readPosition();
		this.data = serializer.readInt();
		this.disableVolume = serializer.readBoolean();
	}

	public void writeData(PacketDataSerializer serializer) {
		serializer.writeInt(this.effectId);
		serializer.writePosition(this.position);
		serializer.writeInt(this.data);
		serializer.writeBoolean(this.disableVolume);
	}

	public void handlePacket(PlayClientboundPacketListener listener) {
		listener.handle(this);
	}

}

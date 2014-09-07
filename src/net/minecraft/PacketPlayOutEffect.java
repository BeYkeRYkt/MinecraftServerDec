package net.minecraft;

public class PacketPlayOutEffect implements Packet<PlayOutPacketListener> {

	private int effectId;
	private Position position;
	private int data;
	private boolean disableVolume;

	public PacketPlayOutEffect() {
	}

	public PacketPlayOutEffect(int effectId, Position var2, int data, boolean disableVolume) {
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

	public void handlePacket(PlayOutPacketListener listener) {
		listener.handle(this);
	}

}

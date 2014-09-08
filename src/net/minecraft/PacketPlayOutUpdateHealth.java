package net.minecraft;

public class PacketPlayOutUpdateHealth implements Packet<PlayOutPacketListener> {

	private float health;
	private int food;
	private float saturation;

	public PacketPlayOutUpdateHealth() {
	}

	public PacketPlayOutUpdateHealth(float health, int food, float saturation) {
		this.health = health;
		this.food = food;
		this.saturation = saturation;
	}

	public void readData(PacketDataSerializer serializer) {
		this.health = serializer.readFloat();
		this.food = serializer.readVarInt();
		this.saturation = serializer.readFloat();
	}

	public void writeData(PacketDataSerializer serializer) {
		serializer.writeFloat(this.health);
		serializer.writeVarInt(this.food);
		serializer.writeFloat(this.saturation);
	}

	public void handlePacket(PlayOutPacketListener listener) {
		listener.handle(this);
	}

}

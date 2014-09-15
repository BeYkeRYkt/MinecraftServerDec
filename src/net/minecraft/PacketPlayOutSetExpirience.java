package net.minecraft;

public class PacketPlayOutSetExpirience implements Packet<PlayOutPacketListener> {

	private float exp;
	private int level;
	private int totalExp;

	public PacketPlayOutSetExpirience() {
	}

	public PacketPlayOutSetExpirience(float exp, int level, int totalExp) {
		this.exp = exp;
		this.level = level;
		this.totalExp = totalExp;
	}

	public void readData(PacketDataSerializer serializer) {
		this.exp = serializer.readFloat();
		this.totalExp = serializer.readVarInt();
		this.level = serializer.readVarInt();
	}

	public void writeData(PacketDataSerializer serializer) {
		serializer.writeFloat(this.exp);
		serializer.writeVarInt(this.totalExp);
		serializer.writeVarInt(this.level);
	}

	public void handlePacket(PlayOutPacketListener listener) {
		listener.handle(this);
	}

}

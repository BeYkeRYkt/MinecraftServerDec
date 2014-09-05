package net.minecraft;

public class PacketSetExpirience implements Packet<PlayPacketListener> {

	private float exp;
	private int level;
	private int totalExp;

	public PacketSetExpirience() {
	}

	public PacketSetExpirience(float exp, int level, int totalExp) {
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

	public void handlePacket(PlayPacketListener listener) {
		listener.handle(this);
	}

}

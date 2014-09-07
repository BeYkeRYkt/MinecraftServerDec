package net.minecraft;

public class PacketOutDisplayScoreboard implements Packet<PlayClientboundPacketListener> {

	private int scoreboardPosition;
	private String name;

	public PacketOutDisplayScoreboard() {
	}

	public PacketOutDisplayScoreboard(int scoreboardPosition, ScoreboardObjective objective) {
		this.scoreboardPosition = scoreboardPosition;
		if (objective == null) {
			this.name = "";
		} else {
			this.name = objective.getName();
		}

	}

	public void readData(PacketDataSerializer serializer) {
		this.scoreboardPosition = serializer.readByte();
		this.name = serializer.readString(16);
	}

	public void writeData(PacketDataSerializer serializer) {
		serializer.writeByte(this.scoreboardPosition);
		serializer.writeString(this.name);
	}

	public void handlePacket(PlayClientboundPacketListener listener) {
		listener.a(this);
	}

}

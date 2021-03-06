package net.minecraft;

public class PacketPlayOutDisplayScoreboard implements Packet<PlayOutPacketListener> {

	private int scoreboardPosition;
	private String name;

	public PacketPlayOutDisplayScoreboard() {
	}

	public PacketPlayOutDisplayScoreboard(int scoreboardPosition, ScoreboardObjective objective) {
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

	public void handlePacket(PlayOutPacketListener listener) {
		listener.handle(this);
	}

}

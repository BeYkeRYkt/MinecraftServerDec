package net.minecraft;

public class PacketOutScoreboardObjective implements Packet<PlayClientboundPacketListener> {

	private String name;
	private String displayName;
	private ScoreboardObjectiveType objectiveType;
	private int action;

	public PacketOutScoreboardObjective() {
	}

	public PacketOutScoreboardObjective(ScoreboardObjective objective, int action) {
		this.name = objective.getName();
		this.displayName = objective.getDisplayName();
		this.objectiveType = objective.getCriteria().getType();
		this.action = action;
	}

	public void readData(PacketDataSerializer serializer) {
		this.name = serializer.readString(16);
		this.action = serializer.readByte();
		if (this.action == 0 || this.action == 2) {
			this.displayName = serializer.readString(32);
			this.objectiveType = ScoreboardObjectiveType.getByName(serializer.readString(16));
		}

	}

	public void writeData(PacketDataSerializer var1) {
		var1.writeString(this.name);
		var1.writeByte(this.action);
		if (this.action == 0 || this.action == 2) {
			var1.writeString(this.displayName);
			var1.writeString(this.objectiveType.getName());
		}
	}

	public void handlePacket(PlayClientboundPacketListener listener) {
		listener.handle(this);
	}

}

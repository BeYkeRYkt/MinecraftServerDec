package net.minecraft;

public class PacketPlayOutUpdateScore implements Packet<PlayOutPacketListener> {

	private String playerName = "";
	private String name = "";
	private int value;
	private Action action;

	public PacketPlayOutUpdateScore() {
	}

	public PacketPlayOutUpdateScore(ScoreboardScore score) {
		this.playerName = score.getPlayerName();
		this.name = score.getObjective().getName();
		this.value = score.getScore();
		this.action = Action.CHANGE;
	}

	public PacketPlayOutUpdateScore(String playerName) {
		this.playerName = playerName;
		this.name = "";
		this.value = 0;
		this.action = Action.REMOVE;
	}

	public PacketPlayOutUpdateScore(String playerName, ScoreboardObjective objective) {
		this.playerName = playerName;
		this.name = objective.getName();
		this.value = 0;
		this.action = Action.REMOVE;
	}

	public void readData(PacketDataSerializer serializer) {
		this.playerName = serializer.readString(40);
		this.action = (Action) serializer.readEnum(Action.class);
		this.name = serializer.readString(16);
		if (this.action != Action.REMOVE) {
			this.value = serializer.readVarInt();
		}

	}

	public void writeData(PacketDataSerializer serializer) {
		serializer.writeString(this.playerName);
		serializer.writeEnum(this.action);
		serializer.writeString(this.name);
		if (this.action != Action.REMOVE) {
			serializer.writeVarInt(this.value);
		}
	}

	public void handlePacket(PlayOutPacketListener listener) {
		listener.handle(this);
	}

	private static enum Action {
		CHANGE, REMOVE;
	}

}

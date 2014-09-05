package net.minecraft;

public class PacketRespawn implements Packet<PlayPacketListener> {

	private int dimensionId;
	private Difficulty difficulty;
	private GameMode gameMode;
	private LevelType levelType;

	public PacketRespawn() {
	}

	public PacketRespawn(int dimensionId, Difficulty difficulty, LevelType levelType, GameMode gameMode) {
		this.dimensionId = dimensionId;
		this.difficulty = difficulty;
		this.gameMode = gameMode;
		this.levelType = levelType;
	}

	public void readData(PacketDataSerializer serializer) {
		this.dimensionId = serializer.readInt();
		this.difficulty = Difficulty.clampAndGetById(serializer.readUnsignedByte());
		this.gameMode = GameMode.byId(serializer.readUnsignedByte());
		this.levelType = LevelType.byName(serializer.readString(16));
		if (this.levelType == null) {
			this.levelType = LevelType.DEFAULT;
		}
	}

	public void writeData(PacketDataSerializer var1) {
		var1.writeInt(this.dimensionId);
		var1.writeByte(this.difficulty.getId());
		var1.writeByte(this.gameMode.getId());
		var1.writeString(this.levelType.a());
	}

	public void handlePacket(PlayPacketListener listener) {
		listener.handle(this);
	}

}

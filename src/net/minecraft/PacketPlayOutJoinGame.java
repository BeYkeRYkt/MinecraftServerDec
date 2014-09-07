package net.minecraft;

public class PacketPlayOutJoinGame implements Packet<PlayOutPacketListener> {

	private int entityId;
	private boolean isHardcore;
	private GameMode playerGameMode;
	private int dimensionId;
	private Difficulty difficulty;
	private int maxPlayers;
	private LevelType levelType;
	private boolean debugInfo;

	public PacketPlayOutJoinGame() {
	}

	public PacketPlayOutJoinGame(int entityId, GameMode playerGameMode, boolean isHardcore, int dimensionId, Difficulty difficulty, int maxPlayers, LevelType levelType, boolean debugInfo) {
		this.entityId = entityId;
		this.dimensionId = dimensionId;
		this.difficulty = difficulty;
		this.playerGameMode = playerGameMode;
		this.maxPlayers = maxPlayers;
		this.isHardcore = isHardcore;
		this.levelType = levelType;
		this.debugInfo = debugInfo;
	}

	public void readData(PacketDataSerializer serializer) {
		this.entityId = serializer.readInt();
		short playerGameModeId = serializer.readUnsignedByte();
		this.isHardcore = (playerGameModeId & 8) == 8;
		this.playerGameMode = GameMode.getById(playerGameModeId & -9);
		this.dimensionId = serializer.readByte();
		this.difficulty = Difficulty.clampAndGetById(serializer.readUnsignedByte());
		this.maxPlayers = serializer.readUnsignedByte();
		this.levelType = LevelType.byName(serializer.readString(16));
		if (this.levelType == null) {
			this.levelType = LevelType.DEFAULT;
		}

		this.debugInfo = serializer.readBoolean();
	}

	public void writeData(PacketDataSerializer serializer) {
		serializer.writeInt(this.entityId);
		int playerGameModeId = this.playerGameMode.getId();
		if (this.isHardcore) {
			playerGameModeId |= 8;
		}

		serializer.writeByte(playerGameModeId);
		serializer.writeByte(this.dimensionId);
		serializer.writeByte(this.difficulty.getId());
		serializer.writeByte(this.maxPlayers);
		serializer.writeString(this.levelType.a());
		serializer.writeBoolean(this.debugInfo);
	}

	public void handlePacket(PlayOutPacketListener listener) {
		listener.handle(this);
	}

}

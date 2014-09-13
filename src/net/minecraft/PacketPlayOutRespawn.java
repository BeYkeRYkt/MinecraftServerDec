package net.minecraft;

public class PacketPlayOutRespawn implements Packet<PlayOutPacketListener> {

	private int dimensionId;
	private Difficulty difficulty;
	private EnumGameMode gameMode;
	private LevelType levelType;

	public PacketPlayOutRespawn() {
	}

	public PacketPlayOutRespawn(int dimensionId, Difficulty difficulty, LevelType levelType, EnumGameMode gameMode) {
		this.dimensionId = dimensionId;
		this.difficulty = difficulty;
		this.gameMode = gameMode;
		this.levelType = levelType;
	}

	public void readData(PacketDataSerializer serializer) {
		this.dimensionId = serializer.readInt();
		this.difficulty = Difficulty.clampAndGetById(serializer.readUnsignedByte());
		this.gameMode = EnumGameMode.getById(serializer.readUnsignedByte());
		this.levelType = LevelType.getByName(serializer.readString(16));
		if (this.levelType == null) {
			this.levelType = LevelType.DEFAULT;
		}
	}

	public void writeData(PacketDataSerializer var1) {
		var1.writeInt(this.dimensionId);
		var1.writeByte(this.difficulty.getId());
		var1.writeByte(this.gameMode.getId());
		var1.writeString(this.levelType.getName());
	}

	public void handlePacket(PlayOutPacketListener listener) {
		listener.handle(this);
	}

}

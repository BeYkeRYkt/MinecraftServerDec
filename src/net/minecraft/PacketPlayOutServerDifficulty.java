package net.minecraft;

public class PacketPlayOutServerDifficulty implements Packet<PlayOutPacketListener> {

	private Difficulty difficulty;

	public PacketPlayOutServerDifficulty() {
	}

	public PacketPlayOutServerDifficulty(Difficulty difficulty, boolean unusedBoolean) {
		this.difficulty = difficulty;
	}

	public void readData(PacketDataSerializer serializer) {
		this.difficulty = Difficulty.clampAndGetById(serializer.readUnsignedByte());
	}

	public void writeData(PacketDataSerializer serializer) {
		serializer.writeByte(this.difficulty.getId());
	}

	public void handlePacket(PlayOutPacketListener listener) {
		listener.handle(this);
	}

}

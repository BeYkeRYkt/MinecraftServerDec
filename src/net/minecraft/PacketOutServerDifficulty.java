package net.minecraft;

public class PacketOutServerDifficulty implements Packet<PlayClientboundPacketListener> {

	private Difficulty difficulty;

	public PacketOutServerDifficulty() {
	}

	public PacketOutServerDifficulty(Difficulty difficulty, boolean unusedBoolean) {
		this.difficulty = difficulty;
	}

	public void readData(PacketDataSerializer serializer) {
		this.difficulty = Difficulty.clampAndGetById(serializer.readUnsignedByte());
	}

	public void writeData(PacketDataSerializer serializer) {
		serializer.writeByte(this.difficulty.getId());
	}

	public void handlePacket(PlayClientboundPacketListener listener) {
		listener.handle(this);
	}

}

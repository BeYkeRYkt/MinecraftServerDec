package net.minecraft;

public class ix implements Packet<PlayClientboundPacketListener> {

	private Difficulty a;
	private boolean b;

	public ix() {
	}

	public ix(Difficulty var1, boolean var2) {
		this.a = var1;
		this.b = var2;
	}

	public void handlePacket(PlayClientboundPacketListener var1) {
		var1.a(this);
	}

	public void readData(PacketDataSerializer var1) {
		this.a = Difficulty.clampAndGetById(var1.readUnsignedByte());
	}

	public void writeData(PacketDataSerializer var1) {
		var1.writeByte(this.a.getId());
	}
}

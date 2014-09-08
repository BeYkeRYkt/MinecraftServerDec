package net.minecraft;

public class mu implements Packet<PlayInPacketListener> {

	private Position a;
	private IChatBaseComponent[] b;

	public void readData(PacketDataSerializer var1) {
		this.a = var1.readPosition();
		this.b = new IChatBaseComponent[4];

		for (int var2 = 0; var2 < 4; ++var2) {
			this.b[var2] = var1.readJSONComponent();
		}

	}

	public void writeData(PacketDataSerializer var1) {
		var1.writePosition(this.a);

		for (int var2 = 0; var2 < 4; ++var2) {
			var1.writeJSONComponent(this.b[var2]);
		}

	}

	public void handlePacket(PlayInPacketListener var1) {
		var1.a(this);
	}

	public Position a() {
		return this.a;
	}

	public IChatBaseComponent[] b() {
		return this.b;
	}
}

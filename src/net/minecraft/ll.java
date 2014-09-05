package net.minecraft;

public class ll implements Packet<PlayPacketListener> {

	private World a;
	private Position b;
	private IJSONComponent[] c;

	public ll() {
	}

	public ll(World var1, Position var2, IJSONComponent[] var3) {
		this.a = var1;
		this.b = var2;
		this.c = new IJSONComponent[] { var3[0], var3[1], var3[2], var3[3] };
	}

	public void readData(PacketDataSerializer var1) {
		this.b = var1.readPosition();
		this.c = new IJSONComponent[4];

		for (int var2 = 0; var2 < 4; ++var2) {
			this.c[var2] = var1.readJSONComponent();
		}

	}

	public void writeData(PacketDataSerializer var1) {
		var1.writePosition(this.b);

		for (int var2 = 0; var2 < 4; ++var2) {
			var1.writeJSONComponent(this.c[var2]);
		}

	}

	public void handlePacket(PlayPacketListener var1) {
		var1.a(this);
	}
}

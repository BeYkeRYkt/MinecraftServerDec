package net.minecraft;

public class lm implements Packet<PlayPacketListener> {

	private IJSONComponent a;
	private IJSONComponent b;

	public lm() {
	}

	public lm(IJSONComponent var1) {
		this.a = var1;
	}

	public void readData(PacketDataSerializer var1) {
		this.a = var1.readJSONComponent();
		this.b = var1.readJSONComponent();
	}

	public void writeData(PacketDataSerializer var1) {
		var1.writeJSONComponent(this.a);
		var1.writeJSONComponent(this.b);
	}

	public void handlePacket(PlayPacketListener var1) {
		var1.a(this);
	}
}

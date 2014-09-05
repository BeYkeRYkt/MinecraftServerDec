package net.minecraft;

public class ng implements Packet<nc> {

	private IJSONComponent a;

	public ng() {
	}

	public ng(IJSONComponent var1) {
		this.a = var1;
	}

	public void readData(PacketDataSerializer var1) {
		this.a = var1.readJSONComponent();
	}

	public void writeData(PacketDataSerializer var1) {
		var1.writeJSONComponent(this.a);
	}

	public void handlePacket(nc var1) {
		var1.a(this);
	}
}

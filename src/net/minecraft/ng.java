package net.minecraft;

public class ng implements Packet<nc> {

	private IChatBaseComponent a;

	public ng() {
	}

	public ng(IChatBaseComponent var1) {
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

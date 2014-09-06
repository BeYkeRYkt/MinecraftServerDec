package net.minecraft;

public class jj implements Packet<PlayClientboundPacketListener> {

	private IJSONComponent a;

	public jj() {
	}

	public jj(IJSONComponent var1) {
		this.a = var1;
	}

	public void readData(PacketDataSerializer var1) {
		this.a = var1.readJSONComponent();
	}

	public void writeData(PacketDataSerializer var1) {
		var1.writeJSONComponent(this.a);
	}

	public void handlePacket(PlayClientboundPacketListener var1) {
		var1.a(this);
	}
}

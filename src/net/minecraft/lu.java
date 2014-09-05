package net.minecraft;

public class lu implements Packet<ls> {

	private String a;

	public lu() {
	}

	public lu(String var1) {
		if (var1.length() > 100) {
			var1 = var1.substring(0, 100);
		}

		this.a = var1;
	}

	public void readData(PacketDataSerializer var1) {
		this.a = var1.readString(100);
	}

	public void writeData(PacketDataSerializer var1) {
		var1.writeString(this.a);
	}

	public void handlePacket(ls var1) {
		var1.a(this);
	}

	public String a() {
		return this.a;
	}
}

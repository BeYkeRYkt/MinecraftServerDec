package net.minecraft;

public class ko implements Packet<PlayClientboundPacketListener> {

	private String a;
	private String b;

	public ko() {
	}

	public ko(String var1, String var2) {
		this.a = var1;
		this.b = var2;
		if (var2.length() > 40) {
			throw new IllegalArgumentException("Hash is too long (max 40, was " + var2.length() + ")");
		}
	}

	public void readData(PacketDataSerializer var1) {
		this.a = var1.readString(32767);
		this.b = var1.readString(40);
	}

	public void writeData(PacketDataSerializer var1) {
		var1.writeString(this.a);
		var1.writeString(this.b);
	}

	public void handlePacket(PlayClientboundPacketListener var1) {
		var1.a(this);
	}
}

package net.minecraft;

public class lf implements Packet<PlayClientboundPacketListener> {

	private String a = "";
	private String b = "";
	private int c;
	private lg d;

	public lf() {
	}

	public lf(bsa var1) {
		this.a = var1.e();
		this.b = var1.d().b();
		this.c = var1.c();
		this.d = lg.a;
	}

	public lf(String var1) {
		this.a = var1;
		this.b = "";
		this.c = 0;
		this.d = lg.b;
	}

	public lf(String var1, bry var2) {
		this.a = var1;
		this.b = var2.b();
		this.c = 0;
		this.d = lg.b;
	}

	public void readData(PacketDataSerializer var1) {
		this.a = var1.readString(40);
		this.d = (lg) var1.a(lg.class);
		this.b = var1.readString(16);
		if (this.d != lg.b) {
			this.c = var1.readVarInt();
		}

	}

	public void writeData(PacketDataSerializer var1) {
		var1.writeString(this.a);
		var1.writeEnum((Enum) this.d);
		var1.writeString(this.b);
		if (this.d != lg.b) {
			var1.writeVarInt(this.c);
		}

	}

	public void handlePacket(PlayClientboundPacketListener var1) {
		var1.a(this);
	}
}

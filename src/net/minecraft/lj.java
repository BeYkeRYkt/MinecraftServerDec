package net.minecraft;

public class lj implements Packet<PlayClientboundPacketListener> {

	private lk a;
	private IChatBaseComponent b;
	private int c;
	private int d;
	private int e;

	public lj() {
	}

	public lj(lk var1, IChatBaseComponent var2) {
		this(var1, var2, -1, -1, -1);
	}

	public lj(int var1, int var2, int var3) {
		this(lk.c, (IChatBaseComponent) null, var1, var2, var3);
	}

	public lj(lk var1, IChatBaseComponent var2, int var3, int var4, int var5) {
		this.a = var1;
		this.b = var2;
		this.c = var3;
		this.d = var4;
		this.e = var5;
	}

	public void readData(PacketDataSerializer var1) {
		this.a = (lk) var1.readEnum(lk.class);
		if (this.a == lk.a || this.a == lk.b) {
			this.b = var1.readJSONComponent();
		}

		if (this.a == lk.c) {
			this.c = var1.readInt();
			this.d = var1.readInt();
			this.e = var1.readInt();
		}

	}

	public void writeData(PacketDataSerializer var1) {
		var1.writeEnum((Enum) this.a);
		if (this.a == lk.a || this.a == lk.b) {
			var1.writeJSONComponent(this.b);
		}

		if (this.a == lk.c) {
			var1.writeInt(this.c);
			var1.writeInt(this.d);
			var1.writeInt(this.e);
		}

	}

	public void handlePacket(PlayClientboundPacketListener var1) {
		var1.a(this);
	}
}

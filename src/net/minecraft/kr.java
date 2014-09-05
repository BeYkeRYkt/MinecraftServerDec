package net.minecraft;

public class kr implements Packet<PlayPacketListener> {

	private kt a;
	private int b;
	private double c;
	private double d;
	private double e;
	private double f;
	private long g;
	private int h;
	private int i;

	public kr() {
	}

	public kr(bfb var1, kt var2) {
		this.a = var2;
		this.c = var1.f();
		this.d = var1.g();
		this.f = var1.h();
		this.e = var1.j();
		this.g = var1.i();
		this.b = var1.l();
		this.i = var1.q();
		this.h = var1.p();
	}

	public void readData(PacketDataSerializer var1) {
		this.a = (kt) var1.a(kt.class);
		switch (ks.a[this.a.ordinal()]) {
			case 1:
				this.e = var1.readDouble();
				break;
			case 2:
				this.f = var1.readDouble();
				this.e = var1.readDouble();
				this.g = var1.readVarLong();
				break;
			case 3:
				this.c = var1.readDouble();
				this.d = var1.readDouble();
				break;
			case 4:
				this.i = var1.readVarInt();
				break;
			case 5:
				this.h = var1.readVarInt();
				break;
			case 6:
				this.c = var1.readDouble();
				this.d = var1.readDouble();
				this.f = var1.readDouble();
				this.e = var1.readDouble();
				this.g = var1.readVarLong();
				this.b = var1.readVarInt();
				this.i = var1.readVarInt();
				this.h = var1.readVarInt();
		}

	}

	public void writeData(PacketDataSerializer var1) {
		var1.writeEnum((Enum) this.a);
		switch (ks.a[this.a.ordinal()]) {
			case 1:
				var1.writeDouble(this.e);
				break;
			case 2:
				var1.writeDouble(this.f);
				var1.writeDouble(this.e);
				var1.writeVarLong(this.g);
				break;
			case 3:
				var1.writeDouble(this.c);
				var1.writeDouble(this.d);
				break;
			case 4:
				var1.writeVarInt(this.i);
				break;
			case 5:
				var1.writeVarInt(this.h);
				break;
			case 6:
				var1.writeDouble(this.c);
				var1.writeDouble(this.d);
				var1.writeDouble(this.f);
				var1.writeDouble(this.e);
				var1.writeVarLong(this.g);
				var1.writeVarInt(this.b);
				var1.writeVarInt(this.i);
				var1.writeVarInt(this.h);
		}

	}

	public void handlePacket(PlayPacketListener var1) {
		var1.a(this);
	}
}

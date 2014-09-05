package net.minecraft;

public class ke implements Packet<PlayPacketListener> {

	public kg a;
	public int b;
	public int c;
	public int d;
	public String e;

	public ke() {
	}

	public ke(wg var1, kg var2) {
		this.a = var2;
		EntityLiving var3 = var1.c();
		switch (kf.a[var2.ordinal()]) {
			case 1:
				this.d = var1.f();
				this.c = var3 == null ? -1 : var3.getId();
				break;
			case 2:
				this.b = var1.h().getId();
				this.c = var3 == null ? -1 : var3.getId();
				this.e = var1.b().c();
		}

	}

	public void readData(PacketDataSerializer var1) {
		this.a = (kg) var1.a(kg.class);
		if (this.a == kg.b) {
			this.d = var1.readVarInt();
			this.c = var1.readInt();
		} else if (this.a == kg.c) {
			this.b = var1.readVarInt();
			this.c = var1.readInt();
			this.e = var1.readString(32767);
		}

	}

	public void writeData(PacketDataSerializer var1) {
		var1.writeEnum((Enum) this.a);
		if (this.a == kg.b) {
			var1.writeVarInt(this.d);
			var1.writeInt(this.c);
		} else if (this.a == kg.c) {
			var1.writeVarInt(this.b);
			var1.writeInt(this.c);
			var1.writeString(this.e);
		}

	}

	public void handlePacket(PlayPacketListener var1) {
		var1.a(this);
	}
}

package net.minecraft;

public class in implements Packet<PlayPacketListener> {

	private int a;
	private int b;
	private int c;
	private int d;
	private int e;

	public in() {
	}

	public in(Entity var1) {
		this.a = var1.getId();
		this.b = DataTypesConverter.toFixedPointInt(var1.locationX * 32.0D);
		this.c = DataTypesConverter.toFixedPointInt(var1.locationY * 32.0D);
		this.d = DataTypesConverter.toFixedPointInt(var1.locationZ * 32.0D);
		if (var1 instanceof ads) {
			this.e = 1;
		}

	}

	public void readData(PacketDataSerializer var1) {
		this.a = var1.readVarInt();
		this.e = var1.readByte();
		this.b = var1.readInt();
		this.c = var1.readInt();
		this.d = var1.readInt();
	}

	public void writeData(PacketDataSerializer var1) {
		var1.writeVarInt(this.a);
		var1.writeByte(this.e);
		var1.writeInt(this.b);
		var1.writeInt(this.c);
		var1.writeInt(this.d);
	}

	public void handlePacket(PlayPacketListener var1) {
		var1.a(this);
	}
}

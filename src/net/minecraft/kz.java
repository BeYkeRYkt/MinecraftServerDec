package net.minecraft;

public class kz implements Packet<PlayPacketListener> {

	private int a;
	private int b;
	private int c;
	private int d;

	public kz() {
	}

	public kz(Entity var1) {
		this(var1.getId(), var1.motionX, var1.motionY, var1.motionZ);
	}

	public kz(int var1, double var2, double var4, double var6) {
		this.a = var1;
		double var8 = 3.9D;
		if (var2 < -var8) {
			var2 = -var8;
		}

		if (var4 < -var8) {
			var4 = -var8;
		}

		if (var6 < -var8) {
			var6 = -var8;
		}

		if (var2 > var8) {
			var2 = var8;
		}

		if (var4 > var8) {
			var4 = var8;
		}

		if (var6 > var8) {
			var6 = var8;
		}

		this.b = (int) (var2 * 8000.0D);
		this.c = (int) (var4 * 8000.0D);
		this.d = (int) (var6 * 8000.0D);
	}

	public void readData(PacketDataSerializer var1) {
		this.a = var1.readVarInt();
		this.b = var1.readShort();
		this.c = var1.readShort();
		this.d = var1.readShort();
	}

	public void writeData(PacketDataSerializer var1) {
		var1.writeVarInt(this.a);
		var1.writeShort(this.b);
		var1.writeShort(this.c);
		var1.writeShort(this.d);
	}

	public void handlePacket(PlayPacketListener var1) {
		var1.a(this);
	}
}

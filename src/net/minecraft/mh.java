package net.minecraft;

public class mh extends mg {

	public mh() {
		this.g = true;
	}

	public void readData(PacketDataSerializer var1) {
		this.a = var1.readDouble();
		this.b = var1.readDouble();
		this.c = var1.readDouble();
		super.readData(var1);
	}

	public void writeData(PacketDataSerializer var1) {
		var1.writeDouble(this.a);
		var1.writeDouble(this.b);
		var1.writeDouble(this.c);
		super.writeData(var1);
	}
}

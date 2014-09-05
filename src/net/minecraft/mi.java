package net.minecraft;

public class mi extends mg {

	public mi() {
		this.g = true;
		this.h = true;
	}

	public void readData(PacketDataSerializer var1) {
		this.a = var1.readDouble();
		this.b = var1.readDouble();
		this.c = var1.readDouble();
		this.d = var1.readFloat();
		this.e = var1.readFloat();
		super.readData(var1);
	}

	public void writeData(PacketDataSerializer var1) {
		var1.writeDouble(this.a);
		var1.writeDouble(this.b);
		var1.writeDouble(this.c);
		var1.writeFloat(this.d);
		var1.writeFloat(this.e);
		super.writeData(var1);
	}
}

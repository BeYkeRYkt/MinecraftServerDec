package net.minecraft;

public class mj extends mg {

	public mj() {
		this.h = true;
	}

	public void readData(PacketDataSerializer var1) {
		this.d = var1.readFloat();
		this.e = var1.readFloat();
		super.readData(var1);
	}

	public void writeData(PacketDataSerializer var1) {
		var1.writeFloat(this.d);
		var1.writeFloat(this.e);
		super.writeData(var1);
	}
}

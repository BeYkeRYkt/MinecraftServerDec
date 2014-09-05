package net.minecraft;

public class kb extends jy {

	public kb() {
		this.h = true;
	}

	public kb(int var1, byte var2, byte var3, boolean var4) {
		super(var1);
		this.e = var2;
		this.f = var3;
		this.h = true;
		this.g = var4;
	}

	public void readData(PacketDataSerializer var1) {
		super.readData(var1);
		this.e = var1.readByte();
		this.f = var1.readByte();
		this.g = var1.readBoolean();
	}

	public void writeData(PacketDataSerializer var1) {
		super.writeData(var1);
		var1.writeByte(this.e);
		var1.writeByte(this.f);
		var1.writeBoolean(this.g);
	}
}

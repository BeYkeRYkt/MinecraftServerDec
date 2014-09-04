package net.minecraft;

public class jz extends jy {

	public jz() {
	}

	public jz(int var1, byte var2, byte var3, byte var4, boolean var5) {
		super(var1);
		this.b = var2;
		this.c = var3;
		this.d = var4;
		this.g = var5;
	}

	public void a(hd var1) {
		super.a(var1);
		this.b = var1.readByte();
		this.c = var1.readByte();
		this.d = var1.readByte();
		this.g = var1.readBoolean();
	}

	public void b(hd var1) {
		super.b(var1);
		var1.writeByte(this.b);
		var1.writeByte(this.c);
		var1.writeByte(this.d);
		var1.writeBoolean(this.g);
	}
}

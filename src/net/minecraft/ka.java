package net.minecraft;

public class ka extends jy {

	public ka() {
		this.h = true;
	}

	public ka(int var1, byte var2, byte var3, byte var4, byte var5, byte var6, boolean var7) {
		super(var1);
		this.b = var2;
		this.c = var3;
		this.d = var4;
		this.e = var5;
		this.f = var6;
		this.g = var7;
		this.h = true;
	}

	public void a(hd var1) {
		super.a(var1);
		this.b = var1.readByte();
		this.c = var1.readByte();
		this.d = var1.readByte();
		this.e = var1.readByte();
		this.f = var1.readByte();
		this.g = var1.readBoolean();
	}

	public void b(hd var1) {
		super.b(var1);
		var1.writeByte(this.b);
		var1.writeByte(this.c);
		var1.writeByte(this.d);
		var1.writeByte(this.e);
		var1.writeByte(this.f);
		var1.writeBoolean(this.g);
	}
}

package net.minecraft;

public class iv implements id<ik> {

	private dt a;
	private int b;
	private int c;
	private atr d;

	public iv() {
	}

	public iv(dt var1, atr var2, int var3, int var4) {
		this.a = var1;
		this.b = var3;
		this.c = var4;
		this.d = var2;
	}

	public void a(hd var1) {
		this.a = var1.c();
		this.b = var1.readUnsignedByte();
		this.c = var1.readUnsignedByte();
		this.d = atr.c(var1.e() & 4095);
	}

	public void b(hd var1) {
		var1.a(this.a);
		var1.writeByte(this.b);
		var1.writeByte(this.c);
		var1.b(atr.a(this.d) & 4095);
	}

	public void a(ik var1) {
		var1.a(this);
	}
}

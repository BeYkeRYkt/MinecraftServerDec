package net.minecraft;

public class lz implements id<ls> {

	private int a;
	private int b;

	public void a(ls var1) {
		var1.a(this);
	}

	public void a(hd var1) {
		this.a = var1.readByte();
		this.b = var1.readByte();
	}

	public void b(hd var1) {
		var1.writeByte(this.a);
		var1.writeByte(this.b);
	}

	public int a() {
		return this.a;
	}

	public int b() {
		return this.b;
	}
}

package net.minecraft;

public class ly implements id<ls> {

	private int a;
	private short b;
	private boolean c;

	public void a(ls var1) {
		var1.a(this);
	}

	public void a(hd var1) {
		this.a = var1.readByte();
		this.b = var1.readShort();
		this.c = var1.readByte() != 0;
	}

	public void b(hd var1) {
		var1.writeByte(this.a);
		var1.writeShort(this.b);
		var1.writeByte(this.c ? 1 : 0);
	}

	public int a() {
		return this.a;
	}

	public short b() {
		return this.b;
	}
}

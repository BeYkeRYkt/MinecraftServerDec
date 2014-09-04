package net.minecraft;

public class lr implements id<ik> {

	private int a;
	private byte b;
	private byte c;
	private int d;
	private byte e;

	public lr() {
	}

	public lr(int var1, wq var2) {
		this.a = var1;
		this.b = (byte) (var2.a() & 255);
		this.c = (byte) (var2.c() & 255);
		if (var2.b() > 32767) {
			this.d = 32767;
		} else {
			this.d = var2.b();
		}

		this.e = (byte) (var2.f() ? 1 : 0);
	}

	public void a(hd var1) {
		this.a = var1.e();
		this.b = var1.readByte();
		this.c = var1.readByte();
		this.d = var1.e();
		this.e = var1.readByte();
	}

	public void b(hd var1) {
		var1.b(this.a);
		var1.writeByte(this.b);
		var1.writeByte(this.c);
		var1.b(this.d);
		var1.writeByte(this.e);
	}

	public void a(ik var1) {
		var1.a(this);
	}
}

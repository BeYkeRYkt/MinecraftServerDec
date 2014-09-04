package net.minecraft;

public class it implements id<ik> {

	private int a;
	private dt b;
	private int c;

	public it() {
	}

	public it(int var1, dt var2, int var3) {
		this.a = var1;
		this.b = var2;
		this.c = var3;
	}

	public void a(hd var1) {
		this.a = var1.e();
		this.b = var1.c();
		this.c = var1.readUnsignedByte();
	}

	public void b(hd var1) {
		var1.b(this.a);
		var1.a(this.b);
		var1.writeByte(this.c);
	}

	public void a(ik var1) {
		var1.a(this);
	}
}

package net.minecraft;

public class im implements id<ik> {

	private int a;
	private int b;
	private int c;
	private int d;
	private int e;

	public im() {
	}

	public im(xk var1) {
		this.a = var1.F();
		this.b = uv.c(var1.s * 32.0D);
		this.c = uv.c(var1.t * 32.0D);
		this.d = uv.c(var1.u * 32.0D);
		this.e = var1.j();
	}

	public void a(hd var1) {
		this.a = var1.e();
		this.b = var1.readInt();
		this.c = var1.readInt();
		this.d = var1.readInt();
		this.e = var1.readShort();
	}

	public void b(hd var1) {
		var1.b(this.a);
		var1.writeInt(this.b);
		var1.writeInt(this.c);
		var1.writeInt(this.d);
		var1.writeShort(this.e);
	}

	public void a(ik var1) {
		var1.a(this);
	}
}

package net.minecraft;

public class lx implements id<ls> {

	private String a;
	private int b;
	private ahg c;
	private boolean d;
	private int e;

	public void a(hd var1) {
		this.a = var1.c(7);
		this.b = var1.readByte();
		this.c = ahg.a(var1.readByte());
		this.d = var1.readBoolean();
		this.e = var1.readUnsignedByte();
	}

	public void b(hd var1) {
		var1.a(this.a);
		var1.writeByte(this.b);
		var1.writeByte(this.c.a());
		var1.writeBoolean(this.d);
		var1.writeByte(this.e);
	}

	public void a(ls var1) {
		var1.a(this);
	}

	public String a() {
		return this.a;
	}

	public ahg c() {
		return this.c;
	}

	public boolean d() {
		return this.d;
	}

	public int e() {
		return this.e;
	}
}

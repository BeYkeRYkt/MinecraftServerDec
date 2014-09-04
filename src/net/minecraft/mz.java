package net.minecraft;

public class mz implements id<na> {

	private int a;
	private String b;
	private int c;
	private EnumProtocol d;

	public void a(hd var1) {
		this.a = var1.e();
		this.b = var1.c(255);
		this.c = var1.readUnsignedShort();
		this.d = EnumProtocol.a(var1.e());
	}

	public void b(hd var1) {
		var1.b(this.a);
		var1.a(this.b);
		var1.writeShort(this.c);
		var1.b(this.d.a());
	}

	public void a(na var1) {
		var1.a(this);
	}

	public EnumProtocol a() {
		return this.d;
	}

	public int b() {
		return this.a;
	}
}

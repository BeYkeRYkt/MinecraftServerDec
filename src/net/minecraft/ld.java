package net.minecraft;

public class ld implements id<ik> {

	private String a;
	private String b;
	private bsl c;
	private int d;

	public ld() {
	}

	public ld(bry var1, int var2) {
		this.a = var1.b();
		this.b = var1.d();
		this.c = var1.c().c();
		this.d = var2;
	}

	public void a(hd var1) {
		this.a = var1.c(16);
		this.d = var1.readByte();
		if (this.d == 0 || this.d == 2) {
			this.b = var1.c(32);
			this.c = bsl.a(var1.c(16));
		}

	}

	public void b(hd var1) {
		var1.a(this.a);
		var1.writeByte(this.d);
		if (this.d == 0 || this.d == 2) {
			var1.a(this.b);
			var1.a(this.c.a());
		}

	}

	public void a(ik var1) {
		var1.a(this);
	}
}

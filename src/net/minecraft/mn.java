package net.minecraft;

public class mn implements id<ls> {

	private int a;
	private mo b;
	private int c;

	public void a(hd var1) {
		this.a = var1.e();
		this.b = (mo) var1.a(mo.class);
		this.c = var1.e();
	}

	public void b(hd var1) {
		var1.b(this.a);
		var1.a((Enum) this.b);
		var1.b(this.c);
	}

	public void a(ls var1) {
		var1.a(this);
	}

	public mo b() {
		return this.b;
	}

	public int c() {
		return this.c;
	}
}

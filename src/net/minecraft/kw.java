package net.minecraft;

public class kw implements id<ik> {

	private int a;
	private String b;

	public kw() {
	}

	public kw(int var1, bry var2) {
		this.a = var1;
		if (var2 == null) {
			this.b = "";
		} else {
			this.b = var2.b();
		}

	}

	public void a(hd var1) {
		this.a = var1.readByte();
		this.b = var1.c(16);
	}

	public void b(hd var1) {
		var1.writeByte(this.a);
		var1.a(this.b);
	}

	public void a(ik var1) {
		var1.a(this);
	}
}

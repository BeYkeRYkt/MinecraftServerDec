package net.minecraft;

public class lb implements id<ik> {

	private float a;
	private int b;
	private int c;

	public lb() {
	}

	public lb(float var1, int var2, int var3) {
		this.a = var1;
		this.b = var2;
		this.c = var3;
	}

	public void a(hd var1) {
		this.a = var1.readFloat();
		this.c = var1.e();
		this.b = var1.e();
	}

	public void b(hd var1) {
		var1.writeFloat(this.a);
		var1.b(this.c);
		var1.b(this.b);
	}

	public void a(ik var1) {
		var1.a(this);
	}
}

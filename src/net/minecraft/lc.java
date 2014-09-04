package net.minecraft;

public class lc implements id<ik> {

	private float a;
	private int b;
	private float c;

	public lc() {
	}

	public lc(float var1, int var2, float var3) {
		this.a = var1;
		this.b = var2;
		this.c = var3;
	}

	public void a(hd var1) {
		this.a = var1.readFloat();
		this.b = var1.e();
		this.c = var1.readFloat();
	}

	public void b(hd var1) {
		var1.writeFloat(this.a);
		var1.b(this.b);
		var1.writeFloat(this.c);
	}

	public void a(ik var1) {
		var1.a(this);
	}
}

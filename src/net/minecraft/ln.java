package net.minecraft;

public class ln implements id<ik> {

	private int a;
	private int b;

	public ln() {
	}

	public ln(int var1, int var2) {
		this.a = var1;
		this.b = var2;
	}

	public void a(hd var1) {
		this.a = var1.e();
		this.b = var1.e();
	}

	public void b(hd var1) {
		var1.b(this.a);
		var1.b(this.b);
	}

	public void a(ik var1) {
		var1.a(this);
	}
}

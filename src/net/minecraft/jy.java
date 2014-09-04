package net.minecraft;

public class jy implements id<ik> {

	protected int a;
	protected byte b;
	protected byte c;
	protected byte d;
	protected byte e;
	protected byte f;
	protected boolean g;
	protected boolean h;

	public jy() {
	}

	public jy(int var1) {
		this.a = var1;
	}

	public void a(hd var1) {
		this.a = var1.e();
	}

	public void b(hd var1) {
		var1.b(this.a);
	}

	public void a(ik var1) {
		var1.a(this);
	}

	public String toString() {
		return "Entity_" + super.toString();
	}
}

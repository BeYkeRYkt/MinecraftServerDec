package net.minecraft;

public class iw implements id<ik> {

	private dt a;
	private bec b;

	public iw() {
	}

	public iw(World var1, dt var2) {
		this.a = var2;
		this.b = var1.p(var2);
	}

	public void a(hd var1) {
		this.a = var1.c();
		this.b = (bec) atr.d.a(var1.e());
	}

	public void b(hd var1) {
		var1.a(this.a);
		var1.b(atr.d.b(this.b));
	}

	public void a(ik var1) {
		var1.a(this);
	}
}

package net.minecraft;

public class kr implements id<ik> {

	private kt a;
	private int b;
	private double c;
	private double d;
	private double e;
	private double f;
	private long g;
	private int h;
	private int i;

	public kr() {
	}

	public kr(bfb var1, kt var2) {
		this.a = var2;
		this.c = var1.f();
		this.d = var1.g();
		this.f = var1.h();
		this.e = var1.j();
		this.g = var1.i();
		this.b = var1.l();
		this.i = var1.q();
		this.h = var1.p();
	}

	public void a(hd var1) {
		this.a = (kt) var1.a(kt.class);
		switch (ks.a[this.a.ordinal()]) {
			case 1:
				this.e = var1.readDouble();
				break;
			case 2:
				this.f = var1.readDouble();
				this.e = var1.readDouble();
				this.g = var1.f();
				break;
			case 3:
				this.c = var1.readDouble();
				this.d = var1.readDouble();
				break;
			case 4:
				this.i = var1.e();
				break;
			case 5:
				this.h = var1.e();
				break;
			case 6:
				this.c = var1.readDouble();
				this.d = var1.readDouble();
				this.f = var1.readDouble();
				this.e = var1.readDouble();
				this.g = var1.f();
				this.b = var1.e();
				this.i = var1.e();
				this.h = var1.e();
		}

	}

	public void b(hd var1) {
		var1.a((Enum) this.a);
		switch (ks.a[this.a.ordinal()]) {
			case 1:
				var1.writeDouble(this.e);
				break;
			case 2:
				var1.writeDouble(this.f);
				var1.writeDouble(this.e);
				var1.b(this.g);
				break;
			case 3:
				var1.writeDouble(this.c);
				var1.writeDouble(this.d);
				break;
			case 4:
				var1.b(this.i);
				break;
			case 5:
				var1.b(this.h);
				break;
			case 6:
				var1.writeDouble(this.c);
				var1.writeDouble(this.d);
				var1.writeDouble(this.f);
				var1.writeDouble(this.e);
				var1.b(this.g);
				var1.b(this.b);
				var1.b(this.i);
				var1.b(this.h);
		}

	}

	public void a(ik var1) {
		var1.a(this);
	}
}

package net.minecraft;

public class mh extends mg {

	public mh() {
		this.g = true;
	}

	public void a(hd var1) {
		this.a = var1.readDouble();
		this.b = var1.readDouble();
		this.c = var1.readDouble();
		super.a(var1);
	}

	public void b(hd var1) {
		var1.writeDouble(this.a);
		var1.writeDouble(this.b);
		var1.writeDouble(this.c);
		super.b(var1);
	}
}

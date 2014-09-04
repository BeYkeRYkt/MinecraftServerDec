package net.minecraft;

public class mj extends mg {

	public mj() {
		this.h = true;
	}

	public void a(hd var1) {
		this.d = var1.readFloat();
		this.e = var1.readFloat();
		super.a(var1);
	}

	public void b(hd var1) {
		var1.writeFloat(this.d);
		var1.writeFloat(this.e);
		super.b(var1);
	}
}

package net.minecraft;

import java.io.IOException;

public class la implements id<ik> {

	private int a;
	private int b;
	private amj c;

	public la() {
	}

	public la(int var1, int var2, amj var3) {
		this.a = var1;
		this.b = var2;
		this.c = var3 == null ? null : var3.k();
	}

	public void a(hd var1) throws IOException {
		this.a = var1.e();
		this.b = var1.readShort();
		this.c = var1.i();
	}

	public void b(hd var1) {
		var1.b(this.a);
		var1.writeShort(this.b);
		var1.a(this.c);
	}

	public void a(ik var1) {
		var1.a(this);
	}
}

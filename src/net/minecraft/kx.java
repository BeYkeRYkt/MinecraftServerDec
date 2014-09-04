package net.minecraft;

import java.io.IOException;
import java.util.List;

public class kx implements id<ik> {

	private int a;
	private List b;

	public kx() {
	}

	public kx(int var1, xv var2, boolean var3) {
		this.a = var1;
		if (var3) {
			this.b = var2.c();
		} else {
			this.b = var2.b();
		}

	}

	public void a(hd var1) throws IOException {
		this.a = var1.e();
		this.b = xv.b(var1);
	}

	public void b(hd var1) {
		var1.b(this.a);
		xv.a(this.b, var1);
	}

	public void a(ik var1) {
		var1.a(this);
	}
}

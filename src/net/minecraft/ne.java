package net.minecraft;

import java.security.PublicKey;

public class ne implements id<nc> {

	private String a;
	private PublicKey b;
	private byte[] c;

	public ne() {
	}

	public ne(String var1, PublicKey var2, byte[] var3) {
		this.a = var1;
		this.b = var2;
		this.c = var3;
	}

	public void a(hd var1) {
		this.a = var1.c(20);
		this.b = ug.a(var1.a());
		this.c = var1.a();
	}

	public void b(hd var1) {
		var1.a(this.a);
		var1.a(this.b.getEncoded());
		var1.a(this.c);
	}

	public void a(nc var1) {
		var1.a(this);
	}
}

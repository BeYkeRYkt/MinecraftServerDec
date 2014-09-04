package net.minecraft;

import java.security.PrivateKey;
import javax.crypto.SecretKey;

public class nj implements id<nh> {

	private byte[] a = new byte[0];
	private byte[] b = new byte[0];

	public void a(hd var1) {
		this.a = var1.a();
		this.b = var1.a();
	}

	public void b(hd var1) {
		var1.a(this.a);
		var1.a(this.b);
	}

	public void a(nh var1) {
		var1.a(this);
	}

	public SecretKey a(PrivateKey var1) {
		return ug.a(var1, this.a);
	}

	public byte[] b(PrivateKey var1) {
		return var1 == null ? this.b : ug.b(var1, this.b);
	}
}

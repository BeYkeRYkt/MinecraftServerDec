package net.minecraft;

public class nw implements id<nv> {

	private long a;

	public void a(hd var1) {
		this.a = var1.readLong();
	}

	public void b(hd var1) {
		var1.writeLong(this.a);
	}

	public void a(nv var1) {
		var1.a(this);
	}

	public long a() {
		return this.a;
	}
}

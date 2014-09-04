package net.minecraft;

public class li implements id<ik> {

	private long a;
	private long b;

	public li() {
	}

	public li(long var1, long var3, boolean var5) {
		this.a = var1;
		this.b = var3;
		if (!var5) {
			this.b = -this.b;
			if (this.b == 0L) {
				this.b = -1L;
			}
		}

	}

	public void a(hd var1) {
		this.a = var1.readLong();
		this.b = var1.readLong();
	}

	public void b(hd var1) {
		var1.writeLong(this.a);
		var1.writeLong(this.b);
	}

	public void a(ik var1) {
		var1.a(this);
	}
}

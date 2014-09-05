package net.minecraft;

public class bqf {

	public final EntityHuman a;
	private boolean d;
	private int e;
	private int f;
	private int g;
	private int h;
	private int i;
	public int b;
	// $FF: synthetic field
	final bqe c;

	public bqf(bqe var1, EntityHuman var2) {
		this.c = var1;
		this.d = true;
		this.e = 0;
		this.f = 0;
		this.g = 127;
		this.h = 127;
		this.a = var2;
	}

	public Packet a(ItemStack var1) {
		if (this.d) {
			this.d = false;
			return new jx(var1.i(), this.c.e, this.c.h.values(), this.c.f, this.e, this.f, this.g + 1 - this.e, this.h + 1 - this.f);
		} else {
			return this.i++ % 5 == 0 ? new jx(var1.i(), this.c.e, this.c.h.values(), this.c.f, 0, 0, 0, 0) : null;
		}
	}

	public void a(int var1, int var2) {
		if (this.d) {
			this.e = Math.min(this.e, var1);
			this.f = Math.min(this.f, var2);
			this.g = Math.max(this.g, var1);
			this.h = Math.max(this.h, var2);
		} else {
			this.d = true;
			this.e = var1;
			this.f = var2;
			this.g = var1;
			this.h = var2;
		}

	}
}

package net.minecraft;

public class aiw extends ajk {

	private ahd a;
	private int b;

	public aiw(ahd var1, vq var2, int var3, int var4, int var5) {
		super(var2, var3, var4, var5);
		this.a = var1;
	}

	public boolean a(amj var1) {
		return false;
	}

	public amj a(int var1) {
		if (this.e()) {
			this.b += Math.min(var1, this.d().b);
		}

		return super.a(var1);
	}

	public void a(ahd var1, amj var2) {
		this.c(var2);
		super.a(var1, var2);
	}

	protected void a(amj var1, int var2) {
		this.b += var2;
		this.c(var1);
	}

	protected void c(amj var1) {
		var1.a(this.a.o, this.a, this.b);
		if (!this.a.o.D) {
			int var2 = this.b;
			float var3 = aok.a().b(var1);
			int var4;
			if (var3 == 0.0F) {
				var2 = 0;
			} else if (var3 < 1.0F) {
				var4 = uv.d((float) var2 * var3);
				if (var4 < uv.f((float) var2 * var3) && Math.random() < (double) ((float) var2 * var3 - (float) var4)) {
					++var4;
				}

				var2 = var4;
			}

			while (var2 > 0) {
				var4 = xk.a(var2);
				var2 -= var4;
				this.a.o.d((Entity) (new xk(this.a.o, this.a.s, this.a.t + 0.5D, this.a.u + 0.5D, var4)));
			}
		}

		this.b = 0;
		if (var1.b() == amk.j) {
			this.a.b((tq) tl.k);
		}

		if (var1.b() == amk.aV) {
			this.a.b((tq) tl.p);
		}

	}
}

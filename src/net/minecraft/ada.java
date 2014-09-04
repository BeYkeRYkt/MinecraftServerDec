package net.minecraft;

public class ada extends Entity {

	public int a;
	public int b;

	public ada(World var1) {
		super(var1);
		this.k = true;
		this.a(2.0F, 2.0F);
		this.b = 5;
		this.a = this.V.nextInt(100000);
	}

	protected boolean r_() {
		return false;
	}

	protected void h() {
		this.ac.a(8, Integer.valueOf(this.b));
	}

	public void s_() {
		this.p = this.s;
		this.q = this.t;
		this.r = this.u;
		++this.a;
		this.ac.b(8, Integer.valueOf(this.b));
		int var1 = NumberConverter.c(this.s);
		int var2 = NumberConverter.c(this.t);
		int var3 = NumberConverter.c(this.u);
		if (this.o.t instanceof bgh && this.o.p(new dt(var1, var2, var3)).c() != aty.ab) {
			this.o.a(new dt(var1, var2, var3), aty.ab.P());
		}

	}

	protected void b(NBTCompoundTag var1) {
	}

	protected void a(NBTCompoundTag var1) {
	}

	public boolean ad() {
		return true;
	}

	public boolean a(wh var1, float var2) {
		if (this.b(var1)) {
			return false;
		} else {
			if (!this.I && !this.o.D) {
				this.b = 0;
				if (this.b <= 0) {
					this.J();
					if (!this.o.D) {
						this.o.a((Entity) null, this.s, this.t, this.u, 6.0F, true);
					}
				}
			}

			return true;
		}
	}
}

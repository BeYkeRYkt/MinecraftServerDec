package net.minecraft;

public class age extends afm {

	public age(World var1) {
		super(var1);
		this.a(1.4F, 0.9F);
		this.i.a(1, new yy(this));
		this.i.a(2, this.a);
		this.i.a(3, new zg(this, 0.4F));
		this.i.a(4, new agf(this, ahd.class));
		this.i.a(4, new agf(this, acq.class));
		this.i.a(5, new zy(this, 0.8D));
		this.i.a(6, new zh(this, ahd.class, 8.0F));
		this.i.a(6, new zx(this));
		this.bg.a(1, new aal(this, false, new Class[0]));
		this.bg.a(2, new agh(this, ahd.class));
		this.bg.a(3, new agh(this, acq.class));
	}

	protected aaz b(World var1) {
		return new aba(this, var1);
	}

	protected void h() {
		super.h();
		this.ac.a(16, new Byte((byte) 0));
	}

	public void s_() {
		super.s_();
		if (!this.o.D) {
			this.a(this.D);
		}

	}

	protected void aW() {
		super.aW();
		this.a(afs.a).a(16.0D);
		this.a(afs.d).a(0.30000001192092896D);
	}

	protected String z() {
		return "mob.spider.say";
	}

	protected String bn() {
		return "mob.spider.say";
	}

	protected String bo() {
		return "mob.spider.death";
	}

	protected void a(dt var1, atr var2) {
		this.a("mob.spider.step", 0.15F, 1.0F);
	}

	protected alq A() {
		return amk.F;
	}

	protected void b(boolean var1, int var2) {
		super.b(var1, var2);
		if (var1 && (this.V.nextInt(3) == 0 || this.V.nextInt(1 + var2) > 0)) {
			this.a(amk.bB, 1);
		}

	}

	public boolean j_() {
		return this.n();
	}

	public void aB() {
	}

	public xs by() {
		return xs.c;
	}

	public boolean d(wq var1) {
		return var1.a() == wp.u.H ? false : super.d(var1);
	}

	public boolean n() {
		return (this.ac.a(16) & 1) != 0;
	}

	public void a(boolean var1) {
		byte var2 = this.ac.a(16);
		if (var1) {
			var2 = (byte) (var2 | 1);
		} else {
			var2 &= -2;
		}

		this.ac.b(16, Byte.valueOf(var2));
	}

	public xq a(vu var1, xq var2) {
		Object var4 = super.a(var1, var2);
		if (this.o.s.nextInt(100) == 0) {
			afw var3 = new afw(this.o);
			var3.b(this.s, this.t, this.u, this.y, 0.0F);
			var3.a(var1, (xq) null);
			this.o.d((Entity) var3);
			var3.a((Entity) this);
		}

		if (var4 == null) {
			var4 = new agg();
			if (this.o.aa() == vt.d && this.o.s.nextFloat() < 0.1F * var1.c()) {
				((agg) var4).a(this.o.s);
			}
		}

		if (var4 instanceof agg) {
			int var5 = ((agg) var4).a;
			if (var5 > 0 && wp.a[var5] != null) {
				this.c(new wq(var5, Integer.MAX_VALUE));
			}
		}

		return (xq) var4;
	}

	public float aR() {
		return 0.65F;
	}
}

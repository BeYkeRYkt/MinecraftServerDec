package net.minecraft;

public class aca extends abq {

	private final yu bk;

	public aca(World var1) {
		super(var1);
		this.a(0.9F, 0.9F);
		((aay) this.s()).a(true);
		this.i.a(0, new yy(this));
		this.i.a(1, new zu(this, 1.25D));
		this.i.a(2, this.bk = new yu(this, 0.3F));
		this.i.a(3, new yt(this, 1.0D));
		this.i.a(4, new aag(this, 1.2D, amk.bY, false));
		this.i.a(4, new aag(this, 1.2D, amk.bR, false));
		this.i.a(5, new za(this, 1.1D));
		this.i.a(6, new zy(this, 1.0D));
		this.i.a(7, new zh(this, ahd.class, 6.0F));
		this.i.a(8, new zx(this));
	}

	protected void aW() {
		super.aW();
		this.a(afs.a).a(10.0D);
		this.a(afs.d).a(0.25D);
	}

	public boolean bV() {
		amj var1 = ((ahd) this.l).bz();
		return var1 != null && var1.b() == amk.bY;
	}

	protected void h() {
		super.h();
		this.ac.a(16, Byte.valueOf((byte) 0));
	}

	public void b(NBTCompoundTag var1) {
		super.b(var1);
		var1.a("Saddle", this.cj());
	}

	public void a(NBTCompoundTag var1) {
		super.a(var1);
		this.l(var1.n("Saddle"));
	}

	protected String z() {
		return "mob.pig.say";
	}

	protected String bn() {
		return "mob.pig.say";
	}

	protected String bo() {
		return "mob.pig.death";
	}

	protected void a(dt var1, atr var2) {
		this.a("mob.pig.step", 0.15F, 1.0F);
	}

	public boolean a(ahd var1) {
		if (super.a(var1)) {
			return true;
		} else if (this.cj() && !this.o.D && (this.l == null || this.l == var1)) {
			var1.a((Entity) this);
			return true;
		} else {
			return false;
		}
	}

	protected alq A() {
		return this.au() ? amk.am : amk.al;
	}

	protected void b(boolean var1, int var2) {
		int var3 = this.V.nextInt(3) + 1 + this.V.nextInt(1 + var2);

		for (int var4 = 0; var4 < var3; ++var4) {
			if (this.au()) {
				this.a(amk.am, 1);
			} else {
				this.a(amk.al, 1);
			}
		}

		if (this.cj()) {
			this.a(amk.aA, 1);
		}

	}

	public boolean cj() {
		return (this.ac.a(16) & 1) != 0;
	}

	public void l(boolean var1) {
		if (var1) {
			this.ac.b(16, Byte.valueOf((byte) 1));
		} else {
			this.ac.b(16, Byte.valueOf((byte) 0));
		}

	}

	public void a(ads var1) {
		if (!this.o.D) {
			afo var2 = new afo(this.o);
			var2.c(0, new amj(amk.B));
			var2.b(this.s, this.t, this.u, this.y, this.z);
			this.o.d((Entity) var2);
			this.J();
		}
	}

	public void e(float var1, float var2) {
		super.e(var1, var2);
		if (var1 > 5.0F && this.l instanceof ahd) {
			((ahd) this.l).b((PlayerStatistic) tl.u);
		}

	}

	public aca b(ws var1) {
		return new aca(this.o);
	}

	public boolean d(amj var1) {
		return var1 != null && var1.b() == amk.bR;
	}

	public yu ck() {
		return this.bk;
	}

	// $FF: synthetic method
	public ws a(ws var1) {
		return this.b(var1);
	}
}

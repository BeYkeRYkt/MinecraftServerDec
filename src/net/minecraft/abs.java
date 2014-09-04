package net.minecraft;

public class abs extends abq {

	public abs(World var1) {
		super(var1);
		this.a(0.9F, 1.3F);
		((aay) this.s()).a(true);
		this.i.a(0, new yy(this));
		this.i.a(1, new zu(this, 2.0D));
		this.i.a(2, new yt(this, 1.0D));
		this.i.a(3, new aag(this, 1.25D, amk.O, false));
		this.i.a(4, new za(this, 1.25D));
		this.i.a(5, new zy(this, 1.0D));
		this.i.a(6, new zh(this, ahd.class, 6.0F));
		this.i.a(7, new zx(this));
	}

	protected void aW() {
		super.aW();
		this.a(afs.a).a(10.0D);
		this.a(afs.d).a(0.20000000298023224D);
	}

	protected String z() {
		return "mob.cow.say";
	}

	protected String bn() {
		return "mob.cow.hurt";
	}

	protected String bo() {
		return "mob.cow.hurt";
	}

	protected void a(dt var1, atr var2) {
		this.a("mob.cow.step", 0.15F, 1.0F);
	}

	protected float bA() {
		return 0.4F;
	}

	protected alq A() {
		return amk.aF;
	}

	protected void b(boolean var1, int var2) {
		int var3 = this.V.nextInt(3) + this.V.nextInt(1 + var2);

		int var4;
		for (var4 = 0; var4 < var3; ++var4) {
			this.a(amk.aF, 1);
		}

		var3 = this.V.nextInt(3) + 1 + this.V.nextInt(1 + var2);

		for (var4 = 0; var4 < var3; ++var4) {
			if (this.au()) {
				this.a(amk.bj, 1);
			} else {
				this.a(amk.bi, 1);
			}
		}

	}

	public boolean a(ahd var1) {
		amj var2 = var1.bg.h();
		if (var2 != null && var2.b() == amk.aw && !var1.by.instabuild) {
			if (var2.b-- == 1) {
				var1.bg.a(var1.bg.c, new amj(amk.aG));
			} else if (!var1.bg.a(new amj(amk.aG))) {
				var1.a(new amj(amk.aG, 1, 0), false);
			}

			return true;
		} else {
			return super.a(var1);
		}
	}

	public abs b(ws var1) {
		return new abs(this.o);
	}

	public float aR() {
		return this.K;
	}

	// $FF: synthetic method
	public ws a(ws var1) {
		return this.b(var1);
	}
}

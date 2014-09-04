package net.minecraft;

public abstract class afm extends EntityCreature implements aex {

	protected final zb a = new yp(this, new afn(this), 4.0F, 1.0D, 2.0D);

	public afm(World var1) {
		super(var1);
		this.b_ = 5;
	}

	public void m() {
		this.bw();
		float var1 = this.c(1.0F);
		if (var1 > 0.5F) {
			this.aO += 2;
		}

		super.m();
	}

	public void s_() {
		super.s_();
		if (!this.o.D && this.o.aa() == vt.a) {
			this.J();
		}

	}

	protected String P() {
		return "game.hostile.swim";
	}

	protected String aa() {
		return "game.hostile.swim.splash";
	}

	public boolean a(wh var1, float var2) {
		if (this.b(var1)) {
			return false;
		} else if (super.a(var1, var2)) {
			Entity var3 = var1.j();
			return this.l != var3 && this.m != var3 ? true : true;
		} else {
			return false;
		}
	}

	protected String bn() {
		return "game.hostile.hurt";
	}

	protected String bo() {
		return "game.hostile.die";
	}

	protected String n(int var1) {
		return var1 > 4 ? "game.hostile.hurt.fall.big" : "game.hostile.hurt.fall.small";
	}

	public boolean r(Entity var1) {
		float var2 = (float) this.a(afs.e).e();
		int var3 = 0;
		if (var1 instanceof EntityLiving) {
			var2 += aph.a(this.bz(), ((EntityLiving) var1).by());
			var3 += aph.a((EntityLiving) this);
		}

		boolean var4 = var1.a(wh.a((EntityLiving) this), var2);
		if (var4) {
			if (var3 > 0) {
				var1.g((double) (-uv.a(this.y * 3.1415927F / 180.0F) * (float) var3 * 0.5F), 0.1D, (double) (uv.b(this.y * 3.1415927F / 180.0F) * (float) var3 * 0.5F));
				this.v *= 0.6D;
				this.x *= 0.6D;
			}

			int var5 = aph.b((EntityLiving) this);
			if (var5 > 0) {
				var1.e(var5 * 4);
			}

			this.a(this, var1);
		}

		return var4;
	}

	public float a(dt var1) {
		return 0.5F - this.o.o(var1);
	}

	protected boolean m_() {
		dt var1 = new dt(this.s, this.aQ().b, this.u);
		if (this.o.b(arf.a, var1) > this.V.nextInt(32)) {
			return false;
		} else {
			int var2 = this.o.l(var1);
			if (this.o.R()) {
				int var3 = this.o.ab();
				this.o.b(10);
				var2 = this.o.l(var1);
				this.o.b(var3);
			}

			return var2 <= this.V.nextInt(8);
		}
	}

	public boolean bQ() {
		return this.o.aa() != vt.a && this.m_() && super.bQ();
	}

	protected void aW() {
		super.aW();
		this.bx().b(afs.e);
	}

	protected boolean aZ() {
		return true;
	}
}

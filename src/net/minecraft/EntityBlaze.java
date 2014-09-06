package net.minecraft;

public class EntityBlaze extends EntityMonster {

	private float b = 0.5F;
	private int c;

	public EntityBlaze(World var1) {
		super(var1);
		this.ab = true;
		this.b_ = 10;
		this.i.a(4, new aen(this));
		this.i.a(5, new zo(this, 1.0D));
		this.i.a(7, new zy(this, 1.0D));
		this.i.a(8, new zh(this, EntityHuman.class, 8.0F));
		this.i.a(8, new zx(this));
		this.bg.a(1, new aal(this, true, new Class[0]));
		this.bg.a(2, new aaq(this, EntityHuman.class, true));
	}

	protected void aW() {
		super.aW();
		this.a(afs.e).a(6.0D);
		this.a(afs.d).a(0.23000000417232513D);
		this.a(afs.b).a(48.0D);
	}

	protected void h() {
		super.h();
		this.dataWatcher.a(16, new Byte((byte) 0));
	}

	protected String z() {
		return "mob.blaze.breathe";
	}

	protected String bn() {
		return "mob.blaze.hit";
	}

	protected String bo() {
		return "mob.blaze.death";
	}

	public float c(float var1) {
		return 1.0F;
	}

	public void m() {
		if (!this.onGround && this.motionY < 0.0D) {
			this.motionY *= 0.6D;
		}

		if (this.o.D) {
			if (this.V.nextInt(24) == 0 && !this.R()) {
				this.o.a(this.locationX + 0.5D, this.locationY + 0.5D, this.locationZ + 0.5D, "fire.fire", 1.0F + this.V.nextFloat(), this.V.nextFloat() * 0.7F + 0.3F, false);
			}

			for (int var1 = 0; var1 < 2; ++var1) {
				this.o.a(Particle.m, this.locationX + (this.V.nextDouble() - 0.5D) * (double) this.J, this.locationY + this.V.nextDouble() * (double) this.K, this.locationZ + (this.V.nextDouble() - 0.5D) * (double) this.J, 0.0D, 0.0D, 0.0D, new int[0]);
			}
		}

		super.m();
	}

	protected void E() {
		if (this.U()) {
			this.a(wh.f, 1.0F);
		}

		--this.c;
		if (this.c <= 0) {
			this.c = 100;
			this.b = 0.5F + (float) this.V.nextGaussian() * 3.0F;
		}

		EntityLiving var1 = this.u();
		if (var1 != null && var1.locationY + (double) var1.aR() > this.locationY + (double) this.aR() + (double) this.b) {
			this.motionY += (0.30000001192092896D - this.motionY) * 0.30000001192092896D;
			this.ai = true;
		}

		super.E();
	}

	public void e(float var1, float var2) {
	}

	protected Item A() {
		return amk.bv;
	}

	public boolean au() {
		return this.n();
	}

	protected void b(boolean var1, int var2) {
		if (var1) {
			int var3 = this.V.nextInt(2 + var2);

			for (int var4 = 0; var4 < var3; ++var4) {
				this.a(amk.bv, 1);
			}
		}

	}

	public boolean n() {
		return (this.dataWatcher.a(16) & 1) != 0;
	}

	public void a(boolean var1) {
		byte var2 = this.dataWatcher.a(16);
		if (var1) {
			var2 = (byte) (var2 | 1);
		} else {
			var2 &= -2;
		}

		this.dataWatcher.b(16, Byte.valueOf(var2));
	}

	protected boolean m_() {
		return true;
	}
}

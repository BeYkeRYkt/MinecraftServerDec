package net.minecraft;

public class aep extends afm {

	private int b;
	private int c;
	private int bk = 30;
	private int bl = 3;
	private int bm = 0;

	public aep(World var1) {
		super(var1);
		this.i.a(1, new yy(this));
		this.i.a(2, new aae(this));
		this.i.a(2, this.a);
		this.i.a(3, new yp(this, new aeq(this), 6.0F, 1.0D, 1.2D));
		this.i.a(4, new zk(this, 1.0D, false));
		this.i.a(5, new zy(this, 0.8D));
		this.i.a(6, new zh(this, ahd.class, 8.0F));
		this.i.a(6, new zx(this));
		this.bg.a(1, new aaq(this, ahd.class, true));
		this.bg.a(2, new aal(this, false, new Class[0]));
	}

	protected void aW() {
		super.aW();
		this.a(afs.d).a(0.25D);
	}

	public int aF() {
		return this.u() == null ? 3 : 3 + (int) (this.bm() - 1.0F);
	}

	public void e(float var1, float var2) {
		super.e(var1, var2);
		this.c = (int) ((float) this.c + var1 * 1.5F);
		if (this.c > this.bk - 5) {
			this.c = this.bk - 5;
		}

	}

	protected void h() {
		super.h();
		this.ac.a(16, Byte.valueOf((byte) -1));
		this.ac.a(17, Byte.valueOf((byte) 0));
		this.ac.a(18, Byte.valueOf((byte) 0));
	}

	public void b(NBTCompoundTag var1) {
		super.b(var1);
		if (this.ac.a(17) == 1) {
			var1.a("powered", true);
		}

		var1.a("Fuse", (short) this.bk);
		var1.a("ExplosionRadius", (byte) this.bl);
		var1.a("ignited", this.cl());
	}

	public void a(NBTCompoundTag var1) {
		super.a(var1);
		this.ac.b(17, Byte.valueOf((byte) (var1.n("powered") ? 1 : 0)));
		if (var1.b("Fuse", 99)) {
			this.bk = var1.e("Fuse");
		}

		if (var1.b("ExplosionRadius", 99)) {
			this.bl = var1.d("ExplosionRadius");
		}

		if (var1.n("ignited")) {
			this.cm();
		}

	}

	public void s_() {
		if (this.ai()) {
			this.b = this.c;
			if (this.cl()) {
				this.a(1);
			}

			int var1 = this.ck();
			if (var1 > 0 && this.c == 0) {
				this.a("creeper.primed", 1.0F, 0.5F);
			}

			this.c += var1;
			if (this.c < 0) {
				this.c = 0;
			}

			if (this.c >= this.bk) {
				this.c = this.bk;
				this.cp();
			}
		}

		super.s_();
	}

	protected String bn() {
		return "mob.creeper.say";
	}

	protected String bo() {
		return "mob.creeper.death";
	}

	public void a(wh var1) {
		super.a(var1);
		if (var1.j() instanceof afw) {
			int var2 = alq.b(amk.cq);
			int var3 = alq.b(amk.cB);
			int var4 = var2 + this.V.nextInt(var3 - var2 + 1);
			this.a(alq.b(var4), 1);
		} else if (var1.j() instanceof aep && var1.j() != this && ((aep) var1.j()).n() && ((aep) var1.j()).cn()) {
			((aep) var1.j()).co();
			this.a(new amj(amk.bX, 1, 4), 0.0F);
		}

	}

	public boolean r(Entity var1) {
		return true;
	}

	public boolean n() {
		return this.ac.a(17) == 1;
	}

	protected alq A() {
		return amk.H;
	}

	public int ck() {
		return this.ac.a(16);
	}

	public void a(int var1) {
		this.ac.b(16, Byte.valueOf((byte) var1));
	}

	public void a(ads var1) {
		super.a(var1);
		this.ac.b(17, Byte.valueOf((byte) 1));
	}

	protected boolean a(ahd var1) {
		amj var2 = var1.bg.h();
		if (var2 != null && var2.b() == amk.d) {
			this.o.a(this.s + 0.5D, this.t + 0.5D, this.u + 0.5D, "fire.ignite", 1.0F, this.V.nextFloat() * 0.4F + 0.8F);
			var1.bv();
			if (!this.o.D) {
				this.cm();
				var2.a(1, (EntityLiving) var1);
				return true;
			}
		}

		return super.a(var1);
	}

	private void cp() {
		if (!this.o.D) {
			boolean var1 = this.o.Q().b("mobGriefing");
			float var2 = this.n() ? 2.0F : 1.0F;
			this.o.a(this, this.s, this.t, this.u, (float) this.bl * var2, var1);
			this.J();
		}

	}

	public boolean cl() {
		return this.ac.a(18) != 0;
	}

	public void cm() {
		this.ac.b(18, Byte.valueOf((byte) 1));
	}

	public boolean cn() {
		return this.bm < 1 && this.o.Q().b("doMobLoot");
	}

	public void co() {
		++this.bm;
	}
}

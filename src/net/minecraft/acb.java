package net.minecraft;

public class acb extends abq {

	private acf bk;
	private int bm = 0;
	private int bn = 0;
	private boolean bo = false;
	private boolean bp = false;
	private int bq = 0;
	private ace br;
	private int bs;
	private EntityHuman bt;

	public acb(World var1) {
		super(var1);
		this.br = ace.b;
		this.bs = 0;
		this.bt = null;
		this.a(0.6F, 0.7F);
		this.g = new ach(this, this);
		this.f = new aci(this);
		((aay) this.s()).a(true);
		this.h.a(2.5F);
		this.i.a(1, new yy(this));
		this.i.a(1, new acj(this, 1.33D));
		this.i.a(2, new aag(this, 1.0D, amk.bR, false));
		this.i.a(3, new yt(this, 0.8D));
		this.i.a(5, new ack(this));
		this.i.a(5, new zy(this, 0.6D));
		this.i.a(11, new zh(this, EntityHuman.class, 10.0F));
		this.bk = new acf(this, new acc(this), 16.0F, 1.33D, 1.33D);
		this.i.a(4, this.bk);
		this.b(0.0D);
	}

	protected float bD() {
		return this.f.a() && this.f.e() > this.locationY + 0.5D ? 0.5F : this.br.b();
	}

	public void a(ace var1) {
		this.br = var1;
	}

	public void b(double var1) {
		this.s().a(var1);
		this.f.a(this.f.d(), this.f.e(), this.f.f(), var1);
	}

	public void a(boolean var1, ace var2) {
		super.i(var1);
		if (!var1) {
			if (this.br == ace.e) {
				this.br = ace.b;
			}
		} else {
			this.b(1.5D * (double) var2.a());
			this.a(this.ck(), this.bA(), ((this.V.nextFloat() - this.V.nextFloat()) * 0.2F + 1.0F) * 0.8F);
		}

		this.bo = var1;
	}

	public void b(ace var1) {
		this.a(true, var1);
		this.bn = var1.d();
		this.bm = 0;
	}

	public boolean cj() {
		return this.bo;
	}

	protected void h() {
		super.h();
		this.dataWatcher.a(18, Byte.valueOf((byte) 0));
	}

	public void E() {
		if (this.f.b() > 0.8D) {
			this.a(ace.d);
		} else if (this.br != ace.e) {
			this.a(ace.b);
		}

		if (this.bq > 0) {
			--this.bq;
		}

		if (this.bs > 0) {
			this.bs -= this.V.nextInt(3);
			if (this.bs < 0) {
				this.bs = 0;
			}
		}

		if (this.C) {
			if (!this.bp) {
				this.a(false, ace.a);
				this.cu();
			}

			if (this.cl() == 99 && this.bq == 0) {
				EntityLiving var1 = this.u();
				if (var1 != null && this.h(var1) < 16.0D) {
					this.a(var1.locationX, var1.locationZ);
					this.f.a(var1.locationX, var1.locationY, var1.locationZ, this.f.b());
					this.b(ace.e);
					this.bp = true;
				}
			}

			ach var4 = (ach) this.g;
			if (!var4.c()) {
				if (this.f.a() && this.bq == 0) {
					bpv var2 = this.h.j();
					brw var3 = new brw(this.f.d(), this.f.e(), this.f.f());
					if (var2 != null && var2.e() < var2.d()) {
						var3 = var2.a((Entity) this);
					}

					this.a(var3.a, var3.c);
					this.b(this.br);
				}
			} else if (!var4.d()) {
				this.cr();
			}
		}

		this.bp = this.C;
	}

	public void Y() {
	}

	private void a(double var1, double var3) {
		this.yaw = (float) (Math.atan2(var3 - this.locationZ, var1 - this.locationX) * 180.0D / 3.1415927410125732D) - 90.0F;
	}

	private void cr() {
		((ach) this.g).a(true);
	}

	private void cs() {
		((ach) this.g).a(false);
	}

	private void ct() {
		this.bq = this.cm();
	}

	private void cu() {
		this.ct();
		this.cs();
	}

	public void m() {
		super.m();
		if (this.bm != this.bn) {
			if (this.bm == 0 && !this.o.D) {
				this.o.a((Entity) this, (byte) 1);
			}

			++this.bm;
		} else if (this.bn != 0) {
			this.bm = 0;
			this.bn = 0;
		}

	}

	protected void aW() {
		super.aW();
		this.a(afs.a).a(10.0D);
		this.a(afs.d).a(0.30000001192092896D);
	}

	public void b(NBTCompoundTag var1) {
		super.b(var1);
		var1.put("RabbitType", this.cl());
		var1.put("MoreCarrotTicks", this.bs);
	}

	public void a(NBTCompoundTag var1) {
		super.a(var1);
		this.r(var1.getInt("RabbitType"));
		this.bs = var1.getInt("MoreCarrotTicks");
	}

	protected String ck() {
		return "mob.rabbit.hop";
	}

	protected String z() {
		return "mob.rabbit.idle";
	}

	protected String bn() {
		return "mob.rabbit.hurt";
	}

	protected String bo() {
		return "mob.rabbit.death";
	}

	public boolean r(Entity var1) {
		if (this.cl() == 99) {
			this.a("mob.attack", 1.0F, (this.V.nextFloat() - this.V.nextFloat()) * 0.2F + 1.0F);
			return var1.a(wh.a((EntityLiving) this), 8.0F);
		} else {
			return var1.a(wh.a((EntityLiving) this), 3.0F);
		}
	}

	public int bq() {
		return this.cl() == 99 ? 8 : super.bq();
	}

	public boolean a(wh var1, float var2) {
		return this.b(var1) ? false : super.a(var1, var2);
	}

	protected void bp() {
		this.a(new ItemStack(amk.br, 1), 0.0F);
	}

	protected void b(boolean var1, int var2) {
		int var3 = this.V.nextInt(2) + this.V.nextInt(1 + var2);

		int var4;
		for (var4 = 0; var4 < var3; ++var4) {
			this.a(amk.bs, 1);
		}

		var3 = this.V.nextInt(2);

		for (var4 = 0; var4 < var3; ++var4) {
			if (this.au()) {
				this.a(amk.bp, 1);
			} else {
				this.a(amk.bo, 1);
			}
		}

	}

	private boolean a(Item var1) {
		return var1 == amk.bR || var1 == amk.bW || var1 == Item.getItemOf((Block) aty.N);
	}

	public acb b(ws var1) {
		acb var2 = new acb(this.o);
		if (var1 instanceof acb) {
			var2.r(this.V.nextBoolean() ? this.cl() : ((acb) var1).cl());
		}

		return var2;
	}

	public boolean d(ItemStack var1) {
		return var1 != null && this.a(var1.getItem());
	}

	public int cl() {
		return this.dataWatcher.a(18);
	}

	public void r(int var1) {
		if (var1 == 99) {
			this.i.a((zb) this.bk);
			this.i.a(4, new acd(this));
			this.bg.a(1, new aal(this, false, new Class[0]));
			this.bg.a(2, new aaq(this, EntityHuman.class, true));
			this.bg.a(2, new aaq(this, acu.class, true));
			if (!this.k_()) {
				this.a(fi.a("entity.KillerBunny.name"));
			}
		}

		this.dataWatcher.b(18, Byte.valueOf((byte) var1));
	}

	public xq a(vu var1, xq var2) {
		Object var5 = super.a(var1, var2);
		int var3 = this.V.nextInt(6);
		boolean var4 = false;
		if (var5 instanceof acg) {
			var3 = ((acg) var5).a;
			var4 = true;
		} else {
			var5 = new acg(var3);
		}

		this.r(var3);
		if (var4) {
			this.b(-24000);
		}

		return (xq) var5;
	}

	private boolean cv() {
		return this.bs == 0;
	}

	protected int cm() {
		return this.br.c();
	}

	protected void cn() {
		this.o.a(ew.M, this.locationX + (double) (this.V.nextFloat() * this.J * 2.0F) - (double) this.J, this.locationY + 0.5D + (double) (this.V.nextFloat() * this.K), this.locationZ + (double) (this.V.nextFloat() * this.J * 2.0F) - (double) this.J, 0.0D, 0.0D, 0.0D, new int[] { Block.f(aty.cb.a(7)) });
		this.bs = 100;
	}

	// $FF: synthetic method
	public ws a(ws var1) {
		return this.b(var1);
	}

	// $FF: synthetic method
	static boolean a(acb var0) {
		return var0.cv();
	}
}

package net.minecraft;

import java.util.UUID;

public class afo extends agj {

	private static final UUID c = UUID.fromString("49455A49-7EC5-45BA-B886-3B90B23A1718");
	private static final ya bk = (new ya(c, "Attacking speed boost", 0.05D, 0)).a(false);
	private int bl;
	private int bm;
	private UUID bn;

	public afo(World var1) {
		super(var1);
		this.ab = true;
	}

	public void b(EntityLiving var1) {
		super.b(var1);
		if (var1 != null) {
			this.bn = var1.aJ();
		}

	}

	protected void n() {
		this.bg.a(1, new afq(this));
		this.bg.a(2, new afp(this));
	}

	protected void aW() {
		super.aW();
		this.a(b).a(0.0D);
		this.a(afs.d).a(0.23000000417232513D);
		this.a(afs.e).a(5.0D);
	}

	public void s_() {
		super.s_();
	}

	protected void E() {
		xz var1 = this.a(afs.d);
		if (this.ck()) {
			if (!this.i_() && !var1.a(bk)) {
				var1.b(bk);
			}

			--this.bl;
		} else if (var1.a(bk)) {
			var1.c(bk);
		}

		if (this.bm > 0 && --this.bm == 0) {
			this.a("mob.zombiepig.zpigangry", this.bA() * 2.0F, ((this.V.nextFloat() - this.V.nextFloat()) * 0.2F + 1.0F) * 1.8F);
		}

		if (this.bl > 0 && this.bn != null && this.bc() == null) {
			ahd var2 = this.o.b(this.bn);
			this.b((EntityLiving) var2);
			this.aL = var2;
			this.aM = this.bd();
		}

		super.E();
	}

	public boolean bQ() {
		return this.o.aa() != Difficulty.PEACEFUL;
	}

	public boolean bR() {
		return this.o.a(this.aQ(), (Entity) this) && this.o.a((Entity) this, this.aQ()).isEmpty() && !this.o.d(this.aQ());
	}

	public void b(NBTCompoundTag var1) {
		super.b(var1);
		var1.a("Anger", (short) this.bl);
		if (this.bn != null) {
			var1.a("HurtBy", this.bn.toString());
		} else {
			var1.a("HurtBy", "");
		}

	}

	public void a(NBTCompoundTag var1) {
		super.a(var1);
		this.bl = var1.e("Anger");
		String var2 = var1.j("HurtBy");
		if (var2.length() > 0) {
			this.bn = UUID.fromString(var2);
			ahd var3 = this.o.b(this.bn);
			this.b((EntityLiving) var3);
			if (var3 != null) {
				this.aL = var3;
				this.aM = this.bd();
			}
		}

	}

	public boolean a(wh var1, float var2) {
		if (this.b(var1)) {
			return false;
		} else {
			Entity var3 = var1.j();
			if (var3 instanceof ahd) {
				this.b(var3);
			}

			return super.a(var1, var2);
		}
	}

	private void b(Entity var1) {
		this.bl = 400 + this.V.nextInt(400);
		this.bm = this.V.nextInt(40);
		if (var1 instanceof EntityLiving) {
			this.b((EntityLiving) var1);
		}

	}

	public boolean ck() {
		return this.bl > 0;
	}

	protected String z() {
		return "mob.zombiepig.zpig";
	}

	protected String bn() {
		return "mob.zombiepig.zpighurt";
	}

	protected String bo() {
		return "mob.zombiepig.zpigdeath";
	}

	protected void b(boolean var1, int var2) {
		int var3 = this.V.nextInt(2 + var2);

		int var4;
		for (var4 = 0; var4 < var3; ++var4) {
			this.a(amk.bt, 1);
		}

		var3 = this.V.nextInt(2 + var2);

		for (var4 = 0; var4 < var3; ++var4) {
			this.a(amk.bx, 1);
		}

	}

	public boolean a(ahd var1) {
		return false;
	}

	protected void bp() {
		this.a(amk.k, 1);
	}

	protected void a(vu var1) {
		this.c(0, new amj(amk.B));
	}

	public xq a(vu var1, xq var2) {
		super.a(var1, var2);
		this.m(false);
		return var2;
	}

	// $FF: synthetic method
	static void a(afo var0, Entity var1) {
		var0.b(var1);
	}

}

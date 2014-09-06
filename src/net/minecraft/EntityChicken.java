package net.minecraft;

public class EntityChicken extends abq {

	public float bk;
	public float bm;
	public float bn;
	public float bo;
	public float bp = 1.0F;
	public int bq;
	public boolean br;

	public EntityChicken(World var1) {
		super(var1);
		this.a(0.4F, 0.7F);
		this.bq = this.V.nextInt(6000) + 6000;
		this.i.a(0, new yy(this));
		this.i.a(1, new zu(this, 1.4D));
		this.i.a(2, new yt(this, 1.0D));
		this.i.a(3, new aag(this, 1.0D, Items.N, false));
		this.i.a(4, new za(this, 1.1D));
		this.i.a(5, new zy(this, 1.0D));
		this.i.a(6, new zh(this, EntityHuman.class, 6.0F));
		this.i.a(7, new zx(this));
	}

	public float aR() {
		return this.K;
	}

	protected void aW() {
		super.aW();
		this.a(afs.a).a(4.0D);
		this.a(afs.d).a(0.25D);
	}

	public void m() {
		super.m();
		this.bo = this.bk;
		this.bn = this.bm;
		this.bm = (float) ((double) this.bm + (double) (this.onGround ? -1 : 4) * 0.3D);
		this.bm = DataTypesConverter.a(this.bm, 0.0F, 1.0F);
		if (!this.onGround && this.bp < 1.0F) {
			this.bp = 1.0F;
		}

		this.bp = (float) ((double) this.bp * 0.9D);
		if (!this.onGround && this.motionY < 0.0D) {
			this.motionY *= 0.6D;
		}

		this.bk += this.bp * 2.0F;
		if (!this.o.D && !this.i_() && !this.cj() && --this.bq <= 0) {
			this.a("mob.chicken.plop", 1.0F, (this.V.nextFloat() - this.V.nextFloat()) * 0.2F + 1.0F);
			this.a(Items.aP, 1);
			this.bq = this.V.nextInt(6000) + 6000;
		}

	}

	public void e(float var1, float var2) {
	}

	protected String z() {
		return "mob.chicken.say";
	}

	protected String bn() {
		return "mob.chicken.hurt";
	}

	protected String bo() {
		return "mob.chicken.hurt";
	}

	protected void a(Position var1, Block var2) {
		this.a("mob.chicken.step", 0.15F, 1.0F);
	}

	protected Item A() {
		return Items.G;
	}

	protected void b(boolean var1, int var2) {
		int var3 = this.V.nextInt(3) + this.V.nextInt(1 + var2);

		for (int var4 = 0; var4 < var3; ++var4) {
			this.a(Items.G, 1);
		}

		if (this.au()) {
			this.a(Items.bl, 1);
		} else {
			this.a(Items.bk, 1);
		}

	}

	public EntityChicken b(ws var1) {
		return new EntityChicken(this.o);
	}

	public boolean d(ItemStack var1) {
		return var1 != null && var1.getItem() == Items.N;
	}

	public void a(NBTCompoundTag var1) {
		super.a(var1);
		this.br = var1.getBoolean("IsChickenJockey");
		if (var1.hasKey("EggLayTime")) {
			this.bq = var1.getInt("EggLayTime");
		}

	}

	protected int b(EntityHuman var1) {
		return this.cj() ? 10 : super.b(var1);
	}

	public void b(NBTCompoundTag var1) {
		super.b(var1);
		var1.put("IsChickenJockey", this.br);
		var1.put("EggLayTime", this.bq);
	}

	protected boolean C() {
		return this.cj() && this.l == null;
	}

	public void al() {
		super.al();
		float var1 = DataTypesConverter.a(this.aG * 3.1415927F / 180.0F);
		float var2 = DataTypesConverter.b(this.aG * 3.1415927F / 180.0F);
		float var3 = 0.1F;
		float var4 = 0.0F;
		this.l.b(this.locationX + (double) (var3 * var1), this.locationY + (double) (this.K * 0.5F) + this.l.am() + (double) var4, this.locationZ - (double) (var3 * var2));
		if (this.l instanceof EntityLiving) {
			((EntityLiving) this.l).aG = this.aG;
		}

	}

	public boolean cj() {
		return this.br;
	}

	public void l(boolean var1) {
		this.br = var1;
	}

	// $FF: synthetic method
	public ws a(ws var1) {
		return this.b(var1);
	}
}

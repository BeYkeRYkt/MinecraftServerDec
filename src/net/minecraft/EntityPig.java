package net.minecraft;

public class EntityPig extends abq {

	private final yu bk;

	public EntityPig(World var1) {
		super(var1);
		this.a(0.9F, 0.9F);
		((aay) this.s()).a(true);
		this.i.a(0, new yy(this));
		this.i.a(1, new zu(this, 1.25D));
		this.i.a(2, this.bk = new yu(this, 0.3F));
		this.i.a(3, new yt(this, 1.0D));
		this.i.a(4, new aag(this, 1.2D, Items.CARROT_ON_A_STICK, false));
		this.i.a(4, new aag(this, 1.2D, Items.CARROT, false));
		this.i.a(5, new za(this, 1.1D));
		this.i.a(6, new zy(this, 1.0D));
		this.i.a(7, new zh(this, EntityHuman.class, 6.0F));
		this.i.a(8, new zx(this));
	}

	protected void aW() {
		super.aW();
		this.a(afs.a).a(10.0D);
		this.a(afs.d).a(0.25D);
	}

	public boolean bV() {
		ItemStack var1 = ((EntityHuman) this.l).bz();
		return var1 != null && var1.getItem() == Items.CARROT_ON_A_STICK;
	}

	protected void h() {
		super.h();
		this.dataWatcher.a(16, Byte.valueOf((byte) 0));
	}

	public void b(NBTCompoundTag var1) {
		super.b(var1);
		var1.put("Saddle", this.cj());
	}

	public void a(NBTCompoundTag var1) {
		super.a(var1);
		this.l(var1.getBoolean("Saddle"));
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

	protected void a(Position var1, Block var2) {
		this.a("mob.pig.step", 0.15F, 1.0F);
	}

	public boolean a(EntityHuman var1) {
		if (super.a(var1)) {
			return true;
		} else if (this.cj() && !this.o.D && (this.l == null || this.l == var1)) {
			var1.a((Entity) this);
			return true;
		} else {
			return false;
		}
	}

	protected Item A() {
		return this.au() ? Items.COOCKED_PORKCHOP : Items.PORKCHOP;
	}

	protected void b(boolean var1, int var2) {
		int var3 = this.V.nextInt(3) + 1 + this.V.nextInt(1 + var2);

		for (int var4 = 0; var4 < var3; ++var4) {
			if (this.au()) {
				this.a(Items.COOCKED_PORKCHOP, 1);
			} else {
				this.a(Items.PORKCHOP, 1);
			}
		}

		if (this.cj()) {
			this.a(Items.SADDLE, 1);
		}

	}

	public boolean cj() {
		return (this.dataWatcher.a(16) & 1) != 0;
	}

	public void l(boolean var1) {
		if (var1) {
			this.dataWatcher.b(16, Byte.valueOf((byte) 1));
		} else {
			this.dataWatcher.b(16, Byte.valueOf((byte) 0));
		}

	}

	public void a(EntityLightning var1) {
		if (!this.o.D) {
			EntityPigZombie var2 = new EntityPigZombie(this.o);
			var2.c(0, new ItemStack(Items.GOLDEN_SWORD));
			var2.b(this.locationX, this.locationY, this.locationZ, this.yaw, this.pitch);
			this.o.d((Entity) var2);
			this.J();
		}
	}

	public void e(float var1, float var2) {
		super.e(var1, var2);
		if (var1 > 5.0F && this.l instanceof EntityHuman) {
			((EntityHuman) this.l).b((Statistic) AchievementList.u);
		}

	}

	public EntityPig b(ws var1) {
		return new EntityPig(this.o);
	}

	public boolean d(ItemStack var1) {
		return var1 != null && var1.getItem() == Items.CARROT;
	}

	public yu ck() {
		return this.bk;
	}

	// $FF: synthetic method
	public ws a(ws var1) {
		return this.b(var1);
	}
}

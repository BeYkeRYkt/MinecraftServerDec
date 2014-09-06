package net.minecraft;

public class EntityCreeper extends EntityMonster {

	private int b;
	private int c;
	private int bk = 30;
	private int bl = 3;
	private int bm = 0;

	public EntityCreeper(World var1) {
		super(var1);
		this.i.a(1, new yy(this));
		this.i.a(2, new aae(this));
		this.i.a(2, this.a);
		this.i.a(3, new yp(this, new aeq(this), 6.0F, 1.0D, 1.2D));
		this.i.a(4, new zk(this, 1.0D, false));
		this.i.a(5, new zy(this, 0.8D));
		this.i.a(6, new zh(this, EntityHuman.class, 8.0F));
		this.i.a(6, new zx(this));
		this.bg.a(1, new aaq(this, EntityHuman.class, true));
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
		this.dataWatcher.a(16, Byte.valueOf((byte) -1));
		this.dataWatcher.a(17, Byte.valueOf((byte) 0));
		this.dataWatcher.a(18, Byte.valueOf((byte) 0));
	}

	public void b(NBTCompoundTag var1) {
		super.b(var1);
		if (this.dataWatcher.a(17) == 1) {
			var1.put("powered", true);
		}

		var1.put("Fuse", (short) this.bk);
		var1.put("ExplosionRadius", (byte) this.bl);
		var1.put("ignited", this.cl());
	}

	public void a(NBTCompoundTag var1) {
		super.a(var1);
		this.dataWatcher.b(17, Byte.valueOf((byte) (var1.getBoolean("powered") ? 1 : 0)));
		if (var1.isTagAssignableFrom("Fuse", 99)) {
			this.bk = var1.getShort("Fuse");
		}

		if (var1.isTagAssignableFrom("ExplosionRadius", 99)) {
			this.bl = var1.getByte("ExplosionRadius");
		}

		if (var1.getBoolean("ignited")) {
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

	public void a(DamageSource var1) {
		super.a(var1);
		if (var1.j() instanceof EntitySkeleton) {
			int var2 = Item.getId(Items.cq);
			int var3 = Item.getId(Items.cB);
			int var4 = var2 + this.V.nextInt(var3 - var2 + 1);
			this.a(Item.getById(var4), 1);
		} else if (var1.j() instanceof EntityCreeper && var1.j() != this && ((EntityCreeper) var1.j()).n() && ((EntityCreeper) var1.j()).cn()) {
			((EntityCreeper) var1.j()).co();
			this.a(new ItemStack(Items.bX, 1, 4), 0.0F);
		}

	}

	public boolean r(Entity var1) {
		return true;
	}

	public boolean n() {
		return this.dataWatcher.a(17) == 1;
	}

	protected Item A() {
		return Items.H;
	}

	public int ck() {
		return this.dataWatcher.a(16);
	}

	public void a(int var1) {
		this.dataWatcher.b(16, Byte.valueOf((byte) var1));
	}

	public void a(EntityLightning var1) {
		super.a(var1);
		this.dataWatcher.b(17, Byte.valueOf((byte) 1));
	}

	protected boolean a(EntityHuman var1) {
		ItemStack var2 = var1.playerInventory.getItemInHand();
		if (var2 != null && var2.getItem() == Items.d) {
			this.o.a(this.locationX + 0.5D, this.locationY + 0.5D, this.locationZ + 0.5D, "fire.ignite", 1.0F, this.V.nextFloat() * 0.4F + 0.8F);
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
			this.o.a(this, this.locationX, this.locationY, this.locationZ, (float) this.bl * var2, var1);
			this.J();
		}

	}

	public boolean cl() {
		return this.dataWatcher.a(18) != 0;
	}

	public void cm() {
		this.dataWatcher.b(18, Byte.valueOf((byte) 1));
	}

	public boolean cn() {
		return this.bm < 1 && this.o.Q().b("doMobLoot");
	}

	public void co() {
		++this.bm;
	}
}

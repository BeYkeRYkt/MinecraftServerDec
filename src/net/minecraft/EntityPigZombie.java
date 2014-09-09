package net.minecraft;

import java.util.UUID;

public class EntityPigZombie extends EntityZombie {

	private static final UUID c = UUID.fromString("49455A49-7EC5-45BA-B886-3B90B23A1718");
	private static final AttributeModifier bk = (new AttributeModifier(c, "Attacking speed boost", 0.05D, 0)).setSerializable(false);
	private int bl;
	private int bm;
	private UUID bn;

	public EntityPigZombie(World var1) {
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
		AttributeInstance var1 = this.a(afs.d);
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
			EntityHuman var2 = this.world.b(this.bn);
			this.b((EntityLiving) var2);
			this.aL = var2;
			this.aM = this.bd();
		}

		super.E();
	}

	public boolean bQ() {
		return this.world.getDifficulty() != Difficulty.PEACEFUL;
	}

	public boolean bR() {
		return this.world.a(this.getBoundingBox(), (Entity) this) && this.world.getCubes((Entity) this, this.getBoundingBox()).isEmpty() && !this.world.d(this.getBoundingBox());
	}

	public void b(NBTCompoundTag var1) {
		super.b(var1);
		var1.put("Anger", (short) this.bl);
		if (this.bn != null) {
			var1.put("HurtBy", this.bn.toString());
		} else {
			var1.put("HurtBy", "");
		}

	}

	public void a(NBTCompoundTag var1) {
		super.a(var1);
		this.bl = var1.getShort("Anger");
		String var2 = var1.getString("HurtBy");
		if (var2.length() > 0) {
			this.bn = UUID.fromString(var2);
			EntityHuman var3 = this.world.b(this.bn);
			this.b((EntityLiving) var3);
			if (var3 != null) {
				this.aL = var3;
				this.aM = this.bd();
			}
		}

	}

	public boolean a(DamageSource var1, float var2) {
		if (this.b(var1)) {
			return false;
		} else {
			Entity var3 = var1.j();
			if (var3 instanceof EntityHuman) {
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
			this.a(Items.ROTTEN_FLESH, 1);
		}

		var3 = this.V.nextInt(2 + var2);

		for (var4 = 0; var4 < var3; ++var4) {
			this.a(Items.GOLD_NUGGET, 1);
		}

	}

	public boolean a(EntityHuman var1) {
		return false;
	}

	protected void bp() {
		this.a(Items.GOLD_INGOT, 1);
	}

	protected void a(vu var1) {
		this.setArmor(0, new ItemStack(Items.GOLDEN_SWORD));
	}

	public xq a(vu var1, xq var2) {
		super.a(var1, var2);
		this.m(false);
		return var2;
	}

	// $FF: synthetic method
	static void a(EntityPigZombie var0, Entity var1) {
		var0.b(var1);
	}

}

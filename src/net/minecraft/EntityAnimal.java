package net.minecraft;

public abstract class EntityAnimal extends EntityAgeable implements IAnimal {

	protected Block bl;
	private int bk;
	private EntityHuman bm;

	public EntityAnimal(World var1) {
		super(var1);
		this.bl = Blocks.GRASS;
	}

	protected void E() {
		if (this.l() != 0) {
			this.bk = 0;
		}

		super.E();
	}

	public void m() {
		super.m();
		if (this.l() != 0) {
			this.bk = 0;
		}

		if (this.bk > 0) {
			--this.bk;
			if (this.bk % 10 == 0) {
				double var1 = this.V.nextGaussian() * 0.02D;
				double var3 = this.V.nextGaussian() * 0.02D;
				double var5 = this.V.nextGaussian() * 0.02D;
				this.world.a(Particle.I, this.locationX + (double) (this.V.nextFloat() * this.J * 2.0F) - (double) this.J, this.locationY + 0.5D + (double) (this.V.nextFloat() * this.K), this.locationZ + (double) (this.V.nextFloat() * this.J * 2.0F) - (double) this.J, var1, var3, var5, new int[0]);
			}
		}

	}

	public boolean a(DamageSource var1, float var2) {
		if (this.b(var1)) {
			return false;
		} else {
			this.bk = 0;
			return super.a(var1, var2);
		}
	}

	public float a(Position var1) {
		return this.world.getBlockState(var1.b()).getBlock() == Blocks.GRASS ? 10.0F : this.world.o(var1) - 0.5F;
	}

	public void b(NBTCompoundTag var1) {
		super.b(var1);
		var1.put("InLove", this.bk);
	}

	public void a(NBTCompoundTag var1) {
		super.a(var1);
		this.bk = var1.getInt("InLove");
	}

	public boolean bQ() {
		int var1 = MathHelper.toFixedPointInt(this.locationX);
		int var2 = MathHelper.toFixedPointInt(this.getBoundingBox().minY);
		int var3 = MathHelper.toFixedPointInt(this.locationZ);
		Position var4 = new Position(var1, var2, var3);
		return this.world.getBlockState(var4.b()).getBlock() == this.bl && this.world.k(var4) > 8 && super.bQ();
	}

	public int w() {
		return 120;
	}

	protected boolean C() {
		return false;
	}

	protected int b(EntityHuman var1) {
		return 1 + this.world.s.nextInt(3);
	}

	public boolean d(ItemStack var1) {
		return var1 == null ? false : var1.getItem() == Items.WHEAT;
	}

	public boolean a(EntityHuman var1) {
		ItemStack var2 = var1.playerInventory.getItemInHand();
		if (var2 != null) {
			if (this.d(var2) && this.l() == 0 && this.bk <= 0) {
				this.a(var1, var2);
				this.c(var1);
				return true;
			}

			if (this.i_() && this.d(var2)) {
				this.a(var1, var2);
				this.a((int) ((float) (-this.l() / 20) * 0.1F), true);
				return true;
			}
		}

		return super.a(var1);
	}

	protected void a(EntityHuman var1, ItemStack var2) {
		if (!var1.playerProperties.instabuild) {
			--var2.amount;
			if (var2.amount <= 0) {
				var1.playerInventory.a(var1.playerInventory.itemInHandIndex, (ItemStack) null);
			}
		}

	}

	public void c(EntityHuman var1) {
		this.bk = 600;
		this.bm = var1;
		this.world.a((Entity) this, (byte) 18);
	}

	public EntityHuman co() {
		return this.bm;
	}

	public boolean cp() {
		return this.bk > 0;
	}

	public void cq() {
		this.bk = 0;
	}

	public boolean a(EntityAnimal var1) {
		return var1 == this ? false : (var1.getClass() != this.getClass() ? false : this.cp() && var1.cp());
	}
}

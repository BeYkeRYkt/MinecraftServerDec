package net.minecraft;

public class EntityMinecartTNT extends adx {

	private int a = -1;

	public EntityMinecartTNT(World var1) {
		super(var1);
	}

	public EntityMinecartTNT(World var1, double var2, double var4, double var6) {
		super(var1, var2, var4, var6);
	}

	public MinecartType getType() {
		return MinecartType.TNT;
	}

	public IBlockState u() {
		return Blocks.TNT.getBlockState();
	}

	public void s_() {
		super.s_();
		if (this.a > 0) {
			--this.a;
			this.world.addParticle(Particle.l, this.locationX, this.locationY + 0.5D, this.locationZ, 0.0D, 0.0D, 0.0D, new int[0]);
		} else if (this.a == 0) {
			this.b(this.motionX * this.motionX + this.motionZ * this.motionZ);
		}

		if (this.positionChanged) {
			double var1 = this.motionX * this.motionX + this.motionZ * this.motionZ;
			if (var1 >= 0.009999999776482582D) {
				this.b(var1);
			}
		}

	}

	public boolean damageEntity(DamageSource var1, float var2) {
		Entity var3 = var1.i();
		if (var3 instanceof EntityArrow) {
			EntityArrow var4 = (EntityArrow) var3;
			if (var4.au()) {
				this.b(var4.motionX * var4.motionX + var4.motionY * var4.motionY + var4.motionZ * var4.motionZ);
			}
		}

		return super.damageEntity(var1, var2);
	}

	public void a(DamageSource var1) {
		super.a(var1);
		double var2 = this.motionX * this.motionX + this.motionZ * this.motionZ;
		if (!var1.c()) {
			this.a(new ItemStack(Blocks.TNT, 1), 0.0F);
		}

		if (var1.o() || var1.c() || var2 >= 0.009999999776482582D) {
			this.b(var2);
		}

	}

	protected void b(double var1) {
		if (!this.world.isStatic) {
			double var3 = Math.sqrt(var1);
			if (var3 > 5.0D) {
				var3 = 5.0D;
			}

			this.world.createExplosion(this, this.locationX, this.locationY, this.locationZ, (float) (4.0D + this.random.nextDouble() * 1.5D * var3), true);
			this.die();
		}

	}

	public void e(float var1, float var2) {
		if (var1 >= 3.0F) {
			float var3 = var1 / 10.0F;
			this.b((double) (var3 * var3));
		}

		super.e(var1, var2);
	}

	public void a(int var1, int var2, int var3, boolean var4) {
		if (var4 && this.a < 0) {
			this.j();
		}

	}

	public void j() {
		this.a = 80;
		if (!this.world.isStatic) {
			this.world.broadcastEntityEffect((Entity) this, (byte) 10);
			if (!this.isSilent()) {
				this.world.a((Entity) this, "game.tnt.primed", 1.0F, 1.0F);
			}
		}

	}

	public boolean y() {
		return this.a > -1;
	}

	public float a(Explosion var1, World var2, Position var3, IBlockState var4) {
		return this.y() && (ati.d(var4) || ati.d(var2, var3.getUp())) ? 0.0F : super.a(var1, var2, var3, var4);
	}

	public boolean a(Explosion var1, World var2, Position var3, IBlockState var4, float var5) {
		return this.y() && (ati.d(var4) || ati.d(var2, var3.getUp())) ? false : super.a(var1, var2, var3, var4, var5);
	}

	protected void a(NBTCompoundTag var1) {
		super.a(var1);
		if (var1.isTagAssignableFrom("TNTFuse", 99)) {
			this.a = var1.getInt("TNTFuse");
		}

	}

	protected void b(NBTCompoundTag var1) {
		super.b(var1);
		var1.put("TNTFuse", this.a);
	}
}

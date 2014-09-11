package net.minecraft;

public class EntityExpirienceOrb extends Entity {

	public int a;
	public int b;
	public int c;
	private int d = 5;
	private int e;
	private EntityHuman f;
	private int g;

	public EntityExpirienceOrb(World var1, double var2, double var4, double var6, int var8) {
		super(var1);
		this.a(0.5F, 0.5F);
		this.b(var2, var4, var6);
		this.yaw = (float) (Math.random() * 360.0D);
		this.motionX = (double) ((float) (Math.random() * 0.20000000298023224D - 0.10000000149011612D) * 2.0F);
		this.motionY = (double) ((float) (Math.random() * 0.2D) * 2.0F);
		this.motionZ = (double) ((float) (Math.random() * 0.20000000298023224D - 0.10000000149011612D) * 2.0F);
		this.e = var8;
	}

	protected boolean r_() {
		return false;
	}

	public EntityExpirienceOrb(World var1) {
		super(var1);
		this.a(0.25F, 0.25F);
	}

	protected void h() {
	}

	public void s_() {
		super.s_();
		if (this.c > 0) {
			--this.c;
		}

		this.p = this.locationX;
		this.q = this.locationY;
		this.r = this.locationZ;
		this.motionY -= 0.029999999329447746D;
		if (this.world.getBlockState(new Position(this)).getBlock().getMaterial() == Material.LAVA) {
			this.motionY = 0.20000000298023224D;
			this.motionX = (double) ((this.V.nextFloat() - this.V.nextFloat()) * 0.2F);
			this.motionZ = (double) ((this.V.nextFloat() - this.V.nextFloat()) * 0.2F);
			this.a("random.fizz", 0.4F, 2.0F + this.V.nextFloat() * 0.4F);
		}

		this.j(this.locationX, (this.getBoundingBox().minY + this.getBoundingBox().maxY) / 2.0D, this.locationZ);
		double var1 = 8.0D;
		if (this.g < this.a - 20 + this.getId() % 100) {
			if (this.f == null || this.f.getDistanceSquared(this) > var1 * var1) {
				this.f = this.world.a(this, var1);
			}

			this.g = this.a;
		}

		if (this.f != null && this.f.isSpectator()) {
			this.f = null;
		}

		if (this.f != null) {
			double var3 = (this.f.locationX - this.locationX) / var1;
			double var5 = (this.f.locationY + (double) this.f.aR() - this.locationY) / var1;
			double var7 = (this.f.locationZ - this.locationZ) / var1;
			double var9 = Math.sqrt(var3 * var3 + var5 * var5 + var7 * var7);
			double var11 = 1.0D - var9;
			if (var11 > 0.0D) {
				var11 *= var11;
				this.motionX += var3 / var9 * var11 * 0.1D;
				this.motionY += var5 / var9 * var11 * 0.1D;
				this.motionZ += var7 / var9 * var11 * 0.1D;
			}
		}

		this.move(this.motionX, this.motionY, this.motionZ);
		float var13 = 0.98F;
		if (this.onGround) {
			var13 = this.world.getBlockState(new Position(MathHelper.toFixedPointInt(this.locationX), MathHelper.toFixedPointInt(this.getBoundingBox().minY) - 1, MathHelper.toFixedPointInt(this.locationZ))).getBlock().K * 0.98F;
		}

		this.motionX *= (double) var13;
		this.motionY *= 0.9800000190734863D;
		this.motionZ *= (double) var13;
		if (this.onGround) {
			this.motionY *= -0.8999999761581421D;
		}

		++this.a;
		++this.b;
		if (this.b >= 6000) {
			this.die();
		}

	}

	public boolean W() {
		return this.world.a(this.getBoundingBox(), Material.WATER, (Entity) this);
	}

	protected void f(int var1) {
		this.a(DamageSource.a, (float) var1);
	}

	public boolean a(DamageSource var1, float var2) {
		if (this.b(var1)) {
			return false;
		} else {
			this.ac();
			this.d = (int) ((float) this.d - var2);
			if (this.d <= 0) {
				this.die();
			}

			return false;
		}
	}

	public void b(NBTCompoundTag var1) {
		var1.put("Health", (short) ((byte) this.d));
		var1.put("Age", (short) this.b);
		var1.put("Value", (short) this.e);
	}

	public void a(NBTCompoundTag var1) {
		this.d = var1.getShort("Health") & 255;
		this.b = var1.getShort("Age");
		this.e = var1.getShort("Value");
	}

	public void d(EntityHuman var1) {
		if (!this.world.isStatic) {
			if (this.c == 0 && var1.bn == 0) {
				var1.bn = 2;
				this.world.a((Entity) var1, "random.orb", 0.1F, 0.5F * ((this.V.nextFloat() - this.V.nextFloat()) * 0.7F + 1.8F));
				var1.a((Entity) this, 1);
				var1.u(this.e);
				this.die();
			}

		}
	}

	public int getExp() {
		return this.e;
	}

	public static int a(int var0) {
		return var0 >= 2477 ? 2477 : (var0 >= 1237 ? 1237 : (var0 >= 617 ? 617 : (var0 >= 307 ? 307 : (var0 >= 149 ? 149 : (var0 >= 73 ? 73 : (var0 >= 37 ? 37 : (var0 >= 17 ? 17 : (var0 >= 7 ? 7 : (var0 >= 3 ? 3 : 1)))))))));
	}

	public boolean aE() {
		return false;
	}
}

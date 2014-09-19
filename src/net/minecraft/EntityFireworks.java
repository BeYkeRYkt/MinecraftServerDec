package net.minecraft;

public class EntityFireworks extends Entity {

	private int a;
	private int b;

	public EntityFireworks(World var1) {
		super(var1);
		this.a(0.25F, 0.25F);
	}

	protected void h() {
		this.dataWatcher.a(8, 5);
	}

	public EntityFireworks(World var1, double var2, double var4, double var6, ItemStack var8) {
		super(var1);
		this.a = 0;
		this.a(0.25F, 0.25F);
		this.b(var2, var4, var6);
		int var9 = 1;
		if (var8 != null && var8.hasTag()) {
			this.dataWatcher.b(8, var8);
			NBTCompoundTag var10 = var8.getTag();
			NBTCompoundTag var11 = var10.getCompound("Fireworks");
			if (var11 != null) {
				var9 += var11.getByte("Flight");
			}
		}

		this.motionX = this.random.nextGaussian() * 0.001D;
		this.motionZ = this.random.nextGaussian() * 0.001D;
		this.motionY = 0.05D;
		this.b = 10 * var9 + this.random.nextInt(6) + this.random.nextInt(7);
	}

	public void s_() {
		this.P = this.locationX;
		this.Q = this.locationY;
		this.R = this.locationZ;
		super.s_();
		this.motionX *= 1.15D;
		this.motionZ *= 1.15D;
		this.motionY += 0.04D;
		this.move(this.motionX, this.motionY, this.motionZ);
		float var1 = MathHelper.sqrt(this.motionX * this.motionX + this.motionZ * this.motionZ);
		this.yaw = (float) (Math.atan2(this.motionX, this.motionZ) * 180.0D / 3.1415927410125732D);

		for (this.pitch = (float) (Math.atan2(this.motionY, (double) var1) * 180.0D / 3.1415927410125732D); this.pitch - this.lastPitch < -180.0F; this.lastPitch -= 360.0F) {
			;
		}

		while (this.pitch - this.lastPitch >= 180.0F) {
			this.lastPitch += 360.0F;
		}

		while (this.yaw - this.lastYaw < -180.0F) {
			this.lastYaw -= 360.0F;
		}

		while (this.yaw - this.lastYaw >= 180.0F) {
			this.lastYaw += 360.0F;
		}

		this.pitch = this.lastPitch + (this.pitch - this.lastPitch) * 0.2F;
		this.yaw = this.lastYaw + (this.yaw - this.lastYaw) * 0.2F;
		if (this.a == 0 && !this.isSilent()) {
			this.world.a((Entity) this, "fireworks.launch", 3.0F, 1.0F);
		}

		++this.a;
		if (this.world.isStatic && this.a % 2 < 2) {
			this.world.addParticle(Particle.d, this.locationX, this.locationY - 0.3D, this.locationZ, this.random.nextGaussian() * 0.05D, -this.motionY * 0.5D, this.random.nextGaussian() * 0.05D, new int[0]);
		}

		if (!this.world.isStatic && this.a > this.b) {
			this.world.broadcastEntityEffect((Entity) this, (byte) 17);
			this.die();
		}

	}

	public void b(NBTCompoundTag var1) {
		var1.put("Life", this.a);
		var1.put("LifeTime", this.b);
		ItemStack var2 = this.dataWatcher.f(8);
		if (var2 != null) {
			NBTCompoundTag var3 = new NBTCompoundTag();
			var2.write(var3);
			var1.put("FireworksItem", (NBTTag) var3);
		}

	}

	public void a(NBTCompoundTag var1) {
		this.a = var1.getInt("Life");
		this.b = var1.getInt("LifeTime");
		NBTCompoundTag var2 = var1.getCompound("FireworksItem");
		if (var2 != null) {
			ItemStack var3 = ItemStack.fromNBT(var2);
			if (var3 != null) {
				this.dataWatcher.b(8, var3);
			}
		}

	}

	public float c(float var1) {
		return super.c(var1);
	}

	public boolean aE() {
		return false;
	}
}

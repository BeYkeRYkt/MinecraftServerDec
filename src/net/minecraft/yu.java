package net.minecraft;

public class yu extends PathfinderGoal {

	private final EntityInsentient a;
	private final float b;
	private float c;
	private boolean d;
	private int e;
	private int f;

	public yu(EntityInsentient var1, float var2) {
		this.a = var1;
		this.b = var2;
		this.a(7);
	}

	public void c() {
		this.c = 0.0F;
	}

	public void d() {
		this.d = false;
		this.c = 0.0F;
	}

	public boolean a() {
		return this.a.isAlive() && this.a.passenger != null && this.a.passenger instanceof EntityHuman && (this.d || this.a.bV());
	}

	public void e() {
		EntityHuman var1 = (EntityHuman) this.a.passenger;
		EntityCreature var2 = (EntityCreature) this.a;
		float var3 = MathHelper.g(var1.yaw - this.a.yaw) * 0.5F;
		if (var3 > 5.0F) {
			var3 = 5.0F;
		}

		if (var3 < -5.0F) {
			var3 = -5.0F;
		}

		this.a.yaw = MathHelper.g(this.a.yaw + var3);
		if (this.c < this.b) {
			this.c += (this.b - this.c) * 0.01F;
		}

		if (this.c > this.b) {
			this.c = this.b;
		}

		int var4 = MathHelper.toFixedPointInt(this.a.locationX);
		int var5 = MathHelper.toFixedPointInt(this.a.locationY);
		int var6 = MathHelper.toFixedPointInt(this.a.locationZ);
		float var7 = this.c;
		if (this.d) {
			if (this.e++ > this.f) {
				this.d = false;
			}

			var7 += var7 * 1.15F * MathHelper.a((float) this.e / (float) this.f * 3.1415927F);
		}

		float var8 = 0.91F;
		if (this.a.onGround) {
			var8 = this.a.world.getBlockState(new Position(MathHelper.d((float) var4), MathHelper.d((float) var5) - 1, MathHelper.d((float) var6))).getBlock().K * 0.91F;
		}

		float var9 = 0.16277136F / (var8 * var8 * var8);
		float var10 = MathHelper.a(var2.yaw * 3.1415927F / 180.0F);
		float var11 = MathHelper.b(var2.yaw * 3.1415927F / 180.0F);
		float var12 = var2.bH() * var9;
		float var13 = Math.max(var7, 1.0F);
		var13 = var12 / var13;
		float var14 = var7 * var13;
		float var15 = -(var14 * var10);
		float var16 = var14 * var11;
		if (MathHelper.e(var15) > MathHelper.e(var16)) {
			if (var15 < 0.0F) {
				var15 -= this.a.height / 2.0F;
			}

			if (var15 > 0.0F) {
				var15 += this.a.height / 2.0F;
			}

			var16 = 0.0F;
		} else {
			var15 = 0.0F;
			if (var16 < 0.0F) {
				var16 -= this.a.height / 2.0F;
			}

			if (var16 > 0.0F) {
				var16 += this.a.height / 2.0F;
			}
		}

		int var17 = MathHelper.toFixedPointInt(this.a.locationX + (double) var15);
		int var18 = MathHelper.toFixedPointInt(this.a.locationZ + (double) var16);
		int var19 = MathHelper.d(this.a.height + 1.0F);
		int var20 = MathHelper.d(this.a.width + var1.width + 1.0F);
		int var21 = MathHelper.d(this.a.height + 1.0F);
		if (var4 != var17 || var6 != var18) {
			Block var22 = this.a.world.getBlockState(new Position(var4, var5, var6)).getBlock();
			boolean var23 = !this.a(var22) && (var22.getMaterial() != Material.AIR || !this.a(this.a.world.getBlockState(new Position(var4, var5 - 1, var6)).getBlock()));
			if (var23 && 0 == bpy.a(this.a.world, this.a, var17, var5, var18, var19, var20, var21, false, false, true) && 1 == bpy.a(this.a.world, this.a, var4, var5 + 1, var6, var19, var20, var21, false, false, true) && 1 == bpy.a(this.a.world, this.a, var17, var5 + 1, var18, var19, var20, var21, false, false, true)) {
				var2.r().a();
			}
		}

		if (!var1.playerProperties.instabuild && this.c >= this.b * 0.5F && this.a.bb().nextFloat() < 0.006F && !this.d) {
			ItemStack var24 = var1.getItemInHand();
			if (var24 != null && var24.getItem() == Items.CARROT_ON_A_STICK) {
				var24.a(1, (EntityLiving) var1);
				if (var24.amount == 0) {
					ItemStack var25 = new ItemStack(Items.FISHING_ROD);
					var25.setTag(var24.getTag());
					var1.playerInventory.contents[var1.playerInventory.itemInHandIndex] = var25;
				}
			}
		}

		this.a.g(0.0F, var7);
	}

	private boolean a(Block var1) {
		return var1 instanceof BlockStairs || var1 instanceof BlockStepAbstract;
	}

	public boolean f() {
		return this.d;
	}

	public void g() {
		this.d = true;
		this.e = 0;
		this.f = this.a.bb().nextInt(841) + 140;
	}

	public boolean h() {
		return !this.f() && this.c > this.b * 0.3F;
	}
}

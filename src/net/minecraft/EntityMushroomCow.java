package net.minecraft;

public class EntityMushroomCow extends EntityCow {

	public EntityMushroomCow(World var1) {
		super(var1);
		this.a(0.9F, 1.3F);
		this.bl = Blocks.MYCELIUM;
	}

	public boolean a(EntityHuman var1) {
		ItemStack var2 = var1.playerInventory.getItemInHand();
		if (var2 != null && var2.getItem() == Items.BOWL && this.l() >= 0) {
			if (var2.amount == 1) {
				var1.playerInventory.a(var1.playerInventory.itemInHandIndex, new ItemStack(Items.MUSHROOM_STEW));
				return true;
			}

			if (var1.playerInventory.a(new ItemStack(Items.MUSHROOM_STEW)) && !var1.playerProperties.instabuild) {
				var1.playerInventory.a(var1.playerInventory.itemInHandIndex, 1);
				return true;
			}
		}

		if (var2 != null && var2.getItem() == Items.SHEARS && this.l() >= 0) {
			this.die();
			this.world.a(Particle.b, this.locationX, this.locationY + (double) (this.K / 2.0F), this.locationZ, 0.0D, 0.0D, 0.0D, new int[0]);
			if (!this.world.isStatic) {
				EntityCow var3 = new EntityCow(this.world);
				var3.setPositionRotation(this.locationX, this.locationY, this.locationZ, this.yaw, this.pitch);
				var3.h(this.getHealth());
				var3.aG = this.aG;
				if (this.k_()) {
					var3.a(this.aL());
				}

				this.world.addEntity((Entity) var3);

				for (int var4 = 0; var4 < 5; ++var4) {
					this.world.addEntity((Entity) (new EntityItem(this.world, this.locationX, this.locationY + (double) this.K, this.locationZ, new ItemStack(Blocks.RED_MUSHROOM))));
				}

				var2.a(1, (EntityLiving) var1);
				this.a("mob.sheep.shear", 1.0F, 1.0F);
			}

			return true;
		} else {
			return super.a(var1);
		}
	}

	public EntityMushroomCow c(EntityAgeable var1) {
		return new EntityMushroomCow(this.world);
	}

	// $FF: synthetic method
	public EntityCow b(EntityAgeable var1) {
		return this.c(var1);
	}

	// $FF: synthetic method
	public EntityAgeable a(EntityAgeable var1) {
		return this.c(var1);
	}
}

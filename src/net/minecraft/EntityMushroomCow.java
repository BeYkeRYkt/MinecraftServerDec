package net.minecraft;

public class EntityMushroomCow extends EntityCow {

	public EntityMushroomCow(World var1) {
		super(var1);
		this.a(0.9F, 1.3F);
		this.bl = aty.bw;
	}

	public boolean a(EntityHuman var1) {
		ItemStack var2 = var1.playerInventory.getItemInHand();
		if (var2 != null && var2.getItem() == amk.z && this.l() >= 0) {
			if (var2.b == 1) {
				var1.playerInventory.a(var1.playerInventory.c, new ItemStack(amk.A));
				return true;
			}

			if (var1.playerInventory.a(new ItemStack(amk.A)) && !var1.by.instabuild) {
				var1.playerInventory.a(var1.playerInventory.c, 1);
				return true;
			}
		}

		if (var2 != null && var2.getItem() == amk.be && this.l() >= 0) {
			this.J();
			this.o.a(Particle.b, this.locationX, this.locationY + (double) (this.K / 2.0F), this.locationZ, 0.0D, 0.0D, 0.0D, new int[0]);
			if (!this.o.D) {
				EntityCow var3 = new EntityCow(this.o);
				var3.b(this.locationX, this.locationY, this.locationZ, this.yaw, this.pitch);
				var3.h(this.bm());
				var3.aG = this.aG;
				if (this.k_()) {
					var3.a(this.aL());
				}

				this.o.d((Entity) var3);

				for (int var4 = 0; var4 < 5; ++var4) {
					this.o.d((Entity) (new EntityItem(this.o, this.locationX, this.locationY + (double) this.K, this.locationZ, new ItemStack(aty.Q))));
				}

				var2.a(1, (EntityLiving) var1);
				this.a("mob.sheep.shear", 1.0F, 1.0F);
			}

			return true;
		} else {
			return super.a(var1);
		}
	}

	public EntityMushroomCow c(ws var1) {
		return new EntityMushroomCow(this.o);
	}

	// $FF: synthetic method
	public EntityCow b(ws var1) {
		return this.c(var1);
	}

	// $FF: synthetic method
	public ws a(ws var1) {
		return this.c(var1);
	}
}

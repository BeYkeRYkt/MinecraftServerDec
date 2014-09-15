package net.minecraft;

public class EntityMinecartRideable extends adx {

	public EntityMinecartRideable(World var1) {
		super(var1);
	}

	public EntityMinecartRideable(World var1, double var2, double var4, double var6) {
		super(var1, var2, var4, var6);
	}

	public boolean e(EntityHuman var1) {
		if (this.passenger != null && this.passenger instanceof EntityHuman && this.passenger != var1) {
			return true;
		} else if (this.passenger != null && this.passenger != var1) {
			return false;
		} else {
			if (!this.world.isStatic) {
				var1.mount((Entity) this);
			}

			return true;
		}
	}

	public void a(int var1, int var2, int var3, boolean var4) {
		if (var4) {
			if (this.passenger != null) {
				this.passenger.mount((Entity) null);
			}

			if (this.q() == 0) {
				this.k(-this.r());
				this.j(10);
				this.a(50.0F);
				this.ac();
			}
		}

	}

	public MinecartType s() {
		return MinecartType.RIDEABLE;
	}
}

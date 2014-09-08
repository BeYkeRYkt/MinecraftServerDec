package net.minecraft;

public class EntityCaveSpider extends EntitySpider {

	public EntityCaveSpider(World var1) {
		super(var1);
		this.a(0.7F, 0.5F);
	}

	protected void aW() {
		super.aW();
		this.a(afs.a).a(12.0D);
	}

	public boolean r(Entity var1) {
		if (super.r(var1)) {
			if (var1 instanceof EntityLiving) {
				byte var2 = 0;
				if (this.world.getDifficulty() == Difficulty.NORMAL) {
					var2 = 7;
				} else if (this.world.getDifficulty() == Difficulty.HARD) {
					var2 = 15;
				}

				if (var2 > 0) {
					((EntityLiving) var1).c(new MobEffect(MobEffectList.u.H, var2 * 20, 0));
				}
			}

			return true;
		} else {
			return false;
		}
	}

	public xq a(vu var1, xq var2) {
		return var2;
	}

	public float aR() {
		return 0.45F;
	}
}

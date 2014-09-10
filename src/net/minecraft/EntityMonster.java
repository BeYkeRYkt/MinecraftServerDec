package net.minecraft;

public abstract class EntityMonster extends EntityCreature implements IMonster {

	protected final zb a = new yp(this, new afn(this), 4.0F, 1.0D, 2.0D);

	public EntityMonster(World var1) {
		super(var1);
		this.b_ = 5;
	}

	public void m() {
		this.bw();
		float var1 = this.c(1.0F);
		if (var1 > 0.5F) {
			this.aO += 2;
		}

		super.m();
	}

	public void s_() {
		super.s_();
		if (!this.world.isStatic && this.world.getDifficulty() == Difficulty.PEACEFUL) {
			this.die();
		}

	}

	protected String P() {
		return "game.hostile.swim";
	}

	protected String aa() {
		return "game.hostile.swim.splash";
	}

	public boolean a(DamageSource var1, float var2) {
		if (this.b(var1)) {
			return false;
		} else if (super.a(var1, var2)) {
			Entity var3 = var1.j();
			return this.l != var3 && this.vehicle != var3 ? true : true;
		} else {
			return false;
		}
	}

	protected String bn() {
		return "game.hostile.hurt";
	}

	protected String bo() {
		return "game.hostile.die";
	}

	protected String n(int var1) {
		return var1 > 4 ? "game.hostile.hurt.fall.big" : "game.hostile.hurt.fall.small";
	}

	public boolean r(Entity var1) {
		float var2 = (float) this.a(afs.e).e();
		int var3 = 0;
		if (var1 instanceof EntityLiving) {
			var2 += aph.a(this.getItemInHand(), ((EntityLiving) var1).by());
			var3 += aph.a((EntityLiving) this);
		}

		boolean var4 = var1.a(DamageSource.a((EntityLiving) this), var2);
		if (var4) {
			if (var3 > 0) {
				var1.g((double) (-DataTypesConverter.a(this.yaw * 3.1415927F / 180.0F) * (float) var3 * 0.5F), 0.1D, (double) (DataTypesConverter.b(this.yaw * 3.1415927F / 180.0F) * (float) var3 * 0.5F));
				this.motionX *= 0.6D;
				this.motionZ *= 0.6D;
			}

			int var5 = aph.b((EntityLiving) this);
			if (var5 > 0) {
				var1.e(var5 * 4);
			}

			this.a(this, var1);
		}

		return var4;
	}

	public float a(Position var1) {
		return 0.5F - this.world.o(var1);
	}

	protected boolean m_() {
		Position var1 = new Position(this.locationX, this.getBoundingBox().minY, this.locationZ);
		if (this.world.b(arf.a, var1) > this.V.nextInt(32)) {
			return false;
		} else {
			int var2 = this.world.l(var1);
			if (this.world.R()) {
				int var3 = this.world.ab();
				this.world.b(10);
				var2 = this.world.l(var1);
				this.world.b(var3);
			}

			return var2 <= this.V.nextInt(8);
		}
	}

	public boolean bQ() {
		return this.world.getDifficulty() != Difficulty.PEACEFUL && this.m_() && super.bQ();
	}

	protected void aW() {
		super.aW();
		this.bx().b(afs.e);
	}

	protected boolean aZ() {
		return true;
	}
}

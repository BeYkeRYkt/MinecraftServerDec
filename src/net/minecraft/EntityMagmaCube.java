package net.minecraft;

public class EntityMagmaCube extends EntitySlime {

	public EntityMagmaCube(World var1) {
		super(var1);
		this.fireProof = true;
	}

	protected void aW() {
		super.aW();
		this.a(afs.d).a(0.20000000298023224D);
	}

	public boolean bQ() {
		return this.world.getDifficulty() != Difficulty.PEACEFUL;
	}

	public boolean bR() {
		return this.world.a(this.getBoundingBox(), (Entity) this) && this.world.getCubes((Entity) this, this.getBoundingBox()).isEmpty() && !this.world.d(this.getBoundingBox());
	}

	public int bq() {
		return this.ck() * 3;
	}

	public float c(float var1) {
		return 1.0F;
	}

	protected Particle n() {
		return Particle.A;
	}

	protected EntitySlime cd() {
		return new EntityMagmaCube(this.world);
	}

	protected Item getLoot() {
		return Items.MAGMA_CREAM;
	}

	protected void dropDeathLoot(boolean var1, int var2) {
		Item var3 = this.getLoot();
		if (var3 != null && this.ck() > 1) {
			int var4 = this.random.nextInt(4) - 2;
			if (var2 > 0) {
				var4 += this.random.nextInt(var2 + 1);
			}

			for (int var5 = 0; var5 < var4; ++var5) {
				this.a(var3, 1);
			}
		}

	}

	public boolean au() {
		return false;
	}

	protected int ce() {
		return super.ce() * 4;
	}

	protected void cf() {
		this.a *= 0.9F;
	}

	protected void jump() {
		this.motionY = (double) (0.42F + (float) this.ck() * 0.1F);
		this.ai = true;
	}

	protected void bG() {
		this.motionY = (double) (0.22F + (float) this.ck() * 0.05F);
		this.ai = true;
	}

	public void e(float var1, float var2) {
	}

	protected boolean cg() {
		return true;
	}

	protected int ch() {
		return super.ch() + 2;
	}

	protected String ci() {
		return this.ck() > 1 ? "mob.magmacube.big" : "mob.magmacube.small";
	}

	protected boolean cj() {
		return true;
	}
}

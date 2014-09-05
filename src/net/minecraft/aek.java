package net.minecraft;

public class aek extends Entity {

	public int a;
	private EntityLiving b;

	public aek(World var1) {
		super(var1);
		this.k = true;
		this.a(0.98F, 0.98F);
	}

	public aek(World var1, double var2, double var4, double var6, EntityLiving var8) {
		this(var1);
		this.b(var2, var4, var6);
		float var9 = (float) (Math.random() * 3.1415927410125732D * 2.0D);
		this.motionX = (double) (-((float) Math.sin((double) var9)) * 0.02F);
		this.motionY = 0.20000000298023224D;
		this.motionZ = (double) (-((float) Math.cos((double) var9)) * 0.02F);
		this.a = 80;
		this.p = var2;
		this.q = var4;
		this.r = var6;
		this.b = var8;
	}

	protected void h() {
	}

	protected boolean r_() {
		return false;
	}

	public boolean ad() {
		return !this.I;
	}

	public void s_() {
		this.p = this.locationX;
		this.q = this.locationY;
		this.r = this.locationZ;
		this.motionY -= 0.03999999910593033D;
		this.d(this.motionX, this.motionY, this.motionZ);
		this.motionX *= 0.9800000190734863D;
		this.motionY *= 0.9800000190734863D;
		this.motionZ *= 0.9800000190734863D;
		if (this.C) {
			this.motionX *= 0.699999988079071D;
			this.motionZ *= 0.699999988079071D;
			this.motionY *= -0.5D;
		}

		if (this.a-- <= 0) {
			this.J();
			if (!this.o.D) {
				this.l();
			}
		} else {
			this.W();
			this.o.a(ew.l, this.locationX, this.locationY + 0.5D, this.locationZ, 0.0D, 0.0D, 0.0D, new int[0]);
		}

	}

	private void l() {
		float var1 = 4.0F;
		this.o.a(this, this.locationX, this.locationY + (double) (this.K / 2.0F), this.locationZ, var1, true);
	}

	protected void b(NBTCompoundTag var1) {
		var1.put("Fuse", (byte) this.a);
	}

	protected void a(NBTCompoundTag var1) {
		this.a = var1.getByte("Fuse");
	}

	public EntityLiving j() {
		return this.b;
	}

	public float aR() {
		return 0.0F;
	}
}

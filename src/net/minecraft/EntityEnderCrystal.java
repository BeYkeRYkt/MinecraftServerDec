package net.minecraft;

public class EntityEnderCrystal extends Entity {

	public int a;
	public int b;

	public EntityEnderCrystal(World var1) {
		super(var1);
		this.k = true;
		this.a(2.0F, 2.0F);
		this.b = 5;
		this.a = this.V.nextInt(100000);
	}

	protected boolean r_() {
		return false;
	}

	protected void h() {
		this.dataWatcher.a(8, Integer.valueOf(this.b));
	}

	public void s_() {
		this.p = this.locationX;
		this.q = this.locationY;
		this.r = this.locationZ;
		++this.a;
		this.dataWatcher.b(8, Integer.valueOf(this.b));
		int var1 = MathHelper.toFixedPointInt(this.locationX);
		int var2 = MathHelper.toFixedPointInt(this.locationY);
		int var3 = MathHelper.toFixedPointInt(this.locationZ);
		if (this.world.worldProvider instanceof WorldProviderTheEnd && this.world.getBlockState(new Position(var1, var2, var3)).getBlock() != Blocks.FIRE) {
			this.world.a(new Position(var1, var2, var3), Blocks.FIRE.getBlockState());
		}

	}

	protected void b(NBTCompoundTag var1) {
	}

	protected void a(NBTCompoundTag var1) {
	}

	public boolean ad() {
		return true;
	}

	public boolean a(DamageSource var1, float var2) {
		if (this.b(var1)) {
			return false;
		} else {
			if (!this.dead && !this.world.isStatic) {
				this.b = 0;
				if (this.b <= 0) {
					this.die();
					if (!this.world.isStatic) {
						this.world.a((Entity) null, this.locationX, this.locationY, this.locationZ, 6.0F, true);
					}
				}
			}

			return true;
		}
	}
}

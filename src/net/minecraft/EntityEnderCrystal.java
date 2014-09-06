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
		int var1 = DataTypesConverter.toFixedPointInt(this.locationX);
		int var2 = DataTypesConverter.toFixedPointInt(this.locationY);
		int var3 = DataTypesConverter.toFixedPointInt(this.locationZ);
		if (this.o.worldProvider instanceof TheEndWorldProvider && this.o.p(new Position(var1, var2, var3)).getBlock() != aty.ab) {
			this.o.a(new Position(var1, var2, var3), aty.ab.P());
		}

	}

	protected void b(NBTCompoundTag var1) {
	}

	protected void a(NBTCompoundTag var1) {
	}

	public boolean ad() {
		return true;
	}

	public boolean a(wh var1, float var2) {
		if (this.b(var1)) {
			return false;
		} else {
			if (!this.I && !this.o.D) {
				this.b = 0;
				if (this.b <= 0) {
					this.J();
					if (!this.o.D) {
						this.o.a((Entity) null, this.locationX, this.locationY, this.locationZ, 6.0F, true);
					}
				}
			}

			return true;
		}
	}
}

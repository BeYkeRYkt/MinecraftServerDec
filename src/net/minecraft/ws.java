package net.minecraft;

public abstract class ws extends EntityCreature {

	protected int a;
	protected int b;
	protected int c;
	private float bk = -1.0F;
	private float bl;

	public ws(World var1) {
		super(var1);
	}

	public abstract ws a(ws var1);

	public boolean a(EntityHuman var1) {
		ItemStack var2 = var1.playerInventory.getItemInHand();
		if (var2 != null && var2.getItem() == amk.bJ) {
			if (!this.o.D) {
				Class var3 = EntityTypes.getClassById(var2.i());
				if (var3 != null && this.getClass() == var3) {
					ws var4 = this.a(this);
					if (var4 != null) {
						var4.b(-24000);
						var4.b(this.locationX, this.locationY, this.locationZ, 0.0F, 0.0F);
						this.o.d((Entity) var4);
						if (var2.s()) {
							var4.a(var2.q());
						}

						if (!var1.by.instabuild) {
							--var2.b;
							if (var2.b <= 0) {
								var1.playerInventory.a(var1.playerInventory.c, (ItemStack) null);
							}
						}
					}
				}
			}

			return true;
		} else {
			return false;
		}
	}

	protected void h() {
		super.h();
		this.dataWatcher.a(12, Byte.valueOf((byte) 0));
	}

	public int l() {
		return this.o.D ? this.dataWatcher.a(12) : this.a;
	}

	public void a(int var1, boolean var2) {
		int var3 = this.l();
		int var4 = var3;
		var3 += var1 * 20;
		if (var3 > 0) {
			var3 = 0;
			if (var4 < 0) {
				this.n();
			}
		}

		int var5 = var3 - var4;
		this.b(var3);
		if (var2) {
			this.b += var5;
			if (this.c == 0) {
				this.c = 40;
			}
		}

		if (this.l() == 0) {
			this.b(this.b);
		}

	}

	public void a(int var1) {
		this.a(var1, false);
	}

	public void b(int var1) {
		this.dataWatcher.b(12, Byte.valueOf((byte) DataTypesConverter.a(var1, -1, 1)));
		this.a = var1;
		this.a(this.i_());
	}

	public void b(NBTCompoundTag var1) {
		super.b(var1);
		var1.put("Age", this.l());
		var1.put("ForcedAge", this.b);
	}

	public void a(NBTCompoundTag var1) {
		super.a(var1);
		this.b(var1.getInt("Age"));
		this.b = var1.getInt("ForcedAge");
	}

	public void m() {
		super.m();
		if (this.o.D) {
			if (this.c > 0) {
				if (this.c % 4 == 0) {
					this.o.a(Particle.v, this.locationX + (double) (this.V.nextFloat() * this.J * 2.0F) - (double) this.J, this.locationY + 0.5D + (double) (this.V.nextFloat() * this.K), this.locationZ + (double) (this.V.nextFloat() * this.J * 2.0F) - (double) this.J, 0.0D, 0.0D, 0.0D, new int[0]);
				}

				--this.c;
			}

			this.a(this.i_());
		} else {
			int var1 = this.l();
			if (var1 < 0) {
				++var1;
				this.b(var1);
				if (var1 == 0) {
					this.n();
				}
			} else if (var1 > 0) {
				--var1;
				this.b(var1);
			}
		}

	}

	protected void n() {
	}

	public boolean i_() {
		return this.l() < 0;
	}

	public void a(boolean var1) {
		this.a(var1 ? 0.5F : 1.0F);
	}

	protected final void a(float var1, float var2) {
		boolean var3 = this.bk > 0.0F;
		this.bk = var1;
		this.bl = var2;
		if (!var3) {
			this.a(1.0F);
		}

	}

	protected final void a(float var1) {
		super.a(this.bk * var1, this.bl * var1);
	}
}

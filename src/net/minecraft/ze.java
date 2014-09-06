package net.minecraft;

public class ze extends zn {

	private final EntityVillager c;
	private boolean d;
	private boolean e;
	private int f;

	public ze(EntityVillager var1, double var2) {
		super(var1, var2, 16);
		this.c = var1;
	}

	public boolean a() {
		if (this.a <= 0) {
			if (!this.c.o.Q().b("mobGriefing")) {
				return false;
			}

			this.f = -1;
			this.d = this.c.cs();
			this.e = this.c.cr();
		}

		return super.a();
	}

	public boolean b() {
		return this.f >= 0 && super.b();
	}

	public void c() {
		super.c();
	}

	public void d() {
		super.d();
	}

	public void e() {
		super.e();
		this.c.p().a((double) this.b.getX() + 0.5D, (double) (this.b.getY() + 1), (double) this.b.getZ() + 0.5D, 10.0F, (float) this.c.bP());
		if (this.f()) {
			World var1 = this.c.o;
			Position var2 = this.b.a();
			bec var3 = var1.p(var2);
			Block var4 = var3.getBlock();
			if (this.f == 0 && var4 instanceof BlockCrops && ((Integer) var3.b(BlockCrops.a)).intValue() == 7) {
				var1.b(var2, true);
			} else if (this.f == 1 && var4 == Blocks.AIR) {
				wa var5 = this.c.co();

				for (int var6 = 0; var6 < var5.n_(); ++var6) {
					ItemStack var7 = var5.a(var6);
					boolean var8 = false;
					if (var7 != null) {
						if (var7.getItem() == Items.WHEAT_SEEDS) {
							var1.a(var2, Blocks.WHEAT.P(), 3);
							var8 = true;
						} else if (var7.getItem() == Items.POTATO) {
							var1.a(var2, Blocks.POTATOES.P(), 3);
							var8 = true;
						} else if (var7.getItem() == Items.CARROT) {
							var1.a(var2, Blocks.CARROTS.P(), 3);
							var8 = true;
						}
					}

					if (var8) {
						--var7.b;
						if (var7.b <= 0) {
							var5.a(var6, (ItemStack) null);
						}
						break;
					}
				}
			}

			this.f = -1;
			this.a = 10;
		}

	}

	protected boolean a(World var1, Position var2) {
		Block var3 = var1.p(var2).getBlock();
		if (var3 == Blocks.FARMLAND) {
			var2 = var2.a();
			bec var4 = var1.p(var2);
			var3 = var4.getBlock();
			if (var3 instanceof BlockCrops && ((Integer) var4.b(BlockCrops.a)).intValue() == 7 && this.e && (this.f == 0 || this.f < 0)) {
				this.f = 0;
				return true;
			}

			if (var3 == Blocks.AIR && this.d && (this.f == 1 || this.f < 0)) {
				this.f = 1;
				return true;
			}
		}

		return false;
	}
}

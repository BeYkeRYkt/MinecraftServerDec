package net.minecraft;

public class zr extends zn {

	private final EntityOcelot c;

	public zr(EntityOcelot var1, double var2) {
		super(var1, var2, 8);
		this.c = var1;
	}

	public boolean a() {
		return this.c.cj() && !this.c.cl() && super.a();
	}

	public boolean b() {
		return super.b();
	}

	public void c() {
		super.c();
		this.c.cn().a(false);
	}

	public void d() {
		super.d();
		this.c.n(false);
	}

	public void e() {
		super.e();
		this.c.cn().a(false);
		if (!this.f()) {
			this.c.n(false);
		} else if (!this.c.cl()) {
			this.c.n(true);
		}

	}

	protected boolean a(World var1, Position var2) {
		if (!var1.d(var2.a())) {
			return false;
		} else {
			BlockState var3 = var1.getBlockState(var2);
			Block var4 = var3.getBlock();
			if (var4 == Blocks.CHEST) {
				TileEntity var5 = var1.getTileEntity(var2);
				if (var5 instanceof TileEntityChest && ((TileEntityChest) var5).l < 1) {
					return true;
				}
			} else {
				if (var4 == Blocks.LIT_FURNACE) {
					return true;
				}

				if (var4 == Blocks.BED && var3.b(BlockBed.a) != atq.a) {
					return true;
				}
			}

			return false;
		}
	}
}

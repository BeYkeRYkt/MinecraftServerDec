package net.minecraft;

public class arj implements ard {

	protected int a;
	protected int b;
	protected Chunk[][] c;
	protected boolean d;
	protected World e;

	public arj(World var1, Position var2, Position var3, int var4) {
		this.e = var1;
		this.a = var2.getX() - var4 >> 4;
		this.b = var2.getZ() - var4 >> 4;
		int var5 = var3.getX() + var4 >> 4;
		int var6 = var3.getZ() + var4 >> 4;
		this.c = new Chunk[var5 - this.a + 1][var6 - this.b + 1];
		this.d = true;

		int var7;
		int var8;
		for (var7 = this.a; var7 <= var5; ++var7) {
			for (var8 = this.b; var8 <= var6; ++var8) {
				this.c[var7 - this.a][var8 - this.b] = var1.a(var7, var8);
			}
		}

		for (var7 = var2.getX() >> 4; var7 <= var3.getX() >> 4; ++var7) {
			for (var8 = var2.getZ() >> 4; var8 <= var3.getZ() >> 4; ++var8) {
				Chunk var9 = this.c[var7 - this.a][var8 - this.b];
				if (var9 != null && !var9.c(var2.getY(), var3.getY())) {
					this.d = false;
				}
			}
		}

	}

	public TileEntity s(Position var1) {
		int var2 = (var1.getX() >> 4) - this.a;
		int var3 = (var1.getZ() >> 4) - this.b;
		return this.c[var2][var3].a(var1, bfl.a);
	}

	public bec p(Position var1) {
		if (var1.getY() >= 0 && var1.getY() < 256) {
			int var2 = (var1.getX() >> 4) - this.a;
			int var3 = (var1.getZ() >> 4) - this.b;
			if (var2 >= 0 && var2 < this.c.length && var3 >= 0 && var3 < this.c[var2].length) {
				Chunk var4 = this.c[var2][var3];
				if (var4 != null) {
					return var4.g(var1);
				}
			}
		}

		return Blocks.AIR.P();
	}

	public boolean d(Position var1) {
		return this.p(var1).getBlock().r() == Material.AIR;
	}

	public int a(Position var1, PaintingDirection var2) {
		bec var3 = this.p(var1);
		return var3.getBlock().b((ard) this, var1, var3, var2);
	}
}

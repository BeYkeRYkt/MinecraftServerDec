package net.minecraft;

public class ea implements dz {

	private final World a;
	private final Position b;

	public ea(World var1, Position var2) {
		this.a = var1;
		this.b = var2;
	}

	public World i() {
		return this.a;
	}

	public double a() {
		return (double) this.b.getX() + 0.5D;
	}

	public double b() {
		return (double) this.b.getY() + 0.5D;
	}

	public double c() {
		return (double) this.b.getZ() + 0.5D;
	}

	public Position d() {
		return this.b;
	}

	public Block e() {
		return this.a.p(this.b).getBlock();
	}

	public int f() {
		bec var1 = this.a.p(this.b);
		return var1.getBlock().c(var1);
	}

	public TileEntity h() {
		return this.a.s(this.b);
	}
}

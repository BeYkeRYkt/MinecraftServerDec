package net.minecraft;

public class bgh extends WorldProvider {

	public void b() {
		this.c = new asc(arm.y, 0.0F);
		this.dimensionId = 1;
		this.e = true;
	}

	public IChunkProvider c() {
		return new bgw(this.b, this.b.J());
	}

	public float a(long var1, float var3) {
		return 0.0F;
	}

	public boolean e() {
		return false;
	}

	public boolean d() {
		return false;
	}

	public boolean a(int var1, int var2) {
		return this.b.c(new Position(var1, 0, var2)).r().c();
	}

	public Position h() {
		return new Position(100, 50, 0);
	}

	public int i() {
		return 50;
	}

	public String k() {
		return "The End";
	}

	public String l() {
		return "_end";
	}
}

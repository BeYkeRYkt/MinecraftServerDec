package net.minecraft;

public class BlockBarrier extends Block {

	protected BlockBarrier() {
		super(Material.BARRIER);
		this.v();
		this.b(6000001.0F);
		this.J();
		this.t = true;
	}

	public int b() {
		return -1;
	}

	public boolean c() {
		return false;
	}

	public void a(World var1, Position var2, BlockState var3, float var4, int var5) {
	}
}

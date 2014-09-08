package net.minecraft;

public abstract class atg extends Block implements avs {

	protected atg(Material var1) {
		super(var1);
		this.A = true;
	}

	public int b() {
		return -1;
	}

	public void b(World var1, Position var2, BlockState var3) {
		super.b(var1, var2, var3);
		var1.t(var2);
	}

	public boolean a(World var1, Position var2, BlockState var3, int var4, int var5) {
		super.a(var1, var2, var3, var4, var5);
		TileEntity var6 = var1.getTileEntity(var2);
		return var6 == null ? false : var6.c(var4, var5);
	}
}

package net.minecraft;

public class BlockStandingSign extends bai {

	public static final bew a = bew.a("rotation", 0, 15);

	public BlockStandingSign() {
		this.j(this.L.b().a(a, Integer.valueOf(0)));
	}

	public void a(World var1, Position var2, bec var3, Block var4) {
		if (!var1.p(var2.b()).getBlock().r().isBuildable()) {
			this.b(var1, var2, var3, 0);
			var1.g(var2);
		}

		super.a(var1, var2, var3, var4);
	}

	public bec a(int var1) {
		return this.P().a(a, Integer.valueOf(var1));
	}

	public int c(bec var1) {
		return ((Integer) var1.b(a)).intValue();
	}

	protected bed e() {
		return new bed(this, new bex[] { a });
	}

}

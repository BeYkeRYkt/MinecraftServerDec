package net.minecraft;

public class BlockWallBanner extends atb {

	public BlockWallBanner() {
		this.j(this.L.b().a(a, BlockFace.NORTH));
	}

	public void a(ard var1, Position var2) {
		BlockFace var3 = (BlockFace) var1.p(var2).b(a);
		float var4 = 0.0F;
		float var5 = 0.78125F;
		float var6 = 0.0F;
		float var7 = 1.0F;
		float var8 = 0.125F;
		this.a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
		switch (atc.a[var3.ordinal()]) {
			case 1:
			default:
				this.a(var6, var4, 1.0F - var8, var7, var5, 1.0F);
				break;
			case 2:
				this.a(var6, var4, 0.0F, var7, var5, var8);
				break;
			case 3:
				this.a(1.0F - var8, var4, var6, 1.0F, var5, var7);
				break;
			case 4:
				this.a(0.0F, var4, var6, var8, var5, var7);
		}

	}

	public void a(World var1, Position var2, bec var3, Block var4) {
		BlockFace var5 = (BlockFace) var3.b(a);
		if (!var1.p(var2.a(var5.getOpposite())).getBlock().r().isBuildable()) {
			this.b(var1, var2, var3, 0);
			var1.g(var2);
		}

		super.a(var1, var2, var3, var4);
	}

	public bec a(int var1) {
		BlockFace var2 = BlockFace.getById(var1);
		if (var2.k() == el.b) {
			var2 = BlockFace.NORTH;
		}

		return this.P().a(a, var2);
	}

	public int c(bec var1) {
		return ((BlockFace) var1.b(a)).getId();
	}

	protected bed e() {
		return new bed(this, new bex[] { a });
	}
}

package net.minecraft;

public class BlockQuartz extends Block {

	public static final bev a = bev.a("variant", azn.class);

	public BlockQuartz() {
		super(Material.STONE);
		this.setBlockState(this.L.b().a(a, azn.a));
		this.a(CreativeModeTab.BUILDING_BLOCKS);
	}

	public BlockState a(World var1, Position var2, BlockFace var3, float var4, float var5, float var6, int var7, EntityLiving var8) {
		if (var7 == azn.c.a()) {
			switch (azm.a[var3.k().ordinal()]) {
				case 1:
					return this.getBlockState().a(a, azn.e);
				case 2:
					return this.getBlockState().a(a, azn.d);
				case 3:
				default:
					return this.getBlockState().a(a, azn.c);
			}
		} else {
			return var7 == azn.b.a() ? this.getBlockState().a(a, azn.b) : this.getBlockState().a(a, azn.a);
		}
	}

	public int a(BlockState var1) {
		azn var2 = (azn) var1.b(a);
		return var2 != azn.d && var2 != azn.e ? var2.a() : azn.c.a();
	}

	protected ItemStack i(BlockState var1) {
		azn var2 = (azn) var1.b(a);
		return var2 != azn.d && var2 != azn.e ? super.i(var1) : new ItemStack(Item.getItemOf((Block) this), 1, azn.c.a());
	}

	public MaterialMapColor g(BlockState var1) {
		return MaterialMapColor.p;
	}

	public BlockState a(int var1) {
		return this.getBlockState().a(a, azn.a(var1));
	}

	public int c(BlockState var1) {
		return ((azn) var1.b(a)).a();
	}

	protected bed e() {
		return new bed(this, new bex[] { a });
	}

}

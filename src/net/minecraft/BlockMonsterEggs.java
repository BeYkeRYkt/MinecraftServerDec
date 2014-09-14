package net.minecraft;

import java.util.Random;

public class BlockMonsterEggs extends Block {

	public static final bev a = bev.a("variant", axu.class);

	public BlockMonsterEggs() {
		super(Material.CLAY);
		this.setBlockState(this.L.b().a(a, axu.a));
		this.c(0.0F);
		this.a(CreativeModeTab.DECORATIONS);
	}

	public int a(Random var1) {
		return 0;
	}

	public static boolean d(IBlockState var0) {
		Block var1 = var0.getBlock();
		return var0 == Blocks.STONE.getBlockState().a(BlockStone.a, bbb.a) || var1 == Blocks.COBBLESTONE || var1 == Blocks.STONEBRICK;
	}

	protected ItemStack i(IBlockState var1) {
		switch (axt.a[((axu) var1.b(a)).ordinal()]) {
			case 1:
				return new ItemStack(Blocks.COBBLESTONE);
			case 2:
				return new ItemStack(Blocks.STONEBRICK);
			case 3:
				return new ItemStack(Blocks.STONEBRICK, 1, bbd.b.a());
			case 4:
				return new ItemStack(Blocks.STONEBRICK, 1, bbd.c.a());
			case 5:
				return new ItemStack(Blocks.STONEBRICK, 1, bbd.d.a());
			default:
				return new ItemStack(Blocks.STONE);
		}
	}

	public void a(World var1, Position var2, IBlockState var3, float var4, int var5) {
		if (!var1.isStatic && var1.getGameRules().b("doTileDrops")) {
			EntitySilverfish var6 = new EntitySilverfish(var1);
			var6.setPositionRotation((double) var2.getX() + 0.5D, (double) var2.getY(), (double) var2.getZ() + 0.5D, 0.0F, 0.0F);
			var1.addEntity((Entity) var6);
			var6.y();
		}

	}

	public int j(World var1, Position var2) {
		IBlockState var3 = var1.getBlockState(var2);
		return var3.getBlock().getData(var3);
	}

	public IBlockState a(int var1) {
		return this.getBlockState().a(a, axu.a(var1));
	}

	public int getData(IBlockState var1) {
		return ((axu) var1.b(a)).a();
	}

	protected bed e() {
		return new bed(this, new bex[] { a });
	}

}

package net.minecraft;

import java.util.Random;

public class BlockRepeater extends ava {

	public static final bet a = bet.a("locked");
	public static final bew b = bew.a("delay", 1, 4);

	protected BlockRepeater(boolean var1) {
		super(var1);
		this.setBlockState(this.L.b().a(N, BlockFace.NORTH).a(b, Integer.valueOf(1)).a(a, Boolean.valueOf(false)));
	}

	public IBlockState a(IBlockState var1, ard var2, Position var3) {
		return var1.a(a, Boolean.valueOf(this.b(var2, var3, var1)));
	}

	public boolean interact(World var1, Position var2, IBlockState var3, EntityHuman var4, BlockFace var5, float var6, float var7, float var8) {
		if (!var4.playerProperties.maybuild) {
			return false;
		} else {
			var1.setBlockAt(var2, var3.a(b), 3);
			return true;
		}
	}

	protected int d(IBlockState var1) {
		return ((Integer) var1.b(b)).intValue() * 2;
	}

	protected IBlockState e(IBlockState var1) {
		Integer var2 = (Integer) var1.b(b);
		Boolean var3 = (Boolean) var1.b(a);
		BlockFace var4 = (BlockFace) var1.b(N);
		return Blocks.POWERED_REPEATER.getBlockState().a(N, var4).a(b, var2).a(a, var3);
	}

	protected IBlockState k(IBlockState var1) {
		Integer var2 = (Integer) var1.b(b);
		Boolean var3 = (Boolean) var1.b(a);
		BlockFace var4 = (BlockFace) var1.b(N);
		return Blocks.UNPOWERED_REPEATER.getBlockState().a(N, var4).a(b, var2).a(a, var3);
	}

	public Item a(IBlockState var1, Random var2, int var3) {
		return Items.REPEATER;
	}

	public boolean b(ard var1, Position var2, IBlockState var3) {
		return this.c(var1, var2, var3) > 0;
	}

	protected boolean c(Block var1) {
		return d(var1);
	}

	public void remove(World var1, Position var2, IBlockState var3) {
		super.remove(var1, var2, var3);
		this.h(var1, var2, var3);
	}

	public IBlockState setData(int var1) {
		return this.getBlockState().a(N, BlockFace.fromDirection(var1)).a(a, Boolean.valueOf(false)).a(b, Integer.valueOf(1 + (var1 >> 2)));
	}

	public int getData(IBlockState var1) {
		byte var2 = 0;
		int var3 = var2 | ((BlockFace) var1.b(N)).toDirection();
		var3 |= ((Integer) var1.b(b)).intValue() - 1 << 2;
		return var3;
	}

	protected bed e() {
		return new bed(this, new bex[] { N, b, a });
	}

}

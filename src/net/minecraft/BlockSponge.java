package net.minecraft;

import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class BlockSponge extends Block {

	public static final bet a = bet.a("wet");

	protected BlockSponge() {
		super(Material.SPONGE);
		this.setBlockState(this.L.b().a(a, Boolean.valueOf(false)));
		this.a(CreativeModeTab.BUILDING_BLOCKS);
	}

	public int getItemDropData(IBlockState var1) {
		return ((Boolean) var1.b(a)).booleanValue() ? 1 : 0;
	}

	public void onPlace(World var1, Position var2, IBlockState var3) {
		this.e(var1, var2, var3);
	}

	public void a(World var1, Position var2, IBlockState var3, Block var4) {
		this.e(var1, var2, var3);
		super.a(var1, var2, var3, var4);
	}

	protected void e(World var1, Position var2, IBlockState var3) {
		if (!((Boolean) var3.b(a)).booleanValue() && this.d(var1, var2)) {
			var1.setBlockAt(var2, var3.a(a, Boolean.valueOf(true)), 2);
			var1.triggerEffect(2001, var2, Block.getBlockId((Block) Blocks.WATER));
		}

	}

	private boolean d(World var1, Position var2) {
		LinkedList var3 = Lists.newLinkedList();
		ArrayList var4 = Lists.newArrayList();
		var3.add(new vi(var2, Integer.valueOf(0)));
		int var5 = 0;

		Position var7;
		while (!var3.isEmpty()) {
			vi var6 = (vi) var3.poll();
			var7 = (Position) var6.a();
			int var8 = ((Integer) var6.b()).intValue();
			BlockFace[] var9 = BlockFace.values();
			int var10 = var9.length;

			for (int var11 = 0; var11 < var10; ++var11) {
				BlockFace var12 = var9[var11];
				Position var13 = var7.getRelative(var12);
				if (var1.getBlockState(var13).getBlock().getMaterial() == Material.WATER) {
					var1.setBlockAt(var13, Blocks.AIR.getBlockState(), 2);
					var4.add(var13);
					++var5;
					if (var8 < 6) {
						var3.add(new vi(var13, Integer.valueOf(var8 + 1)));
					}
				}
			}

			if (var5 > 64) {
				break;
			}
		}

		Iterator var14 = var4.iterator();

		while (var14.hasNext()) {
			var7 = (Position) var14.next();
			var1.c(var7, Blocks.AIR);
		}

		return var5 > 0;
	}

	public IBlockState setData(int var1) {
		return this.getBlockState().a(a, Boolean.valueOf((var1 & 1) == 1));
	}

	public int getData(IBlockState var1) {
		return ((Boolean) var1.b(a)).booleanValue() ? 1 : 0;
	}

	protected bed e() {
		return new bed(this, new bex[] { a });
	}

}

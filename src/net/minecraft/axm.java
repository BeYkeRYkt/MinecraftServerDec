package net.minecraft;

import java.util.Iterator;

public abstract class axm extends baa {

	public static final bev a = bev.a("axis", axo.class);

	public axm() {
		super(Material.WOOD);
		this.a(CreativeModeTab.BUILDING_BLOCKS);
		this.c(2.0F);
		this.a(f);
	}

	public void remove(World var1, Position var2, IBlockState var3) {
		byte var4 = 4;
		int var5 = var4 + 1;
		if (var1.a(var2.a(-var5, -var5, -var5), var2.a(var5, var5, var5))) {
			Iterator var6 = Position.a(var2.a(-var4, -var4, -var4), var2.a(var4, var4, var4)).iterator();

			while (var6.hasNext()) {
				Position var7 = (Position) var6.next();
				IBlockState var8 = var1.getBlockState(var7);
				if (var8.getBlock().getMaterial() == Material.LEAVES && !((Boolean) var8.b(BlockLeaves.b)).booleanValue()) {
					var1.setBlockAt(var7, var8.a(BlockLeaves.b, Boolean.valueOf(true)), 4);
				}
			}

		}
	}

	public IBlockState a(World var1, Position var2, BlockFace var3, float var4, float var5, float var6, int var7, EntityLiving var8) {
		return super.a(var1, var2, var3, var4, var5, var6, var7, var8).a(a, axo.a(var3.k()));
	}

}

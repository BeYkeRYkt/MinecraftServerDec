package net.minecraft;

import java.util.Random;

public class BlockRedstoneLamp extends Block {

	private final boolean a;

	public BlockRedstoneLamp(boolean var1) {
		super(Material.BUILDABLE_GLASS);
		this.a = var1;
		if (var1) {
			this.a(1.0F);
		}

	}

	public void onPlace(World var1, Position var2, IBlockState var3) {
		if (!var1.isStatic) {
			if (this.a && !var1.isBlockIndirectlyPowered(var2)) {
				var1.setBlockAt(var2, Blocks.REDSTONE_LAMP.getBlockState(), 2);
			} else if (!this.a && var1.isBlockIndirectlyPowered(var2)) {
				var1.setBlockAt(var2, Blocks.LIT_REDSTONE_LAMP.getBlockState(), 2);
			}

		}
	}

	public void a(World var1, Position var2, IBlockState var3, Block var4) {
		if (!var1.isStatic) {
			if (this.a && !var1.isBlockIndirectlyPowered(var2)) {
				var1.a(var2, (Block) this, 4);
			} else if (!this.a && var1.isBlockIndirectlyPowered(var2)) {
				var1.setBlockAt(var2, Blocks.LIT_REDSTONE_LAMP.getBlockState(), 2);
			}

		}
	}

	public void b(World var1, Position var2, IBlockState var3, Random var4) {
		if (!var1.isStatic) {
			if (this.a && !var1.isBlockIndirectlyPowered(var2)) {
				var1.setBlockAt(var2, Blocks.REDSTONE_LAMP.getBlockState(), 2);
			}

		}
	}

	public Item a(IBlockState var1, Random var2, int var3) {
		return Item.getItemOf(Blocks.REDSTONE_LAMP);
	}

	protected ItemStack i(IBlockState var1) {
		return new ItemStack(Blocks.REDSTONE_LAMP);
	}
}

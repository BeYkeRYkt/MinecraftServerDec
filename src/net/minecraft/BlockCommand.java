package net.minecraft;

import java.util.Random;

public class BlockCommand extends atg {

	public static final bet a = bet.a("triggered");

	public BlockCommand() {
		super(Material.ORE);
		this.setBlockState(this.L.b().a(a, Boolean.valueOf(false)));
	}

	public TileEntity getTileEntity(World var1, int var2) {
		return new TileEntityCommand();
	}

	public void a(World var1, Position var2, IBlockState var3, Block var4) {
		if (!var1.isStatic) {
			boolean var5 = var1.isBlockIndirectlyPowered(var2);
			boolean var6 = ((Boolean) var3.b(a)).booleanValue();
			if (var5 && !var6) {
				var1.setBlockAt(var2, var3.a(a, Boolean.valueOf(true)), 4);
				var1.a(var2, (Block) this, this.a(var1));
			} else if (!var5 && var6) {
				var1.setBlockAt(var2, var3.a(a, Boolean.valueOf(false)), 4);
			}
		}

	}

	public void b(World var1, Position var2, IBlockState var3, Random var4) {
		TileEntity var5 = var1.getTileEntity(var2);
		if (var5 instanceof TileEntityCommand) {
			((TileEntityCommand) var5).getListener().executeCommand(var1);
			var1.e(var2, this);
		}

	}

	public int a(World var1) {
		return 1;
	}

	public boolean interact(World var1, Position var2, IBlockState var3, EntityHuman var4, BlockFace var5, float var6, float var7, float var8) {
		TileEntity var9 = var1.getTileEntity(var2);
		return var9 instanceof TileEntityCommand ? ((TileEntityCommand) var9).getListener().canOpen(var4) : false;
	}

	public boolean isComplexRedstone() {
		return true;
	}

	public int l(World var1, Position var2) {
		TileEntity var3 = var1.getTileEntity(var2);
		return var3 instanceof TileEntityCommand ? ((TileEntityCommand) var3).getListener().getSuccessCount() : 0;
	}

	public void a(World var1, Position var2, IBlockState var3, EntityLiving var4, ItemStack var5) {
		TileEntity var6 = var1.getTileEntity(var2);
		if (var6 instanceof TileEntityCommand) {
			CommandBlockListenerAbstract var7 = ((TileEntityCommand) var6).getListener();
			if (var5.hasDisplayName()) {
				var7.setCustomName(var5.getDisplayName());
			}

			if (!var1.isStatic) {
				var7.setTrackOutput(var1.getGameRules().b("sendCommandFeedback"));
			}

		}
	}

	public int getDropCount(Random var1) {
		return 0;
	}

	public int b() {
		return 3;
	}

	public IBlockState setData(int var1) {
		return this.getBlockState().a(a, Boolean.valueOf((var1 & 1) > 0));
	}

	public int getData(IBlockState var1) {
		int var2 = 0;
		if (((Boolean) var1.b(a)).booleanValue()) {
			var2 |= 1;
		}

		return var2;
	}

	protected bed e() {
		return new bed(this, new bex[] { a });
	}

	public IBlockState a(World var1, Position var2, BlockFace var3, float var4, float var5, float var6, int var7, EntityLiving var8) {
		return this.getBlockState().a(a, Boolean.valueOf(false));
	}

}

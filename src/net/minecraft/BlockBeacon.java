package net.minecraft;

public class BlockBeacon extends atg {

	public BlockBeacon() {
		super(Material.SHATTERABLE);
		this.c(3.0F);
		this.a(CreativeModeTab.MISC);
	}

	public TileEntity getTileEntity(World var1, int var2) {
		return new TileEntityBeacon();
	}

	public boolean interact(World var1, Position var2, IBlockState var3, EntityHuman var4, BlockFace var5, float var6, float var7, float var8) {
		if (var1.isStatic) {
			return true;
		} else {
			TileEntity var9 = var1.getTileEntity(var2);
			if (var9 instanceof TileEntityBeacon) {
				var4.openDispenser((IInventory) ((TileEntityBeacon) var9));
			}

			return true;
		}
	}

	public boolean c() {
		return false;
	}

	public boolean d() {
		return false;
	}

	public int b() {
		return 3;
	}

	public void a(World var1, Position var2, IBlockState var3, EntityLiving var4, ItemStack var5) {
		super.a(var1, var2, var3, var4, var5);
		if (var5.hasDisplayName()) {
			TileEntity var6 = var1.getTileEntity(var2);
			if (var6 instanceof TileEntityBeacon) {
				((TileEntityBeacon) var6).a(var5.getDisplayName());
			}
		}

	}

	public void a(World var1, Position var2, IBlockState var3, Block var4) {
		TileEntity var5 = var1.getTileEntity(var2);
		if (var5 instanceof TileEntityBeacon) {
			((TileEntityBeacon) var5).m();
			var1.playBlockAction(var2, this, 1, 0);
		}

	}

	public static void d(World var0, Position var1) {
		ui.a.submit((Runnable) (new atn(var0, var1)));
	}
}

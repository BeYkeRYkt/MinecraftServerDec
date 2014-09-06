package net.minecraft;

public class BlockJukeBox extends atg {

	public static final bet a = bet.a("has_record");

	protected BlockJukeBox() {
		super(Material.WOOD);
		this.j(this.L.b().a(a, Boolean.valueOf(false)));
		this.a(CreativeModeTab.DECORATIONS);
	}

	public boolean a(World var1, Position var2, bec var3, EntityHuman var4, BlockFace var5, float var6, float var7, float var8) {
		if (((Boolean) var3.b(a)).booleanValue()) {
			this.e(var1, var2, var3);
			var3 = var3.a(a, Boolean.valueOf(false));
			var1.a(var2, var3, 2);
			return true;
		} else {
			return false;
		}
	}

	public void a(World var1, Position var2, bec var3, ItemStack var4) {
		if (!var1.D) {
			TileEntity var5 = var1.s(var2);
			if (var5 instanceof TileEntityRecordPlayer) {
				((TileEntityRecordPlayer) var5).a(new ItemStack(var4.getItem(), 1, var4.i()));
				var1.a(var2, var3.a(a, Boolean.valueOf(true)), 2);
			}
		}
	}

	private void e(World var1, Position var2, bec var3) {
		if (!var1.D) {
			TileEntity var4 = var1.s(var2);
			if (var4 instanceof TileEntityRecordPlayer) {
				TileEntityRecordPlayer var5 = (TileEntityRecordPlayer) var4;
				ItemStack var6 = var5.a();
				if (var6 != null) {
					var1.b(1005, var2, 0);
					var1.a(var2, (String) null);
					var5.a((ItemStack) null);
					float var7 = 0.7F;
					double var8 = (double) (var1.s.nextFloat() * var7) + (double) (1.0F - var7) * 0.5D;
					double var10 = (double) (var1.s.nextFloat() * var7) + (double) (1.0F - var7) * 0.2D + 0.6D;
					double var12 = (double) (var1.s.nextFloat() * var7) + (double) (1.0F - var7) * 0.5D;
					ItemStack var14 = var6.getCopy();
					EntityItem var15 = new EntityItem(var1, (double) var2.getX() + var8, (double) var2.getY() + var10, (double) var2.getZ() + var12, var14);
					var15.p();
					var1.d((Entity) var15);
				}
			}
		}
	}

	public void b(World var1, Position var2, bec var3) {
		this.e(var1, var2, var3);
		super.b(var1, var2, var3);
	}

	public void a(World var1, Position var2, bec var3, float var4, int var5) {
		if (!var1.D) {
			super.a(var1, var2, var3, var4, 0);
		}
	}

	public TileEntity a(World var1, int var2) {
		return new TileEntityRecordPlayer();
	}

	public boolean N() {
		return true;
	}

	public int l(World var1, Position var2) {
		TileEntity var3 = var1.s(var2);
		if (var3 instanceof TileEntityRecordPlayer) {
			ItemStack var4 = ((TileEntityRecordPlayer) var3).a();
			if (var4 != null) {
				return Item.getId(var4.getItem()) + 1 - Item.getId(Items.RECORD_13);
			}
		}

		return 0;
	}

	public int b() {
		return 3;
	}

	public bec a(int var1) {
		return this.P().a(a, Boolean.valueOf(var1 > 0));
	}

	public int c(bec var1) {
		return ((Boolean) var1.b(a)).booleanValue() ? 1 : 0;
	}

	protected bed e() {
		return new bed(this, new bex[] { a });
	}

}

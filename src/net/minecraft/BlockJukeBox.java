package net.minecraft;

public class BlockJukeBox extends atg {

	public static final bet a = bet.a("has_record");

	protected BlockJukeBox() {
		super(Material.WOOD);
		this.setBlockState(this.L.b().a(a, Boolean.valueOf(false)));
		this.a(CreativeModeTab.DECORATIONS);
	}

	public boolean interact(World var1, Position var2, IBlockState var3, EntityHuman var4, BlockFace var5, float var6, float var7, float var8) {
		if (((Boolean) var3.b(a)).booleanValue()) {
			this.dropRecord(var1, var2, var3);
			var3 = var3.a(a, Boolean.valueOf(false));
			var1.setBlockAt(var2, var3, 2);
			return true;
		} else {
			return false;
		}
	}

	public void a(World var1, Position var2, IBlockState var3, ItemStack var4) {
		if (!var1.isStatic) {
			TileEntity var5 = var1.getTileEntity(var2);
			if (var5 instanceof TileEntityRecordPlayer) {
				((TileEntityRecordPlayer) var5).setRecord(new ItemStack(var4.getItem(), 1, var4.getWearout()));
				var1.setBlockAt(var2, var3.a(a, Boolean.valueOf(true)), 2);
			}
		}
	}

	public void dropRecord(World world, Position position, IBlockState blockState) {
		if (!world.isStatic) {
			TileEntity tileEntity = world.getTileEntity(position);
			if (tileEntity instanceof TileEntityRecordPlayer) {
				TileEntityRecordPlayer jukebox = (TileEntityRecordPlayer) tileEntity;
				ItemStack record = jukebox.getRecord();
				if (record != null) {
					world.triggerEffect(1005, position, 0);
					world.a(position, (String) null);
					jukebox.setRecord((ItemStack) null);
					float randomAmpl = 0.7F;
					double randomX = (double) (world.random.nextFloat() * randomAmpl) + (double) (1.0F - randomAmpl) * 0.5D;
					double randomY = (double) (world.random.nextFloat() * randomAmpl) + (double) (1.0F - randomAmpl) * 0.2D + 0.6D;
					double randomZ = (double) (world.random.nextFloat() * randomAmpl) + (double) (1.0F - randomAmpl) * 0.5D;
					ItemStack itemStack = record.getCopy();
					EntityItem entityItem = new EntityItem(world, (double) position.getX() + randomX, (double) position.getY() + randomY, (double) position.getZ() + randomZ, itemStack);
					entityItem.p();
					world.addEntity(entityItem);
				}
			}
		}
	}

	public void remove(World var1, Position var2, IBlockState var3) {
		this.dropRecord(var1, var2, var3);
		super.remove(var1, var2, var3);
	}

	public void dropNaturally(World var1, Position var2, IBlockState var3, float var4, int var5) {
		if (!var1.isStatic) {
			super.dropNaturally(var1, var2, var3, var4, 0);
		}
	}

	public TileEntity getTileEntity(World var1, int var2) {
		return new TileEntityRecordPlayer();
	}

	public boolean isComplexRedstone() {
		return true;
	}

	public int l(World var1, Position var2) {
		TileEntity var3 = var1.getTileEntity(var2);
		if (var3 instanceof TileEntityRecordPlayer) {
			ItemStack var4 = ((TileEntityRecordPlayer) var3).getRecord();
			if (var4 != null) {
				return Item.getId(var4.getItem()) + 1 - Item.getId(Items.RECORD_13);
			}
		}

		return 0;
	}

	public int b() {
		return 3;
	}

	public IBlockState setData(int var1) {
		return this.getBlockState().a(a, Boolean.valueOf(var1 > 0));
	}

	public int getData(IBlockState var1) {
		return ((Boolean) var1.b(a)).booleanValue() ? 1 : 0;
	}

	protected bed e() {
		return new bed(this, new bex[] { a });
	}

}

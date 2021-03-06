package net.minecraft;

import java.util.Random;

public class BlockDispenser extends atg {

	public static final beu a = beu.a("facing");
	public static final bet b = bet.a("triggered");
	public static final RegistryDefault registry = new RegistryDefault(new DispenseBehaviorItem());
	protected Random N = new Random();

	protected BlockDispenser() {
		super(Material.STONE);
		this.setBlockState(this.L.b().a(a, BlockFace.NORTH).a(b, Boolean.valueOf(false)));
		this.a(CreativeModeTab.REDSTONE);
	}

	public int a(World var1) {
		return 4;
	}

	public void onPlace(World world, Position position, IBlockState blockState) {
		super.onPlace(world, position, blockState);
		this.e(world, position, blockState);
	}

	private void e(World var1, Position var2, IBlockState var3) {
		if (!var1.isStatic) {
			BlockFace var4 = (BlockFace) var3.b(a);
			boolean var5 = var1.getBlockState(var2.getNorth()).getBlock().m();
			boolean var6 = var1.getBlockState(var2.getSouth()).getBlock().m();
			if (var4 == BlockFace.NORTH && var5 && !var6) {
				var4 = BlockFace.SOUTH;
			} else if (var4 == BlockFace.SOUTH && var6 && !var5) {
				var4 = BlockFace.NORTH;
			} else {
				boolean var7 = var1.getBlockState(var2.getWest()).getBlock().m();
				boolean var8 = var1.getBlockState(var2.getEast()).getBlock().m();
				if (var4 == BlockFace.WEST && var7 && !var8) {
					var4 = BlockFace.EAST;
				} else if (var4 == BlockFace.EAST && var8 && !var7) {
					var4 = BlockFace.WEST;
				}
			}

			var1.setBlockAt(var2, var3.a(a, var4).a(b, Boolean.valueOf(false)), 2);
		}
	}

	public boolean interact(World world, Position position, IBlockState var3, EntityHuman human, BlockFace var5, float var6, float var7, float var8) {
		if (world.isStatic) {
			return true;
		} else {
			TileEntity tileEntity = world.getTileEntity(position);
			if (tileEntity instanceof TileEntityDispenser) {
				human.openInventory((IInventory) ((TileEntityDispenser) tileEntity));
			}

			return true;
		}
	}

	public void dispense(World world, Position position) {
		SourceBlock sourceBlock = new SourceBlock(world, position);
		TileEntityDispenser dispenser = (TileEntityDispenser) sourceBlock.getTileEntity();
		if (dispenser != null) {
			int slot = dispenser.getRandomSlot();
			if (slot < 0) {
				world.triggerEffect(1001, position, 0);
			} else {
				ItemStack itemStack = dispenser.getItem(slot);
				IDispenseBehavior dispenseBehaviour = this.getDispenseBehaviour(itemStack);
				if (dispenseBehaviour != IDispenseBehavior.NOP) {
					ItemStack itemStackNew = dispenseBehaviour.a(sourceBlock, itemStack);
					dispenser.setItem(slot, itemStackNew.amount == 0 ? null : itemStackNew);
				}
			}
		}
	}

	protected IDispenseBehavior getDispenseBehaviour(ItemStack itemStack) {
		return (IDispenseBehavior) registry.getByName(itemStack == null ? null : itemStack.getItem());
	}

	public void a(World var1, Position var2, IBlockState var3, Block var4) {
		boolean var5 = var1.isBlockIndirectlyPowered(var2) || var1.isBlockIndirectlyPowered(var2.getUp());
		boolean var6 = ((Boolean) var3.b(b)).booleanValue();
		if (var5 && !var6) {
			var1.a(var2, (Block) this, this.a(var1));
			var1.setBlockAt(var2, var3.a(b, Boolean.valueOf(true)), 4);
		} else if (!var5 && var6) {
			var1.setBlockAt(var2, var3.a(b, Boolean.valueOf(false)), 4);
		}

	}

	public void b(World var1, Position var2, IBlockState var3, Random var4) {
		if (!var1.isStatic) {
			this.dispense(var1, var2);
		}

	}

	public TileEntity getTileEntity(World var1, int var2) {
		return new TileEntityDispenser();
	}

	public IBlockState a(World var1, Position var2, BlockFace var3, float var4, float var5, float var6, int var7, EntityLiving var8) {
		return this.getBlockState().a(a, BlockPiston.a(var1, var2, var8)).a(b, Boolean.valueOf(false));
	}

	public void a(World var1, Position var2, IBlockState var3, EntityLiving var4, ItemStack var5) {
		var1.setBlockAt(var2, var3.a(a, BlockPiston.a(var1, var2, var4)), 2);
		if (var5.hasDisplayName()) {
			TileEntity var6 = var1.getTileEntity(var2);
			if (var6 instanceof TileEntityDispenser) {
				((TileEntityDispenser) var6).a(var5.getDisplayName());
			}
		}

	}

	public void remove(World var1, Position var2, IBlockState var3) {
		TileEntity var4 = var1.getTileEntity(var2);
		if (var4 instanceof TileEntityDispenser) {
			vs.a(var1, var2, (TileEntityDispenser) var4);
			var1.e(var2, this);
		}

		super.remove(var1, var2, var3);
	}

	public static IPosition a(ISourceBlock var0) {
		BlockFace var1 = b(var0.getData());
		double var2 = var0.getX() + 0.7D * (double) var1.g();
		double var4 = var0.getY() + 0.7D * (double) var1.h();
		double var6 = var0.getZ() + 0.7D * (double) var1.i();
		return new PositionVector(var2, var4, var6);
	}

	public static BlockFace b(int var0) {
		return BlockFace.getById(var0 & 7);
	}

	public boolean isComplexRedstone() {
		return true;
	}

	public int l(World var1, Position var2) {
		return Container.a(var1.getTileEntity(var2));
	}

	public int b() {
		return 3;
	}

	public IBlockState setData(int var1) {
		return this.getBlockState().a(a, b(var1)).a(b, Boolean.valueOf((var1 & 8) > 0));
	}

	public int getData(IBlockState var1) {
		byte var2 = 0;
		int var3 = var2 | ((BlockFace) var1.b(a)).getId();
		if (((Boolean) var1.b(b)).booleanValue()) {
			var3 |= 8;
		}

		return var3;
	}

	protected bed e() {
		return new bed(this, new bex[] { a, b });
	}

}

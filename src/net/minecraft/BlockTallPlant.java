package net.minecraft;

import java.util.Random;

public class BlockTallPlant extends auc implements atz {

	public static final bev a = bev.a("variant", avk.class);
	public static final bev b = bev.a("half", avj.class);

	public BlockTallPlant() {
		super(Material.REPLACEABLE_PLANT);
		this.setBlockState(this.L.b().a(a, avk.a).a(b, avj.b));
		this.c(0.0F);
		this.a(h);
		this.setName("doublePlant");
	}

	public void a(ard var1, Position var2) {
		this.a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
	}

	public avk e(ard var1, Position var2) {
		IBlockState var3 = var1.getBlockState(var2);
		if (var3.getBlock() == this) {
			var3 = this.a(var3, var1, var2);
			return (avk) var3.b(a);
		} else {
			return avk.d;
		}
	}

	public boolean c(World var1, Position var2) {
		return super.c(var1, var2) && var1.d(var2.getUp());
	}

	public boolean f(World var1, Position var2) {
		IBlockState var3 = var1.getBlockState(var2);
		if (var3.getBlock() != this) {
			return true;
		} else {
			avk var4 = (avk) this.a(var3, var1, var2).b(a);
			return var4 == avk.d || var4 == avk.c;
		}
	}

	protected void e(World var1, Position var2, IBlockState var3) {
		if (!this.f(var1, var2, var3)) {
			boolean var4 = var3.b(b) == avj.a;
			Position var5 = var4 ? var2 : var2.getUp();
			Position var6 = var4 ? var2.getDown() : var2;
			Object var7 = var4 ? this : var1.getBlockState(var5).getBlock();
			Object var8 = var4 ? var1.getBlockState(var6).getBlock() : this;
			if (var7 == this) {
				var1.setBlockAt(var5, Blocks.AIR.getBlockState(), 3);
			}

			if (var8 == this) {
				var1.setBlockAt(var6, Blocks.AIR.getBlockState(), 3);
				if (!var4) {
					this.dropNaturally(var1, var6, var3, 0);
				}
			}

		}
	}

	public boolean f(World var1, Position var2, IBlockState var3) {
		if (var3.b(b) == avj.a) {
			return var1.getBlockState(var2.getDown()).getBlock() == this;
		} else {
			IBlockState var4 = var1.getBlockState(var2.getUp());
			return var4.getBlock() == this && super.f(var1, var2, var4);
		}
	}

	public Item getItemDrop(IBlockState var1, Random var2, int var3) {
		if (var1.b(b) == avj.a) {
			return null;
		} else {
			avk var4 = (avk) var1.b(a);
			return var4 == avk.d ? null : (var4 == avk.c ? (var2.nextInt(8) == 0 ? Items.WHEAT_SEEDS : null) : Item.getItemOf((Block) this));
		}
	}

	public int getItemDropData(IBlockState var1) {
		return var1.b(b) != avj.a && var1.b(a) != avk.c ? ((avk) var1.b(a)).a() : 0;
	}

	public void a(World var1, Position var2, avk var3, int var4) {
		var1.setBlockAt(var2, this.getBlockState().a(b, avj.b).a(a, var3), var4);
		var1.setBlockAt(var2.getUp(), this.getBlockState().a(b, avj.a), var4);
	}

	public void a(World var1, Position var2, IBlockState var3, EntityLiving var4, ItemStack var5) {
		var1.setBlockAt(var2.getUp(), this.getBlockState().a(b, avj.a), 2);
	}

	public void a(World var1, EntityHuman var2, Position var3, IBlockState var4, TileEntity var5) {
		if (var1.isStatic || var2.bY() == null || var2.bY().getItem() != Items.SHEARS || var4.b(b) != avj.b || !this.b(var1, var3, var4, var2)) {
			super.a(var1, var2, var3, var4, var5);
		}
	}

	public void a(World var1, Position var2, IBlockState var3, EntityHuman var4) {
		if (var3.b(b) == avj.a) {
			if (var1.getBlockState(var2.getDown()).getBlock() == this) {
				if (!var4.playerProperties.instabuild) {
					IBlockState var5 = var1.getBlockState(var2.getDown());
					avk var6 = (avk) var5.b(a);
					if (var6 != avk.d && var6 != avk.c) {
						var1.b(var2.getDown(), true);
					} else if (!var1.isStatic) {
						if (var4.bY() != null && var4.bY().getItem() == Items.SHEARS) {
							this.b(var1, var2, var5, var4);
							var1.g(var2.getDown());
						} else {
							var1.b(var2.getDown(), true);
						}
					} else {
						var1.g(var2.getDown());
					}
				} else {
					var1.g(var2.getDown());
				}
			}
		} else if (var4.playerProperties.instabuild && var1.getBlockState(var2.getUp()).getBlock() == this) {
			var1.setBlockAt(var2.getUp(), Blocks.AIR.getBlockState(), 2);
		}

		super.a(var1, var2, var3, var4);
	}

	private boolean b(World var1, Position var2, IBlockState var3, EntityHuman var4) {
		avk var5 = (avk) var3.b(a);
		if (var5 != avk.d && var5 != avk.c) {
			return false;
		} else {
			var4.b(StatisticList.MINE_BLOCK_COUNT[Block.getBlockId((Block) this)]);
			int var6 = (var5 == avk.c ? EnumGrassType.b : EnumGrassType.c).a();
			dropItem(var1, var2, new ItemStack(Blocks.TALLGRASS, 2, var6));
			return true;
		}
	}

	public int j(World var1, Position var2) {
		return this.e(var1, var2).a();
	}

	public boolean a(World var1, Position var2, IBlockState var3, boolean var4) {
		avk var5 = this.e(var1, var2);
		return var5 != avk.c && var5 != avk.d;
	}

	public boolean a(World var1, Random var2, Position var3, IBlockState var4) {
		return true;
	}

	public void b(World var1, Random var2, Position var3, IBlockState var4) {
		dropItem(var1, var3, new ItemStack(this, 1, this.e(var1, var3).a()));
	}

	public IBlockState setData(int var1) {
		return (var1 & 8) > 0 ? this.getBlockState().a(b, avj.a) : this.getBlockState().a(b, avj.b).a(a, avk.a(var1 & 7));
	}

	public IBlockState a(IBlockState var1, ard var2, Position var3) {
		if (var1.b(b) == avj.a) {
			IBlockState var4 = var2.getBlockState(var3.getDown());
			if (var4.getBlock() == this) {
				var1 = var1.a(a, var4.b(a));
			}
		}

		return var1;
	}

	public int getData(IBlockState var1) {
		return var1.b(b) == avj.a ? 8 : ((avk) var1.b(a)).a();
	}

	protected bed e() {
		return new bed(this, new bex[] { b, a });
	}

}

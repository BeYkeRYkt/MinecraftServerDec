package net.minecraft;

public class BlockTNT extends Block {

	public static final bet a = bet.a("explode");

	public BlockTNT() {
		super(Material.TNT);
		this.setBlockState(this.L.b().a(a, Boolean.valueOf(false)));
		this.a(CreativeModeTab.REDSTONE);
	}

	public void c(World var1, Position var2, BlockState var3) {
		super.c(var1, var2, var3);
		if (var1.z(var2)) {
			this.d(var1, var2, var3.a(a, Boolean.valueOf(true)));
			var1.g(var2);
		}

	}

	public void a(World var1, Position var2, BlockState var3, Block var4) {
		if (var1.z(var2)) {
			this.d(var1, var2, var3.a(a, Boolean.valueOf(true)));
			var1.g(var2);
		}

	}

	public void a(World var1, Position var2, aqo var3) {
		if (!var1.isStatic) {
			EntityTNTPrimed var4 = new EntityTNTPrimed(var1, (double) ((float) var2.getX() + 0.5F), (double) ((float) var2.getY() + 0.5F), (double) ((float) var2.getZ() + 0.5F), var3.c());
			var4.a = var1.s.nextInt(var4.a / 4) + var4.a / 8;
			var1.d((Entity) var4);
		}
	}

	public void d(World var1, Position var2, BlockState var3) {
		this.a(var1, var2, var3, (EntityLiving) null);
	}

	public void a(World var1, Position var2, BlockState var3, EntityLiving var4) {
		if (!var1.isStatic) {
			if (((Boolean) var3.b(a)).booleanValue()) {
				EntityTNTPrimed var5 = new EntityTNTPrimed(var1, (double) ((float) var2.getX() + 0.5F), (double) ((float) var2.getY() + 0.5F), (double) ((float) var2.getZ() + 0.5F), var4);
				var1.d((Entity) var5);
				var1.a((Entity) var5, "game.tnt.primed", 1.0F, 1.0F);
			}

		}
	}

	public boolean a(World var1, Position var2, BlockState var3, EntityHuman var4, BlockFace var5, float var6, float var7, float var8) {
		if (var4.bY() != null) {
			Item var9 = var4.bY().getItem();
			if (var9 == Items.FLINT_AND_STEEL || var9 == Items.FIRE_CHARGE) {
				this.a(var1, var2, var3.a(a, Boolean.valueOf(true)), (EntityLiving) var4);
				var1.g(var2);
				if (var9 == Items.FLINT_AND_STEEL) {
					var4.bY().a(1, (EntityLiving) var4);
				} else if (!var4.playerProperties.instabuild) {
					--var4.bY().amount;
				}

				return true;
			}
		}

		return super.a(var1, var2, var3, var4, var5, var6, var7, var8);
	}

	public void a(World var1, Position var2, BlockState var3, Entity var4) {
		if (!var1.isStatic && var4 instanceof EntityArrow) {
			EntityArrow var5 = (EntityArrow) var4;
			if (var5.au()) {
				this.a(var1, var2, var1.getBlockState(var2).a(a, Boolean.valueOf(true)), var5.c instanceof EntityLiving ? (EntityLiving) var5.c : null);
				var1.g(var2);
			}
		}

	}

	public boolean a(aqo var1) {
		return false;
	}

	public BlockState a(int var1) {
		return this.getBlockState().a(a, Boolean.valueOf((var1 & 1) > 0));
	}

	public int c(BlockState var1) {
		return ((Boolean) var1.b(a)).booleanValue() ? 1 : 0;
	}

	protected bed e() {
		return new bed(this, new bex[] { a });
	}

}

package net.minecraft;

public class BlockPumpkin extends avb {

	private bek a;
	private bek b;
	private bek M;
	private bek O;

	protected BlockPumpkin() {
		super(Material.PUMPKIN);
		this.setBlockState(this.L.b().a(N, BlockFace.NORTH));
		this.a(true);
		this.a(CreativeModeTab.BUILDING_BLOCKS);
	}

	public void c(World var1, Position var2, BlockState var3) {
		super.c(var1, var2, var3);
		this.e(var1, var2);
	}

	public boolean d(World var1, Position var2) {
		return this.j().a(var1, var2) != null || this.S().a(var1, var2) != null;
	}

	private void e(World var1, Position var2) {
		bem var3;
		int var4;
		int var6;
		if ((var3 = this.l().a(var1, var2)) != null) {
			for (var4 = 0; var4 < this.l().b(); ++var4) {
				bei var5 = var3.a(0, var4, 0);
				var1.a(var5.d(), Blocks.AIR.getBlockState(), 2);
			}

			EntitySnowman var9 = new EntitySnowman(var1);
			Position var11 = var3.a(0, 2, 0).d();
			var9.setPositionRotation((double) var11.getX() + 0.5D, (double) var11.getY() + 0.05D, (double) var11.getZ() + 0.5D, 0.0F, 0.0F);
			var1.addEntity((Entity) var9);

			for (var6 = 0; var6 < 120; ++var6) {
				var1.a(Particle.G, (double) var11.getX() + var1.s.nextDouble(), (double) var11.getY() + var1.s.nextDouble() * 2.5D, (double) var11.getZ() + var1.s.nextDouble(), 0.0D, 0.0D, 0.0D, new int[0]);
			}

			for (var6 = 0; var6 < this.l().b(); ++var6) {
				bei var7 = var3.a(0, var6, 0);
				var1.b(var7.d(), Blocks.AIR);
			}
		} else if ((var3 = this.T().a(var1, var2)) != null) {
			for (var4 = 0; var4 < this.T().c(); ++var4) {
				for (int var12 = 0; var12 < this.T().b(); ++var12) {
					var1.a(var3.a(var4, var12, 0).d(), Blocks.AIR.getBlockState(), 2);
				}
			}

			Position var10 = var3.a(1, 2, 0).d();
			EntityIronGolem var13 = new EntityIronGolem(var1);
			var13.l(true);
			var13.setPositionRotation((double) var10.getX() + 0.5D, (double) var10.getY() + 0.05D, (double) var10.getZ() + 0.5D, 0.0F, 0.0F);
			var1.addEntity((Entity) var13);

			for (var6 = 0; var6 < 120; ++var6) {
				var1.a(Particle.F, (double) var10.getX() + var1.s.nextDouble(), (double) var10.getY() + var1.s.nextDouble() * 3.9D, (double) var10.getZ() + var1.s.nextDouble(), 0.0D, 0.0D, 0.0D, new int[0]);
			}

			for (var6 = 0; var6 < this.T().c(); ++var6) {
				for (int var14 = 0; var14 < this.T().b(); ++var14) {
					bei var8 = var3.a(var6, var14, 0);
					var1.b(var8.d(), Blocks.AIR);
				}
			}
		}

	}

	public boolean c(World var1, Position var2) {
		return var1.getBlockState(var2).getBlock().material.j() && World.a((ard) var1, var2.b());
	}

	public BlockState a(World var1, Position var2, BlockFace var3, float var4, float var5, float var6, int var7, EntityLiving var8) {
		return this.getBlockState().a(N, var8.aO().getOpposite());
	}

	public BlockState a(int var1) {
		return this.getBlockState().a(N, BlockFace.fromDirection(var1));
	}

	public int c(BlockState var1) {
		return ((BlockFace) var1.b(N)).toDirection();
	}

	protected bed e() {
		return new bed(this, new bex[] { N });
	}

	protected bek j() {
		if (this.a == null) {
			this.a = ben.a().a(new String[] { " ", "#", "#" }).a('#', bei.a(beq.a(Blocks.SNOW))).b();
		}

		return this.a;
	}

	protected bek l() {
		if (this.b == null) {
			this.b = ben.a().a(new String[] { "^", "#", "#" }).a('^', bei.a(beq.a(Blocks.PUMPKIN))).a('#', bei.a(beq.a(Blocks.SNOW))).b();
		}

		return this.b;
	}

	protected bek S() {
		if (this.M == null) {
			this.M = ben.a().a(new String[] { "~ ~", "###", "~#~" }).a('#', bei.a(beq.a(Blocks.IRON_BLOCK))).a('~', bei.a(beq.a(Blocks.AIR))).b();
		}

		return this.M;
	}

	protected bek T() {
		if (this.O == null) {
			this.O = ben.a().a(new String[] { "~^~", "###", "~#~" }).a('^', bei.a(beq.a(Blocks.PUMPKIN))).a('#', bei.a(beq.a(Blocks.IRON_BLOCK))).a('~', bei.a(beq.a(Blocks.AIR))).b();
		}

		return this.O;
	}
}

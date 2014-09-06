package net.minecraft;

import java.util.Random;

public class BlockDragonEgg extends Block {

	public BlockDragonEgg() {
		super(Material.DRAGON_EGG);
		this.a(0.0625F, 0.0F, 0.0625F, 0.9375F, 1.0F, 0.9375F);
	}

	public void c(World var1, Position var2, bec var3) {
		var1.a(var2, (Block) this, this.a(var1));
	}

	public void a(World var1, Position var2, bec var3, Block var4) {
		var1.a(var2, (Block) this, this.a(var1));
	}

	public void b(World var1, Position var2, bec var3, Random var4) {
		this.d(var1, var2);
	}

	private void d(World var1, Position var2) {
		if (avt.d(var1, var2.b()) && var2.getY() >= 0) {
			byte var3 = 32;
			if (!avt.M && var1.a(var2.a(-var3, -var3, -var3), var2.a(var3, var3, var3))) {
				var1.d((Entity) (new EntityFallingBlock(var1, (double) ((float) var2.getX() + 0.5F), (double) var2.getY(), (double) ((float) var2.getZ() + 0.5F), this.P())));
			} else {
				var1.g(var2);

				Position var4;
				for (var4 = var2; avt.d(var1, var4) && var4.getY() > 0; var4 = var4.b()) {
					;
				}

				if (var4.getY() > 0) {
					var1.a(var4, this.P(), 2);
				}
			}

		}
	}

	public boolean a(World var1, Position var2, bec var3, EntityHuman var4, BlockFace var5, float var6, float var7, float var8) {
		this.e(var1, var2);
		return true;
	}

	public void a(World var1, Position var2, EntityHuman var3) {
		this.e(var1, var2);
	}

	private void e(World var1, Position var2) {
		bec var3 = var1.p(var2);
		if (var3.getBlock() == this) {
			for (int var4 = 0; var4 < 1000; ++var4) {
				Position var5 = var2.a(var1.s.nextInt(16) - var1.s.nextInt(16), var1.s.nextInt(8) - var1.s.nextInt(8), var1.s.nextInt(16) - var1.s.nextInt(16));
				if (var1.p(var5).getBlock().material == Material.AIR) {
					if (var1.D) {
						for (int var6 = 0; var6 < 128; ++var6) {
							double var7 = var1.s.nextDouble();
							float var9 = (var1.s.nextFloat() - 0.5F) * 0.2F;
							float var10 = (var1.s.nextFloat() - 0.5F) * 0.2F;
							float var11 = (var1.s.nextFloat() - 0.5F) * 0.2F;
							double var12 = (double) var5.getX() + (double) (var2.getX() - var5.getX()) * var7 + (var1.s.nextDouble() - 0.5D) * 1.0D + 0.5D;
							double var14 = (double) var5.getY() + (double) (var2.getY() - var5.getY()) * var7 + var1.s.nextDouble() * 1.0D - 0.5D;
							double var16 = (double) var5.getZ() + (double) (var2.getZ() - var5.getZ()) * var7 + (var1.s.nextDouble() - 0.5D) * 1.0D + 0.5D;
							var1.a(Particle.y, var12, var14, var16, (double) var9, (double) var10, (double) var11, new int[0]);
						}
					} else {
						var1.a(var5, var3, 2);
						var1.g(var2);
					}

					return;
				}
			}

		}
	}

	public int a(World var1) {
		return 5;
	}

	public boolean c() {
		return false;
	}

	public boolean d() {
		return false;
	}
}

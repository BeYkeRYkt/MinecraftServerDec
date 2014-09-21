package net.minecraft;

import java.util.Random;

class aev extends PathfinderGoal {

	private EntityEnderman a;

	public aev(EntityEnderman var1) {
		this.a = var1;
	}

	public boolean a() {
		return !this.a.world.getGameRules().isGameRule("mobGriefing") ? false : (this.a.ck().getBlock().getMaterial() != Material.AIR ? false : this.a.bb().nextInt(20) == 0);
	}

	public void e() {
		Random var1 = this.a.bb();
		World var2 = this.a.world;
		int var3 = MathHelper.toFixedPointInt(this.a.locationX - 2.0D + var1.nextDouble() * 4.0D);
		int var4 = MathHelper.toFixedPointInt(this.a.locationY + var1.nextDouble() * 3.0D);
		int var5 = MathHelper.toFixedPointInt(this.a.locationZ - 2.0D + var1.nextDouble() * 4.0D);
		Position var6 = new Position(var3, var4, var5);
		IBlockState var7 = var2.getBlockState(var6);
		Block var8 = var7.getBlock();
		if (EntityEnderman.co().contains(var8)) {
			this.a.a(var7);
			var2.a(var6, Blocks.AIR.getBlockState());
		}

	}
}

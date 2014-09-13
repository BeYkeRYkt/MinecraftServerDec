package net.minecraft;

import java.util.List;

public class EntityLightning extends EntityWeather {

	private int b;
	public long a;
	private int c;

	public EntityLightning(World var1, double var2, double var4, double var6) {
		super(var1);
		this.setPositionRotation(var2, var4, var6, 0.0F, 0.0F);
		this.b = 2;
		this.a = this.random.nextLong();
		this.c = this.random.nextInt(3) + 1;
		if (!var1.isStatic && var1.getGameRules().b("doFireTick") && (var1.getDifficulty() == Difficulty.NORMAL || var1.getDifficulty() == Difficulty.HARD) && var1.a(new Position(this), (int) 10)) {
			Position var8 = new Position(this);
			if (var1.getBlockState(var8).getBlock().getMaterial() == Material.AIR && Blocks.FIRE.c(var1, var8)) {
				var1.a(var8, Blocks.FIRE.getBlockState());
			}

			for (int var9 = 0; var9 < 4; ++var9) {
				Position var10 = var8.a(this.random.nextInt(3) - 1, this.random.nextInt(3) - 1, this.random.nextInt(3) - 1);
				if (var1.getBlockState(var10).getBlock().getMaterial() == Material.AIR && Blocks.FIRE.c(var1, var10)) {
					var1.a(var10, Blocks.FIRE.getBlockState());
				}
			}
		}

	}

	public void s_() {
		super.s_();
		if (this.b == 2) {
			this.world.makeSound(this.locationX, this.locationY, this.locationZ, "ambient.weather.thunder", 10000.0F, 0.8F + this.random.nextFloat() * 0.2F);
			this.world.makeSound(this.locationX, this.locationY, this.locationZ, "random.explode", 2.0F, 0.5F + this.random.nextFloat() * 0.2F);
		}

		--this.b;
		if (this.b < 0) {
			if (this.c == 0) {
				this.die();
			} else if (this.b < -this.random.nextInt(10)) {
				--this.c;
				this.b = 1;
				this.a = this.random.nextLong();
				Position var1 = new Position(this);
				if (!this.world.isStatic && this.world.getGameRules().b("doFireTick") && this.world.a(var1, (int) 10) && this.world.getBlockState(var1).getBlock().getMaterial() == Material.AIR && Blocks.FIRE.c(this.world, var1)) {
					this.world.a(var1, Blocks.FIRE.getBlockState());
				}
			}
		}

		if (this.b >= 0) {
			if (this.world.isStatic) {
				this.world.c(2);
			} else {
				double var6 = 3.0D;
				List var3 = this.world.getEntities((Entity) this, new AxisAlignedBB(this.locationX - var6, this.locationY - var6, this.locationZ - var6, this.locationX + var6, this.locationY + 6.0D + var6, this.locationZ + var6));

				for (int var4 = 0; var4 < var3.size(); ++var4) {
					Entity var5 = (Entity) var3.get(var4);
					var5.a(this);
				}
			}
		}

	}

	protected void h() {
	}

	protected void a(NBTCompoundTag var1) {
	}

	protected void b(NBTCompoundTag var1) {
	}
}

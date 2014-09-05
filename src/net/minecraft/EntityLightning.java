package net.minecraft;

import java.util.List;

public class EntityLightning extends EntityWeather {

	private int b;
	public long a;
	private int c;

	public EntityLightning(World var1, double var2, double var4, double var6) {
		super(var1);
		this.b(var2, var4, var6, 0.0F, 0.0F);
		this.b = 2;
		this.a = this.V.nextLong();
		this.c = this.V.nextInt(3) + 1;
		if (!var1.D && var1.Q().b("doFireTick") && (var1.getDifficulty() == Difficulty.NORMAL || var1.getDifficulty() == Difficulty.HARD) && var1.a(new Position(this), (int) 10)) {
			Position var8 = new Position(this);
			if (var1.p(var8).c().r() == Material.AIR && aty.ab.c(var1, var8)) {
				var1.a(var8, aty.ab.P());
			}

			for (int var9 = 0; var9 < 4; ++var9) {
				Position var10 = var8.a(this.V.nextInt(3) - 1, this.V.nextInt(3) - 1, this.V.nextInt(3) - 1);
				if (var1.p(var10).c().r() == Material.AIR && aty.ab.c(var1, var10)) {
					var1.a(var10, aty.ab.P());
				}
			}
		}

	}

	public void s_() {
		super.s_();
		if (this.b == 2) {
			this.o.a(this.locationX, this.locationY, this.locationZ, "ambient.weather.thunder", 10000.0F, 0.8F + this.V.nextFloat() * 0.2F);
			this.o.a(this.locationX, this.locationY, this.locationZ, "random.explode", 2.0F, 0.5F + this.V.nextFloat() * 0.2F);
		}

		--this.b;
		if (this.b < 0) {
			if (this.c == 0) {
				this.J();
			} else if (this.b < -this.V.nextInt(10)) {
				--this.c;
				this.b = 1;
				this.a = this.V.nextLong();
				Position var1 = new Position(this);
				if (!this.o.D && this.o.Q().b("doFireTick") && this.o.a(var1, (int) 10) && this.o.p(var1).c().r() == Material.AIR && aty.ab.c(this.o, var1)) {
					this.o.a(var1, aty.ab.P());
				}
			}
		}

		if (this.b >= 0) {
			if (this.o.D) {
				this.o.c(2);
			} else {
				double var6 = 3.0D;
				List var3 = this.o.b((Entity) this, new brt(this.locationX - var6, this.locationY - var6, this.locationZ - var6, this.locationX + var6, this.locationY + 6.0D + var6, this.locationZ + var6));

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

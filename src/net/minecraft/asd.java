package net.minecraft;

import java.util.Random;

public class asd extends arm {

	private int aG;
	protected static final bhf aD = new bhf(false, true);
	protected static final bhf aE = new bhf(false, false);
	protected static final bij aF = new bij(false);

	public asd(int var1, int var2) {
		super(var1);
		this.aG = var2;
		this.as.A = 10;
		this.as.C = 2;
		if (this.aG == 1) {
			this.as.A = 6;
			this.as.B = 100;
			this.as.C = 1;
		}

		this.a(5159473);
		this.a(0.7F, 0.8F);
		if (this.aG == 2) {
			this.aj = 353825;
			this.ai = 3175492;
			this.a(0.6F, 0.6F);
		}

		if (this.aG == 0) {
			this.au.add(new arq(EntityWolf.class, 5, 4, 4));
		}

		if (this.aG == 3) {
			this.as.A = -999;
		}

	}

	protected arm a(int var1, boolean var2) {
		if (this.aG == 2) {
			this.aj = 353825;
			this.ai = var1;
			if (var2) {
				this.aj = (this.aj & 16711422) >> 1;
			}

			return this;
		} else {
			return super.a(var1, var2);
		}
	}

	public bhc a(Random var1) {
		return (bhc) (this.aG == 3 && var1.nextInt(3) > 0 ? aF : (this.aG != 2 && var1.nextInt(5) != 0 ? this.aA : aE));
	}

	public awa a(Random var1, Position var2) {
		if (this.aG == 1) {
			double var3 = DataTypesConverter.a((1.0D + af.a((double) var2.getX() / 48.0D, (double) var2.getZ() / 48.0D)) / 2.0D, 0.0D, 0.9999D);
			awa var5 = awa.values()[(int) (var3 * (double) awa.values().length)];
			return var5 == awa.c ? awa.b : var5;
		} else {
			return super.a(var1, var2);
		}
	}

	public void a(World var1, Random var2, Position var3) {
		int var4;
		int var5;
		int var6;
		int var7;
		if (this.aG == 3) {
			for (var4 = 0; var4 < 4; ++var4) {
				for (var5 = 0; var5 < 4; ++var5) {
					var6 = var4 * 4 + 1 + 8 + var2.nextInt(3);
					var7 = var5 * 4 + 1 + 8 + var2.nextInt(3);
					Position var8 = var1.m(var3.a(var6, 0, var7));
					if (var2.nextInt(20) == 0) {
						bhv var9 = new bhv();
						var9.b(var1, var2, var8);
					} else {
						bhc var12 = this.a(var2);
						var12.e();
						if (var12.b(var1, var2, var8)) {
							var12.a(var1, var2, var8);
						}
					}
				}
			}
		}

		var4 = var2.nextInt(5) - 3;
		if (this.aG == 1) {
			var4 += 2;
		}

		var5 = 0;

		while (var5 < var4) {
			var6 = var2.nextInt(3);
			if (var6 == 0) {
				ag.a(avk.b);
			} else if (var6 == 1) {
				ag.a(avk.e);
			} else if (var6 == 2) {
				ag.a(avk.f);
			}

			var7 = 0;

			while (true) {
				if (var7 < 5) {
					int var11 = var2.nextInt(16) + 8;
					int var13 = var2.nextInt(16) + 8;
					int var10 = var2.nextInt(var1.m(var3.a(var11, 0, var13)).getY() + 32);
					if (!ag.b(var1, var2, new Position(var3.getX() + var11, var10, var3.getZ() + var13))) {
						++var7;
						continue;
					}
				}

				++var5;
				break;
			}
		}

		super.a(var1, var2, var3);
	}

	protected arm d(int var1) {
		if (this.az == arm.t.az) {
			asd var2 = new asd(var1, 1);
			var2.a(new aro(this.an, this.ao + 0.2F));
			var2.a("Flower Forest");
			var2.a(6976549, true);
			var2.a(8233509);
			return var2;
		} else {
			return (arm) (this.az != arm.Q.az && this.az != arm.R.az ? new asf(this, var1, this) : new ase(this, var1, this));
		}
	}

}

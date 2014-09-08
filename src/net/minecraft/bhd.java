package net.minecraft;

import com.google.common.collect.Lists;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class bhd extends bhc {

	private Random k;
	private World l;
	private Position m;
	int a;
	int b;
	double c;
	double d;
	double e;
	double f;
	int g;
	int h;
	int i;
	List j;

	public bhd(boolean var1) {
		super(var1);
		this.m = Position.ZERO;
		this.c = 0.618D;
		this.d = 0.381D;
		this.e = 1.0D;
		this.f = 1.0D;
		this.g = 1;
		this.h = 12;
		this.i = 4;
	}

	void a() {
		this.b = (int) ((double) this.a * this.c);
		if (this.b >= this.a) {
			this.b = this.a - 1;
		}

		int var1 = (int) (1.382D + Math.pow(this.f * (double) this.a / 13.0D, 2.0D));
		if (var1 < 1) {
			var1 = 1;
		}

		int var2 = this.m.getY() + this.b;
		int var3 = this.a - this.i;
		this.j = Lists.newArrayList();
		this.j.add(new bhe(this.m.b(var3), var2));

		for (; var3 >= 0; --var3) {
			float var4 = this.a(var3);
			if (var4 >= 0.0F) {
				for (int var5 = 0; var5 < var1; ++var5) {
					double var6 = this.e * (double) var4 * ((double) this.k.nextFloat() + 0.328D);
					double var8 = (double) (this.k.nextFloat() * 2.0F) * 3.141592653589793D;
					double var10 = var6 * Math.sin(var8) + 0.5D;
					double var12 = var6 * Math.cos(var8) + 0.5D;
					Position var14 = this.m.a(var10, (double) (var3 - 1), var12);
					Position var15 = var14.b(this.i);
					if (this.a(var14, var15) == -1) {
						int var16 = this.m.getX() - var14.getX();
						int var17 = this.m.getZ() - var14.getZ();
						double var18 = (double) var14.getY() - Math.sqrt((double) (var16 * var16 + var17 * var17)) * this.d;
						int var20 = var18 > (double) var2 ? var2 : (int) var18;
						Position var21 = new Position(this.m.getX(), var20, this.m.getZ());
						if (this.a(var21, var14) == -1) {
							this.j.add(new bhe(var14, var21.getY()));
						}
					}
				}
			}
		}

	}

	void a(Position var1, float var2, Block var3) {
		int var4 = (int) ((double) var2 + 0.618D);

		for (int var5 = -var4; var5 <= var4; ++var5) {
			for (int var6 = -var4; var6 <= var4; ++var6) {
				if (Math.pow((double) Math.abs(var5) + 0.5D, 2.0D) + Math.pow((double) Math.abs(var6) + 0.5D, 2.0D) <= (double) (var2 * var2)) {
					Position var7 = var1.a(var5, 0, var6);
					Material var8 = this.l.getBlockState(var7).getBlock().getMaterial();
					if (var8 == Material.AIR || var8 == Material.LEAVES) {
						this.a(this.l, var7, var3, 0);
					}
				}
			}
		}

	}

	float a(int var1) {
		if ((float) var1 < (float) this.a * 0.3F) {
			return -1.0F;
		} else {
			float var2 = (float) this.a / 2.0F;
			float var3 = var2 - (float) var1;
			float var4 = DataTypesConverter.c(var2 * var2 - var3 * var3);
			if (var3 == 0.0F) {
				var4 = var2;
			} else if (Math.abs(var3) >= var2) {
				return 0.0F;
			}

			return var4 * 0.5F;
		}
	}

	float b(int var1) {
		return var1 >= 0 && var1 < this.i ? (var1 != 0 && var1 != this.i - 1 ? 3.0F : 2.0F) : -1.0F;
	}

	void a(Position var1) {
		for (int var2 = 0; var2 < this.i; ++var2) {
			this.a(var1.b(var2), this.b(var2), Blocks.LEAVES);
		}

	}

	void a(Position var1, Position var2, Block var3) {
		Position var4 = var2.a(-var1.getX(), -var1.getY(), -var1.getZ());
		int var5 = this.b(var4);
		float var6 = (float) var4.getX() / (float) var5;
		float var7 = (float) var4.getY() / (float) var5;
		float var8 = (float) var4.getZ() / (float) var5;

		for (int var9 = 0; var9 <= var5; ++var9) {
			Position var10 = var1.a((double) (0.5F + (float) var9 * var6), (double) (0.5F + (float) var9 * var7), (double) (0.5F + (float) var9 * var8));
			axo var11 = this.b(var1, var10);
			this.a(this.l, var10, var3.getBlockState().a(axm.a, var11));
		}

	}

	private int b(Position var1) {
		int var2 = DataTypesConverter.a(var1.getX());
		int var3 = DataTypesConverter.a(var1.getY());
		int var4 = DataTypesConverter.a(var1.getZ());
		return var4 > var2 && var4 > var3 ? var4 : (var3 > var2 ? var3 : var2);
	}

	private axo b(Position var1, Position var2) {
		axo var3 = axo.b;
		int var4 = Math.abs(var2.getX() - var1.getX());
		int var5 = Math.abs(var2.getZ() - var1.getZ());
		int var6 = Math.max(var4, var5);
		if (var6 > 0) {
			if (var4 == var6) {
				var3 = axo.a;
			} else if (var5 == var6) {
				var3 = axo.c;
			}
		}

		return var3;
	}

	void b() {
		Iterator var1 = this.j.iterator();

		while (var1.hasNext()) {
			bhe var2 = (bhe) var1.next();
			this.a(var2);
		}

	}

	boolean c(int var1) {
		return (double) var1 >= (double) this.a * 0.2D;
	}

	void c() {
		Position var1 = this.m;
		Position var2 = this.m.b(this.b);
		Block var3 = Blocks.LOG;
		this.a(var1, var2, var3);
		if (this.g == 2) {
			this.a(var1.f(), var2.f(), var3);
			this.a(var1.f().d(), var2.f().d(), var3);
			this.a(var1.d(), var2.d(), var3);
		}

	}

	void d() {
		Iterator var1 = this.j.iterator();

		while (var1.hasNext()) {
			bhe var2 = (bhe) var1.next();
			int var3 = var2.q();
			Position var4 = new Position(this.m.getX(), var3, this.m.getZ());
			if (this.c(var3 - this.m.getY())) {
				this.a(var4, var2, Blocks.LOG);
			}
		}

	}

	int a(Position var1, Position var2) {
		Position var3 = var2.a(-var1.getX(), -var1.getY(), -var1.getZ());
		int var4 = this.b(var3);
		float var5 = (float) var3.getX() / (float) var4;
		float var6 = (float) var3.getY() / (float) var4;
		float var7 = (float) var3.getZ() / (float) var4;
		if (var4 == 0) {
			return -1;
		} else {
			for (int var8 = 0; var8 <= var4; ++var8) {
				Position var9 = var1.a((double) (0.5F + (float) var8 * var5), (double) (0.5F + (float) var8 * var6), (double) (0.5F + (float) var8 * var7));
				if (!this.a(this.l.getBlockState(var9).getBlock())) {
					return var8;
				}
			}

			return -1;
		}
	}

	public void e() {
		this.i = 5;
	}

	public boolean b(World var1, Random var2, Position var3) {
		this.l = var1;
		this.m = var3;
		this.k = new Random(var2.nextLong());
		if (this.a == 0) {
			this.a = 5 + this.k.nextInt(this.h);
		}

		if (!this.f()) {
			return false;
		} else {
			this.a();
			this.b();
			this.c();
			this.d();
			return true;
		}
	}

	private boolean f() {
		Block var1 = this.l.getBlockState(this.m.b()).getBlock();
		if (var1 != Blocks.DIRT && var1 != Blocks.GRASS && var1 != Blocks.FARMLAND) {
			return false;
		} else {
			int var2 = this.a(this.m, this.m.b(this.a - 1));
			if (var2 == -1) {
				return true;
			} else if (var2 < 6) {
				return false;
			} else {
				this.a = var2;
				return true;
			}
		}
	}
}

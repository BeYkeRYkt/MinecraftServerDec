package net.minecraft;

import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class bkr extends blb {

	private blf o;
	private blf p;
	private List q = Lists.newArrayList();

	public bkr() {
	}

	public bkr(Random var1, int var2, int var3, BlockFace var4) {
		super(0);
		this.m = var4;
		switch (bkj.a[this.m.ordinal()]) {
			case 1:
			case 2:
				this.l = new CuboidArea(var2, 39, var3, var2 + 58 - 1, 61, var3 + 58 - 1);
				break;
			default:
				this.l = new CuboidArea(var2, 39, var3, var2 + 58 - 1, 61, var3 + 58 - 1);
		}

		List var5 = this.a(var1);
		this.o.d = true;
		this.q.add(new bkz(this.m, this.o));
		this.q.add(new bkt(this.m, this.p, var1));
		ArrayList var6 = Lists.newArrayList();
		var6.add(new bkl((bkj) null));
		var6.add(new bkn((bkj) null));
		var6.add(new bko((bkj) null));
		var6.add(new bkk((bkj) null));
		var6.add(new bkm((bkj) null));
		var6.add(new bkq((bkj) null));
		var6.add(new bkp((bkj) null));
		Iterator var7 = var5.iterator();

		while (var7.hasNext()) {
			blf var8 = (blf) var7.next();
			if (!var8.d && !var8.b()) {
				Iterator var9 = var6.iterator();

				while (var9.hasNext()) {
					bks var10 = (bks) var9.next();
					if (var10.a(var8)) {
						this.q.add(var10.a(this.m, var8, var1));
						break;
					}
				}
			}
		}

		int var14 = this.l.minY;
		int var15 = this.a(9, 22);
		int var16 = this.b(9, 22);
		Iterator var17 = this.q.iterator();

		while (var17.hasNext()) {
			blb var11 = (blb) var17.next();
			var11.c().a(var15, var14, var16);
		}

		CuboidArea var18 = CuboidArea.a(this.a(1, 1), this.d(1), this.b(1, 1), this.a(23, 21), this.d(8), this.b(23, 21));
		CuboidArea var19 = CuboidArea.a(this.a(34, 1), this.d(1), this.b(34, 1), this.a(56, 21), this.d(8), this.b(56, 21));
		CuboidArea var12 = CuboidArea.a(this.a(22, 22), this.d(13), this.b(22, 22), this.a(35, 35), this.d(17), this.b(35, 35));
		int var13 = var1.nextInt();
		this.q.add(new ble(this.m, var18, var13++));
		this.q.add(new ble(this.m, var19, var13++));
		this.q.add(new bla(this.m, var12));
	}

	private List a(Random var1) {
		blf[] var2 = new blf[75];

		int var3;
		int var4;
		byte var5;
		int var6;
		for (var3 = 0; var3 < 5; ++var3) {
			for (var4 = 0; var4 < 4; ++var4) {
				var5 = 0;
				var6 = a(var3, var5, var4);
				var2[var6] = new blf(var6);
			}
		}

		for (var3 = 0; var3 < 5; ++var3) {
			for (var4 = 0; var4 < 4; ++var4) {
				var5 = 1;
				var6 = a(var3, var5, var4);
				var2[var6] = new blf(var6);
			}
		}

		for (var3 = 1; var3 < 4; ++var3) {
			for (var4 = 0; var4 < 2; ++var4) {
				var5 = 2;
				var6 = a(var3, var5, var4);
				var2[var6] = new blf(var6);
			}
		}

		this.o = var2[g];

		int var8;
		int var9;
		int var11;
		int var12;
		int var13;
		for (var3 = 0; var3 < 5; ++var3) {
			for (var4 = 0; var4 < 5; ++var4) {
				for (int var17 = 0; var17 < 3; ++var17) {
					var6 = a(var3, var17, var4);
					if (var2[var6] != null) {
						BlockFace[] var7 = BlockFace.values();
						var8 = var7.length;

						for (var9 = 0; var9 < var8; ++var9) {
							BlockFace var10 = var7[var9];
							var11 = var3 + var10.g();
							var12 = var17 + var10.h();
							var13 = var4 + var10.i();
							if (var11 >= 0 && var11 < 5 && var13 >= 0 && var13 < 5 && var12 >= 0 && var12 < 3) {
								int var14 = a(var11, var12, var13);
								if (var2[var14] != null) {
									if (var13 != var4) {
										var2[var6].a(var10.getOpposite(), var2[var14]);
									} else {
										var2[var6].a(var10, var2[var14]);
									}
								}
							}
						}
					}
				}
			}
		}

		blf var15;
		blf var16;
		blf var18;
		var2[h].a(BlockFace.UP, var15 = new blf(1003));
		var2[i].a(BlockFace.SOUTH, var16 = new blf(1001));
		var2[j].a(BlockFace.SOUTH, var18 = new blf(1002));
		var15.d = true;
		var16.d = true;
		var18.d = true;
		this.o.e = true;
		this.p = var2[a(var1.nextInt(4), 0, 2)];
		this.p.d = true;
		this.p.b[BlockFace.EAST.getId()].d = true;
		this.p.b[BlockFace.NORTH.getId()].d = true;
		this.p.b[BlockFace.EAST.getId()].b[BlockFace.NORTH.getId()].d = true;
		this.p.b[BlockFace.UP.getId()].d = true;
		this.p.b[BlockFace.EAST.getId()].b[BlockFace.UP.getId()].d = true;
		this.p.b[BlockFace.NORTH.getId()].b[BlockFace.UP.getId()].d = true;
		this.p.b[BlockFace.EAST.getId()].b[BlockFace.NORTH.getId()].b[BlockFace.UP.getId()].d = true;
		ArrayList var19 = Lists.newArrayList();
		blf[] var20 = var2;
		var8 = var2.length;

		for (var9 = 0; var9 < var8; ++var9) {
			blf var24 = var20[var9];
			if (var24 != null) {
				var24.a();
				var19.add(var24);
			}
		}

		var15.a();
		Collections.shuffle(var19, var1);
		int var21 = 1;
		Iterator var22 = var19.iterator();

		while (var22.hasNext()) {
			blf var23 = (blf) var22.next();
			int var25 = 0;
			var11 = 0;

			while (var25 < 2 && var11 < 5) {
				++var11;
				var12 = var1.nextInt(6);
				if (var23.c[var12]) {
					var13 = BlockFace.getById(var12).getOpposite().getId();
					var23.c[var12] = false;
					var23.b[var12].c[var13] = false;
					if (var23.a(var21++) && var23.b[var12].a(var21++)) {
						++var25;
					} else {
						var23.c[var12] = true;
						var23.b[var12].c[var13] = true;
					}
				}
			}
		}

		var19.add(var15);
		var19.add(var16);
		var19.add(var18);
		return var19;
	}

	public boolean a(World var1, Random var2, CuboidArea var3) {
		this.a(false, 0, var1, var2, var3);
		this.a(true, 33, var1, var2, var3);
		this.b(var1, var2, var3);
		this.c(var1, var2, var3);
		this.d(var1, var2, var3);
		this.e(var1, var2, var3);
		this.f(var1, var2, var3);
		this.g(var1, var2, var3);

		int var4;
		for (var4 = 0; var4 < 7; ++var4) {
			int var5 = 0;

			while (var5 < 7) {
				if (var5 == 0 && var4 == 3) {
					var5 = 6;
				}

				int var6 = var4 * 9;
				int var7 = var5 * 9;

				for (int var8 = 0; var8 < 4; ++var8) {
					for (int var9 = 0; var9 < 4; ++var9) {
						this.a(var1, b, var6 + var8, 0, var7 + var9, var3);
						this.b(var1, b, var6 + var8, -1, var7 + var9, var3);
					}
				}

				if (var4 != 0 && var4 != 6) {
					var5 += 6;
				} else {
					++var5;
				}
			}
		}

		for (var4 = 0; var4 < 5; ++var4) {
			this.a(var1, var3, -1 - var4, 0 + var4 * 2, -1 - var4, -1 - var4, 23, 58 + var4, f, f, false);
			this.a(var1, var3, 58 + var4, 0 + var4 * 2, -1 - var4, 58 + var4, 23, 58 + var4, f, f, false);
			this.a(var1, var3, 0 - var4, 0 + var4 * 2, -1 - var4, 57 + var4, 23, -1 - var4, f, f, false);
			this.a(var1, var3, 0 - var4, 0 + var4 * 2, 58 + var4, 57 + var4, 23, 58 + var4, f, f, false);
		}

		Iterator var10 = this.q.iterator();

		while (var10.hasNext()) {
			blb var11 = (blb) var10.next();
			if (var11.c().a(var3)) {
				var11.a(var1, var2, var3);
			}
		}

		return true;
	}

	private void a(boolean var1, int var2, World var3, Random var4, CuboidArea var5) {
		boolean var6 = true;
		if (this.a(var5, var2, 0, var2 + 23, 20)) {
			this.a(var3, var5, var2 + 0, 0, 0, var2 + 24, 0, 20, a, a, false);
			this.a(var3, var5, var2 + 0, 1, 0, var2 + 24, 10, 20, f, f, false);

			int var7;
			for (var7 = 0; var7 < 4; ++var7) {
				this.a(var3, var5, var2 + var7, var7 + 1, var7, var2 + var7, var7 + 1, 20, b, b, false);
				this.a(var3, var5, var2 + var7 + 7, var7 + 5, var7 + 7, var2 + var7 + 7, var7 + 5, 20, b, b, false);
				this.a(var3, var5, var2 + 17 - var7, var7 + 5, var7 + 7, var2 + 17 - var7, var7 + 5, 20, b, b, false);
				this.a(var3, var5, var2 + 24 - var7, var7 + 1, var7, var2 + 24 - var7, var7 + 1, 20, b, b, false);
				this.a(var3, var5, var2 + var7 + 1, var7 + 1, var7, var2 + 23 - var7, var7 + 1, var7, b, b, false);
				this.a(var3, var5, var2 + var7 + 8, var7 + 5, var7 + 7, var2 + 16 - var7, var7 + 5, var7 + 7, b, b, false);
			}

			this.a(var3, var5, var2 + 4, 4, 4, var2 + 6, 4, 20, a, a, false);
			this.a(var3, var5, var2 + 7, 4, 4, var2 + 17, 4, 6, a, a, false);
			this.a(var3, var5, var2 + 18, 4, 4, var2 + 20, 4, 20, a, a, false);
			this.a(var3, var5, var2 + 11, 8, 11, var2 + 13, 8, 20, a, a, false);
			this.a(var3, d, var2 + 12, 9, 12, var5);
			this.a(var3, d, var2 + 12, 9, 15, var5);
			this.a(var3, d, var2 + 12, 9, 18, var5);
			var7 = var1 ? var2 + 19 : var2 + 5;
			int var8 = var1 ? var2 + 5 : var2 + 19;

			int var9;
			for (var9 = 20; var9 >= 5; var9 -= 3) {
				this.a(var3, d, var7, 5, var9, var5);
			}

			for (var9 = 19; var9 >= 7; var9 -= 3) {
				this.a(var3, d, var8, 5, var9, var5);
			}

			for (var9 = 0; var9 < 4; ++var9) {
				int var10 = var1 ? var2 + (24 - (17 - var9 * 3)) : var2 + 17 - var9 * 3;
				this.a(var3, d, var10, 5, 5, var5);
			}

			this.a(var3, d, var8, 5, 5, var5);
			this.a(var3, var5, var2 + 11, 1, 12, var2 + 13, 7, 12, a, a, false);
			this.a(var3, var5, var2 + 12, 1, 11, var2 + 12, 7, 13, a, a, false);
		}

	}

	private void b(World var1, Random var2, CuboidArea var3) {
		if (this.a(var3, 22, 5, 35, 17)) {
			this.a(var1, var3, 25, 0, 0, 32, 8, 20, f, f, false);

			for (int var4 = 0; var4 < 4; ++var4) {
				this.a(var1, var3, 24, 2, 5 + var4 * 4, 24, 4, 5 + var4 * 4, b, b, false);
				this.a(var1, var3, 22, 4, 5 + var4 * 4, 23, 4, 5 + var4 * 4, b, b, false);
				this.a(var1, b, 25, 5, 5 + var4 * 4, var3);
				this.a(var1, b, 26, 6, 5 + var4 * 4, var3);
				this.a(var1, e, 26, 5, 5 + var4 * 4, var3);
				this.a(var1, var3, 33, 2, 5 + var4 * 4, 33, 4, 5 + var4 * 4, b, b, false);
				this.a(var1, var3, 34, 4, 5 + var4 * 4, 35, 4, 5 + var4 * 4, b, b, false);
				this.a(var1, b, 32, 5, 5 + var4 * 4, var3);
				this.a(var1, b, 31, 6, 5 + var4 * 4, var3);
				this.a(var1, e, 31, 5, 5 + var4 * 4, var3);
				this.a(var1, var3, 27, 6, 5 + var4 * 4, 30, 6, 5 + var4 * 4, a, a, false);
			}
		}

	}

	private void c(World var1, Random var2, CuboidArea var3) {
		if (this.a(var3, 15, 20, 42, 21)) {
			this.a(var1, var3, 15, 0, 21, 42, 0, 21, a, a, false);
			this.a(var1, var3, 26, 1, 21, 31, 3, 21, f, f, false);
			this.a(var1, var3, 21, 12, 21, 36, 12, 21, a, a, false);
			this.a(var1, var3, 17, 11, 21, 40, 11, 21, a, a, false);
			this.a(var1, var3, 16, 10, 21, 41, 10, 21, a, a, false);
			this.a(var1, var3, 15, 7, 21, 42, 9, 21, a, a, false);
			this.a(var1, var3, 16, 6, 21, 41, 6, 21, a, a, false);
			this.a(var1, var3, 17, 5, 21, 40, 5, 21, a, a, false);
			this.a(var1, var3, 21, 4, 21, 36, 4, 21, a, a, false);
			this.a(var1, var3, 22, 3, 21, 26, 3, 21, a, a, false);
			this.a(var1, var3, 31, 3, 21, 35, 3, 21, a, a, false);
			this.a(var1, var3, 23, 2, 21, 25, 2, 21, a, a, false);
			this.a(var1, var3, 32, 2, 21, 34, 2, 21, a, a, false);
			this.a(var1, var3, 28, 4, 20, 29, 4, 21, b, b, false);
			this.a(var1, b, 27, 3, 21, var3);
			this.a(var1, b, 30, 3, 21, var3);
			this.a(var1, b, 26, 2, 21, var3);
			this.a(var1, b, 31, 2, 21, var3);
			this.a(var1, b, 25, 1, 21, var3);
			this.a(var1, b, 32, 1, 21, var3);

			int var4;
			for (var4 = 0; var4 < 7; ++var4) {
				this.a(var1, c, 28 - var4, 6 + var4, 21, var3);
				this.a(var1, c, 29 + var4, 6 + var4, 21, var3);
			}

			for (var4 = 0; var4 < 4; ++var4) {
				this.a(var1, c, 28 - var4, 9 + var4, 21, var3);
				this.a(var1, c, 29 + var4, 9 + var4, 21, var3);
			}

			this.a(var1, c, 28, 12, 21, var3);
			this.a(var1, c, 29, 12, 21, var3);

			for (var4 = 0; var4 < 3; ++var4) {
				this.a(var1, c, 22 - var4 * 2, 8, 21, var3);
				this.a(var1, c, 22 - var4 * 2, 9, 21, var3);
				this.a(var1, c, 35 + var4 * 2, 8, 21, var3);
				this.a(var1, c, 35 + var4 * 2, 9, 21, var3);
			}

			this.a(var1, var3, 15, 13, 21, 42, 15, 21, f, f, false);
			this.a(var1, var3, 15, 1, 21, 15, 6, 21, f, f, false);
			this.a(var1, var3, 16, 1, 21, 16, 5, 21, f, f, false);
			this.a(var1, var3, 17, 1, 21, 20, 4, 21, f, f, false);
			this.a(var1, var3, 21, 1, 21, 21, 3, 21, f, f, false);
			this.a(var1, var3, 22, 1, 21, 22, 2, 21, f, f, false);
			this.a(var1, var3, 23, 1, 21, 24, 1, 21, f, f, false);
			this.a(var1, var3, 42, 1, 21, 42, 6, 21, f, f, false);
			this.a(var1, var3, 41, 1, 21, 41, 5, 21, f, f, false);
			this.a(var1, var3, 37, 1, 21, 40, 4, 21, f, f, false);
			this.a(var1, var3, 36, 1, 21, 36, 3, 21, f, f, false);
			this.a(var1, var3, 35, 1, 21, 35, 2, 21, f, f, false);
			this.a(var1, var3, 33, 1, 21, 34, 1, 21, f, f, false);
		}

	}

	private void d(World var1, Random var2, CuboidArea var3) {
		if (this.a(var3, 21, 21, 36, 36)) {
			this.a(var1, var3, 21, 0, 22, 36, 0, 36, a, a, false);
			this.a(var1, var3, 21, 1, 22, 36, 23, 36, f, f, false);

			for (int var4 = 0; var4 < 4; ++var4) {
				this.a(var1, var3, 21 + var4, 13 + var4, 21 + var4, 36 - var4, 13 + var4, 21 + var4, b, b, false);
				this.a(var1, var3, 21 + var4, 13 + var4, 36 - var4, 36 - var4, 13 + var4, 36 - var4, b, b, false);
				this.a(var1, var3, 21 + var4, 13 + var4, 22 + var4, 21 + var4, 13 + var4, 35 - var4, b, b, false);
				this.a(var1, var3, 36 - var4, 13 + var4, 22 + var4, 36 - var4, 13 + var4, 35 - var4, b, b, false);
			}

			this.a(var1, var3, 25, 16, 25, 32, 16, 32, a, a, false);
			this.a(var1, var3, 25, 17, 25, 25, 19, 25, b, b, false);
			this.a(var1, var3, 32, 17, 25, 32, 19, 25, b, b, false);
			this.a(var1, var3, 25, 17, 32, 25, 19, 32, b, b, false);
			this.a(var1, var3, 32, 17, 32, 32, 19, 32, b, b, false);
			this.a(var1, b, 26, 20, 26, var3);
			this.a(var1, b, 27, 21, 27, var3);
			this.a(var1, e, 27, 20, 27, var3);
			this.a(var1, b, 26, 20, 31, var3);
			this.a(var1, b, 27, 21, 30, var3);
			this.a(var1, e, 27, 20, 30, var3);
			this.a(var1, b, 31, 20, 31, var3);
			this.a(var1, b, 30, 21, 30, var3);
			this.a(var1, e, 30, 20, 30, var3);
			this.a(var1, b, 31, 20, 26, var3);
			this.a(var1, b, 30, 21, 27, var3);
			this.a(var1, e, 30, 20, 27, var3);
			this.a(var1, var3, 28, 21, 27, 29, 21, 27, a, a, false);
			this.a(var1, var3, 27, 21, 28, 27, 21, 29, a, a, false);
			this.a(var1, var3, 28, 21, 30, 29, 21, 30, a, a, false);
			this.a(var1, var3, 30, 21, 28, 30, 21, 29, a, a, false);
		}

	}

	private void e(World var1, Random var2, CuboidArea var3) {
		int var4;
		if (this.a(var3, 0, 21, 6, 58)) {
			this.a(var1, var3, 0, 0, 21, 6, 0, 57, a, a, false);
			this.a(var1, var3, 0, 1, 21, 6, 7, 57, f, f, false);
			this.a(var1, var3, 4, 4, 21, 6, 4, 53, a, a, false);

			for (var4 = 0; var4 < 4; ++var4) {
				this.a(var1, var3, var4, var4 + 1, 21, var4, var4 + 1, 57 - var4, b, b, false);
			}

			for (var4 = 23; var4 < 53; var4 += 3) {
				this.a(var1, d, 5, 5, var4, var3);
			}

			this.a(var1, d, 5, 5, 52, var3);

			for (var4 = 0; var4 < 4; ++var4) {
				this.a(var1, var3, var4, var4 + 1, 21, var4, var4 + 1, 57 - var4, b, b, false);
			}

			this.a(var1, var3, 4, 1, 52, 6, 3, 52, a, a, false);
			this.a(var1, var3, 5, 1, 51, 5, 3, 53, a, a, false);
		}

		if (this.a(var3, 51, 21, 58, 58)) {
			this.a(var1, var3, 51, 0, 21, 57, 0, 57, a, a, false);
			this.a(var1, var3, 51, 1, 21, 57, 7, 57, f, f, false);
			this.a(var1, var3, 51, 4, 21, 53, 4, 53, a, a, false);

			for (var4 = 0; var4 < 4; ++var4) {
				this.a(var1, var3, 57 - var4, var4 + 1, 21, 57 - var4, var4 + 1, 57 - var4, b, b, false);
			}

			for (var4 = 23; var4 < 53; var4 += 3) {
				this.a(var1, d, 52, 5, var4, var3);
			}

			this.a(var1, d, 52, 5, 52, var3);
			this.a(var1, var3, 51, 1, 52, 53, 3, 52, a, a, false);
			this.a(var1, var3, 52, 1, 51, 52, 3, 53, a, a, false);
		}

		if (this.a(var3, 0, 51, 57, 57)) {
			this.a(var1, var3, 7, 0, 51, 50, 0, 57, a, a, false);
			this.a(var1, var3, 7, 1, 51, 50, 10, 57, f, f, false);

			for (var4 = 0; var4 < 4; ++var4) {
				this.a(var1, var3, var4 + 1, var4 + 1, 57 - var4, 56 - var4, var4 + 1, 57 - var4, b, b, false);
			}
		}

	}

	private void f(World var1, Random var2, CuboidArea var3) {
		int var4;
		if (this.a(var3, 7, 21, 13, 50)) {
			this.a(var1, var3, 7, 0, 21, 13, 0, 50, a, a, false);
			this.a(var1, var3, 7, 1, 21, 13, 10, 50, f, f, false);
			this.a(var1, var3, 11, 8, 21, 13, 8, 53, a, a, false);

			for (var4 = 0; var4 < 4; ++var4) {
				this.a(var1, var3, var4 + 7, var4 + 5, 21, var4 + 7, var4 + 5, 54, b, b, false);
			}

			for (var4 = 21; var4 <= 45; var4 += 3) {
				this.a(var1, d, 12, 9, var4, var3);
			}
		}

		if (this.a(var3, 44, 21, 50, 54)) {
			this.a(var1, var3, 44, 0, 21, 50, 0, 50, a, a, false);
			this.a(var1, var3, 44, 1, 21, 50, 10, 50, f, f, false);
			this.a(var1, var3, 44, 8, 21, 46, 8, 53, a, a, false);

			for (var4 = 0; var4 < 4; ++var4) {
				this.a(var1, var3, 50 - var4, var4 + 5, 21, 50 - var4, var4 + 5, 54, b, b, false);
			}

			for (var4 = 21; var4 <= 45; var4 += 3) {
				this.a(var1, d, 45, 9, var4, var3);
			}
		}

		if (this.a(var3, 8, 44, 49, 54)) {
			this.a(var1, var3, 14, 0, 44, 43, 0, 50, a, a, false);
			this.a(var1, var3, 14, 1, 44, 43, 10, 50, f, f, false);

			for (var4 = 12; var4 <= 45; var4 += 3) {
				this.a(var1, d, var4, 9, 45, var3);
				this.a(var1, d, var4, 9, 52, var3);
				if (var4 == 12 || var4 == 18 || var4 == 24 || var4 == 33 || var4 == 39 || var4 == 45) {
					this.a(var1, d, var4, 9, 47, var3);
					this.a(var1, d, var4, 9, 50, var3);
					this.a(var1, d, var4, 10, 45, var3);
					this.a(var1, d, var4, 10, 46, var3);
					this.a(var1, d, var4, 10, 51, var3);
					this.a(var1, d, var4, 10, 52, var3);
					this.a(var1, d, var4, 11, 47, var3);
					this.a(var1, d, var4, 11, 50, var3);
					this.a(var1, d, var4, 12, 48, var3);
					this.a(var1, d, var4, 12, 49, var3);
				}
			}

			for (var4 = 0; var4 < 3; ++var4) {
				this.a(var1, var3, 8 + var4, 5 + var4, 54, 49 - var4, 5 + var4, 54, a, a, false);
			}

			this.a(var1, var3, 11, 8, 54, 46, 8, 54, b, b, false);
			this.a(var1, var3, 14, 8, 44, 43, 8, 53, a, a, false);
		}

	}

	private void g(World var1, Random var2, CuboidArea var3) {
		int var4;
		if (this.a(var3, 14, 21, 20, 43)) {
			this.a(var1, var3, 14, 0, 21, 20, 0, 43, a, a, false);
			this.a(var1, var3, 14, 1, 22, 20, 14, 43, f, f, false);
			this.a(var1, var3, 18, 12, 22, 20, 12, 39, a, a, false);
			this.a(var1, var3, 18, 12, 21, 20, 12, 21, b, b, false);

			for (var4 = 0; var4 < 4; ++var4) {
				this.a(var1, var3, var4 + 14, var4 + 9, 21, var4 + 14, var4 + 9, 43 - var4, b, b, false);
			}

			for (var4 = 23; var4 <= 39; var4 += 3) {
				this.a(var1, d, 19, 13, var4, var3);
			}
		}

		if (this.a(var3, 37, 21, 43, 43)) {
			this.a(var1, var3, 37, 0, 21, 43, 0, 43, a, a, false);
			this.a(var1, var3, 37, 1, 22, 43, 14, 43, f, f, false);
			this.a(var1, var3, 37, 12, 22, 39, 12, 39, a, a, false);
			this.a(var1, var3, 37, 12, 21, 39, 12, 21, b, b, false);

			for (var4 = 0; var4 < 4; ++var4) {
				this.a(var1, var3, 43 - var4, var4 + 9, 21, 43 - var4, var4 + 9, 43 - var4, b, b, false);
			}

			for (var4 = 23; var4 <= 39; var4 += 3) {
				this.a(var1, d, 38, 13, var4, var3);
			}
		}

		if (this.a(var3, 15, 37, 42, 43)) {
			this.a(var1, var3, 21, 0, 37, 36, 0, 43, a, a, false);
			this.a(var1, var3, 21, 1, 37, 36, 14, 43, f, f, false);
			this.a(var1, var3, 21, 12, 37, 36, 12, 39, a, a, false);

			for (var4 = 0; var4 < 4; ++var4) {
				this.a(var1, var3, 15 + var4, var4 + 9, 43 - var4, 42 - var4, var4 + 9, 43 - var4, b, b, false);
			}

			for (var4 = 21; var4 <= 36; var4 += 3) {
				this.a(var1, d, var4, 13, 38, var3);
			}
		}

	}
}

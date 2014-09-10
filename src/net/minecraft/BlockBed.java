package net.minecraft;

import java.util.Iterator;
import java.util.Random;

public class BlockBed extends avb {

	public static final bev a = bev.a("part", atq.class);
	public static final bet b = bet.a("occupied");

	public BlockBed() {
		super(Material.CLOTH);
		this.setBlockState(this.L.b().a(a, atq.b).a(b, Boolean.valueOf(false)));
		this.j();
	}

	public boolean a(World var1, Position var2, BlockState var3, EntityHuman var4, BlockFace var5, float var6, float var7, float var8) {
		if (var1.D) {
			return true;
		} else {
			if (var3.b(a) != atq.a) {
				var2 = var2.a((BlockFace) var3.b(N));
				var3 = var1.getBlockState(var2);
				if (var3.getBlock() != this) {
					return true;
				}
			}

			if (var1.worldProvider.isPrimaryWorld() && var1.b(var2) != arm.x) {
				if (((Boolean) var3.b(b)).booleanValue()) {
					EntityHuman var10 = this.e(var1, var2);
					if (var10 != null) {
						var4.b((IChatBaseComponent) (new ChatMessage("tile.bed.occupied", new Object[0])));
						return true;
					}

					var3 = var3.a(b, Boolean.valueOf(false));
					var1.a(var2, var3, 4);
				}

				ahf var11 = var4.a(var2);
				if (var11 == ahf.a) {
					var3 = var3.a(b, Boolean.valueOf(true));
					var1.a(var2, var3, 4);
					return true;
				} else {
					if (var11 == ahf.c) {
						var4.b((IChatBaseComponent) (new ChatMessage("tile.bed.noSleep", new Object[0])));
					} else if (var11 == ahf.f) {
						var4.b((IChatBaseComponent) (new ChatMessage("tile.bed.notSafe", new Object[0])));
					}

					return true;
				}
			} else {
				var1.g(var2);
				Position var9 = var2.a(((BlockFace) var3.b(N)).getOpposite());
				if (var1.getBlockState(var9).getBlock() == this) {
					var1.g(var9);
				}

				var1.a((Entity) null, (double) var2.getX() + 0.5D, (double) var2.getY() + 0.5D, (double) var2.getZ() + 0.5D, 5.0F, true, true);
				return true;
			}
		}
	}

	private EntityHuman e(World var1, Position var2) {
		Iterator var3 = var1.j.iterator();

		EntityHuman var4;
		do {
			if (!var3.hasNext()) {
				return null;
			}

			var4 = (EntityHuman) var3.next();
		} while (!var4.isSleeping() || !var4.bv.equals(var2));

		return var4;
	}

	public boolean d() {
		return false;
	}

	public boolean c() {
		return false;
	}

	public void a(ard var1, Position var2) {
		this.j();
	}

	public void a(World var1, Position var2, BlockState var3, Block var4) {
		BlockFace var5 = (BlockFace) var3.b(N);
		if (var3.b(a) == atq.a) {
			if (var1.getBlockState(var2.a(var5.getOpposite())).getBlock() != this) {
				var1.g(var2);
			}
		} else if (var1.getBlockState(var2.a(var5)).getBlock() != this) {
			var1.g(var2);
			if (!var1.D) {
				this.b(var1, var2, var3, 0);
			}
		}

	}

	public Item a(BlockState var1, Random var2, int var3) {
		return var1.b(a) == atq.a ? null : Items.BED;
	}

	private void j() {
		this.a(0.0F, 0.0F, 0.0F, 1.0F, 0.5625F, 1.0F);
	}

	public static Position a(World var0, Position var1, int var2) {
		BlockFace var3 = (BlockFace) var0.getBlockState(var1).b(N);
		int var4 = var1.getX();
		int var5 = var1.getY();
		int var6 = var1.getZ();

		for (int var7 = 0; var7 <= 1; ++var7) {
			int var8 = var4 - var3.g() * var7 - 1;
			int var9 = var6 - var3.i() * var7 - 1;
			int var10 = var8 + 2;
			int var11 = var9 + 2;

			for (int var12 = var8; var12 <= var10; ++var12) {
				for (int var13 = var9; var13 <= var11; ++var13) {
					Position var14 = new Position(var12, var5, var13);
					if (d(var0, var14)) {
						if (var2 <= 0) {
							return var14;
						}

						--var2;
					}
				}
			}
		}

		return null;
	}

	protected static boolean d(World var0, Position var1) {
		return World.a((ard) var0, var1.b()) && !var0.getBlockState(var1).getBlock().getMaterial().isBuildable() && !var0.getBlockState(var1.a()).getBlock().getMaterial().isBuildable();
	}

	public void a(World var1, Position var2, BlockState var3, float var4, int var5) {
		if (var3.b(a) == atq.b) {
			super.a(var1, var2, var3, var4, 0);
		}

	}

	public int i() {
		return 1;
	}

	public void a(World var1, Position var2, BlockState var3, EntityHuman var4) {
		if (var4.playerProperties.instabuild && var3.b(a) == atq.a) {
			Position var5 = var2.a(((BlockFace) var3.b(N)).getOpposite());
			if (var1.getBlockState(var5).getBlock() == this) {
				var1.g(var5);
			}
		}

	}

	public BlockState a(int var1) {
		BlockFace var2 = BlockFace.fromDirection(var1);
		return (var1 & 8) > 0 ? this.getBlockState().a(a, atq.a).a(N, var2).a(b, Boolean.valueOf((var1 & 4) > 0)) : this.getBlockState().a(a, atq.b).a(N, var2);
	}

	public BlockState a(BlockState var1, ard var2, Position var3) {
		if (var1.b(a) == atq.b) {
			BlockState var4 = var2.getBlockState(var3.a((BlockFace) var1.b(N)));
			if (var4.getBlock() == this) {
				var1 = var1.a(b, var4.b(b));
			}
		}

		return var1;
	}

	public int c(BlockState var1) {
		byte var2 = 0;
		int var3 = var2 | ((BlockFace) var1.b(N)).toDirection();
		if (var1.b(a) == atq.a) {
			var3 |= 8;
			if (((Boolean) var1.b(b)).booleanValue()) {
				var3 |= 4;
			}
		}

		return var3;
	}

	protected bed e() {
		return new bed(this, new bex[] { N, a, b });
	}

}

package net.minecraft;

import com.google.common.collect.Lists;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class WorldGenStrongholdPieces {

	private static final WorldGenStrongholdPieceWeight[] b = new WorldGenStrongholdPieceWeight[] { new WorldGenStrongholdPieceWeight(WorldGenStrongholdStairs.class, 40, 0), new WorldGenStrongholdPieceWeight(WorldGenStrongholdPrison.class, 5, 5), new WorldGenStrongholdPieceWeight(WorldGenStrongholdLeftTurn.class, 20, 0), new WorldGenStrongholdPieceWeight(WorldGenStrongholdRightTurn.class, 20, 0), new WorldGenStrongholdPieceWeight(WorldGenStrongholdRoomCrossing.class, 10, 6), new WorldGenStrongholdPieceWeight(WorldGenStrongholdStairsStraight.class, 5, 5), new WorldGenStrongholdPieceWeight(WorldGenStrongholdStairs2.class, 5, 5), new WorldGenStrongholdPieceWeight(WorldGenStrongholdCrossing.class, 5, 4), new WorldGenStrongholdPieceWeight(WorldGenStrongholdChestCorridor.class, 5, 4), new WorldGenStrongholdUnknown(WorldGenStrongholdLibrary.class, 10, 2), new WorldGenStrongholdPiece2(WorldGenStrongholdPortalRoom.class, 20, 1) };
	private static List c;
	private static Class d;
	static int a;
	private static final WorldGenStrongholdStones e = new WorldGenStrongholdStones((WorldGenStrongholdUnknown) null);

	public static void a() {
		WorldGenFactory.a(WorldGenStrongholdChestCorridor.class, "SHCC");
		WorldGenFactory.a(WorldGenStrongholdCorridor.class, "SHFC");
		WorldGenFactory.a(WorldGenStrongholdCrossing.class, "SH5C");
		WorldGenFactory.a(WorldGenStrongholdLeftTurn.class, "SHLT");
		WorldGenFactory.a(WorldGenStrongholdLibrary.class, "SHLi");
		WorldGenFactory.a(WorldGenStrongholdPortalRoom.class, "SHPR");
		WorldGenFactory.a(WorldGenStrongholdPrison.class, "SHPH");
		WorldGenFactory.a(WorldGenStrongholdRightTurn.class, "SHRT");
		WorldGenFactory.a(WorldGenStrongholdRoomCrossing.class, "SHRC");
		WorldGenFactory.a(WorldGenStrongholdStairs2.class, "SHSD");
		WorldGenFactory.a(WorldGenStrongholdStart.class, "SHStart");
		WorldGenFactory.a(WorldGenStrongholdStairs.class, "SHS");
		WorldGenFactory.a(WorldGenStrongholdStairsStraight.class, "SHSSD");
	}

	public static void b() {
		c = Lists.newArrayList();
		WorldGenStrongholdPieceWeight[] var0 = b;
		int var1 = var0.length;

		for (int var2 = 0; var2 < var1; ++var2) {
			WorldGenStrongholdPieceWeight var3 = var0[var2];
			var3.c = 0;
			c.add(var3);
		}

		d = null;
	}

	private static boolean d() {
		boolean var0 = false;
		a = 0;

		WorldGenStrongholdPieceWeight var2;
		for (Iterator var1 = c.iterator(); var1.hasNext(); a += var2.b) {
			var2 = (WorldGenStrongholdPieceWeight) var1.next();
			if (var2.d > 0 && var2.c < var2.d) {
				var0 = true;
			}
		}

		return var0;
	}

	private static WorldGenStrongholdPiece a(Class var0, List var1, Random var2, int var3, int var4, int var5, BlockFace var6, int var7) {
		Object var8 = null;
		if (var0 == WorldGenStrongholdStairs.class) {
			var8 = WorldGenStrongholdStairs.a(var1, var2, var3, var4, var5, var6, var7);
		} else if (var0 == WorldGenStrongholdPrison.class) {
			var8 = WorldGenStrongholdPrison.a(var1, var2, var3, var4, var5, var6, var7);
		} else if (var0 == WorldGenStrongholdLeftTurn.class) {
			var8 = WorldGenStrongholdLeftTurn.a(var1, var2, var3, var4, var5, var6, var7);
		} else if (var0 == WorldGenStrongholdRightTurn.class) {
			var8 = WorldGenStrongholdRightTurn.a(var1, var2, var3, var4, var5, var6, var7);
		} else if (var0 == WorldGenStrongholdRoomCrossing.class) {
			var8 = WorldGenStrongholdRoomCrossing.a(var1, var2, var3, var4, var5, var6, var7);
		} else if (var0 == WorldGenStrongholdStairsStraight.class) {
			var8 = WorldGenStrongholdStairsStraight.a(var1, var2, var3, var4, var5, var6, var7);
		} else if (var0 == WorldGenStrongholdStairs2.class) {
			var8 = WorldGenStrongholdStairs2.a(var1, var2, var3, var4, var5, var6, var7);
		} else if (var0 == WorldGenStrongholdCrossing.class) {
			var8 = WorldGenStrongholdCrossing.a(var1, var2, var3, var4, var5, var6, var7);
		} else if (var0 == WorldGenStrongholdChestCorridor.class) {
			var8 = WorldGenStrongholdChestCorridor.a(var1, var2, var3, var4, var5, var6, var7);
		} else if (var0 == WorldGenStrongholdLibrary.class) {
			var8 = WorldGenStrongholdLibrary.a(var1, var2, var3, var4, var5, var6, var7);
		} else if (var0 == WorldGenStrongholdPortalRoom.class) {
			var8 = WorldGenStrongholdPortalRoom.a(var1, var2, var3, var4, var5, var6, var7);
		}

		return (WorldGenStrongholdPiece) var8;
	}

	private static WorldGenStrongholdPiece b(WorldGenStrongholdStart var0, List var1, Random var2, int var3, int var4, int var5, BlockFace var6, int var7) {
		if (!d()) {
			return null;
		} else {
			if (d != null) {
				WorldGenStrongholdPiece var8 = a(d, var1, var2, var3, var4, var5, var6, var7);
				d = null;
				if (var8 != null) {
					return var8;
				}
			}

			int var13 = 0;

			while (var13 < 5) {
				++var13;
				int var9 = var2.nextInt(a);
				Iterator var10 = c.iterator();

				while (var10.hasNext()) {
					WorldGenStrongholdPieceWeight var11 = (WorldGenStrongholdPieceWeight) var10.next();
					var9 -= var11.b;
					if (var9 < 0) {
						if (!var11.a(var7) || var11 == var0.a) {
							break;
						}

						WorldGenStrongholdPiece var12 = a(var11.a, var1, var2, var3, var4, var5, var6, var7);
						if (var12 != null) {
							++var11.c;
							var0.a = var11;
							if (!var11.a()) {
								c.remove(var11);
							}

							return var12;
						}
					}
				}
			}

			CuboidArea var14 = WorldGenStrongholdCorridor.a(var1, var2, var3, var4, var5, var6);
			if (var14 != null && var14.minY > 1) {
				return new WorldGenStrongholdCorridor(var7, var2, var14, var6);
			} else {
				return null;
			}
		}
	}

	private static StructurePiece c(WorldGenStrongholdStart var0, List var1, Random var2, int var3, int var4, int var5, BlockFace var6, int var7) {
		if (var7 > 50) {
			return null;
		} else if (Math.abs(var3 - var0.c().minX) <= 112 && Math.abs(var5 - var0.c().minZ) <= 112) {
			WorldGenStrongholdPiece var8 = b(var0, var1, var2, var3, var4, var5, var6, var7 + 1);
			if (var8 != null) {
				var1.add(var8);
				var0.c.add(var8);
			}

			return var8;
		} else {
			return null;
		}
	}

	// $FF: synthetic method
	static StructurePiece a(WorldGenStrongholdStart var0, List var1, Random var2, int var3, int var4, int var5, BlockFace var6, int var7) {
		return c(var0, var1, var2, var3, var4, var5, var6, var7);
	}

	// $FF: synthetic method
	static Class a(Class var0) {
		d = var0;
		return var0;
	}

	// $FF: synthetic method
	static WorldGenStrongholdStones c() {
		return e;
	}

}

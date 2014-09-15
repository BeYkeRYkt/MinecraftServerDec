package net.minecraft;

import java.util.List;
import java.util.Random;

public class WorldGenNetherPieces {

	private static final WorldGenNetherPieceWeight[] a = new WorldGenNetherPieceWeight[] { new WorldGenNetherPieceWeight(WorldGenNetherPiece3.class, 30, 0, true), new WorldGenNetherPieceWeight(WorldGenNetherPiece1.class, 10, 4), new WorldGenNetherPieceWeight(WorldGenNetherPiece13.class, 10, 4), new WorldGenNetherPieceWeight(WorldGenNetherPiece16.class, 10, 3), new WorldGenNetherPieceWeight(WorldGenNetherPiece12.class, 5, 2), new WorldGenNetherPieceWeight(WorldGenNetherPiece6.class, 5, 1) };
	private static final WorldGenNetherPieceWeight[] b = new WorldGenNetherPieceWeight[] { new WorldGenNetherPieceWeight(WorldGenNetherPiece9.class, 25, 0, true), new WorldGenNetherPieceWeight(WorldGenNetherPiece7.class, 15, 5), new WorldGenNetherPieceWeight(WorldGenNetherPiece10.class, 5, 10), new WorldGenNetherPieceWeight(WorldGenNetherPiece8.class, 5, 10), new WorldGenNetherPieceWeight(WorldGenNetherPiece4.class, 10, 3, true), new WorldGenNetherPieceWeight(WorldGenNetherPiece5.class, 7, 2), new WorldGenNetherPieceWeight(WorldGenNetherPiece11.class, 5, 2) };

	public static void a() {
		WorldGenFactory.a(WorldGenNetherPiece1.class, "NeBCr");
		WorldGenFactory.a(WorldGenNetherPiece2.class, "NeBEF");
		WorldGenFactory.a(WorldGenNetherPiece3.class, "NeBS");
		WorldGenFactory.a(WorldGenNetherPiece4.class, "NeCCS");
		WorldGenFactory.a(WorldGenNetherPiece5.class, "NeCTB");
		WorldGenFactory.a(WorldGenNetherPiece6.class, "NeCE");
		WorldGenFactory.a(WorldGenNetherPiece7.class, "NeSCSC");
		WorldGenFactory.a(WorldGenNetherPiece8.class, "NeSCLT");
		WorldGenFactory.a(WorldGenNetherPiece9.class, "NeSC");
		WorldGenFactory.a(WorldGenNetherPiece10.class, "NeSCRT");
		WorldGenFactory.a(WorldGenNetherPiece11.class, "NeCSR");
		WorldGenFactory.a(WorldGenNetherPiece12.class, "NeMT");
		WorldGenFactory.a(WorldGenNetherPiece13.class, "NeRC");
		WorldGenFactory.a(WorldGenNetherPiece16.class, "NeSR");
		WorldGenFactory.a(WorldGenNetherPiece15.class, "NeStart");
	}

	private static WorldGenNetherPiece b(WorldGenNetherPieceWeight var0, List var1, Random var2, int var3, int var4, int var5, BlockFace var6, int var7) {
		Class var8 = var0.a;
		Object var9 = null;
		if (var8 == WorldGenNetherPiece3.class) {
			var9 = WorldGenNetherPiece3.a(var1, var2, var3, var4, var5, var6, var7);
		} else if (var8 == WorldGenNetherPiece1.class) {
			var9 = WorldGenNetherPiece1.a(var1, var2, var3, var4, var5, var6, var7);
		} else if (var8 == WorldGenNetherPiece13.class) {
			var9 = WorldGenNetherPiece13.a(var1, var2, var3, var4, var5, var6, var7);
		} else if (var8 == WorldGenNetherPiece16.class) {
			var9 = WorldGenNetherPiece16.a(var1, var2, var3, var4, var5, var7, var6);
		} else if (var8 == WorldGenNetherPiece12.class) {
			var9 = WorldGenNetherPiece12.a(var1, var2, var3, var4, var5, var7, var6);
		} else if (var8 == WorldGenNetherPiece6.class) {
			var9 = WorldGenNetherPiece6.a(var1, var2, var3, var4, var5, var6, var7);
		} else if (var8 == WorldGenNetherPiece9.class) {
			var9 = WorldGenNetherPiece9.a(var1, var2, var3, var4, var5, var6, var7);
		} else if (var8 == WorldGenNetherPiece10.class) {
			var9 = WorldGenNetherPiece10.a(var1, var2, var3, var4, var5, var6, var7);
		} else if (var8 == WorldGenNetherPiece8.class) {
			var9 = WorldGenNetherPiece8.a(var1, var2, var3, var4, var5, var6, var7);
		} else if (var8 == WorldGenNetherPiece4.class) {
			var9 = WorldGenNetherPiece4.a(var1, var2, var3, var4, var5, var6, var7);
		} else if (var8 == WorldGenNetherPiece5.class) {
			var9 = WorldGenNetherPiece5.a(var1, var2, var3, var4, var5, var6, var7);
		} else if (var8 == WorldGenNetherPiece7.class) {
			var9 = WorldGenNetherPiece7.a(var1, var2, var3, var4, var5, var6, var7);
		} else if (var8 == WorldGenNetherPiece11.class) {
			var9 = WorldGenNetherPiece11.a(var1, var2, var3, var4, var5, var6, var7);
		}

		return (WorldGenNetherPiece) var9;
	}

	// $FF: synthetic method
	static WorldGenNetherPiece a(WorldGenNetherPieceWeight var0, List var1, Random var2, int var3, int var4, int var5, BlockFace var6, int var7) {
		return b(var0, var1, var2, var3, var4, var5, var6, var7);
	}

	// $FF: synthetic method
	static WorldGenNetherPieceWeight[] b() {
		return a;
	}

	// $FF: synthetic method
	static WorldGenNetherPieceWeight[] c() {
		return b;
	}

}

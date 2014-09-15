package net.minecraft;

import com.google.common.collect.Lists;
import java.util.List;
import java.util.Random;

public class WorldGenMineshaftPieces {

	private static final List a = Lists.newArrayList((Object[]) (new StructurePieceTreasure[] { new StructurePieceTreasure(Items.IRON_INGOT, 0, 1, 5, 10), new StructurePieceTreasure(Items.GOLD_INGOT, 0, 1, 3, 5), new StructurePieceTreasure(Items.REDSTONE, 0, 4, 9, 5), new StructurePieceTreasure(Items.DYE, akv.l.b(), 4, 9, 5), new StructurePieceTreasure(Items.DIAMOND, 0, 1, 2, 3), new StructurePieceTreasure(Items.COAL, 0, 3, 8, 10), new StructurePieceTreasure(Items.BREAD, 0, 1, 3, 15), new StructurePieceTreasure(Items.IRON_PICKAXE, 0, 1, 1, 1), new StructurePieceTreasure(Item.getItemOf(Blocks.RAIL), 0, 4, 8, 1), new StructurePieceTreasure(Items.MELON_SEEDS, 0, 2, 4, 10), new StructurePieceTreasure(Items.PUMPKIN_SEEDS, 0, 2, 4, 10), new StructurePieceTreasure(Items.SADDLE, 0, 1, 1, 3), new StructurePieceTreasure(Items.IRON_HORSE_ARMOR, 0, 1, 1, 1) }));

	public static void a() {
		WorldGenFactory.a(WorldGenMineshaftCorridor.class, "MSCorridor");
		WorldGenFactory.a(WorldGenMineshaftCross.class, "MSCrossing");
		WorldGenFactory.a(WorldGenMineshaftRoom.class, "MSRoom");
		WorldGenFactory.a(WorldGenMineshaftStairs.class, "MSStairs");
	}

	private static StructurePiece a(List var0, Random var1, int var2, int var3, int var4, BlockFace var5, int var6) {
		int var7 = var1.nextInt(100);
		CuboidArea var8;
		if (var7 >= 80) {
			var8 = WorldGenMineshaftCross.a(var0, var1, var2, var3, var4, var5);
			if (var8 != null) {
				return new WorldGenMineshaftCross(var6, var1, var8, var5);
			}
		} else if (var7 >= 70) {
			var8 = WorldGenMineshaftStairs.a(var0, var1, var2, var3, var4, var5);
			if (var8 != null) {
				return new WorldGenMineshaftStairs(var6, var1, var8, var5);
			}
		} else {
			var8 = WorldGenMineshaftCorridor.a(var0, var1, var2, var3, var4, var5);
			if (var8 != null) {
				return new WorldGenMineshaftCorridor(var6, var1, var8, var5);
			}
		}

		return null;
	}

	private static StructurePiece b(StructurePiece var0, List var1, Random var2, int var3, int var4, int var5, BlockFace var6, int var7) {
		if (var7 > 8) {
			return null;
		} else if (Math.abs(var3 - var0.c().minX) <= 80 && Math.abs(var5 - var0.c().minZ) <= 80) {
			StructurePiece var8 = a(var1, var2, var3, var4, var5, var6, var7 + 1);
			if (var8 != null) {
				var1.add(var8);
				var8.a(var0, var1, var2);
			}

			return var8;
		} else {
			return null;
		}
	}

	// $FF: synthetic method
	static StructurePiece a(StructurePiece var0, List var1, Random var2, int var3, int var4, int var5, BlockFace var6, int var7) {
		return b(var0, var1, var2, var3, var4, var5, var6, var7);
	}

	// $FF: synthetic method
	static List b() {
		return a;
	}

}

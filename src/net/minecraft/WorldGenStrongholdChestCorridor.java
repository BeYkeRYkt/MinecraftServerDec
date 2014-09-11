package net.minecraft;

import com.google.common.collect.Lists;
import java.util.List;
import java.util.Random;

public class WorldGenStrongholdChestCorridor extends WorldGenStrongholdPiece {

	private static final List a = Lists.newArrayList((Object[]) (new StructurePieceTreasure[] { new StructurePieceTreasure(Items.ENDER_PEARL, 0, 1, 1, 10), new StructurePieceTreasure(Items.DIAMOND, 0, 1, 3, 3), new StructurePieceTreasure(Items.IRON_INGOT, 0, 1, 5, 10), new StructurePieceTreasure(Items.GOLD_INGOT, 0, 1, 3, 5), new StructurePieceTreasure(Items.REDSTONE, 0, 4, 9, 5), new StructurePieceTreasure(Items.BREAD, 0, 1, 3, 15), new StructurePieceTreasure(Items.APPLE, 0, 1, 3, 15), new StructurePieceTreasure(Items.IRON_PICKAXE, 0, 1, 1, 5), new StructurePieceTreasure(Items.IRON_SWORD, 0, 1, 1, 5), new StructurePieceTreasure(Items.IRON_CHESTPLATE, 0, 1, 1, 5), new StructurePieceTreasure(Items.IRON_HELMET, 0, 1, 1, 5), new StructurePieceTreasure(Items.IRON_LEGGINS, 0, 1, 1, 5), new StructurePieceTreasure(Items.IRON_BOOTS, 0, 1, 1, 5), new StructurePieceTreasure(Items.GOLDEN_APPLE, 0, 1, 1, 1), new StructurePieceTreasure(Items.SADDLE, 0, 1, 1, 1),
			new StructurePieceTreasure(Items.IRON_HORSE_ARMOR, 0, 1, 1, 1), new StructurePieceTreasure(Items.GOLDEN_HORSE_ARMOR, 0, 1, 1, 1), new StructurePieceTreasure(Items.DIAMOND_HORSE_ARMOR, 0, 1, 1, 1) }));
	private boolean b;

	public WorldGenStrongholdChestCorridor() {
	}

	public WorldGenStrongholdChestCorridor(int var1, Random var2, CuboidArea var3, BlockFace var4) {
		super(var1);
		this.m = var4;
		this.d = this.a(var2);
		this.l = var3;
	}

	protected void a(NBTCompoundTag var1) {
		super.a(var1);
		var1.put("Chest", this.b);
	}

	protected void b(NBTCompoundTag var1) {
		super.b(var1);
		this.b = var1.getBoolean("Chest");
	}

	public void a(StructurePiece var1, List var2, Random var3) {
		this.a((WorldGenStrongholdStart) var1, var2, var3, 1, 1);
	}

	public static WorldGenStrongholdChestCorridor a(List var0, Random var1, int var2, int var3, int var4, BlockFace var5, int var6) {
		CuboidArea var7 = CuboidArea.a(var2, var3, var4, -1, -1, 0, 5, 5, 7, var5);
		return a(var7) && StructurePiece.a(var0, var7) == null ? new WorldGenStrongholdChestCorridor(var6, var1, var7, var5) : null;
	}

	public boolean a(World var1, Random var2, CuboidArea var3) {
		if (this.a(var1, var3)) {
			return false;
		} else {
			this.a(var1, var3, 0, 0, 0, 4, 4, 6, true, var2, WorldGenStrongholdPieces.c());
			this.a(var1, var2, var3, this.d, 1, 1, 0);
			this.a(var1, var2, var3, bml.a, 1, 1, 6);
			this.a(var1, var3, 3, 1, 2, 3, 1, 4, Blocks.STONEBRICK.getBlockState(), Blocks.STONEBRICK.getBlockState(), false);
			this.a(var1, Blocks.STONE_SLAB.a(bbg.f.a()), 3, 1, 1, var3);
			this.a(var1, Blocks.STONE_SLAB.a(bbg.f.a()), 3, 1, 5, var3);
			this.a(var1, Blocks.STONE_SLAB.a(bbg.f.a()), 3, 2, 2, var3);
			this.a(var1, Blocks.STONE_SLAB.a(bbg.f.a()), 3, 2, 4, var3);

			for (int var4 = 2; var4 <= 4; ++var4) {
				this.a(var1, Blocks.STONE_SLAB.a(bbg.f.a()), 2, 1, var4, var3);
			}

			if (!this.b && var3.b((fd) (new Position(this.a(3, 3), this.d(2), this.b(3, 3))))) {
				this.b = true;
				this.a(var1, var3, var2, 3, 2, 3, StructurePieceTreasure.a(a, new StructurePieceTreasure[] { Items.ENCHANTED_BOOK.b(var2) }), 2 + var2.nextInt(2));
			}

			return true;
		}
	}

}

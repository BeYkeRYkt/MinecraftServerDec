package net.minecraft;

import com.google.common.collect.Lists;
import java.util.List;
import java.util.Random;

public class bnj extends bnn {

	private static final List a = Lists.newArrayList((Object[]) (new vl[] { new vl(Items.DIAMOND, 0, 1, 3, 3), new vl(Items.IRON_INGOT, 0, 1, 5, 10), new vl(Items.GOLD_INGOT, 0, 1, 3, 5), new vl(Items.BREAD, 0, 1, 3, 15), new vl(Items.APPLE, 0, 1, 3, 15), new vl(Items.IRON_PICKAXE, 0, 1, 1, 5), new vl(Items.IRON_SWORD, 0, 1, 1, 5), new vl(Items.IRON_CHESTPLATE, 0, 1, 1, 5), new vl(Items.IRON_HELMET, 0, 1, 1, 5), new vl(Items.IRON_LEGGINS, 0, 1, 1, 5), new vl(Items.IRON_BOOTS, 0, 1, 1, 5), new vl(Item.getItemOf(Blocks.OBSIDIAN), 0, 3, 7, 5), new vl(Item.getItemOf(Blocks.SAPLING), 0, 3, 7, 5), new vl(Items.SADDLE, 0, 1, 1, 3),
			new vl(Items.IRON_HORSE_ARMOR, 0, 1, 1, 1), new vl(Items.GOLDEN_HORSE_ARMOR, 0, 1, 1, 1), new vl(Items.DIAMOND_HORSE_ARMOR, 0, 1, 1, 1) }));
	private boolean b;

	public bnj() {
	}

	public bnj(bnk var1, int var2, Random var3, bjb var4, BlockFace var5) {
		super(var1, var2);
		this.m = var5;
		this.l = var4;
	}

	public static bnj a(bnk var0, List var1, Random var2, int var3, int var4, int var5, BlockFace var6, int var7) {
		bjb var8 = bjb.a(var3, var4, var5, 0, 0, 0, 10, 6, 7, var6);
		return a(var8) && bms.a(var1, var8) == null ? new bnj(var0, var7, var2, var8, var6) : null;
	}

	protected void a(NBTCompoundTag var1) {
		super.a(var1);
		var1.put("Chest", this.b);
	}

	protected void b(NBTCompoundTag var1) {
		super.b(var1);
		this.b = var1.getBoolean("Chest");
	}

	public boolean a(World var1, Random var2, bjb var3) {
		if (this.h < 0) {
			this.h = this.b(var1, var3);
			if (this.h < 0) {
				return true;
			}

			this.l.a(0, this.h - this.l.e + 6 - 1, 0);
		}

		this.a(var1, var3, 0, 1, 0, 9, 4, 6, Blocks.AIR.P(), Blocks.AIR.P(), false);
		this.a(var1, var3, 0, 0, 0, 9, 0, 6, Blocks.COBBLESTONE.P(), Blocks.COBBLESTONE.P(), false);
		this.a(var1, var3, 0, 4, 0, 9, 4, 6, Blocks.COBBLESTONE.P(), Blocks.COBBLESTONE.P(), false);
		this.a(var1, var3, 0, 5, 0, 9, 5, 6, Blocks.STONE_SLAB.P(), Blocks.STONE_SLAB.P(), false);
		this.a(var1, var3, 1, 5, 1, 8, 5, 5, Blocks.AIR.P(), Blocks.AIR.P(), false);
		this.a(var1, var3, 1, 1, 0, 2, 3, 0, Blocks.PLANKS.P(), Blocks.PLANKS.P(), false);
		this.a(var1, var3, 0, 1, 0, 0, 4, 0, Blocks.LOG.P(), Blocks.LOG.P(), false);
		this.a(var1, var3, 3, 1, 0, 3, 4, 0, Blocks.LOG.P(), Blocks.LOG.P(), false);
		this.a(var1, var3, 0, 1, 6, 0, 4, 6, Blocks.LOG.P(), Blocks.LOG.P(), false);
		this.a(var1, Blocks.PLANKS.P(), 3, 3, 1, var3);
		this.a(var1, var3, 3, 1, 2, 3, 3, 2, Blocks.PLANKS.P(), Blocks.PLANKS.P(), false);
		this.a(var1, var3, 4, 1, 3, 5, 3, 3, Blocks.PLANKS.P(), Blocks.PLANKS.P(), false);
		this.a(var1, var3, 0, 1, 1, 0, 3, 5, Blocks.PLANKS.P(), Blocks.PLANKS.P(), false);
		this.a(var1, var3, 1, 1, 6, 5, 3, 6, Blocks.PLANKS.P(), Blocks.PLANKS.P(), false);
		this.a(var1, var3, 5, 1, 0, 5, 3, 0, Blocks.FENCE.P(), Blocks.FENCE.P(), false);
		this.a(var1, var3, 9, 1, 0, 9, 3, 0, Blocks.FENCE.P(), Blocks.FENCE.P(), false);
		this.a(var1, var3, 6, 1, 4, 9, 4, 6, Blocks.COBBLESTONE.P(), Blocks.COBBLESTONE.P(), false);
		this.a(var1, Blocks.FLOWING_LAVA.P(), 7, 1, 5, var3);
		this.a(var1, Blocks.FLOWING_LAVA.P(), 8, 1, 5, var3);
		this.a(var1, Blocks.IRON_BARS.P(), 9, 2, 5, var3);
		this.a(var1, Blocks.IRON_BARS.P(), 9, 2, 4, var3);
		this.a(var1, var3, 7, 2, 4, 8, 2, 5, Blocks.AIR.P(), Blocks.AIR.P(), false);
		this.a(var1, Blocks.COBBLESTONE.P(), 6, 1, 3, var3);
		this.a(var1, Blocks.FURNACE.P(), 6, 2, 3, var3);
		this.a(var1, Blocks.FURNACE.P(), 6, 3, 3, var3);
		this.a(var1, Blocks.DOUBLE_STONE_SLAB.P(), 8, 1, 1, var3);
		this.a(var1, Blocks.GLASS_PANE.P(), 0, 2, 2, var3);
		this.a(var1, Blocks.GLASS_PANE.P(), 0, 2, 4, var3);
		this.a(var1, Blocks.GLASS_PANE.P(), 2, 2, 6, var3);
		this.a(var1, Blocks.GLASS_PANE.P(), 4, 2, 6, var3);
		this.a(var1, Blocks.FENCE.P(), 2, 1, 4, var3);
		this.a(var1, Blocks.WOODEN_PRESSURE_PLATE.P(), 2, 2, 4, var3);
		this.a(var1, Blocks.PLANKS.P(), 1, 1, 5, var3);
		this.a(var1, Blocks.OAK_STAIRS.a(this.a(Blocks.OAK_STAIRS, 3)), 2, 1, 5, var3);
		this.a(var1, Blocks.OAK_STAIRS.a(this.a(Blocks.OAK_STAIRS, 1)), 1, 1, 4, var3);
		if (!this.b && var3.b((fd) (new Position(this.a(5, 5), this.d(1), this.b(5, 5))))) {
			this.b = true;
			this.a(var1, var3, var2, 5, 1, 5, a, 3 + var2.nextInt(6));
		}

		int var4;
		for (var4 = 6; var4 <= 8; ++var4) {
			if (this.a(var1, var4, 0, -1, var3).getBlock().r() == Material.AIR && this.a(var1, var4, -1, -1, var3).getBlock().r() != Material.AIR) {
				this.a(var1, Blocks.STONE_STAIRS.a(this.a(Blocks.STONE_STAIRS, 3)), var4, 0, -1, var3);
			}
		}

		for (var4 = 0; var4 < 7; ++var4) {
			for (int var5 = 0; var5 < 10; ++var5) {
				this.b(var1, var5, 6, var4, var3);
				this.b(var1, Blocks.COBBLESTONE.P(), var5, -1, var4, var3);
			}
		}

		this.a(var1, var3, 7, 1, 1, 1);
		return true;
	}

	protected int c(int var1, int var2) {
		return 3;
	}

}

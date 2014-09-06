package net.minecraft;

import com.google.common.collect.Sets;
import java.util.Set;

public class amu extends ItemTool {

	private static final Set c = Sets.newHashSet((Object[]) (new Block[] { Blocks.cs, Blocks.COAL_ORE, Blocks.COBBLESTONE, Blocks.DETECTOR_RAIL, Blocks.ah, Blocks.ag, Blocks.DOUBLE_STONE_SLAB, Blocks.GOLDEN_RAIL, Blocks.GOLD_BLOCK, Blocks.GOLD_ORE, Blocks.aI, Blocks.IRON_BLOCK, Blocks.IRON_ORE, Blocks.LAPIS_BLOCK, Blocks.LAPIS_ORE, Blocks.aD, Blocks.MOSSY_COBBLESTONE, Blocks.aV, Blocks.cB, Blocks.av, Blocks.aC, Blocks.SANDSTONE, Blocks.cM, Blocks.STONE, Blocks.STONE_SLAB }));

	protected amu(ami var1) {
		super(2.0F, var1, c);
	}

	public boolean b(Block var1) {
		return var1 == Blocks.OBSIDIAN ? this.b.d() == 3 : (var1 != Blocks.ah && var1 != Blocks.ag ? (var1 != Blocks.bP && var1 != Blocks.bT ? (var1 != Blocks.GOLD_BLOCK && var1 != Blocks.GOLD_ORE ? (var1 != Blocks.IRON_BLOCK && var1 != Blocks.IRON_ORE ? (var1 != Blocks.LAPIS_BLOCK && var1 != Blocks.LAPIS_ORE ? (var1 != Blocks.aC && var1 != Blocks.aD ? (var1.r() == Material.STONE ? true : (var1.r() == Material.ORE ? true : var1.r() == Material.HEAVY)) : this.b.d() >= 2) : this.b.d() >= 1) : this.b.d() >= 1) : this.b.d() >= 2) : this.b.d() >= 2) : this.b.d() >= 2);
	}

	public float a(ItemStack var1, Block var2) {
		return var2.r() != Material.ORE && var2.r() != Material.HEAVY && var2.r() != Material.STONE ? super.a(var1, var2) : this.a;
	}

}

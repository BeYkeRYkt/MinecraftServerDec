package net.minecraft;

import com.google.common.collect.Sets;
import java.util.Set;

public class ItemPickaxe extends ItemTool {

	private static final Set c = Sets.newHashSet((Object[]) (new Block[] { Blocks.ACTIVATOR_RAIL, Blocks.COAL_ORE, Blocks.COBBLESTONE, Blocks.DETECTOR_RAIL, Blocks.DIAMOND_BLOCK, Blocks.DIAMOND_ORE, Blocks.DOUBLE_STONE_SLAB, Blocks.GOLDEN_RAIL, Blocks.GOLD_BLOCK, Blocks.GOLD_ORE, Blocks.ICE, Blocks.IRON_BLOCK, Blocks.IRON_ORE, Blocks.LAPIS_BLOCK, Blocks.LAPIS_ORE, Blocks.LIT_REDSTONE_ORE, Blocks.MOSSY_COBBLESTONE, Blocks.NETHERRACK, Blocks.PACKED_ICE, Blocks.RAIL, Blocks.REDSTONE_ORE, Blocks.SANDSTONE, Blocks.RED_SANDSTONE, Blocks.STONE, Blocks.STONE_SLAB }));

	protected ItemPickaxe(EnumToolMaterial var1) {
		super(2.0F, var1, c);
	}

	public boolean canDestroySpecialBlock(Block var1) {
		return var1 == Blocks.OBSIDIAN ? this.b.d() == 3 : (var1 != Blocks.DIAMOND_BLOCK && var1 != Blocks.DIAMOND_ORE ? (var1 != Blocks.EMERALD_ORE && var1 != Blocks.EMERALD_BLOCK ? (var1 != Blocks.GOLD_BLOCK && var1 != Blocks.GOLD_ORE ? (var1 != Blocks.IRON_BLOCK && var1 != Blocks.IRON_ORE ? (var1 != Blocks.LAPIS_BLOCK && var1 != Blocks.LAPIS_ORE ? (var1 != Blocks.REDSTONE_ORE && var1 != Blocks.LIT_REDSTONE_ORE ? (var1.getMaterial() == Material.STONE ? true : (var1.getMaterial() == Material.ORE ? true : var1.getMaterial() == Material.HEAVY)) : this.b.d() >= 2) : this.b.d() >= 1) : this.b.d() >= 1) : this.b.d() >= 2) : this.b.d() >= 2) : this.b.d() >= 2);
	}

	public float a(ItemStack var1, Block var2) {
		return var2.getMaterial() != Material.ORE && var2.getMaterial() != Material.HEAVY && var2.getMaterial() != Material.STONE ? super.a(var1, var2) : this.a;
	}

}

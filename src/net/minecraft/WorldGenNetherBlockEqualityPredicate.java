package net.minecraft;

import com.google.common.base.Predicate;

public class WorldGenNetherBlockEqualityPredicate implements Predicate<IBlockState> {

	public static WorldGenNetherBlockEqualityPredicate create(Block block) {
		return new WorldGenNetherBlockEqualityPredicate(block);
	}

	private final Block block;

	private WorldGenNetherBlockEqualityPredicate(Block block) {
		this.block = block;
	}

	public boolean apply(IBlockState blockState) {
		return blockState != null && blockState.getBlock() == this.block;
	}

}

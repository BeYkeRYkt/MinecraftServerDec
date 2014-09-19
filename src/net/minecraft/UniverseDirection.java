package net.minecraft;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterators;

import java.util.Iterator;
import java.util.Random;

public enum UniverseDirection implements Predicate<BlockFace>, Iterable<BlockFace> {

	HORIZONTAL, VERTICAL;

	public BlockFace[] getBlockFaces() {
		switch (ek.c[this.ordinal()]) {
			case 1:
				return new BlockFace[] { BlockFace.NORTH, BlockFace.EAST, BlockFace.SOUTH, BlockFace.WEST };
			case 2:
				return new BlockFace[] { BlockFace.UP, BlockFace.DOWN };
			default:
				throw new Error("Someone\'s been tampering with the universe!");
		}
	}

	public BlockFace getRandomBlockFace(Random random) {
		BlockFace[] faces = this.getBlockFaces();
		return faces[random.nextInt(faces.length)];
	}

	public boolean apply(BlockFace blockFace) {
		return blockFace != null && blockFace.k().d() == this;
	}

	public Iterator<BlockFace> iterator() {
		return Iterators.forArray(this.getBlockFaces());
	}

}

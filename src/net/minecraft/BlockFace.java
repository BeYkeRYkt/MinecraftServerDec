package net.minecraft;

import com.google.common.collect.Maps;

import java.util.Map;
import java.util.Random;

public enum BlockFace implements va {

	DOWN(0, 1, -1, "down", em.b, el.b, new fd(0, -1, 0)), 
	UP(1, 0, -1, "up", em.a, el.b, new fd(0, 1, 0)), 
	NORTH(2, 3, 2, "north", em.b, el.c, new fd(0, 0, -1)), 
	SOUTH(3, 2, 0, "south", em.a, el.c, new fd(0, 0, 1)), 
	WEST(4, 5, 1, "west", em.b, el.a, new fd(-1, 0, 0)), 
	EAST(5, 4, 3, "east", em.a, el.a, new fd(1, 0, 0));

	private static final BlockFace[] byId = new BlockFace[6];
	private static final BlockFace[] directionById = new BlockFace[4];
	private static final Map<String, BlockFace> byName = Maps.newHashMap();

	static {
		for (BlockFace face : values()) {
			byId[face.id] = face;
			if (face.k().c()) {
				directionById[face.directionId] = face;
			}

			byName.put(face.getName().toLowerCase(), face);
		}
	}

	public static BlockFace getById(int id) {
		return byId[MathHelper.a(id % byId.length)];
	}

	public static BlockFace fromDirection(int directionId) {
		return directionById[MathHelper.a(directionId % directionById.length)];
	}

	public static BlockFace fromDirection(double entityYaw) {
		return fromDirection(MathHelper.toFixedPointInt(entityYaw / 90.0D + 0.5D) & 3);
	}

	public static BlockFace getRandom(Random random) {
		return values()[random.nextInt(values().length)];
	}

	private final int id;
	private final int oppositeId;
	private final int directionId;
	private final String name;
	private final el k;
	private final em l;

	private BlockFace(int id, int oppositeId, int directionId, String name, em var7, el var8, fd var9) {
		this.id = id;
		this.directionId = directionId;
		this.oppositeId = oppositeId;
		this.name = name;
		this.k = var8;
		this.l = var7;
	}

	public int getId() {
		return this.id;
	}

	public int toDirection() {
		return this.directionId;
	}

	public em c() {
		return this.l;
	}

	public BlockFace getOpposite() {
		return getById(this.oppositeId);
	}

	public BlockFace e() {
		switch (ek.b[this.ordinal()]) {
			case 1:
				return EAST;
			case 2:
				return SOUTH;
			case 3:
				return WEST;
			case 4:
				return NORTH;
			default:
				throw new IllegalStateException("Unable to get Y-rotated facing of " + this);
		}
	}

	public BlockFace f() {
		switch (ek.b[this.ordinal()]) {
			case 1:
				return WEST;
			case 2:
				return NORTH;
			case 3:
				return EAST;
			case 4:
				return SOUTH;
			default:
				throw new IllegalStateException("Unable to get CCW facing of " + this);
		}
	}

	public int g() {
		return this.k == el.a ? this.l.a() : 0;
	}

	public int h() {
		return this.k == el.b ? this.l.a() : 0;
	}

	public int i() {
		return this.k == el.c ? this.l.a() : 0;
	}

	public String getName() {
		return this.name;
	}

	public el k() {
		return this.k;
	}

	public String toString() {
		return this.name;
	}

	public String l() {
		return this.name;
	}

}

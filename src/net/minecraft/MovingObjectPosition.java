package net.minecraft;

public class MovingObjectPosition {

	private Position position;
	public EnumMovingObjectType type;
	public BlockFace face;
	public Vec3D vec;
	public Entity entity;

	public MovingObjectPosition(Vec3D vec, BlockFace face, Position position) {
		this(EnumMovingObjectType.BLOCK, vec, face, position);
	}

	public MovingObjectPosition(Vec3D vec, BlockFace face) {
		this(EnumMovingObjectType.BLOCK, vec, face, Position.ZERO);
	}

	public MovingObjectPosition(Entity entity) {
		this(entity, new Vec3D(entity.locationX, entity.locationY, entity.locationZ));
	}

	public MovingObjectPosition(EnumMovingObjectType type, Vec3D vec, BlockFace face, Position position) {
		this.type = type;
		this.position = position;
		this.face = face;
		this.vec = new Vec3D(vec.x, vec.y, vec.z);
	}

	public MovingObjectPosition(Entity entity, Vec3D vec) {
		this.type = EnumMovingObjectType.ENTITY;
		this.entity = entity;
		this.vec = vec;
	}

	public Position getPosition() {
		return this.position;
	}

	public String toString() {
		return "HitResult{type=" + this.type + ", blockpos=" + this.position + ", f=" + this.face + ", pos=" + this.vec + ", entity=" + this.entity + '}';
	}

}

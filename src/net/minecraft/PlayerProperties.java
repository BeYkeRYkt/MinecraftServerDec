package net.minecraft;

public class PlayerProperties {

	public boolean invulnerable;
	public boolean flying;
	public boolean mayfly;
	public boolean instabuild;
	public boolean maybuild = true;
	private float flyspeed = 0.05F;
	private float walkspeed = 0.1F;

	public void write(NBTCompoundTag tag) {
		NBTCompoundTag var2 = new NBTCompoundTag();
		tag.put("invulnerable", this.invulnerable);
		tag.put("flying", this.flying);
		tag.put("mayfly", this.mayfly);
		tag.put("instabuild", this.instabuild);
		tag.put("mayBuild", this.maybuild);
		tag.put("flySpeed", this.flyspeed);
		tag.put("walkSpeed", this.walkspeed);
		tag.put("abilities", (NBTTag) var2);
	}

	public void read(NBTCompoundTag var1) {
		if (var1.isTagAssignableFrom("abilities", 10)) {
			NBTCompoundTag var2 = var1.getCompound("abilities");
			this.invulnerable = var2.getBoolean("invulnerable");
			this.flying = var2.getBoolean("flying");
			this.mayfly = var2.getBoolean("mayfly");
			this.instabuild = var2.getBoolean("instabuild");
			if (var2.isTagAssignableFrom("flySpeed", 99)) {
				this.flyspeed = var2.getFloat("flySpeed");
				this.walkspeed = var2.getFloat("walkSpeed");
			}

			if (var2.isTagAssignableFrom("mayBuild", 1)) {
				this.maybuild = var2.getBoolean("mayBuild");
			}
		}

	}

	public float getFlySpeed() {
		return this.flyspeed;
	}

	public float getWalkSpeed() {
		return this.walkspeed;
	}

}

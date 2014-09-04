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
		tag.a("invulnerable", this.invulnerable);
		tag.a("flying", this.flying);
		tag.a("mayfly", this.mayfly);
		tag.a("instabuild", this.instabuild);
		tag.a("mayBuild", this.maybuild);
		tag.a("flySpeed", this.flyspeed);
		tag.a("walkSpeed", this.walkspeed);
		tag.a("abilities", (NBTTag) var2);
	}

	public void read(NBTCompoundTag var1) {
		if (var1.b("abilities", 10)) {
			NBTCompoundTag var2 = var1.m("abilities");
			this.invulnerable = var2.n("invulnerable");
			this.flying = var2.n("flying");
			this.mayfly = var2.n("mayfly");
			this.instabuild = var2.n("instabuild");
			if (var2.b("flySpeed", 99)) {
				this.flyspeed = var2.h("flySpeed");
				this.walkspeed = var2.h("walkSpeed");
			}

			if (var2.b("mayBuild", 1)) {
				this.maybuild = var2.n("mayBuild");
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

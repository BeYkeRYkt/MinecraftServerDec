package net.minecraft;

public class MaterialDecoration extends Material {

	public MaterialDecoration(MaterialMapColor var1) {
		super(var1);
	}

	public boolean isBuildable() {
		return false;
	}

	public boolean blocksLight() {
		return false;
	}

	public boolean isSolid() {
		return false;
	}
}

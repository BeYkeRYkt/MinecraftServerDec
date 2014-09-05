package net.minecraft;

public class MaterialsGas extends Material {

	public MaterialsGas(MaterialMapColor var1) {
		super(var1);
		this.i();
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

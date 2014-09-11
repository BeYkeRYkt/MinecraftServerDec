package net.minecraft;

import com.google.common.base.Predicate;

public abstract class BlockFlowers extends auc {

	protected bev a;

	protected BlockFlowers() {
		super(Material.PLANT);
		this.setBlockState(this.L.b().a(this.l(), this.j() == EnumFlowerColor.b ? EnumFlowerType.b : EnumFlowerType.a));
	}

	public int a(BlockState var1) {
		return ((EnumFlowerType) var1.b(this.l())).b();
	}

	public BlockState a(int var1) {
		return this.getBlockState().a(this.l(), EnumFlowerType.a(this.j(), var1));
	}

	public abstract EnumFlowerColor j();

	public bex l() {
		if (this.a == null) {
			this.a = bev.a("type", EnumFlowerType.class, (Predicate) (new avz(this)));
		}

		return this.a;
	}

	public int c(BlockState var1) {
		return ((EnumFlowerType) var1.b(this.l())).b();
	}

	protected bed e() {
		return new bed(this, new bex[] { this.l() });
	}
}

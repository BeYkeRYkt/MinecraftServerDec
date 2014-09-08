package net.minecraft;

import com.google.common.base.Predicate;

public abstract class BlockFlowers extends auc {

	protected bev a;

	protected BlockFlowers() {
		super(Material.PLANT);
		this.setBlockState(this.L.b().a(this.l(), this.j() == awc.b ? awa.b : awa.a));
	}

	public int a(BlockState var1) {
		return ((awa) var1.b(this.l())).b();
	}

	public BlockState a(int var1) {
		return this.getBlockState().a(this.l(), awa.a(this.j(), var1));
	}

	public abstract awc j();

	public bex l() {
		if (this.a == null) {
			this.a = bev.a("type", awa.class, (Predicate) (new avz(this)));
		}

		return this.a;
	}

	public int c(BlockState var1) {
		return ((awa) var1.b(this.l())).b();
	}

	protected bed e() {
		return new bed(this, new bex[] { this.l() });
	}
}
